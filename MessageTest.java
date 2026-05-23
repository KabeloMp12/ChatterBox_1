package chatterbox_final;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testCheckUserNameSuccess() {
        Login login = new Login();
        login.StoreUsername = "K_1";
        assertTrue(login.checkUserName());
    }

    @Test
    public void testCheckUserNameFailure() {
        Login login = new Login();
        login.StoreUsername = "TooLongUsername";
        assertFalse(login.checkUserName());
    }

    @Test
    public void testPasswordComplexitySuccess() {
        Login login = new Login();
        assertTrue(login.checkPasswordComplexity("Ch@tt3rBox"));
    }

    @Test
    public void testPasswordComplexityFailure() {
        Login login = new Login();
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCheckCellPhoneNumberSuccess() {
        Login login = new Login();
        assertTrue(login.checkCellPhoneNumber("+27857597588"));
    }

    @Test
    public void testCheckCellPhoneNumberFailure() {
        Login login = new Login();
        assertFalse(login.checkCellPhoneNumber("08575975889"));
    }

    @Test
    public void testRegisterUserSuccess() {
        Login login = new Login();
        login.StoreUsername = "K_1";
        login.StorePassword = "Ch@tt3rBox";
        login.StoreCellphonenumber = "+27857597588";
        
        String result = login.registerUser();
        String expected = "The two above conditions have been met, and the user has been registered successfully.";
        assertEquals(expected, result);
    }

    @Test
    public void testLoginUserSuccess() {
        Login login = new Login();
        login.StoreUsername = "K_1";
        login.StorePassword = "Ch@tt3rBox";
        
        assertTrue(login.loginUser("K_1", "Ch@tt3rBox"));
    }

    @Test
    public void testLoginUserFailure() {
        Login login = new Login();
        login.StoreUsername = "K_1";
        login.StorePassword = "Ch@tt3rBox";
        
        assertFalse(login.loginUser("WrongUser", "WrongPass"));
    }

    @Test
    public void testReturnLoginStatusSuccess() {
        Login login = new Login();
        login.firstName = "John";
        login.lastName = "Doe";
        
        String result = login.returnLoginStatus(true);
        String expected = "Welcome John, Doe it is great to see you again.";
        assertEquals(expected, result);
    }

    @Test
    public void testReturnLoginStatusFailure() {
        Login login = new Login();
        
        String result = login.returnLoginStatus(false);
        String expected = "Username or password incorrect, please try again.";
        assertEquals(expected, result);
    }

    @Test
    public void testCheckMessageIDSuccess() {
        Message testMessenger = new Message();
        assertTrue(testMessenger.checkMessageID("MSG101"));
    }

    @Test
    public void testCheckMessageIDFailure() {
        Message testMessenger = new Message();
        assertFalse(testMessenger.checkMessageID("MESSAGE_ID_TOO_LONG_123456789"));
    }

    @Test
    public void testCheckRecipientCellSuccess() {
        Message testMessenger = new Message();
        String result = testMessenger.checkRecipientCell("+27857597588");
        String expected = "Cell phone number successfully captured.";
        assertEquals(expected, result);
    }

    @Test
    public void testCheckRecipientCellFailure() {
        Message testMessenger = new Message();
        String result = testMessenger.checkRecipientCell("08575975889");
        String expected = "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        assertEquals(expected, result);
    }

    @Test
    public void testCheckMessageLengthSuccess() {
        Message testMessenger = new Message();
        String result = testMessenger.checkMessageLength("Hello Mike!");
        String expected = "Message ready to send.";
        assertEquals(expected, result);
    }

    @Test
    public void testCheckMessageLengthFailure() {
        Message testMessenger = new Message();
        String longMessage = "";
        for (int i = 0; i < 255; i++) {
            longMessage = longMessage + "a";
        }
        String result = testMessenger.checkMessageLength(longMessage);
        String expected = "Message exceeds 250 characters by 5; please reduce the size.";
        assertEquals(expected, result);
    }

    @Test
    public void testCreateMessageHash() {
        Message testMessenger = new Message();
        String result = testMessenger.createMessageHash("MSG101", 0, "Hello Mike");
        String expected = "MS:0:MIKE";
        assertEquals(expected, result);
    }

    @Test
    public void testSentMessageChoice1() {
        Message testMessenger = new Message();
        String result = testMessenger.SentMessage(1);
        assertEquals("Message successfully sent.", result);
        assertEquals(1, testMessenger.returnTotalMessagess());
    }

    @Test
    public void testSentMessageChoice2() {
        Message testMessenger = new Message();
        String result = testMessenger.SentMessage(2);
        assertEquals("Message successfully stored.", result);
        assertEquals(0, testMessenger.returnTotalMessagess());
    }
}