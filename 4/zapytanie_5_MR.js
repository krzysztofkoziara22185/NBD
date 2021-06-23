var mapper = function (){
	if(this.sex == "Female"&& this.nationality =="Poland"){
	for (var idx = 0; idx < this.credit.length; idx++) {
		 var key = this.credit[idx].currency;
		 var value = {balance: parseFloat(this.credit[idx].balance),
		 count: 1};
					
		emit(key,value);
		}
	}
};

var reducer = function(key, values){
	reducedVal = {balance_total:0, count:0}
	
	for (var idx = 0; idx < values.length; idx++) {
       reducedVal.balance_total += values[idx].balance;
	   reducedVal.count += values[idx].count;
   }
return reducedVal;
};

var fin = function (key, reducedVal) {
  reducedVal.balance_avg = reducedVal.balance_total/reducedVal.count;
  return reducedVal;
};

db.people.mapReduce(
   mapper,
   reducer,
   {
     out: { merge: "wyniki_5_MR" },
	 query: {},
	 finalize: fin
   }
 );
 printjson(db.wyniki_5_MR.find().toArray())
