package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Buy.Buy_Screen;
import Sales.Sales_Screen;

public class Main extends JFrame{
	GridBagLayout gBag;



	Main(){
		JFrame c= new JFrame();
		c.setLayout(null);
		c.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setSize(400,600);
		c.setTitle("메인화면");
		 MyPanel panel1 = new MyPanel();
		 c.add(panel1);
		 panel1.setBounds(0, 0, 380, 430);
		 JPanel panel2= new JPanel();
		 panel2.setBorder(BorderFactory.createLineBorder(Color.black));
		 c.add(panel2);
		 panel2.setBounds(0,430,380,130);
		 gBag = new GridBagLayout();
		 panel2.setLayout(gBag);
		 
	
	
		
		
		JLabel notice= new JLabel("비밀번호를 입력하세요!");
		JPasswordField tf2 = new JPasswordField("비밀번호 입력",10);
		JButton doneButton = new JButton("입력");
		
		JButton userButton = new JButton("사용자");
		JButton staffButton= new JButton("관리자");
		
		 gbinadd(userButton,1,0,1,1);
		 gbinadd(staffButton,2,0,1,1);
		 gbinadd(notice,1,2,4,1);
		 gbinadd(tf2,4,2,1,1);
		 gbinadd(doneButton,2,3,1,1);
		
		
		panel2.add(userButton);
		panel2.add(staffButton);
		panel2.add(notice);
		notice.setVisible(false);
		tf2.setText("");
		 panel2.add(tf2);
		tf2.setVisible(false);
		panel2.add(doneButton);
		doneButton.setVisible(false);
		
		userButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new Buy_Screen();
				
				
			}
		});
		
		staffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			notice.setVisible(true);
			tf2.setVisible(true);
			doneButton.setVisible(true);
				
			}
		});
		
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String myPass=String.valueOf(tf2.getPassword());
		if(Integer.parseInt(myPass) == 9999) {
			new Sales_Screen();
		}
		else {
			notice.setText("비밀번호가 틀렸습니다!");
			tf2.setText("");
		}
		
			}
		});

		}	
	
	class MyPanel extends JPanel {
		ImageIcon Main_img= new ImageIcon("main.jpg");
		Image img= Main_img.getImage();
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		}
		
	}
	
	public void gbinadd(Component c, int x, int y, int w, int h){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill= GridBagConstraints.BOTH;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gBag.setConstraints(c,gbc);
        this.add(c);
       
       
    }


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
