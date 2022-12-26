package Buy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Sales.Sales_Screen;


public class Buy_Screen extends JFrame {
	GridBagLayout gBag;
	Button[] arButtons = new Button[6];
	String[] menuName = {"Americano","Latte","Vanilla latte","macchiato","Cappuccino","Mocha"};
	String[] rows= new String[6];
	   JRadioButton op2 = new JRadioButton("소화잘되는우유(+500)");
	   JRadioButton op3 = new JRadioButton("귀리우유변경(+1500)");
	int menuprice=0;
	int sizeprice=0;
	int orderprice=0;
	String pPrice;
	int count = 0;
	JOptionPane aa=new JOptionPane();//구매하기 버튼 클릭시 팝업창 띄울 패널
	

	String num;
	int prePrice; //계산 전 가격
	int totalPrice; //총 가격
	static JLabel nameLabel;
	static JLabel totalLabel;
	static JButton addButton;
	JPanel OptionPanel = new JPanel();
	JPanel OrderPanel = new JPanel();

	
	public Buy_Screen(){
	JFrame c= new JFrame();
	c.setLayout(null);
	c.setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	c.setSize(1100,800);
	String orderName = "";
	
	JPanel mainPanel = new JPanel();
	JPanel OptionPanel = new JPanel();
    OptionPanel.setBorder(BorderFactory.createLineBorder(Color.black));//테두리 설정
	

	
	mainPanel.setBounds(0,0,600,400);
	
	GridLayout grid = new GridLayout(2,3);
	mainPanel.setLayout(grid);
	
	for (int i = 0; i < arButtons.length; i++) {
		arButtons[i] = new Button(menuName[i]);
		arButtons[i].setFont(new Font("Dialog",Font.BOLD,20));
		mainPanel.add(arButtons[i]);
		arButtons[i].setName(menuName[i]);
		MyActionListener listener = new MyActionListener();
		arButtons[i].addActionListener(listener); //이벤트 달기
		
	}

	
	
	gBag = new GridBagLayout();
	OptionPanel.setLayout(gBag);// 옵션패널 레이아웃 설정
	OptionPanel.setBounds(0,400,600,200);
	
	
	
	
	
	
	JLabel optionLabel = new JLabel("옵션 선택 창"); 

	optionLabel.setFont(new Font("고딕", Font.BOLD, 13));
	
	JLabel orderLabel = new JLabel("-선택한 메뉴 :"); 
	nameLabel = new JLabel(orderName);
	JLabel numberLabel = new JLabel("-개수 :");
	Choice nmbChoice= new Choice();
	nmbChoice.add("1");
	nmbChoice.add("2");
	nmbChoice.add("3");
	nmbChoice.add("4");
	nmbChoice.add("5");
	nmbChoice.add("6");
	nmbChoice.add("7");
	nmbChoice.add("8");
	JLabel temperLabel = new JLabel("-종류 :"); 
	JLabel sizeLabel = new JLabel("-사이즈 :"); 
	JLabel subLabel = new JLabel("-기타 옵션 :"); 
	addButton = new JButton("담기"); //담기버튼 생성

	
	
	JRadioButton rd1 = new JRadioButton("ice");
    JRadioButton rd2 = new JRadioButton("hot");

  
    ButtonGroup groupRd = new ButtonGroup();
    groupRd.add(rd1);
    groupRd.add(rd2);
    
    JRadioButton size1 = new JRadioButton("S");
    JRadioButton size2 = new JRadioButton("M(+500)");
	JRadioButton size3 = new JRadioButton("L(+1000)");
  
    ButtonGroup groupsize = new ButtonGroup();
    groupsize.add(size1);
    groupsize.add(size2);
    groupsize.add(size3);
    
    JRadioButton op1 = new JRadioButton("없음");
 

  
    ButtonGroup groupop = new ButtonGroup();
    groupop.add(op1);
    groupop.add(op2);
    groupop.add(op3);

    


    gbinadd(optionLabel,0,0,1,1);
	gbinadd(nameLabel,1,1,1,1);
	gbinadd(orderLabel,0,1,1,1);
	gbinadd(numberLabel,0,2,1,1);
	gbinadd(nmbChoice,1,2,1,1);
	gbinadd(temperLabel,0,3,1,1);
	gbinadd(sizeLabel,0,4,1,1);
	gbinadd(subLabel,0,5,1,1);
	gbinadd(rd1,1,3,1,1);
	gbinadd(rd2,2,3,1,1);
	gbinadd(size1,1,4,1,1);
	gbinadd(size2,2,4,1,1);
	gbinadd(size3,3,4,1,1);
	gbinadd(op1,1,5,1,1);
	gbinadd(op2,2,5,1,1);
	gbinadd(op3,3,5,1,1);
	
	gbinadd(addButton,3,6,1,2);
	
	OptionPanel.add(nmbChoice);
	OptionPanel.add(numberLabel);
	OptionPanel.add(optionLabel);
	OptionPanel.add(nameLabel);
	OptionPanel.add(orderLabel);
	OptionPanel.add(temperLabel);
	OptionPanel.add(sizeLabel);
	OptionPanel.add(subLabel);
	OptionPanel.add(rd1);
	OptionPanel.add(rd2);
	OptionPanel.add(size1);
	OptionPanel.add(size2);
	OptionPanel.add(size3);
	OptionPanel.add(op1);
	OptionPanel.add(op2);
	OptionPanel.add(op3);
	OptionPanel.add(addButton);
	
	String CName[]= {"이름","개수","종류","사이즈","우유변경","가격"};
	DefaultTableModel model= new DefaultTableModel(CName,0);
	JTable table= new JTable(model);
	OrderPanel.add(new JScrollPane(table),BorderLayout.CENTER);
	OrderPanel.setBounds(600,0,500,600);
    OrderPanel.setBorder(BorderFactory.createLineBorder(Color.black));//테두리 설정
    JButton deleteButton = new JButton("지우기");
    JButton chargeButton = new JButton("계산하기");
    
    
    OrderPanel.add(deleteButton);
    OrderPanel.add(chargeButton);
   
    

	
	setVisible(true);
	c.add(mainPanel);
	c.add(OptionPanel);
	c.add(OrderPanel);
	
	addButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) { 
		
		if(groupRd.isSelected(null)||groupsize.isSelected(null)||groupop.isSelected(null))
		{
			JOptionPane.showMessageDialog(null, "옵션을 선택해주세요");
			
		}
		else {
			
		rows[0]=nameLabel.getText();
		num=nmbChoice.getSelectedItem();
		rows[1]=num; //담기
		if(rd1.isSelected()) rows[2]="ice";
		else rows[2]= "hot";
		
		if(size1.isSelected()) {rows[3]="S"; sizeprice=0;}
		else if(size2.isSelected()) { rows[3]= "M"; sizeprice=500;}
		else {rows[3]="L"; sizeprice= 1000;}
		
		if(op1.isSelected()) {rows[4]="X"; orderprice= 0;}
		else if(op2.isSelected()){rows[4]= "소잘우유"; orderprice=500;}
		else {rows[4]="귀리우유"; orderprice=1500;}
	
		
		prePrice = menuprice*Integer.parseInt(num)+sizeprice+orderprice;
		rows[5]=Integer.toString(prePrice);
		model.addRow(rows);
		op1.setSelected(false);
		op2.setSelected(false);
		op3.setSelected(false);
		
		size1.setSelected(false);
		size2.setSelected(false);
		size3.setSelected(false);
		}
		}
	
		
		
	});
	
	chargeButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			int ab= table.getRowCount();
			
			
			System.out.print(ab);
			
			for(int i=0; i<ab; i++) {
		totalPrice +=Integer.parseInt((String) model.getValueAt(i, 5));
				}
			
			
			Sales_Screen.total_price+=totalPrice;
			
			
				aa.showMessageDialog(null, "구매하신 총 금액은"+ totalPrice +"원 입니다. \n 구매해주셔서 감사합니다!");
				totalPrice=0;

			
		for(int j=0; j<ab; j++) {
	 
	if(model.getValueAt(j, 0).toString()=="아메리카노") {
		for(int i=0; i<Integer.parseInt(num); i++)
		Sales_Screen.Amcnt++;
	}
	else if(model.getValueAt(j, 0).toString()=="라떼") {
		for(int i=0; i<Integer.parseInt(num); i++)
		Sales_Screen.Lacnt++;
	}
	else if(model.getValueAt(j, 0).toString()=="바닐라라떼") {
		for(int i=0; i<Integer.parseInt(num); i++)
			Sales_Screen.Vacnt++;
	}
	else if(model.getValueAt(j, 0).toString()=="마끼야또") {
		for(int i=0; i<Integer.parseInt(num); i++)
			Sales_Screen.Macnt++;
	}
	else if(model.getValueAt(j, 0).toString()=="카푸치노") {
		for(int i=0; i<Integer.parseInt(num); i++)
			Sales_Screen.Cacnt++;
	}
	else {
		for(int i=0; i<Integer.parseInt(num); i++)
			Sales_Screen.Mocnt++;
	}
			}
		
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		model.setNumRows(0); //테이블 초기화 
		}	

			
		

	});
	
	deleteButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int rowIndex= table.getSelectedRow();
			
			if(rowIndex==-1) return;
			model.removeRow(rowIndex);
			
			
		}
	});

	}	
	

	
	
	
	class MyActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) { 
			//TODO Auto-generated method stub
			
			//TODO 컴포넌트에 정의된 text 받아오는역할 
			switch(e.getActionCommand()){
			
			//TODO getActionCommand() 버튼의 텍스트를 얻어옵니다
			case "Americano": 
				nameLabel.setText("아메리카노");
				op2.setEnabled(false);
				op3.setEnabled(false);
				menuprice=2900;
				break;
			
			case "Latte": 
				nameLabel.setText("라떼");
				op2.setEnabled(true);
				op3.setEnabled(true);
				menuprice=3500;
				break;
			
			case "Vanilla latte": 
				nameLabel.setText("바닐라라떼");
				op2.setEnabled(true);
				op3.setEnabled(true);
				menuprice=3900;
				break;
		
			case "macchiato": 
				nameLabel.setText("마끼야또");
				op2.setEnabled(true);
				op3.setEnabled(true);
				menuprice=4500;
				break;
			
			case "Cappuccino": 
				nameLabel.setText("카푸치노");
				op2.setEnabled(true);
				op3.setEnabled(true);
				menuprice=4000;
				break;
			
			case "Mocha": 
				nameLabel.setText("모카");
				op2.setEnabled(true);
				op3.setEnabled(true);
				menuprice=4800;
				break;
			}
			
		
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
		new Buy_Screen();
	}

}
