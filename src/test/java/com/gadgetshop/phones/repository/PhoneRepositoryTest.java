package com.gadgetshop.phones.repository;

import com.gadgetshop.phones.model.OperatingSystem;
import com.gadgetshop.phones.model.Phone;
import com.gadgetshop.phones.model.Specifications;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class PhoneRepositoryTest {

		@Autowired
		private TestEntityManager entityManager;

		@Autowired
		private PhoneRepository repo;

		@Autowired
		private SpecificationsRepository specsRepo;

		@Autowired
		private OperatingSystemRepository osRepo;

//		@Test
//		public void testCreatOs(){
//				OperatingSystem os = new OperatingSystem();
//				//Os
//				os.set_osVersion(13.0);
//				os.set_osName("iOS 13");
//				os.set_osCreatorName("Apple");
//
//				OperatingSystem savedOs = osRepo.save(os);
//
//				OperatingSystem existOs = entityManager.find(OperatingSystem.class, savedOs.get_osId());
//
//				assertThat(os.get_osId()).isEqualTo(existOs.get_osId());
//		}
		@Test
		public void testCreatePhone(){
				Phone phone = new Phone();
				OperatingSystem os = new OperatingSystem();
				Specifications specs = new Specifications();

				//Specs
				specs.set_ram(8);
				specs.set_rom(128);
				specs.set_soc("A13 Bionic (7 nm+)");
				specs.set_screenSize("1700x900");
				specs.set_os(os);

				//Os
				os.set_osVersion(13.0);
				os.set_osName("iOS 13");
				os.set_osCreatorName("Apple");

				phone.set_name("IPHONE11 128GB Black");
				phone.set_price(6.77);
				phone.set_sku("ert");
				phone.set_img("https://www.tele2.nl/Consumer/media/images/_mobiel/alle-telefoons/apple/iphone-11/shop/black/dvi-front-back_Iphone11_Zwart_305x450.png");
				phone.set_manufacturerName("Apple");
				phone.set_modelName("Iphone 11");
				phone.set_color("Black");
				phone.set_specs(specs);

				Phone savedPhone = repo.save(phone);

				Phone existPhone = entityManager.find(Phone.class, savedPhone.get_phoneId());

				assertThat(phone.get_phoneId()).isEqualTo(existPhone.get_phoneId());
		}
}
