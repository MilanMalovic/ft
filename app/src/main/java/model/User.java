package model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import db.LogInContract.UserTable;
import db.LogInHelper;


public class User {

    private Context context;
    private LogInHelper helper;
    private SQLiteDatabase db;


    private long id;
    private String username;
    private String password;


    public User(String username, String password, Context context) {
        this.username = username;
        this.password = password;
        this.context = context;

    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean insert() {

        boolean success = false;

        if (helper == null) {
            helper = new LogInHelper(context);
        }

        db = helper.getWritableDatabase();

        try {

            ContentValues values = new ContentValues();
            values.put(UserTable.TABLE_COLUMN_USERNAME, username);
            values.put(UserTable.TABLE_COLUMN_PASSWORD, password);

            long idRow = db.insert(UserTable.TABLE_NAME, null, values);

            if (idRow != -1) {
                success = true;
                this.id = idRow;
            }


        } catch (Exception exc) {
            Log.e("Exception --->", exc.toString());
        } finally {

            db.close();

        }


        return success;

    }

    public static boolean hasUser(String username, String password, Context context) {

        boolean success = false;

        LogInHelper helper = new LogInHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM user", null);

        try {

            while (cursor.moveToNext()) {

                String table_username = cursor.getString(cursor.getColumnIndexOrThrow(UserTable.TABLE_COLUMN_USERNAME));
                String table_password = cursor.getString(cursor.getColumnIndexOrThrow(UserTable.TABLE_COLUMN_PASSWORD));

                if (username.equals(table_username) && password.equals(table_password)) {

                    success = true;

                }


            }

        } catch (Exception exc) {
            Log.e("Exception ---> ", exc.toString());
        } finally {
            db.close();
            cursor.close();
        }

        return success;

    }


}
