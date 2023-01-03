package PetStore;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;

import java.io.File;

public class PetStorePet extends PetStoreRestAssuredClient {

    private int petID = 84842316;
    private int petUPDID = 84816;

    public void createPet() {
        File json = new File("src/test/resources/pet.json");
        RestAssured.given()
                .spec(getBaseSpec())
                .body(json)
                .when()
                .post("/pet")
                .then()
                .assertThat()
                .body("id", Matchers.equalTo(petID))
                .statusCode(200);
    }

    public void createPetWithEmptyBody() {
        File json = new File("src/test/resources/pet.json");
        RestAssured.given()
                .spec(getBaseSpec())
                .when()
                .post("/pet")
                .then()
                .assertThat()
                .body("message", Matchers.equalTo("no data"))
                .statusCode(405);
    }

    public void updateExistingPet() {
        File petUPD = new File("src/test/resources/petUpdate.json");
        RestAssured.given()
                .spec(getBaseSpec())
                .body(petUPD)
                .when()
                .put("/pet")
                .then()
                .assertThat()
                .body("id", Matchers.equalTo(petUPDID))
                .statusCode(200);
    }

    public void assertThatPetIsCreated() {
        RestAssured.given()
                .spec(getBaseSpec())
                .get("/pet/" + petID)
                .then()
                .assertThat()
                .body("id", Matchers.equalTo(petID))
                .statusCode(200);
    }

    public void assertThatPetIsUpdated() {
        RestAssured.given()
                .spec(getBaseSpec())
                .get("/pet/" + petUPDID)
                .then()
                .assertThat()
                .body("id", Matchers.equalTo(petUPDID))
                .statusCode(200);
    }

    public void findPetWithIncorrectID() {
        RestAssured.given()
                .spec(getBaseSpec())
                .get("/pet/834580111616")
                .then()
                .assertThat()
                .statusCode(404);
    }

    public void deleteCreatedPetById() {
        RestAssured.given()
                .spec(getBaseSpec())
                .delete("/pet/" + petID)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
