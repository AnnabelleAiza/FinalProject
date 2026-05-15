import org.annabelle.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AdminTest {
    User admin = new Admin("admin");
    Item book = new Book("Book1", "1234567890123", "author1", "fantasy");

    @Test
    @DisplayName("testing canBorrow")
    void testCanBorrow() {
        boolean expected = false;
        boolean actual = admin.canBorrow(book);
        Assertions.assertEquals(expected, actual);
    }
}
