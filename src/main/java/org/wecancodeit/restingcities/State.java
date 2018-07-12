package org.wecancodeit.restingcities;

import java.util.Collection;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class State {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String motto;
	private String abbreviation;
	private String citiesUrl;
	
	@JsonIgnore
	@OneToMany(mappedBy = "state")
	private Collection<City> cities;

	public Collection<City> getCities() {
		return cities;
	}

	@Embedded
	private Fish fish;

	public State() {}
	
	public State(String name, String motto, String abbreviation, String citiesUrl, Fish fish) {
		this.name = name;
		this.motto = motto;
		this.abbreviation = abbreviation;
		this.citiesUrl = citiesUrl;
		this.fish = fish;
	}

	public Long getid() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMotto() {
		return motto;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public String getCitiesUrl() {
		return citiesUrl;
	}
	
	public Fish getFish() {
		return fish;
	}

	@Override
	public String toString() {
		return name;
	}
}
