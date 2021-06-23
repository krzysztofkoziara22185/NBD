var mapper = function (){
	for (var idx = 0; idx < this.credit.length; idx++) {
		 var key = this.credit[idx].currency;
		 var value = parseFloat(this.credit[idx].balance);
						
		emit(key,value);
	}
};

var reducer = function(key, values){
	reducedVal = 0;
	
	for (var idx = 0; idx < values.length; idx++) {
       reducedVal+= values[idx];
   }
return reducedVal;
};

printjson(db.wyniki_2_MR.find().toArray())

db.people.mapReduce(
   mapper,
   reducer,
   {
     out: { merge: "wyniki_2_MR" },
	 query: {}
   }
 );