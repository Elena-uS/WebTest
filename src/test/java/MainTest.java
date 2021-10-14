import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest {

    @Test

    void  testGetSum(){

        int result;
        result=Main.getSum(10,10);

        Assert.assertEquals(result,20);

        result = Main.getSum(0,0);
        Assert.assertEquals(result,0);


        result=Main.getSum(-10,-10);
        Assert.assertEquals(result,-20);



        result=Main.getSum(-10,10);
        Assert.assertEquals(result,0);

    }


}



