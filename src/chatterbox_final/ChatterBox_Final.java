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


 boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) {
            return false; 
        }

        if (password.equals(password.toLowerCase())) {
            return false; 
        }

        if (!password.contains("0") && !password.contains("1") && !password.contains("2") && 
            !password.contains("3") && !password.contains("4") && !password.contains("5") && 
            !password.contains("6") && !password.contains("7") && !password.contains("8") && 
            !password.contains("9")) {
            return false;
        }

        boolean hasSpecial = false;
     
        if (password.contains("@") || password.contains("#") || password.contains("$") || 
            password.contains("%") || password.contains("!") || password.contains("*")) {
            hasSpecial = true;
        }

        return hasSpecial;
    }
 