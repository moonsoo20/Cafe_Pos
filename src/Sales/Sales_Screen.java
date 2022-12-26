package Sales;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import Buy.Buy_Screen;
import Main.Main;

public class Sales_Screen extends JFrame {
	JFrame c= new JFrame();
	
	public static int Amcnt;
	public static int Lacnt;
	public static int Vacnt;
	public static int Macnt;;
	public static int Cacnt;
	public static int Mocnt;
	public static int total_price;
	
	static JLabel AmLabel;
	String[] rows= new String[6];
	Calendar now = Calendar.getInstance();
	
	
	public Sales_Screen(){
	c.setLayout(null);
	c.setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	c.setSize(500,500);
	JPanel centerPanel= new JPanel();
	JPanel topPanel= new JPanel();
	JPanel downPanel= new JPanel();
	int year = now.get(Calendar.YEAR);
	 
	int month = now.get(Calendar.MONTH) +1;
	 
	int day = now.get(Calendar.DAY_OF_MONTH);
	
	JLabel date= new JLabel(year+"년"+month+"월"+day+"일");
	date.setFont(new Font("Serif", Font.BOLD, 45));
	JLabel sale= new JLabel("총 매출:");
	JLabel price= new JLabel(Integer.toString(total_price));
	sale.setFont(new Font("Serif", Font.BOLD, 30));
	price.setFont(new Font("Serif", Font.BOLD, 30));
	downPanel.add(sale);
	downPanel.add(price);
	c.add(downPanel);
	System.out.print(total_price);
	
	
	
	
	
	
	topPanel.add(date);
	date.setBounds(10, 100, 100, 100);
	
	
	AmLabel = new JLabel();
	c.add(centerPanel,BorderLayout.CENTER);
	
	c.add(topPanel);//중간패널 북쪽에 배치
	//topPanel.setBorder(BorderFactory.createLineBorder(Color.red));
	topPanel.setBounds(0,0,500,100);
	centerPanel.setBounds(0,100,500, 150);
	downPanel.setBounds(0, 250, 500, 100);
	
	String CName[]= {"이름","개수"};
	DefaultTableModel model= new DefaultTableModel(CName,0);
	JTable table= new JTable(model);
	centerPanel.add(new JScrollPane(table));
	table.setPreferredSize(new Dimension(500,200));
	
	rows[0]="아메리카노";
	rows[1]=Integer.toString(Amcnt);
	model.addRow(rows);
	rows[0]="카페라떼";
	rows[1]=Integer.toString(Lacnt);
	model.addRow(rows);
	rows[1]=Integer.toString(Vacnt);
	rows[0]="바닐라라떼";
	model.addRow(rows);
	rows[1]=Integer.toString(Macnt);
	rows[0]="마끼야또";
	model.addRow(rows);
	rows[1]=Integer.toString(Cacnt);
	rows[0]="카푸치노";
	model.addRow(rows);
	rows[1]=Integer.toString(Mocnt);
	rows[0]="카페모카";
	model.addRow(rows);
	
			
	
	
	
	}
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	new Sales_Screen();
}
	}
