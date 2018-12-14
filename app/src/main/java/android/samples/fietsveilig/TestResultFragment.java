package android.samples.fietsveilig;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class TestResultFragment extends Fragment {
    private View m_ui;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m_ui = inflater.inflate(R.layout.fragment_test_result, container, false);

        Button btnHome = (Button)m_ui.findViewById(R.id.button_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: listener that brings user to homescreen
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            }
        });

        return m_ui;
    }

    public void setScore(int score){
        TextView txtScore = (TextView)m_ui.findViewById(R.id.textView_score);
        txtScore.setText(score + "/10");
    }
}
