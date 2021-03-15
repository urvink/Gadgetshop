package com.gadgetshop.phones.model;

public abstract class Product {
		//Properties
		private Integer _prodId;

		private String _modelName;

		private String _manufacturerName;

		//Methods
		public Product(String modelName, String manufacturerName) {
				this._modelName = modelName;
				this._manufacturerName = manufacturerName;
		}

		public Integer get_prodId() {
				return _prodId;
		}

		public void set_prodId(Integer _prodId) {
				this._prodId = _prodId;
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

		public void set_manufacturerName(String _manufacturerName) {
				this._manufacturerName = _manufacturerName;
		}
}
