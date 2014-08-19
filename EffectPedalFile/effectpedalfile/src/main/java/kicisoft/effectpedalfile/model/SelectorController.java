package kicisoft.effectpedalfile.model;

import java.util.ArrayList;

import kicisoft.effectpedalfile.constant.EPFConstants;

/**
 * Created by Juan on 11/08/2014.
 * Class representing a selector controller.
 */
public class SelectorController extends Controller {
    public ArrayList<String> positionLabel;
    public int currentPosition;

    public SelectorController(ArrayList<String> positionLabel, int currentPosition, String label) {
        this.positionLabel = positionLabel;
        this.currentPosition = currentPosition;
        this.label = label;
    }

    @Override
    public int getControllerType() {
        return EPFConstants.LEVER_SWITCH_CONTROLLER;
    }
}
