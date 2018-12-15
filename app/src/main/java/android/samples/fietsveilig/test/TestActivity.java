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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // create the fragments
        m_resultFragment = new TestResultFragment();
        m_voorrangZebra = new MultipleChoiceFragment();
        m_deelVanWeg = new TrueFalseFragment();
        m_voorrang = new TrueFalseFragment();

        // add the fragments
        m_testFragments.add(m_voorrangZebra);
        m_testFragments.add(m_deelVanWeg);
        m_testFragments.add(m_voorrang);
        m_testFragments.add(new NumberInputFragment());

        // set current question
        m_currentQuestion = m_testFragments.get(0);

        // set question content
        setQuestions();

        // set first quistion as starting fragment
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
    }

    private void showMessagePopup(String message){
        new AlertDialog.Builder(this)
                .setTitle("Explanation")
                .setMessage(message)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setNeutralButton("ok", null).show();
    }

    public void setNextTestActivity(){
        int currentIndex = m_testFragments.indexOf(m_currentQuestion);

        // if there are no more questions go to resultFragment
        if (currentIndex == (m_testFragments.size()-1)){
            m_resultFragment.setScore(m_accumulatedScore, m_testFragments.size());
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, m_resultFragment).commit();
        }
        // if there are questions remaining, set next question fragment
        else if (currentIndex < m_testFragments.size()){
            m_accumulatedScore += m_currentQuestion.getScore();
            m_currentQuestion = m_testFragments.get(currentIndex+1);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, m_currentQuestion).commit();
        }
    }

}
