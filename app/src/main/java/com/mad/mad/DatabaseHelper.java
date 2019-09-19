package com.mad.mad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper  extends SQLiteOpenHelper
{

    private static final int DATABASE_VERSION = 5;

    private static final String DATABASE_NAME = "LMS.DB";


    //Student data


    private static final String TABLE_USER = "Stud_Infor";

    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_INDEX = "user_index";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PHONE = "user_phone";
    private static final String COLUMN_USER_GPA = "user_GPA";
    private static final String COLUMN_USER_BATCH = "user_batch";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_USER_INDEX + " TEXT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PHONE + " TEXT,"
            + COLUMN_USER_BATCH + " TEXT,"
            + COLUMN_USER_GPA + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";



    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;


    //lecturer data

    private static final String TABLE_LECTURER = "lect_Info";

    private static final String COLUMN_LECT_ID = "lect_id";
    private static final String COLUMN_LECT_INDEX = "lect_index";
    private static final String COLUMN_LECT_NAME = "lect_name";
    private static final String COLUMN_LECT_EMAIL = "lect_email";
    private static final String COLUMN_LECT_PASSWORD = "lect_password";

    private String CREATE_LECT_TABLE = "CREATE TABLE " + TABLE_LECTURER + "("
            + COLUMN_LECT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_LECT_INDEX + " TEXT," + COLUMN_LECT_NAME + " TEXT,"
            + COLUMN_LECT_EMAIL + " TEXT," + COLUMN_LECT_PASSWORD + " TEXT" + ")";



    private String DROP_LECT_TABLE = "DROP TABLE IF EXISTS " + TABLE_LECTURER;


    //task

    private static final String TABLE_TASK   = "task_Info";

    private static final String COLUMN_TASK_ID = "task_id";
    private static final String COLUMN_TASK_NAME = "task_name";
    private static final String COLUMN_TASK_SUBJECT = "task_subject";
    private static final String COLUMN_TASK_BATCH = "task_batch";
    private static final String COLUMN_TASK_EMAIL = "task_email";


    private String CREATE_TASK_TABLE = "CREATE TABLE " + TABLE_TASK + "("
            + COLUMN_TASK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_TASK_NAME + " TEXT," + COLUMN_TASK_SUBJECT + " TEXT,"
            + COLUMN_TASK_BATCH + " TEXT," + COLUMN_TASK_EMAIL + " TEXT" + ")";



    private String DROP_TASK_TABLE = "DROP TABLE IF EXISTS " + TABLE_TASK;












    // create

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_LECT_TABLE);
        db.execSQL(CREATE_TASK_TABLE);
    }

    @Override
    public  void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(DROP_USER_TABLE);
        db.execSQL(DROP_LECT_TABLE);
        db.execSQL(DROP_TASK_TABLE);
        onCreate(db);
    }


//Insert Students

    public void addUser(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_INDEX, user.getIndex());
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PHONE, user.getPhone());
        values.put(COLUMN_USER_GPA, user.getGPA());
        values.put(COLUMN_USER_BATCH,user.getBatch());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        db.insert(TABLE_USER, null, values);
        db.close();
    }


    //lecturer Insert
    public void addLect(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LECT_INDEX, user.getLectIndex());
        values.put(COLUMN_LECT_NAME, user.getLectName());
        values.put(COLUMN_LECT_EMAIL,user.getLectEmail());
        values.put(COLUMN_LECT_PASSWORD, user.getLectPassword());

        db.insert(TABLE_LECTURER, null, values);
        db.close();
    }


    public void addTask(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TASK_NAME, user.getTaskName());
        values.put(COLUMN_TASK_SUBJECT, user.getTaskSubject());
        values.put(COLUMN_TASK_BATCH,user.getTaskBatch());
        values.put(COLUMN_TASK_EMAIL, user.getTaskEmail());

        db.insert(TABLE_TASK, null, values);
        db.close();
    }




