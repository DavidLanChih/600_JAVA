/**
 * @jdk����:1.6
 * @�g�{���ɶ�:2010-7-20
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

public class BarDemo19 extends ApplicationFrame {

	public BarDemo19(String title) {
		super(title);
	}

	/**
	 * �إߤ@�Ӹ�ƶ�
	 * 
	 * @return
	 */
	private CategoryDataset getCategoryDataset() {

		DefaultKeyedValues keyedValues = new DefaultKeyedValues();
		keyedValues.addValue("1", 310);
		keyedValues.addValue("2", 489);
		keyedValues.addValue("3", 512);
		keyedValues.addValue("4", 589);
		keyedValues.addValue("5", 359);
		keyedValues.addValue("6", 402);
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				"java book", keyedValues);
		return dataset;
	}

	/**
	 * ����JFreeChart
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		CategoryDataset dataset = getCategoryDataset();
		JFreeChart chart = ChartFactory.createBarChart("2010.1-6 sales volume", // �Ϫ����D
				"month", // x�b����
				"sales", // y�b����
				dataset, // ��ƶ�
				PlotOrientation.HORIZONTAL, // �Ϫ���V�G�����B����
				false, // �O�_��ܹϨ�(���²�檺�W���ϥ����Ofalse)
				false, // �O�_���ͤu��
				false // �O�_����URL�챵
				);

		return chart;
	}

	/**
	 * �]�w�Ϫ�
	 * 
	 * @param chart
	 */
	public void createPlot() {
		JFreeChart chart = getJFreeChart();
		// ��JFreeChart���O�x�s�b�����
		setContentPane(new ChartPanel(chart));

	}

	public static void main(String[] args) {
		BarDemo19 barDemo = new BarDemo19("�W�ιϹ��");
		barDemo.createPlot();
		barDemo.pack();
		// �ⵡ����ܨ���ܾ�����
		RefineryUtilities.centerFrameOnScreen(barDemo);
		//�]�w�i�H���
		barDemo.setVisible(true);

	}
}
