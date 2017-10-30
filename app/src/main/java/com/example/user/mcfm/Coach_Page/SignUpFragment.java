package com.example.user.mcfm.Coach_Page;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;

import com.example.user.mcfm.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {

    private RadioButton tuteeButton;
    private RadioButton tutorButton;
    private int flag ;
    private EditText userName;
    private EditText userPwd;
    private EditText userEmail;
    private EditText userLocation;
    private EditText userBirth;
    private ImageButton userPhoto;
    private Button createButton;
    private Activity activity;

    public interface OnApplySelectedListener {

        public void onCatagoryApplySelected(int flag);

    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof Activity){
            this.activity = (Activity)context;
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view =  inflater.inflate(R.layout.fragment_sign_up, container, false);
        tutorButton = (RadioButton) view.findViewById(R.id.checkTutor);
        tuteeButton = (RadioButton)view.findViewById(R.id.checkTutee);
        userName = (EditText)view.findViewById(R.id.username);
        userPwd = (EditText)view.findViewById(R.id.userpwd);
        userEmail = (EditText)view.findViewById(R.id.userEmail);
        userBirth = (EditText)view.findViewById(R.id.userBirth);
        userLocation = (EditText)view.findViewById(R.id.userLocation);
        userPhoto = (ImageButton) view.findViewById(R.id.userPhoto);
        createButton = (Button)view.findViewById(R.id.createButton);
        tuteeButton.setChecked(false);
        tutorButton.setChecked(true);


        tutorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tuteeButton.setChecked(false);
                flag = 0;
            }
        });
        tuteeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tutorButton.setChecked(false);
                flag = 1;
            }
        });
        createButton.setEnabled(true);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(v.getContext());
                dialogBuilder.setTitle("알 림");
                dialogBuilder
                        .setMessage("감사합니다\n심사를 거쳐 회원가입이 완료됩니다.\n 계속하시겠습니까?")
                        .setCancelable(false)

                        .setPositiveButton("네",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        // 프로그램을 종료한다

                                        Coach_activity coach_activity =  (Coach_activity) getActivity();
                                        ((OnApplySelectedListener)activity).onCatagoryApplySelected(flag);
                                        LoginFragment loginFragment = new LoginFragment();
                                        Bundle bundle = new Bundle(1);
                                        bundle.putInt("check",flag);
                                        loginFragment.setArguments(bundle);
                                        coach_activity.setFragment(loginFragment);
                                        createButton.setEnabled(false);

                                    }
                                })
                        .setNegativeButton("아니요",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        // 다이얼로그를 취소한다
                                        dialog.cancel();
                                    }
                                });

                // 다이얼로그 생성
                AlertDialog alertDialog = dialogBuilder.create();
                //   TextView messageView = (TextView)alertDialog.findViewById(dialogBuilder.getContext())
                // 다이얼로그 보여주기
                alertDialog.show();


            }
        });

        return view;
    }

    // 폼 자동 생성
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                userPhoto.setImageResource(R.drawable.person);
                userName.setText("홍길동");
                userPwd.setText("helloworld");
                userEmail.setText("Seoul@gmail.com");
                userBirth.setText("19910814");
                userLocation.setText("서울시 노원구 공릉동 풍림아파트");
            }
        },2500);
    }
}
