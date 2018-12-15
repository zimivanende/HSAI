package android.samples.fietsveilig.test;

import android.app.AlertDialog;
import android.os.Bundle;
import android.samples.fietsveilig.R;
import android.support.v7.app.AppCompatActivity;

import java.util.Vector;

//TODO: use ic_info_outline_black as button for information about the current test (question)

public class TestActivity extends AppCompatActivity {
    private Vector<TestActivityFragment> m_testFragments = new Vector<>();
    private TestActivityFragment m_currentQuestion = null;
    private TestResultFragment m_resultFragment; // TODO
    private int m_accumulatedScore = 0;
    private MultipleChoiceFragment m_voorrangZebra = new MultipleChoiceFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        m_resultFragment = new TestResultFragment();
        m_testFragments.add(m_voorrangZebra);
        m_testFragments.add(new NumberInputFragment());
        m_currentQuestion = m_testFragments.get(0);

        //setQuestions();

        // set first quistion as starting fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, m_testFragments.get(0)).commit();

    }

    private void setQuestions(){
        m_voorrangZebra.setQuestion("Voorrang op zebrapaden is enkel boorbehouden voor?");
        m_voorrangZebra.setAnswer1("Fietsers");
        m_voorrangZebra.setAnswer2("Bromfietsers");
        m_voorrangZebra.setAnswer3("Voetgangers");
        m_voorrangZebra.setCorrectAnswer(3);


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
