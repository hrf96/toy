package org.hanrunfan.owner.frame;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 228204561359565347L;

	public static void main(String[] args) {
		new MainFrame();  
	}
	
	public MainFrame(){
        JPanel panel = new JPanel();  
        JTextArea textArea = new JTextArea();  
        panel.setLayout(new GridLayout());  
        textArea.setText("测试一下");  
        //当TextArea里的内容过长时生成滚动条  
        panel.add(new JScrollPane(textArea));  
        this.add(panel);  
        this.setSize(200,200);  
        this.setVisible(true);  
	}

}
