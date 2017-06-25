package home.app2.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by snigo on 18.06.17.
 */

@Service
public class UserService {

    @Autowired
    private JmsTemplate jmsTemplate;


    public void sendUsernameAndPassword(String username, String user, String password, String pass) {
//    public void sendUsernameAndPassword() {

        jmsTemplate.convertAndSend(username, user);
        jmsTemplate.convertAndSend(password, pass);

//        jmsTemplate.convertAndSend("username", "user");
//        jmsTemplate.convertAndSend("password", "password");
    }

    @JmsListener(destination = "username")
    public void receiveUsernameMessage(TextMessage textMessage) throws JMSException {
        System.out.println(textMessage.getText());
    }

    @JmsListener(destination = "password")
    public void receivePasswordMessage(TextMessage textMessage) throws JMSException {
        System.out.println(new BCryptPasswordEncoder().encode(textMessage.getText()));
    }


}
