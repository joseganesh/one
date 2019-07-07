package Java;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

import DB.DbConnection;
import jewelleryUtil.CommonUtil;
import model.DropDownItem;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;

public class PurchaseScreen extends JFrame {

	private JPanel contentPane;
	private static PurchaseScreen framepchse;
	private JTextField name;
	private JTextField contactno;
	private JTextField state;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField slno;
	private JTextField hsncode;
	private JTextField gwt;
	private JTextField touch;
	private JTextField netwt;
	private JTextField rate;
	private JTextField amount;
	private JTextField sumamt;
	private JTextField roundoff;
	private JTextField totalamt;
	private JTextField amtinwords;
	private JTextField purity;
	//first set first component yaxis value
	public static int y=313;
	public static Integer keyset=1;
	public static HashMap<Integer, Object> map = new HashMap<Integer, Object>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					framepchse = new PurchaseScreen();
					framepchse.setVisible(true);
					framepchse.setTitle("PurchaseScreen Page");
					SwingUtilities.updateComponentTreeUI(framepchse);
					framepchse.repaint();
					framepchse.revalidate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PurchaseScreen() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 1330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPurchaseScreen = new JLabel("PURCHASE SCREEN");
		lblPurchaseScreen.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPurchaseScreen.setBounds(473, 11, 262, 53);
		contentPane.add(lblPurchaseScreen);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(10, 63, 124, 14);
		contentPane.add(lblDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(152, 57, 153, 20);
		contentPane.add(dateChooser);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 88, 46, 14);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setBounds(152, 85, 153, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblContactNo = new JLabel("Contact No:");
		lblContactNo.setBounds(10, 113, 95, 14);
		contentPane.add(lblContactNo);
		
		contactno = new JTextField();
		contactno.setBounds(152, 110, 153, 20);
		contentPane.add(contactno);
		contactno.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 170, 95, 14);
		contentPane.add(lblAddress);
		
		JTextArea address = new JTextArea();
		address.setBounds(152, 141, 153, 65);
		contentPane.add(address);
		
		JLabel lblState = new JLabel("State:");
		lblState.setBounds(10, 223, 95, 14);
		contentPane.add(lblState);
		
