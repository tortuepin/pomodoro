package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by suzukikohei on 2016/01/21.
 */
public class StringUtil {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public String InputLine() throws IOException {
        //一行入力させてstrに保存
        String str;


        str = input.readLine();
        return str;
    }


    public int CheckNumber(String str){
        //数字なら数字。それ以外だったら0を返す。
        try {
            int a = Integer.parseInt(str);
            return a;
        } catch (NumberFormatException nfex) {
            return 0;
        }
    }
}
