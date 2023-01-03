package PetStore;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;

import java.io.File;

public class PetStoreUser extends PetStoreRestAssuredClient {

    private String userNickname = "qqqwerty";
    private String userUPDNickname = "werty";

    public void createUser() {
        File userJson = new File("src/test/resources/user.json");
        RestAssured.given()
                .spec(getBaseSpec())
                .body(userJson)
                .when()
                .post("user/")
                .then()
                .assertThat()
                .body("message", Matchers.equalTo("2312333"))
                .statusCode(200);
    }

    public void updateUser() {
        File userUPDJson = new File("src/test/resources/userUPD.json");
        RestAssured.given()
                .spec(getBaseSpec())
                .body(userUPDJson)
                .when()
                .put("user/" + userNickname)
                .then()
                .assertThat()
                .body("message", Matchers.equalTo("231222"))
                .statusCode(200);
    }

    public void assertThatUserCreated() {
        RestAssured.given()
                .spec(getBaseSpec())
                .get("user/" + userNickname)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public void assertThatUserUpdated() {
        RestAssured.given()
                .spec(getBaseSpec())
                .get("user/" + userUPDNickname)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public void deleteUser() {
        RestAssured.given()
                .spec(getBaseSpec())
                .delete("user/" + userNickname)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public void deleteUPDUser() {
        RestAssured.given()
                .spec(getBaseSpec())
                .delete("user/" + userUPDNickname)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public void loginUserintoTheSystem() {
        RestAssured.given()
                .spec(getBaseSpec())
                .get("user/login?username=qqqwerty&password=qwerty")
                .then()
                .assertThat()
                .statusCode(200);
    }

    public void logoutUser() {
        RestAssured.given()
                .spec(getBaseSpec())
                .get("user/logout")
                .then()
                .assertThat()
                .body("message", Matchers.equalTo("ok"))
                .statusCode(200);
    }

}
