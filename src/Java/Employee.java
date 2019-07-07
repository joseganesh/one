package Java;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
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
import model.DropDownItem;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;

public class Employee extends JFrame {
	

	static private JPanel contentPane;
	static private JTextField employeename;
	static private JTextField employeecontactno;
	static private JTextField employeeaatharno;
	static private JTextField employeepin;
	static private JTextField employeeemail;
	static private JTable emptable;
	static private Employee frameem ;
	static private int empId=0;
	static private JDateChooser dateChooser,dateChooser_1;
	static private JTextArea employeeaddress;
	static private JRadioButton rdbtnMale,rdbtnFemale;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			 	
			 	
					frameem = new Employee();
					frameem.setVisible(true);
					frameem.setTitle("Employee Page");
					SwingUtilities.updateComponentTreeUI(frameem);
					frameem.repaint();
					frameem.revalidate();
			 	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Employee() {
		        setExtendedState(JFrame.MAXIMIZED_BOTH);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(0, 0, 1382, 756);
				contentPane = new JPanel();
				contentPane.setBackground(new Color(153, 255, 153));
				contentPane.setBackground(new Color(153, 255, 153));
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
			
			JLabel lblEmployeeDetails = new JLabel("Employee Details");
			lblEmployeeDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblEmployeeDetails.setBounds(564, 11, 134, 29);
			getContentPane().add(lblEmployeeDetails);
			
			JLabel lblDate = new JLabel("Date");
			lblDate.setBounds(455, 81, 99, 14);
			getContentPane().add(lblDate);
			
			 dateChooser = new JDateChooser();
			dateChooser.setDateFormatString("dd-MM-yyyy");
			Date date = new Date();
			dateChooser.setDate(date);
			dateChooser.setBounds(647, 75, 171, 20);
			getContentPane().add(dateChooser);
			
			JLabel lblEmployeeName = new JLabel("Employee Name");
			lblEmployeeName.setBounds(455, 117, 121, 14);
			getContentPane().add(lblEmployeeName);
			
			employeename = new JTextField();
			employeename.setBounds(647, 114, 171, 20);
			getContentPane().add(employeename);
			employeename.setColumns(10);
			
			JLabel lblAddress = new JLabel("Address");
			lblAddress.setBounds(455, 208, 121, 14);
			getContentPane().add(lblAddress);
			
			 employeeaddress = new JTextArea();
			employeeaddress.setBounds(647, 176, 171, 68);
			getContentPane().add(employeeaddress);
			
			JLabel lblDateOfBirth = new JLabel("Date of Birth");
			lblDateOfBirth.setBounds(455, 253, 91, 14);
			getContentPane().add(lblDateOfBirth);
			
			 dateChooser_1 = new JDateChooser();
			 dateChooser_1.setDateFormatString("dd-MM-YYYY");
				Date date1 = new Date();
				dateChooser_1.setDate(date1);
			dateChooser_1.setBounds(647, 261, 171, 20);
			getContentPane().add(dateChooser_1);
			
			JLabel lblNewLabel = new JLabel("Contact No");
			lblNewLabel.setBounds(455, 295, 121, 14);
			getContentPane().add(lblNewLabel);
			
			employeecontactno = new JTextField();
			employeecontactno.setBounds(647, 292, 171, 20);
			getContentPane().add(employeecontactno);
			employeecontactno.setColumns(10);
			
			JLabel lblAatharNo = new JLabel("Aathar No");
			lblAatharNo.setBounds(455, 334, 121, 14);
			getContentPane().add(lblAatharNo);
			
			employeeaatharno = new JTextField();
			employeeaatharno.setBounds(647, 331, 171, 20);
			getContentPane().add(employeeaatharno);
			employeeaatharno.setColumns(10);
			
			JLabel lblPin = new JLabel("Pin");
			lblPin.setBounds(455, 375, 110, 14);
			getContentPane().add(lblPin);
			
			employeepin = new JTextField();
			employeepin.setBounds(647, 372, 171, 20);
			getContentPane().add(employeepin);
			employeepin.setColumns(10);
			
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setBounds(455, 422, 121, 14);
			getContentPane().add(lblEmail);
			
			employeeemail = new JTextField();
			employeeemail.setBounds(647, 419, 171, 20);
			getContentPane().add(employeeemail);
			employeeemail.setColumns(10);
			
			JLabel lblGender = new JLabel("Gender");
			lblGender.setBounds(458, 155, 88, 14);
			contentPane.add(lblGender);
			
			 rdbtnMale = new JRadioButton("male");
			rdbtnMale.setBounds(647, 146, 68, 23);
			contentPane.add(rdbtnMale);
			
			 rdbtnFemale = new JRadioButton("female");
			rdbtnFemale.setBounds(721, 146, 110, 23);
			contentPane.add(rdbtnFemale);
			
			ButtonGroup group = new ButtonGroup();
			group.add(rdbtnMale);
			group.add(rdbtnFemale);
			
			
			JButton employeeSubmit = new JButton("Submit");
			employeeSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						String query="insert into employee(EmployeeName,Address,pin,ContactNo,Email,AatharNo,DateofBirth,Date,Gender) values(?,?,?,?,?,?,?,?,?)";
						Statement tm =DbConnection.getconnection().createStatement();
						PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
						
						pt.setString(1, employeename.getText());
						pt.setString(2, employeeaddress.getText());
						pt.setString(3, employeepin.getText());
						pt.setString(4, employeecontactno.getText());
						pt.setString(5, employeeemail.getText());
						pt.setString(6, employeeaatharno.getText());
						pt.setDate(7,new java.sql.Date(dateChooser.getDate().getTime()));
						pt.setDate(8,new java.sql.Date(dateChooser_1.getDate().getTime()));
						String gender="";
						{
						if(rdbtnMale.isSelected()) 
					        gender="Male";
					    else if(rdbtnFemale.isSelected()) 
					        gender="Female";
						}
						pt.setString(9, gender);
						pt.execute();
						employeename.setText("");
						employeeaddress.setText("");
						employeepin.setText("");
						employeecontactno.setText("");
						employeeemail.setText("");
						employeeaatharno.setText("");
						/*dateChooser.setCalendar(null);
						dateChooser_1.setCalendar(null);*/
						group.clearSelection();
						try {
							frameem.setVisible(false);
							frameem = new Employee();
							frameem.setVisible(true);
							frameem.setTitle("Employee Page");
							SwingUtilities.updateComponentTreeUI(frameem);
							frameem.repaint();
							frameem.revalidate();
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
			
			employeeSubmit.setBounds(626, 465, 89, 23);
			getContentPane().add(employeeSubmit);
			
			
			JButton btnBack = new JButton("back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Viewpage.main(new String[]{});
					setVisible(false);
				}
			});
			btnBack.setBounds(10, 0, 89, 23);
			getContentPane().add(btnBack);
			
			
			
