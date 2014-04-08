package de.sven.utils.collections;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Tests the SubElementIterator.
 *
 * @author sven.bayer
 */
public class SubElementIteratorTest extends AbstractCollectionTest {

    @Test
    public void testTitleIteration() throws Exception {
        SubElementIterator<String> subElementIterator = getTitleSubElementIterator();
        for (int i = 0; i < TESTBOOK_COUNT; i++) {
            Assert.assertTrue(subElementIterator.hasNext());
            String title = subElementIterator.next();
            Assert.assertEquals(title, getTitle(i));
        }
    }

    @Test
    public void testAuthorIteration() throws Exception {
        SubElementIterator<String> subElementIterator = getAuthorSubElementIterator();
        for (int i = 0; i < TESTBOOK_COUNT; i++) {
            Assert.assertTrue(subElementIterator.hasNext());
            String author = subElementIterator.next();
            Assert.assertEquals(author, getAuthor(i));
        }
    }

    @Test
    public void testContentIteration() throws Exception {
        SubElementIterator<String> subElementIterator = getContentSubElementIterator();
        for (int i = 0; i < TESTBOOK_COUNT; i++) {
            Assert.assertTrue(subElementIterator.hasNext());
            String content = subElementIterator.next();
            Assert.assertEquals(content, getContent(i));
        }
    }

    @Test
    public void testPagesIteration() throws Exception {
        SubElementIterator<Integer> subElementIterator = getPagesSubElementIterator();
        for (int i = 0; i < TESTBOOK_COUNT; i++) {
            Assert.assertTrue(subElementIterator.hasNext());
            int pages = subElementIterator.next();
            Assert.assertEquals(pages, getPages(i));
        }
    }

    @Test
    public void testDateIteration() throws Exception {
        SubElementIterator<Date> subElementIterator = getPublicationSubElementIterator();
        for (int i = 0; i < TESTBOOK_COUNT; i++) {
            Assert.assertTrue(subElementIterator.hasNext());
            Date publication = subElementIterator.next();
            Assert.assertEquals(publication, getPublication(i));
        }
    }

    @Test
    public void testTitleRemove() throws Exception {
        SubElementIterator<String> subElementIterator = getTitleSubElementIterator();
        for (int i = 0; i < TESTBOOK_COUNT / 2; i++) {
            Assert.assertTrue(subElementIterator.hasNext());
            subElementIterator.next();
            subElementIterator.remove();
        }
    }

    @Test
    public void testAuthorRemove() throws Exception {
        SubElementIterator<String> subElementIterator = getAuthorSubElementIterator();
        for (int i = 0; i < TESTBOOK_COUNT / 2; i++) {
            Assert.assertTrue(subElementIterator.hasNext());
            subElementIterator.next();
            subElementIterator.remove();
        }
        Assert.assertFalse(subElementIterator.hasNext());
    }

    @Test
    public void testContentRemove() throws Exception {
        SubElementIterator<String> subElementIterator = getContentSubElementIterator();
        for (int i = 0; i < TESTBOOK_COUNT / 2; i++) {
            Assert.assertTrue(subElementIterator.hasNext());
            subElementIterator.next();
            subElementIterator.remove();
        }
        Assert.assertFalse(subElementIterator.hasNext());
    }

    @Test
    public void testPagesRemove() throws Exception {
        SubElementIterator<Integer> subElementIterator = getPagesSubElementIterator();
        for (int i = 0; i < TESTBOOK_COUNT / 2; i++) {
            Assert.assertTrue(subElementIterator.hasNext());
            subElementIterator.next();
            subElementIterator.remove();
        }
        Assert.assertFalse(subElementIterator.hasNext());
    }

    @Test
    public void testDateRemove() throws Exception {
        SubElementIterator<Date> subElementIterator = getPublicationSubElementIterator();
        for (int i = 0; i < TESTBOOK_COUNT / 2; i++) {
            Assert.assertTrue(subElementIterator.hasNext());
            subElementIterator.next();
            subElementIterator.remove();
        }
        Assert.assertFalse(subElementIterator.hasNext());
    }

