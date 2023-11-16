package com.consulta.cnpj.repository;

import com.consulta.cnpj.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
