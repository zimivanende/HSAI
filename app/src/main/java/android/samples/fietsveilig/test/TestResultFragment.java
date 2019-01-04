package android.samples.fietsveilig.test;

import android.content.Intent;
import android.os.Bundle;
import android.samples.fietsveilig.HomeFragment;
import android.samples.fietsveilig.MainActivity;
import android.samples.fietsveilig.R;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class TestResultFragment extends Fragment {
    private View m_ui;
    private int m_score = -1;
    private int m_maxScore = -1;
    private int m_xp = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m_ui = inflater.inflate(R.layout.fragment_test_result, container, false);

        Button btnHome = (Button)m_ui.findViewById(R.id.button_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent transfer = new Intent(getActivity(), MainActivity.class);
                startActivity(transfer);
            }
        });

        // set score text
        TextView txtScore = (TextView)m_ui.findViewById(R.id.textView_score);
        txtScore.setText(m_score + "/" + m_maxScore);

        // set xp text
        TextView txtXp = (TextView)m_ui.findViewById(R.id.textviewXp);
        txtXp.setText("Je hebt "+ m_xp + " xp verdiend.");

        return m_ui;
    }

    public void setScore(int score, int maxScore, int xp){
        m_score = score;
        m_maxScore = maxScore;
        m_xp = xp;
    }
}
