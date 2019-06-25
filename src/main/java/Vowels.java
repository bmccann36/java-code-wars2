import java.util.Arrays;
import java.util.List;

public class Vowels {

    public static int getCount(String str) {
        int vowelsCount = 0;
        Character[] vowelListRaw = {'a', 'e', 'i', 'o', 'u'};
        // Convert String Array to List
        List<Character> list = Arrays.asList(vowelListRaw);
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if(list.contains(c)){
                vowelsCount ++;
            }
        }

        return vowelsCount;
    }

}