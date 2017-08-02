package com.example.binny.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.CookieHandler;
import java.util.concurrent.TimeUnit;

import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends Activity {
    ApiService apiService;
    Retrofit retrofit;
    OkHttpClient okHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //JavaNetCookieJar javaNetCookieJar = new JavaNetCookieJar(CookieHandler.getDefault());
        okHttpClient = new OkHttpClient.Builder().connectTimeout(10000, TimeUnit.MILLISECONDS).build();
        retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(apiService.API_URL).build();
        apiService = retrofit.create(ApiService.class);
        Call<ResponseBody> call = apiService.getData();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    ResponseBody responseBody = response.body();
                    JSONArray jsonArray = new JSONArray(responseBody.string());
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    //int id = jsonObject.getInt("id");
                    //JSONObject jsonObject = (JSONObject)jsonArray.get(0);
                    TextView textView = (TextView)findViewById(R.id.textview);
                    JSONArray jsonArray1 = new JSONArray(jsonObject.getString("sel1"));
                    JSONArray jsonArray2 = new JSONArray(jsonObject.getString("sel2"));
                    Log.v("sel1", jsonArray1.toString());
                    Log.v("sel2", jsonArray2.toString());
                    Log.v("sel1_name", jsonArray1.getJSONObject(0).getString("name"));
                    Log.v("sel2_name_1", jsonArray2.getJSONObject(1).getString("listimagename"));
                    Log.v("sel2_name_2", jsonArray2.getJSONObject(0).getString("listimagename"));
                    //Log.v("style", jsonObject.getString("style"));
                    //Log.v("location", jsonObject.getString("location"));
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
        /*call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                ResponseData responseData = response.body();
                SimpleData simpleData = responseData.getSimpleData();
                SimpleObject simpleObject = simpleData.getSimpleObjects().get(0);
                Log.v("ResponseData", responseData.getImagename() + responseData.getLocation() + responseData.getName() + responseData.getStyle());
                Log.v("SimpleObject", simpleObject.getListimagename() + simpleObject.getText());
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Log.v("Error", t.getLocalizedMessage());
            }
        });*/
    }
}
