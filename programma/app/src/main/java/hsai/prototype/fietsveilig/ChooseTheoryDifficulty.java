package hsai.prototype.fietsveilig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseTheoryDifficulty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_theory_difficulty);
        init();
    }

    private Button m_beginnerButton;
    private Button m_intermediateButton;
    private Button m_expertButton;


    public void init() {
        m_beginnerButton = findViewById(R.id.beginner_button);
        m_intermediateButton = findViewById(R.id.intermediate_button);
        m_expertButton = findViewById(R.id.expert_button);
        addListenerToButton(m_beginnerButton);
        addListenerToButton(m_intermediateButton);
        addListenerToButton(m_expertButton);

    }
    private void addListenerToButton(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseTheoryDifficulty.this, TheoryScreen.class));
            }
        });
    }
}
