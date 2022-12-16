package com.hfab.desalesmessanger;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

/**
 * @author Emanuel Luna
 *
 * SettingsFragment - settings menu that changes the background color
 */
public class SettingsFragment extends Fragment {

    // All private fields
    private Button btnBgWhite;
    private Button btnBgGray;
    private Button btnBgRed;
    private Button btnBgBlue;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    /**
     * OnCreateView - inflate the settings fragment with the options possible
     * @param inflater - inflater
     * @param container - viewgroup container
     * @param savedInstanceState - bundle savedInstanceState
     * @return view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        btnBgRed = view.findViewById(R.id.btn_red);
        btnBgBlue = view.findViewById(R.id.btn_blue);
        btnBgGray = view.findViewById(R.id.btn_gray);
        btnBgWhite = view.findViewById(R.id.btn_white);

        sharedPreferences = view.getContext().getSharedPreferences("fragment_settings.xml", Context.MODE_PRIVATE);

        /**
         * When clicked, the corresponding background color is retrieved
         * from the shared preference file and set as the background color for the Fragment's view.
         */
        btnBgWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sharedPreferences.edit();
                editor.putInt("btn_white", R.color.white);
                editor.apply();

                int bgColor = sharedPreferences.getInt("btn_white", R.color.white);
                view.setBackgroundColor(getResources().getColor(bgColor));
            }
        });

        /**
         * When clicked, the corresponding background color is retrieved
         * from the shared preference file and set as the background color for the Fragment's view.
         */
        btnBgGray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sharedPreferences.edit();
                editor.putInt("btn_gray", R.color.gray);
                editor.apply();

                int bgColor = sharedPreferences.getInt("btn_gray", R.color.gray);
                view.setBackgroundColor(getResources().getColor(bgColor));

            }
        });

        /**
         * When clicked, the corresponding background color is retrieved
         * from the shared preference file and set as the background color for the Fragment's view.
         */
        btnBgRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sharedPreferences.edit();
                editor.putInt("btn_red", R.color.red);
                editor.apply();

                int bgColor = sharedPreferences.getInt("btn_red", R.color.red);
                view.setBackgroundColor(getResources().getColor(bgColor));
            }
        });

        /**
         * When clicked, the corresponding background color is retrieved
         * from the shared preference file and set as the background color for the Fragment's view.
         */
        btnBgBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sharedPreferences.edit();
                editor.putInt("btn_blue", R.color.blue);
                editor.apply();

                int bgColor = sharedPreferences.getInt("btn_blue", R.color.blue);
                view.setBackgroundColor(getResources().getColor(bgColor));
            }
        });

        return view;
    }
}