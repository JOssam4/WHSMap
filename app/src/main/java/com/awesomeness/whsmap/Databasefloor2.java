package com.awesomeness.whsmap;
import java.util.HashMap;

/**
 * Created by James on 1/28/2016.
 */
public class Databasefloor2 {
    public static HashMap<Integer, int[]> elements = new HashMap<>();


    public static int[] room228 = {165, 288};
    public static int[] room227 = {170, 288};
    public static int[] room226 = {205, 288};
    public static int[] room229 = {165, 298};
    public static int[] room230 = {170, 298};
    public static int[] room231 = {205, 298};
    public static int[] room238 = {245, 326};
    public static int[] room239 = {245, 363};
    public static int[] room240 = {245, 369};
    public static int[] room241 = {255, 369};
    public static int[] room242 = {255, 362};
    public static int[] room243 = {255, 327};
    public static int[] room220 = {235, 245};
    public static int[] room219 = {235, 238};
    public static int[] room216 = {235, 200};
    public static int[] room215 = {235, 197};
    public static int[] room211 = {235, 160};
    public static int[] room210 = {235, 122};
    public static int[] room202 = {260, 133};
    public static int[] room207 = {250, 75};
    public static int[] room263 = {320, 279};
    public static int[] room262 = {327, 279};
    public static int[] room246 = {301, 290};
    public static int[] room247 = {369, 290};
    public static int[] room248 = {374, 290};
    public static int[] room250 = {415, 290};
    public static int[] room259 = {355, 280};
    public static int[] room258 = {388, 280};
    public static int[] room257 = {401, 280};
    public static int[] room254 = {440, 271};
    public static int[] room253 = {446, 270};
    public static int[] room252 = {250, 269};
    public static int[] room251 = {454, 270};


    public static void putInBase(){
        elements.put(228, room228);
        elements.put(229, room229);
        elements.put(220, room220);
        elements.put(216, room216);
        elements.put(219, room219);
        elements.put(215, room215);
        elements.put(243, room243);
        elements.put(242, room242);
        elements.put(241, room241);
        elements.put(227, room227);
        elements.put(226, room226);
        elements.put(230, room230);
        elements.put(231, room231);
        elements.put(238, room238);
        elements.put(239, room239);
        elements.put(240, room240);
        elements.put(211, room211);
        elements.put(210, room210);
        elements.put(202, room202);
        elements.put(207, room207);
        elements.put(263, room263);
        elements.put(262, room262);
        elements.put(246, room246);
        elements.put(247, room247);
        elements.put(248, room248);
        elements.put(250, room250);
        elements.put(259, room259);
        elements.put(258, room258);
        elements.put(257, room257);
        elements.put(254, room254);
        elements.put(253, room253);
        elements.put(252, room252);
        elements.put(251, room251);
    }

    public static boolean doesExist(int roomNum){
        return elements.containsKey(roomNum);
    }
}
