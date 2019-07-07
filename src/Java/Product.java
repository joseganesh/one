package Java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import DB.DbConnection;
import ValidationUtil.Validation;
import jewelleryUtil.CommonUtil;
import jewelleryUtil.IdtoNameUtil;
import model.ButtonEditor;
import model.ButtonRenderer;
import model.DropDownItem;
import javax.swing.JTable;

public class Product extends JFrame {

	private JPanel contentPane;
	private JTextField productId;
	private JTextField productname;
	private JTable producttable;
	static private  Product prod;
	static private int prodId=0;
	static private JComboBox productstatus ;
	static private JDateChooser dateChooser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prod = new Product();
					prod.setVisible(true);
					prod.setTitle("Product Page");
					SwingUtilities.updateComponentTreeUI(prod);
					prod.repaint();
					prod.revalidate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Product() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 1331);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProductDetails = new JLabel("Product Details");
		lblProductDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProductDetails.setBounds(646, 24, 151, 20);
		contentPane.add(lblProductDetails);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(295, 95, 85, 14);
		contentPane.add(lblDate);
		
		 dateChooser = new JDateChooser();
		 dateChooser.setDateFormatString("dd-MM-yyyy");
		Date date = new Date();
		dateChooser.setDate(date);
		dateChooser.setBounds(243, 120, 132, 20);
		contentPane.add(dateChooser);
		
		JLabel lblCategory = new JLabel("Category");
	       lblCategory.setBounds(416, 95, 58, 14);
	       contentPane.add(lblCategory);
	       
	       JComboBox category = new JComboBox(CommonUtil.getAllCatageory());
	       category.setBounds(385, 120, 124, 20);
	       contentPane.add(category);
	        setVisible(true);
		
		JLabel lblProductId = new JLabel("Product code");
		lblProductId.setBounds(551, 95, 85, 14);
		contentPane.add(lblProductId);
		
		productId = new JTextField();
		productId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!Validation.textnum(productId.getText())){
					JOptionPane.showMessageDialog(null, "Enter the product code");
					productId.requestFocus();
				}
			}
		});
		productId.setBounds(519, 120, 132, 20);
		contentPane.add(productId);
		productId.setColumns(10);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(680, 95, 85, 14);
		contentPane.add(lblProductName);
		
		productname = new JTextField();
		productname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!Validation.text(productname.getText())){
					JOptionPane.showMessageDialog(null, "Enter the product name");
					productname.requestFocus();
				}
			}
		});
		productname.setBounds(661, 120, 134, 20);
		contentPane.add(productname);
		productname.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(808, 95, 85, 14);
		contentPane.add(lblStatus);
		
		 Vector model = new Vector();
	        model.addElement( new DropDownItem(1, "Active" ) );
	        model.addElement( new DropDownItem(2, "Deactive" ) );
	        
		productstatus = new JComboBox(model);
		productstatus.setBounds(800, 120, 132, 20);
		getContentPane().add(productstatus);
		
		JButton productSubmit = new JButton("Submit");
		productSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="insert into product(ProductCode,ProductName,Status,Date,CatId) values(?,?,?,?,?)";
					Statement tm =DbConnection.getconnection().createStatement();
					PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
					pt.setString(1, productId.getText());
					pt.setString(2, productname.getText());
					DropDownItem item = (DropDownItem)productstatus.getSelectedItem();
					  String status=  item.getId()==1?"A":"D";
					pt.setString(3, status);
					pt.setDate(4,new java.sql.Date(dateChooser.getDate().getTime()));
					DropDownItem cat = (DropDownItem)category.getSelectedItem();
					pt.setInt(5, cat.getId());
					pt.execute();
					productId.setText("");
					productname.setText("");
					status.isEmpty();
					dateChooser.setCalendar(null);
					
					try {
						prod.setVisible(false);
						prod = new Product();
						prod.setVisible(true);
						prod.setTitle("Product Page");
						SwingUtilities.updateComponentTreeUI(prod);
						prod.repaint();
						prod.revalidate();
						//frametax.getContentPane().repaint();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		productSubmit.setBounds(1050, 117, 89, 23);
		contentPane.add(productSubmit);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Viewpage frame = new Viewpage();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
		
		
		
		
		
		//grid view
				try{
					
					String[] str={"Sl No","ProductId","ProductCode","ProductName","Status","Date","Category","Edit","DEL"};
					int count =100;
					String sql="SELECT ProductId, ProductCode, ProductName, Status, Date , CatId FROM product";
					String sqlCou="SELECT count(*) p FROM product";
					
					 Statement st;
						st = DbConnection.getconnection().createStatement();
						ResultSet rs = st.executeQuery(sqlCou);
						while(rs.next())
						{
							count = rs.getInt("p");
						}
						st = DbConnection.getconnection().createStatement();
						 rs = st.executeQuery(sql);
						
						//Vector row = new Vector();
						Object[][] data=new Object[count][9];
						int k=0;
						while(rs.next())
						{
							int j=0;
							data[k][j]=k+1;
							j++;
							int	ProductId= rs.getInt("ProductId");
							data[k][j]=ProductId;
							j++;
						String	ProductCode= rs.getString("ProductCode");
						data[k][j]=ProductCode;
						j++;
						String	ProductName= rs.getString("ProductName");
						data[k][j]=ProductName;
						j++;
						String 	 Status=rs.getString("Status");
						data[k][j]=Status;
						j++;
						String 	 Date=rs.getString("Date");
						data[k][j]=Date;
						j++;
						String 	 cname=IdtoNameUtil.getcategoryName(rs.getInt("CatId"));
						data[k][j]=cname;
						j++;
						//JButton btnEdit = new JButton("EDIT");
					    data[k][j]="EDIT";
					    j++;
					  //  JButton btnDel = new JButton("DEL");
					    data[k][j]="DELETE";
					    k++;
						} 
						producttable = new JTable(data,str);
						producttable.setBounds(0,0, 1400, 1330);
						
						
						producttable.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
						producttable.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox()));
						producttable.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderer());
						producttable.getColumnModel().getColumn(8).setCellEditor(new ButtonEditor(new JCheckBox()));
						producttable.setBounds(0,0, 1400, 1330);
						
						producttable.getColumn("ProductId").setWidth(0);
						producttable.getColumn("ProductId").setMinWidth(0);
						producttable.getColumn("ProductId").setMaxWidth(0);
						
						
						
						producttable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
				            public void valueChanged(ListSelectionEvent event) {
				            	 
				            	 try {
									String co=producttable.getValueAt(producttable.getSelectedRow(), 1).toString();
									//System.out.println(Taxtable.getValueAt(Taxtable.getSelectedRow(), 0).toString());
		       // System.out.println( Taxtable.getSelectedColumn() +" ,"+Taxtable.getSelectedRowCount());
									try {
										if(producttable.getSelectedColumn()==7){
											prodId=Integer.parseInt(producttable.getValueAt(producttable.getSelectedRow(), 1)+"");
										String tx="select * from product where ProductId="+producttable.getValueAt(producttable.getSelectedRow(), 1);
										Statement tm =DbConnection.getconnection().createStatement();
										ResultSet rs=tm.executeQuery(tx);
										while(rs.next())
										{ 
											
											productId.setText(rs.getString("ProductCode")+"");
											productname.setText(rs.getString("ProductName")+"");
											productstatus.setSelectedItem(rs.getString("Status")+"");
											dateChooser.setDateFormatString(rs.getString("Date")+"");
											//rs.getInt("SGST");
										}
										}
										if(producttable.getSelectedColumn()==8){
											String tx="delete from product where ProductId="+producttable.getValueAt(producttable.getSelectedRow(), 1);
										//	System.out.println(tx);
											Statement tm =DbConnection.getconnection().createStatement();
											tm.execute(tx);
											//Taxtable.remove(Taxtable.getSelectedRowCount());
											System.out.println(producttable.getRowCount());
											for(int t =producttable.getSelectedRow();t <producttable.getRowCount();t++){
												System.out.println(t +" tt");
												for(int y=1;y>8;y++){
													
													if((t+1)!=producttable.getRowCount()){
														producttable.getModel().setValueAt(producttable.getValueAt(t+1, y), t, y);
													}else{
														producttable.getModel().setValueAt("", t, y);	
														producttable.getModel().setValueAt("", t, 0);	
													}
												}
												System.out.println(t +" tt end");
												try {
													prod.setVisible(false);
													prod = new Product();
													prod.setVisible(true);
													prod.setTitle("Product Page");
													SwingUtilities.updateComponentTreeUI(prod);
													prod.repaint();
													prod.revalidate();
													//frametax.getContentPane().repaint();
												} catch (Exception e) {
													e.printStackTrace();
												}
											}
											
											
										
										}
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							        //Taxtable.
									
									producttable.clearSelection();
									producttable.repaint();
									producttable.revalidate();
									
								} catch (Exception e) {
									// TODO Auto-generated catch block
									//e.printStackTrace();
								}
				            	// DefaultTableModel md=DefaultTableModel
				            	// Taxtable.fireTableDataChanged();
				            } 
				           
				        });
						
				        JScrollPane scrollPane = new JScrollPane(producttable);
				        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
				        scrollPane.setVisible(true);
				        getContentPane().add(scrollPane);
				        scrollPane.setBounds(341,211, 763, 220);
				        producttable.setFillsViewportHeight(true);
				       getContentPane().add(scrollPane,BorderLayout.CENTER);
				       
				       JButton btnUpdate = new JButton("Update");
				       btnUpdate.addActionListener(new ActionListener() {
				       	public void actionPerformed(ActionEvent arg0) {
				       		try {
								String query="update product set ProductCode=?,ProductName=?,Status=?,Date=?, CatId=? where ProductId="+prodId;
								Statement tm =DbConnection.getconnection().createStatement();
								PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
								pt.setString(1, productId.getText());
								pt.setString(2, productname.getText());
								DropDownItem item = (DropDownItem)productstatus.getSelectedItem();
								  String status=  item.getId()==1?"A":"D";
								pt.setString(3, status);
								pt.setDate(4,new java.sql.Date(dateChooser.getDate().getTime()));
								DropDownItem cat = (DropDownItem)category.getSelectedItem();
								pt.setInt(5, cat.getId());
								pt.execute();
								productId.setText("");
								productname.setText("");
								status.isEmpty();
								dateChooser.setCalendar(null);
								prodId=0;
								try {
									prod.setVisible(false);
									prod = new Product();
									prod.setVisible(true);
									prod.setTitle("Product Page");
									SwingUtilities.updateComponentTreeUI(prod);
									prod.repaint();
									prod.revalidate();
									//frametax.getContentPane().repaint();
								} catch (Exception e) {
									e.printStackTrace();
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				       		
				       	}
				       });
				       btnUpdate.setBounds(942, 120, 89, 23);
				       contentPane.add(btnUpdate);
				       
				       
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
		
		
		
		
		
		
	}
}
