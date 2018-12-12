package android.samples.fietsveilig;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class TheorieModel {

    public static Vector<String> getEisen(){
        Vector<String> daily = new Vector<String>();

        daily.add("Complete 1 quiz");
        daily.add("Complete a section of theory that has easy difficulty");
        daily.add("Complete 1 test");
        daily.add("Complete all daily challenges");

        return daily;
    }

    public static Vector<String> getPaden(){
        Vector<String> weekly = new Vector<String>();

        weekly.add("Complete 5 quizzes");
        weekly.add("Get a score higher than 9/10 on a test of easy difficulty");
        weekly.add("Pass on a test of normal difficulty");

        return weekly;
    }

    public static Vector<String> getBorden(){
        Vector<String> weekly = new Vector<String>();

        weekly.add("Complete 5 quizzes");
        weekly.add("Get a score higher than 9/10 on a test of easy difficulty");
        weekly.add("Pass on a test of normal difficulty");

        return weekly;
    }

    public static Vector<String> getRegels(){
        Vector<String> weekly = new Vector<String>();

        weekly.add("Complete 5 quizzes");
        weekly.add("Get a score higher than 9/10 on a test of easy difficulty");
        weekly.add("Pass on a test of normal difficulty");

        return weekly;
    }

    public static Vector<String> getLichten(){
        Vector<String> weekly = new Vector<String>();

        weekly.add("Complete 5 quizzes");
        weekly.add("Get a score higher than 9/10 on a test of easy difficulty");
        weekly.add("Pass on a test of normal difficulty");

        return weekly;
    }
}
