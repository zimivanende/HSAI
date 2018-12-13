package android.samples.fietsveilig;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MultipleChoiceFragment extends TestActivityFragment {
    private String m_hint;
    private String m_explanation;
    private int m_correctAnswer = 1;
    private View m_ui;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO find a way to set hint and explanation
        // TODO find a way to set m_correctAnswer
        View UI = inflater.inflate(R.layout.fragment_multiple_choice, container, false);
        m_ui = UI;

        initButtons();

        // just for test
        m_hint = "choose one of the answers below";
        m_explanation = "bla bla bla";
        m_correctAnswer = 4;

        return UI;
    }

    /**
     * All onlick listeners are set
     */
    private void initButtons(){
        // set onclick listeners
        final Button button1 = (Button)m_ui.findViewById(R.id.button_answer1);
        final Button button2 = (Button)m_ui.findViewById(R.id.button_answer2);
        final Button button3 = (Button)m_ui.findViewById(R.id.button_answer3);
        final Button button4 = (Button)m_ui.findViewById(R.id.button_answer4);
        final Button buttonNext = (Button)m_ui.findViewById(R.id.button_next);
        final Button buttonHint = (Button)m_ui.findViewById(R.id.button_hint);
        final Button buttonExplanation = (Button)m_ui.findViewById(R.id.button_explanation);

        /*
        When an answer button is clicked, then the correct and incorrect answers get highlighted
        and the tip button gets hidden and explanation button gets visible
         */
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (m_correctAnswer != 1){
                    button1.setBackgroundColor(getResources().getColor(R.color.incorrect));
                }
                setAfterAnswerUI();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (m_correctAnswer != 2){
                    button2.setBackgroundColor(getResources().getColor(R.color.incorrect));
                }
                setAfterAnswerUI();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (m_correctAnswer != 3){
                    button3.setBackgroundColor(getResources().getColor(R.color.incorrect));
                }
                setAfterAnswerUI();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (m_correctAnswer != 4){
                    button4.setBackgroundColor(getResources().getColor(R.color.incorrect));
                }
                setAfterAnswerUI();
            }
        });

        // when a hint or explanation button is clicked, the corresponding information is given
        buttonExplanation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessagePopup("Uitleg", m_explanation);
            }
        });

        buttonHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessagePopup("Hint", m_hint);
            }
        });

        // when the "next" button is clicked, the next fragment is going to be opened
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: find a way to open the next test fragment
            }
        });
    }

    // adjust ui post-answer (ui gets adjusted after an answer has been given)
    private void setAfterAnswerUI(){
        final Button buttonNext = (Button)m_ui.findViewById(R.id.button_next);
        final Button buttonHint = (Button)m_ui.findViewById(R.id.button_hint);
        final Button buttonExplanation = (Button)m_ui.findViewById(R.id.button_explanation);

        highlightCorrectAnswer(); // correct answer gets highlighted
        buttonNext.setVisibility(View.VISIBLE); // button to go to the next answer becomes visible
        disableAllAnswerButtons(); // all answer buttons are not clickable anymore
        buttonHint.setVisibility(View.INVISIBLE); // the hint button gets invisible
        buttonExplanation.setVisibility(View.VISIBLE); // explanation button gets visible
    }

    // sets the color of the correct answer to @color/correct
    private void highlightCorrectAnswer(){
        switch (m_correctAnswer){
            case 1:
                ((Button)m_ui.findViewById(R.id.button_answer1)).setBackgroundColor(getResources().getColor(R.color.correct));
                break;
            case 2:
                ((Button)m_ui.findViewById(R.id.button_answer2)).setBackgroundColor(getResources().getColor(R.color.correct));
                break;
            case 3:
                ((Button)m_ui.findViewById(R.id.button_answer3)).setBackgroundColor(getResources().getColor(R.color.correct));
                break;
            case 4:
                ((Button)m_ui.findViewById(R.id.button_answer4)).setBackgroundColor(getResources().getColor(R.color.correct));
                break;
        }
    }

    // disables all answer buttons (not clickable)
    private void disableAllAnswerButtons(){
        ((Button)m_ui.findViewById(R.id.button_answer1)).setClickable(false);
        ((Button)m_ui.findViewById(R.id.button_answer2)).setClickable(false);
        ((Button)m_ui.findViewById(R.id.button_answer3)).setClickable(false);
        ((Button)m_ui.findViewById(R.id.button_answer4)).setClickable(false);
    }

    // a messagebox is shown with the given string as "information"
    private void showMessagePopup(String title, String message){
        new AlertDialog.Builder(getContext())
                .setTitle(title)
                .setMessage(message)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setNeutralButton("ok", null).show();
    }

    @Override
    public String getExplanation() {
        return m_explanation;
    }

    @Override
    public String getHint() {
        return m_hint;
    }
}
