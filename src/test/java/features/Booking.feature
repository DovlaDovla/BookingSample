Feature: Booking feature


  Scenario: Book a stay

       Given I navigate to Booking
       When  I add location
       And   I add check in and check out dates
       And   I add ccupancy information
       And   I  click search
       Then I verify search criteria
       And  I see availability
      And   I verify availability information


