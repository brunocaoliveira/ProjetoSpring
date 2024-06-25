package projeto.dio.desafio_codigo_dio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesafioCodigoDioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioCodigoDioApplication.class, args);
	}

}
