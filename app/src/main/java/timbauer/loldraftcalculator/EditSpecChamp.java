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
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class EditSpecChamp extends ActionBarActivity {

    private ChampDatabase champDatabase;
    private SQLiteDatabase champDB;
    private static int champColumn;
    private int position;
    private String[] dbFields;
    private Spinner[] spinners;

    private TextView currentChamp;
    private Spinner champTier, primaryPosit, secondaryPosit, secondaryPosit2,
            primaryRole, secondaryRole, primaryDmgType, waveClearStrength;

    private Cursor champData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_spec_champ);
        champDatabase = ChampDatabase.getChampDatabase(this);
        champDB = champDatabase.getWritableDatabase();

        Intent getData = getIntent();
        position = getData.getExtras().getInt("champIndex");


        currentChamp = (TextView) findViewById(R.id.currentChampName);

        champTier = (Spinner) findViewById(R.id.editChampTier);
        primaryPosit = (Spinner) findViewById(R.id.editPrimaryPosit);
        secondaryPosit = (Spinner) findViewById(R.id.editSecondaryPosit);
        secondaryPosit2 = (Spinner) findViewById(R.id.editSecondaryPosit2);
        primaryRole = (Spinner) findViewById(R.id.editPrimaryRole);
        secondaryRole = (Spinner) findViewById(R.id.editSecondaryRole);
        primaryDmgType = (Spinner) findViewById(R.id.editPrimaryDmgType);
        waveClearStrength = (Spinner) findViewById(R.id.editWaveClearStrength);

        spinners = new Spinner[]{
                champTier,
                primaryPosit,
                secondaryPosit,
                secondaryPosit2,
                primaryRole,
                secondaryRole,
                primaryDmgType,
                waveClearStrength
        };

        dbFields = new String[]{
                ChampDatabase.champTier,
                ChampDatabase.primaryPosit,
                ChampDatabase.secondaryPosit,
                ChampDatabase.secondaryPosit2,
                ChampDatabase.primaryRole,
                ChampDatabase.secondaryRole,
                ChampDatabase.primaryDmgType,
                ChampDatabase.waveClear
        };

        if (isChampInDB(champs[position], dbFields)){
            setSpinners(champs[position], spinners, dbFields);
        }

    }

    private boolean isChampInDB(String champName, String[] dbFields){
        champData = champDB.query(
                ChampDatabase.tableName,
                dbFields,
                ChampDatabase.champName + " = ?",
                new String[] {champName},
                null, null, null
        );

        return (champData.getCount() > 0);

    }

    private void setSpinners(String champName, Spinner[] spinners, String[] dbFields){
        currentChamp.setText(champName);
/*
        champData = champDB.query(
                ChampDatabase.tableName,
                dbFields,
                ChampDatabase.champName + " = ?",
                new String[] {champName},
                null, null, null
        );
*/

        champData.moveToFirst();

        int tierColumn = champData.getColumnIndex(ChampDatabase.champTier);
        int priPositColumn = champData.getColumnIndex(ChampDatabase.primaryPosit);
        int secPositColumn = champData.getColumnIndex(ChampDatabase.secondaryPosit);
        int secPosit2Column = champData.getColumnIndex(ChampDatabase.secondaryPosit2);
        int priRoleColumn = champData.getColumnIndex(ChampDatabase.primaryRole);
        int secRoleColumn = champData.getColumnIndex(ChampDatabase.secondaryRole);
        int priDmgColumn = champData.getColumnIndex(ChampDatabase.primaryDmgType);
        int waveClearColumn = champData.getColumnIndex(ChampDatabase.waveClear);


        String compareValue = champData.getString(tierColumn);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.champ_tier, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinners[0].setAdapter(adapter);
        if (!compareValue.equals(null)) {
            int spinnerPosition = adapter.getPosition(compareValue);
            spinners[0].setSelection(spinnerPosition);
        }

        compareValue = champData.getString(priPositColumn);
        adapter = ArrayAdapter.createFromResource(this, R.array.champion_positions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinners[1].setAdapter(adapter);
        if (!compareValue.equals(null)) {
            int spinnerPosition = adapter.getPosition(compareValue);
            spinners[1].setSelection(spinnerPosition);
        }

        compareValue = champData.getString(secPositColumn);
        adapter = ArrayAdapter.createFromResource(this, R.array.champion_positions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinners[2].setAdapter(adapter);
        if (!compareValue.equals(null)) {
            int spinnerPosition = adapter.getPosition(compareValue);
            spinners[2].setSelection(spinnerPosition);
        }

        compareValue = champData.getString(secPosit2Column);
        adapter = ArrayAdapter.createFromResource(this, R.array.champion_positions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinners[3].setAdapter(adapter);
        if (!compareValue.equals(null)) {
            int spinnerPosition = adapter.getPosition(compareValue);
            spinners[3].setSelection(spinnerPosition);
        }

        compareValue = champData.getString(priRoleColumn);
        adapter = ArrayAdapter.createFromResource(this, R.array.champion_roles, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinners[4].setAdapter(adapter);
        if (!compareValue.equals(null)) {
            int spinnerPosition = adapter.getPosition(compareValue);
            spinners[4].setSelection(spinnerPosition);
        }

        compareValue = champData.getString(secRoleColumn);
        adapter = ArrayAdapter.createFromResource(this, R.array.champion_roles, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinners[5].setAdapter(adapter);
        if (!compareValue.equals(null)) {
            int spinnerPosition = adapter.getPosition(compareValue);
            spinners[5].setSelection(spinnerPosition);
        }

        compareValue = champData.getString(priDmgColumn);
        adapter = ArrayAdapter.createFromResource(this, R.array.champion_dmg_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinners[6].setAdapter(adapter);
        if (!compareValue.equals(null)) {
            int spinnerPosition = adapter.getPosition(compareValue);
            spinners[6].setSelection(spinnerPosition);
        }

        compareValue = champData.getString(waveClearColumn);
        adapter = ArrayAdapter.createFromResource(this, R.array.wave_clear_strength, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinners[7].setAdapter(adapter);
        if (!compareValue.equals(null)) {
            int spinnerPosition = adapter.getPosition(compareValue);
            spinners[7].setSelection(spinnerPosition);
        }


    }

    private void persistData(){
        ContentValues champData = new ContentValues();

        champData.put(ChampDatabase.champName, champs[position]);
        champData.put(ChampDatabase.champTier, champTier.getSelectedItem().toString());
        champData.put(ChampDatabase.primaryPosit, primaryPosit.getSelectedItem().toString());
        champData.put(ChampDatabase.secondaryPosit, secondaryPosit.getSelectedItem().toString());
        champData.put(ChampDatabase.secondaryPosit2, secondaryPosit2.getSelectedItem().toString());
        champData.put(ChampDatabase.primaryRole, primaryRole.getSelectedItem().toString());
        champData.put(ChampDatabase.secondaryRole, secondaryRole.getSelectedItem().toString());
        champData.put(ChampDatabase.primaryDmgType, primaryDmgType.getSelectedItem().toString());
        champData.put(ChampDatabase.waveClear, waveClearStrength.getSelectedItem().toString());

        champDB.update(ChampDatabase.tableName, champData, ChampDatabase.champName + " = ?" , new String[]{champs[position]});
    }


    public void saveChamp(View view) {
        persistData();
        finish();
    }


    public void discardChanges(View view) {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_spec_champ, menu);
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
