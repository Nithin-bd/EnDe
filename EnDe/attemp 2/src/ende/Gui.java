package ende;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.JTextField;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JTextField filepath;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel imagelabel;
	private JTextField ext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 * @throws BadLocationException 
	 */
	public Gui() throws FileNotFoundException, BadLocationException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 413);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new LineBorder(new Color(0, 128, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		filepath = new JTextField();
		filepath.setForeground(Color.WHITE);
		filepath.setBackground(Color.LIGHT_GRAY);
		filepath.setBounds(10, 22, 398, 35);
		contentPane.add(filepath);
		filepath.setColumns(10);
		
		JButton btnNewButton = new JButton("Chooser");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f=chooser.getSelectedFile();
				filepath.setText(f.getAbsolutePath());
			}
		});
		btnNewButton.setBounds(439, 21, 129, 36);
		contentPane.add(btnNewButton);
		
		File encrypted=new File("locked.encrypted");
			
		btnNewButton_1 = new JButton("Encrypt");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				       Key secretKey = new SecretKeySpec("This is a secret".getBytes(), "AES");
				       Cipher cipher = Cipher.getInstance("AES");
				       cipher.init(Cipher.ENCRYPT_MODE, secretKey);
				       FileInputStream inputStream = new FileInputStream(filepath.getText());
				       byte[] b = inputStream.readAllBytes();

				      
				       inputStream.read(b);
				       
				       byte[] outputBytes = cipher.doFinal(b);
				       FileOutputStream outputStream = new FileOutputStream(encrypted);
				       
				       outputStream.write(outputBytes);
				       inputStream.close();
				       outputStream.close();
				       JOptionPane.showMessageDialog(null, "sucessfull encryption");
				    } 
				catch (NoSuchPaddingException | NoSuchAlgorithmException 
			                     | InvalidKeyException | BadPaddingException
				             | IllegalBlockSizeException | IOException e1) {
					e1.printStackTrace();
			            }
			}
		});
		
		btnNewButton_1.setBounds(365, 131, 153, 36);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Decrypt");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					
					   Key secretKey = new SecretKeySpec("This is a secret".getBytes(), "AES");
				       Cipher cipher = Cipher.getInstance("AES");
				       cipher.init(Cipher.DECRYPT_MODE, secretKey);
				       
				       FileInputStream inputStream = new FileInputStream(encrypted);	

				       byte[] inputBytes = new byte[(int)encrypted.length()];	
				       inputStream.read(inputBytes);
				       
				       byte[] outputBytes = cipher.doFinal(inputBytes);
				       
				       FileOutputStream outputStream = new FileOutputStream(new File("decrypt"+ext.getText()));
				       outputStream.write(outputBytes);
				       
				       inputStream.close();
				       outputStream.close();
				       
				       JOptionPane.showMessageDialog(null, "successfull decryption");

				    } catch (NoSuchPaddingException | NoSuchAlgorithmException 
			                     | InvalidKeyException | IOException | BadPaddingException |  IllegalBlockSizeException e1 ) {
					e1.printStackTrace();
					}
			     }
		});
		
		btnNewButton_2.setBounds(365, 218, 153, 36);
		contentPane.add(btnNewButton_2);
		
		imagelabel = new JLabel("");
		imagelabel.setIcon(new ImageIcon(Gui.class.getResource("/ende/encryption.jpg")));
		imagelabel.setBounds(10, 83, 300, 283);
		contentPane.add(imagelabel);
		
		ext = new JTextField();										
		ext.setText(".");
		ext.setBackground(Color.LIGHT_GRAY);
		ext.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		ext.setBounds(464, 283, 54, 21);
		contentPane.add(ext);
		ext.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Extention:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(345, 275, 129, 39);
		contentPane.add(lblNewLabel);
	}
}
