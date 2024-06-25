package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entity.Gpay;
import com.repository.GpayRepository;

@Service
public class GpayService {

	@Autowired
	GpayRepository gpayRepository;
	
	@Autowired
	RestTemplate restTemplate;			// help to consume other rest api; like HttpClient 
	
	public String createGpayAccount(Gpay gpay) {		// only emailid present
		String emailid = gpay.getEmailid();
		//restTemplate.postForEntity("", gpay, String.class);
		//int accno = restTemplate.getForObject("http://localhost:8383/account/findbyemailid/"+emailid, Integer.class);
		int accno = restTemplate.getForObject("http://ACCOUNT-MICRO-SERVICE/account/findbyemailid/"+emailid, Integer.class);
		if(accno==-1) {
			gpayRepository.save(gpay);
			return "gpay account created without account register";  // emailid, but accno=0
		}else {
			gpay.setAccno(accno);
			gpayRepository.save(gpay);
			return "gpay account created with account details";
		}
	}
	
	public String findBalance(int gpayid) {
		Optional<Gpay> result = gpayRepository.findById(gpayid);
		if(result.isPresent()) {
			Gpay obj = result.get();
			int accno = obj.getAccno();
			String output = restTemplate.getForObject("http://ACCOUNT-MICRO-SERVICE/account/find/"+accno, String.class);
			return output;
		}else {
			return "Gpay acount not exists";
		}
	}
	
}


