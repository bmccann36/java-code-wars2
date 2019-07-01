import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static junit.framework.Assert.assertEquals;

public class RunnersTest {

    @Test
    public void runnersTest() {
        int[] startPositions = {1, 4, 2};
        int[] speeds = {27, 18, 24};
        Runners target = new Runners();
        int result = target.runners(startPositions, speeds);
        assertEquals("it return length of input when all runners meet", 3, result);
    }


    @Test
    public void runnerTest2() {
        int[] startPositions = {1, 4, 2};
        int[] speeds = {5, 6, 2};
        Runners target = new Runners();
        int result = target.runners(startPositions, speeds);
        assertEquals("it returns 2 when 2 out of 3 meet", 2, result);
    }

    @Test
    public void runnerTest3() {
        int[] startPositions = {1, 2, 3};
        int[] speeds = {1, 1, 1};
        Runners target = new Runners();
        int result = target.runners(startPositions, speeds);
        assertEquals("it returns 2 when 2 out of 3 meet", -1, result);
    }

    @Test
    public void oneHundredTests() {
        JSONArray testCaseList = new JSONArray();
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        FileReader reader;
        try {
            reader = new FileReader("guide.json");
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            testCaseList = (JSONArray) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            JSONObject testCaseObj = (JSONObject) testCaseList.get(i);
            List inputs = (List) testCaseObj.get("inputs");
            Long answer = (Long) testCaseObj.get("answer");
            List<Long> startsList = (List<Long>) inputs.get(0);
            List<Long> speedsList = (List<Long>) inputs.get(1);

            int [] startPositions = startsList.stream().mapToInt(n->n.intValue()).toArray();
            int[] speeds =  speedsList.stream().mapToInt(n->n.intValue()).toArray();

            Runners target = new Runners();
            int result = target.runners(startPositions, speeds);
            assertEquals("it works with this random input", answer.intValue(), result);

        }

    }

    public static int[][] getRandInputs() {

        int len = getRand(2, 15);
        int[] startPositions = new int[len];
        int[] speeds = new int[len];

        for (int i = 1; i < len; i++) {
            int startPos = getRand(0, 3) != 0 ? getRand(-50, 50) : getRand(-1000, 1000);
            while (Arrays.asList(startPositions).contains(startPos)) {
                startPos = getRand(-50, 50);
            }
            startPositions[i] = startPos;
            speeds[i] = getRand(1, 30);
        }
        int[][] challengeInputs = {startPositions, speeds};
        return challengeInputs;
    }

    private static int getRand(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}