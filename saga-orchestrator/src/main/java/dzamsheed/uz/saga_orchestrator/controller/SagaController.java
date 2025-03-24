package dzamsheed.uz.saga_orchestrator.controller;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SagaController {

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("/start-saga/{orderId}")
    public String startSaga(@PathVariable String orderId) {
        runtimeService.startProcessInstanceByKey("orderSagaProcess", orderId);
        return "Saga started for orderId: " + orderId;
    }
}