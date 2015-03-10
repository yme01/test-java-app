import junit.framework.*;

public class CalcTest extends TestCase {
   protected int value1, value2;

   private Maths maths = new Maths();
   
   protected void setUp(){
      value1=3;
      value2=3;
   }

   public void testAdd(){
      assertTrue(maths.add(value1, value2) == 6);
   }

   public void testSubtract(){
      assertTrue(maths.subtract(value1, value2) == 0);
   }

   public void testMultiply(){
      assertTrue(maths.multiply(value1, value2) == 9);
   }

   public void testDivide(){
      assertTrue(maths.divide(value1, value2) == 1);
   }

   public void testPower(){
      assertTrue(maths.power(value1, value2) == 27);
   }
}
