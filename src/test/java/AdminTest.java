import org.annabelle.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AdminTest {
    User admin = new Admin("0002", "admin");
    Item book = new Book("Book1", "1234567890123", "author1", "fantasy");
    Item dvd = new DVD("dvd1", "director1", 123);
    Item magazine = new Magazine("magazine1", "13", "publisher1");

    @Test
    @DisplayName("testing canBorrow")
    void testCanBorrow() {
        boolean expected = false;
        boolean actual = admin.canBorrow(book);
        Assertions.assertEquals(expected, actual);
    }
}
