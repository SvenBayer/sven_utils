package de.sven.utils.collections;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Tests the SubElementList.
 *
 * @author sven.bayer
 */
public class SubElementListTest extends AbstractCollectionTest {

    @Test
    public void testConstructorForTitle() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getTitle"));
        for(int i = 0; i < TESTBOOK_COUNT; i++){
            String element = subElementList.get(i);
            Assert.assertEquals(element, getTitle(i));
        }
    }

    @Test
    public void testConstructorForAuthor() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getAuthor"));
        for(int i = 0; i < TESTBOOK_COUNT; i++){
            String element = subElementList.get(i);
            Assert.assertEquals(element, getAuthor(i));
        }
    }

    @Test
    public void testConstructorForContent() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getContent"));
        for(int i = 0; i < TESTBOOK_COUNT; i++){
            String element = subElementList.get(i);
            Assert.assertEquals(element, getContent(i));
        }
    }

    @Test
    public void testConstructorForPages() throws Exception {
        SubElementList<Integer> subElementList = new SubElementList<Integer>(testBooks, TestBook.class.getMethod("getPages"));
        for(int i = 0; i < TESTBOOK_COUNT; i++){
            int element = subElementList.get(i);
            Assert.assertEquals(element, getPages(i));
        }
    }

    @Test
    public void testConstructorForPublication() throws Exception {
        SubElementList<Date> subElementList = new SubElementList<Date>(testBooks, TestBook.class.getMethod("getPublication"));
        for(int i = 0; i < TESTBOOK_COUNT; i++){
            Date element = subElementList.get(i);
            Assert.assertEquals(element, getPublication(i));
        }
    }

    @Test
    public void testTitleToStringArray() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getTitle"));
        String[] subElementsArray = subElementList.toArray(new String[subElementList.size()]);
        testToArrayWithParameter(subElementList, subElementsArray);
    }

    @Test
    public void testAuthorToStringArray() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getAuthor"));
        String[] subElementsArray = subElementList.toArray(new String[subElementList.size()]);
        testToArrayWithParameter(subElementList, subElementsArray);
    }

    @Test
    public void testContentToStringArray() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getContent"));
        String[] subElementsArray = subElementList.toArray(new String[subElementList.size()]);
        testToArrayWithParameter(subElementList, subElementsArray);
    }

    @Test
    public void testPublicationToStringArray() throws Exception {
        SubElementList<Date> subElementList = new SubElementList<Date>(testBooks, TestBook.class.getMethod("getPublication"));
        Date[] subElementsArray = subElementList.toArray(new Date[subElementList.size()]);
        testToArrayWithParameter(subElementList, subElementsArray);
    }

    @Test
    public void testPagesToStringArray() throws Exception {
        SubElementList<Integer> subElementList = new SubElementList<Integer>(testBooks, TestBook.class.getMethod("getPages"));
        Integer[] subElementsArray = subElementList.toArray(new Integer[subElementList.size()]);
        testToArrayWithParameter(subElementList, subElementsArray);
    }

    @Test
    public void testTitleContainsRemoveAllEmpty() throws Exception {
        SubElementList<String> subElementList1 = new SubElementList<String>(testBooks, TestBook.class.getMethod("getTitle"));
        testContainsRemoveAllEmpty(subElementList1);
    }

    @Test
    public void testAuthorContainsRemoveAllEmpty() throws Exception {
        SubElementList<String> subElementList1 = new SubElementList<String>(testBooks, TestBook.class.getMethod("getAuthor"));
        testContainsRemoveAllEmpty(subElementList1);
    }

    @Test
    public void testContentContainsRemoveAllEmpty() throws Exception {
        SubElementList<String> subElementList1 = new SubElementList<String>(testBooks, TestBook.class.getMethod("getContent"));
        testContainsRemoveAllEmpty(subElementList1);
    }

    @Test
    public void testPagesContainsRemoveAllEmpty() throws Exception {
        SubElementList<String> subElementList1 = new SubElementList<String>(testBooks, TestBook.class.getMethod("getPages"));
        testContainsRemoveAllEmpty(subElementList1);
    }

    @Test
    public void testPublicationContainsRemoveAllEmpty() throws Exception {
        SubElementList<String> subElementList1 = new SubElementList<String>(testBooks, TestBook.class.getMethod("getPublication"));
        testContainsRemoveAllEmpty(subElementList1);
    }

    @Test
     public void testTitleRemoveElements()  throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getTitle"));
        testRemoveElements(subElementList);
    }

    @Test
    public void testAuthorRemoveElements()  throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getAuthor"));
        testRemoveElements(subElementList);
    }

    @Test
    public void testContentRemoveElements()  throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getContent"));
        testRemoveElements(subElementList);
    }

    @Test
    public void testPagesRemoveElements()  throws Exception {
        SubElementList<Integer> subElementList = new SubElementList<Integer>(testBooks, TestBook.class.getMethod("getPages"));
        testRemoveElements(subElementList);
    }

    @Test
    public void testPublicationRemoveElements()  throws Exception {
        SubElementList<Date> subElementList = new SubElementList<Date>(testBooks, TestBook.class.getMethod("getPublication"));
        testRemoveElements(subElementList);
    }

    @Test
    public void testTitleParentList() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getTitle"));
        testParentList(subElementList);
    }

    @Test
    public void testAuthorParentList() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getAuthor"));
        testParentList(subElementList);
    }

    @Test
    public void testContentParentList() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getContent"));
        testParentList(subElementList);
    }

    @Test
    public void testPagesParentList() throws Exception {
        SubElementList<Integer> subElementList = new SubElementList<Integer>(testBooks, TestBook.class.getMethod("getPages"));
        testParentList(subElementList);
    }

    @Test
    public void testPublicationParentList() throws Exception {
        SubElementList<Date> subElementList = new SubElementList<Date>(testBooks, TestBook.class.getMethod("getPublication"));
        testParentList(subElementList);
    }

    @Test
    public void testTitleSubList() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getTitle"));
        testSubList(subElementList);
    }

    @Test
    public void testAuthorSubList() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getAuthor"));
        testSubList(subElementList);
    }

    @Test
    public void testContentSubList() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getContent"));
        testSubList(subElementList);
    }

    @Test
    public void testPagesSubList() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getPages"));
        testSubList(subElementList);
    }

    @Test
    public void testPublicationSubList() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getPublication"));
        testSubList(subElementList);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testTitleToArray() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getTitle"));
        subElementList.toArray();
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testAuthorToArray() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getAuthor"));
        subElementList.toArray();
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testContentToArray() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getContent"));
        subElementList.toArray();
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testPagesToArray() throws Exception {
        SubElementList<Integer> subElementList = new SubElementList<Integer>(testBooks, TestBook.class.getMethod("getPages"));
        subElementList.toArray();
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testPublicationToArray() throws Exception {
        SubElementList<Date> subElementList = new SubElementList<Date>(testBooks, TestBook.class.getMethod("getPublication"));
        subElementList.toArray();
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testTitleAdd() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getTitle"));
        subElementList.add(new String());
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testAuthorAdd() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getAuthor"));
        subElementList.add(new String());
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testContentAdd() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getContent"));
        subElementList.add(new String());
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testPagesAdd() throws Exception {
        SubElementList<Integer> subElementList = new SubElementList<Integer>(testBooks, TestBook.class.getMethod("getPages"));
        subElementList.add(new Integer(0));
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testPublicationAdd() throws Exception {
        SubElementList<Date> subElementList = new SubElementList<Date>(testBooks, TestBook.class.getMethod("getPublication"));
        subElementList.add(new Date());
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testTitleSet() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getTitle"));
        subElementList.set(0, new String());
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testAuthorSet() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getAuthor"));
        subElementList.set(0, new String());
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testContentSet() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getContent"));
        subElementList.set(0, new String());
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testPagesSet() throws Exception {
        SubElementList<Integer> subElementList = new SubElementList<Integer>(testBooks, TestBook.class.getMethod("getPages"));
        subElementList.set(0, new Integer(0));
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testPublicationSet() throws Exception {
        SubElementList<Date> subElementList = new SubElementList<Date>(testBooks, TestBook.class.getMethod("getPublication"));
        subElementList.set(0, new Date());
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testTitleAddAt() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getTitle"));
        subElementList.add(0, new String());
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testAuthorAddAt() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getAuthor"));
        subElementList.add(0, new String());
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testContentAddAt() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getContent"));
        subElementList.add(0, new String());
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testPagesAddAt() throws Exception {
        SubElementList<Integer> subElementList = new SubElementList<Integer>(testBooks, TestBook.class.getMethod("getPages"));
        subElementList.add(0, new Integer(0));
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testPublicationAddAt() throws Exception {
        SubElementList<Date> subElementList = new SubElementList<Date>(testBooks, TestBook.class.getMethod("getPublication"));
        subElementList.add(0, new Date());
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testTitleListIterator() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getTitle"));
        subElementList.listIterator();
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testAuthorListIterator() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getAuthor"));
        subElementList.listIterator();
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testContentListIterator() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getContent"));
        subElementList.listIterator();
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testPagesListIterator() throws Exception {
        SubElementList<Integer> subElementList = new SubElementList<Integer>(testBooks, TestBook.class.getMethod("getPages"));
        subElementList.listIterator();
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testPublicationListIterator() throws Exception {
        SubElementList<Date> subElementList = new SubElementList<Date>(testBooks, TestBook.class.getMethod("getPublication"));
        subElementList.listIterator();
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testTitleListIteratorAt() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getTitle"));
        subElementList.listIterator(0);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testAuthorListIteratorAt() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getAuthor"));
        subElementList.listIterator(0);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testContentListIteratorAt() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getContent"));
        subElementList.listIterator(0);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testPagesListIteratorAt() throws Exception {
        SubElementList<Integer> subElementList = new SubElementList<Integer>(testBooks, TestBook.class.getMethod("getPages"));
        subElementList.listIterator(0);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testPublicationListIteratorAt() throws Exception {
        SubElementList<Date> subElementList = new SubElementList<Date>(testBooks, TestBook.class.getMethod("getPublication"));
        subElementList.listIterator(0);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testTitleAddAll() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getTitle"));
        subElementList.addAll(subElementList);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testAuthorAddAll() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getAuthor"));
        subElementList.addAll(subElementList);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testContentAddAll() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getContent"));
        subElementList.addAll(subElementList);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testPagesAddAll() throws Exception {
        SubElementList<Integer> subElementList = new SubElementList<Integer>(testBooks, TestBook.class.getMethod("getPages"));
        subElementList.addAll(subElementList);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testPublicationAddAll() throws Exception {
        SubElementList<Date> subElementList = new SubElementList<Date>(testBooks, TestBook.class.getMethod("getPublication"));
        subElementList.addAll(subElementList);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testTitleAddAllAt() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getTitle"));
        subElementList.addAll(0, subElementList);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testAuthorAddAllAt() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getAuthor"));
        subElementList.addAll(0, subElementList);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testContentAddAllAt() throws Exception {
        SubElementList<String> subElementList = new SubElementList<String>(testBooks, TestBook.class.getMethod("getContent"));
        subElementList.addAll(0, subElementList);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testPagesAddAllAt() throws Exception {
        SubElementList<Integer> subElementList = new SubElementList<Integer>(testBooks, TestBook.class.getMethod("getPages"));
        subElementList.addAll(0, subElementList);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testPublicationAddAllAt() throws Exception {
        SubElementList<Date> subElementList = new SubElementList<Date>(testBooks, TestBook.class.getMethod("getPublication"));
        subElementList.addAll(0, subElementList);
    }

    private <T> void testSubList(SubElementList<T> subElementList) {
        SubElementList<T> subSubElementList = (SubElementList<T>) subElementList.subList(1, 9);
        Assert.assertEquals(subSubElementList.size(), 8);
    }

    private void testParentList(SubElementList subElementList) throws Exception {
        List<TestBook> parentList = subElementList.getParentList();
        Assert.assertEquals(parentList, testBooks);
        Assert.assertTrue(parentList.equals(testBooks));
        parentList.remove(0);
        Assert.assertNotEquals(parentList, testBooks);
        Assert.assertFalse(parentList.equals(testBooks));
    }

    private void testRemoveElements(SubElementList subElementList) throws Exception {
        int oldSize = subElementList.size();
        for (int i = 0; i < subElementList.size(); i++) {
            subElementList.remove(i);
            Assert.assertTrue(oldSize > subElementList.size());
        }
        oldSize = subElementList.size();
        for (int i = subElementList.size() - 1; i >= 0; i--) {
            subElementList.remove(i);
            Assert.assertTrue(oldSize > subElementList.size());
        }
        Assert.assertEquals(subElementList.size(), 0);
        Assert.assertTrue(subElementList.isEmpty());
        Assert.assertFalse(subElementList.remove(new String()));
    }

    private <T> void testContainsRemoveAllEmpty(SubElementList<T> subElementList1) throws Exception {
        SubElementList<T> subElementList2 = subElementList1.clone();
        Assert.assertTrue(subElementList1.containsAll(subElementList2));
        Assert.assertEquals(subElementList1.indexOf(null), -1);
        Assert.assertEquals(subElementList1.lastIndexOf(null), -1);
        Assert.assertEquals(subElementList1.indexOf(subElementList2.get(0)), 0);
        Assert.assertEquals(subElementList1.lastIndexOf(subElementList2.get(0)), 0);
        Assert.assertEquals(subElementList1.hashCode(), subElementList2.hashCode());
        Assert.assertEquals(subElementList1.size(), subElementList2.size());
        Assert.assertTrue(subElementList1.equals(subElementList2));
        Assert.assertTrue(subElementList1.equals(subElementList1));
        Assert.assertFalse(subElementList1.equals(new String()));

        Assert.assertFalse(subElementList1.isEmpty());
        Assert.assertTrue(subElementList1.removeAll(subElementList2));
        Assert.assertFalse(subElementList1.removeAll(subElementList2));
        Assert.assertTrue(subElementList1.size() == 0);
        Assert.assertTrue(subElementList1.isEmpty());
        Assert.assertFalse(subElementList1.containsAll(subElementList2));
        Assert.assertTrue(subElementList2.containsAll(subElementList1));
        Assert.assertFalse(subElementList1.retainAll(subElementList2));

        subElementList1 = subElementList2.clone();
        Assert.assertTrue(subElementList1.size() > 0);
        Assert.assertTrue(subElementList1.size() == subElementList2.size());
        Assert.assertEquals(subElementList1.indexOf(null), -1);
        Assert.assertEquals(subElementList1.lastIndexOf(null), -1);

        Assert.assertTrue(subElementList1.retainAll(subElementList2));
        subElementList1.clear();
        subElementList2.clear();
        Assert.assertEquals(subElementList1.size(), 0);
        Assert.assertEquals(subElementList2.size(), 0);
        Assert.assertEquals(subElementList1.size(), subElementList2.size());
        Assert.assertTrue(subElementList1.equals(subElementList2));
        Assert.assertEquals(subElementList1.hashCode(), subElementList2.hashCode());
    }

    private <T> void testToArrayWithParameter(SubElementList<T> subElementList, T[] subElementsArray){
        for(int i = 0; i < TESTBOOK_COUNT; i++){
            Assert.assertEquals(subElementsArray[i], subElementList.get(i));
        }
    }
}