package kicisoft.effectpedalfile;

import android.app.Activity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;

import kicisoft.effectpedalfile.model.SetUp;

/**
 * Created by Juan on 10/08/2014.
 * Activity for load setup screen.
 */
@EActivity(R.layout.activity_load_setup)
public class LoadSetupActivity extends Activity {

    /**
     * Este método se ejecuta cuando todas las vistas están creadas, es equivalente al OnCreate().
     */
    @AfterViews
    void init(){

    }

    /**
     * Returns 10 elements mock list of saved setups.
     */
    private ArrayList<SetUp> getSavedSetupList(){
        ArrayList<SetUp> savedSetups = new ArrayList<SetUp>();
        for(int i = 0; i < 10; i++){
            SetUp setup = new SetUp("Setup " + String.valueOf(i), "01/01/2014");
            savedSetups.add(setup);
        }
        return savedSetups;
    }
}