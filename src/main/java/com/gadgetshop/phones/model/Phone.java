package com.gadgetshop.phones.model;

import javax.persistence.*;

@Entity
@Table(name = "phones")
public class Phone extends Product{

		private



		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "specsId", referencedColumnName = "_prodId")
		private Specifications _specs;

}
