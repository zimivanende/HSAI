package hsai.prototype.fietsveilig;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class LeaderboardActivity extends AppCompatActivity {

    private RecyclerView m_leaderboardView;
    private RecyclerView.Adapter m_leaderboardAdapter;
    private RecyclerView.LayoutManager m_leaderboardLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        m_leaderboardView = findViewById(R.id.leaderboard);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        m_leaderboardView.setHasFixedSize(true);

        // use a linear layout manager
        m_leaderboardLayoutManager = new LinearLayoutManager(this);
        m_leaderboardView.setLayoutManager(m_leaderboardLayoutManager);

        // specify an adapter (see also next example)
        String[] data = new String[10];
        data[0] = "Zimi";
        data[1] = "Jari";
        data[2] = "Enes";
        data[3] = "Joey";
        data[4] = "Arthur";
        data[5] = "Louis";
        data[6] = "Ella";
        data[7] = "Amber";
        m_leaderboardAdapter = new LeaderboardAdapter(data);
        m_leaderboardView.setAdapter(m_leaderboardAdapter);
    }
}
