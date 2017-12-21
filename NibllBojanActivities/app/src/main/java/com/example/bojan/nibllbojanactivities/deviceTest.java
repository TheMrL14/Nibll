package com.example.bojan.nibllbojanactivities;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bojan.nibllbojanactivities.services.MyService;
import com.example.bojan.nibllbojanactivities.utils.NetworkHelper;

public class deviceTest extends AppCompatActivity {
    private static final String urlOff =
            "http://nibll.local:5001/send?protocol=kaku_switch&id=5218304&unit=1&repeat=5&off=1";
    private static final String urlOn = "http://nibll.local:5001/send?protocol=kaku_switch&id=5218304&unit=1&repeat=5&on=1";
    private boolean networkOk;
    private boolean ledOn = false;
    TextView output, mTextView;

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String message =
                    intent.getStringExtra(MyService.MY_SERVICE_PAYLOAD);
            output.append(message + "\n");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_test);

        output = (TextView) findViewById(R.id.output);

        LocalBroadcastManager.getInstance(getApplicationContext())
                .registerReceiver(mBroadcastReceiver,
                        new IntentFilter(MyService.MY_SERVICE_MESSAGE));

        networkOk = NetworkHelper.hasNetworkAccess(this);
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

        LocalBroadcastManager.getInstance(getApplicationContext())
                .unregisterReceiver(mBroadcastReceiver);
    }

    public void runClickHandler(View view) {

        if (networkOk) {
            if(ledOn){
//                Intent intent = new Intent(this, MyService.class);
//                intent.setData(Uri.parse(urlOff));
//                startService(intent);
                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(this);

// Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, urlOff,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("fuck you all!!!!", "onErrorResponse: didn't work");
                    }
                });
// Add the request to the RequestQueue.
                queue.add(stringRequest);
                Toast.makeText(this, "Led is uit", Toast.LENGTH_SHORT).show();
            }else{
//                Intent intent = new Intent(this, MyService.class);
//                intent.setData(Uri.parse(urlOn));
//                startService(intent);
                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(this);

// Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, urlOn,
                        new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                    }
                }, new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        Log.i("fuck you all!!!!", "onErrorResponse: didn't work");
                    }
                });
// Add the request to the RequestQueue.
                queue.add(stringRequest);
                Toast.makeText(this, "Led is aan", Toast.LENGTH_SHORT).show();
            }
        ledOn = !ledOn;
        } else {
            Toast.makeText(this, "Network not available!", Toast.LENGTH_SHORT).show();
        }
    }


}
