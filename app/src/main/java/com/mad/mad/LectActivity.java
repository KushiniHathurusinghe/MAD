package com.mad.mad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LectActivity extends AppCompatActivity {
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
        setContentView(R.layout.lectr);
        getSupportActionBar().hide();

        textViewName =  findViewById(R.id.textViewWelcome);

        databaseHelper = new DatabaseHelper(this);

        Intent intent = getIntent();

        final String nameFromIntent = getIntent().getStringExtra("INDEX");
        String name =  databaseHelper.getLectName(nameFromIntent);
        textViewName.setText("Welcome " + name);

        buttonProfile = findViewById(R.id.profile);
        buttonAssign = findViewById(R.id.Assign);
        buttonPassword = findViewById(R.id.password);
        buttonLogOut = findViewById(R.id.logOut);

        buttonProfile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String name =  databaseHelper.getLectName(nameFromIntent);
                String mail =  databaseHelper.getLectMail(nameFromIntent);


                Intent accountsIntent = new Intent(LectActivity.this,LectProfile.class);
                accountsIntent.putExtra("INDEX",nameFromIntent);
                accountsIntent.putExtra("NAME",name);
                accountsIntent.putExtra("EMAIL",mail);
                startActivity(accountsIntent);
            }
        });


        buttonAssign.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent accountsIntent = new Intent(LectActivity.this,LectAssign.class);
                startActivity(accountsIntent);

            }
        });

        buttonPassword.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent accountsIntent = new Intent(LectActivity.this,LectChangePassword.class);
                accountsIntent.putExtra("INDEX",nameFromIntent);
                startActivity(accountsIntent);

            }
        });

        buttonLogOut.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {


                Intent accountsIntent = new Intent(LectActivity.this,MainActivity.class);
                startActivity(accountsIntent);
            }
        });


    }


}