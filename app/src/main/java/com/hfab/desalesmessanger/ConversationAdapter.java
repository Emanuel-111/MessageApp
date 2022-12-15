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
import androidx.navigation.Navigation;
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

        System.out.println("DONE CREATING A SINGLE ROW'S VIEW");

        return new ConversationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConversationViewHolder holder, int position) {

        Conversation conversation = conversations.get(position);

        holder.setData(conversation, position);

        System.out.println("DONE POPULATING ROW: " +  position +  " "  + conversation.getStudent1ID());

    }


    @Override
    public int getItemCount() {
        return conversations.size();
    }

    class ConversationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        private int currentPosition = -1;
        private Conversation currentConversation = null;

        public ConversationViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        public void setData(Conversation c, int position )
        {
            currentConversation = c;
            currentPosition = position;

            DBHelper.LoginDBHelper dbHelper = new DBHelper.LoginDBHelper(itemView.getContext());
            ArrayList<Login> loginNames = dbHelper.fetchAllStudents();

            TextView tv_name1 = itemView.findViewById(R.id.tv_StudentName);

            for (int i = 0; i < loginNames.size(); i++)
            {
                if ((i+1) == c.getStudent2ID())
                {
                    tv_name1.setText((loginNames.get(i).getStudentName() + ""));
                }
            }


            TextView recentMessage = itemView.findViewById(R.id.tv_RecentMessage);
            recentMessage.setText(c.getLastMessageSent());

            ImageView profilePicture = itemView.findViewById(R.id.imv_StudentPicture);
            profilePicture.setImageResource(R.drawable.default_profile_image);

        }

        @Override
        public void onClick(View v) {

            ConversationFragmentDirections.ActionConversationFragmentToMessageFragment action =
                    ConversationFragmentDirections.actionConversationFragmentToMessageFragment((currentConversation.getConversationID()));

            Navigation.findNavController(itemView).navigate(action);

        }
    }
}
