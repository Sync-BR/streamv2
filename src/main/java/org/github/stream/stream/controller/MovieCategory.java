package org.github.stream.stream.controller;

import org.github.stream.stream.response.MovieCategoryResponse;
import org.github.stream.stream.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieCategory {
    private final MovieService service;

    public MovieCategory(MovieService service) {
        this.service = service;
    }

    @GetMapping("/categorias")
    public List<MovieCategoryResponse> listarCategorias() throws Exception {
        return service.listarCategorias();
    }
}
