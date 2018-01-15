package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Subclass;

@Entity
@Subclass
public class MountainsPhoto extends Photo {
	
	private Mountains mountains;
	
	public MountainsPhoto() {
		super(PhotoId.getNextId());
	}
	
	public MountainsPhoto(PhotoId id) {
		super(id);
	}
	
	public MountainsPhoto(MountainsType type) {
		super();
		Mountains m = MountainsManager.getInstance().createMountains(type);
		this.mountains = m;
	}

	public MountainsPhoto(Mountains mountains) {
		super();
		this.mountains = mountains;
	}
	
	public MountainsPhoto(Mountains mountains, PhotoId id) {
		
		super(id);
		
		this.mountains = mountains;
	}

}
