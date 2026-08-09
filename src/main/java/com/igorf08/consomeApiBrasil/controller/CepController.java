package com.igorf08.consomeApiBrasil.controller;

import com.igorf08.consomeApiBrasil.dto.CepResponseDTO;
import com.igorf08.consomeApiBrasil.service.CepService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CepController {

    private final CepService cepService;


    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/consulta-cep")
    public String paginaInicial() {
        return "busca-cep";
    };

    @GetMapping("/consulta-cep/buscar")
    public String buscarCep(
            @RequestParam(value = "cep", required = false) String cep,
            @RequestParam(value  = "detalhada", defaultValue = "false") Boolean detalhada,
            Model model) {
        if (cep != null && !cep.isBlank()) {
            CepResponseDTO resultado = cepService.buscaCep(cep);
            model.addAttribute("resultadoCep", resultado);
        }

        if (detalhada == true) {
            model.addAttribute("detalhada", detalhada);
        }

        return "busca-cep";
    };

}
