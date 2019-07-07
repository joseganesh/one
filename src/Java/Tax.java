package Java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import DB.DbConnection;
import ValidationUtil.Validation;
import jewelleryUtil.IdtoNameUtil;
import model.ButtonEditor;
import model.ButtonRenderer;
import model.DropDownItem;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Tax extends JFrame {


	static private JPanel contentPane;
	static private JTextField taxsgst;
	static private JTextField taxigst;
	static private JTable Taxtable;
	static private JComboBox taxstatus;
    static private JDateChooser dateChooser;
    static private int taxId=0;
    static Tax frametax;
    static private JTextField taxcgst;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frametax = new Tax();
					frametax.setVisible(true);
					frametax.setTitle("Tax Page");
					SwingUtilities.updateComponentTreeUI(frametax);
					frametax.repaint();
					frametax.revalidate();
					//frametax.getContentPane().repaint();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Tax() {
		//getContentPane().invalidate();
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 1331);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel TaxDetails = new JLabel("Tax Details");
		TaxDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		TaxDetails.setBounds(478, 24, 108, 30);
		getContentPane().add(TaxDetails);
		
		JLabel Sgst = new JLabel("SGST");
		Sgst.setBounds(308, 99, 59, 24);
		getContentPane().add(Sgst);
		
		taxsgst = new JTextField();
		taxsgst.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!Validation.number(taxsgst.getText())){
					JOptionPane.showMessageDialog(null, "Enter only Numbers");
					taxsgst.requestFocus();
				}
			}
		});
		taxsgst.setBounds(292, 134, 86, 20);
		getContentPane().add(taxsgst);
		taxsgst.setColumns(10);
		
		
		   JLabel lblCgst = new JLabel("CGST");
		   lblCgst.setBounds(426, 104, 46, 14);
		   contentPane.add(lblCgst);
		
		taxcgst = new JTextField();
		taxcgst.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!Validation.number(taxcgst.getText())){
					JOptionPane.showMessageDialog(null, "Enter only Numbers");
					taxcgst.requestFocus();
				}
			}
		});
		taxcgst.setBounds(401, 133, 101, 20);
		contentPane.add(taxcgst);
		taxcgst.setColumns(10);
		
		JLabel taxIgst = new JLabel("IGST");
		taxIgst.setBounds(540, 99, 59, 24);
		getContentPane().add(taxIgst);
		
		taxigst = new JTextField();
		taxigst.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!Validation.number(taxsgst.getText())){
					JOptionPane.showMessageDialog(null, "Enter only Numbers");
					taxigst.requestFocus();
				}
			}
		});
		taxigst.setBounds(531, 134, 86, 20);
		getContentPane().add(taxigst);
		taxigst.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(162, 104, 46, 14);
		getContentPane().add(lblDate);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(148, 134, 91, 20);
		Date date = new Date();
		dateChooser.setDate(date);
		getContentPane().add(dateChooser);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(687, 104, 46, 14);
		getContentPane().add(lblStatus);
		
		 Vector model = new Vector();
	        model.addElement( new DropDownItem(1, "Active" ) );
	        model.addElement( new DropDownItem(2, "Deactive" ) );
	        

		taxstatus = new JComboBox(model);
		taxstatus.setBounds(670, 134, 108, 20);
		getContentPane().add(taxstatus);
	        setVisible(true);
	        
		JButton TaxSubmit = new JButton("Submit");
		TaxSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query="insert into tax(SGST,IGST,CGST,Date,Status) values(?,?,?,?,?)";
					Statement tm =DbConnection.getconnection().createStatement();
					PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
					pt.setString(1, taxsgst.getText());
					pt.setString(2, taxigst.getText());
					pt.setString(3, taxcgst.getText());
					pt.setDate(4,new java.sql.Date(dateChooser.getDate().getTime()));
					
					DropDownItem item = (DropDownItem)taxstatus.getSelectedItem();
					  String status=  item.getId()==1?"A":"D";
					pt.setString(5, status);
					pt.execute();
					taxsgst.setText("");
					taxigst.setText("");
					taxcgst.setText("");
					//dateChooser.setDate("");
					//taxstatus.setEnabled(false);
					dateChooser.setCalendar(null);
					try {
						frametax.setVisible(false);
						 frametax = new Tax();
						frametax.setVisible(true);
						frametax.setTitle("Tax Page");
						SwingUtilities.updateComponentTreeUI(frametax);
						frametax.repaint();
						frametax.revalidate();
						//frametax.getContentPane().repaint();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				TaxSubmit.repaint();
				TaxSubmit.revalidate();
           	 /*DefaultTableModel model=(DefaultTableModel)Taxtable.getModel();
		       		model.setRowCount(0);*/
				/*contentPane.repaint();
	            contentPane.validate();
	            Taxtable.repaint();
	            Taxtable.validate();
		       		revalidate();
		       		setContentPane(contentPane);
				  System.exit(1);*/
				/*try {
					frametax.setVisible(false);
					 frametax = new Tax();
					frametax.setVisible(true);
					frametax.setTitle("Tax Page");
					SwingUtilities.updateComponentTreeUI(frametax);
					frametax.repaint();
					frametax.revalidate();
					//frametax.getContentPane().repaint();
				} catch (Exception e) {
					e.printStackTrace();
				}*/
				
			}
		});
		
		TaxSubmit.setBounds(948, 133, 89, 23);
		getContentPane().add(TaxSubmit);
		
		
		

		//grid view
		try{
			
			String[] str={"Sl.No","TaxId","SGST","IGST","CGST","Date","Status","Edit","Delete"};
			int count =100;
			String sql="SELECT TaxId,SGST, IGST,CGST, Date, Status FROM tax";
			String sqlCou="SELECT count(*) c FROM tax";
			
			 Statement st;
				st = DbConnection.getconnection().createStatement();
				ResultSet rs = st.executeQuery(sqlCou);
				while(rs.next())
				{
					count = rs.getInt("c");
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
				int	TaxId= rs.getInt("TaxId");
				data[k][j]=TaxId;
				j++;
				int 	 SGST=rs.getInt("SGST");
				data[k][j]=SGST;
				j++;
				int 	 IGST=rs.getInt("IGST");
				data[k][j]=IGST;
				j++;
				int 	 CGST=rs.getInt("CGST");
				data[k][j]=CGST;
				j++;
				String 	 date1=rs.getString("Date");
				data[k][j]=date1;
				j++;
				String 	 status=rs.getString("Status");
				data[k][j]=status;
				j++;
				
				//JButton btnEdit = new JButton("EDIT");
			    data[k][j]="Edit";
			    j++;
			   // JButton btnDel = new JButton("DEL");
			    data[k][j]="Delete";
			    k++;
				} 
				Taxtable = new JTable(data,str);
				Taxtable.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
				Taxtable.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox()));
				Taxtable.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderer());
				Taxtable.getColumnModel().getColumn(8).setCellEditor(new ButtonEditor(new JCheckBox()));
				Taxtable.setBounds(0,0, 1400, 1330);
				
				Taxtable.getColumn("TaxId").setWidth(0);
				Taxtable.getColumn("TaxId").setMinWidth(0);
				Taxtable.getColumn("TaxId").setMaxWidth(0);
				
				Taxtable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			            public void valueChanged(ListSelectionEvent event) {
			            	 
			            	 try {
								String co=Taxtable.getValueAt(Taxtable.getSelectedRow(), 1).toString();
								//System.out.println(Taxtable.getValueAt(Taxtable.getSelectedRow(), 0).toString());
           // System.out.println( Taxtable.getSelectedColumn() +" ,"+Taxtable.getSelectedRowCount());
								try {
									if(Taxtable.getSelectedColumn()==7){
										taxId=Integer.parseInt(Taxtable.getValueAt(Taxtable.getSelectedRow(), 1)+"");
									String tx="select * from tax where TaxId="+Taxtable.getValueAt(Taxtable.getSelectedRow(), 1);
									Statement tm =DbConnection.getconnection().createStatement();
									ResultSet rs=tm.executeQuery(tx);
									while(rs.next())
									{ 
										
										taxsgst.setText(rs.getInt("SGST")+"");
										taxigst.setText(rs.getInt("IGST")+"");
										taxcgst.setText(rs.getInt("CGST")+"");
										taxstatus.setSelectedItem(rs.getString("Status")+"");
										dateChooser.setDateFormatString(rs.getString("Date")+"");
										//rs.getInt("SGST");
									}
									}
									if(Taxtable.getSelectedColumn()==8){
										String tx="delete from tax where TaxId="+Taxtable.getValueAt(Taxtable.getSelectedRow(), 1);
									//	System.out.println(tx);
										Statement tm =DbConnection.getconnection().createStatement();
										tm.execute(tx);
										//Taxtable.remove(Taxtable.getSelectedRowCount());
										System.out.println(Taxtable.getRowCount());
										for(int t =Taxtable.getSelectedRow();t <Taxtable.getRowCount();t++){
											System.out.println(t +" tt");
											for(int y=1;y<8;y++){
												
												if((t+1)!=Taxtable.getRowCount()){
										      Taxtable.getModel().setValueAt(Taxtable.getValueAt(t+1, y), t, y);
												}else{
													 Taxtable.getModel().setValueAt("", t, y);	
													 Taxtable.getModel().setValueAt("", t, 0);	
												}
											}
											System.out.println(t +" tt end");
											try {
												frametax.setVisible(false);
												 frametax = new Tax();
												frametax.setVisible(true);
												frametax.setTitle("Tax Page");
												SwingUtilities.updateComponentTreeUI(frametax);
												frametax.repaint();
												frametax.revalidate();
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
								
								Taxtable.clearSelection();
								Taxtable.repaint();
								Taxtable.revalidate();
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								//e.printStackTrace();
							}
			            	// DefaultTableModel md=DefaultTableModel
			            	// Taxtable.fireTableDataChanged();
			            } 
			           
			        });
				//contentPane.add(table);
				
				

		        JScrollPane scrollPane = new JScrollPane(Taxtable);
		        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
		        scrollPane.setVisible(true);
		        getContentPane().add(scrollPane);
		        scrollPane.setBounds(136,448, 906, 227);
		        Taxtable.setFillsViewportHeight(true);
		       getContentPane().add(scrollPane,BorderLayout.CENTER);
		       
		       JButton btnUpdate = new JButton("Update");
		       btnUpdate.addActionListener(new ActionListener() {
		       	public void actionPerformed(ActionEvent arg0) {
		       		
		       		
		       		try {
		       			int md=0;
						String query="update tax set SGST=?,IGST=?,CGST=?, Date=?,Status=? where TaxId="+taxId;
						Statement tm =DbConnection.getconnection().createStatement();
						PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
						pt.setString(1, taxsgst.getText());
						pt.setString(2, taxigst.getText());
						pt.setString(3, taxcgst.getText());
						pt.setDate(4,new java.sql.Date(dateChooser.getDate().getTime()));
						
						DropDownItem item = (DropDownItem)taxstatus.getSelectedItem();
						  String status=  item.getId()==1?"A":"D";
						pt.setString(5, status);
						md=pt.executeUpdate();
						taxsgst.setText("");
						taxigst.setText("");
						taxcgst.setText("");
						//dateChooser.setDate("");
						//taxstatus.setEnabled(false);
						dateChooser.setCalendar(null);
						taxId =0;
						try {
							frametax.setVisible(false);
							 frametax = new Tax();
							frametax.setVisible(true);
							frametax.setTitle("Tax Page");
							SwingUtilities.updateComponentTreeUI(frametax);
							frametax.repaint();
							frametax.revalidate();
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
		       btnUpdate.setBounds(826, 133, 89, 23);
		       contentPane.add(btnUpdate);
		       
		       JButton btnBack = new JButton("back");
		       btnBack.addActionListener(new ActionListener() {
		       	public void actionPerformed(ActionEvent arg0) {
		       		Viewpage.main(new String[]{});
		       		setVisible(false);
		       	}
		       });
		       btnBack.setBounds(10, 11, 89, 23);
		       getContentPane().add(btnBack);
		       
		       
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
	
	}
	
	public static  Map gettax() throws SQLException 
	{
		
		Map map=new HashMap();
		
		
		try {
			String sql="SELECT SGST FROM tax WHERE Date = (SELECT MAX(Date) FROM tax)";
			Statement tm =DbConnection.getconnection().createStatement();
			//PreparedStatement rs=DbConnection.getconnection().prepareStatement(sql);
			 ResultSet rs = tm.executeQuery(sql);
			 while (rs.next()) {
				 map.put("SGST", rs.getDouble("SGST"));
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String sql="SELECT IGST FROM tax WHERE Date = (SELECT MAX(Date) FROM tax)";
			Statement tm =DbConnection.getconnection().createStatement();
			//PreparedStatement rs=DbConnection.getconnection().prepareStatement(sql);
			 ResultSet rs = tm.executeQuery(sql);
			 while (rs.next()) {
				 map.put("IGST", rs.getDouble("IGST"));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String sql="SELECT CGST FROM tax WHERE Date = (SELECT MAX(Date) FROM tax)";
			Statement tm =DbConnection.getconnection().createStatement();
			//PreparedStatement rs=DbConnection.getconnection().prepareStatement(sql);
			 ResultSet rs = tm.executeQuery(sql);
			 while (rs.next()) {
				 map.put("CGST", rs.getDouble("CGST"));
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return map;
		
		
	}
}

