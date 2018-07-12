package org.wecancodeit.restingcities;

import javax.persistence.Embeddable;

@Embeddable
public class Fish {
	
	private String fishName;
	private String taxonomy;
	private String imgUrl;
	
	public Fish () {}
	
	public Fish(String fishName, String taxonomy, String imgUrl) {
		this.fishName = fishName;
		this.taxonomy = taxonomy;
		this.imgUrl = imgUrl;
	}

	public String getfishName() {
		return fishName;
	}

	public String getTaxonomy() {
		return taxonomy;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	@Override
	public String toString() {
		return fishName ;
	}

	
	
	

}
