package Java;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.DbConnection;
import model.DropDownItem;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class AccountGroup extends JFrame {

	private JPanel contentPane;
	private JTextField accname;
	private JTextField groupcode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountGroup frame = new AccountGroup();
					frame.setVisible(true);
					frame.setTitle("AccountGroup Page");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AccountGroup() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 1331);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccountGroup = new JLabel("Account Group");
		lblAccountGroup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAccountGroup.setBounds(624, 40, 165, 37);
		contentPane.add(lblAccountGroup);
		
		JLabel lblAccountName = new JLabel("Account Name");
		lblAccountName.setBounds(574, 185, 107, 14);
		contentPane.add(lblAccountName);
		
		accname = new JTextField();
		accname.setBounds(709, 188, 165, 20);
		contentPane.add(accname);
		accname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("AccountHead");
		lblNewLabel.setBounds(574, 218, 104, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox Acchd = new JComboBox();
		Acchd.setModel(new DefaultComboBoxModel(new String[] {"Income", "Asset", "Expense"}));
		Acchd.setBounds(709, 219, 165, 20);
		contentPane.add(Acchd);
		
	
		JLabel Status = new JLabel("Status");
		Status.setBounds(574, 243, 107, 14);
		contentPane.add(Status);
		
		Vector model = new Vector();
        model.addElement( new DropDownItem(1, "Active" ) );
        model.addElement( new DropDownItem(2, "Deactive" ) );
		
		JComboBox Statuscombo = new JComboBox(model);
		Statuscombo.setBounds(709, 250, 165, 20);
		contentPane.add(Statuscombo);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(577, 117, 107, 14);
		contentPane.add(lblDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(709, 117, 165, 20);
		dateChooser.setDateFormatString("dd-MM-yyyy  hh:mm:ss a");
		Date date = new Date();
		dateChooser.setDate(date);
		contentPane.add(dateChooser);
		
		JLabel lblGroupcode = new JLabel("Acc GroupCode");
		lblGroupcode.setBounds(574, 160, 94, 14);
		contentPane.add(lblGroupcode);
		
		groupcode = new JTextField();
		groupcode.setBounds(709, 157, 165, 20);
		contentPane.add(groupcode);
		groupcode.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query="insert into accountgroup(AccountName,AccountHead,Status,Date,GroupCode) values(?,?,?,?,?)";
					Statement tm =DbConnection.getconnection().createStatement();
					PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
					pt.setString(1, accname.getText());
					pt.setString(2, Acchd.getSelectedItem().toString());
					DropDownItem item = (DropDownItem)Statuscombo.getSelectedItem();
					  String status=  item.getId()==1?"A":"D";
					pt.setString(3, status);
					java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
					pt.setTimestamp(4, date);
					pt.setString(5, groupcode.getText());
					
					pt.execute();
					accname.setText("");
					status.isEmpty();
					dateChooser.setCalendar(null);
					groupcode.setText("");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(637, 281, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Viewpage.main(new String[]{});
        		setVisible(false);
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
		
		
		
		
	}
}
