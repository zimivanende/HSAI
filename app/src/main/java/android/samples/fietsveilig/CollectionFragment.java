package android.samples.fietsveilig;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class CollectionFragment extends Fragment {


    public CollectionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View UI = inflater.inflate(R.layout.fragment_collection, container, false);
        GridView gridview = (GridView) UI.findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(getContext()));
        // Inflate the layout for this fragment
        return UI;
    }

}
