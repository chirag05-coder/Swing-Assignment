package org.spring.core;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MudWeightApp extends JFrame {
    private JTextArea logTextArea;
    private XYSeries mudWeightSeries;

    public MudWeightApp() {
        super("Mud Weight Analysis");

        // Initialize components
        JButton displayButton = new JButton("Display");
        JButton clearButton = new JButton("Clear");
        logTextArea = new JTextArea(20, 40);

        // Chart initialization
        mudWeightSeries = new XYSeries("Mud Weight");
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Mud Weight Analysis",
                "MD",
                "Mud Weight",
                new XYSeriesCollection(mudWeightSeries)
        );
        XYPlot plot = (XYPlot) chart.getPlot();
        ChartPanel chartPanel = new ChartPanel(chart);

        // Button event handlers
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayLog();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearLog();
            }
        });

        // Layout setup
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(displayButton);
        buttonPanel.add(clearButton);

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(logTextArea), BorderLayout.CENTER);
        add(chartPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Center on screen
    }

    private void displayLog() {
        try  {
            BufferedReader br = new BufferedReader(new FileReader(new File("D:\\CodingNinjasSpringboot\\assignment\\SwingAssignment\\src\\main\\resources\\Mud_Weight.csv")));
            String line = "";
            int cnt = 0 ;
            while((line = br.readLine()) != null && cnt<2){

                cnt++;

            }
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(",");    // use comma as separator
                mudWeightSeries.add(Double.parseDouble(employee[0]), Double.parseDouble(employee[1]));
            }

        } catch (IOException | NumberFormatException ex) {
            logTextArea.append("Error reading or parsing the CSV file.\n");
        }
    }

    private void clearLog() {
        logTextArea.setText("");
        mudWeightSeries.clear();
    }
}
