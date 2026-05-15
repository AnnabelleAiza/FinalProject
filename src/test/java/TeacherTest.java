import org.annabelle.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TeacherTest {
    User teacher = new Teacher("0001", "Yi");
    Item book = new Book("Book1", "1234567890123", "author1", "fantasy");
    Item dvd = new DVD("dvd1", "director1", 123);

    @Test
    @DisplayName("testing can borrow by type of item")
    void testCanBorrow1() {
        boolean expected = true;
        boolean actual = teacher.canBorrow(dvd);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("testing  can borrow by limit")
    void testCanBorrow2() {
        for (int i = 0; i < 10; i++) {
            teacher.getBorrowedItems().add(new Book("book" + i, "0987654321234", "JK Rowling", "genre"));
        }
        boolean expected = false;
        boolean actual = teacher.canBorrow(book);
        Assertions.assertEquals(expected, actual);
    }
}
