package Java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import DB.DbConnection;
import model.ButtonEditor;
import model.ButtonRenderer;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;

public class Customer extends JFrame {

	private JPanel contentPane;
	private JTextField CustomerName;
	private JTextField customeremail;
	private JTextField pin;
	private JTextField customerevent;
	private JTextField cuscontactNo;
	private JTable custable;
    static private Customer framecus;
    static private JDateChooser dateChooser, eventdate;
    static private JTextArea textArea;
    static private JRadioButton rdbtnMale,rdbtnFemale;
    static private int cusId=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					framecus = new Customer();
					framecus.setVisible(true);
					framecus.setTitle("Customer Page");
					SwingUtilities.updateComponentTreeUI(framecus);
					framecus.repaint();
					framecus.revalidate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Customer() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 1331);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerDetails = new JLabel("Customer Details");
		lblCustomerDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCustomerDetails.setBounds(703, 11, 167, 25);
		contentPane.add(lblCustomerDetails);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(605, 76, 46, 14);
		contentPane.add(lblDate);
		
		 dateChooser = new JDateChooser();
		Date date = new Date();
		dateChooser.setDate(date);
		dateChooser.setBounds(745, 70, 151, 20);
		contentPane.add(dateChooser);
		
		JLabel lblCustomername = new JLabel("CustomerName");
		lblCustomername.setBounds(605, 121, 116, 14);
		contentPane.add(lblCustomername);
		
		CustomerName = new JTextField();
		CustomerName.setBounds(745, 118, 151, 20);
		contentPane.add(CustomerName);
		CustomerName.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(605, 189, 116, 14);
		contentPane.add(lblAddress);
		
		 textArea = new JTextArea();
		textArea.setBounds(745, 164, 151, 63);
		contentPane.add(textArea);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(605, 278, 116, 14);
		contentPane.add(lblEmail);
		
		customeremail = new JTextField();
		customeremail.setBounds(745, 275, 151, 20);
		contentPane.add(customeremail);
		customeremail.setColumns(10);
		
		JLabel lblAatharId = new JLabel("Pin");
		lblAatharId.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAatharId.setBounds(605, 309, 116, 14);
		contentPane.add(lblAatharId);
		
		pin = new JTextField();
		pin.setBounds(745, 306, 151, 20);
		contentPane.add(pin);
		pin.setColumns(10);
		
		JLabel lblEvent = new JLabel("Event");
		lblEvent.setBounds(605, 346, 46, 14);
		contentPane.add(lblEvent);
		
		customerevent = new JTextField();
		customerevent.setBounds(745, 343, 151, 20);
		contentPane.add(customerevent);
		customerevent.setColumns(10);
		
		JLabel lblEventDate = new JLabel("Event Date");
		lblEventDate.setBounds(605, 390, 116, 14);
		contentPane.add(lblEventDate);
		
		 eventdate = new JDateChooser();	
		eventdate.setBounds(745, 384, 154, 20);
		contentPane.add(eventdate);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(605, 253, 116, 14);
		contentPane.add(lblGender);
		
		 rdbtnMale = new JRadioButton("male");
		rdbtnMale.setBounds(745, 245, 67, 23);
		contentPane.add(rdbtnMale);
		
		 rdbtnFemale = new JRadioButton("female");
		rdbtnFemale.setBounds(814, 245, 105, 23);
		contentPane.add(rdbtnFemale);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMale);
		group.add(rdbtnFemale);
		
		JButton customersubmit = new JButton("Submit");
		customersubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query="insert into customer(CustomerName,Address,Pin,ContactNo,Email,Date,EventDate,Event,Gender) values(?,?,?,?,?,?,?,?,?)";
					Statement tm =DbConnection.getconnection().createStatement();
					PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
					
					pt.setString(1, CustomerName.getText());
					pt.setString(2, textArea.getText());
					pt.setString(3, pin.getText());
					pt.setString(4, cuscontactNo.getText());
					pt.setString(5, customeremail.getText());
					pt.setDate(6,new java.sql.Date(dateChooser.getDate().getTime()));
					pt.setDate(7,new java.sql.Date(eventdate.getDate().getTime()));
					pt.setString(8, customerevent.getText());
					String gender="";
					{
					if(rdbtnMale.isSelected()) 
				        gender="Male";
				    else if(rdbtnFemale.isSelected()) 
				        gender="Female";
					}
					pt.setString(9, gender);
					pt.execute();
					CustomerName.setText("");
					textArea.setText("");
					pin.setText("");
					customeremail.setText("");
					customerevent.setText("");
					cuscontactNo.setText("");
					dateChooser.setCalendar(null);
					eventdate.setCalendar(null);
					group.clearSelection();
					
					
					try {
						framecus.setVisible(false);
						framecus = new Customer();
						framecus.setVisible(true);
						framecus.setTitle("Customer Page");
						SwingUtilities.updateComponentTreeUI(framecus);
						framecus.repaint();
						framecus.revalidate();
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
		customersubmit.setBounds(792, 472, 89, 23);
		contentPane.add(customersubmit);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Viewpage frame = new Viewpage();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(34, 11, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setBounds(605, 429, 105, 14);
		contentPane.add(lblContactNo);
		
		cuscontactNo = new JTextField();
		cuscontactNo.setBounds(745, 429, 151, 20);
		contentPane.add(cuscontactNo);
		cuscontactNo.setColumns(10);
		
		
		
		
		
		//grid view
		try{
			String[] str={"Sl No","CustomerId","CustomerName","Address","Pin","Gender","ContactNo","Email","Date","EventDate","Event","Edit","Del"};
			int count =100;
			String sql="SELECT CustomerId,CustomerName, Address, Pin, Gender, ContactNo, Email, Date, EventDate, Event FROM customer";
			String sqlCou="SELECT count(*) cu FROM customer";
			
			 Statement st;
				st = DbConnection.getconnection().createStatement();
				ResultSet rs = st.executeQuery(sqlCou);
				while(rs.next())
				{
					count = rs.getInt("cu");
				}
				st = DbConnection.getconnection().createStatement();
				 rs = st.executeQuery(sql);
				
				//Vector row = new Vector();
				Object[][] data=new Object[count][13];
				int k=0;
				while(rs.next())
				{
					int j=0;
					data[k][j]=k+1;
					j++;
					int	CustomerId= rs.getInt("CustomerId");
					data[k][j]=CustomerId;
					j++;
				String	CustomerName= rs.getString("CustomerName");
				data[k][j]=CustomerName;
				j++;
				String	Address= rs.getString("Address");
				data[k][j]=Address;
				j++;
				String 	 Pin=rs.getString("Pin");
				data[k][j]=Pin;
				j++;
				String 	 Gender=rs.getString("Gender");
				data[k][j]=Gender;
				j++;
				String 	 ContactNo=rs.getString("ContactNo");
				data[k][j]=ContactNo;
				j++;
				String 	 Email=rs.getString("Email");
				data[k][j]=Email;
				j++;
				String 	 Date=rs.getString("Date");
				data[k][j]=Date;
				j++;
				String 	 EventDate=rs.getString("EventDate");
				data[k][j]=EventDate;
				j++;
				String 	 Event=rs.getString("Event");
				data[k][j]=Event;
				j++;
				/*String 	 Status=rs.getString("Status");
				data[k][j]=Status;
				j++;*/
				//JButton btnEdit = new JButton("EDIT");
			    data[k][j]="EDIT";
			    j++;
			   // JButton btnDel = new JButton("DEL");
			    data[k][j]="DELETE";
			    k++;
				} 
				custable = new JTable(data,str);
				/*int rows =str.length;
				
				custable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						int index = 0; 
						custable.setRowSelectionInterval(index, index);
						custable.setBackground(new Color(153, 255, 153));
					}
				});*/
				/*custable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			    ListSelectionModel model=custable.getSelectionModel();
			    model.addListSelectionListener(new ListSelectionListener() {

			        @Override
			        public void valueChanged(ListSelectionEvent e) {

			          // JUST IGNORE WHEN USER HAS ATLEAST ONE SELECTION
			          if(e.getValueIsAdjusting())
			          {
			            return;
			          }
			          ListSelectionModel lsm=(ListSelectionModel) e.getSource();

			          if(lsm.isSelectionEmpty())
			          {
			            JOptionPane.showMessageDialog(null, "No selection");
			          }else
			          {
			            int selectedRow=lsm.getMinSelectionIndex();
			            JOptionPane.showMessageDialog(null, "Selected Row "+selectedRow);
			          }
			        }
			      });*/
				custable.setBounds(0,0, 1400, 1330);
				
				
				custable.getColumnModel().getColumn(11).setCellRenderer(new ButtonRenderer());
				custable.getColumnModel().getColumn(11).setCellEditor(new ButtonEditor(new JCheckBox()));
				custable.getColumnModel().getColumn(12).setCellRenderer(new ButtonRenderer());
				custable.getColumnModel().getColumn(12).setCellEditor(new ButtonEditor(new JCheckBox()));
				custable.setBounds(0,0, 1400, 1330);
				
				custable.getColumn("CustomerId").setWidth(0);
				custable.getColumn("CustomerId").setMinWidth(0);
				custable.getColumn("CustomerId").setMaxWidth(0);
				
				
				custable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		            public void valueChanged(ListSelectionEvent event) {
		            	 
		            	 try {
							String co=custable.getValueAt(custable.getSelectedRow(), 1).toString();
							//System.out.println(Taxtable.getValueAt(Taxtable.getSelectedRow(), 0).toString());
       // System.out.println( Taxtable.getSelectedColumn() +" ,"+Taxtable.getSelectedRowCount());
							try {
								if(custable.getSelectedColumn()==11){
									cusId=Integer.parseInt(custable.getValueAt(custable.getSelectedRow(), 1)+"");
								String tx="select * from customer where CustomerId="+custable.getValueAt(custable.getSelectedRow(), 1);
								Statement tm =DbConnection.getconnection().createStatement();
								ResultSet rs=tm.executeQuery(tx);
								while(rs.next())
								{ 
									
									CustomerName.setText(rs.getString("CustomerName")+"");
									textArea.setText(rs.getString("Address")+"");
									pin.setText(rs.getString("Pin")+"");
									Enumeration enu=group.getElements();
									while(enu.hasMoreElements()){
										JRadioButton btR=(JRadioButton)enu.nextElement();
										System.out.println(btR.getText());
										if(btR.getText().equalsIgnoreCase(rs.getString("Gender")))
										{
											btR.setSelected(true);
										}
									}
									cuscontactNo.setText(rs.getString("ContactNo")+"");
									/*java.util.Date utilDate = new java.util.Date();
									java.sql.Date sd = new java.sql.Date(utilDate.getTime())*/;
									customeremail.setText(rs.getString("Email")+"");
									dateChooser.setDateFormatString(rs.getString("Date")+"");
									eventdate.setDateFormatString(rs.getString("EventDate")+"");
									customerevent.setText(rs.getString("Event")+"");
									
									//ButtonGroup model = (ButtonGroup)group.getSelection();
									
									//gender.setSelectedItem(rs.getString("Gender")+"");
									//rs.getInt("SGST");
								}
								}
								if(custable.getSelectedColumn()==12){
									String tx="delete from customer where CustomerId="+custable.getValueAt(custable.getSelectedRow(), 1);
								//	System.out.println(tx);
									Statement tm =DbConnection.getconnection().createStatement();
									tm.execute(tx);
									//Taxtable.remove(Taxtable.getSelectedRowCount());
									System.out.println(custable.getRowCount());
									for(int t =custable.getSelectedRow();t <custable.getRowCount();t++){
										System.out.println(t +" tt");
										for(int y=1;y>8;y++){
											
											if((t+1)!=custable.getRowCount()){
												custable.getModel().setValueAt(custable.getValueAt(t+1, y), t, y);
											}else{
												custable.getModel().setValueAt("", t, y);	
												custable.getModel().setValueAt("", t, 0);	
											}
										}
										System.out.println(t +" tt end");
										try {
											framecus.setVisible(false);
											framecus = new Customer();
											framecus.setVisible(true);
											framecus.setTitle("Customer Page");
											SwingUtilities.updateComponentTreeUI(framecus);
											framecus.repaint();
											framecus.revalidate();
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
							
							custable.clearSelection();
							custable.repaint();
							custable.revalidate();
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}
		            	// DefaultTableModel md=DefaultTableModel
		            	// Taxtable.fireTableDataChanged();
		            } 
		           
		        });
				
				
		        JScrollPane scrollPane = new JScrollPane(custable);
		       
		        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
		        scrollPane.setVisible(true);
		        getContentPane().add(scrollPane);
		        scrollPane.setBounds(20,523, 1320, 173);
		        custable.setFillsViewportHeight(true);
		       getContentPane().add(scrollPane,BorderLayout.CENTER);
		       
		       JButton btnUpdate = new JButton("Update");
		       btnUpdate.addActionListener(new ActionListener() {
		       	public void actionPerformed(ActionEvent arg0) {
		       		
		       		
					try {
						String query="update customer set  CustomerName=?,Address=?,Pin=?,ContactNo=?,Email=?,Date=?,EventDate=?,Event=?,Gender=? where CustomerId="+cusId;
						Statement tm =DbConnection.getconnection().createStatement();
						PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
						
						pt.setString(1, CustomerName.getText());
						pt.setString(2, textArea.getText());
						pt.setString(3, pin.getText());
						pt.setString(4, cuscontactNo.getText());
						pt.setString(5, customeremail.getText());
						pt.setDate(6,new java.sql.Date(dateChooser.getDate().getTime()));
						pt.setDate(7,new java.sql.Date(eventdate.getDate().getTime()));
						pt.setString(8, customerevent.getText());
						String gender="";
						{
						if(rdbtnMale.isSelected()) 
					        gender="Male";
					    else if(rdbtnFemale.isSelected()) 
					        gender="Female";
						}
						pt.setString(9, gender);
						pt.execute();
						CustomerName.setText("");
						textArea.setText("");
						pin.setText("");
						customeremail.setText("");
						customerevent.setText("");
						cuscontactNo.setText("");
						dateChooser.setCalendar(null);
						eventdate.setCalendar(null);
						group.clearSelection();
						
						cusId=0;
						try {
							framecus.setVisible(false);
							framecus = new Customer();
							framecus.setVisible(true);
							framecus.setTitle("Customer Page");
							SwingUtilities.updateComponentTreeUI(framecus);
							framecus.repaint();
							framecus.revalidate();
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
		       btnUpdate.setBounds(675, 472, 89, 23);
		       contentPane.add(btnUpdate);
		        setVisible(true);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
	}
}
