package gongzi.dng.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;

import gongzi.dng.control.Control01;
import gongzi.dng.model.Forms;

public class MainWin extends JFrame {

	public static void main(String[] args) {
		JFrame frame = new DrawFrame();
	}
}

class DrawFrame extends JFrame {
	private JFrame frame;
	private JLabel jlFile;
	private JLabel jlStart;
	private JLabel jlEnd;

	private JTextField jtfFile;
	private JTextField jtfStart;
	private JTextField jtfEnd;

	private JButton jbSubmit;
    private JButton jbFile;
    
	public DrawFrame() {
		frame = new JFrame("算工资小助手");
		jlFile = new JLabel("文   件：");
		jlStart = new JLabel("起始日期：");
		jlEnd = new JLabel("结束日期：");
		jtfFile = new JTextField("选择文件...");
		jtfStart = new JTextField("输入格式20180115...");
		jtfEnd = new JTextField("输入格式20180115...");
		jbSubmit = new JButton("确 定");
		jbFile = new JButton("选择");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

		frame.setBounds(screenWidth / 3, screenHeight / 4, 330, 150); // 设置位置及大小
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.getContentPane().setBackground(Color.lightGray);
		frame.getContentPane().setLayout(null); // 使用绝对布局
		frame.setResizable(false); // 设置窗口大小不可变

		jlFile.setBounds(5, 2, 100, 25);
		jlStart.setBounds(5, 30, 100, 25);
		jlEnd.setBounds(5, 60, 100, 25);
		jtfFile.setBounds(100, 2, 150, 25);
		jtfStart.setBounds(100, 30, 150, 25);
		jtfEnd.setBounds(100, 60, 150, 25);
		jbSubmit.setBounds(2, 90, 320, 25);
		jbFile.setBounds(250,2,60,25);
		jlFile.setFont(new Font("宋体", 1, 16));
		jlStart.setFont(new Font("宋体", 1, 16));
		jlEnd.setFont(new Font("宋体", 1, 16));

		jtfStart.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {}

			@Override
			public void focusGained(FocusEvent e) {
				jtfStart.setText("");
			}
		});

		jtfEnd.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {}

			@Override
			public void focusGained(FocusEvent e) {
				jtfEnd.setText("");
			}
		});
		
		jbFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				jfc.showDialog(new JLabel(), "选择");
				File file = jfc.getSelectedFile();
				if (file.isDirectory()) {
					System.out.println("文件夹:" + file.getAbsolutePath());
				} else if (file.isFile()) {
					System.out.println("文件:" + file.getAbsolutePath());
				}
				System.out.println(jfc.getSelectedFile().getName());
				
				jtfFile.setText(file.getAbsolutePath());
			}
		});

		jbSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Forms forms = new Forms();
				forms.setFilePath(jtfFile.getText());
				forms.setStartDate(jtfStart.getText());
				forms.setEndDate(jtfEnd.getText());
				Control01.excute(forms);
			}
		});
		
		frame.add(jlFile);
		frame.add(jlStart);
		frame.add(jlEnd);
		frame.add(jtfFile);
		frame.add(jtfStart);
		frame.add(jtfEnd);
		frame.add(jbSubmit);
        frame.add(jbFile);
		frame.setVisible(true);
		// 首选大小
		pack();
	}
}