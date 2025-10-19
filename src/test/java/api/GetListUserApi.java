package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;

public class GetListUserApi extends UserApi {
    private String endPoint;
    private Integer page;
    private Integer perPage;
    private String statusCode;
    private String resultPage;
    private String resultPerPage;

    public String setEndPoint(String endPoint) {
        this.endPoint = endPoint;
        return this.endPoint;
    }

    public String setPage (String page) {
        this.page = Integer.valueOf(page);
        return String.valueOf(this.page);
    }

    public  String setPerPage (String perPage){
        this.perPage = Integer.valueOf(perPage);
        return String.valueOf(this.perPage);
    }

    public String getStatusCode (){
        return statusCode;
    }

    public String getResultPage () {
        return resultPage;
    }

    public String getResultPerPage () {
        return resultPerPage;
    }

    public void testGetListUsers() {
        JSONObject bodyObj = new JSONObject();

        bodyObj.put("page", page);
        bodyObj.put("per_page",perPage );

        Response response = RestAssured
                .given().when()
                .header("Content-Type", "application/json; charset=UTF-8")
                .header("x-api-key",apiKey)
                .body(bodyObj.toString())
                .get(endPoint);

        statusCode = String.valueOf(response.getStatusCode());
        resultPage = Integer.toString(response.jsonPath().get("page"));
        resultPerPage = Integer.toString(response.jsonPath().get("per_page"));
    }


}
