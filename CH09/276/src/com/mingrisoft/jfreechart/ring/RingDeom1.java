package com.mingrisoft.jfreechart.ring;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * 基本環形圖
 * @author baiweiming
 *
 */
public class RingDeom1 extends ApplicationFrame {

	public RingDeom1(String title) {
		super(title);
	}

	/**
	 * 建立一個資料集
	 * 
	 * @return
	 */
	private PieDataset getPieDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();

		dataset.setValue("java book", 1689);
		dataset.setValue("vc book", 810);
		dataset.setValue("vb book", 490);
		return dataset;
	}

	/**
	 * 產生JFreeChart
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		PieDataset dataset = getPieDataset();
		JFreeChart chart = ChartFactory.createRingChart(
				"2010.1-6 sales volume", // 圖表標題
				dataset, // 資料集
				true, // 是否顯示圖例
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
		RingDeom1 demo = new RingDeom1("環形圖");
		demo.createPlot();
		demo.pack();
		// 把窗體顯示到顯示器中央
		RefineryUtilities.centerFrameOnScreen(demo);
		// 設定可以顯示
		demo.setVisible(true);

	}

}
