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
        Vector<Pair<String, String>> data = new Vector<>();

        data.add(new Pair("Hoe Mini Games vrijspelen?", "Door je gemiddelde score te verhogen verhoog je je status.\n" +
                "Bij elke nieuwe status speel je een Mini Game vrij."));
        data.add(new Pair("Vrienden toevoegen en verwijderen", "Ga naar je profiel pagina.\n" +
                "Om vrienden toe te voegen druk je op \"+\" knop, voer je de naam in en drukt op voeg toe.\n" +
                "Om vrienden te verwijderen klik je op het vuilbakje naast hun naam."));
        data.add(new Pair("Login & Loguit", "Inloggen met een gebruikersnaam en wachtwoord, gekregen van de leerkracht.\n" +
                "\n" +
                "Inloggen als gast, zonder gebruikersnaam en/of wachtwoord." +
                "Alle theorie en oefeningen zijn nog beschikbaar maar de voortgang wordt niet bijgehouden.\n" +
                "\n" +
                "Je blijft ingelogd, ook na het verlaten van de app." +
                "Je kan uitloggen door in het zij-menu, de optie te selecteren"));

        return data;
    }
}
