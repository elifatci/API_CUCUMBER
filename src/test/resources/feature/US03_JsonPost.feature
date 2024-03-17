
  @post
  Feature:Json HTTP POST method

    Scenario Outline: Hit any get http rest api and validate it

      Given "<baseUrl>" and "<pathParams>" available for test
      When request for "<title>" "<body>" "<userId>"
      Then verify the response "<statusCode>" and "<contentType>" are valid
      Then verify the response body is "<title>" "<body>" "<id>" are valid

      Examples:
        |              baseUrl                 | pathParams |   title  |       body                  | userId | statusCode |         contentType             | id |
        |https://jsonplaceholder.typicode.com/ |  posts     | Software |  API is very nice to learn  | 12     |   201      |application/json; charset=utf-8  | 101|

