/***
 * @author chen9
 */
package com.send.ons;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
			Properties properties = new Properties();
			properties.put(PropertyKeyConst.ProducerId, "PID_162173622-101");
			properties.put(PropertyKeyConst.AccessKey,"JqkUliuzNAjWHupu");
		    properties.put(PropertyKeyConst.SecretKey, "E0eXrLZV4jwKcyArf6xmF1cd73GxgV");
		    
		    Producer producer = ONSFactory.createProducer(properties);
		    producer.start();
		    boolean isrun = true;
		    while(isrun){
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
		        logger.info("发送成功=========>"+sendResult);
		        
		        String sdf=new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Date());
		        if(sdf == "2015-01-29-12-00"){
		        	isrun = false;
		        	break;
		        }
		    }
		} catch (IOException e) {
			logger.info("发送失败 了。。。。。。。。。。。。");
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}