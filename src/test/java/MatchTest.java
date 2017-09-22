import java.util.regex.Pattern;

/**
 * 测试正则表达式
 * Created by zzy on 2017/9/22.
 */
public class MatchTest {
    public static final String URL_LIST = "http://www\\.niuza\\.com\\/index(\\d+||^$)\\.html";
    public static void main(String[] args){
        String str1="http://www.niuza.com/index2.html";
        String str2="http://www.niuza.com/index4555.html";
        String str3="http://www.niuza.com/index.html";
        String str4="http://www.niuza.com/indexmama.html";
        String str5="http://www.niuza.com/inde.html";

        Pattern pattern=Pattern.compile(URL_LIST);
        System.out.println(pattern.matcher(str1).find());
        System.out.println(pattern.matcher(str2).find());
        System.out.println(pattern.matcher(str3).find());
        System.out.println(pattern.matcher(str4).find());
        System.out.println(pattern.matcher(str5).find());





    }
}
