package com.set.ultimax.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "All_Accounts";

    private static final String TABLE_USERS = "Registerd_Accounts";
 
    // Account Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_USERS = "userName";
    private static final String KEY_PASS = "passWord";
 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ACCOUNT_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_USERS + " TEXT,"
                + KEY_PASS + " TEXT" + ")";
        db.execSQL(CREATE_ACCOUNT_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);// Create tables again
    }

    // Adding new User
    void addUsers(Users users) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_USERS, users.getUser()); // User Name
        values.put(KEY_PASS, users.getPassword()); // Password
 
        // Inserting Row
        db.insert(TABLE_USERS, null, values);
        db.close(); // Closing database connection
    }
    public void deleteAll() //Deletes all data in the database
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS,null,null);
    }

    public boolean validateUser(String username, String password){
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_USERS + " WHERE "
                        + KEY_USERS + "='" + username +"'AND "+KEY_PASS+"='"+password+"'" ,  null);
        if (c.getCount() > 0) {
            return true;
        }
        else{return false;}

    }
    public boolean sameUser(String username){
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_USERS + " WHERE "
                        + KEY_USERS + "='" + username  + "'" ,  null);
        if (c.getCount() > 0) {
            return true;
        }
        else{return false;}
    }

}
