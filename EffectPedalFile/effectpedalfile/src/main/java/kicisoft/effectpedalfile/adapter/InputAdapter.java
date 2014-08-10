package kicisoft.effectpedalfile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import kicisoft.effectpedalfile.R;


/**
 * Created by Juan on 27/07/2014.
 */
public class InputAdapter extends BaseAdapter {
    private Context context;
    private final String[] controllers;

    public InputAdapter(Context context, String[] controllers){
        this.context = context;
        this.controllers = controllers;
    }

    @Override
    public int getCount() {
        return controllers.length;
    }

    @Override
    public Object getItem(int i) {
        return controllers[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        HolderView h = new HolderView();

        if(view == null){
            view = inflater.inflate(R.layout.input_widget, null);

            h.name = (TextView)view.findViewById(R.id.name);
            h.inputView = (FrameLayout)view.findViewById(R.id.input);

            view.setTag(h);
        } else {
            h = (HolderView) view.getTag();
        }

        h.name.setText(controllers[i]);

        return view;
    }

    private class HolderView {
        TextView name;
        FrameLayout inputView;
    }
}
