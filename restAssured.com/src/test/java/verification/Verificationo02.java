package verification;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Verificationo02 {

    //TestNg Assertion
    @Test
    public void Test_Verify_02(){
        String ResponseName1= "Arpit";
        Assert.assertEquals(ResponseName1, "Arpit");
    }
    //Assert J Assertion
    @Test
    public void AssertJ_Verify(){
        String RespnseName2= "Arpit Mishra";
        assertThat(RespnseName2).isNotNull().isEqualTo("Arpit Mishra");

        //we can also verify list
        List<String> names = Arrays.asList("Arpit", "Mayank","Supriya");
        assertThat(names).hasSize(3).isNotNull();

        //This is how we veridy the dates
        LocalDate date= LocalDate.now();
        System.out.println(date);

        assertThat(date)
                .isAfterOrEqualTo(LocalDate.of(2021, 1, 1))
                .isBeforeOrEqualTo(LocalDate.of(2024, 12,31))
                .isBetween(
                        LocalDate.of(2023,1,1),
                        LocalDate.of(2024,12,31));
        //This is how you can read the file
        File file = new File("Testdata.json");
        assertThat(file).exists().isFile().canRead();

        //This other thing you can verify
        Map<String, Integer> ages= new HashMap<String, Integer>();
        ages.put("Arpit",25);
        ages.put("Aman", 25);
        assertThat(ages).hasSize(2).containsEntry("Arpit",25).doesNotContainValue(100);

//Note By using the Assert J you can use 100+ assertion to verify the response
    }
}
