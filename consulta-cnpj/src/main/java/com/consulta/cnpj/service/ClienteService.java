package com.consulta.cnpj.service;

import com.consulta.cnpj.api.CnpjApiRequest;
import com.consulta.cnpj.dto.ClienteDTO;
import com.consulta.cnpj.entity.Cliente;
import com.consulta.cnpj.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private IClienteRepository repository;

    public ClienteDTO buscarCnpj(String cnpj) throws Exception {
        CnpjApiRequest cnpjApiRequest = new CnpjApiRequest();
        return cnpjApiRequest.buscarCnpjApi(cnpj);
    }

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }
}