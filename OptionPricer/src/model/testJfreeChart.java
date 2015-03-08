/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optionpricer;

/**
 *
 * @author catherine_Liu
 */
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.EmptyBlock;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class testJfreeChart {

    public static class volatilityGraph extends ApplicationFrame {

        volatilityGraph(String s, double[] volatility, double[] optionPrice) {
            super(s);
            setContentPane(createDemoPanel(volatility, optionPrice));
        }

        private XYDataset createDataset(double[] volatility, double[] optionPrice) {
            XYSeries xyseries = new XYSeries("");
            int i = 0;
            for (i = 0; i < 11; i++) {
                xyseries.add(volatility[i], optionPrice[i]);
            }
            XYSeriesCollection xyseriescollection = new XYSeriesCollection();
            xyseriescollection.addSeries(xyseries);
            return xyseriescollection;
        }

        private JFreeChart createChart(double[] volatility, double[] optionPrice) {
            XYDataset xydataset = createDataset(volatility, optionPrice);
            JFreeChart jfreechart = ChartFactory.createXYLineChart(
                    "Volatility Graph", "volatility(%)", "Option Price($)", xydataset,
                    PlotOrientation.VERTICAL, false, true, false);
            XYPlot xyplot = (XYPlot) jfreechart.getPlot();
            NumberAxis numberaxis = (NumberAxis) xyplot.getRangeAxis();
            numberaxis.setAutoRangeIncludesZero(false);
            xyplot.mapDatasetToRangeAxis(1, 1);
            XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) xyplot.getRenderer();

            XYPointerAnnotation xypointerannotation = new XYPointerAnnotation("Annotation 1 (2.0, 167.3)", 5D, 100.30000000000001D, -0.78539816339744828D);
            xypointerannotation.setTextAnchor(TextAnchor.BOTTOM_LEFT);
            xypointerannotation.setPaint(Color.red);  //线的颜色
            xypointerannotation.setArrowPaint(Color.red);
            xylineandshaperenderer.addAnnotation(xypointerannotation);
            XYLineAndShapeRenderer xylineandshaperenderer1 = new XYLineAndShapeRenderer(true, true);
            xylineandshaperenderer1.setSeriesPaint(0, Color.black);

            LegendTitle legendtitle = new LegendTitle(xylineandshaperenderer);

            return jfreechart;
        }

        public JPanel createDemoPanel(double[] volatility, double[] optionPrice) {
            JFreeChart jfreechart = createChart(volatility, optionPrice);
            return new ChartPanel(jfreechart);
        }
    }
    /*public static void main(String args[]) {  
     int i=0; 
     double[] a,b;
     a=new double[11];
     b = new double[11];
     for(i=0;i<11;i++){
     a[i]=i;
     b[i]=i;
     }
     JFrame.setDefaultLookAndFeelDecorated(true);  
     volatilityGraph graph = new volatilityGraph("Option Pricer Software",a,b);  
     graph.pack();  
     RefineryUtilities.centerFrameOnScreen(graph);  
     graph.setVisible(true);  
     } */

}
