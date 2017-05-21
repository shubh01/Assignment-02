# Assignment-02

Brief:

Web application using Spring 4 that implements Login/Signup and Profile functionalities. It will provide both a web UI and expose a RESTful API for the same.

Details:

The web application should have 3 pages:

1) Login UI Page [url: /login]

● Login page should allow for user to login with existing credentials.

● Login form should ask for email and password

● After login, user should be taken to Profile page.

2) Signup UI Page [url: /signup]

● Signup page should allow for user to register and create a new account.

● Signup form should ask for Name, Company, email and password

● After signup user should be taken to Profile page.

3) Profile UI Page [url: /profile]

● Profile page should show Name, Company, email associated with user.

● Profile page should also have a Logout option

● After logout, user should be taken to /login page

The APIs will provide the following:

1) Login API [url: /api/login POST]

● API should accept and produce JSON and it should be a RESTful endpoint

● Request should be fetched from request body json

2) Signup API [url: /api/signup POST]

● API should accept and produce JSON and it should be a RESTful endpoint

● Request should be fetched from request body json

3) Profile API [url: /api/user/{userId}/profile GET]

● API should return profile details as JSON. Profile will be fetched based on userId in the

request URL

Important Application Requirements

1. Both Web App and API should use Spring 4 MVC

2. Signup/Login should compulsorily be implemented using Spring Security.

3. App should be neatly structured using MVC constructs ­ Controllers, Service, Dao, Views

4. DB should be MYSQL. Use a table called "user" to store all user related info.

5. "password" should be encrypted before getting stored in DB (MD5Hash)

6. App should use ONLY Java based configuration. No XML configuration.

7. Use log4j for logging wherever necessary

8. App should be built using MAVEN

9. Frontend can be implemented via JSPs (Or Freemarker, Thymeleaf if you are

comfortable)

10. email should be the unique identifier to fetch user from DB
