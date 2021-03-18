package com.gadgetshop.phones.repository;

import com.gadgetshop.phones.model.Phone;
import com.gadgetshop.phones.model.Product;
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

		@Test
		public void testCreatePhone(){
				Phone phone = new Phone();

//				Specifications specs = new Specifications();


				phone.set_price(6.77);
				phone.set_sku("ert");
				phone.set_img("https://www.tele2.nl/Consumer/media/images/_mobiel/alle-telefoons/apple/iphone-11/shop/black/dvi-front-back_Iphone11_Zwart_305x450.png");
				phone.set_manufacturerName("Apple");
				phone.set_modelName("Iphone 11");
				phone.set_color("Black");
//				specs.set_os("Android");
//				specs.set_ram(8);
//				specs.set_rom(128);
//				specs.set_soc("TEST");
//				specs.set_screenSize("1700x900");

				Phone savedPhone = repo.save(phone);

				Phone existPhone = entityManager.find(Phone.class, savedPhone.get_prodId());

				assertThat(phone.get_prodId()).isEqualTo(existPhone.get_prodId());
		}
		@Test
		public void testCreateProduct(){
				Phone phone = new Product();

//				Specifications specs = new Specifications();


				phone.set_price(6.77);
				phone.set_sku("ert");
				phone.set_img("https://www.tele2.nl/Consumer/media/images/_mobiel/alle-telefoons/apple/iphone-11/shop/black/dvi-front-back_Iphone11_Zwart_305x450.png");
				phone.set_manufacturerName("Apple");
				phone.set_modelName("Iphone 11");
				phone.set_color("Black");
//				specs.set_os("Android");
//				specs.set_ram(8);
//				specs.set_rom(128);
//				specs.set_soc("TEST");
//				specs.set_screenSize("1700x900");

				Phone savedPhone = repo.save(phone);

				Phone existPhone = entityManager.find(Phone.class, savedPhone.get_prodId());

				assertThat(phone.get_prodId()).isEqualTo(existPhone.get_prodId());
		}

}
