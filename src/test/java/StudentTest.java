import org.annabelle.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentTest {
    Student student = new Student("Alice");
    Item book = new Book("Book1", "1234567890123", "author1", "fantasy");
    Item dvd = new DVD("dvd1", "director1", 123);

    @Test
    void testCanBorrow1() {
        boolean expected = true;
        boolean actual = student.canBorrow(book);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCanBorrow2() {
        boolean expected = false;
        boolean actual = student.canBorrow(dvd);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCanBorrow3() {
        for (int i = 0; i < 5; i++) {
            student.getBorrowedItems().add(new Book("book" + i, "0987654321234", "JK Rowling", "genre"));
        }
        boolean expected = false;
        boolean actual = student.canBorrow(book);
        Assertions.assertEquals(expected, actual);
    }
}
