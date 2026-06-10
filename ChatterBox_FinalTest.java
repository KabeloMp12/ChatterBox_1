package chatterbox_finaltest;
import chatterbox_final.ChatterBox_Final;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ChatterBox_FinalTest {

    @Test
    public void testSentMessagesSummary() {
        String expected = "\"Did you get the cake?\", \"It is dinner time!\"";
        String actual = ChatterBox_Final.getSentMessagesSummary();
        assertEquals(expected, actual);
    }

    @Test
    public void testDisplayLongestMessage() {
        String expected = "Where are you? You are late! I have asked you to be on time.";
        String actual = ChatterBox_Final.getLongestStoredMessage();
        assertEquals(expected, actual);
    }

    @Test
    public void testSearchByMessageID() {
        String expected = "\"It is dinner time !\"";
        String actual = ChatterBox_Final.searchByMessageID("0838884567");
        assertEquals(expected, actual);
    }

    @Test
    public void testSearchByRecipient() {
        String expected = "Where are you? You are late! I have asked you to be on time. Ok, I am leaving without you.";
        String actual = ChatterBox_Final.getMessagesByRecipient("+27838884567");
        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteMessageUsingHash() {
        String expected = "Message: \"Where are you? You are late! I have asked you to be on time\" successfully deleted.";
        String actual = ChatterBox_Final.deleteMessageByHash("e5f6g7h8");
        assertEquals(expected, actual);
    }
}