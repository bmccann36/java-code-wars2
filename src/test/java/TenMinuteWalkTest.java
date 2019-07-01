import org.junit.Test;

import static org.junit.Assert.*;

public class TenMinuteWalkTest {
    @Test
    public void Test() {
        assertEquals("Should return true", true, TenMinuteWalk.isValid(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}));
        assertEquals("Should return false", false, TenMinuteWalk.isValid(new char[]{'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e'}));
        assertEquals("Should return false", false, TenMinuteWalk.isValid(new char[]{'w'}));
        assertEquals("Should return false", false, TenMinuteWalk.isValid(new char[]{'n', 'n', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}));

    }

    private static final char[][] fail = new char[][]{
            new char[]{'n'},
            new char[]{'n', 's'},
            new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'},
            new char[]{'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's', 'e', 'w'},
            new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 'n'},
            new char[]{'e', 'e', 'e', 'w', 'n', 's', 'n', 's', 'e', 'w'},
            new char[]{'n', 'e', 'n', 'e', 'n', 'e', 'n', 'e', 'n', 'e'},
            new char[]{'n', 'w', 'n', 'w', 'n', 'w', 'n', 'w', 'n', 'w'},
            new char[]{'s', 'e', 's', 'e', 's', 'e', 's', 'e', 's', 'e'},
            new char[]{'s', 'w', 's', 'w', 's', 'w', 's', 'w', 's', 'w'}
    };

    private static final char[][] pass = new char[][]{
            new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'},
            new char[]{'e', 'w', 'e', 'w', 'n', 's', 'n', 's', 'e', 'w'},
            new char[]{'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's'}
    };

    @Test
    public void Test02() {
        assertEquals("Should return false if walk is too short.  ", false, TenMinuteWalk.isValid(fail[0]));
        assertEquals("Should return false if walk is too short.  ", false, TenMinuteWalk.isValid(fail[1]));
        assertEquals("Should return false if walk is too long.  ", false, TenMinuteWalk.isValid(fail[2]));
        assertEquals("Should return false if walk is too long.  ", false, TenMinuteWalk.isValid(fail[3]));
        assertEquals("Should return false if walk does not bring you back to start.  ", false, TenMinuteWalk.isValid(fail[4]));
        assertEquals("Should return false if walk does not bring you back to start.  ", false, TenMinuteWalk.isValid(fail[5]));
        assertEquals("Should return false if walk does not bring you back to start.  ", false, TenMinuteWalk.isValid(fail[6]));
        assertEquals("Should return false if walk does not bring you back to start.  ", false, TenMinuteWalk.isValid(fail[7]));
        assertEquals("Should return false if walk does not bring you back to start.  ", false, TenMinuteWalk.isValid(fail[8]));
        assertEquals("Should return false if walk does not bring you back to start.  ", false, TenMinuteWalk.isValid(fail[9]));
        assertEquals("Should return true for a valid walk.  ", true, TenMinuteWalk.isValid(pass[0]));
        assertEquals("Should return true for a valid walk.  ", true, TenMinuteWalk.isValid(pass[1]));
        assertEquals("Should return true for a valid walk.  ", true, TenMinuteWalk.isValid(pass[2]));
    }
}