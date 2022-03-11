package com.example.emlak_burada.activeMq.resource;


import com.example.emlak_burada.activeMq.service.ActiveMqService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/publish")
@RequiredArgsConstructor
public class ProcedurResource {

    private final ActiveMqService activeMqService;

    @GetMapping("/{message}")
    public String publish(@PathVariable("message") final String message){
//        jmsTemplate.convertAndSend(queue, message);
        activeMqService.sendMessage(message);
        return "Published Successfully";
    }

}
