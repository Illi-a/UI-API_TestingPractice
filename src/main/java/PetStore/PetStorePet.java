package PetStore;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.equalTo;

public class PetStorePet extends RestAssuredClient {

    private int petID = 84842316;
    private int petUPDID = 84816;

    public void createPet() {
        File json = new File("src/test/resources/pet.json");
        given()
                .spec(getBaseSpec())
                .body(json)
                .when()
                .post("/pet")
                .then()
                .assertThat()
                .body("id", equalTo(petID))
                .statusCode(200);
    }

    public void createPetWithEmptyBody() {
        File json = new File("src/test/resources/pet.json");
        given()
                .spec(getBaseSpec())
                .when()
                .post("/pet")
                .then()
                .assertThat()
                .body("message", equalTo("no data"))
                .statusCode(405);
    }

    public void updateExistingPet(){
        File petUPD = new File ("src/test/resources/petUpdate.json");
        given()
                .spec(getBaseSpec())
                .body(petUPD)
                .when()
                .put("/pet")
                .then()
                .assertThat()
                .body("id", equalTo(petUPDID))
                .statusCode(200);
    }

    public void assertThatPetIsCreated(){
        given()
                .spec(getBaseSpec())
                .get("/pet/" + petID)
                .then()
                .assertThat()
                .body("id", equalTo(petID))
                .statusCode(200);
    }

    public void assertThatPetIsUpdated(){
        given()
                .spec(getBaseSpec())
                .get("/pet/" + petUPDID)
                .then()
                .assertThat()
                .body("id", equalTo(petUPDID))
                .statusCode(200);
    }

    public void findPetWithIncorrectID(){
        given()
                .spec(getBaseSpec())
                .get("/pet/834580111616")
                .then()
                .assertThat()
                .statusCode(404);
    }

    public void deleteCreatedPetById(){
        given()
                .spec(getBaseSpec())
                .delete("/pet/" + petID)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
