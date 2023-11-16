package com.consulta.cnpj.api;

import com.consulta.cnpj.dto.ClienteDTO;

public class CnpjApiRequest extends DefaultApiRequest{
    public ClienteDTO buscarCnpjApi(String cnpj) throws Exception {
        String json = get(" https://publica.cnpj.ws/cnpj/"+cnpj);
        return ClienteDTO.fromJson(json);
    }
}
