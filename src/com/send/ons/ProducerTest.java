/***
 * @author chen9
 */
package com.send.ons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
		try {			
			InputStream input = new FileInputStream(System.getProperty("user.dir")+"\\conf\\ons.properties");			
			Properties pro = new Properties();
			pro.load(input);
			Properties properties = new Properties();
			properties.put(PropertyKeyConst.ProducerId, "PID_162173622-101");
			properties.put(PropertyKeyConst.AccessKey,"JqkUliuzNAjWHupu");
		    properties.put(PropertyKeyConst.SecretKey, "E0eXrLZV4jwKcyArf6xmF1cd73GxgV");
		    
		    Producer producer = ONSFactory.createProducer(properties);
		    producer.start();
		    Message msg = new Message(//Message Topic
		            "Test-FG",
		            //Message Tag,
		            //�����ΪGmail�еı�ǩ������Ϣ�����ٹ��࣬����Consumerָ������������ONS����������       
		            "TagA",
		            //Message Body
		            //�κζ�������ʽ�����ݣ�ONS�����κθ�Ԥ����ҪProducer��ConsumerЭ�̺�һ�µ����л��ͷ����л���ʽ
		            "Hello ONS".getBytes("utf-8"));
		    msg.setKey("ORDERID_100");
		    SendResult sendResult = producer.send(msg);
	        System.out.println(sendResult);
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
