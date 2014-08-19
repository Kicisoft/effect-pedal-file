package kicisoft.effectpedalfile;

import android.content.Context;
import android.util.AttributeSet;

import org.androidannotations.annotations.EViewGroup;

/**
 * Created by Juan on 10/08/2014.
 * View for a switch controller.
 */
@EViewGroup(R.layout.switch_controller_view)
public class SwitchControllerView extends ControllerView{
    public SwitchControllerView(Context context) {
        super(context);
    }

    public SwitchControllerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SwitchControllerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void increment() {

    }

    @Override
    public void decrease() {

    }
}
