import org.annabelle.utils.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    @Test
    void testValidateISBN1() {
        String isbn = "123";
        boolean expected = false;
        boolean actual = Validation.validateISBN(isbn);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testValidateISBN2() {
        String isbn = "1234567890123";
        boolean expected = true;
        boolean actual = Validation.validateISBN(isbn);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testValidateISBN3() {
        String isbn = "fakeISBN";
        boolean expected = false;
        boolean actual = Validation.validateISBN(isbn);
        Assertions.assertEquals(expected, actual);
    }
}
