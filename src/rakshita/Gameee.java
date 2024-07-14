package rakshita;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.Color;

public class Gameee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int n;
	private JLabel lbl3; // Instance variable for JLabel
	private JButton btnGuessIt; // Instance variable for JButton

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gameee frame = new Gameee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gameee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select the Range");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(138, 11, 161, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lbl1 = new JLabel("Lower");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl1.setBounds(94, 38, 68, 23);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("Upper");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl2.setBounds(266, 38, 75, 23);
		contentPane.add(lbl2);
		
		String[] arr1 = {" ","0","10","20","30","50","70","100","120","140","160"};
		JComboBox comboBox = new JComboBox(arr1);
		comboBox.setBounds(94, 63, 63, 29);
		contentPane.add(comboBox);
		
		String[] arr2 = {" ","10","20","30","50","70","100","125","150","175","200"};
		JComboBox comboBox_1 = new JComboBox(arr2);
		comboBox_1.setBounds(276, 63, 65, 29);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("RANDOM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int lower = Integer.parseInt((String) comboBox.getSelectedItem());
				int upper = Integer.parseInt((String) comboBox_1.getSelectedItem());
				if(lower < upper) {
					Random random = new Random();
					int randomNumber = random.nextInt((upper - lower) + 1) + lower;
					n = randomNumber;
					lbl3.setText("The number is selected.");
					btnGuessIt.setVisible(true);
				} else {
					lbl3.setText("<html>Inappropriate range.<br>   Select again.</html>");
					btnGuessIt.setVisible(false);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(158, 101, 117, 34);
		contentPane.add(btnNewButton);
		
		lbl3 = new JLabel(""); // Initialize lbl3
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl3.setBounds(121, 146, 193, 61);
		contentPane.add(lbl3);
		
		btnGuessIt = new JButton("GUESS IT"); // Initialize btnGuessIt
		btnGuessIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gameee.this.setVisible(false);
				Guess conver = new Guess(n);
				conver.setVisible(true);
			}
		});
		btnGuessIt.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGuessIt.setBounds(158, 218, 117, 34);
		contentPane.add(btnGuessIt);
		btnGuessIt.setVisible(false); // Initially hide btnGuessIt
		
	}

}
