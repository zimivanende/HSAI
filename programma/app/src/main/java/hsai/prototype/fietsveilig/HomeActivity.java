package hsai.prototype.fietsveilig;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        init();
    }

    public Button m_button;

    public void init() {
        m_button = findViewById(R.id.button4);

        m_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent transfer = new Intent(HomeActivity.this, HomeScreen.class);
                startActivity(transfer);
            }
        });

        // go to profile activity when profile picture in hamburger menu is tapped
        ImageView profilePic = findViewById(R.id.nav_header_profile_image);
        profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent transfer = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(transfer);
            }
        });
    }


        @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        init();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent transfer = null;

        if (id == R.id.nav_challenges) {
            transfer = new Intent(HomeActivity.this, ChallengesActivity.class);
        } else if (id == R.id.nav_help) {
            transfer = new Intent(HomeActivity.this, HelpActivity.class);
        } else if (id == R.id.nav_leaderboard) {
            transfer = new Intent(HomeActivity.this, LeaderboardActivity.class);
        } else if (id == R.id.nav_home) {
            transfer = new Intent(HomeActivity.this, HomeActivity.class);
        } else if (id == R.id.nav_minigames) {
            transfer = new Intent(HomeActivity.this, MiniGamesActivity.class);
        } else if (id == R.id.nav_settings) {
            transfer = new Intent(HomeActivity.this, SettingsActivity.class);
        }

        startActivity(transfer);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
