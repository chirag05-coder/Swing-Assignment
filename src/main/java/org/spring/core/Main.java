package org.spring.core;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Graph based on Mud_weight.csv
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MudWeightApp().setVisible(true);
            }
        });

        //For creating a new file by changing the unit of the weight
        MudWeightConverter mudWeightConverter = new MudWeightConverter();
        mudWeightConverter.convertMudWeight();

        //For creating a new File by changing weight Multiplied by Pi value
        MudWeightPi mudWeightPi = new MudWeightPi();
        mudWeightPi.convertMudWeight();
    }
}