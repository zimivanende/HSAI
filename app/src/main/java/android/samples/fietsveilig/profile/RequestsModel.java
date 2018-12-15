package android.samples.fietsveilig.profile;

import java.util.Vector;

public class RequestsModel {
    private static Vector<String> m_requests = new Vector<>();
    private static boolean m_initialized = false;
    private static final String POSTFIX = " heeft je een vriendschapsverzoek gestuurd.";

    private static void init(){
        if (!m_initialized){
            m_requests.add("Dirk (Beginner)");
            m_requests.add("Gert (Intermediar)");
            m_requests.add("Albert (Ervaren)");
            m_requests.add("David (Nieuweling)");
            m_initialized = true;
        }
    }

    public static Vector<String> getRequests(){
        if (m_requests.size() == 0){
            init();
        }

        return m_requests;
    }

    public static void remove (int pos){
        m_requests.remove(pos);
    }

    public static String getRequest(int pos){
        if (m_initialized == false)
            init();
        return m_requests.get(pos) + POSTFIX;
    }

    public static String getRequestSender(int pos){
        if (m_initialized == false)
            init();
        return m_requests.get(pos);
    }

    public static int getCount(){
        if (m_requests.size() == 0){
            init();
        }
            return m_requests.size();
    }
}
