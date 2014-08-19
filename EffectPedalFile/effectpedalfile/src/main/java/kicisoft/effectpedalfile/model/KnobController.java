package kicisoft.effectpedalfile.model;

import kicisoft.effectpedalfile.constant.EPFConstants;

/**
 * Created by Juan on 11/08/2014.
 * Class representing a knob controller.
 */
public class KnobController extends Controller {
    int currentValue;

    public KnobController(int currentValue, String label) {
        this.label = label;
        this.currentValue = currentValue;
    }

    @Override
    public int getControllerType() {
        return EPFConstants.KNOB_CONTROLLER;
    }
}
