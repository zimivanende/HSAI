package android.samples.fietsveilig.leaderboard;

import android.content.Context;
import android.os.Bundle;
import android.samples.fietsveilig.R;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Vector;

public class LeaderboardFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // get the page adapter that is going to provide the profile activity with its tab pages
        m_pageAdapter = new PageAdapter(((AppCompatActivity)context).getSupportFragmentManager());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View UI = inflater.inflate(R.layout.fragment_leaderboard, container, false);
        // set m_pageAdapter as our viewPager's adapter
        m_pages = (ViewPager) UI.findViewById(R.id.leaderboard_pager);
        m_pages.setAdapter(m_pageAdapter); // now the adapter is going to provide the pages to the view

        // add tabs
        m_tabs = (TabLayout) UI.findViewById(R.id.tabLayout);
        m_tabs.setupWithViewPager(m_pages);

        // tab click listener for navigating on tab click
        m_tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // move to page corresponding with clicked tab
                m_pages.setCurrentItem(tab.getPosition());
            }

            // we don't need these
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        // return the fragments' view
        return UI;
    }

    private ViewPager m_pages;
    private PageAdapter m_pageAdapter;
    private TabLayout m_tabs;
    private RecyclerView m_leaderboardView;
    private RecyclerView.Adapter m_leaderboardAdapter;
    private RecyclerView.LayoutManager m_leaderboardLayoutManager;




    // ######################### LEADERBOAR-TAB FRAGMENT #########################

    public static class LeaderboardTabFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View UI = inflater.inflate(R.layout.fragment_leaderboard_tab, container, false);
            m_leaderboardView = UI.findViewById(R.id.leaderboard);
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            m_leaderboardView.setHasFixedSize(true);

            // use a linear layout manager
            m_leaderboardLayoutManager = new LinearLayoutManager(UI.getContext());
            m_leaderboardView.setLayoutManager(m_leaderboardLayoutManager);

            // specify an adapter (see also next example)
            ArrayList<String> ranks = new ArrayList<>();
            ranks.add("1");
            ranks.add("2");
            ranks.add("3");
            ranks.add("4");
            ranks.add("5");
            ranks.add("6");
            ranks.add("7");
            ranks.add("8");
            ranks.add("9");
            ArrayList<String> usernames = new ArrayList<>();
            usernames.add("Gert");
            usernames.add("Davy");
            usernames.add("Edgar");
            usernames.add("Cindy");
            usernames.add("Joe");
            usernames.add("Klara");
            usernames.add("Mechiel");
            usernames.add("Jan");
            usernames.add("Thijs");
            ArrayList<String> images = new ArrayList<>();
            ArrayList<String> scores = new ArrayList<>();
            scores.add("98");
            scores.add("85");
            scores.add("76");
            scores.add("68");
            scores.add("54");
            scores.add("46");
            scores.add("39");
            scores.add("31");
            scores.add("25");

            m_leaderboardAdapter = new LeaderboardAdapter(images, usernames, ranks, scores, UI.getContext());
            m_leaderboardView.setAdapter(m_leaderboardAdapter);
            return UI;
        }

        private RecyclerView m_leaderboardView;
        private RecyclerView.Adapter m_leaderboardAdapter;
        private RecyclerView.LayoutManager m_leaderboardLayoutManager;
    }

    // ######################### PAGE ADAPTER ########################

    private class PageAdapter extends FragmentPagerAdapter {
        private Vector<Fragment> m_fragments = new Vector<>();
        private Vector<String> m_fragmentsTitles = new Vector<>();


        public PageAdapter(FragmentManager fm) {
            super(fm);

            m_fragments.add(new LeaderboardTabFragment());
            m_fragmentsTitles.add("Memory");

            m_fragments.add(new LeaderboardTabFragment());
            m_fragmentsTitles.add("Zoek");

            m_fragments.add(new LeaderboardTabFragment());
            m_fragmentsTitles.add("Route");


        }

        @Override
        public Fragment getItem(int i) {
            return m_fragments.get(i);
        }

        @Override
        public int getCount() {
            return m_fragments.size();
        }

        public CharSequence getPageTitle(int position){
            return m_fragmentsTitles.get(position);
        }
    }
}