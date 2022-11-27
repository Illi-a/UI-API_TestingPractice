import PetStore.PetStoreOrder;
import PetStore.PetStorePet;
import PetStore.PetStoreUser;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreTest {

    PetStorePet petStorePet = new PetStorePet();
    PetStoreOrder petStoreOrder = new PetStoreOrder();
    PetStoreUser petStoreUser = new PetStoreUser();

    @Test
    public void petCanBeCreated() {
        petStorePet.createPet();
        petStorePet.assertThatPetIsCreated();
        petStorePet.deleteCreatedPetById();
    }

    @Test
    public void creatingPetWithEmptyBody(){
        petStorePet.createPetWithEmptyBody();
    }

    @Test
    public void petNameCanBeUpdated() {
        petStorePet.createPet();
        petStorePet.updateExistingPet();
        petStorePet.assertThatPetIsUpdated();
        petStorePet.deleteCreatedPetById();
    }

    @Test
    public void findPetWithIncorrectIDTest404(){
        petStorePet.findPetWithIncorrectID();
    }

    @Test
    public void newOrderCanBeCreated(){
        petStoreOrder.createNewOrder();
        petStoreOrder.assertThatOrderIsCreated();
        petStoreOrder.deleteOrderById();
    }

    @Test
    public void findOrderWithIncorrectIDTest404(){
        petStoreOrder.findOrderByIncorrectID();
    }

    @Test
    public void creatingNewOrderWithEmptyBody(){
        petStoreOrder.createNewOrderWithEmptyBody();
    }

    @Test
    public void userCanBeCreated(){
        petStoreUser.createUser();
        petStoreUser.assertThatUserCreated();
        petStoreUser.deleteUser();
    }

    @Test
    public void userCanBeUpdated(){
        petStoreUser.createUser();
        petStoreUser.updateUser();
        petStoreUser.assertThatUserUpdated();
        petStoreUser.deleteUPDUser();
    }

    @Test
    public void userCanLoginIntoSystem(){
        petStoreUser.createUser();
        petStoreUser.loginUserintoTheSystem();
        petStoreUser.logoutUser();
        petStoreUser.deleteUser();
    }
}
