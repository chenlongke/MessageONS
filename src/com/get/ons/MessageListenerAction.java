package com.get.ons;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;

public class MessageListenerAction implements MessageListener {
	@Override
	public Action consume(Message message, ConsumeContext context) {
		excute ex = new excute(message);
		ex.run();
        return Action.CommitMessage;
	}
}