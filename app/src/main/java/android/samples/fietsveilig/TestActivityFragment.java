package android.samples.fietsveilig;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 *
 * This class is the superclass of the text fragments
 * Subclass this class, make a custom view for your subclass and implement the abstract functions.
 * If you're done with that, then you can add it in the TestActivity class
 *
 */
public abstract class TestActivityFragment extends Fragment {

    public TestActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    // The explanation of why the answer is correct or wrong
    abstract public String getExplanation();

    // Small explanation of what the user needs to do
    abstract public String getHint();

}

// mulptiple choice
// verkeersborden verbinden met text
// selecteren waar je mag oversteken
// vraag stellen en vragen van een nummber