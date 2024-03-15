Feature:US JsonPlaceHolderApi Testi

  @Api
  Scenario: TC JSonPlaceHolderGet Testi

    Given kullanici "JsonUrl" base Url adresine gider
    Then kullanici "posts/44" parametrelerini kullanir
    And kullanici GET request gonderip gelen responsu kaydeder
    Then kullanici status kodunun 200 oldugunu test eder
    Then kullanici content type degerinin "application/json; charset=utf-8" oldugunu test eder
    Then kullanici donen cevaptaki userid degerinin 5 oldugunu test eder
    Then kullanici donen cevaptaki title degerinin "optio dolor molestias sit" oldugunu test eder
