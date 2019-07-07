package Java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.BorderLayout;
import java.awt.Color;

public class Rate extends JFrame {
	

	static private  JPanel contentPane;
	static private JTextField Rateamount;
	static private JComboBox ratecategory;
	static private JComboBox ratecarat,rateStatus;
	static private JTable RATEtable;
	static private JDateChooser dateChooser;
	static private int rateId=0;
	static Rate framert;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					framert = new Rate();
					framert.setVisible(true);
					framert.setTitle("Rate Page");
					SwingUtilities.updateComponentTreeUI(framert);
					framert.repaint();
					framert.revalidate();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Rate() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(0, 0, 1400, 1331);
				contentPane = new JPanel();
				contentPane.setBackground(new Color(153, 255, 153));
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
		JLabel RateDetails = new JLabel("Rate Details");
		RateDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		RateDetails.setBounds(621, 11, 129, 27);
		getContentPane().add(RateDetails);
		
		JLabel CategoryName = new JLabel("Category Name");
		CategoryName.setBounds(329, 49, 97, 14);
		getContentPane().add(CategoryName);
		
		ratecategory = new JComboBox(CommonUtil.getAllCatageory());		
		ratecategory.setBounds(329, 74, 110, 20);
		getContentPane().add(ratecategory);
		
		JLabel Carat = new JLabel("Carat");
		Carat.setBounds(489, 49, 46, 14);
		getContentPane().add(Carat);
		
		ratecarat = new JComboBox(CommonUtil.getAllunit());
		ratecarat.setBounds(478, 74, 90, 20);
		getContentPane().add(ratecarat);
		
		JLabel Amount = new JLabel("Amount");
		Amount.setBounds(631, 49, 46, 14);
		getContentPane().add(Amount);
		
