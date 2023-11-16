package com.fire.socket.websocket;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/arduino")
public class WebSocketController {

    private final SimpMessagingTemplate template;

    @GetMapping
    public void receiveData(@RequestParam String req) {
        template.convertAndSend("/topic/socket", req);
        System.out.println(req);
    }

}
