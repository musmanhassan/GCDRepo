/**
 * 
 */
package au.com.unico.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import au.com.unico.entity.SumValues;
import au.com.unico.exception.ServiceFault;
import au.com.unico.exception.ServiceFaultException;
import au.com.unico.repositiry.SumValuesRespositiry;

/**
 * @author Usman
 *
 */
@Component
public class OutputServiceImpl implements OutputService {
	@Autowired
	JmsService jmsService;

	@Autowired
	SumValuesRespositiry sumValuesRespositiry;

	@Override
	public synchronized Integer getGCDandSaveSum() {
		Integer gcdValue = 0;
        try{
		Integer firstNumber = jmsService.getMessage();
		Integer secondNumber = jmsService.getMessage();

		 gcdValue = getGCDNumber(firstNumber, secondNumber);

		SumValues sumValues = new SumValues();
		sumValues.setInputValues(gcdValue);
		sumValuesRespositiry.save(sumValues);
        } catch (Exception ex){
        	throw new ServiceFaultException("ERROR",new ServiceFault(
                    "01", "Some thing went wrong while getting the sum. Please try again"));
        }
		return gcdValue;
	}

	@Override
	public List<Integer> getGCDList() {
         List<Integer> sumList = new ArrayList<Integer>();
         try{
		  List<SumValues> sumValuesList = (List<SumValues>) sumValuesRespositiry.findAll();
          sumList = sumValuesList.stream().map(SumValues::getInputValues).collect(Collectors.toList());
         } catch(Exception ex){
        	 throw new ServiceFaultException("ERROR",new ServiceFault(
	                    "03", "Some thing went wrong while getting the GCD List. Please try again"));
         }
		return sumList;
	}

	@Override
	public Integer getGCDSum() {

		Integer sumValues=0;
		try{
			sumValues = sumValuesRespositiry.getSumValues();
		}catch(Exception ex){
			    	throw new ServiceFaultException("ERROR",new ServiceFault(
	                    "02", "Some thing went wrong while getting the sum. Please try again"));
	   		}  
		return sumValues;
	}

	private Integer getGCDNumber(Integer number1, Integer number2) {
      
		
		BigInteger b1 = BigInteger.valueOf(number1);
		BigInteger b2 = BigInteger.valueOf(number2);
		BigInteger gcd = b1.gcd(b2);

		return gcd.intValue();
	}

}
