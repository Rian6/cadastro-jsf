package com.integracao.cnpj.service;

import com.google.gson.Gson;
import com.integracao.cnpj.api.DefaultApiRequest;
import com.integracao.cnpj.dto.ClienteDTO;
import com.integracao.cnpj.enums.ApiEnum;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadastroClienteService extends DefaultApiRequest {

    private final String enderecoHTTP = "http://"+ApiEnum.ENDERECO.getDescricao() + ":" + ApiEnum.PORTA.getDescricao();

    public ClienteDTO buscarCnpj(String cnpj) {
        try {
            String json = get(enderecoHTTP + "/cliente/buscar-cnpj/" + cnpj + ".json");
            ClienteDTO clienteDTO = new ClienteDTO();
            
            return clienteDTO.fromJson(json);
        } catch (Exception ex) {
            Logger.getLogger(CadastroClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ClienteDTO salvar(ClienteDTO clienteDTO) {
        try {
            String json = post(enderecoHTTP + "/cliente/salvar", clienteDTO);
            Gson gson = new Gson();

            return gson.fromJson(json, ClienteDTO.class);
        } catch (Exception ex) {
            Logger.getLogger(CadastroClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
