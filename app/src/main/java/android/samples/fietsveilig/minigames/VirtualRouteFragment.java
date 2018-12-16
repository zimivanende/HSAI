package android.samples.fietsveilig.minigames;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.samples.fietsveilig.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VirtualRouteFragment extends Fragment {


    public VirtualRouteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_virtual_route, container, false);
    }

}
