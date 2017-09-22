import utils.StringUtil;

/**
 * Created by zzy on 2017/9/15.
 */
public class StringUtilTest {
    public static void main(String[] args){
        /*System.out.println(StringUtil.getPriceString("hahh1.2"));
        System.out.println(StringUtil.getPriceString("hahh1.2a"));
        System.out.println(StringUtil.getPriceString("hahh1.2妈呀"));
        System.out.println(StringUtil.getPriceString("hahh1.2妈呀2"));*/


        System.out.println(StringUtil.isNullOrBlank("hahh1.2妈呀2"));
        System.out.println(StringUtil.isNullOrBlank(""));
        System.out.println(StringUtil.isNullOrBlank("   "));

    }
}
