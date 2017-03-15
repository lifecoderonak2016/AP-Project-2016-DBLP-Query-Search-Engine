package approject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EntityHandler extends DefaultHandler {

	private String author;

	private String result;

	private boolean aliasexist;

	private boolean wwwTagExist;

	private List<String> entities;

	public List<String> getEntities() 
	{
		return entities;
	}

	public String getAuthor() 
	{
		return author;
	}

	public boolean hasAlias() 
	{
		return this.aliasexist;
	}

	public boolean hasWWWTag() 
	{
		return this.wwwTagExist;
	}

	public EntityHandler(String author) 
	{
		super();
		this.author = author;
	}

	@Override
	public void startDocument() throws SAXException 
	{
		this.entities = new ArrayList<String>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException 
	{
		result = "";
		if (qName.equalsIgnoreCase("www")) 
		{
			this.wwwTagExist = true;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException 
	{
		result = new String(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException 
	{
		if (this.wwwTagExist) 
		{
			if (qName.equalsIgnoreCase("www")) 
			{
				if (getEntities().contains(author)) 
				{
					if (!this.aliasexist) 
					{
						this.aliasexist = true;
					}
				} 
				else 
				{
					entities.clear();
				}
				this.wwwTagExist = false;
			} 
			else if (qName.equalsIgnoreCase("author") && !this.aliasexist) 
			{
				entities.add(result);
			}

		}
	}

	@Override
	public void endDocument() throws SAXException 
	{
		System.out.println(getEntities().isEmpty());
		if (getEntities().size() == 0) 
		{
			this.aliasexist = false;
		}
	}

	public void parseEntity() 
	{
		try 
		{
			File xmlFile = new File("dblp.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(xmlFile, new EntityHandler(author));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}