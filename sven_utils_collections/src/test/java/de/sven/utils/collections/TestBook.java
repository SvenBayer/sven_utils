package de.sven.utils.collections;

import java.util.Date;

/**
 * Test class for collections.
 *
 * @author sven.bayer
 */
public class TestBook {
    private String title;
    private String author;
    private String content;
    private Date publication;

    private int pages;

    public TestBook(String title, String author, String content, int pages, Date publication) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.pages = pages;
        this.publication = publication;
    }

    public Date getPublication() {
        return publication;
    }

    public void setPublication(Date publication) {
        this.publication = publication;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}