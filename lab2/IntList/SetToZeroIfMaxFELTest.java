package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SetToZeroIfMaxFELTest {

    @Test
    public void testZeroOutFELMaxes1() {
        IntList L = IntList.of(1, 22, 15);
        IntListExercises.setToZeroIfMaxFEL(L);
        assertEquals("0 -> 0 -> 15", L.toString());
    }

    @Test
    public void testZeroOutFELMaxes2() {
        IntList L = IntList.of(55, 22, 45, 44, 5);
        IntListExercises.setToZeroIfMaxFEL(L);
        assertEquals("0 -> 22 -> 45 -> 0 -> 0", L.toString());
    }

    @Test
    public void testZeroOutFELMaxes3() {
        IntList L = IntList.of(5, 535, 35, 11, 10, 0);
        IntListExercises.setToZeroIfMaxFEL(L);
        assertEquals("0 -> 0 -> 35 -> 0 -> 10 -> 0", L.toString());
    }

    @Test
    public void  testFirstDigitEqualsLastDigit(){
        assertFalse(IntListExercises.firstDigitEqualsLastDigit(10));
    }

    @Test
    public void  testFirstDigitEqualsLastDigit2(){
        assertTrue(IntListExercises.firstDigitEqualsLastDigit(535));
    }

    @Test
    public void  testFirstDigitEqualsLastDigit3(){
        assertTrue(IntListExercises.firstDigitEqualsLastDigit(101));
    }

    @Test
    public void  testMax(){
        IntList L = IntList.of(535, 565, 35, 11, 10, 565);
        assertEquals(IntListExercises.max(L), 565);
    }

    @Test
    public void  testMax2(){
        IntList L = IntList.of(1, 1, 1, 1, 1, 1);
        assertEquals(IntListExercises.max(L), 1);
    }

    @Test
    public void testZeroOutFELMaxes4() {
        IntList L = IntList.of();
        IntListExercises.setToZeroIfMaxFEL(L);
        assertNull(L);
    }
}
