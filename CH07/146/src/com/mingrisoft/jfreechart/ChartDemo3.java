/**
 * @jdk版本:1.6
 * @寫程式時間:2010-7-20
 */
package com.mingrisoft.jfreechart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class ChartDemo3 {

	/**
	 * 產生JFreeChart
	 * 
	 * @return
	 */
	public JFreeChart getJFreeChart() {
		PieDataset dataset = getPieDataset();
		JFreeChart chart = ChartFactory.createPieChart("Pie title", dataset,
				true, true, false);
		return chart;
	}

	/**
	 * 建立一個餅圖表的資料集
	 * 
	 * @return
	 */
	private PieDataset getPieDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("A", 200);
		dataset.setValue("B", 400);
		dataset.setValue("C", 500);
		return dataset;
	}

	public static void main(String[] args) {
		ChartDemo3 demo = new ChartDemo3();
		ChartFrame chartFrame = new ChartFrame("JFreeChar Demo",
				demo.getJFreeChart());
		chartFrame.pack();
		chartFrame.setVisible(true);

	}
}
