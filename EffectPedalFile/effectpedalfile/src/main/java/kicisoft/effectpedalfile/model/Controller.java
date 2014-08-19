package kicisoft.effectpedalfile.model;

/**
 * Created by Juan on 11/08/2014.
 * Class representing an input controller.
 */
public abstract class Controller {
    String label;

    public abstract int getControllerType();

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
