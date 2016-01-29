package com.get.ons;

import java.io.UnsupportedEncodingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




import com.aliyun.openservices.ons.api.Message;

public class excute {
	private static final Logger logger = LogManager.getLogger(excute.class.getName());
	private Message message = null;
	
	public excute(Message message){
		this.message = message;
	}
	public void run(){
		try {
			String content = new String(message.getBody(),"utf-8");
			String tag = message.getTag();
			String key = message.getKey();
			String top = message.getTopic();
			String mid = message.getMsgID();
			logger.info("得到消息----->"+content+"\t\tmessageID----->" + mid + "\t\ttopic----->" + top + "\t\tkey----->" + key + "\t\ttag----->" + tag);
			
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
