package android.samples.fietsveilig.profile;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.support.design.widget.Snackbar;

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
        private static final String m_title = "Vooruitgang";

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

            // get circular progress bars
            ProgressBar prgsBeginner = (ProgressBar) progressContainer.findViewById(R.id.progressBarBeginner);
            ProgressBar prgsIntermediate = (ProgressBar) progressContainer.findViewById(R.id.progressBarIntermediate);
            ProgressBar prgsAdvanced = (ProgressBar) progressContainer.findViewById(R.id.progressBarAdvanced);
            ProgressBar prgsOverall = (ProgressBar) progressContainer.findViewById(R.id.progressBarOverall);

            // update percentages
            txtBeginner.setText(prgsBeginner.getProgress() + "%");
            txtIntermediate.setText(prgsIntermediate.getProgress() + "%");
            txtAdvanced.setText(prgsAdvanced.getProgress() + "%");

            return progressContainer;
        }

        public static String getTitle(){
            return m_title;
        }
    }

    // ######################### FRIENDS FRAGMENT #########################
    public static class FriendsFragment extends Fragment{
        private static final String m_title = "Friends";
        private static FriendsViewAdapter m_adapter;

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
            FriendsViewAdapter friendsAdapter = new FriendsViewAdapter(getActivity(), android.R.layout.simple_list_item_1, friendsContainer, this);
            lv.setAdapter(friendsAdapter);

            m_adapter = friendsAdapter;
            return friendsContainer;
        }

        public static String getTitle(){
            return m_title;
        }

        public static FriendsViewAdapter getAdapter(){ return m_adapter; }

        // this is the class that acts as an intermediate between the friends listview and the friends model
        public static class FriendsViewAdapter extends ArrayAdapter<String> {
            private Context m_context;
            private FriendsViewAdapter m_friendsAdapter = this;
            private View m_friendsUi;
            private Fragment m_friendsFragment;

            public FriendsViewAdapter(Context context, int resource, View friendsContainer, Fragment friendsFragment) {
                super(context, resource);
                m_context= context;
                m_friendsUi = friendsContainer;
                m_friendsFragment = friendsFragment;
            }

            public View getView(final int position, View convertView, ViewGroup parent){
                if (position == 0)
                    return getSearchBar(convertView);

                final int newPos = position - 1;

                if (convertView == null){
                    LayoutInflater li = (LayoutInflater) m_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = li.inflate(R.layout.profile_friends_list_item, null);
                }

                // now find the textView, set its text and return the whole layout where it is situated
                final TextView txtHeader = (TextView) convertView.findViewById(R.id.friend_name);
                txtHeader.setText(FriendsModel.getFriend(newPos));

                // item gets deleted when corresponding delete button is clicked
                Button btnDelete = (Button) convertView.findViewById(R.id.deleteFriend);
                btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // delete button is clicked, now ask for a confirmation

                        new AlertDialog.Builder(m_context)
                                .setTitle("Bevestiging")
                                .setMessage("Ben je zeker dat je " + FriendsModel.getFriend(newPos) + " van je vriendenlijst wilt verwijderen?")
                                .setIcon(android.R.drawable.ic_dialog_alert)

                                // when yes is clicked, the selected item is going to be deleted
                                .setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        FriendsModel.remove(newPos);
                                        m_friendsAdapter.notifyDataSetChanged();
                                    }
                                })

                                // do nothing when no is selected
                                .setNegativeButton("Nee", null).show();
                    }
                });

                return convertView;
            }

            private View getSearchBar(View convertView){
                if (convertView == null){
                    LayoutInflater li = (LayoutInflater) m_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = li.inflate(R.layout.profile_friends_list_add_friend_layout, null);
                }

                // get views
                final EditText input = (EditText) convertView.findViewById(R.id.editText_friend_name);
                final Button btnAddFriend = (Button) convertView.findViewById(R.id.button_add_friend);
                Button btnAddFriendConfirm = (Button) convertView.findViewById(R.id.button_add_friend_confirm);
                Button btnCancel = (Button) convertView.findViewById(R.id.button_cancel);
                final LinearLayout buttonsLayout = (LinearLayout) convertView.findViewById(R.id.layout_buttons);


                // attack click listeners
                // addfriend button makes the interface for input username visible
                btnAddFriend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // make all other elements visible
                        buttonsLayout.setVisibility(View.VISIBLE);
                        input.setVisibility(View.VISIBLE);

                        // make the button itself invisible
                        btnAddFriend.setVisibility(View.GONE);
                    }
                });

                // this button "sends a notification" to the user with the given username
                btnAddFriendConfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = input.getText().toString();
                        String msg;

                        if (!FriendsModel.isFriend(name) && FriendsModel.exists(name)){
                            FriendsModel.addNonFriendAsFriend(name);
                            notifyDataSetChanged();
                            input.setText("");
                            msg = name + " is nu je vriend.";
                        }
                        else{

                            if (FriendsModel.exists(name)){
                                // is already a friend
                                msg = name + " is al je vriend.";
                            }
                            else{
                                // doesn't exists
                                msg = "Er bestaat geen gebruiker met " + name + " als gebruikersnaam";
                            }
                        }
                        InputMethodManager inputManager = (InputMethodManager)  m_friendsFragment.getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

                        inputManager.hideSoftInputFromWindow(m_friendsFragment.getActivity().getCurrentFocus().getWindowToken(),
                                InputMethodManager.HIDE_NOT_ALWAYS);

                        Snackbar.make(m_friendsUi, msg, Snackbar.LENGTH_LONG)
                                .setAction("Ok", null)
                                .show();
                    }
                });

                // this buttons hides the element for input and submission and displays the initial button
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // make all other elements visible
                        buttonsLayout.setVisibility(View.GONE);
                        input.setVisibility(View.GONE);

                        // make the button itself invisible
                        btnAddFriend.setVisibility(View.VISIBLE);

                        // dont forget to clear out the text
                        input.setText("");
                    }
                });

                return convertView;
            }

            public int getCount(){
                return FriendsModel.getCount() + 1;
            }

            public String getItem(int pos){
                if (pos > 0)
                    return FriendsModel.getFriend(pos-1);
                else
                    return "";
            }

            public boolean isEnabled(int position){
                return true;
            }

            public FriendsViewAdapter getInstance(){ return this; }
        }
    }

    // ######################### FRIENDS FRAGMENT #########################
    //TODO this class crashes
    public static class RequestsFragment extends Fragment {
        private static final String m_title = "Verzoeken";

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
            View requestsContainer = inflater.inflate(R.layout.fragment_profile_requests, container, false);

            ListView lv = (ListView) requestsContainer.findViewById(R.id.requests_listView);
            RequestsViewAdapter requestsViewAdapter = new RequestsViewAdapter(getActivity(), android.R.layout.simple_list_item_1);
            lv.setAdapter(requestsViewAdapter);

            return requestsContainer;
        }

        public static String getTitle(){
            return m_title;
        }

        // this is the class that acts as an intermediate between the friends listview and the friends model
        public static class RequestsViewAdapter extends ArrayAdapter<String> {
            private Context m_context;
            private RequestsFragment.RequestsViewAdapter m_requestsAdapter = this;

            public RequestsViewAdapter(Context context, int resource) {
                super(context, resource);
                m_context= context;
            }

            public View getView(final int position, View convertView, ViewGroup parent){
                if (convertView == null){
                    LayoutInflater li = (LayoutInflater) m_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = li.inflate(R.layout.profile_requests_list_item, null);
                }

                // now find the textView and button, set its text and set the click listeners then
                // return the whole layout where it is situated
                TextView txtRequest = (TextView)convertView.findViewById(R.id.textview_request);
                Button btnAccept = (Button) convertView.findViewById(R.id.button_accept);
                Button btnReject = (Button) convertView.findViewById(R.id.button_reject);

                String text = RequestsModel.getRequest(position);

                txtRequest.setText(text);

                // accept friend
                btnAccept.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // delete button is clicked, now ask for a confirmation
                        FriendsModel.add(RequestsModel.getRequestSender(position)); // add to friends list
                        RequestsModel.remove(position); // remove from request
                        m_requestsAdapter.notifyDataSetChanged(); // notify requests view
                        FriendsFragment.getAdapter().notifyDataSetChanged(); // notify friends view
                    }
                });

                // reject user
                btnReject.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // delete button is clicked, now ask for a confirmation
                        RequestsModel.remove(position); // remove from request
                        m_requestsAdapter.notifyDataSetChanged(); // notify requests view
                    }
                });

                return convertView;
            }

            public int getCount(){
                return RequestsModel.getCount();
            }

            public String getItem(int pos){
                return FriendsModel.getFriend(pos);
            }

            public boolean isEnabled(int position){
                return true;
            }

            public RequestsViewAdapter getInstance(){ return this; }
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

            m_fragments.add(new RequestsFragment());
            m_fragmentsTitles.add("Verzoeken");
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
