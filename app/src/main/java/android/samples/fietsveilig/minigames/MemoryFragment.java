package android.samples.fietsveilig.minigames;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.samples.fietsveilig.R;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MemoryFragment extends Fragment {


    public MemoryFragment() {
        // Required empty public constructor
    }
    private TextView m_score, m_turns;
    private ImageView m_iv_11, m_iv_12,m_iv_13, m_iv_14, m_iv_21, m_iv_22,
            m_iv_23, m_iv_24, m_iv_31, m_iv_32, m_iv_33, m_iv_34;

    private int m_im_101, m_im_102, m_im_103, m_im_104, m_im_105, m_im_106,
            m_im_201, m_im_202, m_im_203, m_im_204, m_im_205, m_im_206;

    private int m_cardOne, m_cardTwo;

    private int m_clickedFirst, m_clickedSecond;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_memory, container, false);
    }

}
