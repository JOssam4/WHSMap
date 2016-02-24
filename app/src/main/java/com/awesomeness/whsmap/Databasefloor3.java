package com.awesomeness.whsmap;

import java.util.HashMap;

/**
 * Created by James on 2/12/2016.
 */
    public class Databasefloor3 {

    public static HashMap<Integer, int[]> elements = new HashMap<>();
    public static HashMap<String, int[]> stairs =  new HashMap<>();

    public static int[] room319 = {168, 305};
    public static int[] room318 = {168, 295};
    public static int[] room320 = {175, 304};
    public static int[] room317 = {175, 295};
    public static int[] room316 = {211, 295};
    public static int[] room321 = {211, 305};
    public static int[] room328 = {249, 334};
    public static int[] room334 = {259, 334};
    public static int[] room330 = {249, 371};
    public static int[] room333 = {260, 369};
    public static int[] room331 = {250, 379};
    public static int[] room332 = {260, 369};
    public static int[] room358 = {289, 286};
    public static int[] room357 = {324, 286};
    public static int[] room356 = {344, 286};
    public static int[] room353 = {365, 286};
    public static int[] room352 = {381, 286};
    public static int[] room337 = {307, 295};
    public static int[] room338 = {348, 295};
    public static int[] room339 = {379, 295};
    public static int[] room341 = {421, 295};
    public static int[] room342 = {434, 262};
    public static int[] room348 = {425, 262};
    public static int[] room343 = {438, 238};
    public static int[] room345 = {438, 224};
    public static int[] room346 = {425, 210};
    public static int[] room347 = {425, 216};
    public static int[] room360 = {272, 269};
    public static int[] room310 = {240, 250};
    public static int[] room309 = {240, 245};
    public static int[] room306 = {240, 208};
    public static int[] room305 = {240, 201};
    public static int[] room301 = {240, 165};

    public static int[] mainStair = {293, 296};
    public static int[] LStair = {144, 299};
    public static int[] BStair = {252, 400};
    public static int[] TStair = {243,156};
    public static int[] RStair = {456,290};
    public static int[] AWStair = {431, 194}; //art wing stair

    public static void putInBase(){
        elements.put(319, room319);
        elements.put(320, room320);
        elements.put(321, room321);
        elements.put(328, room328);
        elements.put(318, room318);
        elements.put(317, room317);
        elements.put(316, room316);
        elements.put(310, room310);
        elements.put(334, room334);
        elements.put(330, room330);
        elements.put(328, room328);
        elements.put(333, room333);
        elements.put(331, room331);
        elements.put(332, room332);
        elements.put(358, room358);
        elements.put(357, room357);
        elements.put(356, room356);
        elements.put(353, room353);
        elements.put(352, room352);
        elements.put(337, room337);
        elements.put(338, room338);
        elements.put(339, room339);
        elements.put(341, room341);
        elements.put(342, room342);
        elements.put(348, room348);
        elements.put(343, room343);
        elements.put(345, room345);
        elements.put(346, room346);
        elements.put(347, room347);
        elements.put(360, room360);
        elements.put(309, room309);
        elements.put(306, room306);
        elements.put(305, room305);
        elements.put(301, room301);

        stairs.put("Main", mainStair);
        stairs.put("LStair", LStair);
        stairs.put("BStair", BStair);
        stairs.put("RStair", RStair);
        stairs.put("TStair", TStair);
        stairs.put("AWStair", AWStair);
    }

    public static boolean doesExist(int roomNum){
        return elements.containsKey(roomNum);
    }

}
