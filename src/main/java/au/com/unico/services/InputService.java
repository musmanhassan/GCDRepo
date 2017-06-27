/**
 * 
 */
package au.com.unico.services;

import java.util.List;

/**
 * @author Usman
 *
 */
public interface InputService {

	String saveAndQueueNumber(int number1, int number2);

	List<Integer> getAllNumbersFromDB();
}
