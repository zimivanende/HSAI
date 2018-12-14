package android.samples.fietsveilig;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.Vector;

public class HelpExpandableListAdapter extends BaseExpandableListAdapter {
    private Vector<Pair<String, String>> m_data = HelpModel.getHelpData();
    private Context m_context;

    public HelpExpandableListAdapter(Context context) {
        this.m_context = context;
    }

    @Override
    public int getGroupCount() {
        return m_data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return m_data.get(groupPosition).first;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return m_data.get(groupPosition).second;
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

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        // if header view object is not created yet
        if (convertView == null){
            LayoutInflater li = (LayoutInflater) m_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.help_expandable_list_header_item, null);
        }

        // set label text
        TextView labelExplanation = (TextView) convertView.findViewById(R.id.help_header_item);
        labelExplanation.setText(m_data.get(groupPosition).first);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        // if child view object is not created yet
        if (convertView == null){
            LayoutInflater li = (LayoutInflater) m_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.help_expandable_list_child_item, null);
        }

        // set label text
        TextView labelExplanation = (TextView) convertView.findViewById(R.id.help_child_item);
        labelExplanation.setText(m_data.get(groupPosition).second);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
