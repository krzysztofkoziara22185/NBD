printjson(db.people.aggregate([
{$group: {
	_id: "$nationality",
	avg_BMI:{$avg: {$divide: [{"$toDecimal":"$weight"},{$pow:[{$divide:[{"$toDecimal":"$height"},100]},2]}]}},
	min_BMI:{$min: {$divide: [{"$toDecimal":"$weight"},{$pow:[{$divide:[{"$toDecimal":"$height"},100]},2]}]}},
	max_BMI:{$max: {$divide: [{"$toDecimal":"$weight"},{$pow:[{$divide:[{"$toDecimal":"$height"},100]},2]}]}}
	}
}]
).toArray())

