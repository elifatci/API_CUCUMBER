Feature:US JsonPlaceHolderApi Testi

  @Api
  Scenario: TC JSonPlaceHolderGet Testi

    Given kullanici url adresine gider
    And kullanici GET request gonderip gelen responsu kaydeder
    Then kullanici status kodunun 200 oldugunu test eder
    Then kullanici content type degerinin "application/json; charset=utf-8" oldugunu test eder
    Then kullanici donen cevaptaki degerleri test eder

