package hsai.prototype.fietsveilig;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

public class ChallengesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);
        setTitle("Challenges");

        // connect expandable listview with it's adapter
        ExpandableListView challenges = (ExpandableListView)findViewById(R.id.challenges_list);
        ChallengesExpandableListAdapter challengeAdapter = new ChallengesExpandableListAdapter(this);
        challenges.setAdapter(challengeAdapter);

        challenges.expandGroup(0); // expand daily challenges


        // add hamburger menu
        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
         */
    }
}
