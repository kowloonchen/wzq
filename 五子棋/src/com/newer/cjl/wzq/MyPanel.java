package com.newer.cjl.wzq;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * �Զ���һ�������
 * 
 * @author kowloon
 * 
 */
public class MyPanel extends JPanel {

	/**
	 * ��дJPanel�ķ��� 
	 * paint�����������ǽ��ؼ������������Ļ�� 
	 * ������С�����ı���Ҫ���»�������Ļ�ϵ�ʱ����Զ�����
	 */
	public void paint(Graphics g) {
		// super��ʾ������󣬵��ø����paint��������ȷ�Ļ��ƿؼ�����
		super.paint(g);
		//��������
		drawQipan(g);
		//��������
		drawChess(g,WZQListener.chesses);
	}

	/**
	 * �������̵ķ���
	 * @param g
	 */
	private void drawQipan(Graphics g) {
		Color c = new Color(196,154,57);
		g.setColor(c);
		//�������
		for(int i=0;i<50;i++){
			//�����
			int x1 = (int)(Math.random()*460);
			int y1 = (int)(Math.random()*460);
			int x2 = (int)(Math.random()*460);
			int y2 = (int)(Math.random()*460);
			g.drawOval(x1, y1, x2, y2);
		}
		
		g.setColor(Color.BLACK);
		// ����ˮƽֱ��
		for (int i = 0; i < 15; i++) {
			g.drawLine(20, 20 + 30 * i, 440, 20 + 30 * i);
		}
		//���ƴ�ֱ��
		for (int j = 0; j < 15; j++) {
			g.drawLine(20 + 30 * j, 20, 20 + 30 * j, 440);
		}

		//���Ʊ�ǵ�
		g.fillOval(20 + 30 * 7 - 3, 20 + 30 * 7 - 3, 6, 6);
		g.fillOval(20 + 30 * 3 - 3, 20 + 30 * 3 - 3, 6, 6);
		g.fillOval(20 + 30 * 11 - 3, 20 + 30 * 3 - 3, 6, 6);
		g.fillOval(20 + 30 * 3 - 3, 20 + 30 * 11 - 3, 6, 6);
		g.fillOval(20 + 30 * 11 - 3, 20 + 30 * 11 - 3, 6, 6);
	}
	
	//����ά�����е����ӻ�����������
	private void drawChess(Graphics g,int[][] chesses){
		for(int i=0;i<chesses.length;i++){
			for(int j=0;j<chesses[i].length;j++){
				int num = chesses[i][j];
				if(num!=0){//��������ӣ��ͻ���
					//���ݶ�ά������±���㽻��������
					int x = 20+30*j;
					int y = 20+30*i;
					if(num==-1){
						g.setColor(Color.BLACK);
					}else{
						g.setColor(Color.WHITE);
					}
					g.fillOval(x-15, y-15, 30, 30);
				}
			}
		}
		
		
	}

}







