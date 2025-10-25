package verification;

import org.testng.Assert;
import org.testng.annotations.Test;
public class Verification01 {
    // Topic is TestNg Assertion in this we perform verification
    @Test
    public void Test_Verify_01(){
        String ResponseName1= "Arpit";
        Assert.assertEquals("Arpit", "Arpit");
    }

}
