package kicisoft.effectpedalfile;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Juan on 10/08/2014.
 * View for a selector controller.
 */
@EViewGroup(R.layout.selector_controller_view)
public class SelectorControllerView extends ControllerView{
    @ViewById
    ImageView selector;
    public int currentPosition;
    public int maxPos;
    public SelectorControllerView(Context context) {
        super(context);
    }

    public SelectorControllerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SelectorControllerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void increment() {
        if(currentPosition < maxPos)
        currentPosition++;

        updatePosition();

    }

    @Override
    public void decrease() {
        if (currentPosition > 0) {
            currentPosition--;
        }

        updatePosition();
    }

    private void updatePosition(){
        RelativeLayout.LayoutParams params = (LayoutParams) selector.getLayoutParams();
        params.setMargins(0, currentPosition * (int)getResources().getDimension(R.dimen.lever_switch_position_height), 0, 0);
        selector.setLayoutParams(params);
    }
}