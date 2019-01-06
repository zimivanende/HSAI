package android.samples.fietsveilig.minigames;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.samples.fietsveilig.R;
import android.widget.Button;
import android.widget.TextView;

public class SearchAndFindInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_and_find_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Zoek de verkeersborden");
        Button startSearchAndFindButton = findViewById(R.id.start_search_and_find);
        setInfoText();
        startSearchAndFindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSearchAndFindGame();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void startSearchAndFindGame() {
        Intent transfer = new Intent(this, SearchAndFindActivity.class);
        startActivity(transfer);
    }
    private void setInfoText() {
        TextView safInfo = findViewById(R.id.search_and_find_info);
        safInfo.setText(R.string.search_and_find_info_text);
    }

}
