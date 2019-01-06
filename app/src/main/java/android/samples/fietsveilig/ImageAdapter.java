package android.samples.fietsveilig;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessagePopup(position);
            }
        });

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    private void showMessagePopup(int pos){
        new AlertDialog.Builder(this)
                .setTitle("Info")
                .setMessage(mMessages[pos])
                .setIcon(android.R.drawable.ic_dialog_info)
                .setNeutralButton("ok", null).show();
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.borden, R.drawable.borden2,
            R.drawable.borden3, R.drawable.borden4,
            R.drawable.borden5, R.drawable.borden6,
            R.drawable.borden8, R.drawable.borden9,
            R.drawable.borden10, R.drawable.borden11,
            R.drawable.borden12
    };

    private String[] mMessages = {
            "Begin verplicht fietspad", "Einde verplicht fietspad", "Begin onverplicht fietspad",
            "Einde onverplicht fietspad", "Parkeerplaats fietsers en brommers",
            "LET OP! Recht doorgaande fietsers in twee richtingen", "Verplicht fietspad met tegenliggers",
            "Uitgezonderd fietsers", "Begin van een voetgangerszone",
            "Einde van een voetgangerszone", "Doodlopende weg met doorgang voor fietsers en voetgangers",
            ""
    };

}