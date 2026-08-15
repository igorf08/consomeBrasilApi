package com.igorf08.consomeApiBrasil.dto;

import com.igorf08.consomeApiBrasil.dto.enums.PorteEnum;
import com.igorf08.consomeApiBrasil.utils.CepUtils;
import com.igorf08.consomeApiBrasil.utils.CnpjUtils;

public record CnpjResponseDTO(
        String cnpj,
        String uf,
        String cep,
        String email,
        PorteEnum porte,
        String bairro,
        String municipio,
        String logradouro,
        String descricao_tipo_de_logradouro,
        String descricao_situacao_cadastral,
        String nome_fantasia,
        String razao_social ) {
    public String getCepFormatado() {
        return CepUtils.formatCep(this.cep);
    }
    public String getCnpjFormatado() {
        return CnpjUtils.cnpjFormat(this.cnpj);
    }
}
