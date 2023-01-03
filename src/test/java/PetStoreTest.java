import PetStore.PetStoreOrder;
import PetStore.PetStorePet;
import PetStore.PetStoreUser;
import org.junit.Test;

public class PetStoreTest {

    PetStorePet petStorePet = new PetStorePet();
    PetStoreOrder petStoreOrder = new PetStoreOrder();
    PetStoreUser petStoreUser = new PetStoreUser();

    @Test
    public void petCanBeCreated200() {
        petStorePet.createPet();
        petStorePet.assertThatPetIsCreated();
        petStorePet.deleteCreatedPetById();
    }

    @Test
    public void creatingPetWithEmptyBody405() {
        petStorePet.createPetWithEmptyBody();
    }

    @Test
    public void petNameCanBeUpdated200() {
        petStorePet.createPet();
        petStorePet.updateExistingPet();
        petStorePet.assertThatPetIsUpdated();
        petStorePet.deleteCreatedPetById();
    }

    @Test
    public void findPetWithIncorrectIDTest404() {
        petStorePet.findPetWithIncorrectID();
    }

    @Test
    public void newOrderCanBeCreated200() {
        petStoreOrder.createNewOrder();
        petStoreOrder.assertThatOrderIsCreated();
        petStoreOrder.deleteOrderById();
    }

    @Test
    public void findOrderWithIncorrectIDTest404() {
        petStoreOrder.findOrderByIncorrectID();
    }

    @Test
    public void creatingNewOrderWithEmptyBody400() {
        petStoreOrder.createNewOrderWithEmptyBody();
    }

    @Test
    public void userCanBeCreated200() {
        petStoreUser.createUser();
        petStoreUser.assertThatUserCreated();
        petStoreUser.deleteUser();
    }

    @Test
    public void userCanBeUpdated200() {
        petStoreUser.createUser();
        petStoreUser.updateUser();
        petStoreUser.assertThatUserUpdated();
        petStoreUser.deleteUPDUser();
    }

    @Test
    public void userCanLoginIntoSystem200() {
        petStoreUser.createUser();
        petStoreUser.loginUserintoTheSystem();
        petStoreUser.logoutUser();
        petStoreUser.deleteUser();
    }
}
