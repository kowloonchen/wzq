package com.newer.cjl.wzq;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

/**
 * 放棋子的监听器类，实现鼠标监听器接口
 * 
 * @author kowloon
 * 
 */
public class WZQListener implements MouseListener {

	private Graphics g;
	private int num = 1;// 放棋子的计数器，每放一颗棋子就+1
	// 定义一个二维数组来保存棋盘上交叉点的状态[-1黑子 0无子 1白子 ]
	public static int[][] chesses = new int[15][15];

	public WZQListener(Graphics gr) {
		g = gr;
	}

	// 鼠标按键松开的时候会自动执行
	public void mouseReleased(MouseEvent e) {
		// 1. 获得光标的位置
		int x = e.getX();
		int y = e.getY();

		// 2.计算离光标位置最近的交叉点坐标
		int col = (x - 20) / 30;
		int row = (y - 20) / 30;

		// 计算不能整除的部分，如果超过单元格大小的1/2.就需要往后移动一格
		int a = (x - 20) % 30;
		col = a < 30 / 2 ? col : col + 1;

		int b = (y - 20) % 30;
		row = b < 30 / 2 ? row : row + 1;

		// 判断行和列的值要在棋盘范围内
		if (row >= 0 && row < 15 && col >= 0 && col < 15) {
			// 判断该位置是否有棋子,只有空位才能放棋子
			if (chesses[row][col] == 0) {
				// 根据第几行和第几列计算这个交叉点的坐标
				int x0 = col * 30 + 20;
				int y0 = row * 30 + 20;
				System.out.println(row + " " + col);
				// 放棋子之前，先判断是黑方还是白方
				if (num % 2 != 0) {// 如果是奇数次，就放黑棋
					g.setColor(Color.BLACK);
					// 在二维数组中标记棋子
					chesses[row][col] = -1;
				} else {
					g.setColor(Color.WHITE);
					chesses[row][col] = 1;
				}
				// 3.以交叉点的坐标为圆心 放棋子
				g.fillOval(x0 - 13, y0 - 13, 26, 26);
				num++;// 放完棋子，计数器++

				// 放完棋子，如果棋盘上的棋子个数超过9颗，就判断输赢
				if (num >= 9) {
					boolean bool = checkShuipin(row, col);
					if (bool) {
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

	// ******************判断输赢的算法***********************//
	// 检查水平方向是否有五颗连续的棋子，如果有就返回true，否则false
	// 参数r和c表示当前放棋子的下标位置行和列
	public boolean checkShuipin(int r, int c) {
		int count = 0;// 相连的棋子个数
		// 水平向右
		for (int i = c + 1; i < c + 5 && i < 15; i++) {
			if (chesses[r][i] == chesses[r][c]) {
				count++;
			} else {
				break;
			}
		}
		// 向左
		for (int i = c - 1; i >= c - 5 && i >= 0; i--) {
			if (chesses[r][i] == chesses[r][c]) {
				count++;
			} else {
				break;
			}
		}
		// 总个数
		if (count >= 4) {
			return true;
		} else {
			return false;
		}

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
