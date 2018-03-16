package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Velimir on 3/15/2018.
 */

public final class LogInHelper extends SQLiteOpenHelper {



    public LogInHelper(Context context) {
        super(context, LogInContract.DATABASE_NAME, null, LogInContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(LogInContract.UserTable.SQL_CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       sqLiteDatabase.execSQL(LogInContract.UserTable.SQL_DELETE_USER_TABLE);
       onCreate(sqLiteDatabase);
    }
}
