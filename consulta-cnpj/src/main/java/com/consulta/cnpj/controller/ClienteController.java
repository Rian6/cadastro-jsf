package com.consulta.cnpj.controller;

import com.consulta.cnpj.dto.ClienteDTO;
import com.consulta.cnpj.entity.Cliente;
import com.consulta.cnpj.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService service;

    @RequestMapping(value = "cliente/buscar-cnpj/{cnpj}.json", method = RequestMethod.GET)
    public ClienteDTO buscarCnpj(@PathVariable String cnpj) throws Exception {
        return service.buscarCnpj(cnpj);
    }

    @RequestMapping(value = "cliente/salvar", method =  RequestMethod.POST)
    public Cliente salvar(@RequestBody Cliente cliente)
    {
        return service.salvar(cliente);
    }
}