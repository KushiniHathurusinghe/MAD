package com.mad.mad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LectRegister extends AppCompatActivity {
    private Button btnLogin,btnSignup;

    EditText editTextIndexNo;
    EditText editTextName;
    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextConfirmPassword;

    TextView textViewIndexNo;
    TextView textViewName;
    TextView textViewEmail;
    TextView textViewPassword;
    TextView textViewConfirmPassword;

    Button buttonSignUp;

    private DatabaseHelper databaseHelper;
    private InputValidation inputValidation;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lect_register);
        getSupportActionBar().hide();
        databaseHelper = new DatabaseHelper(this);

        btnLogin=findViewById(R.id.btnLogin);
        btnSignup=findViewById(R.id.buttonSignUp);


        //find TextViews and buttons by id
        editTextIndexNo = findViewById(R.id.editTextIndexNo);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword=findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);

        textViewIndexNo = findViewById(R.id.textViewIndexNo);
        textViewName = findViewById(R.id.textViewName);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewPassword = findViewById(R.id.textViewPassword);
        textViewConfirmPassword= findViewById(R.id.textViewConfirmPassword);


        buttonSignUp = findViewById(R.id.buttonLogin);

        databaseHelper = new DatabaseHelper(LectRegister.this);
        inputValidation = new InputValidation(LectRegister.this);
        user = new User();

        btnLogin.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {

                Intent intent = new Intent(LectRegister.this,LectLogin.class);
                startActivity(intent);

            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                postDataToSQLite();
            }

            private void postDataToSQLite()
            {


                if(!inputValidation.isEditTextFilled(editTextIndexNo,getString(R.string.error_Index)))
                {
                    return;
                }
                if(!inputValidation.isLectEditTextIndexNo(editTextIndexNo,getString(R.string.error_valid_Index)))
                {
                    return;
                }

                if(!inputValidation.isEditTextFilled(editTextName,getString(R.string.error_name)))
                {
                    return;
                }

                if(!inputValidation.isEditTextFilled(editTextEmail,getString(R.string.error_Email)))
                {
                    return;
                }
                if(!inputValidation.isEditTextEmail(editTextEmail,getString(R.string.error_valid_Email)))
                {
                    return;
                }

                if(!inputValidation.isEditTextFilled(editTextPassword,getString(R.string.error_password)))
                {
                    return;
                }
                if(!inputValidation.isEditTextFilled(editTextConfirmPassword,getString(R.string.error_password)))
                {
                    return;
                }



                if(!inputValidation.isEditTextMatches(editTextPassword,editTextConfirmPassword,getString(R.string.error_ConPassword)))
                {
                    return;
                }



                if (!databaseHelper.checkLectEmail(editTextEmail.getText().toString().trim()))
                {

                    user.setLectIndex(editTextIndexNo.getText().toString().trim());
                    user.setLectName(editTextName.getText().toString().trim());
                    user.setLectEmail(editTextEmail.getText().toString().trim());
                    user.setLectPassword(editTextPassword.getText().toString().trim());

                    databaseHelper.addLect(user);

                    // Snack Bar to show success message that record saved successfully
                    Toast.makeText(LectRegister.this, getString(R.string.Registered), Toast.LENGTH_SHORT).show();

                    EmptyEditText();

                }
                else
                {

                    Toast.makeText(LectRegister.this, getString(R.string.error_Email_exist), Toast.LENGTH_SHORT).show();
                }
            }




            private void EmptyEditText()
            {
                editTextIndexNo.setText(null);
                editTextName.setText(null);
                editTextEmail.setText(null);
                editTextPassword.setText(null);
                editTextConfirmPassword.setText(null);
            }
        });
    }


}