    @Test
    public void testTitleRemoveEverySecond() throws Exception {
        SubElementIterator<String> subElementIterator = getTitleSubElementIterator();
        for (int i = 0; i < TESTBOOK_COUNT / 3; i++) {
            Assert.assertTrue(subElementIterator.hasNext());
            subElementIterator.next();
            Assert.assertTrue(subElementIterator.hasNext());
            subElementIterator.next();
            Assert.assertTrue(subElementIterator.hasNext());
            subElementIterator.remove();
        }
        Assert.assertTrue(subElementIterator.hasNext());
    }

    @Test
    public void testAuthorRemoveEverySecond() throws Exception {
        SubElementIterator<String> subElementIterator = getAuthorSubElementIterator();
        for (int i = 0; i < TESTBOOK_COUNT / 3; i++) {
            Assert.assertTrue(subElementIterator.hasNext());
            subElementIterator.next();
            Assert.assertTrue(subElementIterator.hasNext());
            subElementIterator.next();
            Assert.assertTrue(subElementIterator.hasNext());
            subElementIterator.remove();
        }
        Assert.assertTrue(subElementIterator.hasNext());
    }

    @Test
    public void testContentRemoveEverySecond() throws Exception {
        SubElementIterator<String> subElementIterator = getContentSubElementIterator();
        for (int i = 0; i < TESTBOOK_COUNT / 3; i++) {
            Assert.assertTrue(subElementIterator.hasNext());
            subElementIterator.next();
            Assert.assertTrue(subElementIterator.hasNext());
            subElementIterator.next();
            Assert.assertTrue(subElementIterator.hasNext());
            subElementIterator.remove();
        }
        Assert.assertTrue(subElementIterator.hasNext());
    }

    @Test
    public void testDateRemoveEverySecond() throws Exception {
        SubElementIterator<Date> subElementIterator = getPublicationSubElementIterator();
        for (int i = 0; i < TESTBOOK_COUNT / 3; i++) {
            Assert.assertTrue(subElementIterator.hasNext());
            subElementIterator.next();
            Assert.assertTrue(subElementIterator.hasNext());
            subElementIterator.next();
            Assert.assertTrue(subElementIterator.hasNext());
            subElementIterator.remove();
        }
        Assert.assertTrue(subElementIterator.hasNext());
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testTitleNoNextException() throws Exception {
        testNextException(getTitleSubElementIterator());
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testAuthorNoNextException() throws Exception {
        testNextException(getAuthorSubElementIterator());
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testContentNoNextException() throws Exception {
        testNextException(getContentSubElementIterator());
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testPagesNoNextException() throws Exception {
        testNextException(getPagesSubElementIterator());
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testPublicationNoNextException() throws Exception {
        testNextException(getPublicationSubElementIterator());
    }

    private void testNextException(SubElementIterator subElementIterator) throws IndexOutOfBoundsException {
        for (int i = 0; i < TESTBOOK_COUNT; i++) {
            subElementIterator.next();
        }
        subElementIterator.next();
    }

    private SubElementIterator<String> getTitleSubElementIterator() throws NoSuchMethodException {
        return new SubElementIterator<String>(testBooks, TestBook.class.getMethod("getTitle"));
    }

    private SubElementIterator<String> getAuthorSubElementIterator() throws NoSuchMethodException {
        return new SubElementIterator<String>(testBooks, TestBook.class.getMethod("getAuthor"));
    }

    private SubElementIterator<String> getContentSubElementIterator() throws NoSuchMethodException {
        return new SubElementIterator<String>(testBooks, TestBook.class.getMethod("getContent"));
    }

    private SubElementIterator<Integer> getPagesSubElementIterator() throws NoSuchMethodException {
        return new SubElementIterator<Integer>(testBooks, TestBook.class.getMethod("getPages"));
    }

    private SubElementIterator<Date> getPublicationSubElementIterator() throws NoSuchMethodException {
        return new SubElementIterator<Date>(testBooks, TestBook.class.getMethod("getPublication"));
    }
}
