package com.br.dsmeta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.br.dsmeta.entities.Sale;
import com.br.dsmeta.repository.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {
	
	@Value("${twilio.sid}")
	private String twilioSid;
	
	@Value("${twilio.key}")
	private String twilioKey;
	
	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;
	
	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private SaleRepository repository;
	
	public void sendSms(Long saleId) {
		Sale sale = repository.findById(saleId).get();
		String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();
		String money = String.format("%.2f", sale.getAmount());
		String msg = "Vendedor " + sale.getSellerName() + " foi destaque em " + date 
				+ " com um total de R$ " + money; 
		Twilio.init(twilioSid, twilioKey);
		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);
		Message message = Message.creator(to, from, msg).create();
		System.out.println(message.getSid());
	}
	

}
