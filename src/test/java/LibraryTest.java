import org.annabelle.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LibraryTest {
    Library library = new Library();
    User user1 = new Student("0001", "student1");
    User user2 = new Student("0001", "bob");
    Item item1 = new Book("Harry Potter", "1234123412341", "J.K. Rowling", "fantasy");
    Item item2 = new Book("Java prog", "1275673412341", "Jane", "educational");
    Item item3 = new Book("Harry Potter 1", "1234123413333", "J.K. Rowling", "fantasy");
    Item item4 = new DVD("dvd1", "director1", 123);

    @Test
    @DisplayName("testing add user for key")
    void testAddUser1() {
        library.addUser(user1);
        Assertions.assertTrue(library.getUsers().containsKey("0001"));
    }

    @Test
    @DisplayName("testing add item for key")
    void testAddItem1() {
        library.addItem(item1);
        Assertions.assertTrue(library.getItems().containsKey(item1.getId()));
    }

    @Test
    @DisplayName("testing borrowing")
    void testBorrowItem1() {
        library.addUser(user1);
        library.addItem(item1);
        library.borrowItem(item1, user1);
        Assertions.assertEquals(Item.ItemStatus.BORROWED, item1.getStatus());
    }

    @Test
    @DisplayName("testing returning")
    void testReturnItem() {
        library.addUser(user1);
        library.addItem(item1);
        library.returnItem(item1, user1);
        Assertions.assertEquals(Item.ItemStatus.IN_STORE, item1.getStatus());
    }

    @Test
    @DisplayName("searching by title")
    void testSearchByTitle1() {
        library.addItem(item1);
        library.addItem(item2);
        library.addItem(item3);
        library.addItem(item4);
        List<Item> results = library.searchByTitle("Harry");
        Assertions.assertEquals(2, results.size());
    }

    @Test
    @DisplayName("searching by title")
    void testSearchByTitle2() {
        library.addItem(item1);
        library.addItem(item2);
        library.addItem(item3);
        library.addItem(item4);
        List<Item> results = library.searchByTitle("unknown");
        Assertions.assertTrue(results.isEmpty());
    }

    @Test
    @DisplayName("testing search by author")
    void textSearchByAuthor1() {
        library.addItem(item1);
        library.addItem(item2);
        library.addItem(item3);
        library.addItem(item4);
        List<Item> results = library.searchByAuthor("Jane");
        Assertions.assertEquals(1, results.size());
    }

    @Test
    @DisplayName("testing search by author")
    void textSearchByAuthor2() {
        library.addItem(item1);
        library.addItem(item2);
        library.addItem(item3);
        library.addItem(item4);
        List<Item> results = library.searchByTitle("unknown");
        Assertions.assertTrue(results.isEmpty());
    }

    @Test
    @DisplayName("test recursive search")
    void testSearchRecursive() {
        library.addItem(item1);
        library.addItem(item2);
        library.addItem(item3);
        library.addItem(item4);
        List<Item> itemList = new ArrayList<>(library.getItems().values());
        List<Item> result = new ArrayList<>();

        List<Item> actual = library.searchRecursive(itemList, result, "dvd1", 0);

        Assertions.assertEquals(1, actual.size());
    }

    @Test
    @DisplayName("testing search stream")
    void testSearchStream() {
        library.addItem(item1);
        library.addItem(item2);
        library.addItem(item3);
        library.addItem(item4);
        List<Item> results = library.searchStream("Java");
        Assertions.assertEquals(1, results.size());
    }
}
