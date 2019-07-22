package org.jewellery.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="jewellery", name="unit")
public class UnitModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UnitId")
	private Integer UnitId;
	
	@Column(name="Carat")
	private Integer Carat;
	
}