			//grid view
			try{
				
				String[] str={"Sl No","EmployeeId","EmployeeName","Address","AatharNo","DateofBirth","Gender","pin","Email","ContactNo","Date","Edit","Del"};
				int count =100;
				String sql="SELECT EmployeeId, EmployeeName, Address, AatharNo, DateofBirth, Gender, pin, Email, ContactNo, Date FROM employee";
				String sqlCou="SELECT count(*) e FROM employee";
				
				 Statement st;
					st = DbConnection.getconnection().createStatement();
					ResultSet rs = st.executeQuery(sqlCou);
					while(rs.next())
					{
						count = rs.getInt("e");
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
					int	EmployeeId= rs.getInt("EmployeeId");
					data[k][j]=EmployeeId;
					j++;
					String	EmployeeName= rs.getString("EmployeeName");
					data[k][j]=EmployeeName;
					j++;
					String	Address= rs.getString("Address");
					data[k][j]=Address;
					j++;
					String 	 AatharNo=rs.getString("AatharNo");
					data[k][j]=AatharNo;
					j++;
					String 	 DateofBirth=rs.getString("DateofBirth");
					data[k][j]=DateofBirth;
					j++;
					String 	 Gender=rs.getString("Gender");
					data[k][j]=Gender;
					j++;
					int 	 pin=rs.getInt("pin");
					data[k][j]=pin;
					j++;
					String 	 Email=rs.getString("Email");
					data[k][j]=Email;
					j++;
					long 	 ContactNo=rs.getLong("ContactNo");
					data[k][j]=ContactNo;
					j++;
					String 	 Date=rs.getString("Date");
					data[k][j]=Date;
					j++;
					
					/*String 	 Status=rs.getString("Status");AatharNo
					data[k][j]=Status;
					j++;*/
					//JButton btnEdit = new JButton("Edit");
				    data[k][j]="Edit";
				    j++;
				  //  JButton btnDel = new JButton("DEL");
				    data[k][j]="DELETE";
				    k++;
				    /*emptable.getColumn("Edit").setCellRenderer(new ButtonRenderer());
				    j++;*/
					} 
					emptable = new JTable(data,str);
					emptable.setBounds(0,0, 1400, 1330);
					
					
					emptable.getColumnModel().getColumn(11).setCellRenderer(new ButtonRenderer());
					emptable.getColumnModel().getColumn(11).setCellEditor(new ButtonEditor(new JCheckBox()));
					emptable.getColumnModel().getColumn(12).setCellRenderer(new ButtonRenderer());
					emptable.getColumnModel().getColumn(12).setCellEditor(new ButtonEditor(new JCheckBox()));
					emptable.setBounds(0,0, 1400, 1330);
					
					emptable.getColumn("EmployeeId").setWidth(0);
					emptable.getColumn("EmployeeId").setMinWidth(0);
					emptable.getColumn("EmployeeId").setMaxWidth(0);
					
					
					emptable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			            public void valueChanged(ListSelectionEvent event) {
			            	 
			            	 try {
								String co=emptable.getValueAt(emptable.getSelectedRow(), 1).toString();
								//System.out.println(Taxtable.getValueAt(Taxtable.getSelectedRow(), 0).toString());
	       // System.out.println( Taxtable.getSelectedColumn() +" ,"+Taxtable.getSelectedRowCount());
								try {
									if(emptable.getSelectedColumn()==11){
										empId=Integer.parseInt(emptable.getValueAt(emptable.getSelectedRow(), 1)+"");
									String tx="select * from employee where EmployeeId="+emptable.getValueAt(emptable.getSelectedRow(), 1);
									Statement tm =DbConnection.getconnection().createStatement();
									ResultSet rs=tm.executeQuery(tx);
									while(rs.next())
									{ 
										
										employeename.setText(rs.getString("EmployeeName")+"");
										employeeaddress.setText(rs.getString("Address")+"");
										employeeaatharno.setText(rs.getString("AatharNo")+"");
										/*java.util.Date utilDate = new java.util.Date();
										java.sql.Date sd = new java.sql.Date(utilDate.getTime())*/;
										dateChooser.setDateFormatString(rs.getString("Date")+"");
										Enumeration enu=group.getElements();
										while(enu.hasMoreElements()){
											JRadioButton btR=(JRadioButton)enu.nextElement();
											System.out.println(btR.getText());
											if(btR.getText().equalsIgnoreCase(rs.getString("Gender")))
											{
												btR.setSelected(true);
											}
										}
										employeepin.setText(rs.getString("pin")+"");
										employeeemail.setText(rs.getString("Email")+"");
										employeecontactno.setText(rs.getString("ContactNo")+"");
										dateChooser_1.setDateFormatString(rs.getString("Date")+"");
										
										
										//ButtonGroup model = (ButtonGroup)group.getSelection();
										
										//gender.setSelectedItem(rs.getString("Gender")+"");
										//rs.getInt("SGST");
									}
									}
									if(emptable.getSelectedColumn()==12){
										String tx="delete from employee where EmployeeId="+emptable.getValueAt(emptable.getSelectedRow(), 1);
									//	System.out.println(tx);
										Statement tm =DbConnection.getconnection().createStatement();
										tm.execute(tx);
										//Taxtable.remove(Taxtable.getSelectedRowCount());
										System.out.println(emptable.getRowCount());
										for(int t =emptable.getSelectedRow();t <emptable.getRowCount();t++){
											System.out.println(t +" tt");
											for(int y=1;y>8;y++){
												
												if((t+1)!=emptable.getRowCount()){
													emptable.getModel().setValueAt(emptable.getValueAt(t+1, y), t, y);
												}else{
													emptable.getModel().setValueAt("", t, y);	
													emptable.getModel().setValueAt("", t, 0);	
												}
											}
											System.out.println(t +" tt end");
											try {
												frameem.setVisible(false);
												frameem = new Employee();
												frameem.setVisible(true);
												frameem.setTitle("Employee Page");
												SwingUtilities.updateComponentTreeUI(frameem);
												frameem.repaint();
												frameem.revalidate();
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
								
								emptable.clearSelection();
								emptable.repaint();
								emptable.revalidate();
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
							}
			            	// DefaultTableModel md=DefaultTableModel
			            	// Taxtable.fireTableDataChanged();
			            } 
			           
			        });
					
					
			        JScrollPane scrollPane = new JScrollPane(emptable);
			        scrollPane.setBounds(0,502, 1400, 1521);
					emptable.setFillsViewportHeight(true);
			       getContentPane().add(scrollPane,BorderLayout.CENTER);
			       
			       JButton btnUpdate = new JButton("Update");
			       btnUpdate.addActionListener(new ActionListener() {
			       	public void actionPerformed(ActionEvent arg0) {
			       		try {
							String query="update employee set EmployeeName=?,Address=?,pin=?,ContactNo=?,Email=?,AatharNo=?,DateofBirth=?,Date=?,Gender=? where EmployeeId="+empId;
							Statement tm =DbConnection.getconnection().createStatement();
							PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
							
							pt.setString(1, employeename.getText());
							pt.setString(2, employeeaddress.getText());
							pt.setString(3, employeepin.getText());
							pt.setString(4, employeecontactno.getText());
							pt.setString(5, employeeemail.getText());
							pt.setString(6, employeeaatharno.getText());
							pt.setDate(7,new java.sql.Date(dateChooser.getDate().getTime()));
							pt.setDate(8,new java.sql.Date(dateChooser_1.getDate().getTime()));
							String gender="";
							{
							if(rdbtnMale.isSelected()) 
						        gender="Male";
						    else if(rdbtnFemale.isSelected()) 
						        gender="Female";
							}
							pt.setString(9, gender);
							pt.execute();
							employeename.setText("");
							employeeaddress.setText("");
							employeepin.setText("");
							employeecontactno.setText("");
							employeeemail.setText("");
							employeeaatharno.setText("");
							dateChooser.setCalendar(null);
							dateChooser_1.setCalendar(null);
							group.clearSelection();
							empId=0;
							try {
								frameem.setVisible(false);
								frameem = new Employee();
								frameem.setVisible(true);
								frameem.setTitle("Employee Page");
								SwingUtilities.updateComponentTreeUI(frameem);
								frameem.repaint();
								frameem.revalidate();
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
			       btnUpdate.setBounds(487, 465, 89, 23);
			       contentPane.add(btnUpdate);
			        setVisible(true);
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			
			
			
			
			
			
			
			
			 
	        
	}
}
