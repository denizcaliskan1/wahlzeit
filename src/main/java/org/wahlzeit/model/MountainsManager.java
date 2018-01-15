package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Set;

public class MountainsManager {
	
	private static MountainsManager instance = new MountainsManager();

	private Set<MountainsType> mountainsTypes = new HashSet<MountainsType>();
	private Set<Mountains> mountains = new HashSet<Mountains>();
	
	
	public Mountains createMountains(MountainsType type) {
		Mountains m = new Mountains(type);
		mountains.add(m);
		return m;
	}
	
	public Mountains createMountains(String name, int elevation, String location, String range) {
		MountainsType type = createMountainsType(name, elevation, location, range);
		Mountains m = new Mountains(type);
		mountains.add(m);
		return m;
	}
	
	private MountainsType createMountainsType(String name, int elevation, String location, String range) {
		
		for( MountainsType type : mountainsTypes ) {
			if ( type.name.equals(name) ){ /*Mountains have unique names*/
				return type;
			}
		}
		MountainsType type = new MountainsType(name, elevation, location, range);
		mountainsTypes.add(type);
		return type;
	}
	
	public static MountainsManager getInstance() {
		return instance;
	}
	
	

}
