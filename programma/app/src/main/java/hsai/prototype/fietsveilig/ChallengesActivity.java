package hsai.prototype.fietsveilig;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.Vector;

public class ChallengesActivity extends FragmentActivity {
    private ViewPager m_pages;
    private TabLayout m_tabs;
    private PageAdapter m_pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);

        // connect tablayout and viewpager with the adapter
        m_pages = (ViewPager) findViewById(R.id.pager);
        m_tabs = (TabLayout) findViewById(R.id.tabLayout);
        m_pageAdapter = new PageAdapter(getSupportFragmentManager());

        m_pages.setAdapter(m_pageAdapter);
        m_tabs.setupWithViewPager(m_pages);
    }



    // ################################ PAGER ADAPTER AND FRAGMENTS ################################
    /**
     * Contains the pages inside the profile activity the user can swipe:
     *      - page 1: progress
     *      - page 2: friends
     */
    class PageAdapter extends FragmentPagerAdapter{
        private Vector<Fragment> m_fragments = new Vector<>();
        private Vector<String> m_fragmentsTitles = new Vector<>();


        public PageAdapter(FragmentManager fm) {
            super(fm);
            m_fragments.add(new ChallengeFragment());
            m_fragmentsTitles.add("Daily");

            m_fragments.add(new ChallengeFragment());
            m_fragmentsTitles.add("Weekly");

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
    // #############################################################################################
}
