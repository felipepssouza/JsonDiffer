# JsonDiffer [![travis-ci](https://travis-ci.org/felipepssouza/JsonDiffer.svg?branch=master)](https://travis-ci.org/felipepssouza/JsonDiffer) [![codecov](https://codecov.io/gh/felipepssouza/JsonDiffer/branch/master/graph/badge.svg)](https://codecov.io/gh/felipepssouza/JsonDiffer)

Project responsible to get diff from JSON's

## JsonDiffer Endpoints

### **GET:** `/v1/diff/:id/`
Returns the result of the difference of JSON from left and right. Example: 

- If both sides are equals this is the response
```json

{
  "equal": true,
  "differentSize": false,
  "insight": {
    "differentKeys": [],
    "differenceValueOffset": []
  }
}
```

- If they are differents but different in the size of JSON too, this is the response (the insight is not proccess in this case)
```json

{
  "equal": false,
  "differentSize": true,
  "insight": {
    "differentKeys": [],
    "differenceValueOffset": []
  }
}
```

- If they are differents and same size, this is the response, it will do a insight. Insight will say if there is any node that the key is different in the first list, in the other list the values are different, these are the possible cases: 
  - Totally different offset and size equals to zero
```json

{
    "equal": false,
    "differentSize": false,
    "insight": {
      "differentKeys": [
              "city"
        ],
      "differenceValueOffset": [
        {
          "key": "name",
          "offset": 0,
          "size": 0
        }
      ]
    }
  }
  ```

  - Different but equals in any part offset will return the first ocurrence of the difference and the size is the size of the value
```json
  {
  "equal": false,
  "differentSize": false,
  "insight": {
    "differentKeys": [],
    "differenceValueOffset": [
      {
        "key": "name",
        "offset": 0,
        "size": 0
      },
      {
        "key": "age",
        "offset": 0,
        "size": 0
      },
      {
        "key": "city",
        "offset": 4,
        "size": 17
      }
    ]
  }
}
```
  - If any node is equal it won't appear

### **POST:** `/v1/diff/:id/left`
Receives the id and the position left, and in the body receives a JSON in base64.
Returns Ok! (200)

This is an example of cUrl to call it: 
```
curl -X POST -d 'ew0KICAibmFtZSI6ICJUYW1pcmVzIiwNCiAgImNpdHkiOiAiU2FvIFBhdWxvIg0KfQ==' "http://localhost:8080/v1/diff/133/left"
```

### **POST:** `/v1/diff/:id/right`
Receives the id and the position right, and in the body receives a JSON in base64.
Returns Ok! (200)

This is an example of cUrl to call it: 
```
curl -X POST -d 'ew0KICAibmFtZSI6ICJUYW1pcmVzIiwNCiAgImNpdHkiOiAiU2FvIFBhdWxvIg0KfQ==' "http://localhost:8080/v1/diff/133/right"
```

## JsonDiffer - How to use:

- To configure the database enter in this file: 
```
$ROOT/persistence/br/com/felipe/config/DataSourceConfigJPA.java
```
Change the Database URL, user and password.

- Execute these scripts on the path (Or leave it update by the ddl mode, and create the database meld): 
```
$ROOT/scripts/*.sql
```

- To run the project, run this commmand, it will be available on the port 8080 (http://localhost:8080/v1): 
```
$ROOT/gradlew bootRun
```

- To run the tests
```
$ROOT/gradlew test
```

## JsonDiffer - How it is organized:

Following the Clean Architeture of Uncle Bob. This is the structure: 
```
-ROOT
  - controller (All the controllers are here)
  - config (The bootstrap of the system is here, and any possible system configuration, like external confs)
  - persistence (Anything about persistence and model's are located here, the others cannot access the model, it transfer VO's)
  - usecase (Here are all the business rules)
  - scripts (There are some scripts of database to init it)
```




