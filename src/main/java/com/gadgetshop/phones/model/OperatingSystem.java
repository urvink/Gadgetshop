package com.gadgetshop.phones.model;

import javax.persistence.*;

@Entity
@Table(name = "os")
public class OperatingSystem {
		//Properties
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private Long _osId;

		@Column(name = "osName")
		private String _osName;

		@Column(name = "osVersion")
		private Double _osVersion;

		@Column(name = "osMaker")
		private String _osCreatorName;

		//Methods
		public OperatingSystem() {
		}

		public Long get_osId() {
				return _osId;
		}

		public void set_osId(Long _osId) {
				this._osId = _osId;
		}

		public String get_osName() {
				return _osName;
		}

		public void set_osName(String _osName) {
				this._osName = _osName;
		}

		public Double get_osVersion() {
				return _osVersion;
		}

		public void set_osVersion(Double _osVersion) {
				this._osVersion = _osVersion;
		}

		public String get_osCreatorName() {
				return _osCreatorName;
		}

		public void set_osCreatorName(String _osCreatorName) {
				this._osCreatorName = _osCreatorName;
		}

//		public Specifications getSpecs() {
//				return specs;
//		}
//
//		public void setSpecs(Specifications specs) {
//				this.specs = specs;
//		}
}
