package com.example.user.mcfm.Coach_Page;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.mcfm.Main.MainActivity;
import com.example.user.mcfm.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener{

    private EditText userID, userPWD;
    private int flag;
    private Button sign_btn;
    public LoginFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_login, container, false);

        flag = getArguments().getInt("check");

        userID=(EditText) view.findViewById(R.id.username);
        userPWD=(EditText)view.findViewById(R.id.password);
        sign_btn = (Button)view.findViewById(R.id.sign_in_btn);
        sign_btn.setOnClickListener(this);
        sign_btn.setEnabled(true);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                userID.setText("Seoul@naver.com");
                userPWD.setText("helloSeoul");
            }
        },1500);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sign_in_btn:

                Intent intent = new Intent(getContext().getApplicationContext(), MainActivity.class);
                intent.putExtra("getFlag",flag);
                sign_btn.setEnabled(false);
                getContext().startActivity(intent);
                getActivity().finish();

                break;
        }
    }
}
