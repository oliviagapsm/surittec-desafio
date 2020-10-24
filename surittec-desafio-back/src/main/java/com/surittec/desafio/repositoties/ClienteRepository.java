package com.surittec.desafio.repositoties;

import com.surittec.desafio.domain.Cliente;
import com.surittec.desafio.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
