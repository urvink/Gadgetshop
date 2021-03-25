package com.gadgetshop.phones.model;

import javax.persistence.*;

@Entity
@Table(name = "stock")
public class Stock {
		@Id
		@Column(name = "phoneId")
		private Long _id;

		@Column(name = "amount")
		private Integer _stockAmount;

		@OneToOne
		@MapsId
		@JoinColumn(name = "phoneId")
		private Phone phone;

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

		public Phone getPhone() {
				return phone;
		}

		public void setPhone(Phone phone) {
				this.phone = phone;
		}
}
