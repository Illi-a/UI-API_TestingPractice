package PetStore;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreOrder extends RestAssuredClient {

    private int orderID = 231233;

    public void createNewOrder() {
        File json = new File("src/test/resources/order.json");
        given()
                .spec(getBaseSpec())
                .body(json)
                .when()
                .post("store/order")
                .then()
                .assertThat()
                .body("id", equalTo(orderID))
                .statusCode(200);
    }

    public void createNewOrderWithEmptyBody() {
        given()
                .spec(getBaseSpec())
                .when()
                .post("store/order")
                .then()
                .assertThat()
                .body("message", equalTo("No data"))
                .statusCode(400);
    }

    public void assertThatOrderIsCreated() {
        given()
                .spec(getBaseSpec())
                .get("store/order/" + orderID)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public void deleteOrderById(){
        given()
                .spec(getBaseSpec())
                .delete("store/order/" + orderID)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public void findOrderByIncorrectID() {
        given()
                .spec(getBaseSpec())
                .get("store/order/" + 14317567)
                .then()
                .assertThat()
                .statusCode(404);
    }



}