package android.samples.fietsveilig;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class NumberInputFragment extends TestActivityFragment {
    private String m_hint;
    private String m_explanation;
    private int m_correctAnswer;
    private View m_ui;
    private int m_min = 0;
    private int m_max = 10;
    private int m_score = 0;

    @Override
    public int getScore() {
        return m_score;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO find a way to set hint and explanation
        // TODO find a way to set m_correctAnswer
        View UI = inflater.inflate(R.layout.fragment_test_number_input, container, false);
        m_ui = UI;

        initButtons();

        // just for test
        m_hint = "choose one of the answers below";
        m_explanation = "bla bla bla";
        m_correctAnswer = 2;

        return UI;
    }

    /**
     * All onlick listeners are set
     */
    private void initButtons(){
        // set onclick listeners
        final Button buttonNext = (Button)m_ui.findViewById(R.id.button_next);
        final Button buttonSubmit = (Button)m_ui.findViewById(R.id.button_submit);
        final Button buttonHint = (Button)m_ui.findViewById(R.id.button_hint);
        final Button buttonExplanation = (Button)m_ui.findViewById(R.id.button_explanation);
        final Button buttonIncrement = (Button)m_ui.findViewById(R.id.button_increment);
        final Button buttonDecrement = (Button)m_ui.findViewById(R.id.button_decrement);
        final TextView textview_number = (TextView)m_ui.findViewById(R.id.textview_number);
        final TextView lblFeedback = (TextView)m_ui.findViewById(R.id.label_feedback);

        // increment and decrement buttons
        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val = Integer.parseInt(textview_number.getText().toString());
                if (val < m_max){
                    textview_number.setText(String.valueOf(val+1));
                }
            }
        });

        buttonDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val = Integer.parseInt(textview_number.getText().toString());
                if (val > m_min){
                    textview_number.setText(String.valueOf(val-1));
                }
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

        // when the submit button is clicked, feedback is given
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val = Integer.parseInt(textview_number.getText().toString());
                if (val == m_correctAnswer){
                    m_score = 1;
                    lblFeedback.setText("Correct!");
                    lblFeedback.setTextColor(getResources().getColor(R.color.correct));
                }
                else{
                    lblFeedback.setText("Fout! Het juiste antwoord was " + m_correctAnswer);
                    lblFeedback.setTextColor(getResources().getColor(R.color.incorrect));
                }
                buttonDecrement.setEnabled(false); // disable increment and decrement buttons
                buttonIncrement.setEnabled(false);
                buttonSubmit.setVisibility(View.GONE); // submit button gets replaced by "next" button
                buttonNext.setVisibility(View.VISIBLE); // button next becomes visible
                buttonHint.setVisibility(View.INVISIBLE); // the hint button gets invisible
                buttonExplanation.setVisibility(View.VISIBLE); // explanation button gets visible
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
