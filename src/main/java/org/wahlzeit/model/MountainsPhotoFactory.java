package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

public class MountainsPhotoFactory extends PhotoFactory {

	
	private static final Logger log = Logger.getLogger(MountainsPhotoFactory.class.getName());
	
	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	private static MountainsPhotoFactory instance = null;	
	
	protected MountainsPhotoFactory() {/*do nothing*/}
	
	public static void initialize() {
		getInstance();
	}
	
	/**
	 * Public singleton access method.
	 */
	public static synchronized PhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic MountainsPhotoFactory").toString());
			setInstance(new MountainsPhotoFactory());
		}

		return instance;
	}
	
	/**
	 * Method to set the singleton instance of PhotoFactory.
	 */
	protected static synchronized void setInstance(MountainsPhotoFactory photoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize PhotoFactory twice");
		}

		instance = photoFactory;
	}
	
	/**
	 * @methodtype factory
	 */
	public MountainsPhoto createPhoto() {
		return new MountainsPhoto();
	}
	public MountainsPhoto createPhoto(PhotoId id) {
		return new MountainsPhoto(id);
	}
	public MountainsPhoto createPhoto(int height, PhotoId id) {
		return new MountainsPhoto(height,id);
	}
}
