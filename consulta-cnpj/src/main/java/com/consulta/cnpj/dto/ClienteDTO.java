package com.consulta.cnpj.dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class ClienteDTO {
    private Long id;
    private String razaoSocial;
    private String cidade;
    private String situacaoCadastral;
    private String dataCadastro;
    private String endereco;
    private String telefone;
    private String cnpj;

    public ClienteDTO(String razaoSocial, String cidade, String situacaoCadastral, String dataCadastro, String endereco, String telefone, String cnpj) {
        this.razaoSocial = razaoSocial;
        this.cidade = cidade;
        this.situacaoCadastral = situacaoCadastral;
        this.dataCadastro = dataCadastro;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cnpj = cnpj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getSituacaoCadastral() {
        return situacaoCadastral;
    }

    public void setSituacaoCadastral(String situacaoCadastral) {
        this.situacaoCadastral = situacaoCadastral;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public static ClienteDTO fromJson(String json) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        // Extrair os campos do JsonObject e criar um ClienteDTO
        String razaoSocial = jsonObject.get("razao_social").getAsString();
        String cidade = jsonObject.get("estabelecimento").getAsJsonObject().get("cidade").getAsJsonObject().get("nome").getAsString();
        String situacaoCadastral = jsonObject.get("estabelecimento").getAsJsonObject().get("situacao_cadastral").getAsString();
        String dataCadastro = (jsonObject.get("estabelecimento").getAsJsonObject().get("data_situacao_cadastral").getAsString());
        String endereco = jsonObject.get("estabelecimento").getAsJsonObject().get("logradouro").getAsString();
        String telefone = jsonObject.get("estabelecimento").getAsJsonObject().get("telefone1").getAsString();
        String cnpj = jsonObject.get("estabelecimento").getAsJsonObject().get("cnpj").getAsString();

        return new ClienteDTO(razaoSocial, cidade, situacaoCadastral, dataCadastro, endereco, telefone, cnpj);
    }

}
