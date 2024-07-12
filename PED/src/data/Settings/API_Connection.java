/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.Settings;

/**
 *
 * @author Manuel Mora Monge
 */



import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class API_Connection {
    
    
    
    public String[] connectAPI(String APIName, String auxInfo) {
        
        String [] apiResult = null;
        
        try {
            // Define el URL del API de acuerdo a cual necesite conectarse
            URL url = switch(APIName){
                case "currencyExchange" -> new URL("https://apis.gometa.org/tdc/tdc.json");
                //case "currencyExchange" -> new URL("https://apis.gometa.org/tdc/tdc.json?fbclid=IwZXh0bgNhZW0CMTAAAR0kLxEXl9ctEYzV5txwklYgdr5LZNDni_GnceFOsRGcJGf9uIVQ37a8ep8_aem_8c-aEstfJumWtQRJqjkNhg");
                case "personalInformationByID" -> new URL("https://apis.gometa.org/cedulas/" + auxInfo);
                default -> null;
            };
            
            // Se crea la conexión con el API
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            
            // Se verifica la respuesta del servidor, si es igual a 200 el resultado fue éxitoso
            // Si es 404 no se encontraron resultados
            // El servidor puede enviar otros códigos de respuesta con diferentes significados
            int responsecode = con.getResponseCode();
            if (responsecode != 200) {
                System.out.println("Error" + responsecode);
            }
            // Si el código del servidor es correcto se crea un StringBuilder para mantener en buffer 
            // la respuesta segmemntada mediante un Scanner
            else {
                StringBuilder informationstring = new StringBuilder();
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()) {
                    informationstring.append(sc.nextLine());
                }
                sc.close();
                
                
                JSONObject dataObject=new JSONObject(String.valueOf(informationstring));
                System.out.println(dataObject.names());
                switch (APIName) {
                    case "currencyExchange":
                        apiResult = new String[2];
                        apiResult[0] = dataObject.getString("compra");
                        apiResult[1] = dataObject.getString("venta");
                        
                        break;
                    case "personalInformationByID":
                        apiResult = new String[5];
                        apiResult[0] = dataObject.getJSONArray("results").getJSONObject(0).getString("firstname1");
                        apiResult[1] = dataObject.getJSONArray("results").getJSONObject(0).getString("firstname2");
                        apiResult[2] = dataObject.getJSONArray("results").getJSONObject(0).getString("lastname1");
                        apiResult[3] = dataObject.getJSONArray("results").getJSONObject(0).getString("lastname2");
                        apiResult[4] = dataObject.getJSONArray("results").getJSONObject(0).getString("admin");
                        break;
                    default:
                        throw new AssertionError();
                }
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return apiResult;

    }
    
    
    
    

    
    
    
}