package timbauer.loldraftcalculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class BuildDatabaseScreen extends ActionBarActivity {


    private int champ = 0;
    private TextView currentChamp;
    private Button nextChamp,  prevChamp, done;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build__database);

        currentChamp = (TextView) findViewById(R.id.currentChamp);
        nextChamp = (Button) findViewById(R.id.next_champ);
        prevChamp = (Button) findViewById(R.id.previous_champ);
        done = (Button) findViewById(R.id.exit_activity);

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

    public void getNextChamp(View view) {

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
        finish();
    }


    private final static String[] champs = {
            "aatrox",
            "akali",
            "alistar",
            "amumu",
            "anivia",
            "annie",
            "ashe",
            "azir",
            "bard",
            "blitzcrank",
            "brand",
            "braum",
            "caitlyn",
            "cassiopeia",
            "chogath",
            "corki",
            "darius",
            "diana",
            "draven",
            "drmundo",
            "elise",
            "evelynn",
            "ezreal",
            "fiddlesticks",
            "fiora",
            "fizz",
            "galio",
            "gangplank",
            "garen",
            "gragas",
            "graves",
            "hecarim",
            "heimerdinger",
            "irelia",
            "janna",
            "jarvaniv",
            "jax",
            "jayce",
            "jinx",
            "kalista",
            "karma",
            "karthus",
            "kassadin",
            "katarina",
            "kayle",
            "kennen",
            "khazix",
            "kogmaw",
            "leblanc",
            "leesin",
            "leona",
            "lissandra",
            "lucian",
            "lulu",
            "lux",
            "malphite",
            "malzahar",
            "maokai",
            "masteryi",
            "missfortune",
            "monkeyking",
            "mordekaiser",
            "morgana",
            "nami",
            "nasus",
            "nautilus",
            "nidalee",
            "nocturne",
            "nunu",
            "olaf",
            "orianna",
            "pantheon",
            "poppy",
            "quinn",
            "rammus",
            "reksai",
            "renekton",
            "rengar",
            "riven",
            "rumble",
            "ryze",
            "sejuani",
            "shaco",
            "shen",
            "shyvana",
            "singed",
            "sion",
            "sivir",
            "skarner",
            "sona",
            "soraka",
            "swain",
            "syndra",
            "talon",
            "taric",
            "teemo",
            "thresh",
            "tristana",
            "trundle",
            "tryndamere",
            "twistedfate",
            "twitch",
            "udyr",
            "urgot",
            "varus",
            "vayne",
            "veigar",
            "velkoz",
            "vi",
            "viktor",
            "vladimir",
            "volibear",
            "warwick",
            "xerath",
            "xinzhao",
            "yasuo",
            "yorick",
            "zac",
            "zed",
            "ziggs",
            "zilean",
            "zyra"
    };


}
