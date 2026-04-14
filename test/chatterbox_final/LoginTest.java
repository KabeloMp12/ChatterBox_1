package chatterbox_final;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LoginTest {
    
    ChatterBox_Final login = new ChatterBox_Final();

    @Test
    public void testUsername() {
        
        boolean result = login.checkUsername("kyl_");
        assertTrue(result, "Username should be valid");
    }

    @Test
    public void testPassword() {
    
        boolean result = login.checkPassword("Ch@tter123");
        assertTrue(result, "Password should meet all complexity requirements");
    }

    @Test
    public void testPhone() {
     
        boolean result = login.checkPhone("012345678");
        assertTrue(result, "Phone number should be 10 characters and contain a colon");
    }
}

