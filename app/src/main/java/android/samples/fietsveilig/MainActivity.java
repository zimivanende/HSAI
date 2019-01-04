package android.samples.fietsveilig;

import android.samples.fietsveilig.challenges.ChallengesFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.samples.fietsveilig.leaderboard.LeaderboardFragment;
import android.samples.fietsveilig.profile.ProfileFragment;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout m_drawer;
    private boolean mHomeVisible = true;
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

        // if logged in as guest, disable leaderboard
        SharedPreferences sp = getSharedPreferences("login", MODE_PRIVATE);
        if (sp.getBoolean("isGuest", false)){
            NavigationView nv = (NavigationView) findViewById(R.id.nav_view);
            Menu menuNav = navigationView.getMenu();
            MenuItem nav_item2 = menuNav.findItem(R.id.nav_leaderboard);
            nav_item2.setEnabled(false);
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

    /**
     * When hardware backbutton is pressed the program opens the home fragment first before quiting the activity
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // if backbutton is pressed
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mHomeVisible == true) { // if home fragment is visible
                return super.onKeyDown(keyCode, event); // do whatever was done otherwise
            }
            else {
                // home is not visible, make home fragment visible
                setTitle("Home");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                mHomeVisible = true;
                return true; // event handled, return true so it won't be propagated further
            }
        }
        else
            return super.onKeyDown(keyCode, event); // do whatever was done otherwise
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch(menuItem.getItemId()){
            case R.id.nav_home:
                setTitle("Home");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment(), "Home").commit();
                mHomeVisible = true;
                break;
            case R.id.nav_profile:
                setTitle("Profiel");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
                mHomeVisible = false;
                break;
            case R.id.nav_leaderboard:
                setTitle("Scorebord");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LeaderboardFragment()).commit();
                mHomeVisible = false;
                break;
            case R.id.nav_challenges:
                setTitle("Uitdagingen");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChallengesFragment()).commit();
                mHomeVisible = false;
                break;
            case R.id.nav_help:
                setTitle("Help");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HelpFragment()).commit();
                mHomeVisible = false;
                break;
            case R.id.nav_collection:
                setTitle("Collectie");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CollectionFragment()).commit();
                mHomeVisible = false;
                break;
            case R.id.nav_logout:
                SharedPreferences sp = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("isLoggedIn", false);
                editor.putBoolean("isGuest", false);
                editor.apply();
                finish();
                Intent transfer = new Intent(this, LoginActivity.class);
                startActivity(transfer);
                mHomeVisible = false;
                break;
        }

        m_drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
