package com.hfab.desalesmessanger;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class LoginFragment extends Fragment {

    private EditText etvEmailAddress;
    private EditText etvPassword;
    private Button btnLogin;
    private LoginDBHelper loginDBHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        loginDBHelper = new LoginDBHelper(getContext());

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

                if (emailAddress.equals("") && password.equals(""))
                {
                    Toast.makeText(getContext(), "Please enter email or password", Toast.LENGTH_SHORT).show();
                }

                else if (emailAddress.equals(""))
                {
                    Toast.makeText(getContext(), "Please enter email", Toast.LENGTH_SHORT).show();
                }

                else if (password.equals(""))
                {
                    Toast.makeText(getContext(), "Please enter password", Toast.LENGTH_SHORT).show();
                }

                else if (!emailAddress.contains("desales.edu"))
                {
                    Toast.makeText(getContext(), "Please put a DeSales email", Toast.LENGTH_SHORT).show();
                }

                else

                {
                    LoginFragmentDirections.ActionLoginFragmentToConversationFragment action =
                            LoginFragmentDirections.actionLoginFragmentToConversationFragment(1);

                    Navigation.findNavController(view).navigate(action);
                }

            }
        });



        return view;
    }
}