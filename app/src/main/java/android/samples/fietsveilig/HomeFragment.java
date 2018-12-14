package android.samples.fietsveilig;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.zip.Inflater;

public class HomeFragment extends Fragment {
    private Button study_button;
    private Button test_button;
    private Button minigames_button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container, false);
        study_button =(Button)view.findViewById(R.id.buttonStudy);
        study_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent transfer = new Intent(getActivity(), TheorieActivity.class);
                startActivity(transfer);
            }
        });
        test_button =(Button)view.findViewById(R.id.buttonTest);
        test_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent transfer = new Intent(getActivity(), TestActivity.class);
                startActivity(transfer);
            }
        });
        minigames_button =(Button)view.findViewById(R.id.buttonMinigames);
        minigames_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent transfer = new Intent(getActivity(), MiniGamesActivity.class);
                startActivity(transfer);
            }
        });
        return view;
    }
}
