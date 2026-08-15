package com.igorf08.consomeApiBrasil.controller;

import com.igorf08.consomeApiBrasil.dto.CnpjResponseDTO;
import com.igorf08.consomeApiBrasil.service.CnpjService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CnpjController {

    private final CnpjService cnpjService;

    public CnpjController(CnpjService cnpjService) {
        this.cnpjService = cnpjService;
    }

    @GetMapping("/consulta-cnpj")
    public String paginaInicial() {
        return "busca-cnpj";
    }

    @GetMapping("/consulta-cnpj/buscar")
    public String buscarCnpj(
            @RequestParam(name = "cnpj") String cnpj,
            @RequestParam(name = "detalhada", defaultValue = "false") Boolean detalhada,
            Model model) {

        if (cnpj != null && !cnpj.isBlank()) {
            CnpjResponseDTO resultado = cnpjService.buscaCnpj(cnpj);
            model.addAttribute("resultadoCnpj", resultado);
        }

        if (detalhada == true) {
            model.addAttribute("detalhada", detalhada);
        }

        return "busca-cnpj";

    }
}
