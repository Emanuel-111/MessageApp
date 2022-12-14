package com.hfab.desalesmessanger;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class LoginFragment extends Fragment {

    private EditText etvEmailAddress;
    private EditText etvPassword;
    private Button btnLogin;
    private DBHelper.LoginDBHelper loginDBHelper;
    private DBHelper.MessageDBHelper messageDBHelper;
    private DBHelper.ConversationDBHelper convDBHelper;

    private ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        loginDBHelper = new DBHelper.LoginDBHelper(getContext());
        messageDBHelper = new DBHelper.MessageDBHelper(getContext());
        convDBHelper = new DBHelper.ConversationDBHelper(getContext());

        // Fill the arrayList with the logins
        ArrayList<Login> allLogins = loginDBHelper.fetchAllStudents();

        etvEmailAddress = view.findViewById(R.id.etv_email);
        etvPassword = view.findViewById(R.id.etv_password);
        btnLogin = view.findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String emailAddress = etvEmailAddress.getText().toString();
                String password = etvPassword.getText().toString();

                for (int i = 0; i < allLogins.size(); i++)
                {
                    if(emailAddress.equals(allLogins.get(i).getEmailAddress()))
                    {
                        if(password.equals(allLogins.get(i).getPassword()))
                        {
                            LoginFragmentDirections.ActionLoginFragmentToConversationFragment action =
                                    LoginFragmentDirections.actionLoginFragmentToConversationFragment(allLogins.get(i).getId());

                            Navigation.findNavController(view).navigate(action);

                        }

                        else
                        {

                        }
                    }

                    else
                    {

                    }
                }

            }
        });



        return view;
    }
}