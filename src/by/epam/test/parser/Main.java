package by.epam.test.parser;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main
{

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException
	{
		Parser parser = new Parser();
		parser.parse("astronomical_objects.xml");
	}

}
