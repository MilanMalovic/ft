package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import model.User;

public class RepositoryManager {


    private LogInHelper helper;
    private SQLiteDatabase db;


    private static RepositoryManager repositoryManager = null;

    private RepositoryManager() {}

    public static synchronized RepositoryManager getInstance() {

        if (repositoryManager == null)


            repositoryManager = new RepositoryManager();

        return repositoryManager;
    }



    public boolean insert(User user, Context context) {

        boolean success = false;

        if (helper == null) {
            helper = new LogInHelper(context);
        }

        db = helper.getWritableDatabase();

        try {

            ContentValues values = new ContentValues();
            values.put(LogInContract.UserTable.TABLE_COLUMN_USERNAME, user.getUsername());
            values.put(LogInContract.UserTable.TABLE_COLUMN_PASSWORD, user.getPassword());

            long idRow = db.insert(LogInContract.UserTable.TABLE_NAME, null, values);

            if (idRow != -1) {
                success = true;
                user.setId(idRow);
            }


        } catch (Exception exc) {
            Log.e("Exception --->", exc.toString());
        } finally {

            db.close();

        }


        return success;

    }


    public  boolean hasUser(User user, Context context) {

        boolean success = false;


        if (helper == null) {
            helper = new LogInHelper(context);
        }
        db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM user", null);

        try {

            while (cursor.moveToNext()) {

                String table_username = cursor.getString(cursor.getColumnIndexOrThrow(LogInContract.UserTable.TABLE_COLUMN_USERNAME));
                String table_password = cursor.getString(cursor.getColumnIndexOrThrow(LogInContract.UserTable.TABLE_COLUMN_PASSWORD));

                if (user.getUsername().equals(table_username) && user.getPassword().equals(table_password)) {

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
