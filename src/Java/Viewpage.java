package Java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class Viewpage extends JFrame {

	private JPanel contentPane;
static Viewpage frameview;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameview= new Viewpage();
					frameview.setVisible(true);
					frameview.setTitle("View Page");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Viewpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 1331);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JMenuBar menuBar = new JMenuBar();// 1. create an menubar
		menuBar.setBackground(new Color(255, 204, 204));//set background color for menubar
		menuBar.setToolTipText("menu bar");
		setJMenuBar(menuBar);
		//setPreferredSize( new Dimension( 400, 40 ) );
		JMenu mnFile = new JMenu("     MASTER                  ");
		mnFile.setBackground(new Color(0, 0, 255));
		mnFile.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnFile);             // add the menubar to menu
		JMenuItem rate = new JMenuItem("    RATE        ");//3.create an menuitem
		rate.setBackground(new Color(204, 102, 0));
		rate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Rate frame = new Rate();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		JMenuItem tax = new JMenuItem("    TAX              ");
		tax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tax frame = new Tax();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		JMenuItem vendor = new JMenuItem("     VENDOR               ");
		vendor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vendor frame = new Vendor();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		JMenuItem category = new JMenuItem("    CATEGORY               ");
		category.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Category.main(new String[]{});
				frameview.dispose();
				//frame.setVisible(true);
				//setVisible(false);
			}
		});
		JMenuItem product = new JMenuItem("    PRODUCT                    ");
		product.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product frame = new Product();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		JMenuItem employee = new JMenuItem("    EMPLOYEE                       ");
		employee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Employee frame = new Employee();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		JMenuItem customer = new JMenuItem("    CUSTOMER                      ");
		customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Customer frame = new Customer();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		
		
		mnFile.add(rate);
		mnFile.add(tax);
		mnFile.add(vendor);
		mnFile.add(category);
		mnFile.add(product);
		mnFile.add(employee);
		mnFile.add(customer);
		
		
		JMenu mnFile1 = new JMenu("TRANSACTIONS         ");
		mnFile1.setBackground(Color.ORANGE);
		menuBar.add(mnFile1);
		
		JMenuItem sales = new JMenuItem("SALES");
		sales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SalesScreen framesalescr = new SalesScreen();
				framesalescr.setVisible(true);
				setVisible(false);
			}
		});
		
		JMenuItem purchase = new JMenuItem("PURCHASE");
		purchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PurchaseScreen framepchse = new PurchaseScreen();
				framepchse.setVisible(true);
				setVisible(false);
			}
		});
		JMenuItem salesreturn = new JMenuItem("SALES RETURN");
		salesreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SalesReturn framesalescr = new SalesReturn();
				framesalescr.setVisible(true);
				setVisible(false);
			}
		});
		JMenuItem ledger = new JMenuItem("LEDGER");
		ledger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ledger frame = new Ledger();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		JMenuItem accountgroup = new JMenuItem("ACCOUNT GROUP");
		accountgroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AccountGroup frame = new AccountGroup();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		JMenuItem advancereturn = new JMenuItem("ADVANCE RETURN");
		JMenuItem repairissue = new JMenuItem("REPAIR ISSUE");
		
		mnFile1.add(sales);
		mnFile1.add(purchase);
		mnFile1.add(salesreturn);
		mnFile1.add(ledger);
		mnFile1.add(accountgroup);
		mnFile1.add(advancereturn);
		mnFile1.add(repairissue);
		
		
		
		
		JMenu mnFile2 = new JMenu("REPORT       ");
		menuBar.add(mnFile2);
		JMenuItem jewellsreport = new JMenuItem("JEWELLS REPORT");
		mnFile2.add(jewellsreport);
		
		//contentPane.add(menuBar);
		
		
		
	}
}
