package kicisoft.effectpedalfile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import kicisoft.effectpedalfile.ControllerView;
import kicisoft.effectpedalfile.SelectorControllerView;
import kicisoft.effectpedalfile.R;
import kicisoft.effectpedalfile.constant.EPFConstants;
import kicisoft.effectpedalfile.model.Controller;
import kicisoft.effectpedalfile.model.SelectorController;


/**
 * Created by Juan on 27/07/2014.
 * Adapter for effect controllers grid.
 */
public class InputAdapter extends BaseAdapter implements AdapterView.OnItemClickListener{
    private Context context;
    private final ArrayList<Controller> controllers;
    public int selected;

    public InputAdapter(Context context, ArrayList<Controller> controllers){
        this.context = context;
        this.controllers = controllers;
    }

    @Override
    public int getCount() {
        return controllers.size();
    }

    @Override
    public Controller getItem(int i) {
        return controllers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    //TODO Optimise
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        HolderView h = new HolderView();

        if(view == null){
            if(getItem(i).getControllerType() == EPFConstants.KNOB_CONTROLLER){
                view = inflater.inflate(R.layout.knob_input_widget, viewGroup, false);
            }

            if(getItem(i).getControllerType() == EPFConstants.SWITCH_CONTROLLER){
                view = inflater.inflate(R.layout.switch_controller_view, null);
            }

            if (getItem(i).getControllerType() == EPFConstants.LEVER_SWITCH_CONTROLLER) {
                view = inflater.inflate(R.layout.selector_input_widget, viewGroup, false);
                RelativeLayout leverContainer = (RelativeLayout) view.findViewById(R.id.leverContainer);
                SelectorController item = (SelectorController)getItem(i);
                int leverHeight = (int)context.getResources().getDimension(R.dimen.lever_switch_position_height) * item.positionLabel.size() - (int)context.getResources().getDimension(R.dimen.lever_switch_height);
                int currentTextMargin = 0;
                RelativeLayout labelContainer = (RelativeLayout) view.findViewById(R.id.labelContainer);
                for(String label: item.positionLabel){
                    TextView textView = new TextView(context);
                    textView.setText(label);
                    textView.setTextSize((int)context.getResources().getDimension(R.dimen.lever_switch_text_size));
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    params.setMargins(0, currentTextMargin, 0, 0);
                    currentTextMargin += (int)context.getResources().getDimension(R.dimen.lever_switch_position_height);
                    textView.setLayoutParams(params);
                    labelContainer.addView(textView);
                }
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, leverHeight + (int)context.getResources().getDimension(R.dimen.lever_switch_height));
                params.addRule(RelativeLayout.CENTER_IN_PARENT);
                leverContainer.setLayoutParams(params);
                ImageView leverBg = (ImageView) view.findViewById(R.id.guide);
                params = new RelativeLayout.LayoutParams((int)context.getResources().getDimension(R.dimen.lever_switch_height), leverHeight);
                leverBg.setLayoutParams(params);
            }

            h.name = (TextView)view.findViewById(R.id.name);
            h.inputView = (ControllerView)view.findViewById(R.id.input);

            view.setTag(h);
        } else {
            h = (HolderView) view.getTag();
        }

        h.name.setText(getItem(i).getLabel());

        if (getItem(i).getControllerType() == EPFConstants.LEVER_SWITCH_CONTROLLER) {
            ((SelectorControllerView)h.inputView).maxPos = ((SelectorController)getItem(i)).positionLabel.size()-1;
        }

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        this.selected = i;
    }

    private class HolderView {
        TextView name;
        ControllerView inputView;
    }
}
