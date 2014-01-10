package by.epam.test.models;

import java.util.ArrayList;

public class Planet extends AstronomicalObject
{
	
	public enum PlanetType
	{
		DWARF, EARTH_LIKE, GIANT  
	}

	protected PlanetType type;

	protected ArrayList<Satellite> satellites;
	
	public Planet()
	{
		super();
		satellites = new ArrayList<Satellite>();
	}
	
	public Planet(String name, double weight, PlanetType type, String systemName, ArrayList<Satellite> satellites)
	{
		super(name, weight, systemName);
		this.type = type;
		this.satellites = satellites;
	}
	
	public PlanetType getType()
	{
		return type;
	}

	public void setType(PlanetType type)
	{
		this.type = type;
	}

	public ArrayList<Satellite> getSatellites()
	{
		return satellites;
	}

	public void setSatellites(ArrayList<Satellite> satellites)
	{
		this.satellites = satellites;
	}
	
	@Override
	public String toString()
	{
		return new String("Planet: " + name + ". System name: " + systemName + 
				". Weight: " + weight + ". Type:" + type);
		
	}

}
