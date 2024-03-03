package lesson21.homeWork21;

/**
 * AIT-TR, cohort 42.1, Java Basic, hm # 21
 * @author Andrey Hein
 * @version 03-Mar-2024
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RubberArrayTest {
    private int[] actual;
//    private int length;
    RubberArray array = new RubberArray();

    @Test
    public void testExtensionArray() {
        actual = new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        Assertions.assertArrayEquals(actual, array.extensionArray());
    }

    @Test
    public void testAdd() {
        actual = new int[] {5,1,2,0,0,0,0,0,-3,0};
        array.add(5);
        array.add(2);
        array.add(1,1);
        array.add(-3,8);
        Assertions.assertArrayEquals(actual,array.getDataArray());
    }

    @Test
    public void testRemove() {
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }
        actual = new int[] {0,1,2,3,4,5,6,7,8,9};
        Assertions.assertArrayEquals(actual, array.getDataArray());
        array.remove(2);
        actual = new int[] {0,1,3,4,5,6,7,8,9,9};
        Assertions.assertArrayEquals(actual, array.getDataArray());
        array.remove(5);
        actual = new int[] {0,1,3,4,5,7,8,9,9,9};
        Assertions.assertArrayEquals(actual, array.getDataArray());
    }

    @Test
    public void testIndexOf() {
        for (int i = 0; i < 10; i++) {
            array.add(i * 2);
        }
        actual = new int[] {0,2,4,6,8,10,12,14,16,18};
        Assertions.assertArrayEquals(actual, array.getDataArray());
        Assertions.assertEquals(7, array.indexOf(14));
        Assertions.assertEquals(-1, array.indexOf(9));
        // test method 'contains'
        Assertions.assertTrue(array.contains(10));
        Assertions.assertFalse(array.contains(17));
    }

    @Test
    public void testToString() {
        for (int i = 0; i < 5; i++) {
            array.add(i * 3);
        }
        Assertions.assertEquals("[0, 3, 6, 9, 12]",array.toString());
    }
}
