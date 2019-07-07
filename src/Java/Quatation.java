package Java;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

import DB.DbConnection;
import jewelleryUtil.CommonUtil;
import jewelleryUtil.NumtoString;
import model.DropDownItem;

import java.awt.Color;
import java.awt.Component;

import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Quatation extends JFrame {

	private JPanel contentPane;
	private static Quatation framesalescr;
	private JTextField invoice;
	private JTextField contactno;
	private JTextField name;
	private JTextField goldrate;
	private JTextField slno;
	private JTextField hsncode;
	private JTextField quantity;
	private JTextField gwt;
	private JTextField swt;
	private JTextField netwt;
	private JTextField rate;
	private JTextField va;
	private JTextField afterdis;
	private JTextField stonecash;
	private JTextField totalamount;
	public static int y=229;
	public static Integer keyset=1;
	public static HashMap<Integer, Object> map = new HashMap<Integer, Object>();
	private JTextField Cash;
	private JTextField cashdiscount;
	private JTextField taxrs;
	private JTextField cgst;
	private JTextField sgst;
	private JTextField igst;
	private JTextField totalamtpay;
	private JTextField amntinwords;
	public static JComboBox itemname;
	public static JComboBox itemnames;
	private JTextField tnwt;
	private JTextField alltmt;
	private static double tamt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					framesalescr = new Quatation();
					framesalescr.setVisible(true);
					framesalescr.setTitle("Quatation Page");
					SwingUtilities.updateComponentTreeUI(framesalescr);
					framesalescr.repaint();
					framesalescr.revalidate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Quatation() throws SQLException {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 1330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 153));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSalesInvoice = new JLabel("Quatation");
		lblSalesInvoice.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblSalesInvoice.setForeground(new Color(0, 0, 0));
		lblSalesInvoice.setBounds(602, 59, 250, 34);
		contentPane.add(lblSalesInvoice);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDate.setForeground(new Color(0, 0, 255));
		lblDate.setBounds(10, 29, 88, 14);
		contentPane.add(lblDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(108, 23, 151, 20);
		contentPane.add(dateChooser);
		
		JLabel lblInvoiceNumber = new JLabel("Invoice Number");
		lblInvoiceNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInvoiceNumber.setForeground(new Color(255, 0, 0));
		lblInvoiceNumber.setBounds(10, 54, 102, 14);
		contentPane.add(lblInvoiceNumber);
		
		invoice = new JTextField();
		invoice.setBounds(108, 51, 151, 20);
		contentPane.add(invoice);
		invoice.setColumns(10);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContactNo.setForeground(new Color(51, 0, 0));
		lblContactNo.setBounds(10, 79, 88, 14);
		contentPane.add(lblContactNo);
		
		contactno = new JTextField();
		contactno.setBounds(108, 76, 151, 20);
		contentPane.add(contactno);
		contactno.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setForeground(new Color(0, 51, 0));
		lblName.setBounds(10, 104, 88, 14);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setBounds(108, 101, 151, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setForeground(new Color(51, 0, 102));
		lblAddress.setBounds(10, 149, 88, 14);
		contentPane.add(lblAddress);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(108, 126, 151, 50);
		contentPane.add(textArea);
		
		/*JComboBox ggoldrate = new JComboBox(CommonUtil.getAllCatageory());
		ggoldrate.setBounds(1051, 51, 94, 20);
		contentPane.add(ggoldrate);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(1155, 51, 56, 20);
		contentPane.add(spinner);
		
		goldrate = new JTextField();
		goldrate.setBounds(1216, 51, 86, 20);
		contentPane.add(goldrate);
		goldrate.setColumns(10);*/
		
		/*double Rt=dailyrate();
		double dt =Double.parseDouble(rate.getText());
		int douy=(int) dt;*/
		int rd=11;
		double rt=Rate.getdailyrate(rd);
		String s =rt+"";//int douy=(int) rt;
		JLabel lblDailyRate = new JLabel( "Daily Rate : " +s);
		lblDailyRate.setBounds(1169, 82, 146, 14);
		contentPane.add(lblDailyRate);
		
		JLabel lblSlNo = new JLabel("Sl No");
		lblSlNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSlNo.setBounds(10, 204, 76, 14);
		contentPane.add(lblSlNo);
		
		slno = new JTextField();
		slno.setBounds(0, 229, 62, 20);
		contentPane.add(slno);
		slno.setColumns(10);
		
		JLabel lblHsnCode = new JLabel("HSN Code");
		lblHsnCode.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHsnCode.setBounds(82, 204, 62, 14);
		contentPane.add(lblHsnCode);
		
		hsncode = new JTextField();
		hsncode.setBounds(72, 229, 76, 20);
		contentPane.add(hsncode);
		hsncode.setColumns(10);
		
		JLabel lblProductCode = new JLabel("Product Code");
		lblProductCode.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProductCode.setBounds(161, 204, 83, 14);
		contentPane.add(lblProductCode);
		
		JComboBox productcode = new JComboBox(CommonUtil.getProductCode());
		productcode.setBounds(158, 229, 86, 20);
		contentPane.add(productcode);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblItemName.setBounds(266, 204, 72, 14);
		contentPane.add(lblItemName);
		
		 itemname = new JComboBox(CommonUtil.getProductName());
		itemname.setBounds(254, 229, 102, 20);
		contentPane.add(itemname);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblModel.setBounds(376, 204, 62, 14);
		contentPane.add(lblModel);
		
		JComboBox model = new JComboBox(CommonUtil.getAllModel());
		model.setBounds(366, 229, 72, 20);
		contentPane.add(model);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuantity.setBounds(462, 204, 62, 14);
		contentPane.add(lblQuantity);
		
		quantity = new JTextField();
		quantity.setBounds(448, 229, 76, 20);
		contentPane.add(quantity);
		quantity.setColumns(10);
		
		JLabel lblGWt = new JLabel("G . Wt");
		lblGWt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGWt.setBounds(551, 204, 46, 14);
		contentPane.add(lblGWt);
		
		gwt = new JTextField();
		gwt.setBounds(534, 229, 86, 20);
		contentPane.add(gwt);
		gwt.setColumns(10);
		
		JLabel lblSWt = new JLabel("S . Wt");
		lblSWt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSWt.setBounds(645, 204, 46, 14);
		contentPane.add(lblSWt);
		
		swt = new JTextField();
		swt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				double netweight;
				try {
					netweight=totalweight(Double.parseDouble(gwt.getText()),Double.parseDouble(swt.getText()));
					netwt.setText(netweight+"");
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		swt.setBounds(630, 229, 86, 20);
		contentPane.add(swt);
		swt.setColumns(10);
		
		JLabel lblNetWt = new JLabel("Net Wt");
		lblNetWt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNetWt.setBounds(746, 204, 46, 14);
		contentPane.add(lblNetWt);
		
		netwt = new JTextField();
		netwt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) 
			{
				double Rate;
				try {
					Rate=dailyrate();
					double nt=Double.parseDouble(netwt.getText());
					System.out.println( "DAILY Rate IS"+Rate);
					rate.setText((Rate*nt)+"");
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		netwt.setBounds(726, 229, 86, 20);
		contentPane.add(netwt);
		netwt.setColumns(10);
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRate.setBounds(845, 204, 46, 14);
		contentPane.add(lblRate);
		
		rate = new JTextField();
		rate.setBounds(822, 229, 94, 20);
		contentPane.add(rate);
		rate.setColumns(10);
		
		JLabel lblVa = new JLabel("VA%");
		lblVa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVa.setBounds(940, 204, 46, 14);
		contentPane.add(lblVa);
		
		va = new JTextField();
		
		va.setBounds(926, 229, 62, 20);
		contentPane.add(va);
		va.setColumns(10);
		
		JLabel lblAfterDis = new JLabel("  After Dis");
		lblAfterDis.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAfterDis.setBounds(996, 204, 64, 14);
		contentPane.add(lblAfterDis);
		
		afterdis = new JTextField();
		afterdis.setBounds(998, 229, 76, 20);
		contentPane.add(afterdis);
		afterdis.setColumns(10);
		
		JLabel lblStoneCash = new JLabel("Stone cash");
		lblStoneCash.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStoneCash.setBounds(1082, 204, 64, 14);
		contentPane.add(lblStoneCash);
		
		stonecash = new JTextField();
		stonecash.setBounds(1084, 229, 62, 20);
		contentPane.add(stonecash);
		stonecash.setColumns(10);
		va.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				double dt =Double.parseDouble(rate.getText());
				double vaT=Double.parseDouble(va.getText());
				totalamount.setText(dt+(dt*vaT/100)+"");
				double ta =Double.parseDouble(totalamount.getText());
				double tAll=Double.parseDouble(alltmt.getText());
				alltmt.setText((ta+tAll)+"");
				
			}
		});
		stonecash.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				double tot =Double.parseDouble(totalamount.getText());
				double st=Double.parseDouble(stonecash.getText());
				totalamount.setText((tot+st-tamt)+"");
				double ta =Double.parseDouble(totalamount.getText());
				double tAll=Double.parseDouble(alltmt.getText());
				alltmt.setText((st+tAll-tamt)+"");
			}
			@Override
			public void focusGained(FocusEvent arg0) {
				
				try {
					tamt = Double.parseDouble(stonecash.getText());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					tamt=0;
				}
				
			}
		});
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalAmount.setBounds(1158, 204, 77, 14);
		contentPane.add(lblTotalAmount);
		
		totalamount = new JTextField();
		totalamount.setBounds(1149, 229, 102, 20);
		contentPane.add(totalamount);
		totalamount.setColumns(10);
		
		JLabel lblAdd = new JLabel("Add");
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdd.setBounds(1273, 204, 29, 14);
		contentPane.add(lblAdd);
		
		JLabel lblPurchaseDetails = new JLabel("Purchase Details");
		lblPurchaseDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPurchaseDetails.setBounds(227, 298, 176, 34);
		contentPane.add(lblPurchaseDetails);
		
		JLabel lblCashCard = new JLabel("Cash / Card");
		lblCashCard.setBounds(177, 360, 82, 28);
		contentPane.add(lblCashCard);
		
		Cash = new JTextField();
		//Cash.setText("Rs");
		Cash.setBounds(291, 364, 182, 20);
		contentPane.add(Cash);
		Cash.setColumns(10);
		
		JLabel lblCashDiscount = new JLabel("       Cash Discount");
		lblCashDiscount.setBounds(1084, 311, 99, 14);
		contentPane.add(lblCashDiscount);
		
		cashdiscount = new JTextField();
		cashdiscount.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				
				
				
				double tAll=Double.parseDouble(alltmt.getText());
				double dis=Double.parseDouble(cashdiscount.getText());
				double cdis=Double.parseDouble((tAll-dis)+"");
				totalamtpay.setText(cdis+"");
				try {
					Map map=Tax.gettax();
					double TT=Double.parseDouble(totalamtpay.getText());
					double cTax=(double)map.get("CGST");
					double sTax=(double)map.get("SGST");
					double iTax=(double)map.get("IGST");
					double TaxableValue =Math.round( (TT/ ((100+cTax+sTax+iTax)/100) ));
					
					taxrs.setText(TaxableValue+"");
					double tx=Double.parseDouble(taxrs.getText());
					double cst=(double)tx*cTax/100;
					double st=(double)tx*sTax/100;
					double it=(double)tx*iTax/100;
					cgst.setText(cst+"");
					sgst.setText(st+"");
					igst.setText(it+"");
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				double tlamt=Double.parseDouble(alltmt.getText());
				double ds=Double.parseDouble(cashdiscount.getText());
				double tars=tlamt-ds;
				taxrs.setText(tars+"");
				
				
			}
		});
		//cashdiscount.setText("RS ");
		cashdiscount.setBounds(1193, 308, 167, 20);
		contentPane.add(cashdiscount);
		cashdiscount.setColumns(10);
		cashdiscount.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblTaxablevalue = new JLabel("         TaxableValue");
		lblTaxablevalue.setBounds(1082, 337, 102, 14);
		contentPane.add(lblTaxablevalue);
		
		taxrs = new JTextField();
		taxrs.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) 
			{
				double tmp=Double.parseDouble(taxrs.getText());
				double tmp1=Double.parseDouble(cgst.getText());
				double tmp2=Double.parseDouble(sgst.getText());
				double tmp3=Double.parseDouble(igst.getText());
				double totvalueis=tmp+tmp1+tmp2+tmp3;
				totalamtpay.setText(totvalueis+"");
				try {
					amntinwords.setText(NumtoString.convertAmountToWord(totvalueis));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		//taxrs.setText("RS");
		taxrs.setHorizontalAlignment(SwingConstants.RIGHT);
		taxrs.setBounds(1193, 337, 167, 20);
		contentPane.add(taxrs);
		taxrs.setColumns(10);
		
		JLabel lblCgst = new JLabel("                   CGST");
		lblCgst.setBounds(1092, 367, 90, 14);
		contentPane.add(lblCgst);
		
		cgst = new JTextField();
		cgst.setBounds(1193, 364, 167, 20);
		contentPane.add(cgst);
		cgst.setColumns(10);
		cgst.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblSgst = new JLabel("                       SGST");
		lblSgst.setBounds(1082, 392, 100, 14);
		contentPane.add(lblSgst);
		
		sgst = new JTextField();
		sgst.setBounds(1193, 389, 167, 20);
		contentPane.add(sgst);
		sgst.setColumns(10);
		sgst.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblIgst = new JLabel("                     IGST");
		lblIgst.setBounds(1092, 413, 90, 14);
		contentPane.add(lblIgst);
		
		igst = new JTextField();
		igst.setBounds(1193, 414, 167, 20);
		contentPane.add(igst);
		igst.setColumns(10);
		igst.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblTotalAmountPayable = new JLabel("            Total Amount Payable");
		lblTotalAmountPayable.setBounds(1036, 448, 146, 14);
		contentPane.add(lblTotalAmountPayable);
		
		totalamtpay = new JTextField();
		//totalamtpay.setText("RS");
		totalamtpay.setBounds(1193, 445, 167, 20);
		contentPane.add(totalamtpay);
		totalamtpay.setColumns(10);
		totalamtpay.setHorizontalAlignment(SwingConstants.RIGHT);
		
		amntinwords = new JTextField();
		amntinwords.setBounds(24, 445, 1036, 20);
		contentPane.add(amntinwords);
		amntinwords.setColumns(10);
		
		tnwt = new JTextField();
		tnwt.setBounds(726, 260, 86, 20);
		contentPane.add(tnwt);
		tnwt.setColumns(10);
		
		alltmt = new JTextField();
		alltmt.setBounds(1149, 260, 102, 20);
		contentPane.add(alltmt);
		alltmt.setColumns(10);
		alltmt.setText(0.0+"");
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.setBackground(new Color(255, 255, 51));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Quatation.y=Quatation.y+30;
				
				JTextField slnos = new JTextField();
				slnos.setBounds(0, Quatation.y, 62, 20);
				contentPane.add(slnos);
				slnos.setColumns(10);
				
				JTextField hsncodes = new JTextField();
				hsncodes.setBounds(72, Quatation.y, 76, 20);
				contentPane.add(hsncodes);
				hsncodes.setColumns(10);
				
				JComboBox productcodes = new JComboBox(CommonUtil.getProductCode());
				productcodes.setBounds(158, Quatation.y, 86, 20);
				contentPane.add(productcodes);
				
				 itemnames = new JComboBox(CommonUtil.getProductName());
				itemnames.setBounds(254, Quatation.y, 102, 20);
				contentPane.add(itemnames);
				
				JComboBox models = new JComboBox(CommonUtil.getAllModel());
				models.setBounds(366, Quatation.y, 72, 20);
				contentPane.add(models);
				
				JTextField quantitys = new JTextField();
				quantitys.setBounds(448, Quatation.y, 76, 20);
				contentPane.add(quantitys);
				quantitys.setColumns(10);
				
				JTextField gwts = new JTextField();
				gwts.setBounds(534, Quatation.y, 86, 20);
				contentPane.add(gwts);
				gwts.setColumns(10);
				
				JTextField swts = new JTextField();
				swts.setBounds(630, Quatation.y, 86, 20);
				contentPane.add(swts);
				swts.setColumns(10);
				
				JTextField netwts = new JTextField();
				netwts.setBounds(726, Quatation.y, 86, 20);
				contentPane.add(netwts);
				netwts.setColumns(10);
				
				JTextField rates = new JTextField();
				rates.setBounds(822, Quatation.y, 94, 20);
				contentPane.add(rates);
				rates.setColumns(10);
				
				JTextField vas = new JTextField();
				vas.setBounds(926, Quatation.y, 62, 20);
				contentPane.add(vas);
				vas.setColumns(10);
				
				JTextField afterdiss = new JTextField();
				afterdiss.setBounds(998, Quatation.y, 76, 20);
				contentPane.add(afterdiss);
				afterdiss.setColumns(10);
				
				JTextField stonecashs = new JTextField();
				stonecashs.setBounds(1084, Quatation.y, 62, 20);
				contentPane.add(stonecashs);
				stonecashs.setColumns(10);
				
				JTextField totalamounts = new JTextField();
				totalamounts.setBounds(1149, Quatation.y, 102, 20);
				contentPane.add(totalamounts);
				totalamounts.setColumns(10);
				
				/*JTextField  tnwts = new JTextField();
				tnwts.setBounds(726, SalesScreen.y, 86, 20);
				contentPane.add(tnwts);
				tnwts.setColumns(10);
				
				JTextField alltmts = new JTextField();
				alltmts.setBounds(1149, SalesScreen.y, 102, 20);
				contentPane.add(alltmts);
				alltmts.setColumns(10);*/
				
				JButton rem = new JButton("Remove");
				rem.putClientProperty( "row",keyset );
				rem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//r=number of counts of mouse click in add button
						//keyset number of arrays counts key value
				    int r=(Integer)((JButton)e.getSource()).getClientProperty( "row" );
				    
				    List<Component> lis=(List<Component>)map.get(r);
					for(Component c: lis){	
						
						
						contentPane.remove(c);
						
						 
					}
	                  map.remove(r);
	                  contentPane.revalidate();
					contentPane.repaint();
					//int coun =1;
					Quatation.y=Quatation.y-30;
					for(int l=(r+1);l<keyset;l++){
					 List<Component> lis12=(List<Component>)map.get(l);
					 if(lis12!= null && !lis12.isEmpty()){
						// coun++;
					 for(Component c:lis12){
						 
						Rectangle re= c.getBounds();
						//to get an x axis value y axis value width and height
						int x= new Double(re.getX()).intValue();
						int y= new Double(re.getY()).intValue();
						int w= new Double(re.getWidth()).intValue();
						int h= new Double(re.getHeight()).intValue();
						
						c.setBounds(x,y-30,w,h);
						
						contentPane.revalidate();
					 }
					 
					
					 
					
					 }
					}
					
					//set the height of bottom components decrements to call the method
					 setPosmin(lblPurchaseDetails);
					 setPosmin(lblCashCard)  ;
					 setPosmin(Cash);
					 setPosmin(lblCashDiscount);
					 setPosmin(cashdiscount)  ;
					 setPosmin(lblTaxablevalue);
					 setPosmin(taxrs);
					 setPosmin(lblCgst);
					 setPosmin(cgst);
					 setPosmin(lblSgst);
					 setPosmin(sgst);
					 setPosmin(lblIgst);
					 setPosmin(igst);
					 setPosmin(lblTotalAmountPayable);
					 setPosmin(totalamtpay);
					 setPosmin(amntinwords);
					 setPosmin(tnwt);
					 setPosmin(alltmt);
					 contentPane.revalidate();
					 contentPane.repaint();
				
					
					}
					
				});
				rem.setBounds(1253, Quatation.y, 62, 23);
				contentPane.add(rem);
				
				List<Component> list=new ArrayList<Component>();
				
				list.add(slnos);
				list.add(hsncodes);
				list.add(productcodes);
				list.add(itemnames);
				list.add(models);
				list.add(quantitys);
				list.add(gwts);
				list.add(swts);
				list.add(netwts);
				list.add(rates);
				list.add(vas);
				list.add(afterdiss);
				list.add(stonecashs);
				list.add(totalamounts);
				list.add(rem);
				
				
				
				//set the height of bottom components increments to call the method
				setPos(lblPurchaseDetails);
			setPos(lblCashCard)  ;
				setPos(Cash);
				setPos(lblCashDiscount);
				setPos(cashdiscount)  ;
				setPos(lblTaxablevalue);
				setPos(taxrs);
				setPos(lblCgst);
				setPos(cgst);
				setPos(lblSgst);
				setPos(sgst);
				setPos(lblIgst);
				setPos(igst);
				setPos(lblTotalAmountPayable);
				setPos(totalamtpay);
				setPos(amntinwords);
				setPos(tnwt);
				setPos(alltmt);
				
				swts.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent arg0) {
						double netweight;
						try {
							netweight=totalweight(Double.parseDouble(gwts.getText()),Double.parseDouble(swts.getText()));
							netwts.setText(netweight+"");
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				
				
				
				netwts.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent arg0) 
					{
						 int id=0;
						double Rate;
						try {
							JTextField tText =(JTextField)arg0.getComponent();
							Set<Integer> set =Quatation.map.keySet();
							for(int key:set){
							List<Component> lis=(List<Component>)Quatation.map.get(key);
							for(Component c:lis){
								
								if(c==tText){
									JComboBox compo=(JComboBox)lis.get(3);
									DropDownItem itemprodname = (DropDownItem)compo.getSelectedItem();
									id =itemprodname.getId();
								}
							}
								
							}
							Rate=dailyrateLis(id);
							double nt=Double.parseDouble(netwts.getText());
							
							//rate.setText((Rate*nt)+"");
							rates.setText((Rate*nt)+"");
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				
				vas.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent arg0) {
						double dt =Double.parseDouble(rates.getText());
						double vaT=Double.parseDouble(vas.getText());
						totalamounts.setText(dt+(dt*vaT/100)+"");
						double ta =Double.parseDouble(totalamounts.getText());
						double tAll=Double.parseDouble(alltmt.getText());
						alltmt.setText((ta+tAll)+"");
						double tnw=Double.parseDouble(netwt.getText());
						double tnw1=Double.parseDouble(netwts.getText());
						tnwt.setText((tnw1+tnw)+"");
					}
				});
				stonecashs.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent arg0) {
						double tot =Double.parseDouble(totalamounts.getText());
						double st=Double.parseDouble(stonecashs.getText());
						totalamounts.setText((tot+st-tamt)+"");
						double ta =Double.parseDouble(totalamounts.getText());
						double tAll=Double.parseDouble(alltmt.getText());
						alltmt.setText((st+tAll-tamt)+"");
					}
					@Override
					public void focusGained(FocusEvent arg0) {
						
						try {
							tamt = Double.parseDouble(stonecashs.getText());
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							tamt=0;
						}
						
					}
				});
				
				Quatation.map.put(keyset, list);
				keyset++;
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		btnAdd.setBounds(1253, 228, 62, 23);
		contentPane.add(btnAdd);
		
		JButton btnSubmit = new JButton("Save");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int custId=0;
				int CashDataId=0;
				  try{
	 					
	 					String query2="insert into customer(CustomerName,ContactNo,Address) "+ "values(?,?,?)";
	 							
	 					Statement tm =DbConnection.getconnection().createStatement();
	 					PreparedStatement pt2=DbConnection.getconnection().prepareStatement(query2);
	 					
	 					pt2.setString(1, name.getText());
	 					pt2.setString(2, contactno.getText());
	 					pt2.setString(3, textArea.getText());
	 					pt2.execute();
	 					pt2.close();
	 					String sqlQ="SELECT max(CustomerId) as id FROM customer";
	 					ResultSet rs =tm.executeQuery(sqlQ);
	 					while(rs.next()){
	 						custId = rs.getInt("id");
	 					}
	 					
	 					name.setText("");
	 					contactno.setText("");
	 					textArea.setText("");
	 					}
	 					catch (SQLException e2) {
	 						// TODO Auto-generated catch block
	 						e2.printStackTrace();
	 					}
				
               try{
					
					String query1="insert into qucashdata(Cash, Cashdiscount, Taxrs, Cgst, Sgst, IGST, Totalamtpay, Amntinwords, Invoiceno, Date,CustomerId) "+ "values(?,?,?,?,?,?,?,?,?,?,?)";
							
					Statement tm =DbConnection.getconnection().createStatement();
					PreparedStatement pt1=DbConnection.getconnection().prepareStatement(query1);
					
					pt1.setString(1, Cash.getText());
					pt1.setDouble(2, Double.parseDouble(cashdiscount.getText()));
					pt1.setDouble(3, Double.parseDouble(taxrs.getText()));
					pt1.setDouble(4, Double.parseDouble(cgst.getText()));
					pt1.setDouble(5, Double.parseDouble(sgst.getText()));
					pt1.setDouble(6, Double.parseDouble(igst.getText()));
					pt1.setDouble(7, Double.parseDouble(totalamtpay.getText()));
					pt1.setString(8, amntinwords.getText());
					pt1.setString(9, invoice.getText());
				
					java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
					pt1.setTimestamp(10, date);
					pt1.setInt(11, custId);
					pt1.execute();
					pt1.close();
					
					Cash.setText("");
					cashdiscount.setText("");
					taxrs.setText("");
					cgst.setText("");
					sgst.setText("");
					igst.setText("");
					totalamtpay.setText("");
					amntinwords.setText("");
					invoice.setText("");
					}
					catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
               
               
               
               
               
               
				try{
					
				String query="insert into qusalesscreen(ProductCode,ProductName, HSNCode, Quantity, Gwt, Swt, Netwt, Rate, Va,  StoneCash, Totalamount, ModelId,CashDataId) "+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
						
				Statement tm =DbConnection.getconnection().createStatement();
				PreparedStatement pt=DbConnection.getconnection().prepareStatement(query);
				
				
				DropDownItem itemprodcode = (DropDownItem)model.getSelectedItem();
				pt.setInt(1, itemprodcode.getId());
				DropDownItem itemprodname = (DropDownItem)itemname.getSelectedItem();
				pt.setInt(2, itemprodname.getId());
				pt.setString(3, hsncode.getText());
				pt.setInt(4, Integer.parseInt(quantity.getText()));
				pt.setDouble(5, Double.parseDouble(gwt.getText()));
				pt.setDouble(6, Double.parseDouble(swt.getText()));
				pt.setDouble(7, Double.parseDouble(netwt.getText()));
				pt.setDouble(8, Double.parseDouble(rate.getText()));
				pt.setDouble(9, Double.parseDouble(va.getText()));
				//pt.setDouble(10, Double.parseDouble(afterdis.getText()));
				pt.setDouble(10, Double.parseDouble(stonecash.getText()));
				pt.setDouble(11, Double.parseDouble(totalamount.getText()));
				DropDownItem itemcatcde = (DropDownItem)productcode.getSelectedItem();
				pt.setInt(12, itemcatcde.getId());
				//to link the cashdata table to salesscreen using foriegn key
				String sqlsalesscreen="SELECT max(CashDataId) as cashid FROM cashdata";
					ResultSet rs =tm.executeQuery(sqlsalesscreen);
					while(rs.next()){
						CashDataId = rs.getInt("cashid");
					}
				pt.setInt(13, CashDataId);
				pt.execute();
                
				
				for(int i=1;i<keyset;i++)
				{
					 pt=DbConnection.getconnection().prepareStatement(query);
				List<Component> lis=(List<Component>)map.get(i);
				/*list.add(slnos);
				list.add(hsncodes);
				list.add(productcodes);
				list.add(itemnames);
				list.add(models);
				list.add(quantitys);
				list.add(gwts);
				list.add(swts);
				list.add(netwts);
				list.add(rates);
				list.add(vas);
				list.add(afterdiss);
				list.add(stonecashs);
				list.add(totalamounts);
				list.add(rem);*/
				//consider the component where the component j starts from save
				int j=1;
				Component c=lis.get(2);
					
				//to see above list arrange in ascending order
				   
				    DropDownItem Ccatcde = (DropDownItem)productcode.getSelectedItem();
				    pt.setInt(1, Ccatcde.getId());
				    j++;
			    
			    c=lis.get(3);
			    DropDownItem pname = (DropDownItem)itemname.getSelectedItem();
				pt.setInt(2, pname.getId());
				j++;
				
				c=lis.get(1);
				String hsncod=((JTextField)c).getText();
				pt.setString(3, hsncod);
			    j++;
			    
			    c=lis.get(5);
			    Integer quantit=Integer.parseInt(((JTextField)c).getText());
				pt.setInt(4, quantit);
			    j++;
			    
			    c=lis.get(6);
			    Double Gwt=Double.parseDouble(((JTextField)c).getText());
				pt.setDouble(5, Gwt);
			    j++;
			    
			    c=lis.get(7);
			    Double Swt=Double.parseDouble(((JTextField)c).getText());
				pt.setDouble(6, Swt);
			    j++;
			    
			    c=lis.get(8);
			    Double Netwt=Double.parseDouble(((JTextField)c).getText());
				pt.setDouble(7, Netwt);
			    j++;
			    
			    c=lis.get(9);
			    Double Rate=Double.parseDouble(((JTextField)c).getText());
				pt.setDouble(8, Rate);
			    j++;
			    
			    c=lis.get(10);
			    Double Va=Double.parseDouble(((JTextField)c).getText());
				pt.setDouble(9, Va);
			    j++;
			    
			    /*c=lis.get(j);
			    Double AfterDis=Double.parseDouble(((JTextField)c).getText());
				pt.setDouble(11, AfterDis);
			    j++;*/
			    j++;
			    
			    c=lis.get(12);
			    Double StoneCash=Double.parseDouble(((JTextField)c).getText());
				pt.setDouble(10, StoneCash);
			    j++;
			    
			    c=lis.get(13);
			    Double Totalamount=Double.parseDouble(((JTextField)c).getText());
				pt.setDouble(11, Totalamount);
			    j++;
			    
			    c=lis.get(4);
				DropDownItem pcode = (DropDownItem)model.getSelectedItem();
				pt.setInt(12, pcode.getId());
			    j++;
			    
			    pt.setInt(13, CashDataId);
			    j++;
			    
			    pt.execute();
			    pt.close();
				}
				
				
				
				
				/*try {
					String query1="insert into stock(Date,ProductId,ModelId,Quantity,NetWt) values(?,?,?,?,?)";
					Statement tm1 =DbConnection.getconnection().createStatement();
					PreparedStatement pt1=DbConnection.getconnection().prepareStatement(query1);
					pt1.setDate(1,new java.sql.Date(dateChooser.getDate().getTime()));
					DropDownItem itemprodcode1 = (DropDownItem)itemname.getSelectedItem();
					pt1.setInt(2, itemprodcode1.getId());
					DropDownItem model1 = (DropDownItem)model.getSelectedItem();
					pt1.setInt(3, model1.getId());
					double qt=Double.parseDouble(quantity.getText());
					pt1.setDouble(4, -qt );
					double nt=Double.parseDouble(netwt.getText());
					pt1.setDouble(5, -nt);
					
					pt1.execute();
					quantity.setText("");
					netwt.setText("");
					dateChooser.setCalendar(null);
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				hsncode.setText("");
				quantity.setText("");
				gwt.setText("");
				swt.setText("");
				netwt.setText("");
				rate.setText("");
				va.setText("");
				afterdis.setText("");
				stonecash.setText("");
				totalamount.setText("");
				
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				/*try{
 					
 					String sql="insert into invoice(InvoiceId) "+ "values(?)";
 							
 					Statement tm =DbConnection.getconnection().createStatement();
 					PreparedStatement pt2=DbConnection.getconnection().prepareStatement(sql);
 					
 					pt2.setString(1, name.getText());
 					
 					
 					}
 					catch (SQLException e3) {
 						// TODO Auto-generated catch block
 						e3.printStackTrace();
 					}*/
				
				
				try {
					framesalescr.setVisible(false);
					framesalescr = new Quatation();
					framesalescr.setVisible(true);
					framesalescr.setTitle("Quatation Page");
					SwingUtilities.updateComponentTreeUI(framesalescr);
					framesalescr.repaint();
					framesalescr.revalidate();
				} catch (Exception e) {
					e.printStackTrace();
				}
                 
              
			}
		});
		btnSubmit.setBackground(new Color(255, 51, 51));
		btnSubmit.setBounds(1323, 228, 57, 23);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Viewpage.main(new String[]{});
        		setVisible(false);
			}
		});
		btnBack.setBounds(1291, 11, 89, 23);
		contentPane.add(btnBack);
		
		
		
		
		
		
		
		
		
		
	}
	public static void setPos(JComponent comp){
		 Rectangle re=comp.getBounds();
		  
		  
		    comp.setBounds(re.x , re.y+30 ,re.width,re.height);
		    comp.revalidate();
		    comp.repaint();
		    System.out.println(re.x+" , "+ (re.y+30)+" , "+re.height+" , "+re.width+" add");
			
	}
	public static void setPosmin(JComponent compon){
		 Rectangle rem=compon.getBounds();
		    System.out.println(rem.x+" , "+ rem.y+"  , "+rem.width+", "+rem.height);
		  
		    compon.setBounds(rem.x , rem.y-30 ,rem.width,rem.height);
		    compon.revalidate();
		    compon.repaint();
		    System.out.println(rem.x+" , "+ (rem.y-30)+"  , "+rem.width+", "+rem.height);
			
	}
	
	public static double totalweight(double grmwt,double swt) throws SQLException
	{
		DecimalFormat df = new DecimalFormat("#.####");
		 double Nwt1=grmwt-swt;
		 double Nwt=Double.parseDouble(df.format(Nwt1));
		/*double Nwt=grmwt-swt);
		NumberFormat nf = NumberFormat.getInstance();
		double Nwt=nf.format(number)(grmwt-swt);*/
		return Nwt;
		
	}
	public static double dailyrate() throws SQLException
	{
		DropDownItem itemprodname = (DropDownItem)itemname.getSelectedItem();
		int cid =itemprodname.getId();
		 double rateamt=Rate.getRate(cid );
		return rateamt;
		
	}
	public static double dailyrateLis(int cid) throws SQLException
	{
	
		 double rateamt=Rate.getRate(cid );
		return rateamt;
		
	}
}
