/**
 * 
 */
package au.com.unico.rest.controller;

import java.util.List;

import javax.xml.ws.RespectBinding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.unico.UnicoGcdServiceApplication;
import au.com.unico.entity.RecievedValues;
import au.com.unico.repositiry.RecieveValuesReposoitiry;
import au.com.unico.services.InputService;

/**
 * @author Usman
 *
 */
@RestController
@RequestMapping(value = "/gcd/v1")
public class InputController {
	private static final Logger logger = LoggerFactory.getLogger(UnicoGcdServiceApplication.class);
	@Autowired
	public RecieveValuesReposoitiry recieveValuesReposoitiry;
	@Autowired
	public InputService inputService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String pushNumbers(@RequestParam("firstNumber") int firstNumber,
			@RequestParam("secondtNumber") int secondNumber) {
		logger.debug("Entry Push Number, firstNumber"+firstNumber+" secondNumber"+secondNumber);
		String message = inputService.saveAndQueueNumber(firstNumber, secondNumber);
		logger.debug("Exit Push Number, message"+message);

		return message;
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Integer> getAllNumbers() {
		logger.debug("Entry getAllNumbersr");
		
		return inputService.getAllNumbersFromDB();
	}

}
