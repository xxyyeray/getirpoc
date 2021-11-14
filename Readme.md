## Getir Case

### Prerequisites

* Docker or podman or rancher etc .

### Installation

Getir Case project is available on Linux, macOS and Windows platforms.

* networking so containers can see each other

```shell
docker network create mybridge
```  

* run mongo db container

```shell
docker run -dit  --net mybridge  --hostname mongo  mongo
``` 

run our app

```shell
docker run -dit --net mybridge -p 8080:8080   --hostname spring sameterayerdemdocker/readgood
```

call api

```shell
postman collection under to root folder  (readingisgood.json)
```

Create account

```shell
first create  a account with Will persist new customers method 
```

Tokens

```shell
after that get a bearer access token from GetToken
```

Access services

```shell
with this access token u can access every service
```

Tests

```shell
I did the test before spring security. When I run it now, the tests may fail, so I'm adding a code coverage image (code_coverage.png).
```

