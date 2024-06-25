package projeto.dio.desafio_codigo_dio.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.dio.desafio_codigo_dio.model.Cliente;
import projeto.dio.desafio_codigo_dio.model.Endereco;
import projeto.dio.desafio_codigo_dio.repository.ClienteRepository;
import projeto.dio.desafio_codigo_dio.repository.EnderecoRepository;
import projeto.dio.desafio_codigo_dio.service.ClienteService;
import projeto.dio.desafio_codigo_dio.service.ViaCepService;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepositorio;
    @Autowired
    private EnderecoRepository enderecoRepositorio;
    @Autowired
    private ViaCepService viaCepService;


    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepositorio.findById(id);
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
    Optional<Cliente> cliente1=clienteRepositorio.findById(id);
    if (cliente1.isPresent()){
        salvarClienteComCep(cliente);
    }


    }

    @Override
    public void deletar(Long id) {
        clienteRepositorio.deleteById(id);

    }

    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepositorio.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepositorio.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepositorio.save(cliente);
    }
}
