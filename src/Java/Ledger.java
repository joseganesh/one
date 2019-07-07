package Java;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import DB.DbConnection;
import jewelleryUtil.CommonUtil;
import model.DropDownItem;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Ledger extends JFrame {

	private JPanel contentPane;
	private JTextField ledgeriD;
	private JTextField ledgername;
	private JTextField ledgercode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ledger frame = new Ledger();
					frame.setVisible(true);
					frame.setTitle("Ledger Page");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ledger() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 1331);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLedger = new JLabel("Ledger");
		lblLedger.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLedger.setBounds(552, 36, 214, 39);
		contentPane.add(lblLedger);
		
		/*JLabel lblLedgerId = new JLabel("Ledger Id");
		lblLedgerId.setBounds(441, 139, 84, 14);
		contentPane.add(lblLedgerId);
		
		ledgeriD = new JTextField();
		ledgeriD.setBounds(543, 136, 148, 20);
		contentPane.add(ledgeriD);
		ledgeriD.setColumns(10);*/
		
		JLabel lblLedgerName = new JLabel("Ledger Name");
		lblLedgerName.setBounds(441, 168, 84, 14);
		contentPane.add(lblLedgerName);
		
		ledgername = new JTextField();
		ledgername.setBounds(543, 165, 148, 20);
		contentPane.add(ledgername);
		ledgername.setColumns(10);
		
		JLabel lblAccountGroup = new JLabel("Account Group");
		lblAccountGroup.setBounds(441, 205, 97, 14);
		contentPane.add(lblAccountGroup);
		
		JComboBox accgroup = new JComboBox(CommonUtil.getAccgrp());
		accgroup.setBounds(543, 196, 148, 20);
		contentPane.add(accgroup);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(441, 105, 84, 14);
		contentPane.add(lblDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(543, 105, 148, 20);
		dateChooser.setDateFormatString("dd-MM-yyyy  hh:mm:ss a");
		Date date = new Date();
		dateChooser.setDate(date);
		contentPane.add(dateChooser);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(441, 230, 84, 14);
		contentPane.add(lblStatus);
		
		Vector model = new Vector();
        model.addElement( new DropDownItem(1, "Active" ) );
        model.addElement( new DropDownItem(2, "Deactive" ) );
        
		JComboBox ledgercomboBox = new JComboBox(model);
		ledgercomboBox.setBounds(543, 227, 148, 20);
		contentPane.add(ledgercomboBox);
		
		JLabel lblLedgerCode = new JLabel("Ledger Code");
		lblLedgerCode.setBounds(439, 143, 86, 14);
		contentPane.add(lblLedgerCode);
		
		ledgercode = new JTextField();
		ledgercode.setBounds(543, 136, 148, 20);
		contentPane.add(ledgercode);
		ledgercode.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int custId=0;
				try {
					String query="insert into ledger(LedgerName,AccountGroupId,Status,Date,LedgerCode,CustomerId) values(?,?,?,?,?,?)";
					Statement tm =DbConnection.getconnection().createStatement();
					PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
					pt.setString(1, ledgername.getText());
					DropDownItem itemcat = (DropDownItem)accgroup.getSelectedItem();
					pt.setInt(2, itemcat.getId());
					DropDownItem item = (DropDownItem)ledgercomboBox.getSelectedItem();
					  String status=  item.getId()==1?"A":"D";
					pt.setString(3, status);
					java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
					pt.setTimestamp(4, date);
					pt.setString(5, ledgercode.getText());
					String sqlQ="SELECT max(CustomerId) as id FROM customer";
 					ResultSet rs =tm.executeQuery(sqlQ);
 					while(rs.next()){
 						custId = rs.getInt("id");
 					}
 					pt.setInt(6, custId);
					pt.execute();
					
					ledgername.setText("");
					status.isEmpty();
					dateChooser.setCalendar(null);
					ledgercode.setText("");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(489, 267, 89, 23);
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
