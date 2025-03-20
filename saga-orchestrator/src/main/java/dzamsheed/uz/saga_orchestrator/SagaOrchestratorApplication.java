package dzamsheed.uz.saga_orchestrator;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableProcessApplication
public class SagaOrchestratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SagaOrchestratorApplication.class, args);
	}

}
