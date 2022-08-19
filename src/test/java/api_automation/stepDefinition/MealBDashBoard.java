package api_automation.stepDefinition;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class MealBDashBoard {
    Response resp ;

    String url="http://dev-mb.yoll.io/api/dashboard";
    @Given("User submit get request to MealB Dashboard API")
    public void user_submit_get_request_to_MealB_Dashboard_API() {
        Response resp=given()

                .header("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjExMzcyIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6Im1pbmhsZSIsIkFzcE5ldC5JZGVudGl0eS5TZWN1cml0eVN0YW1wIjoiZjg0NGExMzQtZjQ5YS00NzA2LTg5YmMtMWY3ZjlhZjJjZTk4IiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9yb2xlIjoiU2VsZkVtcGxveWVkIiwiaHR0cDovL3d3dy5hc3BuZXRib2lsZXJwbGF0ZS5jb20vaWRlbnRpdHkvY2xhaW1zL3RlbmFudElkIjoiMSIsInN1YiI6IjExMzcyIiwianRpIjoiZWY4YWMwODgtN2Y1NS00MDM2LWE2MDItMmZiNmEwNTBjNjVhIiwiaWF0IjoxNjUyOTEyMTcxLCJuYmYiOjE2NTI5MTIxNzEsImV4cCI6MTY4NDQ0ODE3MSwiaXNzIjoiTWVhbEIiLCJhdWQiOiJNZWFsQiJ9.q0ykPp7YVnzTPWC4x3HioomRkzEkdSkXvM49ic86mlY")
                .contentType(ContentType.JSON)
                .when()
                .get(url);
        resp.prettyPrint();
        double otherExpense= JsonPath.read(resp.asString(),"$.result.otherExpenses");
        System.out.println(otherExpense);


    }

    @Then("User retrieve the value of otherExpenses, travelExpenses, giftExpenses")
    public void user_retrieve_the_value_of_otherExpenses_travelExpenses_giftExpenses() {
        Response resp=given()

                .header("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjExMzcyIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6Im1pbmhsZSIsIkFzcE5ldC5JZGVudGl0eS5TZWN1cml0eVN0YW1wIjoiZjg0NGExMzQtZjQ5YS00NzA2LTg5YmMtMWY3ZjlhZjJjZTk4IiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9yb2xlIjoiU2VsZkVtcGxveWVkIiwiaHR0cDovL3d3dy5hc3BuZXRib2lsZXJwbGF0ZS5jb20vaWRlbnRpdHkvY2xhaW1zL3RlbmFudElkIjoiMSIsInN1YiI6IjExMzcyIiwianRpIjoiZWY4YWMwODgtN2Y1NS00MDM2LWE2MDItMmZiNmEwNTBjNjVhIiwiaWF0IjoxNjUyOTEyMTcxLCJuYmYiOjE2NTI5MTIxNzEsImV4cCI6MTY4NDQ0ODE3MSwiaXNzIjoiTWVhbEIiLCJhdWQiOiJNZWFsQiJ9.q0ykPp7YVnzTPWC4x3HioomRkzEkdSkXvM49ic86mlY")
              //  .contentType(ContentType.JSON)
                .when()
                .get(url);
        resp.prettyPrint();
        double otherExpense= JsonPath.read(resp.asString(),"$.result.otherExpenses");
        double travelExpense=JsonPath.read(resp.asString(),"$.result.travelExpenses");
        double giftExpense =JsonPath.read(resp.asString(),"$.result.giftExpenses");





    }

}
