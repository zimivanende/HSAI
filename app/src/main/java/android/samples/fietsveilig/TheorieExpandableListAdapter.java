package android.samples.fietsveilig;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

public class TheorieExpandableListAdapter extends BaseExpandableListAdapter {
    private String[] m_title = new String[]
            {       "Oversteken",
                    "Regels bij het fietsen",
                    "Soorten fietspaden",
                    "Technische eisen",
                    "Verkeersborden",
                    "Verlichting",
                    "Voorrang van rechts"
            };
    private Vector<Vector<String>> m_eisen = TheorieModel.getEisen();
    private Vector<Vector<String>> m_paden = TheorieModel.getPaden();
    private Vector<Vector<String>> m_regels = TheorieModel.getRegels();
    private Vector<Vector<String>> m_lichten = TheorieModel.getLichten();
    private Vector<Vector<String>> m_borden = TheorieModel.getBorden();
    private Vector<Vector<String>> m_voorrang = TheorieModel.getVoorrang();
    private Vector<Vector<String>> m_oversteken = TheorieModel.getOversteken();
    private Context m_context;

    public TheorieExpandableListAdapter(Context context) {
        m_context = context;
    }

    @Override
    public int getGroupCount() {
        return m_title.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (groupPosition == 0)
            return m_oversteken.size();
        else if (groupPosition == 1)
            return m_regels.size();
        else if (groupPosition == 2)
            return m_paden.size();
        else if (groupPosition == 3)
            return m_eisen.size();
        else if (groupPosition == 4)
            return m_borden.size();
        else if (groupPosition == 5)
            return m_lichten.size();
        else if (groupPosition == 6)
            return m_voorrang.size();
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
            return m_oversteken.get(childPosition);
        else if (groupPosition == 1)
            return m_regels.get(childPosition);
        else if (groupPosition == 2)
            return m_paden.get(childPosition);
        else if (groupPosition == 3)
            return m_eisen.get(childPosition);
        else if (groupPosition == 4)
            return m_borden.get(childPosition);
        else if (groupPosition == 5)
            return m_lichten.get(childPosition);
        else if (groupPosition == 6)
            return m_voorrang.get(childPosition);
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

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        // find header text
        String headerText = m_title[groupPosition];

        // try to find the TextView of the corresponding Header
        // convertView is where the header ui item is located, if the convertView is null, find it (the whole layout)
        if (convertView == null){
            LayoutInflater li = (LayoutInflater) m_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // what inflate does is maybe take the given layout, copy it and return it, so you can reuse the same layout
            convertView = li.inflate(R.layout.theorie_header_layout, null);
        }

        // now find the textView, set its text and return the whole layout where it is situated
        TextView txtHeader = (TextView) convertView.findViewById(R.id.theorie_header);
        txtHeader.setText(headerText);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Vector<String> childText = null;

        // find header text
        if (groupPosition == 0)
            childText =  m_oversteken.get(childPosition);
        else if (groupPosition == 1)
            childText = m_regels.get(childPosition);
        else if (groupPosition == 2)
            childText = m_paden.get(childPosition);
        else if (groupPosition == 3)
            childText = m_eisen.get(childPosition);
        else if (groupPosition == 4)
            childText = m_borden.get(childPosition);
        else if (groupPosition == 5)
            childText = m_lichten.get(childPosition);
        else if (groupPosition == 6)
            childText = m_voorrang.get(childPosition);

        // try to find the TextView of the corresponding Header
        // convertView is where the header ui item is located, if the convertView is null, find it (the whole layout)
        if (convertView == null){
            LayoutInflater li = (LayoutInflater) m_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // what inflate does is maybe take the given layout, copy it and return it, so you can reuse the same layout
            convertView = li.inflate(R.layout.theorie_child_item_layout, null);
        }

        // now find the textView, set its text and return the whole layout where it is situated
        TextView txtHeader = (TextView) convertView.findViewById(R.id.theorie_item);
        txtHeader.setText(childText.get(0));





        ImageView imageview = (ImageView) convertView.findViewById(R.id.theorie_image);
        imageview.setImageResource(Integer.parseInt(childText.get(1)));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
