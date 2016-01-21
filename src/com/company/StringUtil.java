package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by suzukikohei on 2016/01/21.
 */
public class StringUtil {


    public String InputLine() throws IOException {
        //一行入力させてstrに保存
        String str;

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        str = input.readLine();
        return str;
    }

}
