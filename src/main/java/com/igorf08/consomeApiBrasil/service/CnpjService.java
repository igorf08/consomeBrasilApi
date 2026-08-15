package com.igorf08.consomeApiBrasil.service;

import com.igorf08.consomeApiBrasil.dto.CnpjResponseDTO;
import com.igorf08.consomeApiBrasil.model.CnpjModel;
import com.igorf08.consomeApiBrasil.repository.CnpjRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class CnpjService {

    private final RestTemplate restTemplate;
    private final CnpjRepository repository;

    public CnpjService(RestTemplate restTemplate, CnpjRepository repository) {
        this.restTemplate = restTemplate;
        this.repository = repository;
    }

    public CnpjResponseDTO buscaCnpj(String cnpj) {
        String url = "https://brasilapi.com.br/api/cnpj/v1/{cnpj}";

        String decodedCnpj = URLDecoder.decode(cnpj, StandardCharsets.UTF_8);
        Optional<CnpjModel> buscaCnpjNoDb = repository.findByCnpj(decodedCnpj.replaceAll("[^a-zA-Z0-9]", ""));
        System.out.println(decodedCnpj.replaceAll("[^a-zA-Z0-9]", ""));

        if (buscaCnpjNoDb.isPresent()) {
            CnpjModel cnpjModel = buscaCnpjNoDb.get();
            return new CnpjResponseDTO(
                    cnpjModel.getCnpj(),
                    cnpjModel.getUf(),
                    cnpjModel.getCep(),
                    cnpjModel.getEmail(),
                    cnpjModel.getPorte(),
                    cnpjModel.getBairro(),
                    cnpjModel.getMunicipio(),
                    cnpjModel.getLogradouro(),
                    cnpjModel.getDescricao_tipo_de_logradouro(),
                    cnpjModel.getDescricao_situacao_cadastral(),
                    cnpjModel.getNome_fantasia(),
                    cnpjModel.getRazao_social()
            );
        }

        CnpjResponseDTO responseDTO = restTemplate.getForObject(url, CnpjResponseDTO.class, cnpj);
        CnpjModel cnpjModel = new CnpjModel(
                responseDTO.cnpj(),
                responseDTO.uf(),
                responseDTO.cep(),
                responseDTO.email(),
                responseDTO.porte(),
                responseDTO.bairro(),
                responseDTO.municipio(),
                responseDTO.logradouro(),
                responseDTO.descricao_tipo_de_logradouro(),
                responseDTO.razao_social(),
                responseDTO.nome_fantasia(),
                responseDTO.descricao_situacao_cadastral()
        );

        repository.save(cnpjModel);
        return responseDTO;
    };

}
