package projeto.dio.desafio_codigo_dio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import projeto.dio.desafio_codigo_dio.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
