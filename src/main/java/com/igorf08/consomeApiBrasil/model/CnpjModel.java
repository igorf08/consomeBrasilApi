package com.igorf08.consomeApiBrasil.model;

import com.igorf08.consomeApiBrasil.dto.enums.PorteEnum;
import jakarta.persistence.*;

@Entity
@Table(schema = "consome_api_brasil", name = "tb_cnpjs")
public class CnpjModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String cnpj;

    private String uf;
    private String cep;
    private String email;
    @Enumerated(EnumType.STRING)
    private PorteEnum porte;
    private String bairro;
    private String municipio;
    private String logradouro;

    public CnpjModel() {
    }

    public CnpjModel(String cnpj, String uf, String cep, String email, PorteEnum porte, String bairro, String municipio, String logradouro) {
        this.cnpj = cnpj;
        this.uf = uf;
        this.cep = cep;
        this.email = email;
        this.porte = porte;
        this.bairro = bairro;
        this.municipio = municipio;
        this.logradouro = logradouro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PorteEnum getPorte() {
        return porte;
    }

    public void setPorte(PorteEnum porte) {
        this.porte = porte;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
}
