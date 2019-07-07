package Java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import DB.DbConnection;
import jewelleryUtil.CommonUtil;
import jewelleryUtil.IdtoNameUtil;
import model.ButtonEditor;
import model.ButtonRenderer;
import model.DropDownItem;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class StockEntry extends JFrame {

	private JPanel contentPane;
	static StockEntry framest;
	private JTextField quantity;
	private JTextField netwt;
	private JTable table;
	static private int stockId=0;
	private static JComboBox model,productname ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					framest = new StockEntry();
					framest.setVisible(true);
					framest.setTitle("Stock Page");
					SwingUtilities.updateComponentTreeUI(framest);
					framest.repaint();
					framest.revalidate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StockEntry() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 1331);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStockEntry = new JLabel("STOCK  ENTRY");
		lblStockEntry.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblStockEntry.setBounds(385, 11, 133, 28);
		contentPane.add(lblStockEntry);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(26, 52, 77, 14);
		contentPane.add(lblDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 77, 112, 20);
		contentPane.add(dateChooser);
		
		JLabel lblProductNae = new JLabel("Product Name");
		lblProductNae.setBounds(152, 52, 91, 14);
		contentPane.add(lblProductNae);
		
		 productname = new JComboBox(CommonUtil.getProductName());
		productname.setBounds(132, 77, 102, 20);
		contentPane.add(productname);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setBounds(261, 52, 46, 14);
		contentPane.add(lblModel);
		
		 model = new JComboBox(CommonUtil.getAllModel());
		model.setBounds(244, 77, 84, 20);
		contentPane.add(model);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(355, 50, 71, 14);
		contentPane.add(lblQuantity);
		
		quantity = new JTextField();
		quantity.setBounds(338, 77, 86, 20);
		contentPane.add(quantity);
		quantity.setColumns(10);
		
		JLabel lblNetwt = new JLabel("NetWt");
		lblNetwt.setBounds(446, 50, 46, 14);
		contentPane.add(lblNetwt);
		
		netwt = new JTextField();
		netwt.setBounds(432, 77, 102, 20);
		contentPane.add(netwt);
		netwt.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				

				try {
					String query="insert into stock(Date,ProductId,ModelId,Quantity,NetWt) values(?,?,?,?,?)";
					Statement tm =DbConnection.getconnection().createStatement();
					PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
					pt.setDate(1,new java.sql.Date(dateChooser.getDate().getTime()));
					DropDownItem itemprod = (DropDownItem)productname.getSelectedItem();
					pt.setInt(2, itemprod.getId());
					DropDownItem model1 = (DropDownItem)model.getSelectedItem();
					pt.setInt(3, model1.getId());
					pt.setDouble(4, Double.parseDouble(quantity.getText()));
					pt.setDouble(5, Double.parseDouble(netwt.getText()));
					
					pt.execute();
					quantity.setText("");
					netwt.setText("");
					dateChooser.setCalendar(null);
					
					try {
						framest.setVisible(false);
						framest = new StockEntry();
						framest.setVisible(true);
						framest.setTitle("Stock Page");
						SwingUtilities.updateComponentTreeUI(framest);
						framest.repaint();
						framest.revalidate();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		btnSubmit.setBounds(674, 77, 89, 23);
		contentPane.add(btnSubmit);
		
		
		
		
		try{

		
		String[] str={"Sl No","StockId","ProductId","ModelId","Quantity","NetWt","Date","Edit","DEL"};
		int count =100;
		String sql="SELECT StockId, ProductId, ModelId, NetWt, Quantity, Date FROM stock";
		String sqlCou="SELECT count(*) s FROM stock";
		
		 Statement st;
			st = DbConnection.getconnection().createStatement();
			ResultSet rs = st.executeQuery(sqlCou);
			while(rs.next())
			{
				count = rs.getInt("s");
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
				int	StockId= rs.getInt("StockId");
				data[k][j]=StockId;
				j++;
				String 	 pname=IdtoNameUtil.getproductname(rs.getInt("ProductId"));
				data[k][j]=pname;
				j++;
				String 	 mname=IdtoNameUtil.getmodelname(rs.getInt("ModelId"));
				data[k][j]=mname;
				j++;
				Double	Quantity= rs.getDouble("Quantity");
				data[k][j]=Quantity;
				j++;
			Double	NetWt= rs.getDouble("NetWt");
			data[k][j]=NetWt;
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
			table = new JTable(data,str);
			table.setBounds(0,0, 1400, 1330);
			
			
			table.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
			table.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox()));
			table.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderer());
			table.getColumnModel().getColumn(8).setCellEditor(new ButtonEditor(new JCheckBox()));
			table.setBounds(0,0, 1400, 1330);
			
			table.getColumn("StockId").setWidth(0);
			table.getColumn("StockId").setMinWidth(0);
			table.getColumn("StockId").setMaxWidth(0);
			
			
			
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	            public void valueChanged(ListSelectionEvent event) {
	            	 
	            	 try {
						String co=table.getValueAt(table.getSelectedRow(), 1).toString();
						//System.out.println(Taxtable.getValueAt(Taxtable.getSelectedRow(), 0).toString());
   // System.out.println( Taxtable.getSelectedColumn() +" ,"+Taxtable.getSelectedRowCount());
						try {
							if(table.getSelectedColumn()==7){
								stockId=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 1)+"");
							String tx="select * from stock where StockId="+table.getValueAt(table.getSelectedRow(), 1);
							Statement tm =DbConnection.getconnection().createStatement();
							ResultSet rs=tm.executeQuery(tx);
							while(rs.next())
							{ 
								DropDownItem robj =DropDownItem.finById(productname,rs.getInt("ProductId"));
								productname.setSelectedItem(robj);
								DropDownItem mod =DropDownItem.finById(model,rs.getInt("ModelId"));
								model.setSelectedItem(mod);
								quantity.setText(rs.getDouble("Quantity")+"");
								netwt.setText(rs.getDouble("NetWt")+"");
								dateChooser.setDateFormatString(rs.getString("Date")+"");
								
							}
							}
							if(table.getSelectedColumn()==8){
								String tx="delete from stock where StockId="+table.getValueAt(table.getSelectedRow(), 1);
							//	System.out.println(tx);
								Statement tm =DbConnection.getconnection().createStatement();
								tm.execute(tx);
								//Taxtable.remove(Taxtable.getSelectedRowCount());
								System.out.println(table.getRowCount());
								for(int t =table.getSelectedRow();t <table.getRowCount();t++){
									System.out.println(t +" tt");
									for(int y=1;y>8;y++){
										
										if((t+1)!=table.getRowCount()){
											table.getModel().setValueAt(table.getValueAt(t+1, y), t, y);
										}else{
											table.getModel().setValueAt("", t, y);	
											table.getModel().setValueAt("", t, 0);	
										}
									}
									System.out.println(t +" tt end");
									try {
										framest.setVisible(false);
										framest = new StockEntry();
										framest.setVisible(true);
										framest.setTitle("Stock Page");
										SwingUtilities.updateComponentTreeUI(framest);
										framest.repaint();
										framest.revalidate();
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
						
						table.clearSelection();
						table.repaint();
						table.revalidate();
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
	            	// DefaultTableModel md=DefaultTableModel
	            	// Taxtable.fireTableDataChanged();
	            } 
	           
	        });
			
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(376,457, 763, 795);
	        table.setFillsViewportHeight(true);
	       getContentPane().add(scrollPane,BorderLayout.CENTER);
	       
	       JButton btnUpdate = new JButton("Update");
	       btnUpdate.addActionListener(new ActionListener() {
	       	public void actionPerformed(ActionEvent arg0) {
	       		try {
					String query="update stock set Date=?,ProductId=?,ModelId=?,Quantity=?,NetWt=? where StockId="+stockId;
					Statement tm =DbConnection.getconnection().createStatement();
					PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
					
					pt.setDate(1,new java.sql.Date(dateChooser.getDate().getTime()));
					DropDownItem itemprod = (DropDownItem)productname.getSelectedItem();
					pt.setInt(2, itemprod.getId());
					DropDownItem model1 = (DropDownItem)model.getSelectedItem();
					pt.setInt(3, model1.getId());
					pt.setDouble(4, Double.parseDouble(quantity.getText()));
					pt.setDouble(5, Double.parseDouble(netwt.getText()));
					
					pt.execute();
					quantity.setText("");
					netwt.setText("");
					dateChooser.setCalendar(null);
					
					try {
						framest.setVisible(false);
						framest = new StockEntry();
						framest.setVisible(true);
						framest.setTitle("Stock Page");
						SwingUtilities.updateComponentTreeUI(framest);
						framest.repaint();
						framest.revalidate();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	       		
	       	}
	       });
	       btnUpdate.setBounds(562, 77, 89, 23);
	       contentPane.add(btnUpdate);
	        setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
