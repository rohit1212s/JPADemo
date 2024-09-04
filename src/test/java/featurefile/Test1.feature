@clientoutput
Feature: Test1


  Background: Testing
    * def map = { username: ‘root’, password: ‘root1234’, url: ‘jdbc:mysql://localhost:3306/Rohit’, driverClassName: ‘com.mysql.cj.jdbc.Driver’ }
    * def DbUtils = Java.type('org.example.jpademo.util.DbUtils')
    * def db = new DbUtils(map)
    Given url 'http://localhost:8080'


  @parallel=false
  Scenario: Testing valid GET endpoint
    Given path  '/Rohit/SampleData'
    When method GET
    Then status 200
    Then print 'Response -->\n', response

  Scenario: Get all products
    Given path  '/Product/all'
    When method GET
    Then status 200
    Then print 'Response -->\n', response
#    And match $ == {"productId":0,"title":"Api testing",description:"This is testing api","price":1300.0,"live":true }
#    And match $.id == "1"

@test1
  Scenario: Get product by id
    And path  '/Product/3'
    When method GET
    Then status 200
    Then print 'Response -->\n', response
    * def product = db.readRow("SELECT * FROM jpa_products where product_Id=3")
    Then print 'product -->\n', product
    Then match response.price == 1400.0
    Then match response.title == 'Post Api testing'
    Then match response.description == 'This is testing post api'
    And match $ contains {productId:3}
    * def product_id = response.productId
    And print 'product_id -->\n',product_id



  Scenario: Create a new product
    Given path '/Product/create'
    And request
    """
    {
    "title": "Testing21",
    "description": "testing9",
    "price": 1900.0,
    "live": true
    }
    """
    When method POST
    Then status 200
    Then print 'Response -->\n', response
#    And match $ contains {productId:"#notnull"}

  Scenario: Get product by id2
    * call read('@test1')
    And path  '/Product/3'
    When method GET
    Then status 200
    Then print "This is second response"
    Then print 'Response -->\n', response
    Then match response.productId == product_id
#    * def calcAmtActual = new java.math.BigDecimal(calculatedAmount)