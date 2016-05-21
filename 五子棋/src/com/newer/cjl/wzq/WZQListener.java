package com.newer.cjl.wzq;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * �����ӵļ������࣬ʵ�����������ӿ�
 * 
 * @author kowloon
 * 
 */
public class WZQListener implements MouseListener, Config {

	private Graphics g;
	private int num = 1;// �����ӵļ�������ÿ��һ�����Ӿ�+1
	private ImageIcon icon = null;
	
	//���������˶���
	Robot robot = new Robot();

	public WZQListener(Graphics gr) {
		g = gr;
	}

	// ��갴���ɿ���ʱ����Զ�ִ��
	public void mouseReleased(MouseEvent e) {
		// 1. ��ù���λ��
		int x = e.getX();
		int y = e.getY();

		// 2.��������λ������Ľ��������
		int col = (x - X0) / SIZE;
		int row = (y - Y0) / SIZE;

		// ���㲻�������Ĳ��֣����������Ԫ���С��1/2.����Ҫ�����ƶ�һ��
		int a = (x - X0) % SIZE;
		col = a < SIZE / 2 ? col : col + 1;

		int b = (y - Y0) % SIZE;
		row = b < SIZE / 2 ? row : row + 1;
		
		//�˷�����
		putChess(row,col,-1);

		//�����˼���
		robot.jiSuan();
		//����������
		putChess(robot.r,robot.c,1);
	}

	/**
	 * �����ӵķ���
	 * 
	 * @param row
	 *            ��col �����ӵ��±�λ��
	 * @param ch
	 *            ���ӵ���ɫ -1���� 1����
	 */
	public void putChess(int row, int col, int ch) {
		// �ж��к��е�ֵҪ�����̷�Χ��
		if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
			// �жϸ�λ���Ƿ�������,ֻ�п�λ���ܷ�����
			if (chesses[row][col] == 0) {
				// ���ݵڼ��к͵ڼ��м����������������
				int x0 = col * SIZE + X0;
				int y0 = row * SIZE + Y0;

				if (ch == -1) {
					icon = BLACK;
				} else {
					icon = WHITE;
				}
				chesses[row][col] = ch;

				// 3.�Խ���������ΪԲ�� ������
				g.drawImage(icon.getImage(), x0 - CHESS_SIZE / 2, y0
						- CHESS_SIZE / 2, CHESS_SIZE, CHESS_SIZE, null);
				// g.fillOval(x0 - CHESS_SIZE / 2, y0 - CHESS_SIZE / 2,
				// CHESS_SIZE, CHESS_SIZE);
				num++;// �������ӣ�������++

				// �������ӣ���������ϵ����Ӹ�������9�ţ����ж���Ӯ
				if (num >= 9) {
					if (checkShuipin(row, col) || checkChuizhi(row, col)
							|| check135(row, col)) {
						if (chesses[row][col] == -1) {
							JOptionPane.showMessageDialog(null, "����Ӯ��");
						} else {
							JOptionPane.showMessageDialog(null, "����Ӯ��");
						}
					}
				}

			}

		}
	}

	/**
	 * �ж�135�ȷ����Ƿ���5������������
	 */
	public boolean check135(int r, int c) {
		int count = 0;
		// б��
		for (int i = r - 1, j = c - 1; i > r - 5 && i >= 0 && j > c - 5
				&& j >= 0; i--, j--) {
			if (chesses[r][c] == chesses[i][j]) {
				count++;
			} else {
				break;
			}
		}
		// б��
		for (int i = r + 1, j = c + 1; i < r + 5 && i < ROWS && j < c + 5
				&& j < COLS; i++, j++) {
			if (chesses[r][c] == chesses[i][j]) {
				count++;
			} else {
				break;
			}
		}
		// �ܸ���
		if (count >= 4) {
			return true;
		}
		return false;

	}

	// ******************�ж���Ӯ���㷨***********************//
	// ���ˮƽ�����Ƿ���������������ӣ�����оͷ���true������false
	// ����r��c��ʾ��ǰ�����ӵ��±�λ���к���
	public boolean checkShuipin(int r, int c) {
		int count = 0;// ���������Ӹ���
		// ˮƽ����
		for (int i = c + 1; i < c + 5 && i < COLS; i++) {
			if (chesses[r][i] == chesses[r][c]) {
				count++;
			} else {
				break;
			}
		}
		// ����
		for (int i = c - 1; i > c - 5 && i >= 0; i--) {
			if (chesses[r][i] == chesses[r][c]) {
				count++;
			} else {
				break;
			}
		}
		// �ܸ���
		if (count >= 4) {
			return true;
		}
		return false;

	}

	/**
	 * ��ⴹֱ�����Ƿ������������
	 */
	public boolean checkChuizhi(int r, int c) {
		int count = 0;// ���������Ӹ���
		// ������
		for (int i = r - 1; i > r - 5 && i >= 0; i--) {
			if (chesses[r][c] == chesses[i][c]) {
				count++;
			} else {
				break;
			}
		}
		// ������
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
