/**
 * @jdk版本:1.6
 * @寫程式時間:2010-7-20
 */
package com.mingrisoft.jfreechart.pie;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;

public class PieDemo14 extends ApplicationFrame {

	public PieDemo14(final String title) {
		super(title);

	}

	/**
	 * 建立資料集
	 * 
	 * @return
	 */
	private CategoryDataset createDataset() {
		 double[][] data = new double[][] {
				{ 620, 410, 310 },
				{ 300, 390, 500 } };
		 CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				"部門",//行名稱 
				"月份",//列名稱
				data);
		return dataset;
	}

	/**
	 * 獲得資料集，產生JFreeChart，
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		CategoryDataset dataset = createDataset();
		JFreeChart chart = ChartFactory.createMultiplePieChart3D(
				"4-6月銷售排行", // 餅圖標題
				dataset, // 資料集
				TableOrder.BY_COLUMN, // 排序方式
				true, true, false);
		return chart;
	}

	/**
	 * 建立餅圖
	 */
	public void createPiePlot() {
		JFreeChart chart = getJFreeChart();
		// 窗體標題
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("細明體", Font.BOLD, 20));

		// 圖例
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("細明體", Font.PLAIN, 14));
		
		
		MultiplePiePlot multiplePiePlot = (MultiplePiePlot) chart.getPlot();
		JFreeChart jFreeChart = multiplePiePlot.getPieChart();

		// 圖表標籤
		PiePlot3D piePlot = (PiePlot3D) jFreeChart.getPlot();

		piePlot.setLabelFont(new Font("細明體", Font.PLAIN, 14));
		piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0}:{1}"));
		// 圖表標題
		TextTitle textTitle2 = jFreeChart.getTitle();
		textTitle2.setFont(new Font("細明體", Font.BOLD, 20));
		
		
		setContentPane(new ChartPanel(chart));
	}

	public static void main(final String[] args) {

		final PieDemo14 demo = new PieDemo14("餅圖實例");
		demo.createPiePlot();
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}

}
