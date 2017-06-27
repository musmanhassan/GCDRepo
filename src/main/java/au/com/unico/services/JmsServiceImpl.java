/**
 * 
 */
package au.com.unico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import au.com.unico.jms.JMSListner;
import au.com.unico.jms.JMSProducer;

/**
 * @author Usman
 *
 */
@Service
public class JmsServiceImpl implements JmsService {

	@Autowired
	JMSListner jmsListner;
	@Autowired
	JMSProducer jmsProducer;

	@Override
	public String sendMessage(int number1, int number2) {

		return jmsProducer.putNumber(number1, number2);
	}

	@Override
	public Integer getMessage() {

		return jmsListner.getNumber();
	}

}
