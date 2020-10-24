package com.surittec.desafio.config.db;

import com.surittec.desafio.domain.Cliente;
import com.surittec.desafio.domain.Contato;
import com.surittec.desafio.domain.Endereco;
import com.surittec.desafio.domain.User;
import com.surittec.desafio.domain.enums.Profile;
import com.surittec.desafio.domain.enums.SiglaUnidadeFederativa;
import com.surittec.desafio.domain.enums.TipoTelefone;
import com.surittec.desafio.repositoties.ClienteRepository;
import com.surittec.desafio.repositoties.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DBInitialize {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BCryptPasswordEncoder bc;

    public void instantieateTestDatabase() throws ParseException {
        // BLOCO USUARIOS
        System.out.println("Adiciona usuarios");

        User admin = User.builder()
                .usuario("admin")
                .senha(bc.encode("123456"))
                .perfis(Arrays.asList(Profile.ADMIN.getCod()))
                .build();
        User cliente = User.builder()
                .usuario("comum")
                .senha(bc.encode("123456"))
                .perfis(Arrays.asList(Profile.USER.getCod()))
                .build();

        userRepository.saveAll(Arrays.asList(admin, cliente));

        System.out.println("Adiciona clientes");
        Cliente yasmin = Cliente.builder()
                .nome("yasmin")
                .cpf("06691298101")
                .endereco(Endereco.builder()
                        .cep("72120600")
                        .bairro("Taguatinga")
                        .cidade("Brasília")
                        .complemento("Quadra")
                        .logradouro("Lote")
                        .uf(SiglaUnidadeFederativa.DF)
                        .build())
                .contato(
                        Arrays.asList(
                                Contato.builder()
                                        .numero("(61)98500-2233")
                                        .tipo(TipoTelefone.COMERCIAL)
                                        .build(),
                                Contato.builder()
                                        .numero("(61)3500-2233")
                                        .tipo(TipoTelefone.RESIDENCIAL)
                                        .build()
                        )
                )
                .emails(Arrays.asList("yas@gmail.com", "yas2@gmail.com"))
                .build();
        clienteRepository.saveAll(Arrays.asList(yasmin));
        System.out.println("=============================");
    }
}
