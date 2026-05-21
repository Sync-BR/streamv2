package org.github.stream.stream.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.github.stream.stream.response.MovieCategoryResponse;
import org.github.stream.stream.response.MovieResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Component
public class MovieService {

    @Value("${api.server.panel}")
    private String serverPanel;
    private final HttpClient client;
    private final Gson gson;
    public MovieService() {
        this.client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        this.gson = new Gson();
    }

    public List<MovieCategoryResponse> listarCategorias() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverPanel+"&action=get_vod_categories"))
                .header("User-Agent", "Mozilla/5.0")
                .header("Accept", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );



        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro ao buscar categorias. Status: " + response.statusCode());
        }

        Type tipoLista = new TypeToken<List<MovieCategoryResponse>>() {}.getType();

        return gson.fromJson(response.body(), tipoLista);
    }

    public List<MovieResponse> listarFilmes() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(serverPanel+"&action=get_vod_streams"))
                .header("User-Agent", "Mozilla/5.0")
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro ao buscar filmes. Status: " + response.statusCode());
        }

        Type listType = new TypeToken<List<MovieResponse>>() {}.getType();

        return gson.fromJson(response.body(), listType);
    }
}
