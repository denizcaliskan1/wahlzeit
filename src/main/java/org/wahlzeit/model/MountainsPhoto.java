package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Subclass;

@Entity
@Subclass
public class MountainsPhoto extends Photo {
	
	private int height;
	
	public MountainsPhoto() {
		this(0,PhotoId.getNextId());
	}
	
	public MountainsPhoto(PhotoId id) {
		this(0,id);
	}

	public MountainsPhoto(int height, PhotoId id) {
		
		super(id);
		
		if( height < 0 ) {
			throw new IllegalArgumentException("Height of a Mountain can not be below zero!");
		}
		
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
