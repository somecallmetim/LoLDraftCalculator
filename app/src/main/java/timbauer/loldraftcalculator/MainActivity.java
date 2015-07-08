package timbauer.loldraftcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
        Intent getDisplayScreenIntent = new Intent(this, DisplayScreen.class);

        final int result = 1;

        int laneId = 1;

        getDisplayScreenIntent.putExtra("laneId", laneId);
        startActivity(getDisplayScreenIntent);
    }

    public void getMidLaners(View view) {
        Intent getDisplayScreenIntent = new Intent(this, DisplayScreen.class);

        final int result = 1;

        int laneId = 2;

        getDisplayScreenIntent.putExtra("laneId", laneId);
        startActivity(getDisplayScreenIntent);
    }

    public void getJunglers(View view) {
        Intent getDisplayScreenIntent = new Intent(this, DisplayScreen.class);

        final int result = 1;

        int laneId = 3;

        getDisplayScreenIntent.putExtra("laneId", laneId);
        startActivity(getDisplayScreenIntent);
    }

    public void getAdCarries(View view) {
        Intent getDisplayScreenIntent = new Intent(this, DisplayScreen.class);

        final int result = 1;
        int laneId = 4;

        getDisplayScreenIntent.putExtra("laneId", laneId);
        startActivity(getDisplayScreenIntent);
    }


    public void getSupports(View view) {
        Intent getDisplayScreenIntent = new Intent(this, DisplayScreen.class);

        final int result = 1;

        int laneId = 5;

        getDisplayScreenIntent.putExtra("laneId", laneId);
        startActivity(getDisplayScreenIntent);
    }
}
