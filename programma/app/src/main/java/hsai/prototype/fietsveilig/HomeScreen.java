package hsai.prototype.fietsveilig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        init();
    }
    public Button m_button;

    public void init() {
       m_button = findViewById(R.id.button);

       m_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(HomeScreen.this, ChooseTheoryDifficulty.class));
           }
       });


    }

}
