package com.newer.cjl.wzq;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * 放棋子的监听器类，实现鼠标监听器接口
 * 
 * @author kowloon
 * 
 */
public class WZQListener implements MouseListener, Config {

	private Graphics g;
	private int num = 1;// 放棋子的计数器，每放一颗棋子就+1
	private ImageIcon icon = null;
	
	//创建机器人对象
	Robot robot = new Robot();

	public WZQListener(Graphics gr) {
		g = gr;
	}

	// 鼠标按键松开的时候会自动执行
	public void mouseReleased(MouseEvent e) {
		// 1. 获得光标的位置
		int x = e.getX();
		int y = e.getY();

		// 2.计算离光标位置最近的交叉点坐标
		int col = (x - X0) / SIZE;
		int row = (y - Y0) / SIZE;

		// 计算不能整除的部分，如果超过单元格大小的1/2.就需要往后移动一格
		int a = (x - X0) % SIZE;
		col = a < SIZE / 2 ? col : col + 1;

		int b = (y - Y0) % SIZE;
		row = b < SIZE / 2 ? row : row + 1;
		
		//人放棋子
		putChess(row,col,-1);

		//机器人计算
		robot.jiSuan();
		//机器放棋子
		putChess(robot.r,robot.c,1);
	}

	/**
	 * 放棋子的方法
	 * 
	 * @param row
	 *            ，col 放棋子的下标位置
	 * @param ch
	 *            棋子的颜色 -1黑子 1白子
	 */
	public void putChess(int row, int col, int ch) {
		// 判断行和列的值要在棋盘范围内
		if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
			// 判断该位置是否有棋子,只有空位才能放棋子
			if (chesses[row][col] == 0) {
				// 根据第几行和第几列计算这个交叉点的坐标
				int x0 = col * SIZE + X0;
				int y0 = row * SIZE + Y0;

				if (ch == -1) {
					icon = BLACK;
				} else {
					icon = WHITE;
				}
				chesses[row][col] = ch;

				// 3.以交叉点的坐标为圆心 放棋子
				g.drawImage(icon.getImage(), x0 - CHESS_SIZE / 2, y0
						- CHESS_SIZE / 2, CHESS_SIZE, CHESS_SIZE, null);
				// g.fillOval(x0 - CHESS_SIZE / 2, y0 - CHESS_SIZE / 2,
				// CHESS_SIZE, CHESS_SIZE);
				num++;// 放完棋子，计数器++

				// 放完棋子，如果棋盘上的棋子个数超过9颗，就判断输赢
				if (num >= 9) {
					if (checkShuipin(row, col) || checkChuizhi(row, col)
							|| check135(row, col)) {
						if (chesses[row][col] == -1) {
							JOptionPane.showMessageDialog(null, "黑子赢了");
						} else {
							JOptionPane.showMessageDialog(null, "白子赢了");
						}
					}
				}

			}

		}
	}

	/**
	 * 判断135度方向是否有5颗相连的棋子
	 */
	public boolean check135(int r, int c) {
		int count = 0;
		// 斜上
		for (int i = r - 1, j = c - 1; i > r - 5 && i >= 0 && j > c - 5
				&& j >= 0; i--, j--) {
			if (chesses[r][c] == chesses[i][j]) {
				count++;
			} else {
				break;
			}
		}
		// 斜下
		for (int i = r + 1, j = c + 1; i < r + 5 && i < ROWS && j < c + 5
				&& j < COLS; i++, j++) {
			if (chesses[r][c] == chesses[i][j]) {
				count++;
			} else {
				break;
			}
		}
		// 总个数
		if (count >= 4) {
			return true;
		}
		return false;

	}

	// ******************判断输赢的算法***********************//
	// 检查水平方向是否有五颗连续的棋子，如果有就返回true，否则false
	// 参数r和c表示当前放棋子的下标位置行和列
	public boolean checkShuipin(int r, int c) {
		int count = 0;// 相连的棋子个数
		// 水平向右
		for (int i = c + 1; i < c + 5 && i < COLS; i++) {
			if (chesses[r][i] == chesses[r][c]) {
				count++;
			} else {
				break;
			}
		}
		// 向左
		for (int i = c - 1; i > c - 5 && i >= 0; i--) {
			if (chesses[r][i] == chesses[r][c]) {
				count++;
			} else {
				break;
			}
		}
		// 总个数
		if (count >= 4) {
			return true;
		}
		return false;

	}

	/**
	 * 检测垂直方向是否有五颗子相连
	 */
	public boolean checkChuizhi(int r, int c) {
		int count = 0;// 相连的棋子个数
		// 往上走
		for (int i = r - 1; i > r - 5 && i >= 0; i--) {
			if (chesses[r][c] == chesses[i][c]) {
				count++;
			} else {
				break;
			}
		}
		// 往下走
		for (int i = r + 1; i < r + 5 && i < ROWS; i++) {
			if (chesses[r][c] == chesses[i][c]) {
				count++;
			} else {
				break;
			}
		}
		if (count >= 4) {
			return true;
		}
		return false;

	}

	// *****************************************//
	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

}
