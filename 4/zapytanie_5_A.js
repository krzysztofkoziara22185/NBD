printjson(db.people.aggregate([
{$unwind: "$credit"},
{$match:{
	"sex":"Female",
	"nationality":"Poland"
}},
{$group: {
	_id: "$credit.currency",
	total_balance: {$sum: {"$toDecimal":"$credit.balance"}},
	avg_balance: {$avg: {"$toDecimal":"$credit.balance"}}
}}
]
).toArray())