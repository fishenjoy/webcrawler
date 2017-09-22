package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zzy on 2017/9/15.
 */
public class StringUtil {
    //获取一串字符串中整数字段或小数字段
    public static  String getPriceString(String inputString){
        String outputString ="";
        if(isNullOrBlank(inputString)){
            return "";
        }
        String regex="(\\d+(\\.\\d+)?)";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(inputString);
        if(matcher.find()) {
            outputString = matcher.group();
        }
        return outputString;
    }

    public static boolean isNullOrBlank(String str){
        if(str==null){
            return true;
        }else if(str.trim().isEmpty()){
            return true;
        }
        return false;
    }
}
