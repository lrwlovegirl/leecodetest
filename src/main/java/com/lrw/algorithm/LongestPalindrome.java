package com.lrw.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长回文子串
 * 输入 ：aababaa
 *
 */
public class LongestPalindrome {
    /**
     *暴力破解方法
     * 找出字符串所有的子串，然后反转判断
     * 平均时间复杂度：O(n3)
     */
    public static String bruteForce(String str){
        if (null==str||str.trim().length()==0){
            return "";
        }
        if (str.length()==1){
            return str;
        }
        //定义集合，存储所有回文字符串子串
        List<String> list  = new ArrayList<>();
        int len = str.length();
        for (int x=0;x<len;x++){
            for (int y=len;y<=len&&x<=y;y--){
                String s = str.substring(x,y);
                if (s.length()>1&&s.equals(reverse(s))){
                    list.add(s);
                }else {
                    continue;
                }
            }
        }
        //找出一群回文中最长的
        int count = 0;
        int index =0;
        while (index<=list.size()){
            //比较获取最长的回文字符串
            if ((count+1)<list.size()&&list.get(index).length()<list.get(count+1).length()){
                     index=count+1;
            }
            count++;
            if (count>=list.size()){
                break;
            }
        }
        if (list.size()>0){
            return list.get(index);
        }




        //如果输入"ac",就返回a
        return String.valueOf(str.charAt(0));
    }

    /**
     * 反转字符串
     * @param s
     * @return
     */
    private  static  String  reverse(String s){
        StringBuffer stringBuffer = new StringBuffer(s);
        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        //System.out.println(bruteForce("abcdeffedxx"));
        long request = System.currentTimeMillis();
        System.out.println(bruteForce("lcnvoknqgejxbfhijmxglisfzjwbtvhodwummdqeggzfczmetrdnoetmcydwddmtubcqmdjwnpzdqcdhplxtezctvgnpobnnscrmeqkwgiedhzsvskrxwfyklynkplbgefjbyhlgmkkfpwngdkvwmbdskvagkcfsidrdgwgmnqjtdbtltzwxaokrvbxqqqhljszmefsyewwggylpugmdmemvcnlugipqdjnriythsanfdxpvbatsnatmlusspqizgknabhnqayeuzflkuysqyhfxojhfponsndytvjpbzlbfzjhmwoxcbwvhnvnzwmkhjxvuszgtqhctbqsxnasnhrusodeqmzrlcsrafghbqjpyklaaqximcjmpsxpzbyxqvpexytrhwhmrkuybtvqhwxdqhsnbecpfiudaqpzsvfaywvkhargputojdxonvlprzwvrjlmvqmrlftzbytqdusgeupuofhgonqoyffhmartpcbgybshllnjaapaixdbbljvjomdrrgfeqhwffcknmcqbhvulwiwmsxntropqzefwboozphjectnudtvzzlcmeruszqxvjgikcpfclnrayokxsqxpicfkvaerljmxchwcmxhtbwitsexfqowsflgzzeynuzhtzdaixhjtnielbablmckqzcccalpuyahwowqpcskjencokprybrpmpdnswslpunohafvminfolekdleusuaeiatdqsoatputmymqvxjqpikumgmxaxidlrlfmrhpkzmnxjtvdnopcgsiedvtfkltvplfcfflmwyqffktsmpezbxlnjegdlrcubwqvhxdammpkwkycrqtegepyxtohspeasrdtinjhbesilsvffnzznltsspjwuogdyzvanalohmzrywdwqqcukjceothydlgtocukc"));
        long response = System.currentTimeMillis();
        System.out.println((response-request));
    }
}
