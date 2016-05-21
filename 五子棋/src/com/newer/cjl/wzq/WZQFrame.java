package com.newer.cjl.wzq;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * ���������������
 * 
 * @author kowloon
 * 
 */
public class WZQFrame implements Config {

	/**
	 * ��ʼ��һ�������ڵķ���
	 */
	public void initFrame() {
		JFrame jf = new JFrame();
		jf.setTitle("�����������������");
		jf.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		// ���õ���رհ�ť��ʱ���˳�����
		jf.setDefaultCloseOperation(3);
		// ��ֹ�ı䴰�ڴ�С
		jf.setResizable(false);

		// ָ�����ֹ���Ϊ���Զ�λ[�����ֹ���Ϊnull��ʱ����Ϊ���Զ�λ]
		jf.setLayout(null);

		// ����������
		MyPanel panel = new MyPanel();
		// �������ı�����ɫ
		panel.setBackground(PANEL_BG);
		// ����þ��Զ�λ���ؼ�����Ҫִ��λ�úʹ�С
		panel.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);

		jf.add(panel);

		jf.setVisible(true);

		// ����������Ļ��ռ�ݵ��������������������Ƶ�
		Graphics g = panel.getGraphics();

		// ����������������
		WZQListener wlis = new WZQListener(g);
		// ����������������
		panel.addMouseListener(wlis);
	}

}
