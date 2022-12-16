package com.hfab.desalesmessanger;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Wyatt Giberson
 * Message Fragment Creates the view, fills it and calls the Adapter.
 * It also allows users to send and receive new messages
 */
public class MessageFragment extends Fragment {

    //Variables Initialization
    private ImageView imvSend;
    private EditText newMessage;
    private DBHelper.MessageDBHelper messageDBHelper;
    private Context context;
    private View view;
    private ArrayList<Message> messages;
    private ArrayList<Message> specifcMessages;
    long conversationId;

    /**
     * On Create For Message Fragment
     *
     * @param inflater - inflater
     * @param container - viewgroup container
     * @param savedInstanceState - savedInstanceState
     * @return view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Creates View
        view = inflater.inflate(R.layout.fragment_messages, container, false);

        super.onCreate(savedInstanceState);
        //Initializes interactive features
        imvSend = view.findViewById(R.id.imvSend);
        newMessage = view.findViewById(R.id.etMessage);


        //On Click Listener for Send Button
        imvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Gets Time And add time for Message, adds Message in view
                Calendar c = Calendar.getInstance();
                String timeComp = c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE);
                specifcMessages.add(new Message(specifcMessages.size() + 1, (int) conversationId, newMessage.getText().toString(), timeComp, Message.TYPE_SENT));

                //Calls hideKeyboard function
                hideKeyboard(view);
            }

            //Hides Keyboard after message is sent
            private void hideKeyboard(View view) {
                InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
            }
        });

        //Calls Recycler View Setter
        setUpRecyclerView();
        // Inflate the layout for this fragment
        return view;
    }

    //Binds Variables to items from DB
    private void setUpRecyclerView() {

        //Gets Conversation
        conversationId = MessageFragmentArgs.fromBundle(requireArguments()).getConversationId();

        context = getContext();
        messageDBHelper = new DBHelper.MessageDBHelper(context);
        //Gets List of Messages
        messages = messageDBHelper.fetchAllMessages();
        specifcMessages = new ArrayList<Message>();

        //Loop to add messages
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).getConversationID() == conversationId) {
                specifcMessages.add(messages.get(i));
            }
        }

        //Finds Recycler View
        RecyclerView rv = view.findViewById(R.id.rv_message);
        FragmentManager fm = getParentFragmentManager();

        //adapter
        MessageAdapter adapter = new MessageAdapter(fm, getContext(), specifcMessages);
        rv.setAdapter(adapter);

        //manager connects the above 2
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(layoutManager);

    }
}