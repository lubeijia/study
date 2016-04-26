package com.wy.regex;
import java.util.regex.Pattern;

/**
 * 
 */

/**
 * @author wuyong 
* @date 2016年4月7日 下午3:37:38 
*/
/**
 * @author wuyong
 *
 */
public class TestRegex {

    /**
     * @param args
     * @author wuyong
     */
    public static void main(String[] args) {
        TestRegex testRegex = new TestRegex();
        String car = "鲁A12345";
        System.err.println(Pattern.matches("^鲁V{1}[\\S]*73{1}[\\S]?", "鲁V97318"));
        System.out.println(Pattern.compile("^鲁V{1}[\\S]*73{1}[\\S]?",Pattern.CASE_INSENSITIVE).matcher("鲁V97318").find());
        System.out.println(car);
        String[] inputs = { "*12345", "?A12345", "鲁A123*", "鲁A1234?", "鲁A*3?5", "鲁A?2*5", "*A1234?", "?A123*", "?A*?*3*", "?", "*", "?abc", "abc*",
                "abc?", "abc*c?d", "abc?d*e", "abc*bc", "abc?dd", "abc*cd?", "abc?cd*" };
        for (String input : inputs) {
            System.out.println("input:" + input + "\treg:" + testRegex.getRegex(input) + "\t" + Pattern.matches(testRegex.getRegex(input), car));
        }
    }


    /**
     * 将非标准正则表达式转换为标准正则表达式．
     * 将“鲁A*3?5”转换为“^鲁A{1}[\S]*3{1}[\S]?5{1}$”
     * @param unFormatRegex
     *            非标准正则表达式
     * @return 标准正则表达式
     * @author wuyong
     */
    public String getRegex(String unFormatRegex) {
        // 模糊匹配
        String regex = unFormatRegex;
        if (unFormatRegex.indexOf("*") != 0 && unFormatRegex.indexOf("?") != 0) {
            regex = "^" + regex;
        }
        if (unFormatRegex.lastIndexOf("*") != (unFormatRegex.length() - 1) && unFormatRegex.lastIndexOf("?") != (unFormatRegex.length() - 1)) {
            regex = regex + "{1}$";
        }
        regex = regex.replace("*", "{1}[\\S]*");
        regex = regex.replace("?", "{1}[\\S]?");
        if (regex.indexOf("{1}") == 0) {
            regex = regex.substring(3, regex.length());
        }
        return regex;
    }

}
