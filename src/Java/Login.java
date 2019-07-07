package Java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Keymap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setTitle("Login Page");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 1330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Loginpage");
		lblNewLabel.setFont(new Font("MV Boli", Font.PLAIN, 18));
		lblNewLabel.setBounds(611, 49, 162, 44);
		contentPane.add(lblNewLabel);
		
		/*JButton loginSubmit = new JButton("Submit");
		loginSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Viewpage frame = new Viewpage();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		loginSubmit.setBounds(684, 282, 89, 23);
		contentPane.add(loginSubmit);*/
		
		login = new JTextField();
		//to change the textfield border color
		Border b=BorderFactory.createLineBorder(new Color(153, 255, 153));
		login.setBorder(b);
		//to hide or set mouse pointer color swing
		login.setCaretColor(new Color(153, 255, 153));
		login.setForeground(new Color(153, 255, 153));
		login.setBackground(new Color(153, 255, 153));
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 String pwd=login.getText();
				    if(pwd.equals("a123") )
				    {
				    	Viewpage frame = new Viewpage();
						frame.setVisible(true);
						setVisible(false);
				    }
				    else
				    {
				    	JOptionPane.showMessageDialog(null, "Invalid  Password");
				    }  
			}
		});
		/*login.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				 String pwd=login.getText();
				    if(pwd.equals("a") )
				    {
				    	Viewpage frame = new Viewpage();
						frame.setVisible(true);
						setVisible(false);
				    }
				    else
				    {
				    	JOptionPane.showMessageDialog(null, "Invalid  Password");
				    }  
			}
		});*/
		/*login.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent a) {
				
			   String pwd=login.getText();
			    if(pwd.equals("a") && pwd.equals("a"))
			    {
			    	Viewpage frame = new Viewpage();
					frame.setVisible(true);
					setVisible(false);
			    }
			    else
			    {
			    	JOptionPane.showMessageDialog(null, "Invalid  Password");
			    }    
			      
			}
			
			
		});*/
		login.setBounds(687, 215, 86, 20);
		//login.setVisible(false);
		//login.setEnabled(false);
		contentPane.add(login);
		login.setColumns(10);
	}
}
