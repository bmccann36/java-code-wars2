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
}