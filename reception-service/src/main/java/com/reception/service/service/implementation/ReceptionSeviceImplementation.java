package com.reception.service.service.implementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.reception.service.bean.BedAllocationBean;
import com.reception.service.bean.BillingBean;
import com.reception.service.bean.PatitentBean;
import com.reception.service.exception.BedDetailsNotFoundException;
import com.reception.service.exception.BillingDetailsNotFoundException;
import com.reception.service.exception.PatitentDetailsNotFoundException;
import com.reception.service.service.ReceptionService;
@Service
public class ReceptionSeviceImplementation implements ReceptionService
{
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public PatitentBean patitentDetails(int patitentid) {
		String url = "http://localhost:8082/registration/"+patitentid;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
		if(httpEntity!=null) {
		ResponseEntity<PatitentBean> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
				PatitentBean.class);
		PatitentBean patitentBean = responseEntity.getBody();
		return patitentBean;
		}
		else
		{
			throw new PatitentDetailsNotFoundException("Patitent Details Not found");
		}
	}
	
	@Override
	public List<PatitentBean> getPatitentDetails() {
		
		String url = "http://localhost:8082/registration/getAll";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);
				ResponseEntity<List<PatitentBean>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
						new ParameterizedTypeReference<List<PatitentBean>>() {});
				if(responseEntity!=null) {

		List<PatitentBean> patitentBean =  responseEntity.getBody();
		return patitentBean;
		}
		else
		{
			throw new PatitentDetailsNotFoundException("Patitent Details Not found");
		}
	
		
	}
	

	@Override
	public BillingBean billingDetails(int billId) {
		
		String url = "http://localhost:8083/billing/fetch/"+billId;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);

		ResponseEntity<BillingBean> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
				BillingBean.class);
		if(responseEntity!=null) {
		BillingBean billingBean = responseEntity.getBody();
		return billingBean;
		}
		else
		{
			throw new BillingDetailsNotFoundException("Billing details not found..");
		}
		
		
	}

	@Override
	public BedAllocationBean bedAllocationDetails(int bedAllocationId) throws BedDetailsNotFoundException {
		
		String url = "http://localhost:8081/bedAllocation/getById/"+bedAllocationId;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);

		ResponseEntity<BedAllocationBean> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
				BedAllocationBean.class);
		if(responseEntity!=null) {
		BedAllocationBean bedAllocationBean = responseEntity.getBody();
		return bedAllocationBean;
		}
		else
		{
			throw new BedDetailsNotFoundException("BedDetails not found");
		
		}
		
	}
	@Override
	public List<BedAllocationBean> getBedAllocationDetails() throws BedDetailsNotFoundException  {
		
		String url = "http://localhost:8081/bedAllocation/getAll";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);

		ResponseEntity<List<BedAllocationBean>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
				new ParameterizedTypeReference<List<BedAllocationBean>>() {});
		if(responseEntity!=null) {
		List<BedAllocationBean> bedAllocationBean = responseEntity.getBody();
		return bedAllocationBean;
		}
		else
		{
			throw new BedDetailsNotFoundException("BedDetails not found");
		
		}
		
	}
	

	
	

}