		Rateamount = new JTextField();
		Rateamount.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if(!Validation.number(Rateamount.getText())){
					JOptionPane.showMessageDialog(null, "Enter only Numbers");
					Rateamount.requestFocus();
				}
			}
		});
		Rateamount.setBounds(608, 74, 110, 20);
		getContentPane().add(Rateamount);
		Rateamount.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(205, 49, 67, 14);
		getContentPane().add(lblDate);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(180, 74, 117, 20);
		Date date = new Date();
		dateChooser.setDate(date);
		/*String dte = new  SimpleDateFormat("dd:MM:yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		dateChooser.setDateFormatString(dte);*/
		getContentPane().add(dateChooser);
		
		
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(761, 49, 46, 14);
		getContentPane().add(lblStatus);
	     	 Vector model = new Vector();
	        model.addElement( new DropDownItem(1, "Active" ) );
	        model.addElement( new DropDownItem(2, "Deactive" ) );	        
		rateStatus = new JComboBox(model);
		rateStatus.setBounds(745, 74, 80, 20);	
		getContentPane().add(rateStatus);
		
		JButton RateSubmit = new JButton("Submit");
		RateSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
				     
					String rate="insert into rate(Amount,Date,Status,CatId,UnitId) values(?,?,?,?,?)";
					Statement tm =DbConnection.getconnection().createStatement();
					PreparedStatement pt=DbConnection.getconnection().prepareStatement(rate);
					
					pt.setString(1, Rateamount.getText());
					java.sql.Date sqldate=new java.sql.Date(dateChooser.getDate().getTime());
					//java.util.Date jdate = new java.util.Date(sdate.getTime());
					pt.setDate(2, sqldate);
					
					  DropDownItem item = (DropDownItem)rateStatus.getSelectedItem();
					  String status=  item.getId()==1?"A":"D";
					pt.setString(3,status);
					
					DropDownItem itemcat = (DropDownItem)ratecategory.getSelectedItem();
					pt.setInt(4, itemcat.getId());
					
					DropDownItem itemunit = (DropDownItem)ratecarat.getSelectedItem();
					pt.setInt(5, itemunit.getId());
					
					pt.execute();
					Rateamount.setText("");
					dateChooser.setCalendar(null);
					
					try {
						framert.setVisible(false);
						framert = new Rate();
						framert.setVisible(true);
						framert.setTitle("Rate Page");
						SwingUtilities.updateComponentTreeUI(framert);
						framert.repaint();
						framert.revalidate();
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
		RateSubmit.setBounds(981, 73, 89, 23);
		getContentPane().add(RateSubmit);
		
		   
		try{
			
			String[] str={"Sl.No","RateId","CategoryName","carat","Amount","Status"," Date","Edit","Delete"};
			int count =100;
			String sql="SELECT RateId, CatId, UnitId, Amount, Status, Date FROM rate";
			String sqlCou="SELECT count(*) r FROM rate";
			
			 Statement st;
				st = DbConnection.getconnection().createStatement();
				ResultSet rs = st.executeQuery(sqlCou);
				while(rs.next())
				{
					count = rs.getInt("r");
				}
				st = DbConnection.getconnection().createStatement();
				 rs = st.executeQuery(sql);
				
				//Vector row = new Vector();
				Object[][] data=new Object[count][9];
				 RATEtable = new JTable(data,str);
				 int k=0;
				while(rs.next())
				{
					
					 int j=0;
					 data[k][j]=k+1;
					j++;
				int	RateId= rs.getInt("RateId");
				data[k][j]=RateId;
				j++;
				String 	 cname=IdtoNameUtil.getcategoryName(rs.getInt("CatId"));
				data[k][j]=cname;
				j++;
				String 	 carat=IdtoNameUtil.getcarat(rs.getInt("UnitId"));
				data[k][j]=carat;
				j++;
				String 	 amount=rs.getString("Amount");
				data[k][j]=amount;
				j++;
				String 	 status=rs.getString("Status");
				data[k][j]=status;
				j++;
				String 	rateDate=rs.getString("Date");
				data[k][j]=rateDate;
				j++;
				//JButton btnEdit = new JButton("EDIT");
			    data[k][j]="EDIT";
			    /*RATEtable.getColumn("EDIT").setCellRenderer(new ButtonRenderer());
			    RATEtable.getColumn("EDIT").setCellEditor(new ButtonEditor(new JCheckBox()));*/
			    j++;
			  
			   // JButton btnDel = new JButton("DEL");
			    data[k][j]="DELETE";
			    k++;
			    //row.addElement(data);
				} 
				
				//to create an button inside the jtable
				RATEtable.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
				RATEtable.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox()));
				RATEtable.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderer());
				RATEtable.getColumnModel().getColumn(8).setCellEditor(new ButtonEditor(new JCheckBox()));
				
				//to hide the rateid column in the jtable
				RATEtable.getColumn("RateId").setWidth(0);
				RATEtable.getColumn("RateId").setMinWidth(0);
				RATEtable.getColumn("RateId").setMaxWidth(0);
				
				
			    RATEtable.setBounds(0,0, 1400, 1330);
		        JScrollPane scrollPane = new JScrollPane(RATEtable);
		        scrollPane.setBounds(180,394, 891, 144);
		        RATEtable.setFillsViewportHeight(true);
		      
		     RATEtable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		            public void valueChanged(ListSelectionEvent event) {
		            	
		            	 //String co=RATEtable.getValueAt(RATEtable.getSelectedRow(), 0).toString();
		               // System.out.println(RATEtable.getValueAt(RATEtable.getSelectedRow(), 0).toString());

		            	 
		            	 try {
							String co=RATEtable.getValueAt(RATEtable.getSelectedRow(), 1).toString();
							//System.out.println(Taxtable.getValueAt(Taxtable.getSelectedRow(), 0).toString());
      // System.out.println( Taxtable.getSelectedColumn() +" ,"+Taxtable.getSelectedRowCount());
							try {
								if(RATEtable.getSelectedColumn()==7){
									rateId=Integer.parseInt(RATEtable.getValueAt(RATEtable.getSelectedRow(), 1)+"");
								String tx="select * from rate where RateId="+RATEtable.getValueAt(RATEtable.getSelectedRow(), 1);
								Statement tm =DbConnection.getconnection().createStatement();
								ResultSet rs=tm.executeQuery(tx);
								while(rs.next())
								{ 
									
									Rateamount.setText(rs.getDouble("Amount")+"");
									DropDownItem robj =DropDownItem.finById(ratecategory,rs.getInt("CatId"));
									ratecategory.setSelectedItem(robj);
									DropDownItem raobj =DropDownItem.finById(ratecarat,rs.getInt("UnitId"));
									ratecarat.setSelectedItem(raobj);
									System.out.println(rs.getString("Status"));
									int s=rs.getString("Status").equals("A")?1:2;
									DropDownItem sObj=DropDownItem.finById(rateStatus,s);
									rateStatus.setSelectedItem(sObj);
									dateChooser.setDateFormatString(rs.getString("Date")+"");
									//rs.getInt("SGST");
								}
								}
								if(RATEtable.getSelectedColumn()==8){
									String tx="delete from rate where RateId="+RATEtable.getValueAt(RATEtable.getSelectedRow(), 1);
								//	System.out.println(tx);
									Statement tm =DbConnection.getconnection().createStatement();
									tm.execute(tx);
									//Taxtable.remove(Taxtable.getSelectedRowCount());
									System.out.println(RATEtable.getRowCount());
									for(int t =RATEtable.getSelectedRow();t <RATEtable.getRowCount();t++){
										System.out.println(t +" tt");
										for(int y=1;y<8;y++){
											
											if((t+1)!=RATEtable.getRowCount()){
												RATEtable.getModel().setValueAt(RATEtable.getValueAt(t+1, y), t, y);
											}else{
												RATEtable.getModel().setValueAt("", t, y);	
												RATEtable.getModel().setValueAt("", t, 0);	
											}
										}
										System.out.println(t +" tt end");
										try {
											framert.setVisible(false);
											framert = new Rate();
											framert.setVisible(true);
											framert.setTitle("Rate Page");
											SwingUtilities.updateComponentTreeUI(framert);
											framert.repaint();
											framert.revalidate();
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
							
							RATEtable.clearSelection();
							RATEtable.repaint();
							RATEtable.revalidate();
							
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
						     
							String rate="update rate set Amount=?,Date=?,Status=?,CatId=?,UnitId=? where RateId="+rateId ;
							Statement tm =DbConnection.getconnection().createStatement();
							PreparedStatement pt=DbConnection.getconnection().prepareStatement(rate);
							
							pt.setString(1, Rateamount.getText());
							//java.sql.Date sqldate=new java.sql.Date(dateChooser.getDate().getTime());
							//java.util.Date jdate = new java.util.Date(sqldate.getTime());
							pt.setDate(2,new java.sql.Date(dateChooser.getDate().getTime()));
							
							  DropDownItem item = (DropDownItem)rateStatus.getSelectedItem();
							  String status=  item.getId()==1?"A":"D";
							pt.setString(3,status);
							
							DropDownItem itemcat = (DropDownItem)ratecategory.getSelectedItem();
							pt.setInt(4, itemcat.getId());
							
							DropDownItem itemunit = (DropDownItem)ratecarat.getSelectedItem();
							pt.setInt(5, itemunit.getId());
							
							pt.execute();
							Rateamount.setText("");
							dateChooser.setCalendar(null);
							
							rateId =0;
							try {
								framert.setVisible(false);
								framert = new Rate();
								framert.setVisible(true);
								framert.setTitle("Rate Page");
								SwingUtilities.updateComponentTreeUI(framert);
								framert.repaint();
								framert.revalidate();
							} catch (Exception e) {
								e.printStackTrace();
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        		
		        	}
		        });
		        btnUpdate.setBounds(866, 73, 89, 23);
		        contentPane.add(btnUpdate);
		        
		        
		        
		        JButton btnBack = new JButton("back");
		        btnBack.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
		        		Viewpage.main(new String[]{});
		        		setVisible(false);
		        	}
		        });
		        btnBack.setBounds(10, 0, 89, 23);
		        getContentPane().add(btnBack);
		        setVisible(true);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
	}
	
	public static double getRate(int cid) throws SQLException
	{
		double rate=0D;
		try {
			
			//String sql="select Amount from rate WHERE Date = (SELECT MAX(Date) FROM rate)";
			String sql="select r.Amount FROM rate r, product p where p.ProductId="+cid+" and p.CatId=r.CatId ORDER by r.RateId DESC";
			Statement tm =DbConnection.getconnection().createStatement();
			//PreparedStatement rs=DbConnection.getconnection().prepareStatement(sql);
			 ResultSet rs = tm.executeQuery(sql);
			while (rs.next()) {
				 rate = rs.getDouble("Amount");
				 break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rate;
		
		
		
	  
	
	  
	 
	}
	
	public static double getdailyrate(int cid) throws SQLException
	{
		double Darate=0D;
		try {
			int id=0;
			//String sql="select Amount from rate WHERE Date = (SELECT MAX(Date) FROM rate)";
			String sql="SELECT MAX(RateId) as id FROM rate where CatId = "+cid+" ";
			String sqlmax="";
			Statement tm =DbConnection.getconnection().createStatement();
			//PreparedStatement rs=DbConnection.getconnection().prepareStatement(sql);
			 ResultSet rs = tm.executeQuery(sql);
			while (rs.next()) {
				id = rs.getInt("id");
				 break;
			}
			rs.close();
			tm.close();
			 sql="SELECT Amount FROM rate where RateId="+id+" ";
				 tm =DbConnection.getconnection().createStatement();
				//PreparedStatement rs=DbConnection.getconnection().prepareStatement(sql);
				  rs = tm.executeQuery(sql);
				while (rs.next()) {
					Darate = rs.getDouble("Amount");
					 break;
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Darate;
	}
}
