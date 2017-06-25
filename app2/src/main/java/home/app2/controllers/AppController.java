package home.app2.controllers;

import home.app2.servicies.JMSWrapper;
import home.app2.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by snigo on 18.06.17.
 * Файлы кидать в /resources/templates, иначе не работает
 */

@Controller
@RequestMapping
public class AppController {

    private JMSWrapper jmsWrapper;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String showMainPage() {
        return "index";
    }

    @RequestMapping("/getuser")
    public String sendUsernameAndPassword() {

        userService.sendUsernameAndPassword(
                jmsWrapper.username.get(),
                jmsWrapper.user.get(),
                jmsWrapper.password.get(),
                jmsWrapper.pass.get()
                );
        return  "success";
    }

//    @RequestMapping("/error")
//    public String errorMessage() {
//        return "Вы упали...";
//    }
}
