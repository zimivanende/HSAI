package android.samples.fietsveilig;

import android.samples.fietsveilig.challenges.ChallengesFragment;
import android.samples.fietsveilig.leaderboard.LeaderboardFragment;
import android.samples.fietsveilig.profile.ProfileFragment;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout m_drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        m_drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // gives extra information about certain drawer operations
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, m_drawer, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        m_drawer.addDrawerListener(toggle);
        toggle.syncState();

        // start with home fragment
        if (savedInstanceState == null) { // if activity created for the first time
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
            setTitle("Home");
        }
    }

    // don't leave activity when back button is closed if drawer is open!
    @Override
    public void onBackPressed(){
        // if drawer is open, close it
        if (m_drawer.isDrawerOpen(GravityCompat.START)){
            m_drawer.closeDrawer(GravityCompat.START);
        }
        else
            super.onBackPressed(); // if the drawer was not open then call the original onBackPressed() method
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch(menuItem.getItemId()){
            case R.id.nav_home:
                setTitle("Home");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                break;
            case R.id.nav_profile:
                setTitle("Profiel");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
                break;
            case R.id.nav_leaderboard:
                setTitle("Scorebord");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LeaderboardFragment()).commit();
                break;
            case R.id.nav_challenges:
                setTitle("Uitdagingen");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChallengesFragment()).commit();
                break;
            case R.id.nav_help:
                setTitle("Help");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HelpFragment()).commit();
                break;

        }

        m_drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
