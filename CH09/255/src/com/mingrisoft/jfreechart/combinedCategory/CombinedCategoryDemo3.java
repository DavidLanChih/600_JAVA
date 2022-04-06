/**
 * @jdk版本:1.6
 * @寫程式時間:2010-7-20
 */
package com.mingrisoft.jfreechart.combinedCategory;

import java.awt.Font;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * 設定圖表位置
 * @author baiweiming
 */
public class CombinedCategoryDemo3 extends ApplicationFrame {

	public CombinedCategoryDemo3(String title) {
		super(title);
	}

	/**
	 * 建立資料集
	 * 
	 * @return
	 */
	private CategoryDataset getCategoryDataset() {

		// 行關鍵字
		final String series1 = "JAVA圖書";
		final String series2 = "VC圖書";
		final String series3 = "VB圖書";
		// 列關鍵字
		final String category1 = "1月";
		final String category2 = "2月";
		final String category3 = "3月";
		final String category4 = "4月";
		final String category5 = "5月";
		final String category6 = "6月";

		// 建立分類別資料集
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(310, series1, category1);
		dataset.addValue(489, series1, category2);
		dataset.addValue(512, series1, category3);
		dataset.addValue(589, series1, category4);
		dataset.addValue(359, series1, category5);
		dataset.addValue(402, series1, category6);

		dataset.addValue(501, series2, category1);
		dataset.addValue(200, series2, category2);
		dataset.addValue(308, series2, category3);
		dataset.addValue(580, series2, category4);
		dataset.addValue(418, series2, category5);
		dataset.addValue(315, series2, category6);

		dataset.addValue(480, series3, category1);
		dataset.addValue(381, series3, category2);
		dataset.addValue(264, series3, category3);
		dataset.addValue(185, series3, category4);
		dataset.addValue(209, series3, category5);
		dataset.addValue(302, series3, category6);

		return dataset;
	}

	/**
	 * 產生JFreeChart
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		CategoryDataset dataset = getCategoryDataset();
		//產生線形圖著色
		LineAndShapeRenderer renderer1 = new LineAndShapeRenderer();
		//產生柱形圖著色
		BarRenderer renderer2 = new BarRenderer();
		//設定X軸
		CategoryAxis domainAxis = new CategoryAxis("月份");
		//設定Y軸
		NumberAxis rangeAxis = new NumberAxis("銷售量（單位：本）");
		//設定圖表
		CategoryPlot plot1 = new CategoryPlot(dataset, domainAxis, rangeAxis,
				renderer1);
		CategoryPlot plot2 = new CategoryPlot(dataset, domainAxis, rangeAxis,
				renderer2);
		//設定聯合分類別圖表
       final CombinedDomainCategoryPlot plot = new CombinedDomainCategoryPlot(domainAxis);
       //設定聯合圖表
       	plot.add(plot2, 1);
        plot.add(plot1, 1);
        JFreeChart chart = new JFreeChart("2010年上半年銷售量", plot);
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
		CategoryPlot categoryPlot = chart.getCategoryPlot();

		CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
		// X軸字體
		categoryAxis.setTickLabelFont(new Font("細明體", Font.PLAIN, 14));
		// X軸標籤字體
		categoryAxis.setLabelFont(new Font("細明體", Font.PLAIN, 14));
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
		CombinedCategoryDemo3 barDemo = new CombinedCategoryDemo3("聯合分類別圖");
		barDemo.createPlot();
		barDemo.pack();
		// 把窗體顯示到顯示器中央
		RefineryUtilities.centerFrameOnScreen(barDemo);
		// 設定可以顯示
		barDemo.setVisible(true);
	}
}