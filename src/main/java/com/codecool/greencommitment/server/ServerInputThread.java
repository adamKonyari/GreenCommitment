package com.codecool.greencommitment.server;

import com.codecool.greencommitment.common.Measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerInputThread extends Thread {

    private Scanner scanner = new Scanner(System.in);
    private String userInput;
    private List<Measurement> measurementList = new ArrayList<>();
    private ChartBuilder chartBuilder = new ChartBuilder();

    public ServerInputThread(List<Measurement> measurementList) {

        this.measurementList = measurementList;
    }


    public void run() {
        while(true) {
            userInput = scanner.nextLine();
            switch(userInput){
                case "x":
                    System.exit(0);
                case "c":
                    chartBuilder.createChart(measurementList);
            }
        }
    }
}