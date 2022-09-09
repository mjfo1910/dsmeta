package com.devsuperior.dsmeta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Missoes;
import com.devsuperior.dsmeta.repositories.MissoesRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsMissoes {

		@Value("${twilio.sid}")
		private String twilioSid;

		@Value("${twilio.key}")
		private String twilioKey;

		@Value("${twilio.phone.from}")
		private String twilioPhoneFrom;

		@Value("${twilio.phone.to}")
		private String twilioPhoneTo;
		
		@Autowired
		private MissoesRepository missoesRepository;

		public void sendSms(Long MissoesId) {

			Missoes missoes = missoesRepository.findById(MissoesId).get();
			
			String date = missoes.getDate().getMonthValue() + "/" + missoes.getDate().getYear();
			
			String msg = "Nome Contribuidor" + missoes.getNomeOfertante() + " Fiot Master " + date + " com um total de R$ " 
					+ String.format("%.2f", missoes.getTotal());
			Twilio.init(twilioSid, twilioKey);

			PhoneNumber to = new PhoneNumber(twilioPhoneTo);
			PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

			Message message = Message.creator(to, from, msg).create();

			System.out.println(message.getSid());
		}
	}


