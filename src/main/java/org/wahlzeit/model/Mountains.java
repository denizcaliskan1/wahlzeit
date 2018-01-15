package org.wahlzeit.model;

public class Mountains {
	
	protected MountainsType type = null;

	
	public Mountains(MountainsType type) {
		this.type = type;
	}
	
	public MountainsType getType() {
		return type;
	}

}
