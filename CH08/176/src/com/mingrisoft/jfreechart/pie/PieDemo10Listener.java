/**
 * @jdk版本:1.6
 * @寫程式時間:2010-7-20
 */
package com.mingrisoft.jfreechart.pie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jfree.chart.plot.PiePlot;

public class PieDemo10Listener implements ActionListener {

	private PiePlot plot;

	//餅圖的角度
	private int angle = 90;
	
	public PieDemo10Listener(PiePlot plot) {
		this.plot =plot;
	}
	
	/*
	 * 設定餅圖的角度，向右旋轉則減1，如果餅圖的角度減到0時，把角度重新設定為是360
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed( ActionEvent event) {
		this.plot.setStartAngle(this.angle);
		this.angle = this.angle - 1;
		if (this.angle == 0) {
			this.angle = 360;
		}
	}

}
