package com.mingrisoft.jfreechart.ring;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * 環形的陰影偏移
 * @author baiweiming
 *
 */
public class RingDeom6 extends ApplicationFrame {

	public RingDeom6(String title) {
		super(title);
	}

	/**
	 * 建立一個資料集
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
		JFreeChart chart = ChartFactory.createRingChart("2010上半年銷售記錄", // 圖表標題
				dataset, // 資料集
				true, // 是否顯示圖例(對於簡單的柱狀圖必須是false)
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

		// 圖表
		RingPlot ringPlot = (RingPlot) chart.getPlot();
		ringPlot.setLabelFont(new Font("細明體", Font.PLAIN, 14));
		ringPlot.setLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0}:{1}"));

		// 標題
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("細明體", Font.PLAIN, 20));
		//圖示
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("細明體", Font.PLAIN, 14));

	}

	/**
	 * 更新圖表顯示
	 * 
	 * @param chart
	 */
	private void updatePlot(JFreeChart chart) {
		// 圖表
		RingPlot plot = (RingPlot) chart.getPlot();
		//陰影偏移
		plot.setShadowXOffset(20);
		plot.setShadowYOffset(20);
	}

	/**
	 * 設定圖表
	 * 
	 * @param chart
	 */
	public void createPlot() {
		JFreeChart chart = getJFreeChart();
		// 設定字體
		updateFont(chart);
		//設定圖表
		updatePlot(chart);
		// 把JFreeChart面板儲存在窗體裡
		setContentPane(new ChartPanel(chart));

	}

	public static void main(String[] args) {
		RingDeom6 demo = new RingDeom6("環形圖");
		demo.createPlot();
		demo.pack();
		// 把窗體顯示到顯示器中央
		RefineryUtilities.centerFrameOnScreen(demo);
		// 設定可以顯示
		demo.setVisible(true);

	}

}
