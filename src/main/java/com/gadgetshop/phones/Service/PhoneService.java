package com.gadgetshop.phones.Service;

import com.gadgetshop.phones.model.Phone;
import com.gadgetshop.phones.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {
		@Autowired
		private PhoneRepository repo;

		public List<Phone> findAll() {
				return repo.findAll();
		}

		public Optional<Phone> findById(Long id) {
				return repo.findById(id);
		}

		public void deleteById(Long dLong) {
				repo.deleteById(dLong);
		}

}
