
Feature: SQLExecute

  Background: ExecuteSQlExecute Soap Request

    * def map = {username:'root', password:'root1234', url:'jdbc:mysql://localhost:3306/Rohit', driverClassName:'com.mysql.cj.jdbc.Driver'}
    * def DbUtils = Java.type('org.example.jpademo.util.DbUtils')
    * print DbUtils
    * print map
    * def db = new DbUtils(map)


  Scenario: executeSQl
    * def vehicles = db.readRows("SELECT * FROM jpa_products")
    Then print vehicles

