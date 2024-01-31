package com.reception.service.service.implementation;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.reception.service.bean.PatitentBean;
import com.reception.service.service.ReceptionService;
@Service
public class ReceptionSeviceImplementation implements ReceptionService
{
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public PatitentBean patitentDetails(int id) {
		String url = "http://localhost:8080/registration/id";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);

		ResponseEntity<PatitentBean> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
				PatitentBean.class);
		PatitentBean patitentBean = responseEntity.getBody();
		return patitentBean;
	}
	

}
