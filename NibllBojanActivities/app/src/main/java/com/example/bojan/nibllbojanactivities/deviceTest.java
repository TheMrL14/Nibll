package com.example.bojan.nibllbojanactivities;



import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bojan.nibllbojanactivities.utils.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;


public class deviceTest extends AppCompatActivity {


//    private static final String urlOff ="http://192.168.1.128:5001/send?protocol=kaku_switch&id=27672578&unit=0&off=1";
//    private static final String urlOn = "http://192.168.1.128:5001/send?protocol=kaku_switch&id=27672578&unit=0&on=1";
    private static final String urlOff = "http://192.168.0.4/success.json";
//    private static final String urlOn = "http://192.168.1.128:8080/device/getAll";
    private static final String urlOn = "http://192.168.0.4/devices.json";
    private boolean networkOk = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_test);

        View output;

        output = (TextView) findViewById(R.id.output);
//        output.append("Network ok: " + networkOk);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @Override
    protected void onStop() {
        super.onStop();
//        if (mRequestQueue != null) {
//            mRequestQueue.cancelAll(VolleyTAG);
//        }
//        LocalBroadcastManager.getInstance(getApplicationContext())
//                .unregisterReceiver(mBroadcastReceiver);
    }
    public void remoteOn(View view) {
        final TextView mTextView;
        mTextView = (TextView) findViewById(R.id.output);

        if(networkOk){
            JsonArrayRequest jsObjRequest = new JsonArrayRequest
                    (Request.Method.GET, urlOn, null, new Response.Listener<JSONArray>() {




                        @Override
                        public void onResponse(JSONArray response) {
                            String test = "";
                            Gson gson = new Gson();
                            gson.fromJson(response.toString(), JsonArray.class);

                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    JSONObject responseObject =  response.getJSONObject(i);
                                    test += responseObject.get("naamDevice") + " ,";

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
//                            for(JsonElement jsonElement : (JsonArray) response)) {
//                                JsonObject responseObject = response.getAsJsonObject();
//
//                                test += responseObject.get("naamDevice") + " ,";
////                                JsonElement jsonElement =  response.get(i);
////                                jsonElement.
//                            }

                               // mTextView.setText("Response: " + response.toJSONArray());
//                                Iterator x = response.keys();
//                                JSONArray jsonArray = new JSONArray();
//
//                                while (x.hasNext()){
//                                    Log.d("lol", "next ");
//                                    String key = (String) x.next();
//                                    jsonArray.put(response.get(key));
//                                }
//                                for (int i=0; i < jsonArray.length(); i++){
//                                  test +=  jsonArray.getJSONObject(i).get("naamDevice").toString() + " ";
//                                }

                                mTextView.setText("response: " + test);


                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO Auto-generated method stub
                            Log.d("lol", "onErrorResponse: " + error);
                        }

                    });

// Access the RequestQueue through your singleton class.
            MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);

        Toast.makeText(this, "Led is aan", Toast.LENGTH_SHORT).show();
    }

 else {
        Toast.makeText(this, "Network not available!", Toast.LENGTH_SHORT).show();
        }
    }

    public void remoteOff(View view) {
        final TextView mTextView;
        mTextView = (TextView) findViewById(R.id.output);
        if (networkOk) {
            final MediaPlayer plopSound = MediaPlayer.create(this, R.raw.plop);
            plopSound.start();
            RequestQueue mRequestQueue = MySingleton.getInstance(this.getApplicationContext()).
                    getRequestQueue();


// Formulate the request and handle the response.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, urlOff,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Do something with the response
                            mTextView.setText(response);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // Handle error
                            mTextView.setText(error.toString());
                        }
                    });
// Add the request to the RequestQueue.
            MySingleton.getInstance(this).addToRequestQueue(stringRequest);

            Toast.makeText(this, "Led is uit", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Network not available!", Toast.LENGTH_SHORT).show();
        }

    }


}
