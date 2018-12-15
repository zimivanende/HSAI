package android.samples.fietsveilig.profile;

import java.util.Vector;

// just a class that provides dummy friends data
public class FriendsModel {

    private static Vector<String> m_friends = new Vector<>();
    private static boolean m_initialized = false;
    private static Vector<String> m_notFriends = new Vector<>();

    private static void init(){
        if (!m_initialized){
            // init friends list
            m_friends.add("Joe (Beginner)");
            m_friends.add("Cindy (Intermediar)");
            m_friends.add("Davy (Ervaren)");
            m_friends.add("Klara (Nieuweling)");
            m_friends.add("Gert (Expert)");
            m_friends.add("Mechiel  (Intermediar)");
            m_friends.add("Jan (Beginner)");
            m_friends.add("Thijs  (Beginner)");
            m_initialized = true;

            // init non-friends list
            m_notFriends.add("Noor (Nieuweling)");
            m_notFriends.add("Lucie (Beginner)");
            m_notFriends.add("Olivia (Intermediar)");
            m_notFriends.add("Sarah (Ervaren)");
            m_notFriends.add("Louise (Expert)");
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

    public static void add (String name){
        m_friends.add(name);
    }

    public static String getFriend(int pos){
        return m_friends.get(pos);
    }

    /**
     * @param name only the name without the title
     */
    public static boolean isFriend(String name){
        for (String friend : m_friends){
            if (name.equals(friend.split(" ")[0]))
                return true;
        }
        return false;
    }

    /**
     * @param name only the name without the title
     */
    public static boolean exists(String name){
        for (String friend : m_friends){
            if (name.equals(friend.split(" ")[0]))
                return true;
        }

        for (String nonfriend : m_notFriends){
            if (name.equals(nonfriend.split(" ")[0]))
                return true;
        }
        return false;
    }

    public static void addNonFriendAsFriend(String nameNotFriendUser){
        for (int i = 0; i < m_notFriends.size(); i++){
            String nonFriend = m_notFriends.get(i);
            if (nonFriend.split(" ")[0].equals(nameNotFriendUser)){
                m_friends.add(nonFriend);
                m_notFriends.remove(i);
                return;
            }
        }
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
