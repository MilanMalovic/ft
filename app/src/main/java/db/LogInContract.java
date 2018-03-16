package db;

import android.provider.BaseColumns;

/**
 * Created by Velimir on 3/15/2018.
 */

public final class LogInContract {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "LogInDatabase";

    private LogInContract(){}

    public static class UserTable implements BaseColumns {

        public static final String TABLE_NAME = "user";

        public static final String TABLE_COLUMN_USERNAME = "username";
        public static final String TABLE_COLUMN_PASSWORD = "password";




        public static final String SQL_CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY," +
                TABLE_COLUMN_USERNAME + " TEXT,"+
                TABLE_COLUMN_PASSWORD + " TEXT);";


        public static final String SQL_DELETE_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;






    }
}
