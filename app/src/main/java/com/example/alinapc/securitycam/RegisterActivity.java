package com.example.alinapc.securitycam;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends ActionBarActivity {

    EditText etFname;
    EditText etSurname;
    EditText etAge;
    EditText etUsername;
    EditText etPassword;
    EditText etRetype;
    Button   bRegister;

    Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFname      = (EditText) findViewById(R.id.etFname);
        etSurname    = (EditText) findViewById(R.id.etSurname);
        etAge        = (EditText) findViewById(R.id.etAge);
        etUsername   = (EditText) findViewById(R.id.etUsername);
        etPassword   = (EditText) findViewById(R.id.etPassword);
        etRetype     = (EditText) findViewById(R.id.etRetype);
        bRegister    = (Button)   findViewById(R.id.bRegister);
        c            = this;


        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fname        = etFname.getText().toString();
                String surname      = etSurname.getText().toString();
                int age             = Integer.parseInt(etAge.getText().toString());
                String username     = etUsername.getText().toString();
                String pass         = etPassword.getText().toString();
                String retype       = etRetype.getText().toString();

                User registerData = new User(fname, surname, age, username, pass, retype);


                if(fname.length() == 0 || surname.length() == 0 || age == 0 ||
                        username.length() == 0 || pass.length() == 0 || retype.length() == 0){
                    Toast.makeText(c, "Please fill all the fields!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(pass != retype){
                    Toast.makeText(c, "Type the password correctly!", Toast.LENGTH_LONG).show();
                    return;

                }


            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
