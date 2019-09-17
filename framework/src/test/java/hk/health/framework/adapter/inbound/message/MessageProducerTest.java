package hk.health.framework.adapter.inbound.message;


import hk.health.common.RocketMQProducerMockUp;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Usage:
 * @Author: Vicky
 * @Date: 2019-09-05 10:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageProducerTest {

    @Autowired
    private MessageProducer messageProducer;
    @Autowired
    private MessageConsumer messageConsumer;

    // 把RocketMQ的生产者mock
    @BeforeClass
    public static void mockRocketMQ() {
        new RocketMQProducerMockUp();
    }
    @Test
    public void send() throws Exception {
        messageProducer.producer("TestYq","test","hello world");
//        messageConsumer.messageListener();
    }

}
