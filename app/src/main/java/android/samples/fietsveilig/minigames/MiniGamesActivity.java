package android.samples.fietsveilig.minigames;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.samples.fietsveilig.R;
import android.samples.fietsveilig.TheorieActivity;
import android.samples.fietsveilig.test.TestActivity;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.Vector;

import static android.support.constraint.Constraints.TAG;

public class MiniGamesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_games);
        Button memory_button =(Button) findViewById(R.id.button_memory);
        memory_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMemoryFragment();
            }
        });

        Button searchFind_button =(Button) findViewById(R.id.button_search_and_find);
        searchFind_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSearchAndFindFragment();
            }
        });
        Button virtualRoute_button =(Button) findViewById(R.id.button_virtual_route);
        virtualRoute_button.setEnabled(true);
        virtualRoute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVirtualRouteFragment();
            }
        });
    }
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
            Log.d(TAG, "No camera available");
        }
        return c; // returns null if camera is unavailable
    }

    private void startMemoryFragment() {
        Intent transfer = new Intent(this, MemoryActivity.class);
        startActivity(transfer);
    }

    private void startSearchAndFindFragment() {
        Camera cam = getCameraInstance();
        if (cam != null) {
            Intent transfer = new Intent(this, SearchAndFindActivity.class);
            startActivity(transfer);
        }
        else {
            Toast.makeText(this, "de camera is nodig voor deze minigame maar deze is niet beschikbaar, je kan de verzamelde verkeersborden ook in je collectie terugvinden in het menu",
                    Toast.LENGTH_LONG).show();
        }

    }

    private void startVirtualRouteFragment() {
        Toast.makeText(this, "Je hebt niet de juiste status om deze minigame vrij te spelen, dit gebeurt pas als je de status 'Expert' hebt. Blijf oefenen",
                Toast.LENGTH_LONG).show();
    }
}
