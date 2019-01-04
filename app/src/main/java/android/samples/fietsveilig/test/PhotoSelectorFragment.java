package android.samples.fietsveilig.test;

import android.app.AlertDialog;
import android.os.Bundle;
import android.samples.fietsveilig.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PhotoSelectorFragment extends TestActivityFragment {
    public void setM_hint(String m_hint) {
        this.m_hint = m_hint;
    }

    private String mTxtProgress = null;
    private String m_hint;
    private String m_explanation;
    private int m_correctAnswer = 1;
    private View m_ui;
    private int m_score = 0;
    private int[] m_answers = new int[3];
    private String m_question = "question";
    private boolean mHintUsed = false;

    @Override
    public boolean hintUsed() {
        return mHintUsed;
    }

    @Override
    public void setProgress(String progress) {
        mTxtProgress = progress;
    }

    @Override
    public int getScore() {
        return m_score;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View UI = inflater.inflate(R.layout.fragment_test_photo_selector, container, false);
        m_ui = UI;

        // set the text of the view elements
        ((ImageView)m_ui.findViewById(R.id.image_answer1)).setImageResource(m_answers[0]);
        ((ImageView)m_ui.findViewById(R.id.image_answer2)).setImageResource(m_answers[1]);
        ((ImageView)m_ui.findViewById(R.id.image_answer3)).setImageResource(m_answers[2]);
        ((TextView)m_ui.findViewById(R.id.text_view_question)).setText(m_question);
        ((TextView)m_ui.findViewById(R.id.textviewProgress)).setText(mTxtProgress);

        initButtons();

        return UI;
    }

    /**
     * Sets the explanation shown by the fragment
     * @param explanation
     */
    public void setExplanation(String explanation){
        m_explanation = explanation;
    }

    /**
     * Sets the first answer the user can select
     * @param answer1
     */
    public void setAnswer1(int answer1){
        m_answers[0] = answer1;
    }

    /**
     * Sets the first answer the user can select
     * @param answer2
     */
    public void setAnswer2(int answer2){
        m_answers[1] = answer2;
    }

    /**
     * Sets the first answer the user can select
     * @param answer3
     */
    public void setAnswer3(int answer3){
        m_answers[2] = answer3;
    }

    /**
     * Sets the first answer the user can select
     * @param question
     */
    public void setQuestion(String question){
        m_question = question;
    }

    /**
     * Sets the number of the correct answer
     * @param correctAnswer: the number of the answer that is correct
     */
    public void setCorrectAnswer(int correctAnswer){
        m_correctAnswer = correctAnswer;
    }


    /**
     * All onlick listeners are set
     */
    private void initButtons(){
        // set onclick listeners
        final ImageView button1 = (ImageView)m_ui.findViewById(R.id.image_answer1);
        final ImageView button2 = (ImageView)m_ui.findViewById(R.id.image_answer2);
        final ImageView button3 = (ImageView)m_ui.findViewById(R.id.image_answer3);
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
                else
                    m_score = 1;
                setAfterAnswerUI();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (m_correctAnswer != 2){
                    button2.setBackgroundColor(getResources().getColor(R.color.incorrect));
                }
                else
                    m_score = 1;
                setAfterAnswerUI();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (m_correctAnswer != 3){
                    button3.setBackgroundColor(getResources().getColor(R.color.incorrect));
                }
                else
                    m_score = 1;
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
                mHintUsed = true;
            }
        });

        // when the "next" button is clicked, the next fragment is going to be opened
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TestActivity)getActivity()).setNextTestActivity();
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
                ((ImageView)m_ui.findViewById(R.id.image_answer1)).setBackgroundColor(getResources().getColor(R.color.correct));
                break;
            case 2:
                ((ImageView)m_ui.findViewById(R.id.image_answer2)).setBackgroundColor(getResources().getColor(R.color.correct));
                break;
            case 3:
                ((ImageView)m_ui.findViewById(R.id.image_answer3)).setBackgroundColor(getResources().getColor(R.color.correct));
                break;
        }
    }

    // disables all answer buttons (not clickable)
    private void disableAllAnswerButtons(){
        ((ImageView)m_ui.findViewById(R.id.image_answer1)).setClickable(false);
        ((ImageView)m_ui.findViewById(R.id.image_answer2)).setClickable(false);
        ((ImageView)m_ui.findViewById(R.id.image_answer3)).setClickable(false);
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
