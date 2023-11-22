package gui;

import java.util.ArrayList;

import javax.swing.JFrame;  
import javax.swing.SwingUtilities;  
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;

import dao.StatistiqueDao;
import model.Statistiques;  
  
public class BarChartNiveau extends JFrame {  
  
  private static final long serialVersionUID = 1L;  
  
  public BarChartNiveau(String appTitle) {  
    super(appTitle);  
  
    // Create Dataset  
    CategoryDataset dataset = createDataset();  
      
    //Create chart  
    JFreeChart chart=ChartFactory.createBarChart(  
        "Taux d'absences par niveau", //Chart Title  
        "Niveau", // Category axis  
        "Taux d'absences", // Value axis  
        dataset,  
        PlotOrientation.VERTICAL,  
        true,true,false  
       );  
  
    ChartPanel panel=new ChartPanel(chart);  
    setContentPane(panel);  
  }  
  
  private CategoryDataset createDataset() {  
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
  
    ArrayList<Statistiques> arr = StatistiqueDao.statNbAbsByNiveau();
    ArrayList<String> arr1 = StatistiqueDao.nbSeanceByNiveau();
    for(int i=0;i<arr.size();i++) {
    	String [] d = arr1.get(i).split(",");
    	float ta = (arr.get(i).getNombreAbs()/Character.getNumericValue(d[0].charAt(0)))*100;
    	dataset.addValue(ta, arr.get(i).getClasse(),"");
    }
    return dataset;  
  }  
   
}  
