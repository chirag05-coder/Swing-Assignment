package org.spring.core;

import com.opencsv.CSVWriter;

import java.io.*;

public class MudWeightConverter {
    public void convertMudWeight() {
        try
              {

                  FileWriter fw=new FileWriter("D:\\CodingNinjasSpringboot\\assignment\\SwingAssignment\\src\\main\\resources\\Mud_Weight_Converted.csv");
                  File file = new File("D:\\CodingNinjasSpringboot\\assignment\\SwingAssignment\\src\\main\\resources\\Mud_Weight_Converted.csv");
                  FileWriter outputfile = new FileWriter(file);

                  CSVWriter writer = new CSVWriter(outputfile);

                  String[] header = { "MD","Mud_Weight_kg_per_m3" };
            writer.writeNext(header);
                  BufferedReader br = new BufferedReader(new FileReader(new File("D:\\CodingNinjasSpringboot\\assignment\\SwingAssignment\\src\\main\\resources\\Mud_Weight.csv")));
                  String line = "";
                  int cnt = 0 ;
                  while((line = br.readLine()) != null && cnt<2){

                      cnt++;

                  }
                  while ((line = br.readLine()) != null)
                  {
                      String[] parts = line.split(",");
                      double md = Double.parseDouble(parts[0]);
                      double mudWeightLbmPerGal = Double.parseDouble(parts[1]);
//                      System.out.println(md + " " + mudWeightLbmPerGal );


                      double mudWeightKgPerM3 = mudWeightLbmPerGal * 119.826427;
                      writer.writeNext(new String[]{String.valueOf(md), String.valueOf(mudWeightKgPerM3)});
                  }
                  writer.close();



            System.out.println("Conversion completed. New file created: Mud_Weight_Converted.csv");

        } catch (IOException | NumberFormatException ex) {
            System.err.println("Error reading or converting the CSV file: " + ex.getMessage());
        }
    }
}
