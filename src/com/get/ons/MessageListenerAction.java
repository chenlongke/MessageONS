package com.get.ons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;

public class MessageListenerAction implements MessageListener {
	private static final Logger logger = LoggerFactory.getLogger(MessageListenerAction.class.getName());
	@Override
	public Action consume(Message message, ConsumeContext context) {
		logger.info("收到消息: " + message);
		logger.info("发送成功: " + message);
        return Action.CommitMessage;
	}
}