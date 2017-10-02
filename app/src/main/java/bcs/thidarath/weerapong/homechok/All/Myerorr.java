package bcs.thidarath.weerapong.homechok.All;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import bcs.thidarath.weerapong.homechok.R;

/**
 * Created by Administrator on 2/10/2560.
 */

public class Myerorr {
    private Context context;

    public Myerorr(Context context) {
        this.context = context;
    }

    public void myDlalog(String srtTitle, String strMessge){


        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.drawable.error);
        builder.setCancelable(false);
        builder.setTitle(srtTitle);
        builder.setMessage(strMessge);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.show();





    }

}



