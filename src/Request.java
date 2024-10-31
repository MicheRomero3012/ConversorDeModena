import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private String url;
    private String method;
    private Map<String, String> headers = new HashMap<>();
    private String body;

    public Request(String url, String method) {
        this.url = url;
        this.method = method.toUpperCase();
    }
    public void addHeader(String key, String value) {
        headers.put(key, value);
    }

    public void setBody(String body) {
        this.body = body;
    }

    public HttpRequest build() {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder().uri(URI.create(url));
        switch (method) {
            case "POST":
                requestBuilder.POST(HttpRequest.BodyPublishers.ofString(body != null ? body : ""));
                break;
            case "PUT":
                requestBuilder.PUT(HttpRequest.BodyPublishers.ofString(body != null ? body : ""));
                break;
            case "DELETE":
                requestBuilder.DELETE();
                break;
            default:
                requestBuilder.GET();
        }

        headers.forEach(requestBuilder::header);

        return requestBuilder.build();
    }
}


