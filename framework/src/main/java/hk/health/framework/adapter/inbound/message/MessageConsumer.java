package hk.health.framework.adapter.inbound.message;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * @Usage:
 * @Author: Vicky
 * @Date: 2019-09-04 17:55
 */
//@Service
public class MessageConsumer  {
    private static final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
    /**
     * 消费者组名
     */
    @Value("${apache.rocketmq.consumer.PushConsumer}")
    private String consumerGroup;

    /**
     * NameServer 地址
     */
    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;

    /**
     * 初始化RocketMq的监听信息，渠道信息
     */
    public void messageListener() {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);

        consumer.setNamesrvAddr(namesrvAddr);
        try {
            // 订阅Topic下Tag的消息,都订阅消息
            consumer.subscribe("TestYq", "test");

            // 程序第一次启动从消息队列头获取数据
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

            //可以修改每次消费消息的数量，默认设置是每次消费一条
            consumer.setConsumeMessageBatchMaxSize(1);

            //在此监听中消费信息，并返回消费的状态信息
            consumer.registerMessageListener(new MessageListenerConcurrently() {

                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                                ConsumeConcurrentlyContext context) {
                    System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            consumer.start();

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


}
