package approject;

import java.util.ArrayList;
import java.util.List;

public class Article {

	private List<String> authors;
	private String title;
	private String pages;
	private long year;
	private String volume;
	private String journal;
	private String url;

	/**
	 * @return the authors
	 */

	public Article() {
		this.authors = new ArrayList<String>();
	}

	public List<String> getAuthors() {
		return this.authors;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the pages
	 */
	public String getPages() {
		return pages;
	}

	/**
	 * @param pages
	 *            the pages to set
	 */
	public void setPages(String pages) {
		this.pages = pages;
	}

	/**
	 * @return the year
	 */
	public long getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(long year) {
		this.year = year;
	}

	/**
	 * @return the volume
	 */
	public String getVolume() {
		return volume;
	}

	/**
	 * @param volume
	 *            the volume to set
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}

	/**
	 * @return the journal
	 */
	public String getJournal() {
		return journal;
	}

	/**
	 * @param journal
	 *            the journal to set
	 */
	public void setJournal(String journal) {
		this.journal = journal;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}