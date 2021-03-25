package com.gadgetshop.phones.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "specs")
public class Specifications {
		//Properties
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private Long _specsId;

		@Column(name = "ram")
		private Integer _ram;

		@Column(name = "rom")
		private Integer _rom;

		@Column(name = "soc")
		private String _soc;

		@Column(name = "screenSize")
		private String _screenSize;

		@OneToOne(cascade = CascadeType.ALL, mappedBy = "specs")
		private Phone phone;

		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "_osId", referencedColumnName = "id")
		@JsonBackReference
		private OperatingSystem os;

		//Methods
		public Specifications() {
		}

		public Long get_specsId() {
				return _specsId;
		}

		public void set_specsId(Long _specsId) {
				this._specsId = _specsId;
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

		public Phone get_phone() {
				return phone;
		}

		public void set_phone(Phone phone) {
				this.phone = phone;
		}

		public OperatingSystem getOs() {
				return os;
		}

		public void setOs(OperatingSystem os) {
				this.os = os;
		}
}
