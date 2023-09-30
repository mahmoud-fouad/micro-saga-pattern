package com.mfouad.orderservice;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mfouad.orderservice.commands.CreateOrderCommand;

@RestController
public class ApiController {

    private CommandGateway commandGateway;
   

    public ApiController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }



    @PutMapping
    public String createOrder(@RequestBody OrderJson request){
        CreateOrderCommand command = new CreateOrderCommand(UUID.randomUUID().toString()
        , "create order", request);
        commandGateway.sendAndWait(command);
        return "order created";
    }
    
}
