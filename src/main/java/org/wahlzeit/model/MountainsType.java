package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.wahlzeit.services.DataObject;

public class MountainsType extends DataObject {

	protected MountainsType superType = null;
	protected Set<MountainsType> subTypes = new HashSet<MountainsType>();
	
	protected String name = "";			/*Name of the Mountain*/
	protected int elevation = 0; 		/*Elevation above sea level*/
	protected String location = "";	/*Nation, the Mountain is located in*/
	protected String range = ""; 		/*Mountain range the mountain belongs to*/
	
	public MountainsType( String name, int elevation, String location, String range) {
		
		this.name		= name;
		this.elevation 	= elevation;
		this.location 	= location;
		this.range 		= range;
	}
	
	public MountainsType getSuperType() {
		return superType;
	}
	
	public Iterator<MountainsType> getSubTypeIterator(){
		return subTypes.iterator();
	}
	
	public void addSubType(MountainsType mt) {
		assert (mt != null) : "tried to set null sub-type";
		mt.setSuperType(this);
		subTypes.add(mt);
	}

	private void setSuperType(MountainsType mt) {
		this.superType = mt;
	}
	
	public boolean hasInstance(Mountains mountains) {
		assert(mountains != null) : "asked about null object";
		if( mountains.getType() == this) {
			return true;
		}
		
		for( MountainsType type : subTypes ) {
			if( type.hasInstance(mountains)) {
				return true;
			}
		}
		return false;
	}
	
	public String getName() {
		return this.name;
	}
}
