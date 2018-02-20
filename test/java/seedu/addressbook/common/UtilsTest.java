package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;

public class UtilsTest {


    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    @Test
    public void elementsAreNotNull() {
        //empty list
        assertNoneNull();

        //single null object
        assertSomeNull((Object) null);

        //single not null object
        assertNoneNull("abc");
        assertNoneNull(new String());
        assertNoneNull(123);

        //multiple null objects
        assertSomeNull(null, null);
        assertSomeNull(null, null, null, null);

        //multiple non null objects
        assertNoneNull("123", 123, "abc");
        assertNoneNull(new Integer(1), new String());

        //some null objects and some non null objects
        assertSomeNull(null, null, 123);
        assertSomeNull(123, null, 123);
        assertSomeNull(123, "abc", new Integer(3), null);
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertSomeNull(Object... objects) { assertTrue(Utils.isAnyNull(objects)); }

    private void assertNoneNull(Object... objects) { assertFalse(Utils.isAnyNull(objects)); }
}
