# JsonDiffer ![alt tag](https://travis-ci.org/felipepssouza/JsonDiffer.svg?branch=master) [![codecov](https://codecov.io/gh/felipepssouza/JsonDiffer/branch/master/graph/badge.svg)](https://codecov.io/gh/felipepssouza/JsonDiffer)

Project responsible to get diff from JSON's

## JsonDiffer Endpoints

### **GET:** `/v1/diff/131/`
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
}``

- If they are differents but different in the size of JSON too, this is the response (the insight is not proccess in this case)
```{
  "equal": false,
  "differentSize": true,
  "insight": {
    "differentKeys": [],
    "differenceValueOffset": []
  }
}``
- If they are differents and same size, this is the response, it will do a insight. Insight will say if there is any node that the key is different in the first list, in the other list is the values different, these are the possible cases: 
  - Totally different offset and size equals to zero
  ```{
      "equal": false,
      "differentSize": false,
      "insight": {
        "differenceValueOffset": [
          {
            "key": "name",
            "offset": 0,
            "size": 0
          }
        ]
      }
    }``

  - Different but equals in any part offset will return the first ocurrence of the difference and the size is the size of the value
    ```{
    "equal": false,
    "differentSize": false,
    "insight": {
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
  }``
  - If any node is equal it won't appear


