package com.integracao.cnpj.controller;

import com.integracao.cnpj.dto.ClienteDTO;
import com.integracao.cnpj.service.CadastroClienteService;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@ViewScoped
public class CadastroClienteView implements Serializable {

    private String razaoSocial;
    private String cidade;
    private String situacaoCadastral;
    private String dataCadastro;
    private String endereco;
    private String telefone;
    private String cnpj;

    private final CadastroClienteService cadastroClienteService;

    CadastroClienteView() {
        cadastroClienteService = new CadastroClienteService();
    }

    public void buscarCnpj() {
        String cnpjFormatado
                = cnpj.replace(".", "")
                        .replace("/", "")
                        .replace("-", "");

        ClienteDTO clienteDTO = cadastroClienteService.buscarCnpj(cnpjFormatado);
        setRazaoSocial(clienteDTO.getRazaoSocial());
        setCidade(clienteDTO.getCidade());
        setSituacaoCadastral(clienteDTO.getSituacaoCadastral());
        setDataCadastro(clienteDTO.getDataCadastro());
        setCnpj(clienteDTO.getCnpj());
    }

    public void salvar() {
        ClienteDTO clienteDTO = new ClienteDTO(razaoSocial, cidade, situacaoCadastral, dataCadastro, endereco, telefone, cnpj);
        cadastroClienteService.salvar(clienteDTO);
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
        if (dataCadastro != null) {
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
            Date data = null;
            try {
                data = formatoEntrada.parse(dataCadastro);
            } catch (ParseException ex) {
                Logger.getLogger(CadastroClienteView.class.getName()).log(Level.SEVERE, null, ex);
            }

            SimpleDateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy");

            return formatoSaida.format(data);
        } else {
            return null;
        }
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
}
