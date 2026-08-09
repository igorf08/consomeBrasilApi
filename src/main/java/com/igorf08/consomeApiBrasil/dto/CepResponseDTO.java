package com.igorf08.consomeApiBrasil.dto;

import com.igorf08.consomeApiBrasil.utils.CepUtils;

public record CepResponseDTO(String cep, String state, String city, String neighborhood, String street, String timezoneName, LocationDTO location) {
    public String getCepFormatado() {
        return CepUtils.formatCep(this.cep);
    }
}
