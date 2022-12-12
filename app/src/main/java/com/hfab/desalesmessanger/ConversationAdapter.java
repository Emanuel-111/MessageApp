package com.hfab.desalesmessanger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ConversationAdapter extends RecyclerView.Adapter<ConversationAdapter.ConversationViewHolder> {

    private FragmentManager fragmentManager;
    private ArrayList<Conversation> conversations;
    private int currentPositionInList = -1;


    public ConversationAdapter (FragmentManager fm, ArrayList<Conversation> conversation)
    {
        fragmentManager = fm;
        conversations = conversation;
    }

    @NonNull
    @Override
    public ConversationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.conversation_row_item, parent, false);

        return new ConversationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConversationViewHolder holder, int position) {

        Conversation conversation = conversations.get(position);

        holder.setData(conversation, position);

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    class ConversationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        private ImageView profilePicture;
        private TextView person1;
        private TextView person2;
        private Conversation currentConversation = null;

        public ConversationViewHolder(@NonNull View itemView) {
            super(itemView);

           profilePicture =  itemView.findViewById(R.id.imv_StudentPicture);
           person1 = itemView.findViewById(R.id.tv_StudentName);
           person2 = itemView.findViewById(R.id.tv_StudentName);

            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        public void setData(Conversation c, int position )
        {
            profilePicture.setImageResource(R.drawable.default_profile_image);

            currentPositionInList = position;
            currentConversation = c;

        }




        @Override
        public void onClick(View v) {

        }
    }
}
