package com.swuorange.mq;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.swuorange.util.StringUtil;

/**
 * 消息监听类: 监听端口为 swu
 * 
 * @author Randy
 *
 */
@Service
public class ActiveMQConsumerListener implements MessageListener {

	@Autowired
	private ActiveMQProducter activeMQProducter;

	@Override
	public void onMessage(Message message) {
		try {
			String msg = ((TextMessage) message).getText();
			//将收到的msg转换成JSONObject对象
			JSONObject json = JSONObject.parseObject(msg);
			//获取要操作的对象
			JSONObject obj = json.getJSONObject("obj");
			//对象的类型,对象的类名
			String objType = json.getString("objType");
			//获取操作的类型,队形mq项目需要调用的方法
			String opera = json.getString("opeartion");
			//Spring的方法
			ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-tx.xml","applicationContext-mapper.xml");
			// 通过反射获取service接口调用方法,这里就是service的全类名
			Class<?> cls = Class.forName("com.swuorange.service." + objType + "Service");
			//通过反射调用方法
			Method method = cls.getMethod(opera, JSONObject.class);
			//因为Spring默认的id为类名的的首字母小写需要将参数objType的首字母变成小写,在util定义了一个方法传回来的数据已经+Service;
			//rtCode为调用方法的返回值
			String rtCode = (String) method.invoke(ac.getBean(StringUtil.parseFirstStr(objType)), obj);
			//返回server这次的操作类型
			String rtOpera = opera;
			String sid = json.getString("sid");
			//执行完毕后回传至Server
			JSONObject rtjson = new JSONObject();
			rtjson.put("sid", sid);
			rtjson.put("rtCode", rtCode);
			rtjson.put("rtOpera", rtOpera);
			activeMQProducter.send(rtjson.toJSONString());
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
