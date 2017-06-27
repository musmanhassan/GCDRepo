/**
 * 
 */
package au.com.unico.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Usman
 *
 */
@Component
public class JMSListner {

	@Autowired
	JmsTemplate jmsTemplate;

	@Value("${jms.queue.destination}")
	String destinationQueue;

	@Value("${jms.queue.receive.timeout}")
	String receiptTimeout;

	public Integer getNumber() {

		jmsTemplate.setReceiveTimeout(Integer.parseInt(receiptTimeout));
		Integer number = (Integer) jmsTemplate.receiveAndConvert(destinationQueue);

		return number;

	}

}
