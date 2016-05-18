package com.newer.cjl.wzq;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * ���������������
 * @author kowloon
 *
 */
public class WZQFrame {
	
	/**
	 * ��ʼ��һ�������ڵķ���
	 */
	public void initFrame(){
		JFrame jf = new JFrame();
		jf.setTitle("�����������������");
		jf.setSize(516, 530);
		//���õ���رհ�ť��ʱ���˳�����
		jf.setDefaultCloseOperation(3);
		//��ֹ�ı䴰�ڴ�С
		jf.setResizable(false);
		
		//ָ�����ֹ���Ϊ���Զ�λ[�����ֹ���Ϊnull��ʱ����Ϊ���Զ�λ]
		jf.setLayout(null);
		
		//����������
		MyPanel panel = new MyPanel();
		//�������ı�����ɫ
		Color c = new Color(172,135,50);
		panel.setBackground(c);
		//����þ��Զ�λ���ؼ�����Ҫִ��λ�úʹ�С
		panel.setBounds(20,20, 460, 460);
		
		jf.add(panel);
		
		jf.setVisible(true);
		
		//����������Ļ��ռ�ݵ��������������������Ƶ�
		Graphics g = panel.getGraphics();
		
		//����������������
		WZQListener wlis = new WZQListener(g);
		//����������������
		panel.addMouseListener(wlis);
	}
	

}
