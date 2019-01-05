package android.samples.fietsveilig.minigames;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.samples.fietsveilig.R;
import android.widget.Button;
import android.widget.TextView;

public class MemoryInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Memory");
        Button startMemoryButton = findViewById(R.id.start_memory);
        setInfoText();
        startMemoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMemoryGame();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void startMemoryGame() {
        Intent transfer = new Intent(this, MemoryActivity.class);
        startActivity(transfer);
    }
    private void setInfoText() {
        TextView memInfo = findViewById(R.id.memory_info);
        memInfo.setText(R.string.memory_info_text);
    }

}
