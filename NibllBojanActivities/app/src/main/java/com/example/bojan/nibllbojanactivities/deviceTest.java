package com.example.bojan.nibllbojanactivities;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bojan.nibllbojanactivities.utils.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;


public class deviceTest extends AppCompatActivity {

    public static final String VolleyTAG= "MyTag";
    StringRequest stringRequest;
    RequestQueue mRequestQueue;



    private static final String urlOff =
            "http://192.168.1.128:5001/send?protocol=kaku_switch&id=27672578&unit=0&off=1";
//    private static final String urlOn = "http://192.168.1.128:5001/send?protocol=kaku_switch&id=27672578&unit=0&on=1";
    private static final String urlOn = "http://192.168.1.128:8080/device/getAll";
    private boolean networkOk = true;
    private boolean ledOn = false;
    TextView output, mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_test);

        output = (TextView) findViewById(R.id.output);

        output.append("Network ok: " + networkOk);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
    }

    public void remoteOn(View view) {
        final TextView mTextView;
        mTextView = (TextView) findViewById(R.id.output);

        if(networkOk){

            RequestQueue mRequestQueue = MySingleton.getInstance(this.getApplicationContext()).
                    getRequestQueue();

            JsonObjectRequest jsObjRequest = new JsonObjectRequest
                    (Request.Method.GET, urlOn, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            String test = "";
                            Log.d("lol", "lol");
                            try {
                               // mTextView.setText("Response: " + response.toJSONArray());
                                Iterator x = response.keys();
                                JSONArray jsonArray = new JSONArray();

                                while (x.hasNext()){
                                    Log.d("lol", "next ");
                                    String key = (String) x.next();
                                    jsonArray.put(response.get(key));
                                }
                                for (int i=0; i < jsonArray.length(); i++){
                                  test +=  jsonArray.getJSONObject(i).get("naamDevice").toString() + " ";
                                }
                                mTextView.setText("response: " + test);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO Auto-generated method stub

                        }


                    });

// Access the RequestQueue through your singleton class.
            MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);


// Formulate the request and handle the response.
//            StringRequest stringRequest = new StringRequest(Request.Method.GET, urlOn,
//                    new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            // Do something with the response
//                        }
//                    },
//                    new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            // Handle error
//                        }
//                    });

// Add the request to the RequestQueue.
//            MySingleton.getInstance(this).addToRequestQueue(stringRequest);
        Toast.makeText(this, "Led is aan", Toast.LENGTH_SHORT).show();
    }

 else {
        Toast.makeText(this, "Network not available!", Toast.LENGTH_SHORT).show();
        }
    }

    public void remoteOff(View view) {
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
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // Handle error
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
