import org.apache.log4j.Logger;

public class Calc {
    static Logger logger = Logger.getLogger(Calc.class);
    public static void main(String[] args) {
        logger.info("Hello, I'm calculator!");
	Maths maths = new Maths();
	logger.info("10.5 + 20.7 = " + maths.add(10.5,20.7));
	logger.info("10.5 - 20.7 = " + maths.subtract(10.5,20.7));
	logger.info("10.5 / 20.7 = " + maths.divide(10.5,20.7));
    }
}


