printjson(db.people.aggregate(
[{ $match: { weight : {$ne : null }}},
{$group: {
	_id: "$sex",
	avg_weight: {$avg: {"$toDecimal":"$weight"}},
	avg_height:{$avg: {"$toDecimal":"$height"}},
}}]
).toArray())

