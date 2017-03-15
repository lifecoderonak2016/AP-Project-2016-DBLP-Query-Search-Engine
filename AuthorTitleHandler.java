package approject;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AuthorTitleHandler extends DefaultHandler {

	private String result;

	private String searchType;

	private String searchQuery;

	private Article article;

	private List<Article> searchResults;

	public EntityHandler entity;

	public List<Article> getSearchResults() 
	{
		return searchResults;
	}

	public AuthorTitleHandler(String searchType, String searchQuery) 
	{
		super();
		this.searchType = searchType;
		this.searchQuery = searchQuery;
		if (searchType.equals("by author")) {
			entity = new EntityHandler(searchQuery);
			entity.parseEntity();
		}
	}

	public String getResult() 
	{
		return this.result;
	}

	public String getSearchQuery() 
	{
		return searchQuery;
	}

	public String getSearchType() 
	{
		return searchType;
	}

	public void setSearchQuery(String searchQuery) 
	{
		this.searchQuery = searchQuery;
	}

	public void setSearchType(String searchType) 
	{
		this.searchType = searchType;
	}

	public boolean cond() 
	{
		if (searchType.equals("by title tags")) 
		{
			boolean substr = false;
			for (String s : searchQuery.split(" ")) 
			{
				if (article.getTitle().contains(s)) 
				{
					substr = true;
					break;
				}
			}
			return (article.getTitle().contains(searchQuery) || substr);
		} else if (searchType.equals("by author")) 
		{
			System.out.println(
					"alias " + entity.hasAlias() + " array " + Arrays.toString(entity.getEntities().toArray()));
			if (!entity.hasAlias()) 
			{
				return article.getAuthors().contains(searchQuery);
			} 
			else 
			{
				boolean entitypres = false;
				for (String s : entity.getEntities()) 
				{
					if (article.getAuthors().contains(s)) 
					{
						entitypres = true;
						break;
					}
				}
				return entitypres;
			}
		}
		return false;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException 
	{
		result = new String(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException 
	{
		if (article != null) 
		{
			if ((qName.equalsIgnoreCase("article") || qName.equalsIgnoreCase("inproceedings")
					|| qName.equalsIgnoreCase("proceedings") || qName.equalsIgnoreCase("book")
					|| qName.equalsIgnoreCase("incollection") || qName.equalsIgnoreCase("phdthesis")
					|| qName.equalsIgnoreCase("masterthesis"))) {
				if (cond()) 
				{
					searchResults.add(article);
					System.out.print("Title: " + article.getTitle() + "\nAuthors: "
							+ String.join(", ", article.getAuthors()) + "\nPages: " + article.getPages() + "\nYear: "
							+ article.getYear() + "\nVolume: " + article.getVolume() + "\nJournal: "
							+ article.getJournal() + "\nURL: " + article.getUrl() + "\n\n");
				} else {
					article = null;
				}
			} else if (qName.equalsIgnoreCase("author")) {
				article.getAuthors().add(result);
			} else if (qName.equalsIgnoreCase("title")) {
				article.setTitle(result);
			} else if (qName.equalsIgnoreCase("pages")) {
				article.setPages(result);
			} else if (qName.equalsIgnoreCase("year")) {
				article.setYear(Long.valueOf(result));
			} else if (qName.equals("volume")) {
				article.setVolume(result);
			} else if (qName.equalsIgnoreCase("journal") || qName.equalsIgnoreCase("booktitle")) {
				article.setJournal(result);
			} else if (qName.equalsIgnoreCase("url")) {
				article.setUrl(result);
			}
		}
	}

	@Override
	public void startDocument() throws SAXException {
		searchResults = new ArrayList<Article>();
	}

	@Override
	public void endDocument() throws SAXException {
		if (searchResults.size() == 0) {
			System.out.println("No results found for " + searchQuery);
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		result = "";
		if (qName.equalsIgnoreCase("article") || qName.equalsIgnoreCase("inproceedings")
				|| qName.equalsIgnoreCase("proceedings") || qName.equalsIgnoreCase("book")
				|| qName.equalsIgnoreCase("incollection") || qName.equalsIgnoreCase("phdthesis")
				|| qName.equalsIgnoreCase("masterthesis")) {
			article = new Article();
		}
	}

	public void parseAuthorTitle() {
		try {
			File xmlFile = new File("dblp.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(xmlFile, new AuthorTitleHandler(searchType, searchQuery));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		AuthorTitleHandler test = new AuthorTitleHandler("by author", "Margaret H. Dunham");
		test.parseAuthorTitle();
	}

}