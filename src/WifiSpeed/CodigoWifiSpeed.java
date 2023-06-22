package WifiSpeed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.io.File;

public class CodigoWifiSpeed {
	
	public static String ruta() {
	    try {
	        File archivo = new File(CodigoWifiSpeed.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	        String ruta = archivo.getParent();
	        ruta = URLDecoder.decode(ruta, "UTF-8");
	        ruta += "\\SpeedTest.exe";
	        //System.out.println(ruta);
	        return ruta;
	    } catch (UnsupportedEncodingException e) {
	        // Manejar la excepción en caso de que ocurra un error de codificación
	        e.printStackTrace();
	        return null; // o manejar el error de alguna otra manera
	    }
	}
	
	public static String loading(boolean cargando) {
		String loading = "";
		
		while (cargando==true) {
			loading = "Haciendo Test de Velocidad ...";
		}
		
		return loading;
	}

	public static String datosInternet() {
		String datos = "";
		try {
			ProcessBuilder pb = new ProcessBuilder("cmd", "/c", ruta());
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
		//System.out.println("C:\\Users\\Victor Fdez\\eclipse-workspace\\WifiSpeed\\SpeedTest.exe");
		//System.out.println(datos);
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
		//System.out.println(perdidaPaquetes);
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
		//System.out.println(empresaRed);
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
		//System.out.println(ubicacionRed);
		return ubicacionRed;
	}

	public static double latenciaRed(String latencia) {
		String[] datos = latencia.split("\n");
		double latenciaRed = 0;
		for (String linea : datos) {
			if (linea.contains("Idle Latency:")) {
				int startIndex = linea.indexOf("Idle Latency:") + "Idle Latency:".length();
				int endIndex = linea.indexOf("m");
				String latenciaString = linea.substring(startIndex, endIndex).trim();
				latenciaRed = Double.parseDouble(latenciaString);
				break;
			}
		}
		//System.out.println(latenciaRed);
		return latenciaRed;
	}

	public static double descargaRed(String descarga) {
		String[] datos = descarga.split("\n");
		double descargaRed = 0;
		for (String linea : datos) {
			if (linea.contains("Download:")) {
				int startIndex = linea.indexOf("Download:") + "Download:".length();
				int endIndex = linea.indexOf("M");
				String descargaString = linea.substring(startIndex, endIndex).trim();
				descargaRed = Double.parseDouble(descargaString);
				break;
			}
		}
		//System.out.println(descargaRed);
		return descargaRed;
	}

	public static double subidaRed(String subida) {
		String[] datos = subida.split("\n");
		double subidaRed = 0;
		for (String linea : datos) {
			if (linea.contains("Upload:")) {
				int startIndex = linea.indexOf("Upload:") + "Upload:".length();
				int endIndex = linea.indexOf("M");
				String subidaString = linea.substring(startIndex, endIndex).trim();
				subidaRed = Double.parseDouble(subidaString);
				break;
			}
		}
		//System.out.println(subidaRed);
		return subidaRed;
	}

}