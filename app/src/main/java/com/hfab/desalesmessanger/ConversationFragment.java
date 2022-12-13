package com.hfab.desalesmessanger;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class ConversationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_conversation, container, false);



        return view;
    }

    private void setUpRecyclerView()
    {
        RecyclerView rv = getView().findViewById(R.id.rv_conversations);

        FragmentManager fm = getParentFragmentManager();

        ConversationDBHelper convDBHelper = new ConversationDBHelper(getContext());

        ArrayList<Conversation> conversations = convDBHelper.fetchAllConversations();

        //adapter
       ConversationAdapter adapter = new ConversationAdapter(fm, conversations);
        rv.setAdapter(adapter);

        //manager connects the above 2
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(layoutManager);
    }
}
