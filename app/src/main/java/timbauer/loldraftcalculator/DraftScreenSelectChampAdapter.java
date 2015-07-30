package timbauer.loldraftcalculator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by timbauer on 7/20/15.
 */
public class DraftScreenSelectChampAdapter extends BaseAdapter {

    private Context mContext;

    public DraftScreenSelectChampAdapter(Context context){

        mContext = context;
        champImageList = new ArrayList<>(Arrays.asList(champImages));
    }

    @Override
    public int getCount() {
        champImageList.trimToSize();
        return champImageList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(champImageList.get(position));
        return imageView;
    }


    public ArrayList<Integer> champImageList;
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
