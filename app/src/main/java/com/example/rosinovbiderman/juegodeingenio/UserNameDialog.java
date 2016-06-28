package com.example.rosinovbiderman.juegodeingenio;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 41752347 on 21/6/2016.
 */
public class UserNameDialog extends DialogFragment {

    public UserNameDialog() {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_name, container);

        final MainActivity mainActivity  = (MainActivity) getActivity(); // Politicamente incorrecto
        final EditText userName = (EditText) view.findViewById(R.id.txt_your_name);
        userName.setText(mainActivity.getUserName());

        Button b = (Button) view.findViewById(R.id.confirmar);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Click","OK");
                mainActivity.setUserName(userName.getText().toString());
                dismiss();
            }
        });
        getDialog().setTitle("Ingrese nombre de usuario");

        return view;
    }

}