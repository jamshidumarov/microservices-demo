package dzamsheed.uz.saga_orchestrator.config;

import org.camunda.bpm.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamundaDeploymentConfig {

    @Autowired
    private RepositoryService repositoryService;

    @Bean
    public CommandLineRunner deployProcess() {
        return args -> {
            repositoryService.createDeployment()
                    .addClasspathResource("processes/orderSagaProcess.bpmn")
                    .deploy();
        };
    }
}