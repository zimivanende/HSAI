package android.samples.fietsveilig.test;

import android.app.AlertDialog;
import android.os.Bundle;
import android.samples.fietsveilig.R;
import android.support.v7.app.AppCompatActivity;

import java.util.Vector;

public class TestActivity extends AppCompatActivity {
    private Vector<TestActivityFragment> m_testFragments = new Vector<>();
    private TestActivityFragment m_currentQuestion = null;
    private TestResultFragment m_resultFragment;
    private int m_accumulatedScore = 0;
    private MultipleChoiceFragment m_voorrangZebra;
    private TrueFalseFragment m_deelVanWeg;
    private TrueFalseFragment m_voorrang;
    private MultipleChoiceFragment m_borden;
    private MultipleChoiceFragment m_benaming;
    private NumberInputFragment m_number;
    private PhotoSelectorFragment m_fietspaden;
    private int mNumUsedHints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // create the fragments
        m_resultFragment = new TestResultFragment();
        m_voorrangZebra = new MultipleChoiceFragment();
        m_deelVanWeg = new TrueFalseFragment();
        m_voorrang = new TrueFalseFragment();
        m_borden = new MultipleChoiceFragment();
        m_benaming = new MultipleChoiceFragment();
        m_number = new NumberInputFragment();
        m_fietspaden = new PhotoSelectorFragment();

        // add the fragments
        m_testFragments.add(m_voorrangZebra);
        m_testFragments.add(m_deelVanWeg);
        m_testFragments.add(m_voorrang);
        m_testFragments.add(m_borden);
        m_testFragments.add(m_benaming);
        m_testFragments.add(m_number);
        m_testFragments.add(m_fietspaden);

        // set current question
        m_currentQuestion = m_testFragments.get(0);

        // set question content
        setQuestions();

