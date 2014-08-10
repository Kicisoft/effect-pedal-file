package kicisoft.effectpedalfile.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import kicisoft.effectpedalfile.R;


/**
 * Text view with custom font.
 *
 * Created by jmartinez on 08/08/14.
 */
public class CustomTextView extends TextView {

    private Context ctx;
    private String fontName = "fonts/ag-book-rounded-bold.ttf"; // Default

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ctx = context;
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        String font;
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.CustomAttributes, 0, 0);
        try {
            font = a.getString(R.styleable.CustomAttributes_customFont);
            a.recycle();
        } catch (NullPointerException e) {
            font = null;
        }

        if(font != null) {
            fontName = font;
        }

        if(fontName != null && !isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(ctx.getAssets(), fontName);
            this.setTypeface(tf);
        }
    }
}
