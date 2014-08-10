package kicisoft.effectpedalfile.model;

/**
 * Created by Juan on 10/08/2014.
 * Mock class, should represent a pedal set up instance.
 */
public class SetUp {
    String name;
    String dateOfCreation;

    /**
     * Contructor for a mock instance of SetUp.
     * @param name Setup name.
     * @param dateOfCreation Setup date of creation.
     */
    public SetUp(String name, String dateOfCreation) {
        this.name = name;
        this.dateOfCreation = dateOfCreation;
    }
}
