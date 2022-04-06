/**
 * @jdk版本:1.6
 * @寫程式時間:2010-7-20
 */
package com.mingrisoft.jfreechart.bubble;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * 氣泡圖X軸尺度標籤角度
 * @author baiweiming
 * 
 */
public class BubbleDemo8 extends ApplicationFrame {

	public BubbleDemo8(String title) {
		super(title);
	}

	/**
	 * 建立資料集
	 * 
	 * @return
	 */
	private XYZDataset getDataset() {

		// 系例關鍵字
		final String series1 = "JAVA圖書";
		final String series2 = "VC圖書";
		final String series3 = "VB圖書";
		
		// 建立分類別資料集
		DefaultXYZDataset dataset = new DefaultXYZDataset();
		double data1 [] [] =    new double[][] {{600}, {10}, {600/(10*10)}};
		double data2 [] [] =    new double[][] {{650}, {10}, {650/(10*10)}};
		double data3 [] [] =    new double[][] {{800}, {16}, {800/(16*10)}};

		dataset.addSeries(series1, data1);
		dataset.addSeries(series2, data2);
		dataset.addSeries(series3, data3);

		return dataset;
	}

	/**
	 * 產生JFreeChart
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		XYZDataset dataset = getDataset();
		JFreeChart chart = ChartFactory.createBubbleChart("2010年上半年銷售量", // 圖表標題
				"頁數", // x軸標籤
				"章數", // y軸標籤
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
		//圖示
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("細明體", Font.PLAIN, 14));
		
		XYPlot plot = chart.getXYPlot();
		//X軸
		NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
		domainAxis.setLabelFont(new Font("細明體", Font.PLAIN, 14));
		//Y軸
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setLabelFont(new Font("細明體", Font.PLAIN, 14));
	}

	/**
	 * 更新圖表顯示
	 * 
	 * @param chart
	 */
	private void updatePlot(JFreeChart chart) {
		XYPlot plot = chart.getXYPlot();
		//設定透明度
		plot.setForegroundAlpha(0.8f);
		ValueAxis valueAxis = plot.getDomainAxis();
		//氣泡圖X軸尺度標籤角度
		valueAxis.setVerticalTickLabels(true);

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
		//修改圖表
		updatePlot(chart);
		
		setContentPane(new ChartPanel(chart));
	}

	public static void main(String[] args) {
		BubbleDemo8 demo = new BubbleDemo8("氣泡圖");
		demo.createPlot();
		demo.pack();
		// 把窗體顯示到顯示器中央
		RefineryUtilities.centerFrameOnScreen(demo);
		// 設定可以顯示
		demo.setVisible(true);
	}
}
