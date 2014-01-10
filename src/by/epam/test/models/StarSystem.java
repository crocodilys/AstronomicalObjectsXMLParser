package by.epam.test.models;

import java.util.ArrayList;

public class StarSystem
{
	protected String name;
	
	protected ArrayList<Star> stars;
	protected ArrayList<Planet> planets;
	
	protected double weight;
	
	public StarSystem()
	{
		stars = new ArrayList<Star>();
		planets = new ArrayList<Planet>();
	}
	
	public StarSystem(String name, ArrayList<Star> stars, 
						ArrayList<Planet> planets)
	{
		this.stars = stars;
		this.planets = planets;
		calculateWeight();
	}
	
	private void calculateWeight()
	{
		double weight = 0;
		
		for (Star s : stars)
		{
			weight += s.getWeight();
		}
		
		for(Planet p : planets)
		{
			weight += p.getWeight();
		}
		
		this.weight = weight;
	}
	
	public void addObject(AstronomicalObject object)
	{
		if (object.getClass() == Star.class)
		{
			stars.add((Star) object);
		}
		else if (object.getClass() == Planet.class)
		{
			planets.add((Planet) object);
		}
		weight += object.getWeight();
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
