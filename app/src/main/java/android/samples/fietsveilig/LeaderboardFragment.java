package android.samples.fietsveilig;

import android.os.Bundle;
import android.samples.fietsveilig.leaderboard.LeaderboardAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class LeaderboardFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View UI = inflater.inflate(R.layout.fragment_leaderboard, container, false);
        m_leaderboardView = UI.findViewById(R.id.leaderboard);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        m_leaderboardView.setHasFixedSize(true);

        // use a linear layout manager
        m_leaderboardLayoutManager = new LinearLayoutManager(UI.getContext());
        m_leaderboardView.setLayoutManager(m_leaderboardLayoutManager);

        // specify an adapter (see also next example)
        ArrayList<String> ranks = new ArrayList<>();
        ranks.add("1");
        ranks.add("2");
        ranks.add("3");
        ranks.add("4");
        ranks.add("5");
        ranks.add("6");
        ranks.add("7");
        ranks.add("8");
        ArrayList<String> usernames = new ArrayList<>();
        usernames.add("Jari1");
        usernames.add("Jari2");
        usernames.add("Jari3");
        usernames.add("Jari4");
        usernames.add("Jari5");
        usernames.add("Jari6");
        usernames.add("Jari7");
        usernames.add("Jari8");
        ArrayList<String> images = new ArrayList<>();
        ArrayList<String> scores = new ArrayList<>();
        scores.add("10000");
        scores.add("2000");
        scores.add("300");
        scores.add("240");
        scores.add("150");
        scores.add("60");
        scores.add("27");
        scores.add("18");

        m_leaderboardAdapter = new LeaderboardAdapter(images, usernames, ranks, scores, UI.getContext());
        m_leaderboardView.setAdapter(m_leaderboardAdapter);
        return UI;
    }

    private RecyclerView m_leaderboardView;
    private RecyclerView.Adapter m_leaderboardAdapter;
    private RecyclerView.LayoutManager m_leaderboardLayoutManager;
}
