package com.mad.mad;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;

import java.util.ArrayList;

import static android.R.layout.simple_spinner_item;

public class ShowAssign extends AppCompatActivity {

    private Button add;

    ListView listView;
    static Spinner spinner;

    private DatabaseHelper databaseHelper;
    private User user;
    private Context mContext;

static String selected;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.stu_assign_listview);
            getSupportActionBar().hide();

            add = findViewById(R.id.btnAdd);
            spinner = findViewById(R.id.spinner);

            databaseHelper = new DatabaseHelper(ShowAssign.this);
            listView = findViewById(R.id.listView);
            mContext = this;

            user = new User();

            String lan[] = getResources().getStringArray(R.array.Batch);


// Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.Batch, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
            spinner.setAdapter(adapter);


            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                    //lang.setOnItemSelectedListener(this);

                     selected =spinner.getSelectedItem().toString();

                  //  String tBatch = batch.getText().toString().trim();


                    //Select
                    ArrayList ta = databaseHelper.getTask(selected);


                    final String[] listValue = new String[ta.size()];

                    for(int i=0 ; i < ta.size() ; i++)
                    {

                        listValue[i] = ta.get(i).toString();
                    }

                    //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, listValue);

                    ArrayAdapter<String> adapter = new ArrayAdapter(mContext, android.R.layout.simple_list_item_multiple_choice, android.R.id.text1, listValue);

                    ListView listView =  findViewById(R.id.listView);
                    listView.setAdapter(adapter);
                    listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

                    OnItemClickListener itemClickListener = new OnItemClickListener() {
                        public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                            // AdapterView is the parent class of ListView
                            ListView lv = (ListView) arg0;

                            if (lv.isItemChecked(position)) {
                                // Toast.makeText(getBaseContext(), "You checked " + listValue[position], Toast.LENGTH_SHORT).show();
                                final String ck = listValue[position];
                                // boolean isUpdate = databaseHelper.updatePending(ck);

                                AlertDialog.Builder builder = new AlertDialog.Builder(ShowAssign.this);


                                builder.setMessage("Do you want submit assignment ?");


                                builder.setTitle("Alert !");


                                builder.setCancelable(false);


                                builder.setNegativeButton(
                                        "CANCEL",
                                        new DialogInterface
                                                .OnClickListener() {

                                            @Override
                                            public void onClick(DialogInterface dialog,
                                                                int which)
                                            {

                                                // If user click no
                                                // then dialog box is canceled.
                                                dialog.cancel();
                                            }
                                        });


                                builder.setPositiveButton(
                                        "SUBMIT",
                                        new DialogInterface
                                                .OnClickListener() {

                                            @Override
                                            public void onClick(DialogInterface dialog,
                                                                int which)
                                            {
                                                String mail = databaseHelper.getTaskMail(ck);
                                                Intent accountsIntent = new Intent(ShowAssign.this,SendAssign.class);
                                                accountsIntent.putExtra("EMAIL",mail);

                                                startActivity(accountsIntent);

                                            }
                                        });
                                // Set the Negative button with No name
                                // OnClickListener method is use


                                // Create the Alert dialog
                                AlertDialog alertDialog = builder.create();

                                // Show the Alert Dialog box
                                alertDialog.show();

                            }
                        }
                    };








                    listView.setOnItemClickListener(itemClickListener);


                }
            });




    }



}
