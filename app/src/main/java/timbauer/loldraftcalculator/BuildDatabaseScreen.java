package timbauer.loldraftcalculator;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class BuildDatabaseScreen extends ActionBarActivity {


    private int champ = 0;
    private TextView currentChamp;
    private Button nextChamp,  prevChamp, done;
    private Spinner champTier, primaryPosit, secondaryPosit, secondaryPosit2,
        primaryRole, secondaryRole, primaryDmgType, waveClearStrength;
    ChampDatabase champDatabase;
    SQLiteDatabase champDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build__database);
        champDatabase = ChampDatabase.getChampDatabase(this);
        champDB = champDatabase.getWritableDatabase();

        currentChamp = (TextView) findViewById(R.id.currentChamp);
        nextChamp = (Button) findViewById(R.id.next_champ);
        prevChamp = (Button) findViewById(R.id.previous_champ);
        done = (Button) findViewById(R.id.exit_activity);

        champTier = (Spinner) findViewById(R.id.editChampTier);
        primaryPosit = (Spinner) findViewById(R.id.editPrimaryPosit);
        secondaryPosit = (Spinner) findViewById(R.id.editSecondaryPosit);
        secondaryPosit2 = (Spinner) findViewById(R.id.editSecondaryPosit2);
        primaryRole = (Spinner) findViewById(R.id.editPrimaryRole);
        secondaryRole = (Spinner) findViewById(R.id.editSecondaryRole);
        primaryDmgType = (Spinner) findViewById(R.id.editPrimaryDmgType);
        waveClearStrength = (Spinner) findViewById(R.id.editWaveClearStrength);

        currentChamp.setText(champs[champ]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_build__database, menu);
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

    private void persistData(){
        ContentValues champData = new ContentValues();

        champData.put(ChampDatabase.champName, champs[champ]);
        champData.put(ChampDatabase.champTier, champTier.getSelectedItem().toString());
        champData.put(ChampDatabase.primaryPosit, primaryPosit.getSelectedItem().toString());
        champData.put(ChampDatabase.secondaryPosit, secondaryPosit.getSelectedItem().toString());
        champData.put(ChampDatabase.secondaryPosit2, secondaryPosit2.getSelectedItem().toString());
        champData.put(ChampDatabase.primaryRole, primaryRole.getSelectedItem().toString());
        champData.put(ChampDatabase.secondaryRole, secondaryRole.getSelectedItem().toString());
        champData.put(ChampDatabase.primaryDmgType, primaryDmgType.getSelectedItem().toString());
        champData.put(ChampDatabase.waveClear, waveClearStrength.getSelectedItem().toString());

        champDB.insert(champDatabase.tableName, null, champData);
    }

    public void getNextChamp(View view) {

        persistData();

        champ++;
        currentChamp.setText(champs[champ]);

        if (champ >= (champs.length - 1)){
            nextChamp.setClickable(false);
        }

        if (!prevChamp.isClickable() && champ > 0){
            prevChamp.setClickable(true);
        }
    }

    public void getPreviousChamp(View view) {

        champ--;
        currentChamp.setText(champs[champ]);

        if (champ <= 0){
            prevChamp.setClickable(false);
        }

        if (!nextChamp.isClickable() && champ < champs.length){
            nextChamp.setClickable(true);
        }
    }

    public void exitToHomeScreen(View view) {

        persistData();
        champDB.close();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        champDB.close();
    }

    @Override
    protected void onStop() {
        super.onStop();
        champDB.close();
    }

    @Override
    protected void onPause(){
        super.onPause();
        champDB.close();
    }

    @Override
    protected void onResume(){
        super.onResume();
        champDB = champDatabase.getWritableDatabase();
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
