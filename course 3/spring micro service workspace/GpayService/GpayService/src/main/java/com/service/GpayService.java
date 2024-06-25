package com.service;

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
		int accno = restTemplate.getForObject("http://localhost:8383/account/findbyemailid/"+emailid, Integer.class);
		if(accno==-1) {
			gpayRepository.save(gpay);
			return "gpay account created without account register";  // emailid, but accno=0
		}else {
			gpay.setAccno(accno);
			gpayRepository.save(gpay);
			return "gpay account created with account details";
		}
	}
}


