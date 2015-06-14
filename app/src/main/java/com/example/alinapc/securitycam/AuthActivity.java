package com.example.alinapc.securitycam;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AuthActivity extends ActionBarActivity {

    EditText editText_Username;
    EditText editText_Password;
    Button but_login;
    TextView tvCreate;
    Context c;

    UserPhoneStore userPhoneStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        final Intent intent = getIntent();

        editText_Username   = (EditText) findViewById(R.id.editText_Username);
        editText_Password   = (EditText) findViewById(R.id.editText_Password);
        but_login           = (Button)   findViewById(R.id.but_login);
        tvCreate            = (TextView) findViewById(R.id.tvCreate);
        c                   = this;
        userPhoneStore      = new UserPhoneStore(this);



        but_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User(null, null, null);

                System.out.println("Login hit");
                String username = editText_Username.getText() + "";
                String password = editText_Password.getText() + "";

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);

                if(username.length() == 0 || password.length() == 0){

                    Toast.makeText(c, "Please fill the username and password", Toast.LENGTH_SHORT).show();

                    return;

                }

                userPhoneStore.setLoggedInUser(true);

                userPhoneStore.storeUserData(user); ////////to be developed ///////

                Intent intent = new Intent(c, ChooseActivity.class);
                startActivity(intent);
            }
        });

        tvCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, RegisterActivity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_auth, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
