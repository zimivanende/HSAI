package android.samples.fietsveilig;

import java.util.Vector;

// just a class that provides dummy friends data
public class FriendsModel {

    private static Vector<String> m_friends = new Vector<>();
    private static boolean m_initialized = false;


    private static void init(){
        if (!m_initialized){
            m_friends.add("Joe (Beginner)");
            m_friends.add("Cindy (Intermediar)");
            m_friends.add("Davy (Ervaren)");
            m_friends.add("Klara (Nieuweling)");
            m_friends.add("Gert (Expert)");
            m_friends.add("Mechiel  (Intermediar)");
            m_friends.add("Jan (Beginner)");
            m_friends.add("Thijs  (Beginner)");
            m_initialized = true;
        }
    }

    public static Vector<String> getFriends(){
        if (m_friends.size() == 0){
            init();
        }

        return m_friends;
    }

    public static void remove (int pos){
        m_friends.remove(pos);
    }

    public static String getFriend(int pos){
        return m_friends.get(pos);
    }

    public static int getCount(){
        if (m_friends.size() == 0){
            init();
            return m_friends.size();
        }
        else
            return m_friends.size();
    }
}
