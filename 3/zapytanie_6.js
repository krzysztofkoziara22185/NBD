printjson(db.people.insert({
	"sex" : "Male",
	"first_name" : "Krzysztof",
	"last_name" : "Koziara",
	"job" : "Data Engineer",
	"email" : "elo@siemano.com",
	"location" : {
		"city" : "Warszawa",
		"address" : {
			"streetname" : "Kolska",
			"streetnumber" : "2/4"
		}
	},
	"description" : "no no no",
	"height" : "180",
	"weight" : "70",
	"birth_date" : "1996-09-27T05:44:11Z",
	"nationality" : "Poland",
	"credit" : [
		{
			"type" : "laser",
			"number" : "5586087121891962",
			"currency" : "IDR",
			"balance" : "5512.36"
		},
		{
			"type" : "bankcard",
			"number" : "5010120787942724",
			"currency" : "CNY",
			"balance" : "5190.65"
		}
	]
}))
