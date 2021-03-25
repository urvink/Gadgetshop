package com.gadgetshop.phones.model;

import javax.persistence.*;

@Entity
@Table(name = "phones")
public class Phone{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "phoneId")
		private Long _phoneId;

		@Column(name = "name")
		private String _name;

		//Properties
		@Column(name = "modelName")
		private String _modelName;

		@Column(name = "sku")
		private String _sku;

		@Column(name = "manufacturerName")
		private String _manufacturerName;

		@Column(name = "img")
		private String _img;

		@Column(name = "price")
		private Double _price;

		@Column(name = "color")
		private String _color;

		@Column(name = "amountInStock")
		private Integer _stockAmount;

		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "specsId", referencedColumnName = "id")
		private Specifications specs;

//		@OneToOne(cascade = CascadeType.ALL, mappedBy = "phone")
//		@PrimaryKeyJoinColumn
//		private Stock stock;

		public Phone() {
		}

		public Phone(String name, String modelName, String sku, String manufacturerName, String img, Double price, String color) {
				this._name = name;
				this._modelName = modelName;
				this._sku = sku;
				this._manufacturerName = manufacturerName;
				this._img = img;
				this._price = price;
				this._color = color;
		}

		public Long get_phoneId() {
				return _phoneId;
		}

		public void set_phoneId(Long _phoneId) {
				this._phoneId = _phoneId;
		}

		public String get_name() {
				return _name;
		}

		public void set_name(String _name) {
				this._name = _name;
		}

		public String get_modelName() {
				return _modelName;
		}

		public void set_modelName(String _modelName) {
				this._modelName = _modelName;
		}

		public String get_sku() {
				return _sku;
		}

		public void set_sku(String _sku) {
				this._sku = _sku;
		}

		public String get_manufacturerName() {
				return _manufacturerName;
		}

		public void set_manufacturerName(String _manufacturerName) {
				this._manufacturerName = _manufacturerName;
		}

		public String get_img() {
				return _img;
		}

		public void set_img(String _img) {
				this._img = _img;
		}

		public Double get_price() {
				return _price;
		}

		public void set_price(Double _price) {
				this._price = _price;
		}

		public String get_color() {
				return _color;
		}

		public void set_color(String _color) {
				this._color = _color;
		}

		public Integer get_stockAmount() {
				return _stockAmount;
		}

		public void set_stockAmount(Integer _stockAmount) {
				this._stockAmount = _stockAmount;
		}

		public Specifications getSpecs() {
				return specs;
		}

		public void setSpecs(Specifications specs) {
				this.specs = specs;
		}
}
