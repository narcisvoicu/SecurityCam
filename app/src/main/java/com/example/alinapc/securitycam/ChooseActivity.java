package com.example.alinapc.securitycam;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ChooseActivity extends ActionBarActivity {

    Button      bCamera;
    Button      bViewer;
    TextView    tvLogout;

    Context     c;

    UserPhoneStore userPhoneStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        bCamera     = (Button) findViewById(R.id.bCamera);
        bViewer     = (Button) findViewById(R.id.bViewer);
        tvLogout    = (TextView) findViewById(R.id.tvLogout);
        c           = this;
        userPhoneStore = new UserPhoneStore(this);


        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPhoneStore.clearData();
                userPhoneStore.setLoggedInUser(false);

                Intent intent = new Intent(c, AuthActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose, menu);
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
