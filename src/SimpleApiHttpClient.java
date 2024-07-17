import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class SimpleApiHttpClient {

    public String fetchData(String url) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            // Imprime uma mensagem de erro amigável e retorna uma string vazia
            System.err.println("Error during fetch data: " + e.getMessage());
            return "";
        }
    }

    public List<Post> parseJsonPosts(String jsonString) {
        Gson gson = new Gson();
        Type postListType = new TypeToken<List<Post>>() {}.getType();
        return gson.fromJson(jsonString, postListType);
    }
}
