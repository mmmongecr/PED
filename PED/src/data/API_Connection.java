/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Manuel Mora Monge
 */


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API_Connection {
    
    public User queryByIDCardNumber(String IDNumber){
        try {
            // URL del API
            String url = "https://apis.gometa.org/cedulas/" + IDNumber;

            // Crea el cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crea la solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

            // Envia la consulta y obtiene la respuesta en formato JSON, luego la transforma a Strings
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verifica si se recibe respuesta
            if (response.statusCode() == 200) {
                
/*
                // Convertir JSON a objetos Java
                ObjectMapper objectMapper = new ObjectMapper();
                ApiResponse apiResponse = objectMapper.readValue(response.body(), ApiResponse.class);

                // Acceder a los datos
                System.out.println("Nombre: " + apiResponse.getNombre());
                for (ApiResponse.Result result : apiResponse.getResults()) {
                    System.out.println("Nombre completo: " + result.getFullname());
                }*/
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return null;
    }
}