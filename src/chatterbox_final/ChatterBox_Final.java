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
 
 boolean checkCellPhoneNumber(String cellphone_number) {
        return cellphone_number.startsWith("+27") && cellphone_number.length() == 10;
    }


public String registerUser() {
       
        if (checkUserName() == false) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than 5 characters long.";
        } 
        
        if (checkPasswordComplexity(StorePassword) == false) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        
        if (checkCellPhoneNumber(StoreCellphonenumber) == false) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        return "The two above conditions have been met, and the user has been registered successfully. "
                + "" + "Welcome  " +  firstName + "   " + lastName +"   It is great to see you";
       
    }