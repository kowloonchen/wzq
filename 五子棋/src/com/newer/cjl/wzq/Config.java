package com.newer.cjl.wzq;

import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;

/**
 * ����һ���ӿڣ�������������
 * 
 * @author kowloon
 * 
 */
public interface Config {

	// ���ڴ�С
	int WINDOW_WIDTH = 516;
	int WINDOW_HEIGHT = 530;

	// ��Ϸ����С
	int PANEL_WIDTH = 460;
	int PANEL_HEIGHT = 460;

	// ����ڴ�������ʼ�������
	int PANEL_X = 20;
	int PANEL_Y = 20;

	Color PANEL_BG = new Color(172, 135, 50);

	// �������Ͻ���ʼ�������
	int X0 = 20;
	int Y0 = 20;

	// ���̵�Ԫ���С
	int SIZE = 30;

	// ���Ӵ�С
	int CHESS_SIZE = 26;

	// ����ˮƽ�ʹ�ֱ���ߵ�����
	int ROWS = 15;
	int COLS = 15;
	// ����һ����ά���������������Ͻ�����״̬[-1���� 0���� 1���� ]
	public static int[][] chesses = new int[ROWS][COLS];

	URL BLACK_URL = Config.class.getResource("images/b.png");
	URL WHITE_URL = Config.class.getResource("images/w.png");

	ImageIcon BLACK = new ImageIcon(BLACK_URL);
	ImageIcon WHITE = new ImageIcon(WHITE_URL);
}
