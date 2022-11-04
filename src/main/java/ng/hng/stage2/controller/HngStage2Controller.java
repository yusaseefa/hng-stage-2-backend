package ng.hng.stage2.controller;

import ng.hng.stage2.model.AiArithmeticOperation;
import ng.hng.stage2.model.ArithmeticOperation;
import ng.hng.stage2.model.ArithmeticOperationResponse;
import ng.hng.stage2.service.ArithmeticOperationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HngStage2Controller {

    private final ArithmeticOperationService service;

    public HngStage2Controller(ArithmeticOperationService service) {
        this.service = service;
    }

    @PostMapping
    public ArithmeticOperationResponse solve(@Valid @RequestBody ArithmeticOperation operation) {
        return service.solve(operation);
    }

    @PostMapping("/solve/ai")
    public ArithmeticOperationResponse solve(@Valid @RequestBody AiArithmeticOperation operation) {
        return service.solve(operation);
    }

}
