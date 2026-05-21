package org.github.stream.stream.util;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class RequestUtil {

    @Value("${api.server.movie}")
    private String serverPanel;

    private final HttpClient client;


    public RequestUtil() {
        this.client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();
    }


    public HttpResponse<InputStream> createResponse(Long streamId) throws IOException, InterruptedException {
        HttpRequest request = createRequest(streamId);

        return client.send(
                request,
                HttpResponse.BodyHandlers.ofInputStream()
        );
    }

    private HttpRequest createRequest(Long streamId) {

        return HttpRequest.newBuilder()
                .uri(URI.create(serverPanel+streamId+".mp4"))
                .header("User-Agent", "Mozilla/5.0")
                .header("Accept", "*/*")
                .header("Connection", "keep-alive")
                .GET()
                .build();
    }
}