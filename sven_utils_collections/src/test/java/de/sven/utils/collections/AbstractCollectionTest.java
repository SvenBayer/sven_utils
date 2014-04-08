package de.sven.utils.collections;

import org.testng.annotations.BeforeMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Abstract collection test class.
 *
 * @author sven.bayer
 */
public class AbstractCollectionTest {

    /**
     * Count has to be even for testing!
     */
    protected static final int TESTBOOK_COUNT = 10;
    protected List<TestBook> testBooks;
    protected List<Date> dates;

    @BeforeMethod
    public void generateTestData() throws ParseException {
        testBooks = new ArrayList<TestBook>();
        dates = new ArrayList<Date>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd");
        for (int i = 0; i < TESTBOOK_COUNT; i++) {
            dates.add(simpleDateFormat.parse("2013-" + i % 13 + "-" + i % 29));
            TestBook testBook = new TestBook(getTitle(i), getAuthor(i), getContent(i), getPages(i), getPublication(i));
            testBooks.add(testBook);
        }
    }

    protected String getTitle(int i) {
        return "Title" + i;
    }

    protected String getAuthor(int i) {
        return "Author" + i;
    }

    protected String getContent(int i) {
        return "Content" + i;
    }

    protected int getPages(int i) {
        return i * TESTBOOK_COUNT - TESTBOOK_COUNT;
    }

    protected Date getPublication(int i) {
        return dates.get(i);
    }
}