package com.hfab.desalesmessanger;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Emanuel Luna
 * ConversationAdapter sets up the conversation recyclerview
 * to display all conversations.
 */
public class ConversationAdapter extends RecyclerView.Adapter<ConversationAdapter.ConversationViewHolder> {

    private FragmentManager fragmentManager;
    private ArrayList<Conversation> conversations;
    private int currentPositionInList = -1;

    /**
     * ConversationAdapter
     *
     * @param fm           - Fragment manager
     * @param conversation - arrayList of conversations
     */
    public ConversationAdapter(FragmentManager fm, ArrayList<Conversation> conversation) {
        fragmentManager = fm;
        conversations = conversation;
    }

    /**
     * ConversationViewHolder -
     *
     * @param parent   - parent ViewGroup
     * @param viewType - type of view the methods needs
     * @return new ConversationViewHolder(view)
     */
    @NonNull
    @Override
    public ConversationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.conversation_row_item, parent, false);

        System.out.println("DONE CREATING A SINGLE ROW'S VIEW");

        return new ConversationViewHolder(view);
    }

    /**
     * onBindViewHolder - Binds all conversations together
     *
     * @param holder   - holder of the recyclerview
     * @param position - position of the conversation
     */
    @Override
    public void onBindViewHolder(@NonNull ConversationViewHolder holder, int position) {

        Conversation conversation = conversations.get(position);

        holder.setData(conversation, position);

        System.out.println("DONE POPULATING ROW: " + position + " " + conversation.getStudent1ID());

    }


    /**
     * getItemCount - get the number of conversations in the conversation ArrayList
     *
     * @return conversations.size()
     */
    @Override
    public int getItemCount() {
        return conversations.size();
    }

    /**
     * ConversationViewHolder makes all conversations clickable
     * as well as set data for each conversation
     */
    class ConversationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private int currentPosition = -1;
        private Conversation currentConversation = null;

        /**
         * ConversationViewHolder - makes all conversations clickable
         *
         * @param itemView - a type of view
         */
        public ConversationViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        /**
         * setData -
         *
         * @param c        - conversation ArrayList
         * @param position - a specifc position of the conversation
         */
        public void setData(Conversation c, int position) {
            // Sets the current position and current conversation
            currentConversation = c;
            currentPosition = position;

            DBHelper.LoginDBHelper dbHelper = new DBHelper.LoginDBHelper(itemView.getContext());
            ArrayList<Login> loginNames = dbHelper.fetchAllStudents();

            TextView tv_name1 = itemView.findViewById(R.id.tv_StudentName);

            // If the login Id matches the conversation's student2ID
            // then the name associated with both id's will appear
            for (int i = 0; i < loginNames.size(); i++) {
                if ((i + 1) == c.getStudent2ID()) {
                    tv_name1.setText((loginNames.get(i).getStudentName() + ""));
                }
            }

            // Shows the most recent message per conversation
            TextView recentMessage = itemView.findViewById(R.id.tv_RecentMessage);
            recentMessage.setText(c.getLastMessageSent());

            // Shows profilePicture per conversation
            ImageView profilePicture = itemView.findViewById(R.id.imv_StudentPicture);
            profilePicture.setImageResource(R.drawable.default_profile_image);

        }

        /**
         * When a conversation is clicked, the ConversationFragment will be
         * directed to the MessageFragment
         *
         * @param v - view
         */
        @Override
        public void onClick(View v) {

            ConversationFragmentDirections.ActionConversationFragmentToMessageFragment action =
                    ConversationFragmentDirections.actionConversationFragmentToMessageFragment((currentConversation.getConversationID()));

            Navigation.findNavController(itemView).navigate(action);

        }
    }
}
