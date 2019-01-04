package android.samples.fietsveilig.challenges;

import android.os.Bundle;
import android.samples.fietsveilig.R;
import android.samples.fietsveilig.challenges.ChallengesExpandableListAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

public class ChallengesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View UI = inflater.inflate(R.layout.fragment_challenges, container, false);

        // connect expandable listview with it's adapter
        ExpandableListView challenges = (ExpandableListView)UI.findViewById(R.id.challenges_list);
        ChallengesExpandableListAdapter challengeAdapter = new ChallengesExpandableListAdapter(getContext());
        challenges.setAdapter(challengeAdapter);

        challenges.expandGroup(0); // expand daily challenges
        challenges.expandGroup(1); // expand weekly challenges

        return UI;
    }
}
