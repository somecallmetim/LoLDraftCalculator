package timbauer.loldraftcalculator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by timbauer on 7/14/15.
 */
public class ChampDatabase extends SQLiteOpenHelper {
    final static String dbName = "ChampDatabase.db";
    final static int dbVersion = 1;
    Context context;

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ChampDatabase(Context context){

        //contructor checks to see if database exists or not and, if it doesn't exist
            // it calls onCreate. If database exists but the version numbers differ between
            // this class and the db on file, it calls onUpgrade
        super(context, dbName, null, dbVersion);
        this.context = context;
    }
}
