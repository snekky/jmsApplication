package home.app2;

import home.app2.servicies.JMSWrapper;
import home.app2.servicies.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Mockito;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.TextMessage;

import static org.mockito.Mockito.*;


/**
 * Created by snigo on 22.06.17.
 *
 *
 *
 * Тестируем JMS
 *
 *
 *
 *
 */
 @RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {

//    @Autowired
//    private UserService userService;

    private JMSWrapper jmsWrapper;


    @Test
    public void sendUsernameAndPasswordTest() throws Exception {

        UserService userService = mock(UserService.class);

        JmsTemplate jmsTemplate = Mockito.mock(JmsTemplate.class);

        userService.sendUsernameAndPassword(
                jmsWrapper.username.get(),
                jmsWrapper.user.get(),
                jmsWrapper.password.get(),
                jmsWrapper.pass.get());


        verify(userService, times(1)).sendUsernameAndPassword(

                        jmsWrapper.username.get(),
                        jmsWrapper.user.get(),
                        jmsWrapper.password.get(),
                        jmsWrapper.pass.get());

//        ArrayList<String> list = new ArrayList<String>();
//
//        //То, что должно быть(начинка wrappera)
//        ArrayList<String> idealList = new ArrayList<String>();
//        idealList.add("username");
//        idealList.add("user");
//        idealList.add("password");
//        idealList.add("pass");
//
//        // То, что берем из wrappera и передаем в качестве параметров
//        Mockito.when(userService.sendUsernameAndPassword(
//                jmsWrapper.username.get(),
//                jmsWrapper.user.get(),
//                jmsWrapper.password.get(),
//                jmsWrapper.pass.get()))
//                .then(list.add(jmsWrapper.username.get()))
//                .then(jmsWrapper.user.get())
//                .then(jmsWrapper.password.get())
//                .then(jmsWrapper.pass.get());
//
//        Assert.assertNotNull(list);
//        Assert.assertEquals(list, idealList);

    }

//    @Test
//    public void receiveUsernameMessageTest(){
//
//        UserService userService = Mockito.mock(UserService.class);
//
//
//
//        TextMessage textMessage;
//        // вот тут надо создать message
//        textMessage.setText("username");
//        String testControl = "";
//        when(userService.receiveUsernameMessage((textMessage))).then(testControl="user");
//
//        Assert.assertEquals(testControl, "user");
//
//    }


}
