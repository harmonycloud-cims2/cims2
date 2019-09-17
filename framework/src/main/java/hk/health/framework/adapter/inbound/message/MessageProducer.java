package hk.health.framework.adapter.inbound.message;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * @Usage:
 * @Author: Vicky
 * @Date: 2019-09-04 17:56
 */

@Service
public class MessageProducer {

    private static final Logger logger = LoggerFactory.getLogger(MessageProducer.class);
    /**
     * 生产者的组名
     */
    @Value("${apache.rocketmq.producer.producerGroup}")
    private String producerGroup;

    /**
     * NameServer 地址
     */
    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;


    public void producer(String topic, String tags, String body) {

        DefaultMQProducer producer = new DefaultMQProducer(producerGroup);

        producer.setNamesrvAddr(namesrvAddr);

        try {
            producer.start();

            logger.info("-------->:producer starting....");
            Message message = new Message(topic, tags, body.getBytes(RemotingHelper.DEFAULT_CHARSET));

            SendResult sendResult = producer.send(message);
            System.out.printf("%s%n", sendResult);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }

    }
}
