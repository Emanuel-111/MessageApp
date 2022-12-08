package com.hfab.desalesmessanger;

import android.widget.ImageView;

import java.util.ArrayList;

// This will be replaced with a SQL Database
public class LoginDatabase {

    private static ArrayList<Login> logins = new ArrayList<Login>();

    public static ArrayList<Login> getLogins()
    {
        if (logins == null)
        {
            loadData();
        }

        return logins;
    }

    private static void loadData()
    {
        logins.add(new Login(126, "Emanuel Luna","emanuel@desales.edu","12345"));
    }

}
