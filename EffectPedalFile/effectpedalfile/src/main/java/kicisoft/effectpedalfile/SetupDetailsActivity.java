package kicisoft.effectpedalfile;

import android.app.Activity;
import android.widget.GridView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import kicisoft.effectpedalfile.adapter.InputAdapter;


/**
 * Created by Juan on 27/07/2014.
 */
@EActivity(R.layout.activity_setup_details)
public class SetupDetailsActivity extends Activity {
    @ViewById
    GridView controllersGrid;

    InputAdapter adapter;

    String[] controllers = {"Volume", "Gain", "Tone", "Mode", "Some"};

    @AfterViews
    void init(){
        adapter = new InputAdapter(this, controllers);
        controllersGrid.setAdapter(adapter);
    }
}
