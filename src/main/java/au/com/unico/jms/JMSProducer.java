/**
 * 
 */
package au.com.unico.jms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Usman
 *
 */
@Component
public class JMSProducer {

	private static final String GCD_QUEUE = "gcd.queue";

	@Autowired
	JmsTemplate jmsTemplate;

	@Value("${jms.queue.destination}")
	String destinationQueue;

	public String putNumber(Integer number1, Integer number2) {

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(number1);
		numbers.add(number2);

		jmsTemplate.convertAndSend(destinationQueue, number1);
		jmsTemplate.convertAndSend(destinationQueue, number2);

		return "Numbers has been successfully added";
	}
}
