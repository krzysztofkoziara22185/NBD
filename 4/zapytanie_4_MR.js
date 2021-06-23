var mapper = function (){
		 var key = this.nationality;
		 var value = {BMI:(parseFloat(this.weight))/(((parseFloat(this.height))/100)**2), 
					count: 1};
		emit(key,value);
	
};

var reducer = function(key, values){
	reducedVal = {BMI:0, min_BMI:100, max_BMI:0, count:0};
	
	for (var idx = 0; idx < values.length; idx++) {
       reducedVal.BMI+= values[idx].BMI;
	   if(values[idx].BMI<reducedVal.min_BMI){
			reducedVal.min_BMI = values[idx].BMI};
	   if(values[idx].BMI>reducedVal.max_BMI){
			reducedVal.max_BMI = values[idx].BMI};
	   reducedVal.count += values[idx].count;
   }
return reducedVal;
};
	
var fin = function (key, reducedVal) {
  reducedVal.avg_BMI = reducedVal.BMI/reducedVal.count;
  return reducedVal;
};

db.people.mapReduce(
   mapper,
   reducer,
   {
     out: { merge: "wyniki_4_MR" },
	 query: {},
     finalize: fin
   }
 );
 
printjson(db.wyniki_4_MR.find().toArray())
