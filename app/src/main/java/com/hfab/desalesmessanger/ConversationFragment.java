package com.hfab.desalesmessanger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * @author Emanuel Luna
 * ConversationFragment uses a recyclerview to display all
 * conversations depending on the user that signs in.
 */
public class ConversationFragment extends Fragment {

    private ArrayList<Conversation> conversations;
    private ArrayList<Conversation> specificConversation;
    private DBHelper.ConversationDBHelper convDBHelper;

    private View view;

    private FloatingActionButton fabSettings;

    /**
     * onCreateView inflates the fragment with conversations
     * depending on the user that is signed in
     *
     * @param inflater           - LayoutInflater
     * @param container          - Viewgroup container
     * @param savedInstanceState - Bundle of savedInstanceStates
     * @return view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_conversation, container, false);

        convDBHelper = new DBHelper.ConversationDBHelper(getContext());

        conversations = convDBHelper.fetchAllConversations();
        specificConversation = new ArrayList<Conversation>();

        // This login id from the LoginFragment is used for comparing
        String id = ConversationFragmentArgs.fromBundle(requireArguments()).getStudentId();

        // String into an int
        int studentId = Integer.parseInt(id);

        // If the id from the login matches the conversation's studentId
        // Show all conversations from that user specifically
        for (int i = 0; i < conversations.size(); i++) {
            if (conversations.get(i).getStudent1ID() == studentId) {
                specificConversation.add(conversations.get(i));
            }
        }

        fabSettings = view.findViewById(R.id.fab_settings);

        /**
         * When clicking the settings floating action button, the view switches to SettingsFragment
         */
        fabSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_conversationFragment_to_settingsFragment);
            }
        });

        setUpRecyclerView();

        return view;
    }

    /**
     * setUpRecyclerView - sets up the recycler view
     */
    public void setUpRecyclerView() {
        // RecyclerView
        RecyclerView rv = view.findViewById(R.id.rv_conversations);

        // FragmentManager
        FragmentManager fm = getChildFragmentManager();

        //adapter
        ConversationAdapter adapter = new ConversationAdapter(fm, specificConversation);
        rv.setAdapter(adapter);

        //manager connects the above 2
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(layoutManager);
    }

}
