package com.newer.cjl.wzq;

import java.awt.Color;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * �Զ���һ������� Ӳ����
 * 
 * @author kowloon
 * 
 */
public class MyPanel extends JPanel implements Config {

	// ���ͼƬ��URL·��
	URL url = MyPanel.class.getResource("images/chessboard.jpg");
	// ��ͼƬ��װ�ɶ���
	ImageIcon bg = new ImageIcon(url);

	/**
	 * ��дJPanel�ķ��� paint�����������ǽ��ؼ������������Ļ�� ������С�����ı���Ҫ���»�������Ļ�ϵ�ʱ����Զ�����
	 */
	public void paint(Graphics g) {
		// super��ʾ������󣬵��ø����paint��������ȷ�Ļ��ƿؼ�����
		super.paint(g);
		g.drawImage(bg.getImage(), 0, 0, PANEL_WIDTH, PANEL_HEIGHT, null);
		// ��������
		// drawQipan(g);
		// ��������
		drawChess(g, chesses);
	}

	/**
	 * �������̵ķ���
	 * 
	 * @param g
	 */
	private void drawQipan(Graphics g) {
		g.setColor(Color.BLACK);
		// ����ˮƽֱ��
		for (int i = 0; i < ROWS; i++) {
			g.drawLine(X0, Y0 + SIZE * i, X0 + SIZE * (COLS - 1), Y0 + SIZE * i);
		}
		// ���ƴ�ֱ��
		for (int j = 0; j < COLS; j++) {
			g.drawLine(X0 + SIZE * j, Y0, X0 + SIZE * j, Y0 + SIZE * (ROWS - 1));
		}

		if (ROWS == 15 && COLS == 15) {
			// ���Ʊ�ǵ�
			g.fillOval(X0 + SIZE * (COLS / 2) - 3, Y0 + SIZE * (ROWS / 2) - 3,
					6, 6);
			g.fillOval(X0 + SIZE * 3 - 3, Y0 + SIZE * 3 - 3, 6, 6);
			g.fillOval(X0 + SIZE * 11 - 3, Y0 + SIZE * 3 - 3, 6, 6);
			g.fillOval(X0 + SIZE * 3 - 3, Y0 + SIZE * 11 - 3, 6, 6);
			g.fillOval(X0 + SIZE * 11 - 3, Y0 + SIZE * 11 - 3, 6, 6);
		}
	}

	// ����ά�����е����ӻ�����������
	private void drawChess(Graphics g, int[][] chesses) {
		ImageIcon icon = null;
		for (int i = 0; i < chesses.length; i++) {
			for (int j = 0; j < chesses[i].length; j++) {
				int num = chesses[i][j];
				if (num != 0) {// ��������ӣ��ͻ���
					// ���ݶ�ά������±���㽻��������
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
