package com.gadgetshop.phones.Service;

import com.gadgetshop.phones.model.Phone;
import com.gadgetshop.phones.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class PhoneService {
		@Autowired
		private PhoneRepository repo;

		public List<Phone> findAll(){
				return repo.findAll();
		}

		public List<Phone> findAllById(Iterable<Long> longs){
				return repo.findAllById(longs);
		}
}
