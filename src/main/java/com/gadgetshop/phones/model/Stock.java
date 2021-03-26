package com.gadgetshop.phones.model;

import javax.persistence.*;
@Embeddable
@Table(name = "stock")
public class Stock {
		@Id
		@OneToOne(cascade = CascadeType.ALL)
//		@MapsId
		private Long _id;

		@Column(name = "amount")
		private Integer _stockAmount;

		//Methods
		public Stock() {
		}

		public Long get_id() {
				return _id;
		}

		public void set_id(Long _id) {
				this._id = _id;
		}

		public Integer get_stockAmount() {
				return _stockAmount;
		}

		public void set_stockAmount(Integer _stockAmount) {
				this._stockAmount = _stockAmount;
		}

//		public Phone getPhone() {
//				return phone;
//		}
//
//		public void setPhone(Phone phone) {
//				this.phone = phone;
//		}
}
