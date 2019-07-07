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

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import DB.DbConnection;
import jewelleryUtil.CommonUtil;
import model.DropDownItem;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Sales extends JFrame {

	public JPanel contentPane;
	private static JTextField billno;
	private static JTextField quantity;
	private static JTextField amount;
	public static int y=70;
	//public static int z=Purchase.y-10;
	public static JCheckBox chckbxCheck;
	//to set the object in hashmap
	public static Integer keyset=1;
	//private static int clicked = 0;
	public static HashMap<Integer, Object> map = new HashMap<Integer, Object>();
	private static JTextField gram;
	private static JTextField discount;
	private static Sales framesale;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						framesale = new Sales();
						framesale.setVisible(true);
						framesale.setTitle("Sales Page");
						SwingUtilities.updateComponentTreeUI(framesale);
						framesale.repaint();
						framesale.revalidate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sales() {
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 1331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPurchaseDetails = new JLabel("SALES PAGE");
		lblPurchaseDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPurchaseDetails.setBounds(391, -2, 191, 35);
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
		
		/*JLabel lblBillNo = new JLabel("Bill No");
		lblBillNo.setBounds(210, 44, 91, 14);
		contentPane.add(lblBillNo);
		
		billno = new JTextField();
		billno.setBounds(210, 72, 91, 20);
		contentPane.add(billno);
		billno.setColumns(10);*/
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(231, 44, 103, 14);
		contentPane.add(lblProductName);
		
		JComboBox productname = new JComboBox(CommonUtil.getProductName());
		productname.setBounds(210, 72, 108, 20);
		contentPane.add(productname);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(361, 44, 61, 14);
		contentPane.add(lblQuantity);
		
		quantity = new JTextField();
		quantity.setBounds(348, 72, 86, 20);
		contentPane.add(quantity);
		quantity.setColumns(10);
		
		JLabel lblGram = new JLabel("Gram");
		lblGram.setBounds(463, 44, 46, 14);
		contentPane.add(lblGram);
		
		gram = new JTextField();
		gram.setBounds(444, 72, 86, 20);
		contentPane.add(gram);
		gram.setColumns(10);
		
		JLabel lblUnit = new JLabel("Unit");
		lblUnit.setBounds(536, 44, 63, 14);
		contentPane.add(lblUnit);
		
		JComboBox unit = new JComboBox(CommonUtil.getAllunit());
		unit.setBounds(537, 72, 86, 20);
		contentPane.add(unit);
		//unit.actionPerformed(e);
		
		JLabel lblDiscount = new JLabel("Discount");
		lblDiscount.setBounds(647, 44, 63, 14);
		contentPane.add(lblDiscount);
		
		discount = new JTextField();
		discount.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
			double amt;
			try {
				amt = prcentageCal(Double.parseDouble(discount.getText()),Float.parseFloat(gram.getText()));
				amount.setText(amt+"");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				
			}
		});
		discount.setBounds(633, 72, 86, 20);
		contentPane.add(discount);
		discount.setColumns(10);
		
		
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(757, 44, 46, 14);
		contentPane.add(lblAmount);
		
		amount = new JTextField();
		amount.setBounds(744, 72, 86, 20);
		contentPane.add(amount);
		amount.setColumns(10);
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			
			public  void actionPerformed(ActionEvent arg0) {
				
				Sales.y= Sales.y+30;
				/*JTextField billnot = new JTextField();
				billnot.setName("abc");
				billnot.setBounds(126, Sales.y, 91, 20);
				contentPane.add(billnot);
				billnot.setColumns(11);
				billnot.setVisible(true);*/
				//JTextField bill=billno;
				
				JComboBox productnamet = new JComboBox(CommonUtil.getProductName());
				productnamet.setBounds(210, Sales.y, 108, 20);
				contentPane.add(productnamet);
				
				JTextField quantityt = new JTextField();
				quantityt.setBounds(348, Sales.y, 86, 20);
				contentPane.add(quantityt);
				quantityt.setColumns(11);
				
				JTextField gramt = new JTextField();
				gramt.setBounds(444, Sales.y, 86, 20);
				contentPane.add(gramt);
				gramt.setColumns(10);
				
				JComboBox unitt = new JComboBox(CommonUtil.getAllunit());
				unitt.setBounds(537, Sales.y, 86, 20);
				contentPane.add(unitt);
				
				JTextField discountt = new JTextField();
				discountt.setBounds(633, Sales.y, 86, 20);
				
				
				contentPane.add(discountt);
				discountt.setColumns(10);
				
				JTextField amountt = new JTextField();
				amountt.setBounds(744, Sales.y, 86, 20);
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
					Sales.y=Sales.y-30;
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
				btnNewButton.setBounds(841, Sales.y, 86, 20);
				contentPane.add(btnNewButton);
				
			
				//add arraylist to get all components
				List<Component> list=new ArrayList<Component>();
				//list.add(billnot);
				list.add(productnamet);
				list.add(quantityt);
				list.add(gramt);
				list.add(unitt);
				list.add(discountt);
				list.add(amountt);
				//list.add(chckbxCheck);
				list.add(btnNewButton);
				//System.out.println(list);
				discountt.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent arg0) {
					double amt;
					try {
						amt = prcentageCal(Double.parseDouble(discountt.getText()),Float.parseFloat(gramt.getText()));
						amountt.setText(amt+"");
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
						
					}
				});
				
				Sales.map.put(keyset, list);
				keyset++;
				
				
			}
		});
		btnAdd.setBounds(841, 71, 89, 23);
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
				
				
				
				try {
					String query="insert into sales(Date,ProductId,Quantity,Gram,UnitId,Discount,Amount,VendorId,CatId,CustomerId,RateId,TaxId) values(?,?,?,?,?,?,?,0,0,0,0,0)";
					Statement tm =DbConnection.getconnection().createStatement();
					PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
					//pt.setString(1, billno.getText());
					
					java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
					pt.setTimestamp(1, date);
					DropDownItem itemprod = (DropDownItem)productname.getSelectedItem();
					pt.setInt(2, itemprod.getId());
					pt.setString(3, quantity.getText());
					pt.setString(4, gram.getText());
					DropDownItem itemunit = (DropDownItem)unit.getSelectedItem();
					pt.setInt(5, itemunit.getId());
					pt.setString(6, discount.getText());
					pt.setString(7, amount.getText());
					
					pt.execute();
					
					for(int i=1;i<keyset;i++)
					{
						 pt=DbConnection.getconnection().prepareStatement(query);
					List<Component> lis=(List<Component>)map.get(i);
					int j=0;
					
					//for(Component c: lis)
						//{
					java.sql.Timestamp date1 = new java.sql.Timestamp(new java.util.Date().getTime());
					pt.setTimestamp(1, date1);
					
							/*String bill=((JTextField)c).getText();
							pt.setString(1, bill);
					j++;*/
					
							
							
							
					Component c=lis.get(j);
							DropDownItem proditem = (DropDownItem)((JComboBox)c).getSelectedItem();
							pt.setInt(2, proditem.getId());
						    j++;
						    
						    c=lis.get(j);
							String quan=((JTextField)c).getText();
							pt.setString(3, quan);
						    j++;	
						
							c=lis.get(j);
							String grmt=((JTextField)c).getText();
							pt.setString(4, grmt);
						    j++;
					    
						    c=lis.get(j);
							DropDownItem unit = (DropDownItem)((JComboBox)c).getSelectedItem();
							pt.setInt(5, unit.getId());
							j++;
							
							c=lis.get(j);
							String discountt=((JTextField)c).getText();
							pt.setString(6, discountt);
						    j++;
						
						
						    c=lis.get(j);
							String amt=((JTextField)c).getText();
							pt.setString(7, amt);
						    j++;
						
					
						//}
						pt.execute();
						
					}
					
					//billno.setText("");
					//itemprod.getId();
					quantity.setText("");
					//itemunit.getId();
					amount.setText("");
					gram.setText("");
					discount.setText("");
					//dateChooser.setCalendar(null);
					dateChooser.setCalendar(null);
					
					
					try {
						framesale.setVisible(false);
						framesale = new Sales();
						framesale.setVisible(true);
						framesale.setTitle("Sales Page");
						SwingUtilities.updateComponentTreeUI(framesale);
						framesale.repaint();
						framesale.revalidate();
						//frametax.getContentPane().repaint();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Document doc=new Document();
				try {
					PdfWriter.getInstance(doc, new FileOutputStream("report.pdf")) ;
					doc.open();
					doc.add(new Paragraph("heading"));
					doc.add(new Paragraph(new Date().toString()));
					PdfPTable tb=new PdfPTable(2);
					tb.addCell("quantity");
					tb.addCell("gram");
					tb.addCell("discount");
					doc.add(tb);
					/*doc.add(new Paragraph(gram.getText().toString()));
					doc.add(new Paragraph(discount.getText().toString()));
					doc.add(new Paragraph(amount.getText().toString()));*/
					doc.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(943, 72, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*Viewpage.main(new String[]{});
	       		setVisible(false);*/
				Viewpage frame = new Viewpage();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(10, 7, 89, 23);
		contentPane.add(btnBack);
		
		
		
		
		
	}
	
	
	public static double prcentageCal(double dis,float grm) throws SQLException
	{
	  double rateamt=Rate.getRate();
	  double totalgrmamt = grm * rateamt ;
	  double totalDisAmt = totalgrmamt % dis;
	  double totalamtincal = totalgrmamt-totalDisAmt;
	  
	return totalamtincal;
	  
	 
	}

	
}

