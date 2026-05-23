package chatterbox_final;

import java.util.Scanner;


class Login {
    String StoreUsername;
    String StorePassword;
    String StoreCellphonenumber; 
    String firstName;
    String lastName;

    public boolean checkUserName() {
        if (StoreUsername != null && StoreUsername.contains("_") && StoreUsername.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) {
            return false; 
        }
        if (password.equals(password.toLowerCase())) {
            return false; 
        }
        
        // Basic check for a digit
        boolean hasDigit = false;
        if (password.contains("0") || password.contains("1") || password.contains("2") || 
            password.contains("3") || password.contains("4") || password.contains("5") || 
            password.contains("6") || password.contains("7") || password.contains("8") || 
            password.contains("9")) {
            hasDigit = true;
        }

        // Basic check for a special character
        boolean hasSpecial = false;
        if (password.contains("@") || password.contains("#") || password.contains("$") || 
            password.contains("%") || password.contains("!") || password.contains("*")) {
            hasSpecial = true;
        }

        if (hasDigit && hasSpecial) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkCellPhoneNumber(String cellphone_number) {
        if (cellphone_number.startsWith("+27") && cellphone_number.length() == 10) {
            return true;
        } else {
            return false;
        }
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
        return "The two above conditions have been met, and the user has been registered successfully.";
    }

    public boolean loginUser(String username, String password) {
        if (username.equals(StoreUsername) && password.equals(StorePassword)) {
            return true;
        } else {
            return false;
        }
    }

    public String returnLoginStatus(boolean loggedIn) {
        if (loggedIn == true) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}


class Message {
    int totalMessagesSent = 0;

    public boolean checkMessageID(String messageID) {
        if (messageID.length() <= 10) {
            return true;
        } else {
            return false;
        }
    }

    public String checkRecipientCell(String cell) {
        if (cell.startsWith("+27") && cell.length() == 10) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    public String checkMessageLength(String message) {
        if (message.length() <= 250) {
            return "Message ready to send.";
        } else {
            int exceedBy = message.length() - 250;
            return "Message exceeds 250 characters by " + exceedBy + "; please reduce the size.";
        }
    }

    public String createMessageHash(String messageID, int msgNum, String message) {
        String idPrefix = messageID.substring(0, 2);
        String[] words = message.split(" ");
        String lastWord = words[words.length - 1];
        String combined = idPrefix + ":" + msgNum + ":" + lastWord;
        return combined.toUpperCase();
    }

    public String SentMessage(int choice) {
        if (choice == 1) {
            totalMessagesSent = totalMessagesSent + 1;
            return "Message successfully sent.";
        } else if (choice == 2) {
            return "Message successfully stored.";
        } else {
            return "Press 0 to delete the message.";
        }
    }

    public int returnTotalMessagess() {
        return totalMessagesSent;
    }

 
    public void storeMessage(String msgID, String recipient, String content) {
        System.out.println("\n--- SAVED TO JSON STRUCTURE ---");
        System.out.println("{");
        System.out.println("  \"messageID\": \"" + msgID + "\",");
        System.out.println("  \"recipient\": \"" + recipient + "\",");
        System.out.println("  \"body\": \"" + content + "\"");
        System.out.println("}");
        System.out.println("--------------------------------");
    }
}


public class ChatterBox_Final {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Login myLogin = new Login();
        Message messenger = new Message();

 
        System.out.println("--- USER REGISTRATION ---");
        System.out.print("First Name: ");
        myLogin.firstName = scan.nextLine();
        
        System.out.print("Last Name: ");
        myLogin.lastName = scan.nextLine();
        
        System.out.print("Create Username: ");
        myLogin.StoreUsername = scan.nextLine();
        
        System.out.print("Create Password: ");
        myLogin.StorePassword = scan.nextLine();
        
        System.out.print("Cell Number (+27...): ");
        myLogin.StoreCellphonenumber = scan.nextLine();

        String registrationResult = myLogin.registerUser();
        System.out.println("\n" + registrationResult);

        
        if (registrationResult.contains("incorrectly formatted") || registrationResult.contains("not correctly formatted")) {
            System.out.println("Program stopped. Please rerun and register with correct formats.");
            scan.close();
            return; 
        }

      
        System.out.println("\n--- USER LOGIN ---");
        System.out.print("Enter Username: ");
        String loginUser = scan.nextLine();
        
        System.out.print("Enter Password: ");
        String loginPass = scan.nextLine();

        boolean isUserValid = myLogin.loginUser(loginUser, loginPass);
        System.out.println(myLogin.returnLoginStatus(isUserValid));

        
        if (isUserValid == false) {
            scan.close();
            return;
        }

      
        System.out.println("\nWelcome to QuickChat");
        System.out.print("How many messages do you wish to enter? ");
        int numMessages = scan.nextInt();
        scan.nextLine(); 

        for (int i = 0; i < numMessages; i++) {
            int idNum = 101 + i;
            String generatedID = "MSG" + idNum;
            
            System.out.println("\nMessage ID generated: " + generatedID);

            System.out.print("Enter Recipient Number: ");
            String cell = scan.nextLine();
            System.out.println(messenger.checkRecipientCell(cell));

            System.out.print("Enter Message Content: ");
            String body = scan.nextLine();
            System.out.println(messenger.checkMessageLength(body));

            String hash = messenger.createMessageHash(generatedID, i, body);

            System.out.println("\nSelect Action:");
            System.out.println("1) Send Message");
            System.out.println("2) Store Message");
            System.out.println("0) Disregard Message");
            System.out.print("Choice: ");
            int choice = scan.nextInt();
            scan.nextLine(); 

            String actionStatus = messenger.SentMessage(choice);
            System.out.println(actionStatus);

            if (choice == 1) {
                System.out.println("\n--- MESSAGE DETAILS ---");
                System.out.println("Message ID: " + generatedID);
                System.out.println("Message Hash: " + hash);
                System.out.println("Recipient: " + cell);
                System.out.println("Message: " + body);
                messenger.storeMessage(generatedID, cell, body);
            }
        }

        System.out.println("\n========================================");
        System.out.println("Total messages successfully sent: " + messenger.returnTotalMessagess());
        System.out.println("========================================");
        
        scan.close();
    }
}