package com.newer.cjl.wzq;

/**
 * ������Ļ�������
 * 
 * @author kowloon
 * 
 */
public class Robot implements Config {
	// ��������˷����ӵ�λ��
	public int r;
	public int c;
	// Ȩֵ���飬���ڻ����˴��Ȩֵ��Ĭ�ϵ�Ȩֵ��0�������ӵ�λ��ȨֵΪ-1
	// ����һ���ӣ�Ȩֵ������Ҫ���³�ʼ��
	public int[][] quanzhi = new int[ROWS][COLS];

	public void jiSuan() {
		// ����˼�����̣�������
		// 1.���ҳ����еĿ�λ
		for (int i = 0; i < chesses.length; i++) {
			for (int j = 0; j < chesses[i].length; j++) {
				// 2.�ҵ�һ����λ���ͼ��������λ��Ȩֵ
				if (chesses[i][j] == 0) {
					int value = shuipinQuanzhi(r, c);
					value += chuizhiQuanzhi(r, c);
					value += quanzhi135(r, c);
					value += quanzhi45(r, c);
					// ��Ȩֵ��ŵ�Ȩֵ�����Ӧ���±�λ��
					quanzhi[i][j] = value;
				} else {// �����λ�������ӣ�ȨֵΪ-1
					quanzhi[i][j] = -1;
				}

			}
		}

		// 3.�ҳ�Ȩֵ�����е����Ȩֵ ���±�
		int max = -1;
		for (int i = 0; i < quanzhi.length; i++) {
			for (int j = 0; j < quanzhi[i].length; j++) {
				if (quanzhi[i][j] > max) {
					max = quanzhi[i][j];
					r = i;
					c = j;
				}
			}
		}

//		// ����Ȩֵ�����ֵ
//		for (int i = 0; i < quanzhi.length; i++) {
//			for (int j = 0; j < quanzhi[i].length; j++) {
//				System.out.print(quanzhi[i][j] + " \t");
//			}
//			System.out.println();
//		}
		// 4.��ʼ��Ȩֵ����
		quanzhi = new int[ROWS][COLS];
	}

	//����Ȩֵ�ķ���
	private int shuipinQuanzhi(int r, int c) {

		return 0;
	}
	private int chuizhiQuanzhi(int r, int c) {

		return 0;
	}
	private int quanzhi135(int r, int c) {

		return 0;
	}
	private int quanzhi45(int r, int c) {

		return 0;
	}

	// ���ܵ����ͼ����Ӧ��Ȩֵ
	// ���� ?AAAA? 300000
	int huosi = 300000;
	// ����A AAAA? 2500
	int sisiA = 2500;
	// ����B AAA?A 3000
	int sisiB = 3000;
	// ����C AA?AA 2600
	int sisiC = 2600;
	// ���� ??AAA?? 3000
	int huosan = 3000;
	// ����A AAA?? 500
	int sisanA = 500;
	// ����B ?A?AA? 800
	int sisanB = 800;
	// ����C A??AA 600
	int sisanC = 600;
	// ����D A?A?A 550
	int sisanD = 550;
	// ��� ???AA??? 650
	int huoer = 650;
	// ����A AA??? 150
	int sierA = 150;
	// ����B ??A?A?? 250
	int sierB = 250;
	// ����C ?A??A? 200
	int sierC = 200;

}
