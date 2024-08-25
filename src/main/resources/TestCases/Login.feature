Feature: Login Feature

  @tc01 @login @regression
  Scenario Outline: validate user is able to login with credentials
    When user enters valid credentials "<Test Case ID>"
    Then products page should be displayed
    Examples:
      | Test Case ID |
      | TC001        |
      | TC002        |
      | TC003        |
      | TC004        |
      | TC005        |
      | TC006        |
      | TC007        |
      | TC008        |
      | TC009        |
      | TC010        |
      | TC011        |
      | TC012        |

  ### without TestData ###
  @way2tc01 @login @regression
  Scenario Outline: validate user is able to login with credentials
    When user enters valid credentials "<User Name>" and "<Password>"
    Then products page should be displayed
    Examples:
      | User Name               | Password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |
      | invalid_user            | secret_sauce |
      | standard_user           | invalid_pwd  |
      | invalid_user            | invalid_pwd  |
      |                         | secret_sauce |
      | problem_user            |              |
      |                         |              |


