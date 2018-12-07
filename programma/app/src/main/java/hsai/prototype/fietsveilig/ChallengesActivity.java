package hsai.prototype.fietsveilig;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toolbar;

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
    }
}
