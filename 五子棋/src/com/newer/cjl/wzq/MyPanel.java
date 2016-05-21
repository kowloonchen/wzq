package com.newer.cjl.wzq;

import java.awt.Color;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 自定义一个面板类 硬编码
 * 
 * @author kowloon
 * 
 */
public class MyPanel extends JPanel implements Config {

	// 获得图片的URL路径
	URL url = MyPanel.class.getResource("images/chessboard.jpg");
	// 将图片封装成对象
	ImageIcon bg = new ImageIcon(url);

	/**
	 * 重写JPanel的方法 paint方法的作用是将控件本身绘制在屏幕上 当面板大小发生改变需要重新绘制在屏幕上的时候会自动调用
	 */
	public void paint(Graphics g) {
		// super表示父类对象，调用父类的paint方法来正确的绘制控件本身
		super.paint(g);
		g.drawImage(bg.getImage(), 0, 0, PANEL_WIDTH, PANEL_HEIGHT, null);
		// 绘制棋盘
		// drawQipan(g);
		// 绘制棋子
		drawChess(g, chesses);
	}

	/**
	 * 绘制棋盘的方法
	 * 
	 * @param g
	 */
	private void drawQipan(Graphics g) {
		g.setColor(Color.BLACK);
		// 绘制水平直线
		for (int i = 0; i < ROWS; i++) {
			g.drawLine(X0, Y0 + SIZE * i, X0 + SIZE * (COLS - 1), Y0 + SIZE * i);
		}
		// 绘制垂直线
		for (int j = 0; j < COLS; j++) {
			g.drawLine(X0 + SIZE * j, Y0, X0 + SIZE * j, Y0 + SIZE * (ROWS - 1));
		}

		if (ROWS == 15 && COLS == 15) {
			// 绘制标记点
			g.fillOval(X0 + SIZE * (COLS / 2) - 3, Y0 + SIZE * (ROWS / 2) - 3,
					6, 6);
			g.fillOval(X0 + SIZE * 3 - 3, Y0 + SIZE * 3 - 3, 6, 6);
			g.fillOval(X0 + SIZE * 11 - 3, Y0 + SIZE * 3 - 3, 6, 6);
			g.fillOval(X0 + SIZE * 3 - 3, Y0 + SIZE * 11 - 3, 6, 6);
			g.fillOval(X0 + SIZE * 11 - 3, Y0 + SIZE * 11 - 3, 6, 6);
		}
	}

	// 将二维数组中的棋子绘制在棋盘上
	private void drawChess(Graphics g, int[][] chesses) {
		ImageIcon icon = null;
		for (int i = 0; i < chesses.length; i++) {
			for (int j = 0; j < chesses[i].length; j++) {
				int num = chesses[i][j];
				if (num != 0) {// 如果有棋子，就绘制
					// 根据二维数组的下标计算交叉点的坐标
					int x = X0 + SIZE * j;
					int y = Y0 + SIZE * i;
					if (num == -1) {
						icon = BLACK;
					} else {
						icon = WHITE;
					}
					g.drawImage(icon.getImage(), x - CHESS_SIZE / 2, y
							- CHESS_SIZE / 2, CHESS_SIZE, CHESS_SIZE, null);

				}
			}
		}

	}

}
