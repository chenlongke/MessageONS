/***
 * @author chen9
 */
package com.send.ons;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.aliyun.openservices.ons.api.SendResult;

public class ProducerTest {
	private static final Logger logger = LogManager.getLogger(ProducerTest.class.getName());
	public static void main(String a[]){	
		logger.info("我是好人哦~~~~~~~~");
		try {	
			Properties properties = new Properties();
			properties.put(PropertyKeyConst.ProducerId, "PID_162173622-101");
			properties.put(PropertyKeyConst.AccessKey,"JqkUliuzNAjWHupu");
		    properties.put(PropertyKeyConst.SecretKey, "E0eXrLZV4jwKcyArf6xmF1cd73GxgV");
		    
		    Producer producer = ONSFactory.createProducer(properties);
		    producer.start();
		    boolean isrun = true;
		    while(isrun){
		    	Message msg = new Message(
			            	"Test-FG",//Message Topic
			            	"TagA",//标签
			            	"Hello ONS".getBytes("utf-8")//message body
		    			);
			    msg.setKey("ORDERID_100");
			    SendResult sendResult = producer.send(msg);
			    String sdf=new SimpleDateFormat("yyyy-MM-dd-HH").format(new Date());
		        logger.info("发送成功=========>"+sendResult.getMessageId()+"现在的时间是:=======>"+sdf);
		        if(sdf == "2016-01-29-16"){
		        	isrun = false;
		        	break;
		        }
		    }
		    producer.shutdown();
		} catch (IOException e) {
			logger.info("发送失败 了。。。。。。。。。。。。");
			e.printStackTrace();
		}
	}
}