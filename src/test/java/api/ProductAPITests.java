package api;

import io.qameta.allure.Description;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProductAPITests {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://automationexercise.com";
        RestAssured.filters(new AllureRestAssured());
    }

    @Test(priority = 1)
    @Description("API 1: Get All Products List")
    public void testGetAllProductsList() {
        Response response = given()
                .when()
                .get("/api/productsList")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("products"));
    }

    @Test(priority = 2)
    @Description("API 2: POST To All Products List")
    public void testPostToAllProductsList() {
        Response response = given()
                .when()
                .post("/api/productsList")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("405"));
    }

    @Test(priority = 3)
    @Description("API 3: Get All Brands List")
    public void testGetAllBrandsList() {
        Response response = given()
                .when()
                .get("/api/brandsList")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("brands"));
    }

    @Test(priority = 4)
    @Description("API 4: PUT To All Brands List")
    public void testPutToAllBrandsList() {
        Response response = given()
                .when()
                .put("/api/brandsList")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("405"));
    }

    @Test(priority = 5)
    @Description("API 5: POST To Search Product")
    public void testSearchProduct() {
        Response response = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("search_product", "top")
                .when()
                .post("/api/searchProduct")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("products"));
    }

    @Test(priority = 6)
    @Description("API 6: POST To Search Product without search_product parameter")
    public void testSearchProductWithoutParameter() {
        Response response = given()
                .contentType("application/x-www-form-urlencoded")
                .when()
                .post("/api/searchProduct")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("400"));
    }

    @Test(priority = 7)
    @Description("API 7: POST To Verify Login with valid details")
    public void testVerifyLoginWithValidDetails() {
        Response response = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("email", "test@test.com")
                .formParam("password", "test123")
                .when()
                .post("/api/verifyLogin")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 8)
    @Description("API 8: POST To Verify Login without email parameter")
    public void testVerifyLoginWithoutEmail() {
        Response response = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("password", "test123")
                .when()
                .post("/api/verifyLogin")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("400"));
    }

    @Test(priority = 9)
    @Description("API 9: DELETE To Verify Login")
    public void testDeleteVerifyLogin() {
        Response response = given()
                .when()
                .delete("/api/verifyLogin")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("405"));
    }

    @Test(priority = 10)
    @Description("API 10: POST To Create/Register User Account")
    public void testCreateUserAccount() {
        String timestamp = String.valueOf(System.currentTimeMillis());
        Response response = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("name", "Giorgi")
                .formParam("email", "giorgi" + timestamp + "@test.com")
                .formParam("password", "Test123")
                .formParam("title", "Mr")
                .formParam("birth_date", "1")
                .formParam("birth_month", "1")
                .formParam("birth_year", "1990")
                .formParam("firstname", "Giorgi")
                .formParam("lastname", "Malkhaziani")
                .formParam("company", "TestCompany")
                .formParam("address1", "123 Street")
                .formParam("address2", "Apt 4")
                .formParam("country", "United States")
                .formParam("zipcode", "12345")
                .formParam("state", "Georgia")
                .formParam("city", "Tbilisi")
                .formParam("mobile_number", "555-1234")
                .when()
                .post("/api/createAccount")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200);
    }
}
