package Java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;

import com.toedter.calendar.JDateChooser;

import DB.DbConnection;
import jewelleryUtil.CommonUtil;
import model.DropDownItem;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.awt.event.ActionEvent;
import datechooser.beans.DateChooserCombo;
import datechooser.view.WeekDaysStyle;
import javax.swing.JCheckBox;

public class Purchase extends JFrame {

	public JPanel contentPane;
	private JTextField billno;
	private JTextField quantity;
	private JTextField amount;
	public static int y=70;
	//public static int z=Purchase.y-10;
	public static JCheckBox chckbxCheck;
	//to set the object in hashmap
	public static Integer keyset=1;
	//private static int clicked = 0;
	public static HashMap<Integer, Object> map = new HashMap<Integer, Object>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purchase frame = new Purchase();
					frame.setVisible(true);
					frame.setTitle("Purchase Page");
					frame.getContentPane().setBackground( Color.RED );
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Purchase() {
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 1331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPurchaseDetails = new JLabel("PURCHASE DETAILS");
		lblPurchaseDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPurchaseDetails.setBounds(231, 11, 191, 35);
		contentPane.add(lblPurchaseDetails);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(50, 41, 73, 20);
		contentPane.add(lblDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy  hh:mm:ss a");
		Date date = new Date();
		dateChooser.setDate(date);
		dateChooser.setBounds(26, 72, 174, 20);
		contentPane.add(dateChooser);
		
		JLabel lblBillNo = new JLabel("Bill No");
		lblBillNo.setBounds(210, 44, 91, 14);
		contentPane.add(lblBillNo);
		
		billno = new JTextField();
		billno.setBounds(210, 72, 91, 20);
		contentPane.add(billno);
		billno.setColumns(10);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(311, 44, 103, 14);
		contentPane.add(lblProductName);
		
		JComboBox productname = new JComboBox(CommonUtil.getProductName());
		productname.setBounds(311, 72, 108, 20);
		contentPane.add(productname);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(432, 44, 46, 14);
		contentPane.add(lblQuantity);
		
		quantity = new JTextField();
		quantity.setBounds(429, 72, 86, 20);
		contentPane.add(quantity);
		quantity.setColumns(10);
		
		JLabel lblUnit = new JLabel("Unit");
		lblUnit.setBounds(536, 44, 63, 14);
		contentPane.add(lblUnit);
		
		JComboBox unit = new JComboBox(CommonUtil.getAllunit());
		unit.setBounds(537, 72, 73, 20);
		contentPane.add(unit);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(632, 44, 46, 14);
		contentPane.add(lblAmount);
		
		amount = new JTextField();
		amount.setBounds(632, 72, 86, 20);
		contentPane.add(amount);
		amount.setColumns(10);
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			
			public  void actionPerformed(ActionEvent arg0) {
				
				Purchase.y= Purchase.y+30;
				JTextField billnot = new JTextField();
				billnot.setName("abc");
				billnot.setBounds(126, Purchase.y, 91, 20);
				contentPane.add(billnot);
				billnot.setColumns(11);
				billnot.setVisible(true);
				//JTextField bill=billno;
				
				JComboBox productnamet = new JComboBox(CommonUtil.getProductName());
				productnamet.setBounds(249, Purchase.y, 108, 20);
				contentPane.add(productnamet);
				
				JTextField quantityt = new JTextField();
				quantityt.setBounds(378, Purchase.y, 86, 20);
				contentPane.add(quantityt);
				quantityt.setColumns(11);
				
				JComboBox unitt = new JComboBox(CommonUtil.getAllunit());
				unitt.setBounds(474, Purchase.y, 73, 20);
				contentPane.add(unitt);
				
				JTextField amountt = new JTextField();
				amountt.setBounds(563, Purchase.y, 86, 20);
				contentPane.add(amountt);
				amountt.setColumns(11);
				contentPane.repaint();
				
				JButton btnNewButton = new JButton("Remove");
				btnNewButton.putClientProperty( "row",keyset );
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//r=number of counts of mouse click in add button
						//keyset number of arrays counts key value
				    int r=(Integer)((JButton)e.getSource()).getClientProperty( "row" );
				    
				    List<Component> lis=(List<Component>)map.get(r);
					for(Component c: lis){	
						
						
						contentPane.remove(c);
						
						 
					}
					Purchase.y=Purchase.y-30;
					for(int l=r;l<keyset;l++){
					 List<Component> lis12=(List<Component>)map.get(l);
					 for(Component c:lis12){
						 
						Rectangle re= c.getBounds();
						
						int x= new Double(re.getX()).intValue();
						int y= new Double(re.getY()).intValue();
						int w= new Double(re.getWidth()).intValue();
						int h= new Double(re.getHeight()).intValue();
						
						c.setBounds(x,y-30,w,h);
						
						contentPane.revalidate();
					 }
					}
					
					
					
					contentPane.repaint();
					 
					
				
					
					}
				});
				btnNewButton.setBounds(663, Purchase.y, 86, 20);
				contentPane.add(btnNewButton);
				
			
				//add arraylist to get all components
				List<Component> list=new ArrayList<Component>();
				list.add(billnot);
				list.add(productnamet);
				list.add(quantityt);
				list.add(unitt);
				list.add(amountt);
				//list.add(chckbxCheck);
				list.add(btnNewButton);
				//System.out.println(list);
				
				
				Purchase.map.put(keyset, list);
				keyset++;
				
				
			}
		});
		btnAdd.setBounds(745, 72, 89, 23);
		contentPane.add(btnAdd);
		
		/*JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println("inside");
				// String val = "";
				// val =chckbxCheck.getText();
				
				List<Component> lis=(List<Component>)map.get(clicked);
			for(Component c: lis){	
				
				
				contentPane.remove(c);
			}
			contentPane.repaint();
			
			}
		});
		btnRemove.setBounds(844, 72, 89, 23);
		contentPane.add(btnRemove);*/
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*for(int i=1;i<keyset;i++){
				List<Component> lis=(List<Component>)map.get(i);
				System.out.println("Row start" +i);
				for(Component c:lis){
					
					if(c.getClass().getName().contains("JTextField"))
				      System.out.println(((JTextField)c).getText() +"   name"+((JTextField)c).getName());
				
					if(c.getClass().getName().contains("JComboBox")){
					     
					      DropDownItem itemprod = (DropDownItem)((JComboBox)c).getSelectedItem();
					      System.out.println(itemprod.getId());
					      
					}
				 
				}
				System.out.println("Row end " +i);
				}*/
				
				
				try {
					String query="insert into purchase(BillId,ProductId,Quantity,UnitId,Date,Amount,VendorId,CatId) values(?,?,?,?,?,?,0,0)";
					Statement tm =DbConnection.getconnection().createStatement();
					PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
					pt.setString(1, billno.getText());
					DropDownItem itemprod = (DropDownItem)productname.getSelectedItem();
					pt.setInt(2, itemprod.getId());
					pt.setString(3, quantity.getText());
					DropDownItem itemunit = (DropDownItem)unit.getSelectedItem();
					pt.setInt(4, itemunit.getId());
					java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
					pt.setTimestamp(5, date);
					pt.setString(6, amount.getText());
					pt.execute();
					for(int i=1;i<keyset;i++)
					{
						 pt=DbConnection.getconnection().prepareStatement(query);
					List<Component> lis=(List<Component>)map.get(i);
					int j=0;
					
					//for(Component c: lis)
						//{
					Component c=lis.get(j);
							String bill=((JTextField)c).getText();
							pt.setString(1, bill);
					j++;
					c=lis.get(j);
							DropDownItem proditem = (DropDownItem)((JComboBox)c).getSelectedItem();
							pt.setInt(2, proditem.getId());
						j++;
						c=lis.get(j);
						
							String quan=((JTextField)c).getText();
							pt.setString(3, quan);
						j++;	
						
						c=lis.get(j);
							DropDownItem unit = (DropDownItem)((JComboBox)c).getSelectedItem();
							pt.setInt(4, unit.getId());
						
						java.sql.Timestamp date1 = new java.sql.Timestamp(new java.util.Date().getTime());
						pt.setTimestamp(5, date1);
						j++;
						
						c=lis.get(j);
							String amt=((JTextField)c).getText();
							pt.setString(6, amt);
						
						j++;
						//}
						pt.execute();
					}
					
					billno.setText("");
					//itemprod.getId();
					quantity.setText("");
					//itemunit.getId();
					amount.setText("");
					//dateChooser.setCalendar(null);
					dateChooser.setCalendar(null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(943, 72, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Viewpage.main(new String[]{});
	       		setVisible(false);
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
		
		
		
		
		
	}
}

