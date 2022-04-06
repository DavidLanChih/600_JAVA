/**
 * @jdk版本:1.6
 * @寫程式時間:2010-7-20
 */
package com.mingrisoft.jfreechart.line;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * XY聚合線圖
 * @author baiweiming
 * 
 */
public class LineDemo11 extends ApplicationFrame {

	public LineDemo11(String title) {
		super(title);
	}

	/**
	 * 建立資料集
	 * 
	 * @return
	 */
	private IntervalXYDataset getDataset() {

		final XYSeries series1 = new XYSeries("JAVA圖書");
		final XYSeries series2 = new XYSeries("VC圖書");
		final XYSeries series3 = new XYSeries("VB圖書");

		series1.add(501, 3);
		series1.add(200, 2);
		series1.add(308, 2);
		series1.add(580, 4);
		series1.add(418, 2);
		series1.add(315, 1);

		series2.add(480, 2);
		series2.add(381, 3);
		series2.add(264, 1);
		series2.add(185, 2);
		series2.add(209, 2);
		series2.add(302, 2);

		series3.add(310, 2);
		series3.add(489, 2);
		series3.add(512, 3);
		series3.add(589, 4);
		series3.add(359, 2);
		series3.add(402, 2);

		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);
		return dataset;
	}

	/**
	 * 產生JFreeChart
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		IntervalXYDataset dataset = getDataset();
		JFreeChart chart = ChartFactory.createXYLineChart("2010年上半年圖書完成量", // 圖表標題
				"完成頁數", // x軸標籤
				"人員數量", // y軸標籤
				dataset, // 資料集
				PlotOrientation.VERTICAL, // 圖表方向：水平、垂直
				true, // 是否顯示圖例
				false, // 是否產生工具
				false // 是否產生URL鏈接
				);
		return chart;
	}

	/**
	 * 修改字體
	 * 
	 * @param chart
	 */
	private void updateFont(JFreeChart chart) {

		// 標題
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("細明體", Font.PLAIN, 20));
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("細明體", Font.PLAIN, 14));
		// 圖表
		XYPlot plot = chart.getXYPlot();
		NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
		// X軸字體
		domainAxis.setTickLabelFont(new Font("細明體", Font.PLAIN, 14));
		// X軸標籤字體
		domainAxis.setLabelFont(new Font("細明體", Font.PLAIN, 14));

		ValueAxis valueAxis = plot.getRangeAxis();
		// y軸字體
		valueAxis.setTickLabelFont(new Font("細明體", Font.PLAIN, 14));
		// y軸標籤字體
		valueAxis.setLabelFont(new Font("細明體", Font.PLAIN, 14));
	}

	/**
	 * 設定圖表
	 * 
	 * @param chart
	 */
	public void createPlot() {
		JFreeChart chart = getJFreeChart();
		// 修改字體
		updateFont(chart);
		setContentPane(new ChartPanel(chart));
	}

	public static void main(String[] args) {
		LineDemo11 demo = new LineDemo11("聚合線圖");
		demo.createPlot();
		demo.pack();
		// 把窗體顯示到顯示器中央
		RefineryUtilities.centerFrameOnScreen(demo);
		// 設定可以顯示
		demo.setVisible(true);
	}
}