		state = new JTextField();
		state.setBounds(150, 220, 155, 20);
		contentPane.add(state);
		state.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(945, 85, 117, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(1072, 85, 80, 20);
		contentPane.add(comboBox_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(1162, 85, 71, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(1243, 85, 117, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSlNo = new JLabel("Sl No");
		lblSlNo.setBounds(30, 288, 60, 14);
		contentPane.add(lblSlNo);
		
		slno = new JTextField();
		slno.setBounds(10, 313, 80, 20);
		contentPane.add(slno);
		slno.setColumns(10);
		
		JLabel lblHsnCode = new JLabel("HSN code");
		lblHsnCode.setBounds(108, 288, 60, 14);
		contentPane.add(lblHsnCode);
		
		hsncode = new JTextField();
		hsncode.setBounds(94, 313, 86, 20);
		contentPane.add(hsncode);
		hsncode.setColumns(10);
		
		JLabel lblitemname = new JLabel("Item Name");
		lblitemname.setBounds(200, 288, 71, 14);
		contentPane.add(lblitemname);
		
		JComboBox itemname = new JComboBox(CommonUtil.getProductName());
		itemname.setBounds(183, 313, 100, 20);
		contentPane.add(itemname);
		
		JLabel lblPurity = new JLabel("Purity");
		lblPurity.setBounds(309, 288, 60, 14);
		contentPane.add(lblPurity);
		
		purity = new JTextField();
		purity.setBounds(285, 313, 86, 20);
		contentPane.add(purity);
		purity.setColumns(10);
		
		JLabel lblgwt = new JLabel("G Wt.");
		lblgwt.setBounds(397, 288, 46, 14);
		contentPane.add(lblgwt);
		
		gwt = new JTextField();
		gwt.setBounds(376, 313, 86, 20);
		contentPane.add(gwt);
		gwt.setColumns(10);
		
		JLabel lblTouch = new JLabel("Touch");
		lblTouch.setBounds(483, 288, 53, 14);
		contentPane.add(lblTouch);
		
		touch = new JTextField();
		touch.setBounds(473, 313, 86, 20);
		contentPane.add(touch);
		touch.setColumns(10);
		
		JLabel lblNetWt = new JLabel("Net Wt.");
		lblNetWt.setBounds(590, 288, 60, 14);
		contentPane.add(lblNetWt);
		
		netwt = new JTextField();
		netwt.setBounds(569, 313, 95, 20);
		contentPane.add(netwt);
		netwt.setColumns(10);
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setBounds(689, 288, 46, 14);
		contentPane.add(lblRate);
		
		rate = new JTextField();
		rate.setBounds(670, 313, 107, 20);
		contentPane.add(rate);
		rate.setColumns(10);
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setBounds(813, 288, 71, 14);
		contentPane.add(lblTotalAmount);
		
		amount = new JTextField();
		amount.setBounds(787, 313, 139, 20);
		contentPane.add(amount);
		amount.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(670, 352, 86, 14);
		contentPane.add(lblAmount);
		
		sumamt = new JTextField();
		sumamt.setBounds(787, 349, 139, 20);
		contentPane.add(sumamt);
		sumamt.setColumns(10);
		
		JLabel lblRountOff = new JLabel("Rount off:");
		lblRountOff.setBounds(670, 390, 86, 14);
		contentPane.add(lblRountOff);
		
		roundoff = new JTextField();
		roundoff.setBounds(787, 387, 139, 20);
		contentPane.add(roundoff);
		roundoff.setColumns(10);
		
		JLabel lblTotalamount = new JLabel("TotalAmount:");
		lblTotalamount.setBounds(670, 435, 107, 14);
		contentPane.add(lblTotalamount);
		
		totalamt = new JTextField();
		totalamt.setBounds(787, 432, 139, 20);
		contentPane.add(totalamt);
		totalamt.setColumns(10);
		
		amtinwords = new JTextField();
		amtinwords.setBounds(10, 432, 654, 20);
		contentPane.add(amtinwords);
		amtinwords.setColumns(10);
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				PurchaseScreen.y=PurchaseScreen.y+30;
				
				JTextField slnop = new JTextField();
				slnop.setBounds(10, PurchaseScreen.y, 80, 20);
				contentPane.add(slnop);
				slnop.setColumns(10);
				
				JTextField hsncodep = new JTextField();
				hsncodep.setBounds(94, PurchaseScreen.y, 86, 20);
				contentPane.add(hsncodep);
				hsncodep.setColumns(10);
				
				JComboBox itemnamep = new JComboBox(CommonUtil.getProductName());
				itemnamep.setBounds(183, PurchaseScreen.y, 100, 20);
				contentPane.add(itemnamep);
				
				JTextField purityp = new JTextField();
				purityp.setBounds(285, PurchaseScreen.y, 86, 20);
				contentPane.add(purityp);
				purityp.setColumns(10);
				
				JTextField gwtp = new JTextField();
				gwtp.setBounds(376, PurchaseScreen.y, 86, 20);
				contentPane.add(gwtp);
				gwtp.setColumns(10);
				
				JTextField touchp = new JTextField();
				touchp.setBounds(473, PurchaseScreen.y, 86, 20);
				contentPane.add(touchp);
				touchp.setColumns(10);
				
				JTextField netwtp = new JTextField();
				netwtp.setBounds(569, PurchaseScreen.y, 95, 20);
				contentPane.add(netwtp);
				netwtp.setColumns(10);
				
				JTextField ratep = new JTextField();
				ratep.setBounds(670, PurchaseScreen.y, 107, 20);
				contentPane.add(ratep);
				ratep.setColumns(10);
				
				JTextField amountp = new JTextField();
				amountp.setBounds(787, PurchaseScreen.y, 139, 20);
				contentPane.add(amountp);
				amountp.setColumns(10);
				
				JButton rem = new JButton("Remove");
				rem.putClientProperty( "row",keyset );
				rem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//r=number of counts of mouse click in add button
						//keyset number of arrays counts key value
				    int r=(Integer)((JButton)e.getSource()).getClientProperty( "row" );
				    
				    List<Component> lis=(List<Component>)map.get(r);
					for(Component c: lis){	
						
						
						contentPane.remove(c);
						
						 
					}
	                  map.remove(r);
	                  contentPane.revalidate();
					contentPane.repaint();
					//int coun =1;
					PurchaseScreen.y=PurchaseScreen.y-30;
					for(int l=(r+1);l<keyset;l++){
					 List<Component> lis12=(List<Component>)map.get(l);
					 if(lis12!= null && !lis12.isEmpty()){
						
					 for(Component c:lis12){
						 
						Rectangle re= c.getBounds();
						//to get an x axis value y axis value width and height
						int x= new Double(re.getX()).intValue();
						int y= new Double(re.getY()).intValue();
						int w= new Double(re.getWidth()).intValue();
						int h= new Double(re.getHeight()).intValue();
						
						c.setBounds(x,y-30,w,h);
						
						contentPane.revalidate();
					 }
					 
					
					 
					
					 }
					}
					//set the height of bottom components decrements to call the method
					 setPosmin(lblAmount);
					 setPosmin(sumamt)  ;
					 setPosmin(lblRountOff);
					 setPosmin(roundoff);
					 setPosmin(lblTotalamount)  ;
					 setPosmin(totalamt);
					 setPosmin(amtinwords);
					 contentPane.revalidate();
					 contentPane.repaint();
					
					}
					
				});
				rem.setBounds(960, PurchaseScreen.y, 89, 23);
				contentPane.add(rem);
				
				
	List<Component> list=new ArrayList<Component>();
				
				list.add(slnop);
				list.add(hsncodep);
				list.add(itemnamep);
				list.add(purityp);
				list.add(gwtp);
				list.add(touchp);
				list.add(netwtp);
				list.add(ratep);
				list.add(amountp);
				list.add(sumamt);
				list.add(roundoff);
				list.add(totalamt);
				list.add(amtinwords);
				list.add(rem);
				

				//set the height of bottom components increments to call the method
				setPos(lblAmount);
			    setPos(sumamt)  ;
				setPos(lblRountOff);
				setPos(roundoff);
				setPos(lblTotalamount)  ;
				setPos(totalamt);
				setPos(amtinwords);
			
				
				PurchaseScreen.map.put(keyset, list);
				keyset++;
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		btnAdd.setBounds(960, 312, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				 try{
	 					
	 					String query="insert into customer(CustomerName,ContactNo,Address) "+ "values(?,?,?)";
	 							
	 					Statement tm =DbConnection.getconnection().createStatement();
	 					PreparedStatement pt2=DbConnection.getconnection().prepareStatement(query);
	 					
	 					pt2.setString(1, name.getText());
	 					pt2.setString(2, contactno.getText());
	 					pt2.setString(3, address.getText());
	 					pt2.execute();
	 					pt2.close();
	 					
	 					
	 					name.setText("");
	 					contactno.setText("");
	 					address.setText("");
	 					}
	 					catch (SQLException e2) {
	 						// TODO Auto-generated catch block
	 						e2.printStackTrace();
	 					}
				 
				 try{
	 					
	 					String query1="insert into purchasescreen(HSNCode, ProductName, Purity, Gwt, Touch, Netwt, Rate, Totalamt, Sumamt, Roundoff, LastTotAmt, Amtinwords) "+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
	 							
	 					Statement tm =DbConnection.getconnection().createStatement();
	 					PreparedStatement pt=DbConnection.getconnection().prepareStatement(query1);
	 					
	 					pt.setString(1, hsncode.getText());
	 					DropDownItem itemprodname = (DropDownItem)itemname.getSelectedItem();
	 					pt.setInt(2, itemprodname.getId());
	 					pt.setDouble(3, Double.parseDouble(purity.getText()));
	 					pt.setDouble(4, Double.parseDouble(gwt.getText()));
	 					pt.setDouble(5, Double.parseDouble(touch.getText()));
	 					pt.setDouble(6, Double.parseDouble(netwt.getText()));
	 					pt.setDouble(7, Double.parseDouble(rate.getText()));
	 					pt.setDouble(8, Double.parseDouble(amount.getText()));
	 					pt.setDouble(9, Double.parseDouble(sumamt.getText()));
	 					pt.setDouble(10, Double.parseDouble(roundoff.getText()));
	 					pt.setDouble(11, Double.parseDouble(totalamt.getText()));
	 					pt.setString(12, amtinwords.getText());
	 					pt.execute();
	 					pt.close();
	 					
	 					
	 					for(int i=1;i<keyset;i++)
	 					{
	 						 pt=DbConnection.getconnection().prepareStatement(query1);
	 					List<Component> lis=(List<Component>)map.get(i);
	 					//consider the component where the component j starts from save
	 					int j=1;
	 					
	 					Component c=lis.get(j);
	 					
	 					//to see above list arrange in ascending order
	 					String hsncodep=((JTextField)c).getText();
	 					pt.setString(1, hsncodep);
	 				    j++;
	 				    
	 				    c=lis.get(j);
	 				    DropDownItem pname = (DropDownItem)itemname.getSelectedItem();
	 					pt.setInt(2, pname.getId());
	 					j++;
	 				    
	 				    c=lis.get(j);
	 				    Double purityp=Double.parseDouble(((JTextField)c).getText());
	 					pt.setDouble(3, purityp);
	 				    j++;
	 				    
	 				    c=lis.get(j);
	 				    Double gwtp=Double.parseDouble(((JTextField)c).getText());
	 					pt.setDouble(4, gwtp);
	 				    j++;
	 				    
	 				   c=lis.get(j);
	 				    Double touchp=Double.parseDouble(((JTextField)c).getText());
	 					pt.setDouble(5, touchp);
	 				    j++;
	 				    
	 				    c=lis.get(j);
	 				    Double netwtp=Double.parseDouble(((JTextField)c).getText());
	 					pt.setDouble(6, netwtp);
	 				    j++;
	 				    
	 				    c=lis.get(j);
	 				    Double ratep=Double.parseDouble(((JTextField)c).getText());
	 					pt.setDouble(7, ratep);
	 				    j++;
	 				    
	 				   c=lis.get(j);
	 				    Double amountp=Double.parseDouble(((JTextField)c).getText());
	 					pt.setDouble(8, amountp);
	 				    j++;
	 				    
	 				   c=lis.get(j);
	 				    Double samount=Double.parseDouble(((JTextField)c).getText());
	 					pt.setDouble(9, samount);
	 				    j++;
	 				    
	 				   c=lis.get(j);
	 				    Double roundoff=Double.parseDouble(((JTextField)c).getText());
	 					pt.setDouble(10, roundoff);
	 				    j++;
	 				    
	 				    c=lis.get(j);
	 				    Double totalamt=Double.parseDouble(((JTextField)c).getText());
	 					pt.setDouble(11, totalamt);
	 				    j++;
	 				    
	 				    String amtinwordsp=((JTextField)c).getText();
	 					pt.setString(12, amtinwordsp);
	 				    j++;
	 				    
	 				    pt.execute();
	 				    pt.close();
	 					}
	 					
	 					
	 					hsncode.setText("");
	 					purity.setText("");
	 					gwt.setText("");
	 					touch.setText("");
	 					netwt.setText("");
	 					rate.setText("");
	 					amount.setText("");
	 					sumamt.setText("");
	 					totalamt.setText("");
	 					roundoff.setText("");
	 					amtinwords.setText("");
	 					}
	 					catch (SQLException e3) {
	 						// TODO Auto-generated catch block
	 						e3.printStackTrace();
	 					}
				 try {
					 framepchse.setVisible(false);
						framepchse = new PurchaseScreen();
						framepchse.setVisible(true);
						framepchse.setTitle("PurchaseScreen Page");
						SwingUtilities.updateComponentTreeUI(framepchse);
						framepchse.repaint();
						framepchse.revalidate();
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		});
		btnSubmit.setBounds(1073, 312, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Viewpage.main(new String[]{});
        		setVisible(false);
			}
		});
		btnBack.setBounds(1281, 29, 89, 23);
		contentPane.add(btnBack);
	}
	
	public static void setPos(JComponent comp){
		 Rectangle re=comp.getBounds();
		  
		  
		    comp.setBounds(re.x , re.y+30 ,re.width,re.height);
		    comp.revalidate();
		    comp.repaint();
		    System.out.println(re.x+" , "+ (re.y+30)+" , "+re.height+" , "+re.width+" add");
			
	}
	public static void setPosmin(JComponent compon){
		 Rectangle rem=compon.getBounds();
		    System.out.println(rem.x+" , "+ rem.y+"  , "+rem.width+", "+rem.height);
		  
		    compon.setBounds(rem.x , rem.y-30 ,rem.width,rem.height);
		    compon.revalidate();
		    compon.repaint();
		    System.out.println(rem.x+" , "+ (rem.y-30)+"  , "+rem.width+", "+rem.height);
			
	}
}
