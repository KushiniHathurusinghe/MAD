package com.mad.mad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistationActivity extends AppCompatActivity {


        private Button btnLogin,btnSignup;

        EditText editTextIndexNo;
        EditText editTextName;
        EditText editTextEmail;
        EditText editTextMobileNo;
        EditText editTextGPA;
        EditText editTextBatch;
        EditText editTextPassword;
        EditText editTextConfirmPassword;

        TextView textViewIndexNo;
        TextView textViewName;
        TextView textViewEmail;
        TextView textViewMobileNo;
        TextView textViewGPA;
        TextView textViewBatch;
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
            setContentView(R.layout.registation);
            getSupportActionBar().hide();
            databaseHelper = new DatabaseHelper(this);

            btnLogin=findViewById(R.id.btnLogin);
            btnSignup=findViewById(R.id.buttonSignUp);


            //find TextViews and buttons by id
            editTextIndexNo = findViewById(R.id.editTextIndexNo);
            editTextName = findViewById(R.id.editTextName);
            editTextEmail = findViewById(R.id.editTextEmail);
            editTextMobileNo = findViewById(R.id.editTextMobileNo);
            editTextGPA = findViewById(R.id.editTextGPA);
            editTextBatch =findViewById(R.id.editTextBatch);
            editTextPassword=findViewById(R.id.editTextPassword);
            editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);

            textViewIndexNo = findViewById(R.id.textViewIndexNo);
            textViewName = findViewById(R.id.textViewName);
            textViewEmail = findViewById(R.id.textViewEmail);
            textViewMobileNo= findViewById(R.id.textViewMobileNo);
            textViewGPA = findViewById(R.id.textViewGPA);
            textViewBatch = findViewById(R.id.textViewBatch);
            textViewPassword = findViewById(R.id.textViewPassword);
            textViewConfirmPassword= findViewById(R.id.textViewConfirmPassword);


            buttonSignUp = findViewById(R.id.buttonLogin);

            databaseHelper = new DatabaseHelper(RegistationActivity.this);
            inputValidation = new InputValidation(RegistationActivity.this);
            user = new User();

            btnLogin.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View view)
                {

                    Intent intent = new Intent(RegistationActivity.this,LoginActivity.class);
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
                    if(!inputValidation.isEditTextIndexNo(editTextIndexNo,getString(R.string.error_valid_Index)))
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
                    if(!inputValidation.isEditTextFilled(editTextMobileNo,getString(R.string.error_phoneNo)))
                    {
                        return;
                    }
                    if(!inputValidation.isEditTextPhoneNo(editTextMobileNo,getString(R.string.error_valid_PhoneNo)))
                    {
                        return;
                    }
                    if(!inputValidation.isEditTextFilled(editTextGPA,getString(R.string.error_GPA)))
                    {
                        return;
                    }
                    if(!inputValidation.isEditTextFilled(editTextBatch,getString(R.string.error_Batch)))
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


                    if(!inputValidation.isEditTextFilled(editTextConfirmPassword,getString(R.string.error_password)))
                    {
                        return;
                    }


                    if(!inputValidation.isEditTextMatches(editTextPassword,editTextConfirmPassword,getString(R.string.error_ConPassword)))
                    {
                        return;
                    }



                    if (!databaseHelper.checkEmail(editTextEmail.getText().toString().trim()))
                    {

                        user.setIndex(editTextIndexNo.getText().toString().trim());
                        user.setName(editTextName.getText().toString().trim());
                        user.setEmail(editTextEmail.getText().toString().trim());
                        user.setPhone(editTextMobileNo.getText().toString().trim());
                        user.setGPA(editTextGPA.getText().toString().trim());
                        user.setBatch(editTextBatch.getText().toString().trim());
                        user.setPassword(editTextPassword.getText().toString().trim());

                        databaseHelper.addUser(user);

                        // Snack Bar to show success message that record saved successfully
                        Toast.makeText(RegistationActivity.this, getString(R.string.Registered), Toast.LENGTH_SHORT).show();

                        EmptyEditText();

                    }
                    else
                    {

                        Toast.makeText(RegistationActivity.this, getString(R.string.error_Email_exist), Toast.LENGTH_SHORT).show();
                    }
                }




                private void EmptyEditText()
                {
                    editTextIndexNo.setText(null);
                    editTextName.setText(null);
                    editTextEmail.setText(null);
                    editTextMobileNo.setText(null);
                    editTextGPA.setText(null);
                    editTextBatch.setText(null);
                    editTextPassword.setText(null);
                    editTextConfirmPassword.setText(null);
                }
            });
        }


    }


