package com.mad.mad;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class ProfileActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private User user;

    EditText editTextIndexNo;
    EditText editTextName;
    EditText editTextEmail;
    EditText editTextMobileNo;
    EditText editTextGPA;
    EditText editTextBatch;

    Button buttonSave;
    Button buttonEmail;





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        getSupportActionBar().hide();

        databaseHelper = new DatabaseHelper(this);


        editTextIndexNo = findViewById(R.id.editTextIndexNo);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextMobileNo = findViewById(R.id.editTextMobileNo);
        editTextGPA = findViewById(R.id.editTextGPA);
        editTextBatch = findViewById(R.id.editTextBatch);

        buttonSave = findViewById(R.id.buttonSave);
        buttonEmail = findViewById(R.id.buttonEmail);



        final String nameFromIntent = getIntent().getStringExtra("INDEX");
        final String nameFromIntent1 = getIntent().getStringExtra("NAME");
        final String nameFromIntent2 = getIntent().getStringExtra("EMAIL");
        final String nameFromIntent3 = getIntent().getStringExtra("PHONE");
        final String nameFromIntent4 = getIntent().getStringExtra("GPA");
        final String nameFromIntent5 = getIntent().getStringExtra("BATCH");

        editTextIndexNo.setText( nameFromIntent);
        editTextName.setText(nameFromIntent1);
        editTextEmail.setText(nameFromIntent2);
        editTextMobileNo.setText(nameFromIntent3);
        editTextGPA.setText(nameFromIntent4);
        editTextBatch.setText(nameFromIntent5);


        buttonSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                boolean isUpdate = databaseHelper.updateData
                        (editTextIndexNo.getText().toString(),
                                editTextName.getText().toString(),
                                editTextEmail.getText().toString(),
                                editTextMobileNo.getText().toString(),
                                editTextGPA.getText().toString() ,
                                editTextBatch.getText().toString());

                if(isUpdate == true)
                    Toast.makeText(ProfileActivity.this,"Data Update",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(ProfileActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();




            }
        });

        buttonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent accountsIntent = new Intent(ProfileActivity.this,ActivityEmail.class);
                accountsIntent.putExtra("INDEX1",nameFromIntent);
                accountsIntent.putExtra("NAME1",nameFromIntent1);
                accountsIntent.putExtra("EMAIL1",nameFromIntent2);
                accountsIntent.putExtra("PHONE1",nameFromIntent3);
                accountsIntent.putExtra("GPA1",nameFromIntent4);
                accountsIntent.putExtra("BATCH1",nameFromIntent5);
                startActivity(accountsIntent);

            }
        });





    }


}



