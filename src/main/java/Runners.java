
import java.util.HashMap;


public class Runners {
    HashMap<String, Integer> meetPoints = new HashMap();

    public Integer runners(int[] startPositions, int[] speeds) {

        for (int i = 0; i < startPositions.length - 1; i++) {
            for (int j = i + 1; j < startPositions.length; j++) {
                int[] abStarts = {startPositions[i], startPositions[j]};
                int[] abRates = {speeds[i], speeds[j]};
                Integer meetPoint = determineMeetPoint(abStarts, abRates);
                if (meetPoint != -1) this.addToMap(meetPoint);
            }
        }
        if (this.meetPoints.isEmpty()) return -1;
        return getMostFrequent();

    }

    private Integer getMostFrequent() {
        Integer mostFrequent = 0;
        for (Object key : this.meetPoints.keySet()) {
            Integer currentVal = this.meetPoints.get(key);
            if (currentVal > mostFrequent) {
                mostFrequent = currentVal;
            }
        }
        if (mostFrequent == 1) return 2; // to indicate the meeting of two runners
        else return mostFrequent;
    }


    // adds to hash map or increment if key already exists
    private void addToMap(Integer meetPoint) {
        String meetPointKey = meetPoint.toString();
        if (this.meetPoints.containsKey(meetPointKey)) {
            Integer curVal = this.meetPoints.get(meetPointKey);
            this.meetPoints.put(meetPointKey, curVal + 1);
        } else {
            this.meetPoints.put(meetPointKey, 1);
        }

    }

    /*
    takes two values at a time and organizes them into a leader and lagger
    if lagger is going slower it will never catch leader, in this case -1 is returned
    otherwise method will attempt to find the point in meters where they meet
    */
    private static Integer determineMeetPoint(int[] abStarts, int[] abRates) {
        int aStart = abStarts[0];
        int bStart = abStarts[1];

        int aRate = abRates[0];
        int bRate = abRates[1];

        // todo: try making this a class instance instead
        HashMap<String, Integer> leaderData = new HashMap();
        HashMap<String, Integer> laggerData = new HashMap();

        //set conditionally based on which is ahead
        if (aStart - bStart < 0) {
            leaderData.put("startPos", bStart);
            leaderData.put("rate", bRate);
            laggerData.put("startPos", aStart);
            laggerData.put("rate", aRate);
        } else {
            leaderData.put("startPos", aStart);
            leaderData.put("rate", aRate);
            laggerData.put("startPos", bStart);
            laggerData.put("rate", bRate);
        }

        float advantage = leaderData.get("startPos") - laggerData.get("startPos");
        float mpmDiff = laggerData.get("rate") - leaderData.get("rate");
        if (mpmDiff == 0) return -1; // they are going the same speed
        float abMeetPoint = (advantage / mpmDiff * laggerData.get("rate") + laggerData.get("startPos"));
        if (abMeetPoint < 0) return -1;
        else return new Integer((int) abMeetPoint);

    }

}


