package com.awesomeness.whsmap;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by James on 1/5/2016.
 */
public class Databasefloor1 {

    public static int[] room135 = {220, 312};
    public static int[] room136 = {180, 310};
    public static int[] room137 = {176, 311};
    public static int[] room138 = {175, 323};
    public static int[] room139 = {182, 322};
    public static int[] room140 = {220, 321};
    public static int[] room152 = {270, 324};
    public static int[] room151 = {271, 330};
    public static int[] room150 = {269, 368};
    public static int[] room149 = {269, 396};
    public static int[] room148 = {259, 398};
    public static int[] room147 = {260, 391};
    public static int[] room146 = {259, 352};
    public static int[] room154 = {347, 313};
    public static int[] room155 = {352, 312};
    public static int[] room156 = {388, 317};
    public static int[] room157 = {395, 318};
    public static int[] room158 = {402, 317};
    public static int[] room159 = {439, 312};
    public static int[] room160 = {465, 311};
    public static int[] room161 = {454, 290};
    public static int[] room162 = {455, 268};
    public static int[] room163 = {454, 240};
    public static int[] room164 = {446, 239};
    public static int[] room165 = {447, 268};
    public static int[] room108 = {257, 39};
    public static int[] room111 = {231, 38};
    public static int[] room112 = {207, 40};
    public static int[] room116 = {177, 82};
    public static int[] room117 = {169, 80};
    public static int[] room120 = {169, 90};
    public static int[] room121 = {177, 90};
    public static int[] room176 = {349, 305};
    public static int[] room174 = {366, 305};
    public static int[] rooms120121 = {179, 90};
    public static int[] rooms116117 = {169, 81};
    public static int[] rooms151152 = {170, 327};
    public static int[] rooms148149 = {264, 397};
    public static int[] room171 = {315, 264};

    public static int[] topHallEnd = {255, 21};
    public static int[] topHallStart = {255, 305};

    public static int[] leftHallEnd = {147, 317};
    public static int[] leftHallStart = {257, 317};

    public static int[] bottomHallEnd = {265, 424};
    public static int[] bottomHallStart = {265, 314};

    public static int[] rightHallStart = {266, 308};
    public static int[] rightHallEnd = {482, 308};

    public static int[] topRightHallStart = {451, 306};
    public static int[] topRightHallEnd = {451, 200};

    public static int[] mainStair = {308, 310};
    public static int[] LStair = {151, 316};
    public static int[] BStair = {264, 421};
    public static int[] RStair = {477, 308};
    public static int[] BandStair = {450, 205};
    public static int[] TStair = {254, 28};
    public static int[] GStair = {148, 41};

    public static HashMap<Integer, int[]> elements = new HashMap<Integer, int[]>();
    public static HashMap<String, int[]> others = new HashMap<String, int[]>();
    public static HashMap<Integer, Integer> intersX = new HashMap<>();
    public static HashMap<Integer, Integer> intersY = new HashMap<>();
    public static HashMap<String, int[]> stairs = new HashMap<>();

    public static void putInDataBase() {
        elements.put(108, room108);
        elements.put(111, room111);
        elements.put(112, room112);
        elements.put(116, rooms116117);
        elements.put(117, rooms116117);
        elements.put(135, room135);
        elements.put(136, room136);
        elements.put(137, room137);
        elements.put(138, room138);
        elements.put(139, room139);
        elements.put(140, room140);
        elements.put(146, room146);
        elements.put(147, room147);
        //elements.put(148, rooms148149);
        elements.put(149, room149);
        elements.put(148, room148);
        //elements.put(149, rooms148149);
        elements.put(150, rooms151152);
        elements.put(151, room151);
        //elements.put(151, rooms151152);
        elements.put(152, room152);
        elements.put(154, room154);
        elements.put(155, room155);
        elements.put(156, room156);
        elements.put(157, room157);
        elements.put(158, room158);
        elements.put(159, room159);
        elements.put(160, room160);
        elements.put(161, room161);
        elements.put(162, room162);
        elements.put(163, room163);
        elements.put(164, room164);
        elements.put(165, room165);
        elements.put(176, room176);
        elements.put(174, room174);
        elements.put(116, room116);
        elements.put(117, room117);
        elements.put(150, room150);
        elements.put(120, room120);
        elements.put(121, room121);
        elements.put(171, room171);
        //elements.put(120, rooms120121);
        //elements.put(121, rooms120121);

        others.put("top hall end", topHallEnd);
        others.put("top hall start", topHallStart);
        others.put("bottom hall start", bottomHallStart);
        others.put("bottom hall end", bottomHallEnd);
        others.put("left hall start", leftHallStart);
        others.put("left hall end", leftHallEnd);
        others.put("right hall start", rightHallStart);
        others.put("right hall end", rightHallEnd);
        others.put("top right hall start", topRightHallStart);
        others.put("top right hall end", topRightHallEnd);

        intersY.put(21, 255);
        intersY.put(305, 255);
        intersX.put(147, 317);
        intersX.put(257, 317);
        intersY.put(424, 265);
        intersY.put(314, 265);
        intersX.put(266, 308);
        intersX.put(482, 308);
        intersY.put(306, 451);
        intersY.put(200, 451);

        stairs.put("Main", mainStair);
        stairs.put("LStair", LStair);
        stairs.put("RStair", RStair);
        stairs.put("BStair", BStair);
        stairs.put("BandStair", BandStair);
        stairs.put("TStair", TStair);
        stairs.put("GStair", GStair);
    }

