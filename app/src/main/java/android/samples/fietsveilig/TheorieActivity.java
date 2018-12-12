package android.samples.fietsveilig;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;

public class TheorieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theorie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("TheorieActivity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // connect expandable listview with it's adapter
        ExpandableListView theorie = (ExpandableListView)findViewById(R.id.theorie_list);
        TheorieExpandableListAdapter theorieAdapter = new TheorieExpandableListAdapter(this);
        theorie.setAdapter(theorieAdapter);

        theorie.expandGroup(0); // expand daily challenges
    }

}
