package org.wahlzeit.model;

import java.util.logging.Logger;

public class MountainsPhotoManager extends PhotoManager {
	
	protected static final MountainsPhotoManager instance = new MountainsPhotoManager();
	private static final Logger log = Logger.getLogger(MountainsPhotoManager.class.getName());
	
	public MountainsPhotoManager() {
		super();
	}
	
	/**
	 *
	 */
	public static MountainsPhotoManager getInstance() {
		return instance;
	}
}
