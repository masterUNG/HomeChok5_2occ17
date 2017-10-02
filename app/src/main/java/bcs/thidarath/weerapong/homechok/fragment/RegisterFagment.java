package bcs.thidarath.weerapong.homechok.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;


import bcs.thidarath.weerapong.homechok.All.MyPostUser;
import bcs.thidarath.weerapong.homechok.All.Myconstant;
import bcs.thidarath.weerapong.homechok.All.Myerorr;
import bcs.thidarath.weerapong.homechok.MainActivity;
import bcs.thidarath.weerapong.homechok.R;

/**
 * Created by Administrator on 12/9/2560.
 */

public class RegisterFagment extends Fragment {

    //Explicit
    private String nameString, renameString, addressString, genderString,
            phoneString, getderString, passString, rePassString;

    private boolean aBoolean = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmant_register, container, false);


        return view;
        //OnCreevied
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //ToolBar Controller
        toolBarController();

        //save Controller
        saveController();

        //Radio Controller
        radioController();


    } // onActivityCreate

    private void radioController() {
        RadioGroup radioGroup = getView().findViewById(R.id.ragGender);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                aBoolean = false;
                switch (i) {
                    case R.id.ragman:
                        genderString = "Male";
                        break;
                    case R.id.ragmale:
                        genderString = "Female";
                        break;
                }
            }
        });
    }

    private void saveController() {
        ImageView imageView = getView().findViewById(R.id.imvsave);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get Value From
                EditText nameEdiText = getView().findViewById(R.id.name);
                EditText renameEdiText = getView().findViewById(R.id.editname);
                EditText passEdiText = getView().findViewById(R.id.pass);
                EditText repassEdiText = getView().findViewById(R.id.repass);
                EditText addressEdiText = getView().findViewById(R.id.address);
                EditText PhoneEdiText = getView().findViewById(R.id.phon);


                //Change Date Type to String
                nameString = nameEdiText.getText().toString().trim();
                renameString = renameEdiText.getText().toString().trim();
                passString = passEdiText.getText().toString().trim();
                rePassString = repassEdiText.getText().toString().trim();
                addressString = addressEdiText.getText().toString().trim();
                phoneString = PhoneEdiText.getText().toString().trim();


                if (nameString.equals("") ||
                        renameString.equals("") ||
                        passString.equals("") ||
                        rePassString.equals("") ||
                        addressString.equals("") ||
                        phoneString.equals("")) {
                    //True
                    Myerorr myerorr = new Myerorr(getActivity());
                    myerorr.myDlalog("กรุณากรอกให้ครบ", "เข้าใจไหม");
                } else if (aBoolean) {
                    Myerorr myerorr = new Myerorr(getActivity());
                    myerorr.myDlalog("Gender False", "Please Choose Gender");
                } else if (passString.equals(rePassString)) {
                    // Password OK
                    uploadValuetoServer();
                    Log.d("2octV1", "ok ==> ");

                } else {
                    Myerorr myerorr = new Myerorr(getActivity());
                    myerorr.myDlalog("Password False", "Please Type Password Mapping");
                }

            }
        });
    }

    private void uploadValuetoServer() {

        String tag = "2octV1";
        Log.d(tag, "ok ==> ");
        Myconstant myconstant = new Myconstant();

        try {


            //show log
            Log.d(tag, "name ==> " + nameString);
            Log.d(tag, "rename ==> " + renameString);
            Log.d(tag, "pass ==> " + passString);
            Log.d(tag, "gender ==> " + genderString);
            Log.d(tag, "address ==> " + addressString);
            Log.d(tag, "phon ==> " + phoneString);

            MyPostUser myPostUser = new MyPostUser(getActivity());
            myPostUser.execute(
                    nameString,
                    renameString,
                    passString,
                    genderString,
                    addressString,
                    phoneString,
                    myconstant.getUrlpostUserString()

             );
            String result = myPostUser.get();
            Log.d("2octV1", "Result ==>" + result);


        } catch (Exception e) {
            Log.d(tag, "e upload ==>" + e.toString());
        }


    }

    private void toolBarController() {
        Toolbar toolbar = getView().findViewById(R.id.tooberRegister);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(R.string.newregister);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });


    }
} // Main class


