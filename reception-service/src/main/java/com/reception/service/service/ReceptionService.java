package com.reception.service.service;

import java.util.List;

import com.reception.service.bean.BedAllocationBean;
import com.reception.service.bean.BillingBean;
import com.reception.service.bean.PatitentBean;
import com.reception.service.exception.BedDetailsNotFoundException;

public interface ReceptionService {
	PatitentBean patitentDetails(int patitentid);
	List<PatitentBean> getPatitentDetails();
	BillingBean billingDetails(int billId);
	BedAllocationBean bedAllocationDetails(int bedAllocationId) throws BedDetailsNotFoundException;
	List<BedAllocationBean> getBedAllocationDetails() throws BedDetailsNotFoundException;

}
