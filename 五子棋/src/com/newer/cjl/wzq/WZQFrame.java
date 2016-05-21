package com.newer.cjl.wzq;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * 五子棋的主窗口类
 * 
 * @author kowloon
 * 
 */
public class WZQFrame implements Config {

	/**
	 * 初始化一个主窗口的方法
	 */
	public void initFrame() {
		JFrame jf = new JFrame();
		jf.setTitle("世上最聪明的五子棋");
		jf.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		// 设置点击关闭按钮的时候退出程序
		jf.setDefaultCloseOperation(3);
		// 禁止改变窗口大小
		jf.setResizable(false);

		// 指定布局规则为绝对定位[当布局规则为null的时候，则为绝对定位]
		jf.setLayout(null);

		// 创建面板对象
		MyPanel panel = new MyPanel();
		// 设置面板的背景颜色
		panel.setBackground(PANEL_BG);
		// 如果用绝对定位，控件必须要执行位置和大小
		panel.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);

		jf.add(panel);

		jf.setVisible(true);

		// 获得面板在屏幕上占据的区域，这块区域是允许绘制的
		Graphics g = panel.getGraphics();

		// 创建鼠标监听器对象
		WZQListener wlis = new WZQListener(g);
		// 给面板添加鼠标监听器
		panel.addMouseListener(wlis);
	}

}
