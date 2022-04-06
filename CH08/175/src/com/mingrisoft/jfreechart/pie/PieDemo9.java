/**
 * @jdk版本:1.6
 * @寫程式時間:2010-7-20
 */
package com.mingrisoft.jfreechart.pie;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;

public class PieDemo9 extends ApplicationFrame {

	public PieDemo9(String title) {
		super(title);
	}

	/**
	 * 建立一個餅圖表的資料集 把資料增加到資料集中
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
	 * 獲得資料集，產生JFreeChart，
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		PieDataset dataset = getPieDataset();
		JFreeChart chart = ChartFactory.createPieChart3D("2010.8月份銷售排行",
				dataset, true, true, false);
		// 設定餅圖使用的字體
		setPiePoltFont(chart);
		return chart;
	}

	/**
	 * 設定餅圖使用的字體
	 * 
	 * @param chart
	 */
	protected void setPiePoltFont(JFreeChart chart) {

		// 分類別標籤字體和顯示
		PiePlot piePlot = (PiePlot) chart.getPlot();
		piePlot.setLabelFont(new Font("細明體", Font.PLAIN, 14));
		piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0}:{1}"));

		// 標題字體
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("細明體", Font.BOLD, 20));

		// 圖例字體
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
		PiePlot3D plot = (PiePlot3D) chart.getPlot();

		ActionListener actionListener = new PieDemo9Listener(plot);
		// 增加監聽
		Timer timer = new Timer(100, actionListener);
		//啟動timer時間器
		timer.start();

		// 把JFreeChart對像儲存到面板中
		setContentPane(new ChartPanel(chart));

	}

	public static void main(String[] args) {
		PieDemo9 pieChartDemo1 = new PieDemo9("餅圖實例");
		// 建立圖形
		pieChartDemo1.createPiePlot();
		// 產生圖形
		pieChartDemo1.pack();
		// 把窗體顯示到顯示器中
		RefineryUtilities.centerFrameOnScreen(pieChartDemo1);
		// 設定顯示圖形狀態
		pieChartDemo1.setVisible(true);

	}

}
