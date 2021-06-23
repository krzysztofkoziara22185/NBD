var mapper = function (){
		 var key = this.job;
		 var value = {};
		emit(key,value);
	
};

var reducer = function(key, values){
	reducedVal = {};
	
	for (var idx = 0; idx < values.length; idx++) {
       reducedVal = {};
   }
return reducedVal;
};


db.people.mapReduce(
   mapper,
   reducer,
   {
     out: { merge: "wyniki_3_MR" },
	 query: {},
   }
 );
printjson(db.wyniki_3_MR.find({},{"_id":1}).toArray())