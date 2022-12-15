package com.hfab.desalesmessanger;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
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

        DBHelper.ConversationDBHelper convDBHelper = new DBHelper.ConversationDBHelper(getContext());
        ArrayList<Conversation> conversations = convDBHelper.fetchAllConversations();

        ArrayList<Conversation> specificConversation = new ArrayList<Conversation>();

        String id = ConversationFragmentArgs.fromBundle(requireArguments()).getStudentId();

        int studentId = Integer.parseInt(id);

        for (int i = 0; i < conversations.size(); i++)
        {
            if (conversations.get(i).getStudent1ID() == studentId)
            {
                specificConversation.add(conversations.get(i));
            }
        }

        RecyclerView rv = view.findViewById(R.id.rv_conversations);
        Context context = getContext();

        //FragmentManager fm = ((FragmentActivity) context).getSupportFragmentManager();
        FragmentManager fm = getChildFragmentManager();

        //adapter
        ConversationAdapter adapter = new ConversationAdapter(fm, specificConversation);
        rv.setAdapter(adapter);

        //manager connects the above 2
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(layoutManager);

        return view;
    }

}
