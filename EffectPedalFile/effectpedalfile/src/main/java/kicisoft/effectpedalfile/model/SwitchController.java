package kicisoft.effectpedalfile.model;

import kicisoft.effectpedalfile.constant.EPFConstants;

/**
 * Created by Juan on 11/08/2014.
 * Class representing a switch controller.
 */
public class SwitchController extends Controller{
    boolean activated;

    public SwitchController(boolean activated, String label) {
        this.activated = activated;
        this.label = label;
    }

    @Override
    public int getControllerType() {
        return EPFConstants.SWITCH_CONTROLLER;
    }
}
