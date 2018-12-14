package android.samples.fietsveilig;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

public class HelpFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View UI = inflater.inflate(R.layout.fragment_help, container, false);

        // connect help expandable listview with its adapter
        ExpandableListView helpList = (ExpandableListView) UI.findViewById(R.id.help_list);
        helpList.setAdapter(new HelpExpandableListAdapter(getContext()));

        return UI;
    }
}
