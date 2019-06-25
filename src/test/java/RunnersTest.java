import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RunnersTest {

    @Test
    public void runnersTest() {
        int[] startPositions = {1, 4, 2};
        int[] speeds = {27, 18, 24};
        Runners target = new Runners();
        int result = target.runners(startPositions, speeds);
//        System.out.printf("TEST OUTPUT:  %x \n", result);
        assertEquals("it return length of input when all runners meet", 3, result);
    }


    @Test
    public void runnerTest2() {
        int[] startPositions = {1, 4, 2};
        int[] speeds = {5, 6, 2};
        Runners target = new Runners();
        int result = target.runners(startPositions, speeds);
//        System.out.printf("TEST OUTPUT:  %x \n", result);
        assertEquals("it returns 2 when 2 out of 3 meet", 2, result);
    }

    @Test
    public void runnerTest3() {
        int[] startPositions = {1, 2, 3};
        int[] speeds = {1, 1, 1};
        Runners target = new Runners();
        int result = target.runners(startPositions, speeds);
//        System.out.printf("TEST OUTPUT:  %x \n", result);
        assertEquals("it returns 2 when 2 out of 3 meet", -1, result);
    }

}