// Student select


    public String getName(String index)
    {
        String result = "";
        String[] columns = {
                COLUMN_USER_NAME
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_USER_INDEX + " = ?";
        String[] selectionArgs = { index };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        while (cursor.moveToNext())
        {
            result = cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME));
        }
        cursor.close();
        db.close();
        return result;
    }

    public String getMail(String index)
    {
        String result = "";
        String[] columns = {
                COLUMN_USER_EMAIL
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_USER_INDEX + " = ?";
        String[] selectionArgs = { index };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        while (cursor.moveToNext()){
            result = cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL));
        }
        cursor.close();
        db.close();
        return result;
    }


    public String getPhone(String index)
    {
        String result = "";
        String[] columns = {
                COLUMN_USER_PHONE
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_USER_INDEX + " = ?";
        String[] selectionArgs = { index };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        while (cursor.moveToNext()){
            result = cursor.getString(cursor.getColumnIndex(COLUMN_USER_PHONE));
        }
        cursor.close();
        db.close();
        return result;
    }


    public String getGPA(String index)
    {
        String result = "";
        String[] columns = {
                COLUMN_USER_GPA
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_USER_INDEX + " = ?";
        String[] selectionArgs = { index };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        while (cursor.moveToNext()){
            result = cursor.getString(cursor.getColumnIndex(COLUMN_USER_GPA));
        }
        cursor.close();
        db.close();
        return result;
    }



    public String getBatch(String index)
    {
        String result = "";
        String[] columns = {
                COLUMN_USER_BATCH
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_USER_INDEX + " = ?";
        String[] selectionArgs = { index };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        while (cursor.moveToNext()){
            result = cursor.getString(cursor.getColumnIndex(COLUMN_USER_BATCH));
        }
        cursor.close();
        db.close();
        return result;
    }



    //student info update

    public boolean updateData(String index,String name,String mail,String Phone ,String GPA , String batch) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USER_INDEX,index);
        contentValues.put(COLUMN_USER_NAME,name);
        contentValues.put(COLUMN_USER_EMAIL,mail);
        contentValues.put(COLUMN_USER_PHONE,Phone);
        contentValues.put(COLUMN_USER_GPA,GPA);
        contentValues.put(COLUMN_USER_BATCH,batch);
        db.update(TABLE_USER, contentValues, "user_index = ?",new String[] { index });
        return true;
    }
//student password change

    public boolean updateStuPassword(String index,String password ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USER_PASSWORD,password);

        db.update(TABLE_USER, contentValues, "user_index = ?",new String[] { index });
        return true;
    }



    //lecturer password change

    public boolean updateLectPassword(String index,String password ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_LECT_PASSWORD,password);

        db.update(TABLE_LECTURER, contentValues, "lect_index = ?",new String[] { index });
        return true;
    }




    // Student validations

    public String getEmail(String index)
    {
        String[] columns = {
                COLUMN_USER_INDEX
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_NAME + " = ?";
        String[] selectionArgs = { index };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        String val = cursor.getString(2);
        cursor.close();
        db.close();


        return val;
    }


    public boolean checkIndex(String index){
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_INDEX + " = ?";
        String[] selectionArgs = { index };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }
        return false;
    }

    public boolean checkEmail(String email){
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_EMAIL + " = ?";
        String[] selectionArgs = { email };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }
        return false;
    }

    public boolean checkUser(String index, String password){
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_INDEX + " = ?" + " AND " + COLUMN_USER_PASSWORD + " =?";
        String[] selectionArgs = { index, password };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }
        return false;
    }



    // Lect validation

    public boolean checkLectEmail(String email){
        String[] columns = {
                COLUMN_LECT_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_LECT_EMAIL + " = ?";
        String[] selectionArgs = { email };

        Cursor cursor = db.query(TABLE_LECTURER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }
        return false;
    }

    public boolean checkLectUser(String index, String password){
        String[] columns = {
                COLUMN_LECT_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_LECT_INDEX + " = ?" + " AND " + COLUMN_LECT_PASSWORD + " =?";
        String[] selectionArgs = { index, password };

        Cursor cursor = db.query(TABLE_LECTURER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }
        return false;
    }



    // Select Lecturer

    public String getLectName(String index)
    {
        String result = "";
        String[] columns = {
                COLUMN_LECT_NAME
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_LECT_INDEX + " = ?";
        String[] selectionArgs = { index };

        Cursor cursor = db.query(TABLE_LECTURER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        while (cursor.moveToNext())
        {
            result = cursor.getString(cursor.getColumnIndex(COLUMN_LECT_NAME));
        }
        cursor.close();
        db.close();
        return result;
    }

    public String getLectMail(String index)
    {
        String result = "";
        String[] columns = {
                COLUMN_LECT_EMAIL
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_LECT_INDEX + " = ?";
        String[] selectionArgs = { index };

        Cursor cursor = db.query(TABLE_LECTURER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        while (cursor.moveToNext()){
            result = cursor.getString(cursor.getColumnIndex(COLUMN_LECT_EMAIL));
        }
        cursor.close();
        db.close();
        return result;
    }



    //Lect info update

    public boolean updateLectData(String index,String name,String mail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_LECT_INDEX,index);
        contentValues.put(COLUMN_LECT_NAME,name);
        contentValues.put(COLUMN_LECT_EMAIL,mail);

        db.update(TABLE_LECTURER, contentValues, "lect_index = ?",new String[] { index });
        return true;
    }





    //Select Task

    public ArrayList getTask(String Batch) {
        ArrayList result =  new ArrayList();
        String[] columns = {
                COLUMN_TASK_NAME
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_TASK_BATCH + " = ?";
        String[] selectionArgs = {Batch};

        Cursor cursor = db.query(TABLE_TASK,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        while (cursor.moveToNext()) {
            String r = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_NAME));
            result.add(r);
        }
        cursor.close();
        db.close();
        return result;
    }


    public String getTaskMail(String task)
    {
        String result = "";
        String[] columns = {
                COLUMN_TASK_EMAIL
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_TASK_NAME + " = ?";
        String[] selectionArgs = { task };

        Cursor cursor = db.query(TABLE_TASK,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        while (cursor.moveToNext())
        {
            result = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_EMAIL));
        }
        cursor.close();
        db.close();
        return result;
    }


}





