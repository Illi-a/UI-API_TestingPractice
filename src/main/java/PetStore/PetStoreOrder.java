package PetStore;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;

import java.io.File;

public class PetStoreOrder extends PetStoreRestAssuredClient {

    private int orderID = 231233;

    public void createNewOrder() {
        File json = new File("src/test/resources/order.json");
        RestAssured.given()
                .spec(getBaseSpec())
                .body(json)
                .when()
                .post("store/order")
                .then()
                .assertThat()
                .body("id", Matchers.equalTo(orderID))
                .statusCode(200);
    }


    public void createNewOrderWithEmptyBody() {
        RestAssured.given()
                .spec(getBaseSpec())
                .when()
                .post("store/order")
                .then()
                .assertThat()
                .body("message", Matchers.equalTo("No data"))
                .statusCode(400);
    }

    public void assertThatOrderIsCreated() {
        RestAssured.given()
                .spec(getBaseSpec())
                .get("store/order/" + orderID)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public void deleteOrderById() {
        RestAssured.given()
                .spec(getBaseSpec())
                .delete("store/order/" + orderID)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public void findOrderByIncorrectID() {
        RestAssured.given()
                .spec(getBaseSpec())
                .get("store/order/" + 14317567)
                .then()
                .assertThat()
                .statusCode(404);
    }


}