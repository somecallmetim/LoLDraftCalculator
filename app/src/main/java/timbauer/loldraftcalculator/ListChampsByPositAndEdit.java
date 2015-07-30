package timbauer.loldraftcalculator;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ListChampsByPositAndEdit extends ActionBarActivity {

    private ChampDatabase champDatabase;
    private SQLiteDatabase champDB;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_champ_by_posit_and_edit);


        champDatabase = ChampDatabase.getChampDatabase(this);
        champDB = champDatabase.getWritableDatabase();

        String[] dbFields = new String[]{
                ChampDatabase.champTier,
                ChampDatabase.primaryPosit,
                ChampDatabase.secondaryPosit,
                ChampDatabase.secondaryPosit2,
                ChampDatabase.primaryRole,
                ChampDatabase.secondaryRole,
                ChampDatabase.primaryDmgType,
                ChampDatabase.waveClear
        };

        Cursor champData = champDB.query(
                ChampDatabase.tableName,
                dbFields,
                ChampDatabase.champName + " = ?",
                new String[] {"Aatrox"},
                null, null, null);


        if(!(champData.getCount() > 0)){
            populateDatabase();
        }
        champDB.close();

    }

    private void populateDatabase(){
        ContentValues champData = new ContentValues();
        for(int i = 0; i < champs.length; i++){


            champData.put(champName, champs[i]);
            champData.put(champTier, "5");
            champData.put(primaryPosit, "");
            champData.put(secondaryPosit, "");
            champData.put(secondaryPosit2,"");
            champData.put(primaryRole, "");
            champData.put(secondaryRole, "");
            champData.put(primaryDmgType, "");
            champData.put(waveClear, this.getString(R.string.wave_clear_nonexistent));

            champDB.insert(ChampDatabase.tableName, null, champData);

            champData.clear();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getTopLaners(View view) {
        Intent getDisplayScreenIntent = new Intent(this, DisplayResultsScreen.class);

        final int result = 1;

        int laneId = 1;

        getDisplayScreenIntent.putExtra("laneId", laneId);
        startActivity(getDisplayScreenIntent);
    }

    public void getMidLaners(View view) {
        Intent getDisplayScreenIntent = new Intent(this, DisplayResultsScreen.class);

        final int result = 1;

        int laneId = 2;

        getDisplayScreenIntent.putExtra("laneId", laneId);
        startActivity(getDisplayScreenIntent);
    }

    public void getJunglers(View view) {
        Intent getDisplayScreenIntent = new Intent(this, DisplayResultsScreen.class);

        final int result = 1;

        int laneId = 3;

        getDisplayScreenIntent.putExtra("laneId", laneId);
        startActivity(getDisplayScreenIntent);
    }

    public void getAdCarries(View view) {
        Intent getDisplayScreenIntent = new Intent(this, DisplayResultsScreen.class);

        final int result = 1;
        int laneId = 4;

        getDisplayScreenIntent.putExtra("laneId", laneId);
        startActivity(getDisplayScreenIntent);
    }


    public void getSupports(View view) {
        Intent getDisplayScreenIntent = new Intent(this, DisplayResultsScreen.class);

        final int result = 1;

        int laneId = 5;

        getDisplayScreenIntent.putExtra("laneId", laneId);
        startActivity(getDisplayScreenIntent);
    }

    public void editChamps(View view) {
        Intent editChamps = new Intent(this, EditChamps.class);
        startActivity(editChamps);
    }

    private final static String[] champs = {
            "Aatrox",
            "Akali",
            "Alistar",
            "Amumu",
            "Anivia",
            "Annie",
            "Ashe",
            "Azir",
            "Bard",
            "Blitzcrank",
            "Brand",
            "Braum",
            "Caitlyn",
            "Cassiopeia",
            "Chogath",
            "Corki",
            "Darius",
            "Diana",
            "Draven",
            "Drmundo",
            "Elise",
            "Evelynn",
            "Ezreal",
            "Fiddlesticks",
            "Fiora",
            "Fizz",
            "Galio",
            "Gangplank",
            "Garen",
            "Gragas",
            "Graves",
            "Hecarim",
            "Heimerdinger",
            "Irelia",
            "Janna",
            "Jarvaniv",
            "Jax",
            "Jayce",
            "Jinx",
            "Kalista",
            "Karma",
            "Karthus",
            "Kassadin",
            "Katarina",
            "Kayle",
            "Kennen",
            "Khazix",
            "Kogmaw",
            "Leblanc",
            "Leesin",
            "Leona",
            "Lissandra",
            "Lucian",
            "Lulu",
            "Lux",
            "Malphite",
            "Malzahar",
            "Maokai",
            "Masteryi",
            "Missfortune",
            "Monkeyking",
            "Mordekaiser",
            "Morgana",
            "Nami",
            "Nasus",
            "Nautilus",
            "Nidalee",
            "Nocturne",
            "Nunu",
            "Olaf",
            "Orianna",
            "Pantheon",
            "Poppy",
            "Quinn",
            "Rammus",
            "Reksai",
            "Renekton",
            "Rengar",
            "Riven",
            "Rumble",
            "Ryze",
            "Sejuani",
            "Shaco",
            "Shen",
            "Shyvana",
            "Singed",
            "Sion",
            "Sivir",
            "Skarner",
            "Sona",
            "Soraka",
            "Swain",
            "Syndra",
            "Talon",
            "Taric",
            "Teemo",
            "Thresh",
            "Tristana",
            "Trundle",
            "Tryndamere",
            "Twistedfate",
            "Twitch",
            "Udyr",
            "Urgot",
            "Varus",
            "Vayne",
            "Veigar",
            "Velkoz",
            "Vi",
            "Viktor",
            "Vladimir",
            "Volibear",
            "Warwick",
            "Xerath",
            "Xinzhao",
            "Yasuo",
            "Yorick",
            "Zac",
            "Zed",
            "Ziggs",
            "Zilean",
            "Zyra"
    };
}
