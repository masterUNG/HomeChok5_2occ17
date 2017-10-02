package bcs.thidarath.weerapong.homechok.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import bcs.thidarath.weerapong.homechok.All.Myerorr;
import bcs.thidarath.weerapong.homechok.R;

import static bcs.thidarath.weerapong.homechok.R.layout.activity_content;

/**
 * Created by Administrator on 11/9/2560.
 */

public class MainFragment extends Fragment {

    private String userString, passwordString;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragmant_main, container, false);

        return view;
    }   //onCreateView

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Register Controller
        registerController();

        //Login Controller
        loginController();

    } // onActivityCreate

    private void loginController() {
        Button button = getView().findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText userEditText = getView().findViewById(R.id.edtUser);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);

                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();

                if (userString.equals("") || passwordString.equals("")) {
                    Myerorr myerorr = new Myerorr(getActivity());
                    myerorr.myDlalog(getResources().getString(R.string.have_space),
                            getResources().getString(R.string.mess_have));
                } else {
                    checkUserAndPass();
                }

            }
        });
    }

    private void checkUserAndPass() {




    }

    private void registerController() {
        TextView textView = getView().findViewById(R.id.txtRegister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentFragmentMain, new RegisterFagment())
                        .addToBackStack(null)
                        .commit();







            }
        });
    }
}   // Main Class





