package by.epam.test.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import by.epam.test.models.*;
import by.epam.test.models.Planet.PlanetType;
import by.epam.test.models.Star.StarType;

public class Parser
{
	private List<StarSystem> systems;
	
	public void parse(String fileName) throws SAXException, IOException, ParserConfigurationException
	{
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(fileName));
		doc.getDocumentElement().normalize();
		
		systems = new ArrayList<StarSystem>();
		
		NodeList list = doc.getDocumentElement().getChildNodes();
		for (int i = 0; i < list.getLength(); i++) 
		{
			 
			Node node = list.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				AstronomicalObject object = parseNode(node);
				addNewObject(object);
			}
		}
	}
	
	private AstronomicalObject parseNode(Node node)
	{
		Element element = (Element) node;
		String name = element.getElementsByTagName("name").item(0).getTextContent();
		String systemName = element.getAttribute("system_name");
		double weight = Double.parseDouble(element.getElementsByTagName("weight").item(0).getTextContent());
		if (element.getNodeName() == "star")
		{
			StarType type = getStarTypeByName(element.getElementsByTagName("type").item(0).getTextContent());
			Star star = new Star(name, weight, type, systemName);
			//System.out.println(star.toString());
			return star;
		}
		else if (element.getNodeName() == "planet")
		{			
			PlanetType type = getPlanetTypeByName(element.getElementsByTagName("type").item(0).getTextContent());
			Planet planet = new Planet(name, weight, type, systemName, null);
			ArrayList<Satellite> satellites = getSatellitesByElement(element, planet);
			planet.setSatellites(satellites);
			//System.out.println(planet.toString());
			return planet;
		}
		else if (element.getNodeName() == "satellite")
		{
			Satellite satellite = new Satellite(name, weight);
			ArrayList<Satellite> satellites = getSatellitesByElement(element, satellite);
			satellite.setSatellites(satellites);
			return satellite;
		}
		return null;
	}
	
	private StarType getStarTypeByName(String text)
	{
		for (StarType type : StarType.values()) 
		{
	        if (text.equalsIgnoreCase(type.toString())) 
	        {
	        	return type;
	        }
	    }
		return null;
	}
	
	private PlanetType getPlanetTypeByName(String text)
	{
		for (PlanetType type : PlanetType.values()) 
		{
	        if (text.equalsIgnoreCase(type.toString())) 
	        {
	        	return type;
	        }
	    }
		return null;
	}
	
	private void addNewObject(AstronomicalObject object)
	{
		StarSystem system = getSystemByName(object.getSystemName());
		system.addObject(object);
	}
	
	private StarSystem getSystemByName(String name)
	{
		for(StarSystem system : systems)
		{
			if (name.equalsIgnoreCase(system.getName()))
				{
					return system;
				}
		}
		StarSystem newSystem = new StarSystem();
		systems.add(newSystem);
		return newSystem;
	}
	
	private ArrayList<Satellite> getSatellitesByElement(Element element, AstronomicalObject centralBody)
	{
		NodeList list = element.getElementsByTagName("satellites");
		ArrayList<Satellite> satellites = new ArrayList<Satellite>();
		if (list.getLength() != 0)
		{
			list = list.item(0).getChildNodes();
			for (int i = 0; i < list.getLength(); i++) 
			{
				Node node = list.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE)
				{
					Satellite satellite = (Satellite) parseNode(node);
					satellite.setCentralBody(centralBody);
					satellites.add(satellite);
					//System.out.println(satellite.toString());
				}
			}
		}
		return satellites;
	}
}
