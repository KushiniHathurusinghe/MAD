package com.mad.mad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity
{


    private Button btnSignup;

    EditText editTextIndexNo;
    EditText editTextPassword;

    TextView textViewIndexNo;
    TextView textViewPassword;

    Button buttonLogin;


    private DatabaseHelper databaseHelper;
    private InputValidation inputValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getSupportActionBar().hide();


        //find TextViews and buttons by id
        editTextIndexNo = findViewById(R.id.editTextIndexNo);
        editTextPassword=findViewById(R.id.editTextPassword);

        textViewIndexNo = findViewById(R.id.textViewIndexNo);
        textViewPassword = findViewById(R.id.textViewPassword);

        buttonLogin = findViewById(R.id.buttonLogin);


        btnSignup=findViewById(R.id.btnSignup);


        databaseHelper = new DatabaseHelper(LoginActivity.this);
        inputValidation = new InputValidation(LoginActivity.this);


        //signUp Button
        btnSignup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(LoginActivity.this,RegistationActivity.class);
                startActivity(intent);
            }
        });

        //Login Button

        buttonLogin.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                verifyFromSQLite();

            }

            private void verifyFromSQLite()
            {

                if(!inputValidation.isEditTextFilled(editTextIndexNo,getString(R.string.error_Index)))
                {

                    return;
                }

                if(!inputValidation.isEditTextFilled(editTextPassword,getString(R.string.error_password)))
                {
                    return;
                }

                if(databaseHelper.checkUser(editTextIndexNo.getText().toString().trim() ,
                        editTextPassword.getText().toString().trim()))
                {

                    Intent accountsIntent = new Intent(LoginActivity.this,UserActitivity.class);
                    accountsIntent.putExtra("INDEX",editTextIndexNo.getText().toString().trim());
                    emptyEditText();
                    startActivity(accountsIntent);


                }
                else
                {
                    Toast.makeText(LoginActivity.this, getString(R.string.error_Login), Toast.LENGTH_SHORT).show();
                }





            }

            private void emptyEditText()
            {
                editTextIndexNo.setText(null);
                editTextPassword.setText(null);
            }
        });


    }


}
