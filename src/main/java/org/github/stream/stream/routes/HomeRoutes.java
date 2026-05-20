package org.github.stream.stream.routes;

import org.github.stream.stream.service.MovieService;
import org.github.stream.stream.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class HomeRoutes {
    private final MovieService service;
    private final RequestUtil util;
    public HomeRoutes(MovieService service, RequestUtil util) {
        this.service = service;
        this.util = util;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }


    @GetMapping("/filmes")
    public String movie(Model model) throws IOException, InterruptedException {
        model.addAttribute("category", service.listarCategorias());
        model.addAttribute("listMovie",
                service.listarFilmes()
                        .stream()
                        .limit(20)
                        .toList()
        );

        return "movie";
    }
}
