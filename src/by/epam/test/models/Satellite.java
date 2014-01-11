package by.epam.test.models;

import java.util.ArrayList;

public class Satellite extends AstronomicalObject
{
	
	protected AstronomicalObject centralBody;
	
	protected ArrayList<Satellite> satellites;
	
	public Satellite()
	{
		super();
		satellites = new ArrayList<Satellite>();
	}
	
	public Satellite(String name, double weight)
	{
		super(name, weight, null);
		satellites = new ArrayList<Satellite>();
	}

	@Override
	public String toString()
	{
		return new String("Satellite: " + name + ". System name: " + systemName + 
				". Weight: " + weight);
		
	}

	public AstronomicalObject getCentralBody()
	{
		return centralBody;
	}

	public void setCentralBody(AstronomicalObject centralBody)
	{
		this.centralBody = centralBody;
		this.systemName = centralBody.name;
	}

	public ArrayList<Satellite> getSatellites()
	{
		return satellites;
	}

	public void setSatellites(ArrayList<Satellite> satellites)
	{
		this.satellites = satellites;
	}

}
