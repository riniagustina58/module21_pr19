package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;


public class CreateUserApi extends UserApi {


   private String valueName;
   private String valueJob;
   private Integer statusCode;
   private String resultName;
   private String resultJob;
   private String endPoint;

   public String setValueName (String name) {
       valueName = name;
       return valueName;
   }

    public String setValueJob(String job) {
       valueJob = job;
        return valueJob;
    }

    public Integer getStatusCode() {
       return statusCode;
    }

    public String getResultName () {
       return resultName;
    }

    public String getResultJob () {
       return resultJob;
    }

    public String setEndPoint(String endPoint) {
       this.endPoint = endPoint;
       return this.endPoint;
    }

    public void createUsers() {

        JSONObject bodyObj = new JSONObject();
        bodyObj.put("name", valueName);
        bodyObj.put("job", valueJob);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .header("x-api-key", apiKey)
                .header("Accept", "application/json")
                .body(bodyObj.toString())
                .when()
                .post(endPoint);

        statusCode = response.getStatusCode();
        resultName = response.jsonPath().get("name");
        resultJob = response.jsonPath().get("job");
    }

}

