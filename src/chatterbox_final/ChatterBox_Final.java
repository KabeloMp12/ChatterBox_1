package chatterbox_final;
import java.util.Scanner;
/**
 *
 * @author
 */
class Login {
    String StoreUsername;
    String StorePassword;
    String StoreCellphonenumber; 
    String firstName;
    String lastName;

 boolean checkUserName() {
        return StoreUsername != null && StoreUsername.contains("_") && StoreUsername.length() <= 5;
    }
