package com.example.bojan.nibllbojanactivities;



import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bojan.nibllbojanactivities.utils.Apicall;
import com.example.bojan.nibllbojanactivities.utils.NetworkHelper;
import com.example.bojan.nibllbojanactivities.utils.RequestPackage;
import com.example.bojan.nibllbojanactivities.utils.ResponseApi;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public class deviceTest extends AppCompatActivity {
    private static final String urlOff =
            "http://192.168.1.128:5001/send?protocol=kaku_switch&id=27672578&unit=0&off=1";
    private static final String urlOn = "http://192.168.1.128:5001/send?protocol=kaku_switch&id=27672578&unit=0&off=1";
    private boolean networkOk;
    private boolean ledOn = false;
    TextView output, mTextView;

    private ProgressDialog pDialog;
    private String path = urlOn;
    OkHttpClient client;
    String response;
    private TextView tvDisc;
    private ResponseApi[] responseApis;

//    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            String message =
//                    intent.getStringExtra(MyService.MY_SERVICE_PAYLOAD);
//            output.append(message + "\n");
//        }
//    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_test);

        output = (TextView) findViewById(R.id.output);

//        LocalBroadcastManager.getInstance(getApplicationContext())
//                .registerReceiver(mBroadcastReceiver,
//                        new IntentFilter(MyService.MY_SERVICE_MESSAGE));

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

    private class PostDataTOServer extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(deviceTest.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            try {

                client = new OkHttpClient();

                response = Apicall.GET(client, path);

                Gson gson = new Gson();
                Type type = new TypeToken<Collection<ResponseApi>>() {}.getType();
                Collection<ResponseApi> enums = gson.fromJson(response, type);
                responseApis = enums.toArray(new ResponseApi[enums.size()]);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (pDialog.isShowing())
                pDialog.dismiss();
            tvDisc.setText(responseApis[0].getMessage());
        }
    }


//    public void initializeDiscoveryListener() {
//
//
//        // Instantiate a new DiscoveryListener
//       NsdManager mDiscoveryListener = new NsdManager.DiscoveryListener() {
//
//
//
//           public static final String TAG = "lol";
//
//           // Called as soon as service discovery begins.
//            @Override
//            public void onDiscoveryStarted(String regType) {
//                Log.d(TAG, "Service discovery started");
//            }
//
//            @Override
//            public void onServiceFound(NsdServiceInfo service) {
//                // A service was found! Do something with it.
//                Log.d(TAG, "Service discovery success" + service);
////                if (!service.getServiceType().equals(SERVICE_TYPE)) {
////                    // Service type is the string containing the protocol and
////                    // transport layer for this service.
////                    Log.d(TAG, "Unknown Service Type: " + service.getServiceType());
////                } else if (service.getServiceName().equals(mServiceName)) {
////                    // The name of the service tells the user what they'd be
////                    // connecting to. It could be "Bob's Chat App".
////                    Log.d(TAG, "Same machine: " + mServiceName);
////                } else if (service.getServiceName().contains("NsdChat")){
////                    mNsdManager.resolveService(service, mResolveListener);
////                }
//            }
//
//            @Override
//            public void onServiceLost(NsdServiceInfo service) {
//                // When the network service is no longer available.
//                // Internal bookkeeping code goes here.
//                Log.e(TAG, "service lost" + service);
//            }
//
//            @Override
//            public void onDiscoveryStopped(String serviceType) {
//                Log.i(TAG, "Discovery stopped: " + serviceType);
//            }
//
//            @Override
//            public void onStartDiscoveryFailed(String serviceType, int errorCode) {
//                Log.e(TAG, "Discovery failed: Error code:" + errorCode);
////                mNsdManager.stopServiceDiscovery(this);
//            }
//
//            @Override
//            public void onStopDiscoveryFailed(String serviceType, int errorCode) {
//                Log.e(TAG, "Discovery failed: Error code:" + errorCode);
//                mNsdManager.stopServiceDiscovery(this);
//            }
//        };
//    }

//    public void initializeResolveListener() {
//
//       NsdManager mResolveListener = new NsdManager.ResolveListener() {
//           public static final String TAG = "lol";
//
//            @Override
//            public void onResolveFailed(NsdServiceInfo serviceInfo, int errorCode) {
//                // Called when the resolve fails. Use the error code to debug.
//                Log.e(TAG, "Resolve failed" + errorCode);
//            }
//
//            @Override
//            public void onServiceResolved(NsdServiceInfo serviceInfo) {
//                Log.e(TAG, "Resolve Succeeded. " + serviceInfo);
//
//                if (serviceInfo.getServiceName().equals(mServiceName)) {
//                    Log.d(TAG, "Same IP.");
//                    return;
//                }
//                NsdServiceInfo mService = serviceInfo;
//                int port = mService.getPort();
//                InetAddress host = mService.getHost();
//            }
//        };
//    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

//        LocalBroadcastManager.getInstance(getApplicationContext())
//                .unregisterReceiver(mBroadcastReceiver);
    }

    public void remoteOn(View view) {
        if(networkOk){
//        Intent intent = new Intent(this, MyService.class);
//                intent.setData(Uri.parse(urlOn));
//                startService(intent);
        // Instantiate the RequestQueue.
        tvDisc = (TextView) findViewById(R.id.output);
            new PostDataTOServer().execute();
//        RequestQueue queue = Volley.newRequestQueue(this);
//
//// Request a string response from the provided URL.
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlOn,
//                new Response.Listener<String>() {
//
//                    @Override
//                    public void onResponse(String response) {
//                    }
//                }, new Response.ErrorListener() {
//            public void onErrorResponse(VolleyError error) {
//                Log.i("fuck you all!!!!", "onErrorResponse: didn't work");
//            }
//        });
// Add the request to the RequestQueue.
//        queue.add(stringRequest);
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
        } else {
            Toast.makeText(this, "Network not available!", Toast.LENGTH_SHORT).show();
        }

    }

    public void runClickHandler(View view) {

        if (networkOk) {
            if(ledOn){
//                Intent intent = new Intent(this, MyService.class);
//                intent.setData(Uri.parse(urlOff));
//                startService(intent);
                // Instantiate the RequestQueue.
                RequestPackage requestPackage = new RequestPackage();
                requestPackage.setEndPoint(urlOn);
                requestPackage.setParam("category", "Entrees");
                requestPackage.setMethod("GET");

//                RequestQueue queue = Volley.newRequestQueue(this);
//
//// Request a string response from the provided URL.
//                StringRequest stringRequest = new StringRequest(Request.Method.GET, urlOff,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.i("fuck you all!!!!", "onErrorResponse: didn't work");
//                    }
//                });
//// Add the request to the RequestQueue.
//                queue.add(stringRequest);
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
