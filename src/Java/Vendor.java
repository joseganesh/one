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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
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
import model.ButtonEditor;
import model.ButtonRenderer;
import model.DropDownItem;
import javax.swing.JTable;

public class Vendor extends JFrame {

	static private JPanel contentPane;
	static private JTextField vendorcode;
	static private JTextField vendorname;
	static private JTextField vendorcontactno;
	static private JTextField vendoraatharno;
	static	private JTable vendortable;
	static private JTextArea vendoraddress;
	static private JComboBox vendorstatus;
	static private JDateChooser dateChooser;
	static Vendor framevendor;
	static private int venId=0;
	DefaultTableModel dft = new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*Vendor frame = new Vendor();
					frame.setVisible(true);
					frame.setTitle("Vendor Page");*/
					
					framevendor = new Vendor();
					framevendor.setVisible(true);
					framevendor.setTitle("Vendor Page");
					SwingUtilities.updateComponentTreeUI(framevendor);
					framevendor.repaint();
					framevendor.revalidate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vendor() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 1331);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVendorDetails = new JLabel("Vendor Details");
		lblVendorDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVendorDetails.setBounds(590, 11, 132, 31);
		contentPane.add(lblVendorDetails);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(494, 70, 82, 14);
		contentPane.add(lblDate);
		
		dateChooser = new JDateChooser();
		Date date = new Date();
		dateChooser.setDate(date);
		dateChooser.setBounds(636, 64, 167, 20);
		contentPane.add(dateChooser);
		
		JLabel VendorId = new JLabel("Vendor Id");
		VendorId.setBounds(497, 100, 79, 14);
		contentPane.add(VendorId);
		
		vendorcode = new JTextField();
		vendorcode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!Validation.textnum(vendorcode.getText())){
					JOptionPane.showMessageDialog(null, "Enter the vendorcode");
					vendorcode.requestFocus();
				}
			}
		});
		vendorcode.setBounds(636, 97, 167, 20);
		contentPane.add(vendorcode);
		vendorcode.setColumns(10);
		
		JLabel lblVendorName = new JLabel("Vendor Name");
		lblVendorName.setBounds(497, 139, 79, 14);
		contentPane.add(lblVendorName);
		
		vendorname = new JTextField();
		vendorname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!Validation.text(vendorname.getText())){
					JOptionPane.showMessageDialog(null, "Enter the name");
					vendorname.requestFocus();
				}
			}
		});
		vendorname.setBounds(636, 136, 167, 20);
		contentPane.add(vendorname);
		vendorname.setColumns(10);
		
		JLabel Address = new JLabel("Address");
		Address.setBounds(497, 194, 79, 14);
		contentPane.add(Address);
		
		vendoraddress = new JTextArea();
		/*vendoraddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!Validation.textnum(vendoraddress.getText())){
					JOptionPane.showMessageDialog(null, "Enter the address");
					vendoraddress.requestFocus();
				}
			}
		});*/
		vendoraddress.setBounds(636, 167, 167, 77);
		contentPane.add(vendoraddress);
		
		JLabel ContactNo = new JLabel("Contact No");
		ContactNo.setBounds(497, 273, 79, 14);
		contentPane.add(ContactNo);
		
		vendorcontactno = new JTextField();
		vendorcontactno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!Validation.number(vendorcontactno.getText())){
					JOptionPane.showMessageDialog(null, "Enter only Numbers");
					vendorcontactno.requestFocus();
				}
			}
		});
		vendorcontactno.setBounds(636, 270, 167, 20);
		contentPane.add(vendorcontactno);
		vendorcontactno.setColumns(10);
		
		JLabel lblAatharNo = new JLabel("Aathar No");
		lblAatharNo.setBounds(497, 319, 79, 14);
		contentPane.add(lblAatharNo);
		
		vendoraatharno = new JTextField();
		vendoraatharno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!Validation.number(vendoraatharno.getText())){
					JOptionPane.showMessageDialog(null, "Enter only Numbers");
					vendoraatharno.requestFocus();
				}
			}
		});
		vendoraatharno.setBounds(636, 313, 167, 20);
		contentPane.add(vendoraatharno);
		vendoraatharno.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(497, 364, 79, 14);
		contentPane.add(lblStatus);
		
		 Vector model = new Vector();
	        model.addElement( new DropDownItem(1, "Active" ) );
	        model.addElement( new DropDownItem(2, "Deactive" ) );
	        
		
		 vendorstatus = new JComboBox(model);
		vendorstatus.setBounds(636, 361, 167, 20);
		getContentPane().add(vendorstatus);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Viewpage.main(new String[]{});
				setVisible(false);
			}
		});
		btnBack.setBounds(0, 0, 89, 23);
		contentPane.add(btnBack);
		
		
		JButton VendorSubmit = new JButton("Submit");
		VendorSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query="insert into vendor(VendorCode,VendorName,Address,AatharNo,ContactNo,Status,Date) values(?,?,?,?,?,?,?)";
					Statement tm =DbConnection.getconnection().createStatement();
					PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
					pt.setString(1, vendorcode.getText());
					pt.setString(2, vendorname.getText());
					pt.setString(3, vendoraddress.getText());
					pt.setString(4, vendoraatharno.getText());
					pt.setString(5, vendorcontactno.getText());
					DropDownItem item = (DropDownItem)vendorstatus.getSelectedItem();
					  String status=  item.getId()==1?"A":"D";
					pt.setString(6, status);
					pt.setDate(7,new java.sql.Date(dateChooser.getDate().getTime()));
					
					
					pt.execute();
					vendorcode.setText("");
					vendorname.setText("");
					vendoraddress.setText("");
					vendoraatharno.setText("");
					vendorcontactno.setText("");
					status.isEmpty();
					dateChooser.setCalendar(null);
					
					try {
						framevendor.setVisible(false);
						framevendor = new Vendor();
						framevendor.setVisible(true);
						framevendor.setTitle("Vendor Page");
						SwingUtilities.updateComponentTreeUI(framevendor);
						framevendor.repaint();
						framevendor.revalidate();
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
		VendorSubmit.setBounds(664, 400, 89, 23);
		contentPane.add(VendorSubmit);
		
		
		
		//grid view
		try{
			
			String[] str={"Sl No","VendorId","VendorCode","VendorName","Address","AatharNo","ContactNo","Status","Date","Edit","DEL"};
			int count =100;
			String sql="SELECT VendorId, VendorCode, VendorName, Address, AatharNo, ContactNo, Status, Date FROM vendor";
			String sqlCou="SELECT count(*) v FROM vendor";
			
			 Statement st;
				st = DbConnection.getconnection().createStatement();
				ResultSet rs = st.executeQuery(sqlCou);
				while(rs.next())
				{
					count = rs.getInt("v");
				}
				st = DbConnection.getconnection().createStatement();
				 rs = st.executeQuery(sql);
				
				//Vector row = new Vector();
				Object[][] data=new Object[count][11];
				int k=0;
				while(rs.next())
				{
					 int j=0;
					 data[k][j]=k+1;
					j++;
				int	VendorsID= rs.getInt("VendorId");
				data[k][j]=VendorsID;
				j++;
				String	VendorCode= rs.getString("VendorCode");
				data[k][j]=VendorCode;
				j++;
				String	VendorName= rs.getString("VendorName");
				data[k][j]=VendorName;
				j++;
				String	address= rs.getString("Address");
				data[k][j]=address;
				j++;
				String 	 AatharNo=rs.getString("AatharNo");
				data[k][j]=AatharNo;
				j++;
				String 	 contactNo=rs.getString("ContactNo");
				data[k][j]=contactNo;
				j++;
				String 	 Status=rs.getString("Status");
				data[k][j]=Status;
				j++;
				String 	 Date=rs.getString("Date");
				data[k][j]=Date;
				j++;
				//JButton btnEdit = new JButton("EDIT");
			    data[k][j]="Edit";
			    j++;
			    //JButton btnDel = new JButton("DEL");
			    data[k][j]="Delete";
			    k++;
				} 
				vendortable = new JTable(data,str);
				//to create an button inside the jtable
				vendortable.getColumnModel().getColumn(9).setCellRenderer(new ButtonRenderer());
				vendortable.getColumnModel().getColumn(9).setCellEditor(new ButtonEditor(new JCheckBox()));
				vendortable.getColumnModel().getColumn(10).setCellRenderer(new ButtonRenderer());
				vendortable.getColumnModel().getColumn(10).setCellEditor(new ButtonEditor(new JCheckBox()));
				
				//to hide the RateId column in the jtable
				vendortable.getColumn("VendorId").setWidth(0);
				vendortable.getColumn("VendorId").setMinWidth(0);
				vendortable.getColumn("VendorId").setMaxWidth(0);
				
				vendortable.setBounds(0,0, 1400, 1330);
		        JScrollPane scrollPane = new JScrollPane(vendortable);
		        scrollPane.setBounds(10,500, 1350, 191);
		        vendortable.setFillsViewportHeight(true);
		        
		        
		        vendortable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			            public void valueChanged(ListSelectionEvent event) {
			            	
			            	 //String co=RATEtable.getValueAt(RATEtable.getSelectedRow(), 0).toString();
			               // System.out.println(RATEtable.getValueAt(RATEtable.getSelectedRow(), 0).toString());

			            	 
			            	 try {
								String co=vendortable.getValueAt(vendortable.getSelectedRow(), 1).toString();
								//System.out.println(Taxtable.getValueAt(Taxtable.getSelectedRow(), 0).toString());
	      // System.out.println( Taxtable.getSelectedColumn() +" ,"+Taxtable.getSelectedRowCount());
								try {
									if(vendortable.getSelectedColumn()==9){
										venId=Integer.parseInt(vendortable.getValueAt(vendortable.getSelectedRow(), 1)+"");
									String tx="select * from vendor where VendorId="+vendortable.getValueAt(vendortable.getSelectedRow(), 1);
									Statement tm =DbConnection.getconnection().createStatement();
									ResultSet rs=tm.executeQuery(tx);
									while(rs.next())
									{ 
										vendorcode.setText(rs.getString("VendorCode")+"");
										vendorname.setText(rs.getString("VendorName")+"");
										vendoraddress.setText(rs.getString("Address")+"");
										vendorcontactno.setText(rs.getLong("ContactNo")+"");
										vendoraatharno.setText(rs.getLong("AatharNo")+"");
										int s=rs.getString("Status").equals("A")?1:2;
										DropDownItem sObj=DropDownItem.finById(vendorstatus,s);
										vendorstatus.setSelectedItem(sObj);
										dateChooser.setDateFormatString(rs.getString("Date")+"");
										
									}
									}
									if(vendortable.getSelectedColumn()==10){
										String tx="delete from vendor where VendorId="+vendortable.getValueAt(vendortable.getSelectedRow(), 1);
									//	System.out.println(tx);
										Statement tm =DbConnection.getconnection().createStatement();
										tm.execute(tx);
										//Taxtable.remove(Taxtable.getSelectedRowCount());
										System.out.println(vendortable.getRowCount());
										for(int t =vendortable.getSelectedRow();t <vendortable.getRowCount();t++){
											System.out.println(t +" tt");
											for(int y=1;y<8;y++){
												
												if((t+1)!=vendortable.getRowCount()){
													vendortable.getModel().setValueAt(vendortable.getValueAt(t+1, y), t, y);
												}else{
													vendortable.getModel().setValueAt("", t, y);	
													vendortable.getModel().setValueAt("", t, 0);	
												}
											}
											System.out.println(t +" tt end");
											try {
												framevendor.setVisible(false);
												framevendor = new Vendor();
												framevendor.setVisible(true);
												framevendor.setTitle("Vendor Page");
												SwingUtilities.updateComponentTreeUI(framevendor);
												framevendor.repaint();
												framevendor.revalidate();
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
								
								vendortable.clearSelection();
								vendortable.repaint();
								vendortable.revalidate();
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
							}
			            	// DefaultTableModel md=DefaultTableModel
			            	// Taxtable.fireTableDataChanged();
			            
			                
			                
			            }
			        });
		        
		       getContentPane().add(scrollPane,BorderLayout.CENTER);
		       
		       JButton btnUpdate = new JButton("Update");
		       btnUpdate.addActionListener(new ActionListener() {
		       	public void actionPerformed(ActionEvent arg0) {
		       		
		       		try {
						String query="update vendor set VendorCode=?,VendorName=?,Address=?,AatharNo=?,ContactNo=?,Status=?,Date=? where VendorId="+venId;
						Statement tm =DbConnection.getconnection().createStatement();
						PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
						pt.setString(1, vendorcode.getText());
						pt.setString(2, vendorname.getText());
						pt.setString(3, vendoraddress.getText());
						pt.setString(4, vendoraatharno.getText());
						pt.setString(5, vendorcontactno.getText());
						DropDownItem item = (DropDownItem)vendorstatus.getSelectedItem();
						  String status=  item.getId()==1?"A":"D";
						pt.setString(6, status);
						pt.setDate(7,new java.sql.Date(dateChooser.getDate().getTime()));
						
						
						pt.execute();
						vendorcode.setText("");
						vendorname.setText("");
						vendoraddress.setText("");
						vendoraatharno.setText("");
						vendorcontactno.setText("");
						status.isEmpty();
						dateChooser.setCalendar(null);
						
						venId =0;
						try {
							framevendor.setVisible(false);
							framevendor = new Vendor();
							framevendor.setVisible(true);
							framevendor.setTitle("Vendor Page");
							SwingUtilities.updateComponentTreeUI(framevendor);
							framevendor.repaint();
							framevendor.revalidate();
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
		       btnUpdate.setBounds(533, 400, 89, 23);
		       contentPane.add(btnUpdate);
		        setVisible(true);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
	}
}
