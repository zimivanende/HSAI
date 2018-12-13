package android.samples.fietsveilig;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

//TODO: use ic_info_outline_black as button for information about the current test (question)

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // for test only
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MultipleChoiceFragment()).commit();

    }

    private void showMessagePopup(String message){
        new AlertDialog.Builder(this)
                .setTitle("Explanation")
                .setMessage(message)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setNeutralButton("ok", null).show();
    }

}
