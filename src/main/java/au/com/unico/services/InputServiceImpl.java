/**
 * 
 */
package au.com.unico.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import au.com.unico.entity.RecievedValues;
import au.com.unico.repositiry.RecieveValuesReposoitiry;

/**
 * @author Usman
 *
 */
@Component
public class InputServiceImpl implements InputService {

	@Autowired
	JmsService jmsService;

	@Autowired
	RecieveValuesReposoitiry recieveValuesReposoitiry;

	@Override
	public synchronized String saveAndQueueNumber(int number1, int number2) {

		RecievedValues recievedValuesNumber1 = new RecievedValues();
		recievedValuesNumber1.setInputValues(number1);

		RecievedValues recievedValuesNumber2 = new RecievedValues();
		recievedValuesNumber2.setInputValues(number2);

		String message = jmsService.sendMessage(number1, number2);

		List<RecievedValues> recievedValuesList = new ArrayList<RecievedValues>();
		recievedValuesList.add(recievedValuesNumber1);
		recievedValuesList.add(recievedValuesNumber2);
		recieveValuesReposoitiry.save(recievedValuesList);

		return message;
	}

	@Override
	public List<Integer> getAllNumbersFromDB() {

		List<RecievedValues> recievedValuesList = (List<RecievedValues>) recieveValuesReposoitiry.findAll();
		return recievedValuesList.stream().map(RecievedValues::getInputValues).collect(Collectors.toList());
	}

}
