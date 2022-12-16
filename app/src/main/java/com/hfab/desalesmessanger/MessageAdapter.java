package com.hfab.desalesmessanger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//Wyatt Giberson
//Message Adapter Implements The message Class, adds messages to the view from the DB, Creating each individual
//part of the conversation chooses whether to create a
//received or sent message, and fills the view.
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    //Private Variable Initialization
    private FragmentManager fragmentManager;
    private static ArrayList<Message> messages;
    private DBHelper.MessageDBHelper messageDBHelper;
    private Context context;


    //Adapter Constructor
    public MessageAdapter(FragmentManager man, Context ct, ArrayList<Message> message) {
        this.context = ct;
        messageDBHelper = new DBHelper.MessageDBHelper(context);
        fragmentManager = man;
        messages = message;
    }

    //View Holder
    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Setup View
        View view;
        //Sets View Holder to null at first, changed in switch statement.
        MessageViewHolder mvh = null;
        //Statement that finds if message was sent or Received, sets view based on the Global Variable contained. Adds it to the Recycler View based on result
        switch (viewType) {
            case Message.TYPE_SENT:
                //Sent Messages
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.message_sent_item, parent, false);
                mvh = new SentMessageViewHolder(view);
                break;
            //Received Messages
            case Message.TYPE_RECEIVED:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_recieved_item, parent, false);
                mvh = new ReceivedMessageViewHolder(view);
                break;
        }
        //Returns Desired View holder
        return mvh;
    }

    @Override
    public int getItemViewType(int position) {
        //Gets Position In Message Database
        return messages.get(position).getSenderID();
    }

    //Binds the View Holder, to position in list and sets data
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {

        Message m = messages.get(position);
        holder.setData(m, position);
    }

    @Override
    //Gets Amount of messages in DB
    public int getItemCount() {
        return messages.size();
    }

    //Sets up the View Holder For Messages in the Recycler View
    abstract class MessageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //Sets up Views
        private TextView txtMessage;
        private TextView currentTime;
        private int currentPositionInList = -1;
        private Message currentMessage = null;

        //Message View Holder Constructor
        public MessageViewHolder(@NonNull View view) {
            super(view);

            //binds to Views Current Time and Txt Message
            currentTime = view.findViewById(getTimeViewID());
            txtMessage = view.findViewById(getTextViewID());
            view.setClickable(true);
            view.setOnClickListener(this);
        }

        //Sets up variables
        public abstract int getTimeViewID();

        public abstract int getTextViewID();

        //Sets Data for current position in DB to View
        public void setData(Message m, int position) {
            txtMessage.setText(m.getContents());
            currentTime.setText(m.getTimestamp());
            currentPositionInList = position;
            currentMessage = m;
        }

        @Override
        public void onClick(View view) {
        }
    }


    //View Holder for Received Messages
    class ReceivedMessageViewHolder extends MessageViewHolder {

        //Sets up the View
        public ReceivedMessageViewHolder(@NonNull View view) {
            super(view);
        }

        //Sets Variables from the Received layout
        public int getTimeViewID() {
            return R.id.time;
        }

        public int getTextViewID() {
            return R.id.txt_msgReceived;
        }

    }

    //View Holder for Sent Messages
    class SentMessageViewHolder extends MessageViewHolder {
        //Sets up the View
        public SentMessageViewHolder(@NonNull View view) {
            super(view);
        }

        //Sets Variables from the Sent layout
        public int getTimeViewID() {
            return R.id.time;
        }

        public int getTextViewID() {
            return R.id.txt_msgSent;
        }

    }
}