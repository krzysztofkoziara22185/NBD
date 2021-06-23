var mapper = function (){
		 var key = this.sex;
		 var value = { height:  parseFloat(this.height), 
						weight:  parseFloat(this.weight),
						count: 1};
		emit(key,value);
	
};

var reducer = function(key, values){
	reducedVal = {height:0, weight:0, count:0};
	
	for (var idx = 0; idx < values.length; idx++) {
       reducedVal.height+= values[idx].height;
       reducedVal.weight += values[idx].weight;
	   reducedVal.count += values[idx].count;
   }
return reducedVal;
};
	
var fin = function (key, reducedVal) {
  reducedVal.height_avg = reducedVal.height/reducedVal.count;
  reducedVal.weight_avg = reducedVal.weight/reducedVal.count;
  return reducedVal;
};

db.people.mapReduce(
   mapper,
   reducer,
   {
     out: { merge: "wyniki_1_MR" },
	 query: {},
     finalize: fin
   }
 );
 
 printjson(db.wyniki_1_MR.find().toArray())