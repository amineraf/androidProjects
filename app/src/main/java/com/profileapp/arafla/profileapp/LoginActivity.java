package com.profileapp.arafla.profileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

import model.Account;
import service.FormationService;
import sheredValues.CommonSharedPreferences;

public class LoginActivity extends AppCompatActivity {
    private static final String URL_LOGIN ="http://profilapp.getsandbox.com/login" ;
    String login, password;
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, URL_LOGIN,
                    new JSONObject(jsonParams),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            String status = response.optString("status");
                            Account account=new Account();
                            account.setLogin(login);
                            account.setAvatar(response.optString("avatar"));
                            if ("ok".equals(status)) {
                                ArrayList<String> formationList = FormationService.getInstance().getAllFormations();
                                CommonSharedPreferences.getInstance(getApplicationContext()).setFormationList(formationList);
                                CommonSharedPreferences.getInstance(getApplicationContext()).setAccount(account);
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
