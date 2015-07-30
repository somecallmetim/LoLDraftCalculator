package timbauer.loldraftcalculator;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;



public class DraftScreen extends ActionBarActivity {

    int champArrayPosit;
    DraftScreenSelectChampAdapter draftScreenAdapter;

    DraftScreenPickBanAdapter bluePicksAdapter;
    DraftScreenPickBanAdapter blueBansAdapter;
    DraftScreenPickBanAdapter redBansAdapter;
    DraftScreenPickBanAdapter redPicksAdapter;
    
    GridView bluePicksView;
    GridView redPicksView;
    GridView redBansView;
    GridView blueBansView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draft_screen);

        GridView draftableChampsView = (GridView) findViewById(R.id.all_champs_view);
        bluePicksView = (GridView)findViewById(R.id.blue_side);
        redPicksView = (GridView)findViewById(R.id.red_side);
        redBansView = (GridView)findViewById(R.id.red_side_bans);
        blueBansView = (GridView)findViewById(R.id.blue_side_bans);

        bluePicksAdapter = new DraftScreenPickBanAdapter(this, 5);
        bluePicksView.setAdapter(bluePicksAdapter);

        redPicksAdapter = new DraftScreenPickBanAdapter(this, 5);
        redPicksView.setAdapter(redPicksAdapter);

        blueBansAdapter = new DraftScreenPickBanAdapter(this, 3);
        blueBansView.setAdapter(blueBansAdapter);

        redBansAdapter = new DraftScreenPickBanAdapter(this, 3);
        redBansView.setAdapter(redBansAdapter);
        
        


        draftScreenAdapter = new DraftScreenSelectChampAdapter(this);
        draftableChampsView.setAdapter(draftScreenAdapter);

        draftableChampsView.setOnItemLongClickListener(new OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v,
                                           int pos, long id) {
                ClipData data = ClipData.newPlainText("", "");
                DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                        v);
                // start dragging the item touched
                v.startDrag(data, shadowBuilder, v, 0);
                champArrayPosit = pos;
                return false;
            }
        });
        
        

        DraftDragListener bluePick = new DraftDragListener(bluePicksAdapter);
        bluePick.setDestinationLayout((LinearLayout) findViewById(R.id.blue_side_layout));
        findViewById(R.id.blue_side_layout).setOnDragListener(bluePick);

        DraftDragListener redPick = new DraftDragListener(redPicksAdapter);
        bluePick.setDestinationLayout((LinearLayout) findViewById(R.id.red_side_layout));
        findViewById(R.id.red_side_layout).setOnDragListener(redPick);

        DraftDragListener blueBan = new DraftDragListener(blueBansAdapter);
        bluePick.setDestinationLayout((LinearLayout) findViewById(R.id.blue_side_bans_layout));
        findViewById(R.id.blue_side_bans_layout).setOnDragListener(blueBan);

        DraftDragListener redBan = new DraftDragListener(redBansAdapter);
        bluePick.setDestinationLayout((LinearLayout) findViewById(R.id.red_side_bans_layout));
        findViewById(R.id.red_side_bans_layout).setOnDragListener(redBan);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_draft_screen, menu);
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

    public void moveToHomeScreen(View view) {
        Intent moveToHomeScreen = new Intent(this, ListChampsByPositAndEdit.class);
        startActivity(moveToHomeScreen);
    }

    class DraftDragListener implements OnDragListener {


        private LinearLayout destinationLayout = null;
        private DraftScreenPickBanAdapter currentPickBanAdapter;
        private Integer currentChamp;

        public DraftDragListener(DraftScreenPickBanAdapter currentPickBanAdapter) {
            this.currentPickBanAdapter = currentPickBanAdapter;
        }

        public void setDestinationLayout(LinearLayout destinationLayout) {
            this.destinationLayout = destinationLayout;
        }

        @Override
        public boolean onDrag(View v, DragEvent event) {
            try {
                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        // do nothing
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DROP:
                        // Dropped, reassign View to ViewGroup
                        View view = (View) event.getLocalState();
                        currentChamp = draftScreenAdapter.champImageList.get(champArrayPosit);
                        draftScreenAdapter.champImageList.remove(champArrayPosit);
                        draftScreenAdapter.notifyDataSetChanged();
                        currentPickBanAdapter.addChamp(currentChamp);
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                    default:
                        break;
                }
                return true;
            }catch (NullPointerException e){
                System.err.println("NullPointerException: destinationLayout not set- " + e.getMessage());
            }

            return true;
        }
    }

    private final Integer[] champImages = {
            R.drawable.aatrox_square_0,
            R.drawable.akali_square_0,
            R.drawable.alistar_square_0,
            R.drawable.amumu_square_0,
            R.drawable.anivia_square_0,
            R.drawable.annie_square_0,
            R.drawable.ashe_square_0,
            R.drawable.azir_square_0,
            R.drawable.bard_square_0,
            R.drawable.blitzcrank_square_0,
            R.drawable.brand_square_0,
            R.drawable.braum_square_0,
            R.drawable.caitlyn_square_0,
            R.drawable.cassiopeia_square_0,
            R.drawable.chogath_square_0,
            R.drawable.corki_square_0,
            R.drawable.darius_square_0,
            R.drawable.diana_square_0,
            R.drawable.draven_square_0,
            R.drawable.drmundo_square_0,
            R.drawable.elise_square_0,
            R.drawable.evelynn_square_0,
            R.drawable.ezreal_square_0,
            R.drawable.fiddlesticks_square_0,
            R.drawable.fiora_square_0,
            R.drawable.fizz_square_0,
            R.drawable.galio_square_0,
            R.drawable.gangplank_square_0,
            R.drawable.garen_square_0,
            R.drawable.gragas_square_0,
            R.drawable.graves_square_0,
            R.drawable.hecarim_square_0,
            R.drawable.heimerdinger_square_0,
            R.drawable.irelia_square_0,
            R.drawable.janna_square_0,
            R.drawable.jarvaniv_square_0,
            R.drawable.jax_square_0,
            R.drawable.jayce_square_0,
            R.drawable.jinx_square_0,
            R.drawable.kalista_square_0,
            R.drawable.karma_square_0,
            R.drawable.karthus_square_0,
            R.drawable.kassadin_square_0,
            R.drawable.katarina_square_0,
            R.drawable.kayle_square_0,
            R.drawable.kennen_square_0,
            R.drawable.khazix_square_0,
            R.drawable.kogmaw_square_0,
            R.drawable.leblanc_square_0,
            R.drawable.leesin_square_0,
            R.drawable.leona_square_0,
            R.drawable.lissandra_square_0,
            R.drawable.lucian_square_0,
            R.drawable.lulu_square_0,
            R.drawable.lux_square_0,
            R.drawable.malphite_square_0,
            R.drawable.malzahar_square_0,
            R.drawable.maokai_square_0,
            R.drawable.masteryi_square_0,
            R.drawable.missfortune_square_0,
            R.drawable.monkeyking_square_0,
            R.drawable.mordekaiser_square_0,
            R.drawable.morgana_square_0,
            R.drawable.nami_square_0,
            R.drawable.nasus_square_0,
            R.drawable.nautilus_square_0,
            R.drawable.nidalee_square_0,
            R.drawable.nocturne_square_0,
            R.drawable.nunu_square_0,
            R.drawable.olaf_square_0,
            R.drawable.orianna_square_0,
            R.drawable.pantheon_square_0,
            R.drawable.poppy_square_0,
            R.drawable.quinn_square_0,
            R.drawable.rammus_square_0,
            R.drawable.reksai_square_0,
            R.drawable.renekton_square_0,
            R.drawable.rengar_square_0,
            R.drawable.riven_square_0,
            R.drawable.rumble_square_0,
            R.drawable.ryze_square_0,
            R.drawable.sejuani_square_0,
            R.drawable.shaco_square_0,
            R.drawable.shen_square_0,
            R.drawable.shyvana_square_0,
            R.drawable.singed_square_0,
            R.drawable.sion_square_0,
            R.drawable.sivir_square_0,
            R.drawable.skarner_square_0,
            R.drawable.sona_square_0,
            R.drawable.soraka_square_0,
            R.drawable.swain_square_0,
            R.drawable.syndra_square_0,
            R.drawable.talon_square_0,
            R.drawable.taric_square_0,
            R.drawable.teemo_square_0,
            R.drawable.thresh_square_0,
            R.drawable.tristana_square_0,
            R.drawable.trundle_square_0,
            R.drawable.tryndamere_square_0,
            R.drawable.twistedfate_square_0,
            R.drawable.twitch_square_0,
            R.drawable.udyr_square_0,
            R.drawable.urgot_square_0,
            R.drawable.varus_square_0,
            R.drawable.vayne_square_0,
            R.drawable.veigar_square_0,
            R.drawable.velkoz_square_0,
            R.drawable.vi_square_0,
            R.drawable.viktor_square_0,
            R.drawable.vladimir_square_0,
            R.drawable.volibear_square_0,
            R.drawable.warwick_square_0,
            R.drawable.xerath_square_0,
            R.drawable.xinzhao_square_0,
            R.drawable.yasuo_square_0,
            R.drawable.yorick_square_0,
            R.drawable.zac_square_0,
            R.drawable.zed_square_0,
            R.drawable.ziggs_square_0,
            R.drawable.zilean_square_0,
            R.drawable.zyra_square_0
    };
}
