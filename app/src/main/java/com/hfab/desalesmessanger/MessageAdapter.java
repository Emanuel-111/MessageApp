package com.hfab.desalesmessanger;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder>{

    private FragmentManager fragmentManager;
    private static ArrayList<Message> messages;

    public MessageAdapter(FragmentManager man) {
        fragmentManager = man;
        messages = DataBase.getMessages();
    }
    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        MessageViewHolder mvh = null;
        switch (viewType) {
            case Message.TYPE_SENT:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.message_sent_item, parent, false);
                mvh = new SentMessageViewHolder(view);
                System.out.println("Sent!!!!!!!!!!!!!");
                break;
            case Message.TYPE_RECEIVED:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_recieved_item, parent, false);
                mvh = new ReceivedMessageViewHolder(view);
                System.out.println("Recieved!!!!!!!!!!!!!");
                break;
        }
        return mvh;
    }

    @Override
    public int getItemViewType(int position) {

        return messages.get(position).getType();
    }


    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message m = messages.get(position);
        holder.setData(m, position);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
    abstract class MessageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtMessage;
        private TextView currentTime;
        private int currentPositionInList = -1;
        private Message currentMessage = null;

        public MessageViewHolder(@NonNull View view) {
            super(view);

            currentTime = view.findViewById(getTimeViewID());
            txtMessage = view.findViewById(getTextViewID());
            view.setClickable(true);
            view.setOnClickListener(this);
        }
        public abstract int getTimeViewID();
        public abstract int getTextViewID();

        public void setData(Message m, int position) {
            txtMessage.setText(m.getMessage());
            currentTime.setText(m.getTime());
            currentPositionInList = position;
            currentMessage = m;
        }

        @Override
        public void onClick(View view) {
        }
    }

    class ReceivedMessageViewHolder extends MessageViewHolder {

        public ReceivedMessageViewHolder(@NonNull View view) {
            super(view);
        }

        public int getTimeViewID(){return R.id.time;}
        public int getTextViewID(){return R.id.txt_msgReceived;}

    }

    class SentMessageViewHolder extends MessageViewHolder {

        public SentMessageViewHolder(@NonNull View view) {
            super(view);
        }
        public int getTimeViewID(){return R.id.time;}
        public int getTextViewID(){
            return R.id.txt_msgSent;
        }

    }
    //github test
}