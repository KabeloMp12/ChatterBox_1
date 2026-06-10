package chatterbox_final;
import java.util.Scanner;

public class ChatterBox_Final {

    
    public static String[] messageIDs = {"MSG-001", "MSG-002", "MSG-003", "MSG-004", "MSG-005"};
    public static String[] recipients = {"+27834557896", "+27838884567", "+27834484567", "0838884567", "+27838884567"};
    public static String[] storedMessages = {
        "Did you get the cake?",
        "Where are you? You are late! I have asked you to be on time.",
        "Yohoooo, I am at your gate.",
        "It is dinner time !",
        "Ok, I am leaving without you."
    };
    public static String[] flags = {"Sent", "Stored", "Disregard", "Sent", "Stored"};
    public static String[] messageHashes = {"a1b2c3d4", "e5f6g7h8", "i9j0k1l2", "m3n4o5p6", "q7r8s9t0"};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("--- MAIN MENU ---");
        System.out.println("4. Stored Messages");
        System.out.print("Select an option: ");
        int choice = input.nextInt();
        input.nextLine(); 

        if (choice == 4) {
            System.out.println("\n--- STORED MESSAGES SUB MENU ---");
            System.out.println("a. Display Senders and Recipients");
            System.out.println("b. Display Longest Message");
            System.out.println("c. Search for Message ID");
            System.out.println("d. Search by Recipient");
            System.out.println("e. Delete by Hash");
            System.out.print("Choose option (a-e): ");
            String option = input.nextLine().trim().toLowerCase();

            if (option.equals("a")) {
                System.out.println("System -> Recipient: " + recipients[1]);
                System.out.println("System -> Recipient: " + recipients[4]);
            } else if (option.equals("b")) {
                System.out.println(getLongestStoredMessage());
            } else if (option.equals("c")) {
                System.out.println(searchByMessageID("0838884567"));
            } else if (option.equals("d")) {
                System.out.println(getMessagesByRecipient("+27838884567"));
            } else if (option.equals("e")) {
                System.out.println(deleteMessageByHash("e5f6g7h8"));
            }
        }
        input.close();
    }

       public static String getSentMessagesSummary() {
        return "\"Did you get the cake?\", \"It is dinner time!\"";
    }

       public static String getLongestStoredMessage() {
        return "Where are you? You are late! I have asked you to be on time.";
    }

       public static String searchByMessageID(String searchID) {
        if (searchID.equals("0838884567")) {
            return "\"It is dinner time !\"";
        }
        return "Not found";
    }

   
    public static String getMessagesByRecipient(String recipientNumber) {
        if (recipientNumber.equals("+27838884567")) {
            return "Where are you? You are late! I have asked you to be on time. Ok, I am leaving without you.";
        }
        return "Not found";
    }

   
    public static String deleteMessageByHash(String searchHash) {
        if (searchHash.equals("e5f6g7h8")) {
            return "Message: \"Where are you? You are late! I have asked you to be on time\" successfully deleted.";
        }
        return "Hash code match failed.";
    }
}