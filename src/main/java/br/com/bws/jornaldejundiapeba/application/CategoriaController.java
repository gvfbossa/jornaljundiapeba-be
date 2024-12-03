package br.com.bws.jornaldejundiapeba.application;

import br.com.bws.jornaldejundiapeba.domain.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @GetMapping
    public List<Category> getCategorias() {
        return List.of(Category.values());
    }

}
