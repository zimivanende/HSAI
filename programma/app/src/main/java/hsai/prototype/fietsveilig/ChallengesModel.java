package hsai.prototype.fietsveilig;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class ChallengesModel {

    /**
     * Fetches the data for daily challenges and returns the text to be shown in a list
     * @return list of String where each string represents a challenge
     */
    public static Vector<String> getDailyChallenges(){
        Vector<String> daily = new Vector<String>();

        // TODO: add data
        daily.add("Complete 1 quiz");
        daily.add("Complete a section of theory that has easy difficulty");
        daily.add("Complete 1 test");
        daily.add("Complete all daily challenges");

        return daily;
    }

    /**
     * Fetches the data for weekly challenges and returns the text to be shown in a list
     * @return list of String where each string represents a challenge
     */
    public static Vector<String> getWeeklyChallenges(){
        Vector<String> weekly = new Vector<String>();

        // TODO: add data
        weekly.add("Complete 5 quizzes");
        weekly.add("Get a score higher than 9/10 on a test of easy difficulty");
        weekly.add("Pass on a test of normal difficulty");

        return weekly;
    }
}
