SPRING REST EXAMPLE

## Sample Request- 
* POST - localhost:8081/sample/book
````
{
	"id":"1",
	"name":"Learning Java",
	"shortDescription":"Comprehensive Java Tutorial",
	"author":{
		"id":"101",
		"name":"Tom",
		"address":{
			"id":"1",
			"houseNumber":"9",
			"city":"London"
		}
	},
	"publication":{
		"code":"999",
		"name":"Pearl",
		"address":{
			"id":"2",
			"houseNumber":"45",
			"city":"Paris"
		}
	}
}
````
* POST - localhost:8081/sample/author
```

	{	"id":"102",
		"name":"Tom",
		"address":{
			"id":"1",
			"houseNumber":"9",
			"city":"London"
		}
	}
```
* PATCH localhost:8081/sample/book/1
```
{
	"id":"1",
	"name":"Learning Java 2",
	"shortDescription":"Comprehensive Java Tutorial",
	"author":{
		"id":"101",
		"name":"Tom",
		"address":{
			"id":"1",
			"houseNumber":"9",
			"city":"London"
		}
	},
	"publication":{
		"code":"999",
		"name":"Pearl",
		"address":{
			"id":"2",
			"houseNumber":"45",
			"city":"Paris"
		}
	}
}
```
