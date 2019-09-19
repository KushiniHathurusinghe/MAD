package com.mad.mad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private User user;

    Button buttonReset;
    EditText password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);
        getSupportActionBar().hide();

        databaseHelper = new DatabaseHelper(this);

        buttonReset = findViewById(R.id.reset);
        password =findViewById(R.id.password);

        final String nameFromIntent = getIntent().getStringExtra("INDEX");


        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isUpdate = databaseHelper.updateStuPassword
                        (nameFromIntent ,password.getText().toString() );

                if (isUpdate == true)
                    Toast.makeText(ChangePassword.this, "New Password Updated", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(ChangePassword.this, "Password did not Updated", Toast.LENGTH_LONG).show();


            }
        });

    }
}
