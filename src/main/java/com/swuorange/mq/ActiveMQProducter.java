package com.swuorange.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.swuorange.data.ActiveMQData;

/**
 * 通用的消息发送类
 * 
 * @author Randy
 *
 */
@Service
public class ActiveMQProducter {

	@Autowired
	private JmsTemplate jmsTemplate;

	/**
	 * 
	 * @param queue
	 *            发送队列的名称
	 * @param message
	 *            所需要发送的消息内容
	 */
	public void send(String message) {
		jmsTemplate.send(ActiveMQData.CALLBACK_QUEUE_NAME, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}
}
