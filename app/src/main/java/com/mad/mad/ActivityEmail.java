package com.mad.mad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityEmail extends AppCompatActivity {

    EditText editTextTo;
    EditText editTextSubject;

    EditText editTextM;

    Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);
        getSupportActionBar().hide();

        editTextTo = findViewById(R.id.editTextTO);
        editTextSubject = findViewById(R.id.editTextSubject);

        editTextM = findViewById(R.id.editTextM);

        Intent intent = getIntent();

        final String nameFromIntent = getIntent().getStringExtra("INDEX1");
        final String nameFromIntent1 = getIntent().getStringExtra("NAME1");
        final String nameFromIntent2 = getIntent().getStringExtra("EMAIL1");
        final String nameFromIntent3 = getIntent().getStringExtra("PHONE1");
        final String nameFromIntent4 = getIntent().getStringExtra("GPA1");
        final String nameFromIntent5 = getIntent().getStringExtra("BATCH1");

        editTextM.setText("INDEX : " + nameFromIntent + " \n " + "NAME : " + nameFromIntent1 + " \n " + "EMAIL : " + nameFromIntent2 + " \n " + "PHONE : " + nameFromIntent3 + " \n " + "GPA : " + nameFromIntent4  + " \n " + "BATCH : " + nameFromIntent5);



        buttonSend = findViewById(R.id.buttonSend);

        buttonSend.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendMail();
            }
        });




    }


    private void sendMail()
    {
        String recipientList = editTextTo.getText().toString();
        String[] recipients = recipientList.split(",");

        String subject = editTextSubject.getText().toString();
        String message = editTextM.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }
}
