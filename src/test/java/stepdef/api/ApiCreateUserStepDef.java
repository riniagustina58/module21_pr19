package stepdef.api;

import api.CreateUserApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.*;

public class ApiCreateUserStepDef {
    private CreateUserApi createUserApi = new CreateUserApi();

    @Given("insert end point to create user {string}")
    public void insertEndPointToCreateUser(String endPoint) {
      String result = createUserApi.setEndPoint(endPoint);
      assertEquals(result, endPoint);
    }

    @And("insert name {string}")
    public void insertName(String name) {
        String result = createUserApi.setValueName(name);
        assertEquals(result,name);
    }

    @And("insert job {string}")
    public void insertJob(String job) {
        String result = createUserApi.setValueJob(job);
        assertEquals(result, job);
    }

    @Then("user already created {string} {string} {string}")
    public void userAlreadyCreated(String status, String name, String job) {
        createUserApi.createUsers();
        String statusCode = Integer.toString(createUserApi.getStatusCode());
        String resultName = createUserApi.getResultName();
        String resultJob = createUserApi.getResultJob();
        assertEquals(statusCode,status);
        assertEquals(resultName,name);
        assertEquals(resultJob,job);
    }

    @Then("user not created {string}")
    public void userNotCreated(String status) {
        createUserApi.createUsers();
        String statusCode = Integer.toString(createUserApi.getStatusCode());
        assertNotEquals(statusCode, status);

    }
}
