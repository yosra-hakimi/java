# Spring - Rest - Hibernate : Vintud


Implementation of Spring Boot, REST architecture and hibernate within the Vintud project !!
## Installation

Step1. Clone the project from the link below: [link](https://gitlab.com/nbensaber/NidhalBenSaber/) <br/>
Step2. Copy the project "Vintud-Spring-boot-simple" from the folder S7/J3 to your "eclipse-workspace" <br/>
Step3. Open Eclipse go the menu File -> Import -> Maven -> Existing Maven Project load the project and Click "Finish" <br/>
Step4. On Eclipse Right click on the project -> Run As -> SpringBoot App <br/>
Step5. in the file src/main/resources/application.properties change database settings to yours: <br/>

```bash
# DataSource settings:
spring.datasource.url = jdbc:postgresql://localhost:5432/yourdatabasename
spring.datasource.username = yourusername
spring.datasource.password = yourpassword
```
Step5. Open pgAdmin create a new database with the name that you passed into applications.properties file "vintud". <br/>
Step6. You don't need to run any SQL script to create database tables just Run the project as Spring boot app and all tables will be created automatically based on your Entities Classes <br/>
Step7  Select DATABASE "vintud" -> Right Click -> Query Tool -> Open File -> scriptInsertVintud.sql -> EXECUTE. DONE your DATABASE is Already to use ! <br/>
## Usage

use postman: <br/>
&nbsp;&nbsp;&nbsp;&nbsp; method GET 	url  http://localhost:8080/announcement/1 &nbsp;&nbsp;&nbsp;&nbsp;  (announcementId) <br/>
&nbsp;&nbsp;&nbsp;&nbsp; method GET 	url  http://localhost:8080/announcements	<br/>
&nbsp;&nbsp;&nbsp;&nbsp; method GET		url  http://localhost:8080/announcements/1 &nbsp;&nbsp;&nbsp;&nbsp; (userId) <br/>
&nbsp;&nbsp;&nbsp;&nbsp; method POST 	url  http://localhost:8080/announcement/add <br/>
&nbsp;&nbsp;&nbsp;&nbsp; Body -> Raw  and change contentType to JSON past the code below into your request Body <br/>
```json
{
    "title": "t-shirtblue",
    "description": "TEST ADD ",
    "price": 24.98,
    "photo": null,
    "datePub": "2019-01-25 8:32:12",
    "status": true,
    "nbrViews": 2,
    "location": "Paris 9iÃ¨me",
    "category": {
        "id": 1,
        "categoryName": "T-SHIRT",
        "categoryDescription": "VÃªtement lÃ©ger souvent mis lÃ©tÃ©."
    },
    "user": {
        "id": 1,
        "mail": "johnyPirate@Cara.com",
        "firstName": "Pirate",
        "name": "CaraÃ¯bes",
        "role": {
            "roleName": "CLIENT"
        },
        "pseudo": "Johny",
        "password": "unmotdepassedepirate",
        "phoneNumber": "1563214560",
        "address": "Entre latlantic et le pacific."
    }
} 
```
&nbsp;&nbsp;&nbsp;&nbsp; method PUT 	url  http://localhost:8080/announcement/update/1 &nbsp;&nbsp;&nbsp;&nbsp;  (announcementId) <br/>
```json
{
    "title": "t-shirt lacuste bon Ã©tat",
    "description": "TEST UPDATE ",
    "price": 24.98,
    "photo": null,
    "datePub": "2019-01-25 8:32:12",
    "status": true,
    "nbrViews": 2,
    "location": "bizerte",
    "category": {
        "id": 1,
        "categoryName": "T-SHIRT",
        "categoryDescription": "VÃªtement lÃ©ger souvent mis lÃ©tÃ©."
    },
    "user": {
        "id": 1,
        "mail": "johnyPirate@Cara.com",
        "firstName": "Pirate",
        "name": "CaraÃ¯bes",
        "role": {
            "roleName": "CLIENT"
        },
        "pseudo": "Johny",
        "password": "unmotdepassedepirate", 
        "phoneNumber": "1563214560",
        "address": "Entre latlantic et le pacific."
    }
} 
```
&nbsp;&nbsp;&nbsp;&nbsp;  method DELETE 	url http://localhost:8080/announcement/delete/1    (delete by announcementId) <br/>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;  method GET 	url http://localhost:8080/announcements/title/t-shirtblue    (Search by title pattern contains the word test) <br/>
&nbsp;&nbsp;&nbsp;&nbsp;  method GET 	url http://localhost:8080/announcements/price/24.98     (Search by price) <br/>
&nbsp;&nbsp;&nbsp;&nbsp;  method GET 	url http://localhost:8080/announcements/category/t-shirt     (Search by categoryName) <br/>
&nbsp;&nbsp;&nbsp;&nbsp;  method GET 	url http://localhost:8080/announcements/ordredyprice <br/>
&nbsp;&nbsp;&nbsp;&nbsp;  method GET 	url http://localhost:8080/announcements/location <br/>
&nbsp;&nbsp;&nbsp;&nbsp;  method GET 	url http://localhost:8080/announcements/count  <br/>       
&nbsp;&nbsp;&nbsp;&nbsp;  method GET 	url http://localhost:8080/user/mail/johnyPirate@Cara.com   (Search by email "johnyPirate@Cara.com")<br/>   
&nbsp;&nbsp;&nbsp;&nbsp;  method GET 	url http://localhost:8080/user/phone/1563214560  (Search by phone number 1563214560)<br/>     
&nbsp;&nbsp;&nbsp;&nbsp;  method POST url http://localhost:8080/signup <br/>
&nbsp;&nbsp;&nbsp;&nbsp; Body -> Raw  and change contentType to JSON past the code below into your request Body <br/>
```json
{
    "mail": "test@gmail.com",
    "firstName": "test",
    "name": "test",
    "role": {
    	"id": 1,     
        "roleName": "CLIENT"
    },
    "pseudo": "test",
    "password": "123456",
    "phoneNumber": "12345678",
    "address": "test"
}
```
&nbsp;&nbsp;&nbsp;&nbsp; Test many times the same method to check if email is valid also if phone number is valid with pattern matches (+21620089931) or (20089931) and check if phone &nbsp;&nbsp;&nbsp;&nbsp; number or email is used before. <br/>
&nbsp;&nbsp;&nbsp;&nbsp; method POST url http://localhost:8080/signin <br/>
```json
{
    "mail": "test@gmail.com",
    "password": "123456",
}
```

## Test
You don't need to add any depandencies regarding test Spring Boot have his own test enviroement including Junit <br/>
Go to the package src/test/java  ... UserTest.java Right click on the class Run As JunitTest <br/>
Go to the package src/test/java  ... AnnouncementTest.java Right click on the class Run As JunitTest <br/>
## License
[TalanAcademy](https://talan-academy.com)