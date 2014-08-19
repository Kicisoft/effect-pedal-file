package kicisoft.effectpedalfile;

import android.app.Activity;
import android.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

import kicisoft.effectpedalfile.adapter.InputAdapter;
import kicisoft.effectpedalfile.fragment.KnobControlFragment;
import kicisoft.effectpedalfile.fragment.KnobControlFragment_;
import kicisoft.effectpedalfile.model.Controller;
import kicisoft.effectpedalfile.model.KnobController;
import kicisoft.effectpedalfile.model.SelectorController;


/**
 * Created by Juan on 27/07/2014.
 * Activity for effect details.
 * TODO Implement as fragment.
 */
@EActivity(R.layout.activity_setup_details)
public class EffectDetailsActivity extends Activity {
    @ViewById
    GridView controllersGrid;
    @ViewById
    FrameLayout selectedControllerInput;

    InputAdapter adapter;

    ArrayList<Controller> controllers;

    @AfterViews
    void init() {
        controllers = getControllers();
        adapter = new InputAdapter(this, controllers);
        controllersGrid.setAdapter(adapter);
        controllersGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.selected = i;
                //TODO this should be changed for the correct controls.
                setKnobControls();
            }
        });
    }

    /**
     * Retrieves a mock list of controllers.
     * @return Mock controllers.
     */
    private ArrayList<Controller> getControllers() {
        ArrayList<Controller> controllers = new ArrayList<Controller>();
        // 7 knob controllers
        for (int i = 0; i < 7; i++) {
            controllers.add(new KnobController(0, "Knob " + String.valueOf(i)));
        }
        // 1 selector controller
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Label 1");
        labels.add("Label 2");
        labels.add("Label 3");
        labels.add("Label 4");
        labels.add("Label 4");
        labels.add("Label 4");
        labels.add("Label 4");
        controllers.add(new SelectorController(labels, 0, "Label"));
        return controllers;
    }

    void setKnobControls() {
        FragmentManager fm = getFragmentManager();
        android.app.Fragment knobControlFragment = new KnobControlFragment_();
        ((KnobControlFragment) knobControlFragment).setSelectedView((ControllerView) controllersGrid.getChildAt(adapter.selected).findViewById(R.id.input));
        fm.beginTransaction().replace(R.id.selectedControllerInput, knobControlFragment).commit();
    }
}
