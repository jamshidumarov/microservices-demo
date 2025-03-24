package dzamsheed.uz.saga_orchestrator.process;

import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.engine.spring.application.SpringProcessApplication;
import org.springframework.stereotype.Service;

@Service
@ProcessApplication
public class OrderSagaProcess extends SpringProcessApplication {
}