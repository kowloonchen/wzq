package com.newer.cjl.wzq;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * �����ӵļ������࣬ʵ�����������ӿ�
 * 
 * @author kowloon
 * 
 */
public class WZQListener implements MouseListener {

	private Graphics g;

	public WZQListener(Graphics gr) {
		g = gr;
	}

	// ��갴���ɿ���ʱ����Զ�ִ��
	public void mouseReleased(MouseEvent e) {
		//1. ��ù���λ��
		int x = e.getX();
		int y = e.getY();

		//2.��������λ������Ľ��������
		
		//3.�Խ���������ΪԲ�� ������
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
