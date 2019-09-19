package com.mad.mad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserActitivity extends AppCompatActivity {

    private TextView textViewName;
    private Button buttonProfile;
    private Button buttonAssign;
    private Button buttonPassword;
    private Button buttonLogOut;


    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);
        getSupportActionBar().hide();

        textViewName = (TextView) findViewById(R.id.textViewWelcome);

        databaseHelper = new DatabaseHelper(this);

        Intent intent = getIntent();



        final String nameFromIntent = getIntent().getStringExtra("INDEX");
        String name =  databaseHelper.getName(nameFromIntent);
        textViewName.setText("Welcome " +  name);

        buttonProfile = findViewById(R.id.buttonProfile);
        buttonAssign = findViewById(R.id.Assign);
        buttonPassword = findViewById(R.id.password);
        buttonLogOut = findViewById(R.id.logOut);

        buttonProfile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String name =  databaseHelper.getName(nameFromIntent);
                String mail =  databaseHelper.getMail(nameFromIntent);
                String phone =  databaseHelper.getPhone(nameFromIntent);
                String GPA =  databaseHelper.getGPA(nameFromIntent);
                String batch = databaseHelper.getBatch(nameFromIntent);

                Intent accountsIntent = new Intent(UserActitivity.this,ProfileActivity.class);
                accountsIntent.putExtra("INDEX",nameFromIntent);
                accountsIntent.putExtra("NAME",name);
                accountsIntent.putExtra("EMAIL",mail);
                accountsIntent.putExtra("PHONE",phone);
                accountsIntent.putExtra("GPA",GPA);
                accountsIntent.putExtra("BATCH",batch);
                startActivity(accountsIntent);
            }
        });


        buttonAssign.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String batch = databaseHelper.getBatch(nameFromIntent);

                Intent accountsIntent = new Intent(UserActitivity.this,ShowAssign.class);
                accountsIntent.putExtra("BATCH",batch);
                startActivity(accountsIntent);
            }
        });

        buttonPassword.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {


                Intent accountsIntent = new Intent(UserActitivity.this,ChangePassword.class);
                accountsIntent.putExtra("INDEX",nameFromIntent);
                startActivity(accountsIntent);
            }
        });

        buttonLogOut.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {


                Intent accountsIntent = new Intent(UserActitivity.this,MainActivity.class);
                startActivity(accountsIntent);
            }
        });

    }



}

