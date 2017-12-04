package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate{


	@Override
	public double getCartesianDistance(Coordinate c) {
		
		assertClassInvariants();
		
		//precondition
		assertIsNotNull(c);
		
		double d = this.asCartesianCoordinate().getDistance(c);
		
		//postcondition
		assertIsPositive(d);
		
		assertClassInvariants();
		return d;
	}

	@Override
	public double getSphericDistance(Coordinate c) {
		
		assertClassInvariants();
		
		//precondition
		assertIsNotNull(c);
		
		double d = this.asSphericCoordinate().getDistance(c);
		
		//postcondition
		assertIsPositive(d);
		
		assertClassInvariants();
		
		return d;
	}

	@Override
	public boolean isEqual(Coordinate c) {
		
		CartesianCoordinate other = c.asCartesianCoordinate();
		
		if(Double.doubleToLongBits(other.getX()) != Double.doubleToLongBits(this.asCartesianCoordinate().getX()))
			return false;
		if(Double.doubleToLongBits(other.getY()) != Double.doubleToLongBits(this.asCartesianCoordinate().getX()))
			return false;
		if(Double.doubleToLongBits(other.getZ()) != Double.doubleToLongBits(this.asCartesianCoordinate().getX()))
			return false;
		
		return true;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(this.asCartesianCoordinate().getX());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.asCartesianCoordinate().getY());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.asCartesianCoordinate().getZ());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		
		return isEqual(other);
	}
	
	protected abstract void assertClassInvariants();
	
	protected void assertIsNotNull(Coordinate c) {
		assert c != null;
	}
	protected void assertIsPositive( double d ) {
		assert d >= 0;
	}
}
