/***
 * @author chen9
 */
package com.send.ons;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.aliyun.openservices.ons.api.SendResult;

public class ProducerTest {
	private static final Logger logger = LoggerFactory.getLogger(ProducerTest.class.getName());
	public static void main(String a[]){	
		logger.info("我是好人哦~~~~~~~~");
		try {			
			/*InputStream input = new FileInputStream(System.getProperty("user.dir")+"\\conf\\ons.properties");			
			Properties pro = new Properties();
			pro.load(input);*/
			Properties properties = new Properties();
			properties.put(PropertyKeyConst.ProducerId, "PID_162173622-101");
			properties.put(PropertyKeyConst.AccessKey,"JqkUliuzNAjWHupu");
		    properties.put(PropertyKeyConst.SecretKey, "E0eXrLZV4jwKcyArf6xmF1cd73GxgV");
		    
		    Producer producer = ONSFactory.createProducer(properties);
		    producer.start();
		    Message msg = new Message(//Message Topic
		            "Test-FG",
		            //Message Tag,
		            //可理解为Gmail中的标签，对消息进行再归类，方便Consumer指定过滤条件在ONS服务器过滤       
		            "TagA",
		            //Message Body
		            //任何二进制形式的数据，ONS不做任何干预，需要Producer与Consumer协商好一致的序列化和反序列化方式
		            "Hello ONS".getBytes("utf-8"));
		    msg.setKey("ORDERID_100");
		    SendResult sendResult = producer.send(msg);
	        System.out.println(sendResult);
	        logger.info("我是好人哦~~~~~~~~");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}