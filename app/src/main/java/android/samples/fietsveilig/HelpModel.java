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
        data.add(new Pair("Login & Loguit", "Als je de applicatie voor het eerst opstart," +
                " dan kan je kiezen uit twee manieren om in te loggen." +
                " Zo kan je bijvoorbeeld inloggen met een gebruikersnaam en wachtwoord" +
                " dat je hebt gekregen van je leerkracht. Je geeft deze dan in in de tekstvakjes " +
                "die te zien zijn op het startscherm. Als je dit goed hebt gedaan, dan kom je nu terecht op het home-menu.\n" +
                "\n" +
                "Als je de applicatie wilt gebruiken maar je geen gebruikersnaam en wachtwoord hebt om in te loggen, dan kan je ook" +
                " de optie \"Inloggen als gast\" selecteren. Dit zorgt ervoor dat je nog steeds alle theorie" +
                " kan inkijken en dat je de oefeningen nog steeds kunt maken. Het verschil met normaal inloggen is" +
                " wel dat je nu niet kan zien hoe je vrienden het hebben gedaan. Bovendien wordt je vooruitgang in het" +
                " vrijspelen van de minigames niet bijgehouden eenmaal je hebt uitgelogd.\n" +
                "\n" +
                "Al je beslist om de te stoppen met het gebruiken van de applicatie en je verlaat de appplicatie, " +
                "dan blijf je toch ingelogd. Je  kan natuurlijk wel uitloggen als je dit zou willen, dit kan door" +
                " in het zijbalk-menu de keuze \"Uitloggen\" te selecteren. Dit brengt je onmiddelijk terug naar het inlog-scherm waar " +
                "je dan kiezen om terug in te loggen met je gebruikersnaam en wachtwoord. Je kan natuurlijk ook altijd inloggen als gast, hier " +
                "heb je geen inlog-gegevens voor nodig maar je voortgang wordt dan ook niet bewaard na het uitloggen."));

        return data;
    }
}
