import java.awt.*;
import java.io.Serializable;

/*
* Copyright (c) 2012 Macrofocus GmbH. All Rights Reserved.
*/
public interface Demo extends Serializable {

    public static final int ATTRIBUTE_NONE = 0;
    public static final int ATTRIBUTE_NEW = 1;
    public static final int ATTRIBUTE_BETA = 2;
    public static final int ATTRIBUTE_UPDATED = 4;

    /**
     * Gets the name of this demo.
     *
     * @return the name of the demo.
     */
    String getName();

    /**
     * Gets the description of this demo.
     *
     * @return the description of the demo.
     */
    String getDescription();

    /**
     * Gets the main demo panel.
     *
     * @return the main demo panel.
     */
    Component getDemoPanel();

    /**
     * Gets the panel where user can set options of the demoing component(s).
     *
     * @return options panel.
     */
    Component getOptionsPanel();

    /**
     * Gets attributes such as new, updated, beta etc.
     *
     * @return attributes
     */
    int getAttributes();

}
