/**
 * @jdk版本:1.6
 * @寫程式時間:2010-7-20
 */
package com.mingrisoft.jfreechart.bar;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarDemo20 extends ApplicationFrame {

	public BarDemo20(String title) {
		super(title);
	}

	/**
	 * 建立一個資料集
	 * 
	 * @return
	 */
	private CategoryDataset getCategoryDataset() {

		DefaultKeyedValues keyedValues = new DefaultKeyedValues();
		keyedValues.addValue("1", 310);
		keyedValues.addValue("2", 489);
		keyedValues.addValue("3", 512);
		keyedValues.addValue("4", -589);
		keyedValues.addValue("5", null);
		keyedValues.addValue("6", 402);
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				"java book", keyedValues);
		return dataset;
	}

	/**
	 * 產生JFreeChart
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		CategoryDataset dataset = getCategoryDataset();
		JFreeChart chart = ChartFactory.createBarChart("2010.1-6 sales volume", // 圖表標題
				"month", // x軸標籤
				"sales", // y軸標籤
				dataset, // 資料集
				PlotOrientation.VERTICAL, // 圖表方向：水平、垂直
				false, // 是否顯示圖例(對於簡單的柱狀圖必須是false)
				false, // 是否產生工具
				false // 是否產生URL鏈接
				);

		return chart;
	}

	/**
	 * 設定圖表
	 * 
	 * @param chart
	 */
	public void createPlot() {
		JFreeChart chart = getJFreeChart();
		// 把JFreeChart面板儲存在窗體裡
		setContentPane(new ChartPanel(chart));

	}

	public static void main(String[] args) {
		BarDemo20 barDemo = new BarDemo20("柱形圖實例");
		barDemo.createPlot();
		barDemo.pack();
		// 把窗體顯示到顯示器中央
		RefineryUtilities.centerFrameOnScreen(barDemo);
		//設定可以顯示
		barDemo.setVisible(true);

	}
}
