import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: Yu Hao
 * DateTime: 2021-06-02 14:12
 */
public class Test {
    @org.junit.Test
    public void testTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy");
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
