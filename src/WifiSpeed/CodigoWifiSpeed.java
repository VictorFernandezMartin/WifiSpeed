package WifiSpeed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodigoWifiSpeed {

	public static String datosInternet() {
		String datos = "";
		try {
			ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "SpeedTest");
			pb.redirectErrorStream(true);
			Process process = pb.start();

			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String leer = "";
			while ((leer = br.readLine()) != null) {
				datos += leer + "\n";
			}

			int exitCode = process.waitFor();
			if (exitCode != 0) {
				datos = "Error ejecutando el comando SpeedTest.";
			}
			
			br.close();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			datos = "Error al obtener la velocidad.";
		}

		System.out.println(datos);
		return datos;
	}

	public static String perdidaRed(String perdida) {
		String[] datos = perdida.split("\n");
		String perdidaPaquetes = "";
		for (String linea : datos) {
			if (linea.contains("Packet Loss:")) {
				int startIndex = linea.indexOf("Packet Loss:") + "Packet Loss:".length();
				perdidaPaquetes = linea.substring(startIndex).trim();
				break;
			}
		}
		System.out.println(perdidaPaquetes);
		return perdidaPaquetes;
	}

	public static String empresaRed(String empresa) {
		String[] datos = empresa.split("\n");
		String empresaRed = "";
		for (String linea : datos) {
			if (linea.contains("ISP:")) {
				String[] palabras = linea.trim().split(" ");
				empresaRed = palabras[1];
				break;
			}
		}
		System.out.println(empresaRed);
		return empresaRed;
	}
	
	public static String ubicacionRed(String ubicacion) {
		String[] datos = ubicacion.split("\n");
		String ubicacionRed = "";
		for (String linea : datos) {
			if (linea.contains("Server:")) {
				int startIndex = linea.indexOf("-") + "-".length();
				int endIndex = linea.indexOf("(");
				ubicacionRed = linea.substring(startIndex, endIndex).trim();
				break;
			}
		}
		System.out.println(ubicacionRed);
		return ubicacionRed;
	}

	public static String latenciaRed(String latencia) {
		String[] datos = latencia.split("\n");
		String latenciaRed = "";
		for (String linea : datos) {
			if (linea.contains("Idle Latency:")) {
				int startIndex = linea.indexOf("Idle Latency:") + "Idle Latency:".length();
				int endIndex = linea.indexOf("(");
				latenciaRed = linea.substring(startIndex, endIndex).trim();
				break;
			}
		}
		System.out.println(latenciaRed);
		return latenciaRed;
	}

	public static String descargaRed(String descarga) {
		String[] datos = descarga.split("\n");
		String descargaRed = "";
		for (String linea : datos) {
			if (linea.contains("Download:")) {
				int startIndex = linea.indexOf("Download:") + "Download:".length();
				int endIndex = linea.indexOf("(");
				descargaRed = linea.substring(startIndex, endIndex).trim();
				break;
			}
		}
		System.out.println(descargaRed);
		return descargaRed;
	}

	public static String subidaRed(String subida) {
		String[] datos = subida.split("\n");
		String subidaRed = "";
		for (String linea : datos) {
			if (linea.contains("Upload:")) {
				int startIndex = linea.indexOf("Upload:") + "Upload:".length();
				int endIndex = linea.indexOf("(");
				subidaRed = linea.substring(startIndex, endIndex).trim();
				break;
			}
		}
		System.out.println(subidaRed);
		return subidaRed;
	}

}