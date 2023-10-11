1.Developed an application on Mysql Db and created Db name as inmar
2.Run the metadata.txt scripts in Db. you can find the file in root directory of the project.

deploy the application

1.hit the URl   http://localhost:8080/register  for registration and provide the below json body 

##username and password can be anything

{
    "username" : "ramesh",
    "password":"abc"
}

2.Authenticate with below credentials, http://localhost:8080/authenticate
{
    "username" : "ramesh",
    "password":"abc"
}

You will get the response below ( Example token)
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyYW1lc2giLCJleHAiOjE2OTcwMjU3NzcsImlhdCI6MTY5NzAwNzc3N30.ZamQmh0ZXaeTcVQGGRpeZm9rv6SYSdtJWw1k1E21Lel94Nah9zv0Kxqzj5UzVsNjZn5eGCJVcoAU8nv_x-FExw"
}

3.Access other services by providing above token as below
URL :  http://localhost:8080/api/v1/location/Perimeter/department
Header as
Key:Authorization
value:Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyYW1lc2giLCJleHAiOjE2OTcwMjU3NzcsImlhdCI6MTY5NzAwNzc3N30.ZamQmh0ZXaeTcVQGGRpeZm9rv6SYSdtJWw1k1E21Lel94Nah9zv0Kxqzj5UzVsNjZn5eGCJVcoAU8nv_x-FExw



value=Bearer+SPACE+Token
