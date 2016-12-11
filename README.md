# JsonDiffer ![alt tag](https://travis-ci.org/felipepssouza/JsonDiffer.svg?branch=master) [![codecov](https://codecov.io/gh/felipepssouza/JsonDiffer/branch/master/graph/badge.svg)](https://codecov.io/gh/felipepssouza/JsonDiffer)

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
curl -X POST -d 'ew0KICAibmFtZSI6ICJUYW1pcmVzIiwNCiAgImNpdHkiOiAiU2FvIFBhdWxvIg0KfQ==' "http://localhost:8080/v1/diff/133"
```

