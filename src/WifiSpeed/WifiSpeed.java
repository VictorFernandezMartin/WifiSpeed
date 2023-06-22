package WifiSpeed;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.Icon;

/**
 * 
 * @author Victor Fdez
 *
 */

public class WifiSpeed extends JFrame {

	private JPanel contentPane;
	CodigoWifiSpeed codigo = new CodigoWifiSpeed();
	private JLabel lblNewLabel;

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
	
	//Imagen logo
		@Override
		public Image getIconImage() {
			Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/LogoVFnegro.png"));
			return retValue;
		}

	/**
	 * Create the frame.
	 */
	public WifiSpeed() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 518);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(78, 78, 171));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setTitle("WifiSpeed by Victor Fdez");
		setIconImage(getIconImage());

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblWifiSpeed = new JLabel("WifiSpeed");
		lblWifiSpeed.setForeground(new Color(255, 255, 255));
		lblWifiSpeed.setBackground(new Color(255, 255, 255));
		lblWifiSpeed.setFont(new Font("Gadugi", Font.BOLD, 40));
		lblWifiSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		lblWifiSpeed.setBounds(249, 22, 193, 59);
		contentPane.add(lblWifiSpeed);
		 
		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setForeground(new Color(255, 255, 255));
		lblEmpresa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmpresa.setBounds(133, 130, 175, 43);
		contentPane.add(lblEmpresa);
		lblEmpresa.setVisible(false);

		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setForeground(new Color(255, 255, 255));
		lblUbicacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblUbicacion.setBounds(379, 130, 175, 43);
		contentPane.add(lblUbicacion);
		lblUbicacion.setVisible(false);

		JLabel lblPing = new JLabel("Ping");
		lblPing.setForeground(new Color(255, 255, 255));
		lblPing.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPing.setHorizontalAlignment(SwingConstants.CENTER);
		lblPing.setBounds(222, 241, 235, 49);
		contentPane.add(lblPing);
		lblPing.setVisible(false);

		JLabel lblDownload = new JLabel("Download");
		lblDownload.setForeground(new Color(255, 255, 255));
		lblDownload.setHorizontalAlignment(SwingConstants.CENTER);
		lblDownload.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDownload.setBounds(429, 301, 235, 49);
		contentPane.add(lblDownload);
		lblDownload.setVisible(false);

		JLabel lblUpload = new JLabel("Upload");
		lblUpload.setForeground(new Color(255, 255, 255));
		lblUpload.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpload.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUpload.setBounds(21, 301, 235, 49);
		contentPane.add(lblUpload);
		lblUpload.setVisible(false);

		JLabel lblPerdida = new JLabel("Packet Loss");
		lblPerdida.setForeground(new Color(255, 255, 255));
		lblPerdida.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPerdida.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerdida.setBounds(266, 393, 159, 43);
		contentPane.add(lblPerdida);
		lblPerdida.setVisible(false);
		
		JLabel lblLoading = new JLabel("Cargando ...");
		lblLoading.setForeground(new Color(255, 255, 255));
		lblLoading.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblLoading.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoading.setBounds(159, 184, 362, 82);
		contentPane.add(lblLoading);
		lblLoading.setVisible(false);
		
		JLabel imgSubida = new JLabel();
		imgSubida.setForeground(new Color(5, 243, 237));
		imgSubida.setFont(new Font("Tahoma", Font.PLAIN, 20));
		imgSubida.setHorizontalAlignment(SwingConstants.CENTER);
		imgSubida.setText("Subida");
		imgSubida.setLocation(21, 266);
		imgSubida.setSize(235, 49);
		ImageIcon imagenSubida = new ImageIcon("imagenes/datosSubida.png");
		Icon iconSubida = new ImageIcon(imagenSubida.getImage().getScaledInstance(imgSubida.getWidth(), imgSubida.getHeight(), Image.SCALE_DEFAULT));
		imgSubida.setIcon(iconSubida);
		contentPane.add(imgSubida);
		imgSubida.setVisible(false);
		
		JLabel imgDescarga = new JLabel();
		imgDescarga.setText("Descarga");
		imgDescarga.setHorizontalAlignment(SwingConstants.CENTER);
		imgDescarga.setForeground(new Color(255, 0, 255));
		imgDescarga.setFont(new Font("Tahoma", Font.PLAIN, 20));
		imgDescarga.setBounds(429, 266, 235, 49);
		contentPane.add(imgDescarga);
		imgDescarga.setVisible(false);
		
		JLabel imgPing = new JLabel();
		imgPing.setText("Ping");
		imgPing.setHorizontalAlignment(SwingConstants.CENTER);
		imgPing.setForeground(new Color(255, 255, 128));
		imgPing.setFont(new Font("Tahoma", Font.PLAIN, 20));
		imgPing.setBounds(222, 205, 235, 49);
		contentPane.add(imgPing);
		imgPing.setVisible(false);
		
		JLabel imgPerdida = new JLabel("Perdida de Paquetes");
		imgPerdida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		imgPerdida.setForeground(new Color(255, 255, 255));
		imgPerdida.setHorizontalAlignment(SwingConstants.CENTER);
		imgPerdida.setBounds(266, 381, 159, 28);
		contentPane.add(imgPerdida);
		imgPerdida.setVisible(false);
		

		JButton btnRepetir = new JButton("Repetir Test");
		btnRepetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WifiSpeed frame = new WifiSpeed(); // Reemplaza "MiAppPrincipal" por el nombre de tu clase principal
		        frame.setVisible(true);
		        dispose();
				
			}
		});
		btnRepetir.setBounds(565, 440, 110, 28);
		contentPane.add(btnRepetir);
		btnRepetir.setVisible(false);
		btnRepetir.setEnabled(false);

		JButton btnTest = new JButton("TEST");
		btnTest.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnTest.setForeground(new Color(0, 0, 0));
		btnTest.setBackground(new Color(20, 192, 211));
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnTest.setEnabled(false); // Desactivar el botón durante el proceso
				btnTest.setVisible(false);
				
				lblLoading.setVisible(true);
				
				//lblLoading.setText(codigo.loading(true));

				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                
		                // Aquí puedes continuar con el resto del código
		                String test = CodigoWifiSpeed.datosInternet(); 
		                
		                // Resto del código...
		                lblEmpresa.setVisible(true);
						lblEmpresa.setText("Empresa: \n" + CodigoWifiSpeed.empresaRed(test));

						lblUbicacion.setVisible(true);
						lblUbicacion.setText("Ubicacion: \n" + CodigoWifiSpeed.ubicacionRed(test));
						
						imgSubida.setVisible(true);
						imgDescarga.setVisible(true);
						imgPing.setVisible(true);

						lblPing.setVisible(true);
						double latencia = CodigoWifiSpeed.latenciaRed(test);

						lblUpload.setVisible(true);
						double subida = CodigoWifiSpeed.subidaRed(test);

						lblDownload.setVisible(true);
						double descarga = CodigoWifiSpeed.descargaRed(test);
						
						/**
						 * Funcionamiento para la latencia
						 */
						SwingWorker<Void, Integer> workerLatencia = new SwingWorker<Void, Integer>() {
							@Override
							protected Void doInBackground() throws Exception {
								for (int i = 0; i <= latencia; i++) {
									Thread.sleep(80); // Retardo para simular la suma progresiva
									publish(i); // Publicar el progreso
								}
								
								return null;
							}

							@Override
							protected void process(java.util.List<Integer> chunks) {
								int latestValue = chunks.get(chunks.size() - 1); // Obtener el último valor publicado
								lblPing.setText(Integer.toString(latestValue) + "ms"); // Actualizar el texto del JLabel
							}

							@Override
							protected void done() {
								// btnTest.setEnabled(true); // Reactivar el botón cuando el proceso ha
								// finalizado
								lblPing.setText(Double.toString(latencia) + " ms");
							}
						};

						workerLatencia.execute(); // Ejecutar el SwingWorker

						/**
						 * Funcionamiento para la Subida
						 */
						SwingWorker<Void, Integer> workerSubida = new SwingWorker<Void, Integer>() {
							@Override
							protected Void doInBackground() throws Exception {
								for (int i = 0; i <= subida; i++) {
									Thread.sleep(40); // Retardo para simular la suma progresiva
									publish(i); // Publicar el progreso
								}
								
								return null;
							}

							@Override
							protected void process(java.util.List<Integer> chunks) {
								int latestValue = chunks.get(chunks.size() - 1); // Obtener el último valor publicado
								lblUpload.setText(Integer.toString(latestValue) + " Mb/s"); // Actualizar el texto del JLabel
							}

							@Override
							protected void done() {
								lblUpload.setText(subida + " Mb/s");
							}
						};

						workerSubida.execute(); // Ejecutar el SwingWorker

						/**
						 * Funcionamiento para la Descarga
						 */
						SwingWorker<Void, Integer> workerDescarga = new SwingWorker<Void, Integer>() {
							@Override
							protected Void doInBackground() throws Exception {
								for (int i = 0; i <= descarga; i++) {
									Thread.sleep(40); // Retardo para simular la suma progresiva
									publish(i); // Publicar el progreso
								}
								
								return null;
							}

							@Override
							protected void process(java.util.List<Integer> chunks) {
								int latestValue = chunks.get(chunks.size() - 1); // Obtener el último valor publicado
								lblDownload.setText(Integer.toString(latestValue) + " Mb/s"); // Actualizar el texto del JLabel
							}

							@Override
							protected void done() {
								lblDownload.setText(descarga + " Mb/s");
							}
						};

						workerDescarga.execute();
						
						btnRepetir.setVisible(true);
						btnRepetir.setEnabled(true);

						// Mostramos la perdida de paquetes
						imgPerdida.setVisible(true);
						lblPerdida.setVisible(true);
						lblPerdida.setText(codigo.perdidaRed(test));
						
						//codigo.loading(false);
						lblLoading.setVisible(false);
						//codigo.ruta();
		            }
		        });

			}
		});
		btnTest.setBounds(266, 150, 153, 167);
		contentPane.add(btnTest);
		
		
	}
}
