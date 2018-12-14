package android.samples.fietsveilig;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Vector;

public class ProfileFragment extends Fragment {
    private ViewPager m_pages;
    private PageAdapter m_pageAdapter;
    private TabLayout m_tabs;

    /**
     * This is called when the fragment is attached to activity and is called before onCreate()
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // get the page adapter that is going to provide the profile activity with its tab pages
        m_pageAdapter = new PageAdapter(((AppCompatActivity)context).getSupportFragmentManager());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View UI = inflater.inflate(R.layout.fragment_profile, container, false);

        // set m_pageAdapter as our viewPager's adapter
        m_pages = (ViewPager) UI.findViewById(R.id.pager);
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

    // ######################### PROGRESS FRAGMENT #########################
    public static class ProgressFragment extends Fragment{
        private static final String m_title = "Progress";

        /**
         * When fragment is being created
         */
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
        }

        /**
         * The progress fragment's UI
         */
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View progressContainer =  inflater.inflate(R.layout.fragment_profile_progress, container, false);

            // get the textViews
            TextView txtBeginner = (TextView) progressContainer.findViewById(R.id.textViewBeginnerPercentage);
            TextView txtIntermediate = (TextView) progressContainer.findViewById(R.id.textViewIntermediatePercentage);
            TextView txtAdvanced = (TextView) progressContainer.findViewById(R.id.textViewAdvancedPercentage);
            TextView txtOverall = (TextView) progressContainer.findViewById(R.id.textViewOverallPercentage);

            // get circular progress bars
            ProgressBar prgsBeginner = (ProgressBar) progressContainer.findViewById(R.id.progressBarBeginner);
            ProgressBar prgsIntermediate = (ProgressBar) progressContainer.findViewById(R.id.progressBarIntermediate);
            ProgressBar prgsAdvanced = (ProgressBar) progressContainer.findViewById(R.id.progressBarAdvanced);
            ProgressBar prgsOverall = (ProgressBar) progressContainer.findViewById(R.id.progressBarOverall);

            // update percentages
            txtBeginner.setText(prgsBeginner.getProgress() + "%");
            txtIntermediate.setText(prgsIntermediate.getProgress() + "%");
            txtAdvanced.setText(prgsAdvanced.getProgress() + "%");
            txtOverall.setText(prgsOverall.getProgress() + "%");

            return progressContainer;
        }

        public static String getTitle(){
            return m_title;
        }
    }

    // ######################### FRIENDS FRAGMENT #########################
    public static class FriendsFragment extends Fragment{
        private static final String m_title = "Friends";

        /**
         * When fragment is being created
         */
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
        }

        /**
         * The friend fragment's UI
         */
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View friendsContainer = inflater.inflate(R.layout.fragment_profile_friends, container, false);

            ListView lv = (ListView) friendsContainer.findViewById(R.id.friendsListView);
            FriendsViewAdapter friendsAdapter = new FriendsViewAdapter(getActivity(), android.R.layout.simple_list_item_1);
            lv.setAdapter(friendsAdapter);

            return friendsContainer;
        }

        public static String getTitle(){
            return m_title;
        }

        // this is the class that acts as an intermediate between the friends listview and the friends model
        public static class FriendsViewAdapter extends ArrayAdapter<String> {
            private Context m_context;
            private FriendsViewAdapter m_friendsAdapter = this;

            public FriendsViewAdapter(Context context, int resource) {
                super(context, resource);
                m_context= context;
            }

            public View getView(final int position, View convertView, ViewGroup parent){
                if (convertView == null){
                    LayoutInflater li = (LayoutInflater) m_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = li.inflate(R.layout.profile_friends_list_item, null);
                }

                // now find the textView, set its text and return the whole layout where it is situated
                final TextView txtHeader = (TextView) convertView.findViewById(R.id.friend_name);
                txtHeader.setText(FriendsModel.getFriend(position));

                // item gets deleted when corresponding delete button is clicked
                Button btnDelete = (Button) convertView.findViewById(R.id.deleteFriend);
                btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // delete button is clicked, now ask for a confirmation

                        new AlertDialog.Builder(m_context)
                                .setTitle("Confirmation")
                                .setMessage("Ben je zeker dat je " + FriendsModel.getFriend(position) + " van je vriendenlijst wilt verwijderen?")
                                .setIcon(android.R.drawable.ic_dialog_alert)

                                // when yes is clicked, the selected item is going to be deleted
                                .setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        FriendsModel.remove(position);
                                        m_friendsAdapter.notifyDataSetChanged();
                                    }
                                })

                                // do nothing when no is selected
                                .setNegativeButton("Nee", null).show();
                    }
                });

                return convertView;
            }

            public int getCount(){
                return FriendsModel.getCount();
            }

            public String getItem(int pos){
                return FriendsModel.getFriend(pos);
            }

            public boolean isEnabled(int position){
                return true;
            }
        }
    }

    // ######################### PAGE ADAPTER #########################
    /**
     * Contains the pages inside the profile activity the user can swipe:
     *      - page 1: progress
     *      - page 2: friends
     */
    class PageAdapter extends FragmentPagerAdapter {
        private Vector<Fragment> m_fragments = new Vector<>();
        private Vector<String> m_fragmentsTitles = new Vector<>();


        public PageAdapter(FragmentManager fm) {
            super(fm);
            m_fragments.add(new ProgressFragment());
            m_fragmentsTitles.add("Vooruitgang");

            m_fragments.add(new FriendsFragment());
            m_fragmentsTitles.add("Vrienden");
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
