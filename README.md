# hc-test-1 (REST API)
 My HomeCredit Indonesia 1st Technical Test :D
 
 ```
 SCENARIO:
Our Frontend developers want to refactor their homepage using modular approach, they need us as a backend developers to create a new service they need,
their homepage is similar like other Ecommerce Mobile Apps, which there is Promo Caroussel, Category Menu, Flash Sale Section, Transaction History and News Section.

But from our business guys they want to create 3 Groups of users which every group contains many users that have different order of section. For Example:
UserA : Promo, Category, FlashSale, History and News
UserB : Promo, News, FlashSale, Category and News
UserC : Promo, FlashSale, Category, News and History

And they would like to have a privilege to configure this order anytime they want without disturbing our developers.

So for that requirements our frontends want us to create 1 API that returns JSON response similar like this:

Method : GET
Parameter : 
	- UserID
Responses:
{
	"modules":[
		{
			"moduleName":"PromoCard",
			"moduleOrder":1
		},
		{
			"moduleName":"CategoryCard",
			"moduleOrder":2
		},
		{
			"moduleName":"FlashSaleCard",
			"moduleOrder":3
		},
		{
			"moduleName":"HistoryCard",
			"moduleOrder":4
		},
		{
			"moduleName":"NewsCard",
			"moduleOrder":5
		}
	]
}

TASKS:	

Your task is :
1. Provide Web Service that returns JSON that frontends need.
2. Use MySQL DB or you can use memory database H2 if you want to implement database, or any free SQL DB.
3. Will be good if your code is testable.
4. Upload source and SQL script on your GitHub.
5. Use Java Spring Boot Framework
6. Use Maven for Library management
 ```
 
 Stack: Spring Boot - JPA - Hibernate - Lombok - MySQL - SwaggerUI

================================
# How To Test
Please access [http://(your-domain):(your-port)/hctest/swagger-ui.html](http://(your-domain)/hctest/swagger-ui.html)
