package com.mad.mad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LectAssign extends AppCompatActivity {

    EditText task;
    EditText subject;
    EditText batch;
    EditText email;
    Button buttonAdd;

    private DatabaseHelper databaseHelper;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lect_assign);
        getSupportActionBar().hide();

        databaseHelper = new DatabaseHelper(this);
        user = new User();


        task  = findViewById(R.id.task);
        subject = findViewById(R.id.Subject);
        batch = findViewById(R.id.batch);
        email = findViewById(R.id.email);
        buttonAdd = findViewById(R.id.Add);



        buttonAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                user.setTaskName(task.getText().toString().trim());
                user.setTaskSubject(subject.getText().toString().trim());
                user.setTaskBatch(batch.getText().toString().trim());
                user.setTaskEmail(email.getText().toString().trim());
                databaseHelper.addTask(user);

                Toast.makeText(LectAssign.this, "Successful", Toast.LENGTH_SHORT).show();

            }
        });






    }


}
