package android.samples.fietsveilig;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.Vector;

public class ChallengesExpandableListAdapter extends BaseExpandableListAdapter {
    private String[] m_title = new String[]{"Daily", "Weekly"};
    private Vector<String> m_daily = ChallengesModel.getDailyChallenges();
    private Vector<String> m_weekly = ChallengesModel.getWeeklyChallenges();
    private Context m_context;

    public ChallengesExpandableListAdapter(Context context) {
        m_context = context;
    }

    @Override
    public int getGroupCount() {
        return m_title.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (groupPosition == 0)
            return m_daily.size();
        else if (groupPosition == 1)
            return m_weekly.size();
        else
            return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return m_title[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        if (groupPosition == 0)
            return m_daily.get(childPosition);
        else if (groupPosition == 1)
            return m_weekly.get(childPosition);
        else
            return "";
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override// TODO
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        // find header text
        String headerText = m_title[groupPosition];

        // try to find the TextView of the corresponding Header
        // convertView is where the header ui item is located, if the convertView is null, find it (the whole layout)
        if (convertView == null){
            LayoutInflater li = (LayoutInflater) m_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // what inflate does is maybe take the given layout, copy it and return it, so you can reuse the same layout
            convertView = li.inflate(R.layout.challenges_expandable_list_header_item, null);
        }

        // now find the textView, set its text and return the whole layout where it is situated
        TextView txtHeader = (TextView) convertView.findViewById(R.id.challenge_header);
        txtHeader.setText(headerText);
        return convertView;
    }

    @Override// TODO
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childText = "X";

        // find header text
        if (groupPosition == 0){
            childText = m_daily.get(childPosition);
        }
        else if (groupPosition == 1)
            childText = m_weekly.get(childPosition);

        // try to find the TextView of the corresponding Header
        // convertView is where the header ui item is located, if the convertView is null, find it (the whole layout)
        if (convertView == null){
            LayoutInflater li = (LayoutInflater) m_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // what inflate does is maybe take the given layout, copy it and return it, so you can reuse the same layout
            convertView = li.inflate(R.layout.challenges_expandable_list_child_item, null);
        }

        // now find the textView, set its text and return the whole layout where it is situated
        TextView txtHeader = (TextView) convertView.findViewById(R.id.challenge_item);
        txtHeader.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
