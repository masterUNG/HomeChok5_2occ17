package bcs.thidarath.weerapong.homechok.All;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by Administrator on 2/10/2560.
 */

public class MyPostUser extends AsyncTask<String, Void, String>{

    private Context context;

    public MyPostUser(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {


        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("Name", strings[0])
                    .add("User", strings[1])
                    .add("Password", strings[2])
                    .add("Gender", strings[3])
                    .add("Address", strings[4])
                    .add("PhonNumber", strings[5])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[6]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();





        }catch (Exception e){
            Log.d("2octV1", "e ==> " + e.toString());
            return null;
        }

    }
}
