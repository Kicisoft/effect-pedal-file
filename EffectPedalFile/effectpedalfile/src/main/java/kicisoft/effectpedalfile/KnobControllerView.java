package kicisoft.effectpedalfile;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;


import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Juan on 10/08/2014.
 * View for a knob controller.
 */
@EViewGroup(R.layout.knob_controller_view)
public class KnobControllerView extends ControllerView{
    int currentRotation = 0;

    @ViewById
    ImageView knob;

    public KnobControllerView(Context context) {
        super(context);
    }

    public KnobControllerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KnobControllerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void increment() {
        if (currentRotation < 160) {
            currentRotation += 10;
        }
        updateRotation();
    }

    private void updateRotation() {
        knob.setRotation(currentRotation);
    }

    @Override
    public void decrease() {
        if(currentRotation > -160){
            currentRotation -= 10;
        }
        updateRotation();
    }
}
