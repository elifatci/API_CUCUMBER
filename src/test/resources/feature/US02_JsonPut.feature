
@JsonPut
  Feature:Json Put Htttp method

    Scenario:Json Put Http method

      Given kullanici url adresine gider.
      And reqData olusturulup gonderilir donen cevap kaydedilir
      Then response dogrulanir