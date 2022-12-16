package com.hfab.desalesmessanger;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.util.ArrayList;

/**
 * @author Emanuel Luna
 * LoginFragment - prompts the user to login to their account.
 * If the password is correct, the user will be prompted to their conversations
 */
public class LoginFragment extends Fragment {

    private EditText etvEmailAddress;
    private EditText etvPassword;
    private Button btnLogin;
    private DBHelper.LoginDBHelper loginDBHelper;
    private DBHelper.MessageDBHelper messageDBHelper;
    private DBHelper.ConversationDBHelper convDBHelper;
    private ArrayList<Login> allLogins;
    private Toast toast;
    private SQLiteDatabase db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        loginDBHelper = new DBHelper.LoginDBHelper(getContext());
        messageDBHelper = new DBHelper.MessageDBHelper(getContext());
        convDBHelper = new DBHelper.ConversationDBHelper(getContext());

        // If the database does not exist in the project or app it will add and fill the database
        // Otherwise, it will skip.
        try {
            db = SQLiteDatabase.openDatabase(getContext().getDatabasePath("logins.db").toString(), null, SQLiteDatabase.OPEN_READONLY);
        }

        catch (Exception e)
        {

        }

        if (db == null)
        {
            loginDBHelper.callSqlLogins();
            messageDBHelper.addMessage();
            convDBHelper.insertConversation();
        }

        // Fill the arrayList with the logins
        allLogins = loginDBHelper.fetchAllStudents();

        etvEmailAddress = view.findViewById(R.id.etv_email);
        etvPassword = view.findViewById(R.id.etv_password);
        btnLogin = view.findViewById(R.id.btn_login);

        toast = new Toast(getContext());

        /**
         * btnLogin - When the user clicks the login button, it will check to
         * see if the email address and password are correct.
         * If both are correct, the user will be logged into their
         * account.
         */
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Grab the email address and password the user typed
                String emailAddress = etvEmailAddress.getText().toString();
                String password = etvPassword.getText().toString();

                // For every login
                for (int i = 0; i < allLogins.size(); i++) {
                    // If the emailAddress is correct, check the password
                    if (emailAddress.equals(allLogins.get(i).getEmailAddress())) {
                        // If the password is correct, log the user into their account
                        if (password.equals(allLogins.get(i).getPassword())) {
                            LoginFragmentDirections.ActionLoginFragmentToConversationFragment action =
                                    LoginFragmentDirections.actionLoginFragmentToConversationFragment("" + allLogins.get(i).getId());

                            Navigation.findNavController(view).navigate(action);
                            break;
                            // Otherwise, tell the user the password is incorrect
                        } else {
                            toast.makeText(getContext(), "Password is incorrect", Toast.LENGTH_SHORT).show();
                        }
                        // Otherwise, tell the user the email address is incorrect
                    } else {
                        toast.makeText(getContext(), "Email is incorrect", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        return view;
    }

   /* @Override
    public void onDestroy() {
        super.onDestroy();

        loginDBHelper.deleteSqlLogins();
        messageDBHelper.deleteSQLMessages();
        convDBHelper.deleteSQLConversations();

    }*/
}