package android.samples.fietsveilig;

import android.util.Pair;

import java.util.Map;
import java.util.Vector;

public class HelpModel {
    /**
     * Returns a map of texts that is going to be displayed on help page
     * @return: Map<String, String> the key is the title, and the data is the explanation
     */
    public static Vector<Pair<String, String>> getHelpData(){
        // TODO put real data
        Vector<Pair<String, String>> data = new Vector<>();

        data.add(new Pair("Titel 1", "Uitleg 1"));
        data.add(new Pair("Titel 2", "Uitleg 2"));
        data.add(new Pair("Titel 3", "Uitleg 3"));
        data.add(new Pair("Titel 4", "Uitleg 4"));
        data.add(new Pair("Titel 5", "Uitleg 5"));

        return data;
    }
}
