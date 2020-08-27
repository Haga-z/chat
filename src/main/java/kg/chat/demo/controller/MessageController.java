package kg.chat.demo.controller;

import kg.chat.demo.DTO.MessageDTO;
import kg.chat.demo.model.Message;
import kg.chat.demo.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@AllArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @RequestMapping(value={"/messages/{id}"}, method={RequestMethod.GET},produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageDTO returnMessages(@PathVariable("id") Integer id, Principal principal){
        return messageService.getMessage(id,principal);
    }
}
