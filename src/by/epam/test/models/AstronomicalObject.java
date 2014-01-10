package by.epam.test.models;

public abstract class  AstronomicalObject
{
	
	protected String name;
	protected String systemName;

	protected double weight;
	
	public AstronomicalObject()
	{
		
	}
	
	public AstronomicalObject(String name, double weight, String systemName)
	{
		this.name = name;
		this.weight = weight;
		this.systemName = systemName;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getWeight()
	{
		return weight;
	}

	public void setWeight(double weight)
	{
		this.weight = weight;
	}
	
	public String getSystemName()
	{
		return systemName;
	}

	public void setSystemName(String systemName)
	{
		this.systemName = systemName;
	}

}
