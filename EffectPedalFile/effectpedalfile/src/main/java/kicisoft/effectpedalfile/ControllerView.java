package kicisoft.effectpedalfile;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Juan on 10/08/2014.
 * Abstract class for a controller view.
 */
public abstract class ControllerView extends RelativeLayout{

    public ControllerView(Context context) {
        super(context);
    }

    public ControllerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ControllerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public abstract void increment();
    public abstract void decrease();
}
