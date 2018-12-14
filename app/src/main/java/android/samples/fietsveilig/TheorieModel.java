package android.samples.fietsveilig;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class TheorieModel {

    public static Vector<Vector<String>> getEisen(){
        Vector<Vector<String>> eisen = new Vector<Vector<String>>();
        Vector<String> eis = new Vector<String>();

        eis.add(
                "1. een goed functionerende bel\n" +
                "2. goede remmen vooraan en achteraan\n" +
                "3. een witte reflector vooraan\n" +
                "4. een rode reflector achteraan\n" +
                "5. reflectoren aan weerszijden van elke pedaal\n" +
                "6. reflectoren in de wielen\n" +
                "7. of banden met een reflecterende zijkant\n"
                );
        eis.add(Integer.toString(R.drawable.technischeeisenfiets));
        eisen.add(eis);

        return eisen;
    }

    public static Vector<Vector<String>> getPaden(){
        Vector<Vector<String>> paden = new Vector<Vector<String>>();
        Vector<String> pad = new Vector<String>();

        pad.add("Dit soort fietspad bevindt zich " +
                "(meestal) langs weerszijden van de rijbaan." +
                "Het wordt gebruikt indien de weg niet breed genoeg" +
                "is voor een echt fietspad." +
                "We noemen dit soort fietspad de fietssuggestiestrook.");
        pad.add(Integer.toString(R.drawable.fietssuggestiestrook));
        paden.add(pad);
        pad= new Vector<String>();

        pad.add("Dit soort fietspad is afgebakend met" +
                " twee evenwijdige witte onderbroken strepen en" +
                " dat niet breed genoeg is voor het autoverkeer." +
                " Is dit fietspad aanwezig, dan ben je als fietser verplicht " +
                "hiervan gebruik te maken, indien het rechts in je rijrichting ligt."+
                "We noemen dit soort fietspad het fietspad a.d.h.v. wegmarkeringen.");
        pad.add(Integer.toString(R.drawable.wegmarkering));
        paden.add(pad);
        pad= new Vector<String>();

        pad.add("Dit soort fietspad is een vlak afgebakend door" +
                " twee stopstrepen aan een verkeerslicht." +
                "Wanneer het verkeerslicht op rood staat," +
                " mogen de fietsers zich opstellen tussen" +
                " deze twee strepen, vóór de stilstaande wagens." +
                "We noemen dit soort fietspad het fietsopstelvak.");
        pad.add(Integer.toString(R.drawable.fietsopstelvak));
        paden.add(pad);
        pad= new Vector<String>();

        return paden;
    }

    public static Vector<Vector<String>> getBorden(){
        Vector<Vector<String>> borden = new Vector<Vector<String>>();
        Vector<String> bord = new Vector<String>();

        bord.add("Begin verplicht fietspad");
        bord.add(Integer.toString(R.drawable.borden));
        borden.add(bord);
        bord= new Vector<String>();

        bord.add("Einde verplicht fietspad");
        bord.add(Integer.toString(R.drawable.borden2));
        borden.add(bord);
        bord= new Vector<String>();

        bord.add("Begin onverplicht fietspad");
        bord.add(Integer.toString(R.drawable.borden3));
        borden.add(bord);
        bord= new Vector<String>();

        bord.add("Einde onverplicht fietspad");
        bord.add(Integer.toString(R.drawable.borden4));
        borden.add(bord);
        bord= new Vector<String>();

        bord.add("Parkeerplaats fietsers en brommers");
        bord.add(Integer.toString(R.drawable.borden5));
        borden.add(bord);
        bord= new Vector<String>();

        bord.add("LET OP! Recht doorgaande fietsers in twee richtingen");
        bord.add(Integer.toString(R.drawable.borden6));
        borden.add(bord);
        bord= new Vector<String>();

        bord.add("Verplicht fietspad met tegenliggers");
        bord.add(Integer.toString(R.drawable.borden8));
        borden.add(bord);
        bord= new Vector<String>();

        bord.add("Uitgezonderd fietsers");
        bord.add(Integer.toString(R.drawable.borden9));
        borden.add(bord);
        bord= new Vector<String>();

        bord.add("Begin van een voetgangerszone");
        bord.add(Integer.toString(R.drawable.borden10));
        borden.add(bord);
        bord= new Vector<String>();

        bord.add("Einde van een voetgangerszone");
        bord.add(Integer.toString(R.drawable.borden11));
        borden.add(bord);
        bord= new Vector<String>();

        bord.add("Doodlopende weg met doorgang voor fietsers en voetgangers");
        bord.add(Integer.toString(R.drawable.borden12));
        borden.add(bord);
        bord= new Vector<String>();

        return borden;
    }

    public static Vector<Vector<String>> getLichten(){
        Vector<Vector<String>> lichten = new Vector<Vector<String>>();
        Vector<String> licht = new Vector<String>();

        licht.add("Zorg er voor dat je lichten behoorlijk werken" +
                " en gebruik deze ook. Ook al moet je dan veel harder trappen." +
                " Ook al maakt je dynamo een verschrikkelijk geluid." +
                " Je licht (en zeker je achterlicht) dient namelijk niet alleen " +
                "om de baan te verlichten, maar ook (en vooral) om gezien te worden.\n\n" +
                "Zonder goede lichten ben je in het donker zo goed als onzichtbaar." +
                " Zelfs op plaatsen met openbare verlichting.");
        licht.add(Integer.toString(R.drawable.lichten));
        lichten.add(licht);
        licht= new Vector<String>();

        return lichten;
    }

    public static Vector<Vector<String>> getVoorrang(){
        Vector<Vector<String>> voorrangregels = new Vector<Vector<String>>();
        Vector<String> voorrang = new Vector<String>();

        voorrang.add("Ook fietsers moeten dus voorrang verlenen aan" +
                " het verkeer dat van rechts komt." +
                " Op een kruispunt met beperkt zicht moet je erop kunnen vertrouwen" +
                " dat het verkeer van links je voorrang zal verlenen." +
                " Uiteindelijk rijd je een beetje blind. Daarom heeft de auto ook" +
                " (maar ook de fietser) die van rechts komt voorrang.");
        voorrang.add(Integer.toString(R.drawable.voorrangrechts));
        voorrangregels.add(voorrang);
        voorrang= new Vector<String>();

        return voorrangregels;
    }

    public static Vector<Vector<String>> getOversteken(){
        Vector<Vector<String>> oversteekregels = new Vector<Vector<String>>();
        Vector<String> oversteek = new Vector<String>();

        oversteek.add("Voorrang op zebrapaden is enkel voorbehouden aan voetgangers." +
                " Steek je al fietsend het zebrapad over, dan moet je dus voorrang verlenen." +
                " En daar is een goede reden voor. Een voetganger nadert en gebruikt " +
                "het zebrapad aan maximum 5 km/u. Als je het zebrapad nadert op je fiets," +
                " rijd je makkelijk vier keer zo snel. Een automobilist heeft dus een pak" +
                " minder tijd om je op te merken en gepast te reageren. " +
                "Hoe traag hij ook rijdt.\n\n" +
                "Op een zebrapad mag je niet fietsen. Dus moet je afstappen en te voet gaan.");
        oversteek.add(Integer.toString(R.drawable.oversteken));
        oversteekregels.add(oversteek);
        oversteek= new Vector<String>();

        return oversteekregels;
    }

    public static Vector<Vector<String>> getRegels(){
        Vector<Vector<String>> regels = new Vector<Vector<String>>();
        Vector<String> regel = new Vector<String>();

        regel.add("Het is de fietsers verboden te rijden" +
                " zonder het stuur vast te houden, " +
                "zonder de voeten op de pedalen of op de voetsteunen te hebben. " +
                "Zich te laten voorttrekken en" +
                " een dier aan de leiband houden is ook verboden.\n");
        regel.add(Integer.toString(R.drawable.gekfietsen));
        regels.add(regel);
        regel= new Vector<String>();

        regel.add("Is er geen fietspad, dan mag je op een gelijkgrondse" +
                " berm, parkeerstrook of de rijbaan rijden.");
        regel.add(Integer.toString(R.drawable.geenfietspad));
        regels.add(regel);
        regel= new Vector<String>();

        regel.add("Naast elkaar fietsen op de rijbaan mag met maximaal" +
                  " twee personen en alleen als er geen fietspad is." +
                  " Voor een groep fietsers van minstens 15 deelnemers " +
                  "zijn er afwijkende regels voorzien. Ze zijn bijvoorbeeld" +
                  " niet verplicht het fietspad te gebruiken en ze mogen met" +
                  " 2 naast elkaar blijven rijden op de rijbaan.");
        regel.add(Integer.toString(R.drawable.fietseningroep));
        regels.add(regel);
        regel= new Vector<String>();

        regel.add("In een verboden richting fietsen mag je enkel indien" +
                " er onder het rode verbodsbord een wit bordje" +
                " ‘Uitgezonderd fietsers' hangt.");
        regel.add(Integer.toString(R.drawable.verbodenrichting));
        regels.add(regel);
        regel= new Vector<String>();

        regel.add("Fietsers zijn verplicht de richting aan te geven" +
                " als zij van richting veranderen. Dat kan door de hand uit te steken.\n\n" +
                "Hier staan zelfs boetes op!");
        regel.add(Integer.toString(R.drawable.richtingaanwijzen));
        regels.add(regel);
        regel= new Vector<String>();

        regel.add("Fietsers mogen het fietspad verlaten om" +
                " van richting te veranderen, om in te halen en " +
                "om een hindernis heen te rijden");
        regel.add(Integer.toString(R.drawable.fietspadverlaten));
        regels.add(regel);
        regel= new Vector<String>();

        return regels;
    }
}
