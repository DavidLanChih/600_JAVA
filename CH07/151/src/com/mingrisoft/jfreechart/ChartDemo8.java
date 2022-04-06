/**
 * @jdk版本:1.6
 * @寫程式時間:2010-7-20
 */
package com.mingrisoft.jfreechart;

import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.Align;

public class ChartDemo8 {

	/**
	 * 產生JFreeChart
	 * 
	 * @return
	 */
	public JFreeChart getJFreeChart() {
		PieDataset dataset = getPieDataset();
		// locale.getISO3Language()
		JFreeChart chart = ChartFactory.createPieChart("2010.8月份銷售排行", dataset,
				true, true, false);

		return chart;
	}

	/**
	 * 設定餅圖使用的字體
	 * 
	 * @param chart
	 */
	public void setPiePoltFont(JFreeChart chart) {

		// 圖表(餅圖)
		PiePlot piePlot = (PiePlot) chart.getPlot();
		piePlot.setLabelFont(new Font("細明體", Font.PLAIN, 14));
		piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{1}"));

		// 標題
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("細明體", Font.BOLD, 20));

		// 圖例
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("細明體", Font.PLAIN, 12));

	}

	/**
	 * 設定餅圖背景圖
	 * 
	 * @param chart
	 */
	public void setBackgroundImage(JFreeChart chart) {

		Image image = null;
		try {
			image = ImageIO.read(new File("backgroundImage.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PiePlot piePlot = (PiePlot) chart.getPlot();
		piePlot.setBackgroundImage(image);
		//設定背景對齊
		piePlot.setBackgroundImageAlignment(Align.CENTER);
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
		return dataset;
	}

	public static void main(String[] args) {
		ChartDemo8 demo = new ChartDemo8();
		JFreeChart chart = demo.getJFreeChart();
		demo.setPiePoltFont(chart);
		demo.setBackgroundImage(chart);
		ChartFrame chartFrame = new ChartFrame("JFreeChart的例子", chart);
		chartFrame.pack();
		chartFrame.setVisible(true);

	}
}
