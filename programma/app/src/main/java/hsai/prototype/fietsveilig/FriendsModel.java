package hsai.prototype.fietsveilig;


import java.util.Vector;

// just a class that provides dummy friends data
public class FriendsModel {

    private static Vector<String> m_friends = new Vector<>();
    private static boolean m_initialized = false;


    private static void init(){
        if (!m_initialized){
            m_friends.add("Joe (beginner)");
            m_friends.add("Cindy (intermediate)");
            m_friends.add("Bert (experienced)");
            m_friends.add("Klara (rookie)");
            m_friends.add("Gert (expert)");
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
