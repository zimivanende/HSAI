package android.samples.fietsveilig.challenges;

import java.util.Vector;

public class ChallengesModel {

    /**
     * Fetches the data for daily challenges and returns the text to be shown in a list
     * @return list of String where each string represents a challenge
     */
    public static Vector<String> getDailyChallenges(){
        Vector<String> daily = new Vector<String>();

        // TODO: add data
        daily.add("Oefen de theorie 1 keer.");
        daily.add("Haal een minimale score van 3/10 op oefen.");
        daily.add("Speel een minigame.");
        daily.add("Voltooi alle dagelijkse uitdagingen.");

        return daily;
    }

    /**
     * Fetches the data for weekly challenges and returns the text to be shown in a list
     * @return list of String where each string represents a challenge
     */
    public static Vector<String> getWeeklyChallenges(){
        Vector<String> weekly = new Vector<String>();

        // TODO: add data
        weekly.add("Oefen de theorie 10 keer");
        weekly.add("Haal een minimale score van 8/10 op oefen.");
        weekly.add("Haal een hogere score in een van de spelmodi (oefen of minigames) dan een vriend.");

        return weekly;
    }
}
