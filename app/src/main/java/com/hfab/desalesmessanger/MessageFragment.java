package com.hfab.desalesmessanger;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
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
    private MessageDBHelper messageDBHelper;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_messages, container, false);

        super.onCreate(savedInstanceState);
        imvSend = view.findViewById(R.id.imvSend);
        newMessage = view.findViewById(R.id.etMessage);
        imvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = getContext();
                messageDBHelper = new MessageDBHelper(context);
                ArrayList<Message> messages;
                messages = messageDBHelper.fetchAllMessages();
                Calendar c = Calendar.getInstance();
                String timeComp = c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE);
                messages.add(new Message(1, 2, newMessage.getText().toString(),timeComp, Message.TYPE_SENT));
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

        RecyclerView rv = getView().findViewById(R.id.recyclerView);

        FragmentManager fm = getParentFragmentManager();

        //adapter
        MessageAdapter adapter = new MessageAdapter(fm);
        rv.setAdapter(adapter);

        //manager connects the above 2
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(layoutManager);

    }
}