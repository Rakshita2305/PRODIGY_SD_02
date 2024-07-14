package rakshita;

import java.awt.EventQueue;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Guess extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int n;
    private JTextField textField;
    private int ch;
    private JButton playAgainButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Guess frame = new Guess((int) (Math.random() * 100)); // Initialize with a random number between 0 and 99
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
    public Guess(int n) {
        this.n = n;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Guess The Number Here");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(87, 11, 263, 29);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBounds(161, 40, 96, 34);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lbl1 = new JLabel("");
        lbl1.setBackground(new Color(240, 240, 240));
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
        lbl1.setBounds(58, 134, 326, 36);
        contentPane.add(lbl1);

        JLabel lbl2 = new JLabel("");
        lbl2.setBackground(new Color(240, 240, 240));
        lbl2.setHorizontalAlignment(SwingConstants.CENTER);
        lbl2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
        lbl2.setBounds(68, 169, 316, 36);
        contentPane.add(lbl2);

        JButton playAgainButton = new JButton("Play Again");
        playAgainButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Guess.this.setVisible(false);
        		NumberGame Framee = new NumberGame();
        		Framee.setVisible(true);
        	}
        });
        playAgainButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        playAgainButton.setBounds(144, 216, 139, 36);
        contentPane.add(playAgainButton);
        playAgainButton.setVisible(false);

        ch = 0;
        
        JButton btnNewButton = new JButton("COMPARE");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ch++;
                try {
                    int nm = Integer.parseInt(textField.getText());
                    if (nm == n) {
                        lbl1.setText("Congratulations! You Guessed It.");
                        lbl2.setText("You Took " + ch + " chances to guess");
                        playAgainButton.setVisible(true);
                    } else {
                        lbl1.setText("Oh No! You Guessed It Wrong.");
                        lbl2.setText("Guess Again.");
                        playAgainButton.setVisible(false);
                    }
                } catch (NumberFormatException ex) {
                    lbl1.setText("Please enter a valid number.");
                    lbl2.setText("");
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.setBounds(66, 85, 118, 36);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("TRY AGAIN");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lbl1.setText("");
        		lbl2.setText("");
        		textField.setText("");
        	}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton_1.setBounds(232, 85, 128, 38);
        contentPane.add(btnNewButton_1);
        
    }
}
