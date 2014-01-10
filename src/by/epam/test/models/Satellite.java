package by.epam.test.models;

import java.util.ArrayList;

public class Satellite extends AstronomicalObject
{
	
	protected AstronomicalObject centralBody;
	
	protected ArrayList<Satellite> satellites;
	
	public Satellite()
	{
		super();
	}
	
	/*public Satellite(String name, double weight, AstronomicalObject centralBody, 
					ArrayList<Satellite> satellites)
	{
		super(name, weight, centralBody.getSystemName());
		this.centralBody = centralBody;
		this.satellites = satellites;
	}*/
	
	public Satellite(String name, double weight)
	{
		super(name, weight, null);
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
