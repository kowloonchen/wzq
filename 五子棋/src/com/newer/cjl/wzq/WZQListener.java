package com.newer.cjl.wzq;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

/**
 * �����ӵļ������࣬ʵ�����������ӿ�
 * 
 * @author kowloon
 * 
 */
public class WZQListener implements MouseListener {

	private Graphics g;
	private int num = 1;// �����ӵļ�������ÿ��һ�����Ӿ�+1
	// ����һ����ά���������������Ͻ�����״̬[-1���� 0���� 1���� ]
	public static int[][] chesses = new int[15][15];

	public WZQListener(Graphics gr) {
		g = gr;
	}

	// ��갴���ɿ���ʱ����Զ�ִ��
	public void mouseReleased(MouseEvent e) {
		// 1. ��ù���λ��
		int x = e.getX();
		int y = e.getY();

		// 2.��������λ������Ľ��������
		int col = (x - 20) / 30;
		int row = (y - 20) / 30;

		// ���㲻�������Ĳ��֣����������Ԫ���С��1/2.����Ҫ�����ƶ�һ��
		int a = (x - 20) % 30;
		col = a < 30 / 2 ? col : col + 1;

		int b = (y - 20) % 30;
		row = b < 30 / 2 ? row : row + 1;

		// �ж��к��е�ֵҪ�����̷�Χ��
		if (row >= 0 && row < 15 && col >= 0 && col < 15) {
			// �жϸ�λ���Ƿ�������,ֻ�п�λ���ܷ�����
			if (chesses[row][col] == 0) {
				// ���ݵڼ��к͵ڼ��м����������������
				int x0 = col * 30 + 20;
				int y0 = row * 30 + 20;
				System.out.println(row + " " + col);
				// ������֮ǰ�����ж��Ǻڷ����ǰ׷�
				if (num % 2 != 0) {// ����������Σ��ͷź���
					g.setColor(Color.BLACK);
					// �ڶ�ά�����б������
					chesses[row][col] = -1;
				} else {
					g.setColor(Color.WHITE);
					chesses[row][col] = 1;
				}
				// 3.�Խ���������ΪԲ�� ������
				g.fillOval(x0 - 13, y0 - 13, 26, 26);
				num++;// �������ӣ�������++

				// �������ӣ���������ϵ����Ӹ�������9�ţ����ж���Ӯ
				if (num >= 9) {
					boolean bool = checkShuipin(row, col);
					if (bool) {
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

	// ******************�ж���Ӯ���㷨***********************//
	// ���ˮƽ�����Ƿ���������������ӣ�����оͷ���true������false
	// ����r��c��ʾ��ǰ�����ӵ��±�λ���к���
	public boolean checkShuipin(int r, int c) {
		int count = 0;// ���������Ӹ���
		// ˮƽ����
		for (int i = c + 1; i < c + 5 && i < 15; i++) {
			if (chesses[r][i] == chesses[r][c]) {
				count++;
			} else {
				break;
			}
		}
		// ����
		for (int i = c - 1; i >= c - 5 && i >= 0; i--) {
			if (chesses[r][i] == chesses[r][c]) {
				count++;
			} else {
				break;
			}
		}
		// �ܸ���
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
