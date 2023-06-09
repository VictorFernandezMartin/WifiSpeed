package WifiSpeed;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class WifiSpeed extends JFrame {

	private JPanel contentPane;
	CodigoWifiSpeed codigo = new CodigoWifiSpeed();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WifiSpeed frame = new WifiSpeed();
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
	public WifiSpeed() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setTitle("WifiSpeed by Victor Fdez");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWifiSpeed = new JLabel("WifiSpeed");
		lblWifiSpeed.setFont(new Font("Gadugi", Font.BOLD, 40));
		lblWifiSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		lblWifiSpeed.setBounds(202, 23, 253, 59);
		contentPane.add(lblWifiSpeed);
		

		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setForeground(new Color(0, 0, 0));
		lblEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresa.setBounds(230, 391, 78, 23);
		contentPane.add(lblEmpresa);
		
		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblUbicacion.setBounds(355, 391, 78, 23);
		contentPane.add(lblUbicacion);
		
		JLabel lblPing = new JLabel("Ping");
		lblPing.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPing.setHorizontalAlignment(SwingConstants.CENTER);
		lblPing.setBounds(263, 249, 126, 71);
		contentPane.add(lblPing);
		
		JLabel lblDownload = new JLabel("Download");
		lblDownload.setHorizontalAlignment(SwingConstants.CENTER);
		lblDownload.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDownload.setBounds(439, 287, 126, 71);
		contentPane.add(lblDownload);
		
		JLabel lblUpload = new JLabel("Upload");
		lblUpload.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpload.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUpload.setBounds(78, 287, 126, 71);
		contentPane.add(lblUpload);
		 
		JButton btnTest = new JButton("TEST");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnTest.setBounds(252, 138, 153, 67);
				
				/*String test = codigo.datosInternet();
				
				lblPing.setText(codigo.latenciaRed(test));
				lblUbicacion.setText(codigo.ubicacionRed(test));
				lblUpload.setText(codigo.subidaRed(test));
				lblEmpresa.setText(codigo.empresaRed(test));
				lblDownload.setText(codigo.descargaRed(test));*/
				
			}
		});
		btnTest.setBounds(252, 138, 153, 167);
		contentPane.add(btnTest);
		
	}
}
