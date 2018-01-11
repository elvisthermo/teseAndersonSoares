/*
 * Copyright (c) 2012 Macrofocus GmbH. All Rights Reserved.
 */

import javax.swing.*;
import java.awt.*;

/**
 * A template to create additional demo module.
 */
@SuppressWarnings("serial")
abstract public class AbstractDemo implements Demo {
    public AbstractDemo() {
    }

    public String getDescription() {
        return null;
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public String toString() {
        return getName();
    }

    public Component getOptionsPanel() {
        return null;
    }

    public static JFrame showAsFrame(final Demo demo) {
        final JFrame frame = new JFrame(demo.getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Component demoPanel = demo.getDemoPanel();
        JComponent pane = createOptionsPanel(frame, demo, demoPanel);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(demoPanel, BorderLayout.CENTER);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        if (pane != null) {
            frame.getContentPane().add(new JScrollPane(pane), BorderLayout.BEFORE_LINE_BEGINS);
        }

        frame.pack();

        frame.setVisible(true);
        frame.toFront();
        return frame;
    }

    protected static JComponent createOptionsPanel(JFrame parentFrame, Demo demo, Component demoPanel) {
        JPanel panes = new JPanel(new BorderLayout());

        if (demoPanel != null) {
            demoPanel.setName("Demo.DemoPanel");
            Component optionsPanel = demo.getOptionsPanel();
            if (optionsPanel != null) {
                optionsPanel.setName("Demo.OptionsPanel");
            }

            if (optionsPanel != null) {
                panes.add(optionsPanel);
            }
        }
        return panes;
    }

    public int getAttributes() {
        return ATTRIBUTE_NONE;
    }
}


