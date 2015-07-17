package timbauer.loldraftcalculator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by timbauer on 7/14/15.
 */
public class ChampDatabase extends SQLiteOpenHelper {
    final static String dbName = "ChampDatabase.db";
    final static String tableName = "champ_data";
    final static int dbVersion = 1;
    static Context mContext;

    private static ChampDatabase champDatabase = null;

    final static String champName = "champName";
    final static String champTier = "champTier";
    final static String primaryPosit = "primaryPosit";
    final static String secondaryPosit = "secondaryPosit";
    final static String secondaryPosit2 = "secondaryPosit2";
    final static String primaryRole = "primaryRole";
    final static String secondaryRole = "secondaryRole";
    final static String primaryDmgType = "primaryDmgType";
    final static String waveClear = "waveClear";

    @Override
    public void onCreate(SQLiteDatabase champDb) {
        String CREATE_CHAMP_TABLE = "CREATE TABLE " + tableName + "("
                + champName + " TEXT PRIMARY KEY,"
                + champTier + " TEXT,"
                + primaryPosit + " TEXT,"
                + secondaryPosit + " TEXT,"
                + secondaryPosit2 + " TEXT,"
                + primaryRole + " TEXT,"
                + secondaryRole + " TEXT,"
                + primaryDmgType + " TEXT,"
                + waveClear + " TEXT" + ")";
        champDb.execSQL(CREATE_CHAMP_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static ChampDatabase getChampDatabase(Context context){
        if (champDatabase == null){
            champDatabase = new ChampDatabase(context);
        } else {
            mContext = context;
        }
        return champDatabase;
    }

    private ChampDatabase(Context context){

        //constructor checks to see if database exists or not and, if it doesn't exist
            // it calls onCreate. If database exists but the version numbers differ between
            // this class and the db on file, it calls onUpgrade
        super(context, dbName, null, dbVersion);
    }
}
