package Java;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DB.DbConnection;
import model.ButtonEditor;
import model.ButtonRenderer;
import model.DropDownItem;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CustomerLogin extends JFrame {

	static CustomerLogin custlogin;
	private JPanel contentPane;
	private JTextField password;
	static private JTable logtable;
	static private int logId=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					custlogin = new CustomerLogin();
					custlogin.setVisible(true);
					custlogin.setTitle("Main Page");
					SwingUtilities.updateComponentTreeUI(custlogin);
					custlogin.repaint();
					custlogin.revalidate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerLogin() {
		        setExtendedState(JFrame.MAXIMIZED_BOTH);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(0, 0, 1400, 1331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(146, 64, 76, 14);
		contentPane.add(lblPassword);
		
		password = new JTextField();
		password.setBounds(255, 61, 128, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="insert into Login(Password) values(?)";
					Statement tm =DbConnection.getconnection().createStatement();
					PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
					pt.setString(1, password.getText());
					pt.execute();
					password.setText("");
					
					
					try {
						custlogin.setVisible(false);
						custlogin = new CustomerLogin();
						custlogin.setVisible(true);
						custlogin.setTitle("Menu Page");
						SwingUtilities.updateComponentTreeUI(custlogin);
						custlogin.repaint();
						custlogin.revalidate();
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
		btnSubmit.setBounds(393, 60, 89, 23);
		contentPane.add(btnSubmit);
		
		//grid view
		try{
			
			String[] str={"Sl.No","LoginId","Password","Delete"};
			int count =100;
			String sql="SELECT  LoginId,Password FROM Login";
			String sqlCou="SELECT count(*) c FROM Login";
			
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
				Object[][] data=new Object[count][4];
				int k=0;
				while(rs.next())
				{
					int j=0;
					data[k][j]=k+1;
					j++;
					int	LoginId= rs.getInt("LoginId");
					data[k][j]=LoginId;
					j++;
				String 	 password=rs.getString("Password");
				data[k][j]=password;
				j++;
				
				//JButton btnEdit = new JButton("EDIT");
			    /*data[k][j]="EDIT";
			    j++;*/
			    //JButton btnDel = new JButton("DEL");
			    data[k][j]="DELETE";
			    k++;
				} 
				logtable = new JTable(data,str);
				logtable.setBounds(0,0, 1400, 1330);
				
				
				/*logtable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
				logtable.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox()));*/
				logtable.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
				logtable.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JCheckBox()));
				logtable.setBounds(0,0, 1400, 1330);
				
				logtable.getColumn("LoginId").setWidth(0);
				logtable.getColumn("LoginId").setMinWidth(0);
				logtable.getColumn("LoginId").setMaxWidth(0);
				
				
				logtable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		            public void valueChanged(ListSelectionEvent event) {
		            	 
		            	 try {
							String co=logtable.getValueAt(logtable.getSelectedRow(), 1).toString();
							//System.out.println(Taxtable.getValueAt(Taxtable.getSelectedRow(), 0).toString());
       // System.out.println( Taxtable.getSelectedColumn() +" ,"+Taxtable.getSelectedRowCount());
							try {
								/*if(logtable.getSelectedColumn()==2){
									logId=Integer.parseInt(logtable.getValueAt(logtable.getSelectedRow(), 1)+"");
								String tx="select * from Login where logId="+logtable.getValueAt(logtable.getSelectedRow(), 1);
								Statement tm =DbConnection.getconnection().createStatement();
								ResultSet rs=tm.executeQuery(tx);
								while(rs.next())
								{ 
									
									password.setText(rs.getString("Password")+"");
								}
								}*/
								if(logtable.getSelectedColumn()==3){
									String tx="delete from Login where LoginId="+logtable.getValueAt(logtable.getSelectedRow(), 1);
								//	System.out.println(tx);
									Statement tm =DbConnection.getconnection().createStatement();
									tm.execute(tx);
									//Taxtable.remove(Taxtable.getSelectedRowCount());
									System.out.println(logtable.getRowCount());
									for(int t =logtable.getSelectedRow();t <logtable.getRowCount();t++){
										System.out.println(t +" tt");
										for(int y=1;y>8;y++){
											
											if((t+1)!=logtable.getRowCount()){
												logtable.getModel().setValueAt(logtable.getValueAt(t+1, y), t, y);
											}else{
												logtable.getModel().setValueAt("", t, y);	
												logtable.getModel().setValueAt("", t, 0);	
											}
										}
										System.out.println(t +" tt end");
										try {
											custlogin.setVisible(false);
											custlogin = new CustomerLogin();
											custlogin.setVisible(true);
											custlogin.setTitle("Menu Page");
											SwingUtilities.updateComponentTreeUI(custlogin);
											custlogin.repaint();
											custlogin.revalidate();
											//custlogin.getContentPane().repaint();
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
							
							logtable.clearSelection();
							logtable.repaint();
							logtable.revalidate();
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}
		            	// DefaultTableModel md=DefaultTableModel
		            	// Taxtable.fireTableDataChanged();
		            } 
		           
		        });
				
				
		        JScrollPane scrollPane = new JScrollPane(logtable);
		        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
		        scrollPane.setVisible(true);
		        getContentPane().add(scrollPane);
		        scrollPane.setBounds(103,143, 617, 150);
		        logtable.setFillsViewportHeight(true);
		        getContentPane().add(scrollPane,BorderLayout.CENTER);
		        
		        
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
	}
}
