package br.com.bws.jornaldejundiapeba.application;

import br.com.bws.jornaldejundiapeba.domain.model.Type;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tipos")
public class TipoController {

    @GetMapping
    public List<Type> getTipos() {
        return List.of(Type.values());
    }

}
