package com.awesomeness.whsmap;

import java.util.HashMap;

/**
 * Created by James on 2/12/2016.
 */
public class Databasefloor4 {
    public static int[] room418 = {167, 296};
    public static int[] room417 = {172, 296};
    public static int[] room416 = {209, 296};
    public static int[] room419 = {167, 304};
    public static int[] room420 = {172, 303};
    public static int[] room421 = {209, 304};
    public static int[] room428 = {249, 332};
    public static int[] room429 = {249, 369};
    public static int[] room430 = {278, 375};
    public static int[] room431 = {257, 375};
    public static int[] room432 = {257, 370};
    public static int[] room433 = {257, 332};
    public static int[] room450 = {325, 286};
    public static int[] room451 = {320, 286};
    public static int[] room452 = {304, 286};
    public static int[] room441 = {446, 286};
    public static int[] room442 = {441, 286};
    public static int[] room443 = {404, 286};
    public static int[] room444 = {391, 286};
    public static int[] room447 = {376, 286};
    public static int[] room448 = {353, 286};
    public static int[] room440 = {420, 295};
    public static int[] room438 = {380, 295};
    public static int[] room437 = {348, 295};
    public static int[] room436 = {305, 295};
    public static int[] room401 = {239, 165};
    public static int[] room405 = {239, 200};
    public static int[] room406 = {239, 207};
    public static int[] room409 = {239, 244};
    public static int[] room410 = {239, 250};

    public static int[] mainStair = {292, 295};
    public static int[] LStair = {142,294};
    public static int[] BStair = {247,400};
    public static int[] RStair = {455,297};
    public static int[] TStair = {242,157};

    public static HashMap<Integer, int[]>elements = new HashMap<>();
    public static HashMap<String, int[]> stairs = new HashMap<>();

public static void putInBase(){
    elements.put(418, room418);
    elements.put(417, room417);
    elements.put(416, room416);
    elements.put(419, room419);
    elements.put(420, room420);
    elements.put(421, room421);
    elements.put(428, room428);
    elements.put(429, room429);
    elements.put(430, room430);
    elements.put(431, room431);
    elements.put(432, room432);
    elements.put(433, room433);
    elements.put(450, room450);
    elements.put(451, room451);
    elements.put(452, room452);
    elements.put(441, room441);
    elements.put(442, room442);
    elements.put(443, room443);
    elements.put(444, room444);
    elements.put(447, room447);
    elements.put(448, room448);
    elements.put(440, room440);
    elements.put(438, room438);
    elements.put(437, room437);
    elements.put(436, room436);
    elements.put(401, room401);
    elements.put(405, room405);
    elements.put(406, room406);
    elements.put(409, room409);
    elements.put(410, room410);

    stairs.put("Main", mainStair);
    stairs.put("LStair", LStair);
    stairs.put("BStair", BStair);
    stairs.put("RStair", RStair);
    stairs.put("TStair", TStair);
}

public static boolean doesExist(int roomnum){
    return elements.containsKey(roomnum);
}

}
