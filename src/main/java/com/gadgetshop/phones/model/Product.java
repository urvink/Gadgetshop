package com.gadgetshop.phones.model;

import javax.persistence.*;

public abstract class Product {
		//Properties
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "prodId")
		private Long _prodId;

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



		//Methods
//		public Product(String modelName, String sku, String manufacturerName, String img, Double price, Specifications specs) {
//				this._modelName = modelName;
//				this._sku = sku;
//				this._manufacturerName = manufacturerName;
//				this._img = img;
//				this._price = price;
//				this._specs = specs;
//		}

		public Long get_prodId() {
				return _prodId;
		}

		public String get_color() {
				return _color;
		}

		public void set_color(String _color) {
				this._color = _color;
		}

		public String get_img() {
				return _img;
		}

		public void set_img(String _img) {
				this._img = _img;
		}

		public String get_modelName() {
				return _modelName;
		}

		public void set_modelName(String _modelName) {
				this._modelName = _modelName;
		}

		public String get_manufacturerName() {
				return _manufacturerName;
		}

		public String get_sku() {
				return _sku;
		}

		public void set_sku(String _sku) {
				this._sku = _sku;
		}

		public Double get_price() {
				return _price;
		}

		public void set_price(Double _price) {
				this._price = _price;
		}

		public void set_manufacturerName(String _manufacturerName) {
				this._manufacturerName = _manufacturerName;
		}
}