        // set first question as starting fragment
        m_currentQuestion.setProgress("1/" + m_testFragments.size());
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, m_testFragments.get(0)).commit();

    }

    private void setQuestions(){
        m_voorrangZebra.setQuestion("Voorrang op zebrapaden is enkel voorbehouden voor?");
        m_voorrangZebra.setAnswer1("Fietsers");
        m_voorrangZebra.setAnswer2("Bromfietsers");
        m_voorrangZebra.setAnswer3("Voetgangers");
        m_voorrangZebra.setCorrectAnswer(3);
        m_voorrangZebra.setImage(R.drawable.oversteken);
        m_voorrangZebra.setM_hint("Het is de traagste.");
        m_voorrangZebra.setExplanation("Voorrang op zebrapaden is enkel voorbehouden aan voetgangers." +
                " Steek je al fietsend het zebrapad over, dan moet je dus voorrang verlenen." +
                " En daar is een goede reden voor. Kijk even in de theorie voor eer info hierover.");

        m_deelVanWeg.setQuestion("Het fietspad maakt geen deel uit van de openbare weg.");
        m_deelVanWeg.setAnswer1("Juist");
        m_deelVanWeg.setAnswer2("Fout");
        m_deelVanWeg.setCorrectAnswer(2);
        m_deelVanWeg.setImage(R.drawable.wegmarkering);
        m_deelVanWeg.setM_hint("Je verplaatst je erop met een voertuig dus...");
        m_deelVanWeg.setExplanation("Het is deel van de openbare weg, dus alle verkeersregels gelden hierop.");

        m_voorrang.setQuestion("Wie heeft er op deze foto voorang?");
        m_voorrang.setAnswer1("De auto");
        m_voorrang.setAnswer2("De fietser");
        m_voorrang.setCorrectAnswer(1);
        m_voorrang.setImage(R.drawable.voorrangrechts2);
        m_voorrang.setM_hint("Al gehoord van voorrang van rechts? Maar geldt dit ook voor fietsers...");
        m_voorrang.setExplanation("Ook fietsers moeten dus voorrang verlenen aan het verkeer dat van rechts komt. \n" +
                "Als je wil weten waarom bekijk de theorie dan even.");

        m_borden.setQuestion("Welke behoord niet tot deze borden.");
        m_borden.setAnswer1("Het begin van een voetgangerszone");
        m_borden.setAnswer2("Het einde van een voetgangerszone");
        m_borden.setAnswer3("Verplicht hand in hand lopen");
        m_borden.setCorrectAnswer(3);
        m_borden.setImage(R.drawable.begineindevoetgagerszone);
        m_borden.setM_hint("Honden moeten aan de leiband, kinderen ook?");
        m_borden.setExplanation("Zie theorie voor meer borden.");

        m_benaming.setQuestion("Wat is de juist benaming voor wat je op de foto ziet?");
        m_benaming.setAnswer1("Wegmarkering");
        m_benaming.setAnswer2("Stoplichtvak");
        m_benaming.setAnswer3("Fietsopstelvak ");
        m_benaming.setCorrectAnswer(3);
        m_benaming.setImage(R.drawable.fietsopstelvak);
        m_benaming.setM_hint("Je kan er jezelf ... voor te wachten op groen licht.");
        m_benaming.setExplanation("Het fietsopstelvak is afgebakend door twee stopstrepen. Wanneer het verkeerslicht op rood staat," +
                " mogen de fietsers zich opstellen tussen deze twee strepen," +
                " vóór de stilstaande wagens.\nVoor meer info bekijk even de theorie.");

        m_number.setQuestion("Fietsen in groep mag, maar met hoeveel personen mag je langs elkaar rijden?");
        m_number.setCorrectAnswer(2);
        m_number.setImage(R.drawable.fietseningroep);
        m_number.setExplanation("Voor een groep fietsers van minstens 15 deelnemers zijn afwijkende regels voorzien. " +
                "Ze zijn b.v. niet verplicht het fietspad te gebruiken en ze mogen met 2 naast elkaar blijven rijden" +
                " op de rijbaan.\nVoor meer info bekijk even de theorie.");

        m_fietspaden.setQuestion("Welk van deze foto is een fietssuggestiestrook?");
        m_fietspaden.setAnswer1(R.drawable.fietspadantw1);
        m_fietspaden.setAnswer2(R.drawable.fietspadantw2);
        m_fietspaden.setAnswer3(R.drawable.fietspadantw3);
        m_fietspaden.setCorrectAnswer(2);
        m_fietspaden.setM_hint("Welke lijkt het minst \"verlplicht\"");
        m_fietspaden.setExplanation("Fietssuggestiestrook bevindt zich " +
                "meestal langs weerszijden van de rijbaan " +
                "wanneer deze niet breed genoeg " +
                "is voor een echt fietspad.\nVoor meer info bekijk even de theorie.");
    }

    private void showMessagePopup(String message){
        new AlertDialog.Builder(this)
                .setTitle("Explanation")
                .setMessage(message)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setNeutralButton("ok", null).show();
    }

    /**
     * Calculates the xp gained from doing the questions
     */
    private int getXp(){
        return m_accumulatedScore * 3 - mNumUsedHints * 2;
    }

    /**
     * Makes the next test visible
     */
    public void setNextTestActivity(){
        int currentIndex = m_testFragments.indexOf(m_currentQuestion);

        // if there are no more questions go to resultFragment
        if (currentIndex == (m_testFragments.size()-1)){
            m_accumulatedScore += m_currentQuestion.getScore();
            m_resultFragment.setScore(m_accumulatedScore, m_testFragments.size(), getXp());
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, m_resultFragment).commit();
        }
        // if there are questions remaining, set next question fragment
        else if (currentIndex < m_testFragments.size()){
            m_accumulatedScore += m_currentQuestion.getScore();

            if (m_currentQuestion.hintUsed())
                mNumUsedHints++;

            m_currentQuestion = m_testFragments.get(currentIndex+1);
            m_currentQuestion.setProgress((currentIndex+2) + "/" + m_testFragments.size());
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, m_currentQuestion).commit();
        }
    }

}
