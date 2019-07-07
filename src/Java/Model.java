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
import model.ButtonEditor;
import model.ButtonRenderer;
import model.DropDownItem;
import javax.swing.JTable;

public class Model extends JFrame {

	private JPanel contentPane;
	private JTextField modelId;
	private JTextField modelname;
	private JTable modeltable;
	static private  Model mod;
	static private int modId=0;
	static private JComboBox moductstatus ;
	static private JDateChooser dateChooser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mod = new Model();
					mod.setVisible(true);
					mod.setTitle("moduct Page");
					SwingUtilities.updateComponentTreeUI(mod);
					mod.repaint();
					mod.revalidate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Model() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 1331);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblmoductDetails = new JLabel("Model Details");
		lblmoductDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmoductDetails.setBounds(646, 24, 151, 20);
		contentPane.add(lblmoductDetails);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(409, 95, 85, 14);
		contentPane.add(lblDate);
		
		 dateChooser = new JDateChooser();
		 dateChooser.setDateFormatString("dd-MM-yyyy");
		Date date = new Date();
		dateChooser.setDate(date);
		dateChooser.setBounds(377, 120, 132, 20);
		contentPane.add(dateChooser);
		
		JLabel lblmodelId = new JLabel("Model code");
		lblmodelId.setBounds(551, 95, 85, 14);
		contentPane.add(lblmodelId);
		
		modelId = new JTextField();
		modelId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!Validation.textnum(modelId.getText())){
					JOptionPane.showMessageDialog(null, "Enter the moduct code");
					modelId.requestFocus();
				}
			}
		});
		modelId.setBounds(519, 120, 132, 20);
		contentPane.add(modelId);
		modelId.setColumns(10);
		
		JLabel lblmodelname = new JLabel("moduct Name");
		lblmodelname.setBounds(680, 95, 85, 14);
		contentPane.add(lblmodelname);
		
		modelname = new JTextField();
		modelname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!Validation.text(modelname.getText())){
					JOptionPane.showMessageDialog(null, "Enter the moduct name");
					modelname.requestFocus();
				}
			}
		});
		modelname.setBounds(661, 120, 134, 20);
		contentPane.add(modelname);
		modelname.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(808, 95, 85, 14);
		contentPane.add(lblStatus);
		
		 Vector model = new Vector();
	        model.addElement( new DropDownItem(1, "Active" ) );
	        model.addElement( new DropDownItem(2, "Deactive" ) );
	        
		moductstatus = new JComboBox(model);
		moductstatus.setBounds(800, 120, 132, 20);
		getContentPane().add(moductstatus);
		
		JButton moductSubmit = new JButton("Submit");
		moductSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="insert into model(modelCode,modelname,Status,Date) values(?,?,?,?)";
					Statement tm =DbConnection.getconnection().createStatement();
					PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
					pt.setString(1, modelId.getText());
					pt.setString(2, modelname.getText());
					DropDownItem item = (DropDownItem)moductstatus.getSelectedItem();
					  String status=  item.getId()==1?"A":"D";
					pt.setString(3, status);
					pt.setDate(4,new java.sql.Date(dateChooser.getDate().getTime()));
					pt.execute();
					modelId.setText("");
					modelname.setText("");
					status.isEmpty();
					dateChooser.setCalendar(null);
					
					try {
						mod.setVisible(false);
						mod = new Model();
						mod.setVisible(true);
						mod.setTitle("model Page");
						SwingUtilities.updateComponentTreeUI(mod);
						mod.repaint();
						mod.revalidate();
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
		moductSubmit.setBounds(1050, 117, 89, 23);
		contentPane.add(moductSubmit);
		
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
					
					String[] str={"Sl No","ModelId","modelCode","modelname","Status","Date","Edit","DEL"};
					int count =100;
					String sql="SELECT ModelId, ModelCode, modelname, Status, Date FROM model";
					String sqlCou="SELECT count(*) p FROM model";
					
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
						Object[][] data=new Object[count][8];
						int k=0;
						while(rs.next())
						{
							int j=0;
							data[k][j]=k+1;
							j++;
							int	modelId= rs.getInt("ModelId");
							data[k][j]=modelId;
							j++;
						String	modelCode= rs.getString("modelCode");
						data[k][j]=modelCode;
						j++;
						String	modelname= rs.getString("modelname");
						data[k][j]=modelname;
						j++;
						String 	 Status=rs.getString("Status");
						data[k][j]=Status;
						j++;
						String 	 Date=rs.getString("Date");
						data[k][j]=Date;
						j++;
						//JButton btnEdit = new JButton("EDIT");
					    data[k][j]="EDIT";
					    j++;
					  //  JButton btnDel = new JButton("DEL");
					    data[k][j]="DELETE";
					    k++;
						} 
						modeltable = new JTable(data,str);
						modeltable.setBounds(0,0, 1400, 1330);
						
						
						modeltable.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
						modeltable.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox()));
						modeltable.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
						modeltable.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox()));
						modeltable.setBounds(0,0, 1400, 1330);
						
						modeltable.getColumn("ModelId").setWidth(0);
						modeltable.getColumn("ModelId").setMinWidth(0);
						modeltable.getColumn("ModelId").setMaxWidth(0);
						
						
						
						modeltable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
				            public void valueChanged(ListSelectionEvent event) {
				            	 
				            	 try {
									String co=modeltable.getValueAt(modeltable.getSelectedRow(), 1).toString();
									//System.out.println(Taxtable.getValueAt(Taxtable.getSelectedRow(), 0).toString());
		       // System.out.println( Taxtable.getSelectedColumn() +" ,"+Taxtable.getSelectedRowCount());
									try {
										if(modeltable.getSelectedColumn()==6){
											modId=Integer.parseInt(modeltable.getValueAt(modeltable.getSelectedRow(), 1)+"");
										String tx="select * from model where ModelId="+modeltable.getValueAt(modeltable.getSelectedRow(), 1);
										Statement tm =DbConnection.getconnection().createStatement();
										ResultSet rs=tm.executeQuery(tx);
										while(rs.next())
										{ 
											
											modelId.setText(rs.getString("modelCode")+"");
											modelname.setText(rs.getString("modelname")+"");
											moductstatus.setSelectedItem(rs.getString("Status")+"");
											dateChooser.setDateFormatString(rs.getString("Date")+"");
											//rs.getInt("SGST");
										}
										}
										if(modeltable.getSelectedColumn()==7){
											String tx="delete from model where ModelId="+modeltable.getValueAt(modeltable.getSelectedRow(), 1);
										//	System.out.println(tx);
											Statement tm =DbConnection.getconnection().createStatement();
											tm.execute(tx);
											//Taxtable.remove(Taxtable.getSelectedRowCount());
											System.out.println(modeltable.getRowCount());
											for(int t =modeltable.getSelectedRow();t <modeltable.getRowCount();t++){
												System.out.println(t +" tt");
												for(int y=1;y>8;y++){
													
													if((t+1)!=modeltable.getRowCount()){
														modeltable.getModel().setValueAt(modeltable.getValueAt(t+1, y), t, y);
													}else{
														modeltable.getModel().setValueAt("", t, y);	
														modeltable.getModel().setValueAt("", t, 0);	
													}
												}
												System.out.println(t +" tt end");
												try {
													mod.setVisible(false);
													mod = new Model();
													mod.setVisible(true);
													mod.setTitle("model Page");
													SwingUtilities.updateComponentTreeUI(mod);
													mod.repaint();
													mod.revalidate();
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
									
									modeltable.clearSelection();
									modeltable.repaint();
									modeltable.revalidate();
									
								} catch (Exception e) {
									// TODO Auto-generated catch block
									//e.printStackTrace();
								}
				            	// DefaultTableModel md=DefaultTableModel
				            	// Taxtable.fireTableDataChanged();
				            } 
				           
				        });
						
				        JScrollPane scrollPane = new JScrollPane(modeltable);
				        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
				        scrollPane.setVisible(true);
				        getContentPane().add(scrollPane);
				        scrollPane.setBounds(376,457, 763, 237);
				        modeltable.setFillsViewportHeight(true);
				       getContentPane().add(scrollPane,BorderLayout.CENTER);
				       
				       JButton btnUpdate = new JButton("Update");
				       btnUpdate.addActionListener(new ActionListener() {
				       	public void actionPerformed(ActionEvent arg0) {
				       		try {
								String query="update model set modelCode=?,modelname=?,Status=?,Date=? where ModelId="+modId;
								Statement tm =DbConnection.getconnection().createStatement();
								PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
								pt.setString(1, modelId.getText());
								pt.setString(2, modelname.getText());
								DropDownItem item = (DropDownItem)moductstatus.getSelectedItem();
								  String status=  item.getId()==1?"A":"D";
								pt.setString(3, status);
								pt.setDate(4,new java.sql.Date(dateChooser.getDate().getTime()));
								pt.execute();
								modelId.setText("");
								modelname.setText("");
								status.isEmpty();
								dateChooser.setCalendar(null);
								modId=0;
								try {
									mod.setVisible(false);
									mod = new Model();
									mod.setVisible(true);
									mod.setTitle("model Page");
									SwingUtilities.updateComponentTreeUI(mod);
									mod.repaint();
									mod.revalidate();
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
				        setVisible(true);
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
		
		
		
		
		
		
	}
}
