package com.hfab.desalesmessanger;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MessageFragment extends Fragment {

    private ImageView imvSend;
    private EditText newMessage;
    private Date currentTime;
    private DBHelper.MessageDBHelper messageDBHelper;
    private Context context;
    private View view;
    private ArrayList<Message> messages;
    private ArrayList<Message> specifcMessages;
    long conversationId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_messages, container, false);

        super.onCreate(savedInstanceState);
        imvSend = view.findViewById(R.id.imvSend);
        newMessage = view.findViewById(R.id.etMessage);



        imvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Calendar c = Calendar.getInstance();
                String timeComp = c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE);
                specifcMessages.add(new Message(specifcMessages.size() + 1, (int) conversationId, newMessage.getText().toString(),timeComp, Message.TYPE_SENT));

                hideKeyboard(view);
            }
            private void hideKeyboard(View view) {
                InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(),0);
            }
        });

        setUpRecyclerView();
        // Inflate the layout for this fragment
        return view;
    }

    private void setUpRecyclerView(){

        conversationId = MessageFragmentArgs.fromBundle(requireArguments()).getConversationId();

        context = getContext();
        messageDBHelper = new DBHelper.MessageDBHelper(context);

        messages = messageDBHelper.fetchAllMessages();
        specifcMessages = new ArrayList<Message>();


        for (int i = 0; i < messages.size(); i++)
        {
            if (messages.get(i).getConversationID() == conversationId)
            {
                specifcMessages.add(messages.get(i));
            }
        }

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