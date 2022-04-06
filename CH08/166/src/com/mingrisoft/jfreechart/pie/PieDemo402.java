/**
 * @jdk版本:1.6
 * @寫程式時間:2010-7-20
 */
package com.mingrisoft.jfreechart.pie;

import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;

public class PieDemo402 extends ApplicationFrame {

	public PieDemo402(String title) {
		super(title);
	}

	/**
	 * 建立一個餅圖表的資料集
	 * 
	 * @return
	 */
	private PieDataset getPieDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("JAVA從入門到精通（第2版）", 500);
		dataset.setValue("視訊學JAVA", 800);
		dataset.setValue("JAVA全能速查寶典", 1000);
		dataset.setValue("Java範例完全自學手冊(1DVD)", 400);
		dataset.setValue("Java開發典型模塊大全", 750);
		return dataset;
	}

	/**
	 * 產生JFreeChart
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		PieDataset dataset = getPieDataset();
		JFreeChart chart = ChartFactory.createPieChart("2010.8月份銷售排行", dataset,
				true, true, false);
		setPiePoltFont(chart);
		return chart;
	}

	/**
	 * 設定餅圖使用的字體
	 * 
	 * @param chart
	 */
	protected void setPiePoltFont(JFreeChart chart) {

		// 圖表(餅圖)
		PiePlot piePlot = (PiePlot) chart.getPlot();
		piePlot.setLabelFont(new Font("細明體", Font.PLAIN, 14));
		piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0}:{1}"));

		// 標題
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("細明體", Font.BOLD, 20));

		// 圖例
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("細明體", Font.PLAIN, 14));

	}

	/**
	 * 設定Pie
	 * 
	 * @param chart
	 */
	public void createPiePlot() {
		JFreeChart chart = getJFreeChart();
		PiePlot piePlot = (PiePlot) chart.getPlot();
		
		//設定餅圖邊框的顏色
		piePlot.setSectionOutlinePaint("JAVA從入門到精通（第2版）", Color.black);
		piePlot.setSectionOutlinePaint("視訊學JAVA", Color.black);
		piePlot.setSectionOutlinePaint("JAVA全能速查寶典", Color.black);
		piePlot.setSectionOutlinePaint("Java範例完全自學手冊(1DVD)", Color.black);
		piePlot.setSectionOutlinePaint("Java開發典型模塊大全", Color.black);

		// 把JFreeChart面板儲存在窗體裡
		setContentPane(new ChartPanel(chart));

	}

	public static void main(String[] args) {
		PieDemo402 pieChartDemo1 = new PieDemo402("餅圖實例");
		pieChartDemo1.createPiePlot();
		pieChartDemo1.pack();
		// 把窗體顯示到顯示器中央
		RefineryUtilities.centerFrameOnScreen(pieChartDemo1);
		pieChartDemo1.setVisible(true);

	}
}
