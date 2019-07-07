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
import javax.swing.table.TableCellRenderer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import DB.DbConnection;
import ValidationUtil.Validation;
import model.ButtonEditor;
import model.ButtonRenderer;
import model.DropDownItem;
import javax.swing.JTable;

public class Category extends JFrame {

	static private JPanel contentPane;
	static private JTextField categorycode;
	static private JTextField cateroryName;
	static private JComboBox taxstatus;
	static private JTable cattable;
	static Category framecat;
	static private int catId=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					framecat = new Category();
					framecat.setVisible(true);
					framecat.setTitle("Category Page");
					SwingUtilities.updateComponentTreeUI(framecat);
					framecat.repaint();
					framecat.revalidate();
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Category() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 1331);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCategory.setBounds(696, 11, 119, 30);
		contentPane.add(lblCategory);
		
		
		JLabel lblCategoryId = new JLabel("Category Code");
		lblCategoryId.setBounds(492, 104, 93, 14);
		contentPane.add(lblCategoryId);
		
		categorycode = new JTextField();
		categorycode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if(!Validation.textnum(categorycode.getText()))
						{
					JOptionPane.showMessageDialog(null, "Enter only text and Numbers");
					categorycode.requestFocus();
				}
			}
		});
		categorycode.setBounds(470, 133, 125, 20);
		contentPane.add(categorycode);
		categorycode.setColumns(10);
		
		JLabel lblcategoryname = new JLabel("CategoryName");
		lblcategoryname.setBounds(632, 104, 93, 14);
		contentPane.add(lblcategoryname);
		
		cateroryName = new JTextField();
		cateroryName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if(!Validation.textnum(cateroryName.getText()))
						{
					JOptionPane.showMessageDialog(null, "Enter only text and Numbers");
					cateroryName.requestFocus();
				}
			}
		});
		cateroryName.setBounds(615, 133, 153, 20);
		contentPane.add(cateroryName);
		cateroryName.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(815, 104, 98, 14);
		contentPane.add(lblStatus);
		
		Vector model = new Vector();
        model.addElement( new DropDownItem(1, "Active" ) );
        model.addElement( new DropDownItem(2, "Deactive" ) );
		
       taxstatus = new JComboBox(model);
		taxstatus.setBounds(791, 133, 125, 20);
		contentPane.add(taxstatus);
		
		
		
		JButton categorySubmit = new JButton("Submit");
		categorySubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="insert into category(CategoryCode,CategoryName,status) values(?,?,?)";
					Statement tm =DbConnection.getconnection().createStatement();
					PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
					pt.setString(1, categorycode.getText());
					pt.setString(2, cateroryName.getText());
					DropDownItem item = (DropDownItem)taxstatus.getSelectedItem();
					  String status=  item.getId()==1?"A":"D";
					pt.setString(3, status);
					pt.execute();
					cateroryName.setText("");
					categorycode.setText("");
					
					
					try {
						framecat.setVisible(false);
						framecat = new Category();
						framecat.setVisible(true);
						framecat.setTitle("Category Page");
						SwingUtilities.updateComponentTreeUI(framecat);
						framecat.repaint();
						framecat.revalidate();
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
		categorySubmit.setBounds(1055, 132, 89, 23);
		contentPane.add(categorySubmit);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Viewpage.main(new String[]{});
				dispose();
				
			}
		});
		btnBack.setBounds(0, 0, 89, 23);
		contentPane.add(btnBack);
		
		
		
		//grid view
		try{
			
			String[] str={"Sl.No","CatId","CategoryCode","CategoryName","Status","Edit","Delete"};
			int count =100;
			String sql="SELECT  CatId, CategoryName, status, CategoryCode FROM category";
			String sqlCou="SELECT count(*) c FROM category";
			
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
				Object[][] data=new Object[count][7];
				int k=0;
				while(rs.next())
				{
					int j=0;
					data[k][j]=k+1;
					j++;
				int	CatId= rs.getInt("CatId");
				data[k][j]=CatId;
				j++;
				String 	 CategoryCode=rs.getString("CategoryCode");
				data[k][j]=CategoryCode;
				j++;
				String 	 CategoryName=rs.getString("CategoryName");
				data[k][j]=CategoryName;
				j++;
				
				String 	 Status=rs.getString("status");
				data[k][j]=Status;
				j++;
				//JButton btnEdit = new JButton("EDIT");
			    data[k][j]="EDIT";
			    j++;
			    //JButton btnDel = new JButton("DEL");
			    data[k][j]="DELETE";
			    k++;
				} 
				cattable = new JTable(data,str);
				cattable.setBounds(0,0, 1400, 1330);
				
				
				cattable.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
				cattable.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox()));
				cattable.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
				cattable.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox()));
				cattable.setBounds(0,0, 1400, 1330);
				
				cattable.getColumn("CatId").setWidth(0);
				cattable.getColumn("CatId").setMinWidth(0);
				cattable.getColumn("CatId").setMaxWidth(0);
				
				
				cattable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		            public void valueChanged(ListSelectionEvent event) {
		            	 
		            	 try {
							String co=cattable.getValueAt(cattable.getSelectedRow(), 1).toString();
							//System.out.println(Taxtable.getValueAt(Taxtable.getSelectedRow(), 0).toString());
       // System.out.println( Taxtable.getSelectedColumn() +" ,"+Taxtable.getSelectedRowCount());
							try {
								if(cattable.getSelectedColumn()==5){
									catId=Integer.parseInt(cattable.getValueAt(cattable.getSelectedRow(), 1)+"");
								String tx="select * from category where CatId="+cattable.getValueAt(cattable.getSelectedRow(), 1);
								Statement tm =DbConnection.getconnection().createStatement();
								ResultSet rs=tm.executeQuery(tx);
								while(rs.next())
								{ 
									
									categorycode.setText(rs.getString("CategoryCode")+"");
									cateroryName.setText(rs.getString("CategoryName")+"");
									taxstatus.setSelectedItem(rs.getString("status")+"");
									//rs.getInt("SGST");
								}
								}
								if(cattable.getSelectedColumn()==6){
									String tx="delete from category where CatId="+cattable.getValueAt(cattable.getSelectedRow(), 1);
								//	System.out.println(tx);
									Statement tm =DbConnection.getconnection().createStatement();
									tm.execute(tx);
									//Taxtable.remove(Taxtable.getSelectedRowCount());
									System.out.println(cattable.getRowCount());
									for(int t =cattable.getSelectedRow();t <cattable.getRowCount();t++){
										System.out.println(t +" tt");
										for(int y=1;y>8;y++){
											
											if((t+1)!=cattable.getRowCount()){
												cattable.getModel().setValueAt(cattable.getValueAt(t+1, y), t, y);
											}else{
												cattable.getModel().setValueAt("", t, y);	
												cattable.getModel().setValueAt("", t, 0);	
											}
										}
										System.out.println(t +" tt end");
										try {
											framecat.setVisible(false);
											framecat = new Category();
											framecat.setVisible(true);
											framecat.setTitle("Category Page");
											SwingUtilities.updateComponentTreeUI(framecat);
											framecat.repaint();
											framecat.revalidate();
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
							
							cattable.clearSelection();
							cattable.repaint();
							cattable.revalidate();
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}
		            	// DefaultTableModel md=DefaultTableModel
		            	// Taxtable.fireTableDataChanged();
		            } 
		           
		        });
				
				
		        JScrollPane scrollPane = new JScrollPane(cattable);
		        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
		        scrollPane.setVisible(true);
		        getContentPane().add(scrollPane);
		        scrollPane.setBounds(468,194, 617, 150);
		        cattable.setFillsViewportHeight(true);
		        getContentPane().add(scrollPane,BorderLayout.CENTER);
		        
		        JButton btnUpdate = new JButton("Update");
		        btnUpdate.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
		        		
		        		
		        		try {
			       			int md=0;
							String query="update category set CategoryCode=?,CategoryName=?,status=? where CatId="+catId;
							Statement tm =DbConnection.getconnection().createStatement();
							PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
							pt.setString(1, categorycode.getText());
							pt.setString(2, cateroryName.getText());
							DropDownItem item = (DropDownItem)taxstatus.getSelectedItem();
							  String status=  item.getId()==1?"A":"D";
							pt.setString(3, status);
							pt.execute();
							cateroryName.setText("");
							categorycode.setText("");
							catId =0;
							try {
								framecat.setVisible(false);
								framecat = new Category();
								framecat.setVisible(true);
								framecat.setTitle("Category Page");
								SwingUtilities.updateComponentTreeUI(framecat);
								framecat.repaint();
								framecat.revalidate();
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
		        btnUpdate.setBounds(940, 132, 89, 23);
		        contentPane.add(btnUpdate);
		        setVisible(true);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
		
	}
}
