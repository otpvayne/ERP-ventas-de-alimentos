/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;



import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class WhatsAppNotifier {

    // Cambia estos datos por los tuyos reales
    private static final String API_KEY = "6480046"; // ← Pega tu API key aquí
    private static final String PHONE_NUMBER = "573017472421"; // ← Cambia por tu número

    public static void enviarMensaje(String mensaje) {
        try {
            String encodedMessage = URLEncoder.encode(mensaje, "UTF-8");
            String urlString = "https://api.callmebot.com/whatsapp.php?phone=" + PHONE_NUMBER
                    + "&text=" + encodedMessage + "&apikey=" + API_KEY;

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.getResponseCode(); // Esto es importante para que se envíe

        } catch (UnsupportedEncodingException e) {
            System.out.println("Error codificando mensaje: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error enviando mensaje: " + e.getMessage());
        }
    }
}
