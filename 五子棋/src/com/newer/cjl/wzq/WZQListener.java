package com.newer.cjl.wzq;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 放棋子的监听器类，实现鼠标监听器接口
 * 
 * @author kowloon
 * 
 */
public class WZQListener implements MouseListener {

	private Graphics g;

	public WZQListener(Graphics gr) {
		g = gr;
	}

	// 鼠标按键松开的时候会自动执行
	public void mouseReleased(MouseEvent e) {
		//1. 获得光标的位置
		int x = e.getX();
		int y = e.getY();

		//2.计算离光标位置最近的交叉点坐标
		
		//3.以交叉点的坐标为圆心 放棋子
		g.fillOval(x-13, y-13, 26, 26);

	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

}
