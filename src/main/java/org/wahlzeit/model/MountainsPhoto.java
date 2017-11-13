package org.wahlzeit.model;

public class MountainsPhoto extends Photo {
	
	private int height;
	
	public MountainsPhoto() {
		this(0,PhotoId.getNextId());
	}

	public MountainsPhoto(int height, PhotoId id) {
		super(id);
		this.height = height;
	}

	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
