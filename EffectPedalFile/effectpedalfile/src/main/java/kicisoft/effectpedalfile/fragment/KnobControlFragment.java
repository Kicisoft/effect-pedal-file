package kicisoft.effectpedalfile.fragment;

import android.view.View;
import android.widget.ImageButton;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import kicisoft.effectpedalfile.ControllerView;
import kicisoft.effectpedalfile.R;

/**
 * Created by Juan on 18/08/2014.
 * Fragment for knob control.
 */
@EFragment(R.layout.knob_controls_view)
public class KnobControlFragment extends android.app.Fragment {
    @ViewById
    ImageButton addButton, removeButton;

    ControllerView selectedView;

    public void setSelectedView(ControllerView selectedView) {
        this.selectedView = selectedView;
    }

    @AfterViews
    void init() {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedView.increment();
            }
        });
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedView.decrease();
            }
        });
    }
}
