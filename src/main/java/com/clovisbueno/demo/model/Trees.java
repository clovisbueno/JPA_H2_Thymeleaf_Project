package com.clovisbueno.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Trees implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TREE_ID", precision=4) 
	private Long id;
	
	@Column(name="APPROXIMATE_AGE")
	private int approximateAge;
	
	@Column(name="HEIGHT", precision=2, scale=2) 
	private float height;
	
	@Column(name="LOCATION", length =50)
	private String location;
	
	@Column(name="SPECIES", length=80)
	private String species;
	
	@Column(name="TREE_TOP", precision=2, scale=2)
	private float treeTopDiameter;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getApproximateAge() {
		return approximateAge;
	}
	
	public void setApproximateAge(int approximateAge) {
		this.approximateAge = approximateAge;
	}
	
	public float getHeight() {
		return height;
	}
	
	public void setHeight(float height) {
		this.height = height;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getSpecies() {
		return species;
	}
	
	public void setSpecies(String species) {
		this.species = species;
	}
	public float getTreeTopDiameter() {
		return treeTopDiameter;
	}
	
	public void setTreeTopDiameter(float treeTopDiameter) {
		this.treeTopDiameter = treeTopDiameter;
	}
	@Override
	public String toString() {
		return "Trees [id=" + id + ", idade aproximada=" + approximateAge + ", altura=" + height + 
					  ", local=" + location + ", espécie=" + species +
				      ", diâmetro da copa=" + treeTopDiameter + "]";
	}

	public List<Trees> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
