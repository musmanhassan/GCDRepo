/**
 * 
 */
package au.com.unico.soap.endpoints;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import au.com.unico.UnicoGcdServiceApplication;
import au.com.unico.services.OutputService;
import unico.com.au.gcd_service.GetGCDListRequest;
import unico.com.au.gcd_service.GetGCDListResponse;
import unico.com.au.gcd_service.GetGCDRequest;
import unico.com.au.gcd_service.GetGCDResponse;
import unico.com.au.gcd_service.GetGCDSumRequest;
import unico.com.au.gcd_service.GetGCDSumResponse;

/**
 * @author Usman
 *
 */
@Endpoint
public class GCDService {
	private static final Logger logger = LoggerFactory.getLogger(UnicoGcdServiceApplication.class);
	@Autowired
	OutputService outputService;

	private static final String NAMESPACE_URI = "http://au.com.unico/gcd-service";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGCDRequest")
	@ResponsePayload
	public GetGCDResponse getGCD(@RequestPayload GetGCDRequest gcdRequest) {
		logger.debug("Entry getGCD");
		GetGCDResponse gcdResponse = new GetGCDResponse();
		Integer gcd = outputService.getGCDandSaveSum();
		gcdResponse.setGcd(gcd);
		logger.debug("Exit gcd"+gcd);
		return gcdResponse;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGCDListRequest")
	@ResponsePayload
	public GetGCDListResponse getGCDList(@RequestPayload GetGCDListRequest gcdListRequest) {
		logger.debug("Entry getGCDList");
		GetGCDListResponse getGCDListResponse = new GetGCDListResponse();

		getGCDListResponse.getGcdList().addAll(outputService.getGCDList());
		logger.debug("Exit getGCDList"+getGCDListResponse.getGcdList());
		return getGCDListResponse;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGCDSumRequest")
	@ResponsePayload
	@ExceptionHandler(value = Exception.class)  
	public GetGCDSumResponse getGCDSum(@RequestPayload GetGCDSumRequest gcdSumRequest) {
		logger.debug("Entry getGCDSum");
		GetGCDSumResponse gcdSumResponse = new GetGCDSumResponse();
		gcdSumResponse.setGcdSum(outputService.getGCDSum());
		logger.debug("Exit getGCDSum"+gcdSumResponse.getGcdSum());

		return gcdSumResponse;
	}

}
