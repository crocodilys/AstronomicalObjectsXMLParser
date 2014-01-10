package by.epam.test.models;

public class Star extends AstronomicalObject
{
	
	public enum StarType
	{
		DWARF, GIANT, NEW, NEUTRON   
	}

	protected StarType type;

	public Star()
	{
		super();
	}
	
	public Star(String name, double weight, StarType type, String systemName)
	{
		super(name, weight, systemName);
		this.type = type;
		this.systemName = systemName;
	}

	public StarType getType()
	{
		return type;
	}

	public void setType(StarType type)
	{
		this.type = type;
	}
	
	@Override
	public String toString()
	{
		return new String("Star: " + name + ". System name: " + systemName + 
				". Weight: " + weight + ". Type:" + type);
		
	}

}
