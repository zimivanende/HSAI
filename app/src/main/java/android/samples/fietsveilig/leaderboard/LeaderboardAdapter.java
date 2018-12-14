package android.samples.fietsveilig.leaderboard;

import android.content.Context;
import android.samples.fietsveilig.R;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder> {

    private ArrayList<String> m_images = new ArrayList<>();
    private ArrayList<String> m_usernames = new ArrayList<>();
    private ArrayList<String> m_ranks = new ArrayList<>();
    private ArrayList<String> m_scores = new ArrayList<>();
    private Context m_context;

    public LeaderboardAdapter(ArrayList<String> m_images, ArrayList<String> m_usernames, ArrayList<String> m_ranks, ArrayList<String> m_scores, Context m_context) {
        this.m_images = m_images;
        this.m_usernames = m_usernames;
        this.m_ranks = m_ranks;
        this.m_scores = m_scores;
        this.m_context = m_context;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class LeaderboardViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView m_score;
        public TextView m_username;
        public TextView m_rank;
        public RelativeLayout m_parentLayout;
        public CircleImageView m_image;
        public LeaderboardViewHolder(View leaderboardItem) {
            super(leaderboardItem);
            m_score = leaderboardItem.findViewById(R.id.user_score);
            m_username = leaderboardItem.findViewById(R.id.username);
            m_rank = leaderboardItem.findViewById(R.id.user_rank);
            m_parentLayout = leaderboardItem.findViewById(R.id.leaderboard_parentLayout);
            m_image = leaderboardItem.findViewById(R.id.profile_image);
        }
    }


    // Create new views (invoked by the layout manager)
    @Override
    public LeaderboardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.leaderboard_item2, parent, false);

        LeaderboardViewHolder vh = new LeaderboardViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(LeaderboardViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.m_username.setText(m_usernames.get(position));
        holder.m_rank.setText(m_ranks.get(position));
        holder.m_score.setText(m_scores.get(position));

        // TODO: add image loading
        holder.m_image.setImageResource(R.drawable.ic_person_black_24dp);

        holder.m_parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }

    @Override
    public int getItemCount() {
        return m_usernames.size();
    }
}
