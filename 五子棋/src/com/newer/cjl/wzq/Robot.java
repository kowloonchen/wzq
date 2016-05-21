package com.newer.cjl.wzq;

/**
 * 五子棋的机器人类
 * 
 * @author kowloon
 * 
 */
public class Robot implements Config {
	// 保存机器人放棋子的位置
	public int r;
	public int c;
	// 权值数组，用于机器人存放权值，默认的权值是0，有棋子的位置权值为-1
	// 放完一颗子，权值数组需要重新初始化
	public int[][] quanzhi = new int[ROWS][COLS];

	public void jiSuan() {
		// 计算思考过程？？？？
		// 1.先找出所有的空位
		for (int i = 0; i < chesses.length; i++) {
			for (int j = 0; j < chesses[i].length; j++) {
				// 2.找到一个空位，就计算这个空位的权值
				if (chesses[i][j] == 0) {
					int value = shuipinQuanzhi(r, c);
					value += chuizhiQuanzhi(r, c);
					value += quanzhi135(r, c);
					value += quanzhi45(r, c);
					// 将权值存放到权值数组对应的下标位置
					quanzhi[i][j] = value;
				} else {// 如果该位置有棋子，权值为-1
					quanzhi[i][j] = -1;
				}

			}
		}

		// 3.找出权值数组中的最大权值 的下标
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

//		// 测试权值数组的值
//		for (int i = 0; i < quanzhi.length; i++) {
//			for (int j = 0; j < quanzhi[i].length; j++) {
//				System.out.print(quanzhi[i][j] + " \t");
//			}
//			System.out.println();
//		}
		// 4.初始化权值数组
		quanzhi = new int[ROWS][COLS];
	}

	//计算权值的方法
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

	// 可能的棋型及其对应的权值
	// 活四 ?AAAA? 300000
	int huosi = 300000;
	// 死四A AAAA? 2500
	int sisiA = 2500;
	// 死四B AAA?A 3000
	int sisiB = 3000;
	// 死四C AA?AA 2600
	int sisiC = 2600;
	// 活三 ??AAA?? 3000
	int huosan = 3000;
	// 死三A AAA?? 500
	int sisanA = 500;
	// 死三B ?A?AA? 800
	int sisanB = 800;
	// 死三C A??AA 600
	int sisanC = 600;
	// 死三D A?A?A 550
	int sisanD = 550;
	// 活二 ???AA??? 650
	int huoer = 650;
	// 死二A AA??? 150
	int sierA = 150;
	// 死二B ??A?A?? 250
	int sierB = 250;
	// 死二C ?A??A? 200
	int sierC = 200;

}
