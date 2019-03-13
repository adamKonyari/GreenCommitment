package com.codecool.greencommitment.server;

import com.codecool.greencommitment.common.Measurement;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ChartBuilder {

    public void createChart(List<Measurement> measurementList) {
        DefaultCategoryDataset lineChartDataset = new DefaultCategoryDataset();
        int counter = 1;
        for (Measurement measurement : measurementList) {

            lineChartDataset.addValue(measurement.getValue(), "Measurements", String.valueOf(counter));
            counter++;
        }

        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "Celsius Measurements", "Time",
                "Celsius",
                lineChartDataset, PlotOrientation.VERTICAL,
                true, true, false);

        int width = 1920;
        int height = 1080;
        File lineChart = new File("LineChart.jpeg");
        try {
            ChartUtilities.saveChartAsJPEG(lineChart, lineChartObject, width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

