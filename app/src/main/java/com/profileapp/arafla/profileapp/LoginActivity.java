package com.profileapp.arafla.profileapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    String login, password;
    private AutoCompleteTextView mEmailView;
    public static final String MyPREFERENCES = "MyPrefs" ;
    private EditText mPasswordView;
    private View mProgressView;
    public static final String KEY_LOGIN = "login";
    public static final String KEY_PASSWORD = "password";
    private static final String REGISTER_URL = "http://profilapp.getsandbox.com/test";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        setContentView(R.layout.activity_login);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        login = mEmailView.getText().toString().trim();
        password = mPasswordView.getText().toString().trim();
        mProgressView = findViewById(R.id.login_progress);
        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mProgressView.setVisibility(true ? View.VISIBLE : View.GONE);
           //     mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                login = mEmailView.getText().toString();
                password = mPasswordView.getText().toString();
                registerUser();
            }
        });
    }

    private void registerUser() {
        try {
            Map<String, String> jsonParams = new HashMap<String, String>();
            jsonParams.put("login", login);
            jsonParams.put("password", password);
            RequestQueue queue = Volley.newRequestQueue(this);
            JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, "http://profilapp.getsandbox.com/login",
                    new JSONObject(jsonParams),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            if (response.toString().contains("ok")) {
                                SharedPreferences.Editor editor = sharedpreferences.edit();
                                editor.putString("login",login);
                                Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
                                LoginActivity.this.startActivity(myIntent);
                                mProgressView.setVisibility(false ? View.VISIBLE : View.INVISIBLE);
                            }
                            else if(response.toString().contains("password")){
                                Toast.makeText(LoginActivity.this, "Mot de passe incorrect", Toast.LENGTH_LONG).show();

                                mProgressView.setVisibility(false ? View.VISIBLE : View.INVISIBLE);
                            }
                            else{ Toast.makeText(LoginActivity.this, "Login incorrect", Toast.LENGTH_LONG).show();  mProgressView.setVisibility(false ? View.VISIBLE : View.INVISIBLE);}
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(LoginActivity.this, error.toString(), Toast.LENGTH_LONG).show();

                        }
                    }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json; charset=utf-8");
                    headers.put("User-agent", System.getProperty("http.agent"));
                    return headers;
                }
            };
            queue.add(postRequest);
            //   queue.add(stringRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
