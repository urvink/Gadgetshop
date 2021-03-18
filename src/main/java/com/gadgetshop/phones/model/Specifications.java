package com.gadgetshop.phones.model;

import javax.persistence.*;

@Entity
@Table(name = "specifications")
public class Specifications {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long specsId;

		@Column(name = "os")
		private String _os;

		@Column(name = "ram")
		private Integer _ram;

		@Column(name = "rom")
		private Integer _rom;

		@Column(name = "soc")
		private String _soc;

		@Column(name = "screenSize")
		private String _screenSize;

		@OneToOne(mappedBy = "products")
		private Product product;

		//Method
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

		public String get_screenSize() {
				return _screenSize;
		}

		public void set_screenSize(String _screenSize) {
				this._screenSize = _screenSize;
		}
}
