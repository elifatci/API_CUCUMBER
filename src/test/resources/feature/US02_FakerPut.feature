@faker
Feature: Faker url Put methodu

  Scenario: Faker url Put methodu


    Given faker url'e gidilir ve "v1" "Activities" "1" pathparams ile endpoint olusturulur
    And expected data olusturulur
    Then donen response body assert ile dogrulanir