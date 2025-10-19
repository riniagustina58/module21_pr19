package stepdef.api;

import api.GetListUserApi;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ApiGetListUserStepDef {
    private GetListUserApi getListUserApi = new GetListUserApi();

    @Given("insert end point to get list users {string}")
    public void insertEndPointToGetListUsers(String endPoint) {
        String result = getListUserApi.setEndPoint(endPoint);
        Assert.assertEquals(result,endPoint);
    }

    @And("user insert page {string}")
    public void userInsertPage(String page) {
       String result = getListUserApi.setPage(page);
       Assert.assertEquals(result, page);
    }

    @And("insert per page {string}")
    public void insertPerPage(String perPage) {
      String result = getListUserApi.setPerPage(perPage);
      Assert.assertEquals(result, perPage);
    }

    @Then("user received list data user {string} {string} {string}")
    public void userReceivedListDataUser(String status, String page, String perPage) {
        getListUserApi.testGetListUsers();
        String statusCode = getListUserApi.getStatusCode();
        String resultPage = getListUserApi.getResultPage();
        String resultPerPage = getListUserApi.getResultPerPage();
        assertEquals(statusCode,status);
        assertEquals(resultPage,page);
        assertEquals(resultPerPage,perPage);

    }

    @Then("user received no data user {string}")
    public void userReceivedNoDataUser(String status) {
        getListUserApi.testGetListUsers();
        String statusCode = getListUserApi.getStatusCode();
        assertNotEquals(statusCode,status);
    }
}
