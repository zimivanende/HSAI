package android.samples.fietsveilig.minigames;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.samples.fietsveilig.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class SearchAndFindActivityFragment extends Fragment {

    public SearchAndFindActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_and_find2, container, false);
    }
}
