package gob.cpccs.utilidades;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;

/**
 * Controlador VerificarRecaptcha
 *
 * Este archivo contiene métodos para el controlador VerificarRecaptcha
 *
 * @property CPCCS
 * @author Carlos Anchundia
 * @email e.du.ingcharles@hotmail.com
 * @date 2019-01-14
 * @uses VerificarRecaptcha
 * @package gob.cpccs.utilidades
 * @subpackage 
 * 
 */

public class VerificarRecaptcha {

	public static final String URL = "https://www.google.com/recaptcha/api/siteverify";

	private final static String USER_AGENT = "Mozilla/5.0";

	public static boolean verify(String gRecaptchaResponse) throws IOException {
		if (gRecaptchaResponse == null || "".equals(gRecaptchaResponse)) {
			return false;
		}
		
		try{
		URL obj = new URL(URL);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

	
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		String postParams = "secret=" + Constantes.KEY_SECRETO_RECAPTCHA + "&response=" + gRecaptchaResponse + "&remoteip==" + InetAddress.getLocalHost().getHostAddress();
	
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(postParams);
		wr.flush();
		wr.close();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		JsonReader jsonReader = Json.createReader(new StringReader(response.toString()));
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		//System.out.println(response.toString()+"..."+jsonObject.getBoolean("success"));
		    return jsonObject.getBoolean("success");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}