package com.newer.cjl.wzq;

import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;

/**
 * 定义一个接口，用来声明常量
 * 
 * @author kowloon
 * 
 */
public interface Config {

	// 窗口大小
	int WINDOW_WIDTH = 516;
	int WINDOW_HEIGHT = 530;

	// 游戏面板大小
	int PANEL_WIDTH = 460;
	int PANEL_HEIGHT = 460;

	// 面板在窗口中起始点的坐标
	int PANEL_X = 20;
	int PANEL_Y = 20;

	Color PANEL_BG = new Color(172, 135, 50);

	// 棋盘左上角起始点的坐标
	int X0 = 20;
	int Y0 = 20;

	// 棋盘单元格大小
	int SIZE = 30;

	// 棋子大小
	int CHESS_SIZE = 26;

	// 棋盘水平和垂直的线的条数
	int ROWS = 15;
	int COLS = 15;
	// 定义一个二维数组来保存棋盘上交叉点的状态[-1黑子 0无子 1白子 ]
	public static int[][] chesses = new int[ROWS][COLS];

	URL BLACK_URL = Config.class.getResource("images/b.png");
	URL WHITE_URL = Config.class.getResource("images/w.png");

	ImageIcon BLACK = new ImageIcon(BLACK_URL);
	ImageIcon WHITE = new ImageIcon(WHITE_URL);
}
