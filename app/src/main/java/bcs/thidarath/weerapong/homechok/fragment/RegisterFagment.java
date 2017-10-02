package bcs.thidarath.weerapong.homechok.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;


import bcs.thidarath.weerapong.homechok.All.Myerorr;
import bcs.thidarath.weerapong.homechok.MainActivity;
import bcs.thidarath.weerapong.homechok.R;

/**
 * Created by Administrator on 12/9/2560.
 */

public class RegisterFagment extends Fragment {

    //Explicit
    private String nameString,renameString, addressString ,manString,maleString,
      phoneString,
      getderString, passString , rePassString;

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
        ImageView imageView = getView().findViewById(R.id.imvsave);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get Value From
                EditText nameEdiText = getView().findViewById(R.id.name);
                EditText renameEdiText = getView().findViewById(R.id.editname);
                EditText passEdiText = getView().findViewById(R.id.pass);
                EditText repassEdiText = getView().findViewById(R.id.repass);
                EditText manEdiText = getView().findViewById(R.id.ragman);
                EditText maleEdiText = getView().findViewById(R.id.ragmale);
                EditText addressEdiText = getView().findViewById(R.id.address);
                EditText PhoneEdiText = getView().findViewById(R.id.phon);


                //Change Date Type to String
                nameString = nameEdiText.getText().toString().trim();
                renameString = renameEdiText.getText().toString().trim();
                passString = passEdiText.getText().toString().trim();
                rePassString = repassEdiText.getText().toString().trim();
                manString = manEdiText.getText().toString().trim();
                maleString = maleEdiText.getText().toString().trim();
                addressString = addressEdiText.getText().toString().trim();
                phoneString = PhoneEdiText.getText().toString().trim();


                //Check Space
                if  (nameString.equals("")||
                     renameString.equals("")||
                     passString.equals("")||
                     rePassString.equals("")||
                     manString.equals("")||
                     maleString.equals("")||
                        addressString.equals("")||
                        phoneString.equals(""))


                {

                    //True
                    Myerorr myerorr = new Myerorr(getActivity());
                    myerorr.myDlalog("กรุณากรอกให้ครบ", "เข้าใจไหม");


                    {
                        //True

                    }


                }
            }//onclick
        });




    } // onActivityCreate

    private void toolBarController() {
        Toolbar toolbar = getView().findViewById(R.id.tooberRegister);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle(R.string.newregister);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });


    }
} // Main class


