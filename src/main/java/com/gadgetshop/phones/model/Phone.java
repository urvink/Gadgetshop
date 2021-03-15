package com.gadgetshop.phones.model;

public class Phone extends Product{
		//Properties
		private String _os;
		private Integer _ram;
		private Integer _rom;
		private String _soc;
		private Double _screenSize;

		//Methods
		public Phone(String modelName, String manufacturerName, String os, Integer ram, Integer rom, String soc, Double screenSize) {
				super(modelName, manufacturerName);
				this._os = os;
				this._ram = ram;
				this._rom = rom;
				this._soc = soc;
				this._screenSize = screenSize;
		}

		public String get_os() {
				return _os;
		}

		public void set_os(String _os) {
				this._os = _os;
		}

		public Integer get_ram() {
				return _ram;
		}

		public void set_ram(Integer _ram) {
				this._ram = _ram;
		}

		public Integer get_rom() {
				return _rom;
		}

		public void set_rom(Integer _rom) {
				this._rom = _rom;
		}

		public String get_soc() {
				return _soc;
		}

		public void set_soc(String _soc) {
				this._soc = _soc;
		}

		public Double get_screenSize() {
				return _screenSize;
		}

		public void set_screenSize(Double _screenSize) {
				this._screenSize = _screenSize;
		}
}
