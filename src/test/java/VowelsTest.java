import org.junit.Test;

import static org.junit.Assert.*;

public class VowelsTest {

    @Test
    public void getCount() {
        assertEquals("Nope!", 5, Vowels.getCount("abracadabra"));
    }

}