import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            SimpleApiHttpClient client = new SimpleApiHttpClient();
            String jsonResponse = client.fetchData("https://jsonplaceholder.typicode.com/posts");

            // Verifica se a resposta não está vazia
            if (!jsonResponse.isEmpty()) {
                List<Post> posts = client.parseJsonPosts(jsonResponse);

                for (Post post : posts) {
                    System.out.println(post);
                }
            } else {
                System.err.println("No data was fetched from the URL.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