    public static boolean doesExist(int roomNum) {
        if (elements.containsKey(roomNum)) {
            return true;
        } else {
            return false;
        }
    }

    public static void oneDataBase() {
        HashMap<String, int[]> completebase = new HashMap<String, int[]>();
        for (Integer part : elements.keySet()) {
            completebase.put(part.toString(), elements.get(part));
        }
        for (String otherPart : others.keySet()) {
            completebase.put(otherPart.toString(), completebase.get(otherPart));
        }
    }

    public static int getXConst(int[] coord) {
        return coord[0];
    }

    public static int getYConst(int[] coord) {
        return coord[1];
    }

    public static void findNearestIntersection(int[] coord) {
        int x = coord[0];
        int y = coord[1];

        ArrayList<int[]> values = new ArrayList<int[]>();
        for (int[] value : others.values()) {
            values.add(value);
        }
        ArrayList<int[]> lengths = new ArrayList<int[]>();
        for (int[] valuePair : values) {
            int newx = valuePair[0];
            int newy = valuePair[1];

            int lengthX = Math.abs(x - newx);
            int lengthY = Math.abs(y - newy);

            int[] points = {lengthX, lengthY};

            lengths.add(points);
        }


    }

    public static ArrayList<Integer> findInters(int[] coord) {
        ArrayList<int[]> inters = new ArrayList<>();
        inters.add(others.get("top hall end"));
        inters.add(others.get("left hall end"));
        inters.add(others.get("bottom hall end"));
        inters.add(others.get("right hall end"));
        inters.add(others.get("top right hall end"));

        ArrayList<Integer> lowest = new ArrayList<>();
        lowest.add(1000);
        lowest.add(1000);

        int coordx = coord[0];
        int coordy = coord[1];
        for (int[] each : inters) {
            int x = each[0];
            int y = each[1];

            int lenx = Math.abs(coordx - x);
            int leny = Math.abs(coordy - y);

            if ((lowest.get(0) > lenx) && (lowest.get(1) > leny)) {
                lowest.add(0, lenx);
                lowest.add(1, leny);
            }
            else if ((lowest.get(0) == lenx) || (lowest.get(1) == leny)){
                lowest.add(2, lenx);
                lowest.add(3, leny);
            }

        }
        if (lowest.size() == 4){
            int toRemove1 = (lowest.get(0) == lowest.get(2))? 1000: 2;
            int toRemove2 = (lowest.get(1) == lowest.get(3))? 1000: 3;

            if (toRemove1 == 1000){
                lowest.remove(toRemove2);
            }
            else if (toRemove2 == 1000){
                lowest.remove(toRemove1);
            }

        }

        return lowest;
    }

    public static int[] getIntersRewrite(ArrayList<Integer> coord){
        int coordx = coord.get(0);
        int coordy = coord.get(1);

        int lowestx = 1000;
        int lowesty = 1000;

        int otherlowx = 1000;
        int otherlowy = 1000;
        for (int each : intersX.keySet()){
            if( Math.abs(each-coordx) < lowestx){
                lowestx = each;
                lowesty = intersX.get(each);
                //continue;
            }
        }
        for (int yeach : intersY.keySet()){
            if (Math.abs(yeach-coordx) < otherlowy){
                otherlowy = yeach;
                otherlowx = intersY.get(yeach);
            }
        }
        int difX = Math.abs(lowestx - coordx);
        int difY = Math.abs(lowesty - coordy);

        if (Math.min(difX, difY) == difX){
            int[] reterner ={difX ,intersX.get(difX)};
            return reterner;
        }
        else if(Math.min(difX, difY) == difY){
            int[] reterner = {difY, intersY.get(difY)};
            return reterner;
        }
        else{
            int[] reterner = {1000, 1000};
            return reterner;
        }
    }
}