package com.newer.cjl.wzq;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 自定义一个面板类
 * 
 * @author kowloon
 * 
 */
public class MyPanel extends JPanel {

	/**
	 * 重写JPanel的方法 paint方法的作用是将控件本身绘制在屏幕上 当面板大小发生改变需要重新绘制在屏幕上的时候会自动调用
	 */
	public void paint(Graphics g) {
		// super表示父类对象，调用父类的paint方法来正确的绘制控件本身
		super.paint(g);
		drawQipan(g);
	}

	/**
	 * 绘制棋盘的方法
	 * @param g
	 */
	private void drawQipan(Graphics g) {
		Color c = new Color(196,154,57);
		g.setColor(c);
		//添加杂质
		for(int i=0;i<50;i++){
			//随机数
			int x1 = (int)(Math.random()*460);
			int y1 = (int)(Math.random()*460);
			int x2 = (int)(Math.random()*460);
			int y2 = (int)(Math.random()*460);
			g.drawOval(x1, y1, x2, y2);
		}
		
		g.setColor(Color.BLACK);
		// 绘制水平直线
		for (int i = 0; i < 15; i++) {
			g.drawLine(20, 20 + 30 * i, 440, 20 + 30 * i);
		}
		//绘制垂直线
		for (int j = 0; j < 15; j++) {
			g.drawLine(20 + 30 * j, 20, 20 + 30 * j, 440);
		}

		//绘制标记点
		g.fillOval(20 + 30 * 7 - 3, 20 + 30 * 7 - 3, 6, 6);
		g.fillOval(20 + 30 * 3 - 3, 20 + 30 * 3 - 3, 6, 6);
		g.fillOval(20 + 30 * 11 - 3, 20 + 30 * 3 - 3, 6, 6);
		g.fillOval(20 + 30 * 3 - 3, 20 + 30 * 11 - 3, 6, 6);
		g.fillOval(20 + 30 * 11 - 3, 20 + 30 * 11 - 3, 6, 6);
	}

}
