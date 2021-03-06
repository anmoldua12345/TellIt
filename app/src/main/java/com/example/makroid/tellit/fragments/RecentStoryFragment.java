package com.example.makroid.tellit.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.makroid.tellit.R;
import com.example.makroid.tellit.RecyclerAdapter;
import com.example.makroid.tellit.RecyclerSpace;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class RecentStoryFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    static boolean isPortrait = false;

    @Nullable
    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    @Nullable
    @BindView(R.id.drecycler)
    RecyclerView mRecyclerView;

    RecyclerAdapter adapter;
    View view;
    public Fragment newInstance(String param1) {
        RecentStoryFragment fragment = new RecentStoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.story_list,container,false);
        ButterKnife.bind(this,view);
        setRecyclerView(isPortrait);
        return view;
    }

    private void setRecyclerView(boolean is_Portrait) {
        Log.e(TAG, "setRecyclerView: " + is_Portrait );
        adapter = new RecyclerAdapter(getActivity());
        if(mRecyclerView == null) {
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        else {
            mRecyclerView.setAdapter(adapter);
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            mRecyclerView.addItemDecoration(new RecyclerSpace(20));
        }
    }
}
