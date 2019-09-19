package com.mad.mad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LectProfile extends AppCompatActivity {


    private DatabaseHelper databaseHelper;
    private User user;

    EditText editTextIndexNo;
    EditText editTextName;
    EditText editTextEmail;


    Button buttonSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lect_profile);
        getSupportActionBar().hide();

        databaseHelper = new DatabaseHelper(this);


        editTextIndexNo = findViewById(R.id.editTextIndexNo);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);


        buttonSave = findViewById(R.id.buttonSave);



        final String nameFromIntent = getIntent().getStringExtra("INDEX");
        final String nameFromIntent1 = getIntent().getStringExtra("NAME");
        final String nameFromIntent2 = getIntent().getStringExtra("EMAIL");


        editTextIndexNo.setText(nameFromIntent);
        editTextName.setText(nameFromIntent1);
        editTextEmail.setText(nameFromIntent2);



        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isUpdate = databaseHelper.updateLectData
                        (editTextIndexNo.getText().toString(),
                                editTextName.getText().toString(),
                                editTextEmail.getText().toString());

                if (isUpdate == true)
                    Toast.makeText(LectProfile.this, "Data Update", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(LectProfile.this, "Data not Updated", Toast.LENGTH_LONG).show();


            }
        });
    }
}