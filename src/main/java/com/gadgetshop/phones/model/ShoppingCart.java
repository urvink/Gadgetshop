package com.gadgetshop.phones.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ShoppingCart {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Column(name = "Date")
		private LocalDateTime date;

		@Column(name = "quantity")
		private Integer qty;

		@OneToOne(cascade = CascadeType.ALL)
		private Phone phone;

		public Long getId() {
				return id;
		}

		public void setId(Long id) {
				this.id = id;
		}

		public LocalDateTime getDate() {
				return date;
		}

		public void setDate(LocalDateTime date) {
				this.date = date;
		}

		public Integer getQty() {
				return qty;
		}

		public void setQty(Integer qty) {
				this.qty = qty;
		}

		public Phone getPhone() {
				return phone;
		}

		public void setPhone(Phone phone) {
				this.phone = phone;
		}
}
