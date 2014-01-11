package by.epam.test.models;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

public class StarSystem
{
	protected String name;
	
	protected ArrayList<Star> stars;
	protected ArrayList<Planet> planets;
	
	protected double weight;
	protected long objectsCount;
	
	public StarSystem()
	{
		weight = 0;
		objectsCount = 0;
		stars = new ArrayList<Star>();
		planets = new ArrayList<Planet>();
	}
	
	private double calculateWeight(ArrayList<Satellite> satellites)
	{
		double weight = 0;
		
		for (Satellite satellite : satellites)
		{
			weight += satellite.weight;
			if (satellite.getSatellites().size() != 0)
			{
				weight += calculateWeight(satellite.getSatellites());
			}
		}		
		
		return weight;
	}
	
	private long calculateCount(ArrayList<Satellite> satellites)
	{
		long count = 0;
		
		for (Satellite satellite : satellites)
		{
			count ++;
			if (satellite.getSatellites().size() != 0)
			{
				count += calculateCount(satellite.getSatellites());
			}
		}		
		
		return count;
	}
	
	
	public void addObject(AstronomicalObject object)
	{
		if (object.getClass() == Star.class)
		{
			stars.add((Star) object);
			weight += object.getWeight();
			objectsCount ++;
		}
		else if (object.getClass() == Planet.class)
		{
			planets.add((Planet) object);
			weight += object.getWeight();
			objectsCount ++;
			if (((Planet)object).getSatellites().size() != 0)
			{
				weight += calculateWeight(((Planet)object).getSatellites());
				objectsCount += calculateCount(((Planet)object).getSatellites());
			}
		}
		
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public ArrayList<Star> getStars()
	{
		return stars;
	}

	public void setStars(ArrayList<Star> stars)
	{
		this.stars = stars;
	}

	public ArrayList<Planet> getPlanets()
	{
		return planets;
	}

	public void setPlanets(ArrayList<Planet> planets)
	{
		this.planets = planets;
	}

	public double getWeight()
	{
		return weight;
	}

	public void setWeight(double weight)
	{
		this.weight = weight;
	}

}
