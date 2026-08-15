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
    private String descricao_tipo_de_logradouro;
    private String razao_social;
    private String nome_fantasia;
    private String descricao_situacao_cadastral;

    public CnpjModel() {
    }

    public CnpjModel(String cnpj, String uf, String cep, String email, PorteEnum porte, String bairro, String municipio, String logradouro, String descricao_tipo_de_logradouro, String razao_social, String nome_fantasia, String descricao_situacao_cadastral) {
        this.cnpj = cnpj;
        this.uf = uf;
        this.cep = cep;
        this.email = email;
        this.porte = porte;
        this.bairro = bairro;
        this.municipio = municipio;
        this.logradouro = logradouro;
        this.descricao_tipo_de_logradouro = descricao_tipo_de_logradouro;
        this.razao_social = razao_social;
        this.nome_fantasia = nome_fantasia;
        this.descricao_situacao_cadastral = descricao_situacao_cadastral;
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

    public String getDescricao_tipo_de_logradouro() {
        return descricao_tipo_de_logradouro;
    }

    public void setDescricao_tipo_de_logradouro(String descricao_tipo_de_logradouro) {
        this.descricao_tipo_de_logradouro = descricao_tipo_de_logradouro;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getDescricao_situacao_cadastral() {
        return descricao_situacao_cadastral;
    }

    public void setDescricao_situacao_cadastral(String descricao_situacao_cadastral) {
        this.descricao_situacao_cadastral = descricao_situacao_cadastral;
    }
}
