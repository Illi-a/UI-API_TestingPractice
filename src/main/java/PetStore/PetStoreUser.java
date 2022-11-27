package PetStore;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreUser extends RestAssuredClient{

    private String userNickname = "qqqwerty";
    private String userUPDNickname = "werty";

    public void createUser(){
        File userJson = new File("src/test/resources/user.json");
        given()
                .spec(getBaseSpec())
                .body(userJson)
                .when()
                .post("user/")
                .then()
                .assertThat()
                .body("message", equalTo("2312333"))
                .statusCode(200);
    }

    public void updateUser(){
        File userUPDJson = new File("src/test/resources/userUPD.json");
        given()
                .spec(getBaseSpec())
                .body(userUPDJson)
                .when()
                .put("user/" + userNickname)
                .then()
                .assertThat()
                .body("message", equalTo("231222"))
                .statusCode(200);
    }

    public void assertThatUserCreated(){
            given()
                    .spec(getBaseSpec())
                    .get("user/" + userNickname )
                    .then()
                    .assertThat()
                    .statusCode(200);
    }

    public void assertThatUserUpdated(){
        given()
                .spec(getBaseSpec())
                .get("user/" + userUPDNickname)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public void deleteUser(){
        given()
                .spec(getBaseSpec())
                .delete("user/" + userNickname)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public void deleteUPDUser(){
        given()
                .spec(getBaseSpec())
                .delete("user/" + userUPDNickname)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public void loginUserintoTheSystem(){
        given()
                .spec(getBaseSpec())
                .get("user/login?username=qqqwerty&password=qwerty")
                .then()
                .assertThat()
                .statusCode(200);
    }

    public void logoutUser(){
        given()
                .spec(getBaseSpec())
                .get("user/logout")
                .then()
                .assertThat()
                .body("message", equalTo("ok"))
                .statusCode(200);
    }

}
