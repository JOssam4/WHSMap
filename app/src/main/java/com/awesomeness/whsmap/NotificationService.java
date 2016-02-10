package com.awesomeness.whsmap;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by 18zhoue on 1/8/16.
 */
public class NotificationService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
        runnable.run();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    final Handler handler = new Handler();
    private Runnable runnable = new Runnable() {

        @Override
        public void run() {
            try{
                //do your code here
                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// Sets an ID for the notification, so it can be updated
                int notifyID = 1;
                String text = "Last block!";
                String text2 = "No school right now!";
                //Block and Time

                //get day of week
                SimpleDateFormat dayOfWeek = new SimpleDateFormat("EE");
                String d = dayOfWeek.format(new Date());

                //get hour minute second
                SimpleDateFormat hour = new SimpleDateFormat("HH");
                int h = Integer.parseInt(hour.format(new Date()));

                SimpleDateFormat minutes = new SimpleDateFormat("mm");
                int m = Integer.parseInt(minutes.format(new Date()));

                SimpleDateFormat seconds = new SimpleDateFormat("ss");
                int s = Integer.parseInt(seconds.format(new Date()));
                int day = 86400;
                int sTime = h*3600+m*60+s;
                int startSun = 113400;
                int startSat = 199800;
                int start1 = 27000;
                int end1 = 30540;
                int start2 = 30840;
                int end2 = 34380;
                int startA = 34680;
                int endA = 35160;
                int start3 = 34680;
                int end3 = 39000;
                int start4 = 39300;
                int firstLunch4 = 41040;
                int secondLunch4 = 42780;
                int end4 = 44520;
                int start5 = 44820;
                int end5 = 48360;
                int start6 = 48660;
                int end6 = 52200;

                //correct for school derpy clocks
                sTime = sTime+60;

                if(d.equals("Sun")){
                    text = Integer.toString((startSun-sTime)/3600)+"h"+Integer.toString(((startSun-sTime)%3600)/60)+"m"+Integer.toString(((startSun-sTime)%60))+"s to school start";
                }
                else if(d.equals("Mon")){
                    if (sTime >= start1 && sTime < end6) {
                        text2 = Integer.toString((52200 - sTime) / 3600) + "h" + Integer.toString(((52200 - sTime) % 3600) / 60) + "m" + Integer.toString(((52200 - sTime) % 60)) + "s to end of school";
                    }
                    if(sTime < start1){
                        text = Integer.toString((start1-sTime)/3600)+"h"+Integer.toString(((start1-sTime)%3600)/60)+"m"+Integer.toString(((start1-sTime)%60))+"s to start of block 1";

                        text2 = Integer.toString((start2-sTime)/3600)+"h"+Integer.toString(((start2-sTime)%3600)/60)+"m"+Integer.toString(((start2-sTime)%60))+"s to start of block 2";
                    }
                    else if(sTime < end1){
                        text = Integer.toString((end1-sTime)/3600)+"h"+Integer.toString(((end1-sTime)%3600)/60)+"m"+Integer.toString(((end1-sTime)%60))+"s to end of block 1";
                    }
                    else if(sTime < start2){
                        text = Integer.toString((start2-sTime)/3600)+"h"+Integer.toString(((start2-sTime)%3600)/60)+"m"+Integer.toString(((start2-sTime)%60))+"s to start of block 2";
                    }
                    else if(sTime < end2){
                        text = Integer.toString((end2-sTime)/3600)+"h"+Integer.toString(((end2-sTime)%3600)/60)+"m"+Integer.toString(((end2-sTime)%60))+"s to end of block 2";
                    }
                    else if(sTime < startA){
                        text = Integer.toString((startA-sTime)/3600)+"h"+Integer.toString(((startA-sTime)%3600)/60)+"m"+Integer.toString(((startA-sTime)%60))+"s to start of advisory";
                    }
                    else if(sTime < endA){
                        text = Integer.toString((endA-sTime)/3600)+"h"+Integer.toString(((endA-sTime)%3600)/60)+"m"+Integer.toString(((endA-sTime)%60))+"s to end of advisory";
                    }
                    else if(sTime < start3){
                        text = Integer.toString((start3-sTime)/3600)+"h"+Integer.toString(((start3-sTime)%3600)/60)+"m"+Integer.toString(((start3-sTime)%60))+"s to start of block 3";
                    }
                    else if(sTime < end3){
                        text = Integer.toString((end3-sTime)/3600)+"h"+Integer.toString(((end3-sTime)%3600)/60)+"m"+Integer.toString(((end3-sTime)%60))+"s to end of block 3";
                    }
                    else if(sTime < start4){
                        text = Integer.toString((start4-sTime)/3600)+"h"+Integer.toString(((start4-sTime)%3600)/60)+"m"+Integer.toString(((start4-sTime)%60))+"s to start of block 4";
                    }
                    else if(sTime < end4){
                        text = Integer.toString((end4-sTime)/3600)+"h"+Integer.toString(((end4-sTime)%3600)/60)+"m"+Integer.toString(((end4-sTime)%60))+"s to end of block 4";
                        if (sTime < firstLunch4){
                            text2 = Integer.toString((firstLunch4-sTime)/3600)+"h"+Integer.toString(((firstLunch4-sTime)%3600)/60)+"m"+Integer.toString(((firstLunch4-sTime)%60))+"s to end of first lunch";
                        }
                        else if (sTime < secondLunch4){
                            text2 = Integer.toString((secondLunch4-sTime)/3600)+"h"+Integer.toString(((secondLunch4-sTime)%3600)/60)+"m"+Integer.toString(((secondLunch4-sTime)%60))+"s to end of second lunch";
                        }
                    }
                    else if(sTime < start5){
                        text = Integer.toString((start5-sTime)/3600)+"h"+Integer.toString(((start5-sTime)%3600)/60)+"m"+Integer.toString(((start5-sTime)%60))+"s to start of block 5";
                    }
                    else if(sTime < end5){
                        text = Integer.toString((end5-sTime)/3600)+"h"+Integer.toString(((end5-sTime)%3600)/60)+"m"+Integer.toString(((end5-sTime)%60))+"s to end of block 5";
                    }
                    else if(sTime < start6){
                        text = Integer.toString((start6-sTime)/3600)+"h"+Integer.toString(((start6-sTime)%3600)/60)+"m"+Integer.toString(((start6-sTime)%60))+"s to start of block 6";
                    }
                    else if(sTime < end6){
                        text = Integer.toString((end6-sTime)/3600)+"h"+Integer.toString(((end6-sTime)%3600)/60)+"m"+Integer.toString(((end6-sTime)%60))+"s to end of block 6";
                    }
                    else {
                        text = Integer.toString((startSun - sTime) / 3600) + "h" + Integer.toString(((startSun - sTime) % 3600) / 60) + "m" + Integer.toString(((startSun - sTime) % 60)) + "s to school start";
                    }
                }
                else if(d.equals("Tue")){
                    if (sTime >= start1 && sTime < end6) {
                        text2 = Integer.toString((52200 - sTime) / 3600) + "h" + Integer.toString(((52200 - sTime) % 3600) / 60) + "m" + Integer.toString(((52200 - sTime) % 60)) + "s to end of school";
                    }
                    if(sTime < start1){
                        text = Integer.toString((start1-sTime)/3600)+"h"+Integer.toString(((start1-sTime)%3600)/60)+"m"+Integer.toString(((start1-sTime)%60))+"s to start of block 1";

                        text2 = Integer.toString((start2-sTime)/3600)+"h"+Integer.toString(((start2-sTime)%3600)/60)+"m"+Integer.toString(((start2-sTime)%60))+"s to start of block 2";
                    }
                    else if(sTime < end1){
                        text = Integer.toString((end1-sTime)/3600)+"h"+Integer.toString(((end1-sTime)%3600)/60)+"m"+Integer.toString(((end1-sTime)%60))+"s to end of block 1";
                    }
                    else if(sTime < start2){
                        text = Integer.toString((start2-sTime)/3600)+"h"+Integer.toString(((start2-sTime)%3600)/60)+"m"+Integer.toString(((start2-sTime)%60))+"s to start of block 2";
                    }
                    else if(sTime < end2){
                        text = Integer.toString((end2-sTime)/3600)+"h"+Integer.toString(((end2-sTime)%3600)/60)+"m"+Integer.toString(((end2-sTime)%60))+"s to end of block 2";
                    }
                    else if(sTime < startA){
                        text = Integer.toString((startA-sTime)/3600)+"h"+Integer.toString(((startA-sTime)%3600)/60)+"m"+Integer.toString(((startA-sTime)%60))+"s to start of advisory";
                    }
                    else if(sTime < endA){
                        text = Integer.toString((endA-sTime)/3600)+"h"+Integer.toString(((endA-sTime)%3600)/60)+"m"+Integer.toString(((endA-sTime)%60))+"s to end of advisory";
                    }
                    else if(sTime < start3){
                        text = Integer.toString((start3-sTime)/3600)+"h"+Integer.toString(((start3-sTime)%3600)/60)+"m"+Integer.toString(((start3-sTime)%60))+"s to start of block 3";
                    }
                    else if(sTime < end3){
                        text = Integer.toString((end3-sTime)/3600)+"h"+Integer.toString(((end3-sTime)%3600)/60)+"m"+Integer.toString(((end3-sTime)%60))+"s to end of block 3";
                    }
                    else if(sTime < start4){
                        text = Integer.toString((start4-sTime)/3600)+"h"+Integer.toString(((start4-sTime)%3600)/60)+"m"+Integer.toString(((start4-sTime)%60))+"s to start of block 4";
                    }
                    else if(sTime < end4){
                        text = Integer.toString((end4-sTime)/3600)+"h"+Integer.toString(((end4-sTime)%3600)/60)+"m"+Integer.toString(((end4-sTime)%60))+"s to end of block 4";
                        if (sTime < firstLunch4){
                            text2 = Integer.toString((firstLunch4-sTime)/3600)+"h"+Integer.toString(((firstLunch4-sTime)%3600)/60)+"m"+Integer.toString(((firstLunch4-sTime)%60))+"s to end of first lunch";
                        }
                        else if (sTime < secondLunch4){
                            text2 = Integer.toString((secondLunch4-sTime)/3600)+"h"+Integer.toString(((secondLunch4-sTime)%3600)/60)+"m"+Integer.toString(((secondLunch4-sTime)%60))+"s to end of second lunch";
                        }
                    }
                    else if(sTime < start5){
                        text = Integer.toString((start5-sTime)/3600)+"h"+Integer.toString(((start5-sTime)%3600)/60)+"m"+Integer.toString(((start5-sTime)%60))+"s to start of block 5";
                    }
                    else if(sTime < end5){
                        text = Integer.toString((end5-sTime)/3600)+"h"+Integer.toString(((end5-sTime)%3600)/60)+"m"+Integer.toString(((end5-sTime)%60))+"s to end of block 5";
                    }
                    else if(sTime < start6){
                        text = Integer.toString((start6-sTime)/3600)+"h"+Integer.toString(((start6-sTime)%3600)/60)+"m"+Integer.toString(((start6-sTime)%60))+"s to start of block 6";
                    }
                    else if(sTime < end6){
                        text = Integer.toString((end6-sTime)/3600)+"h"+Integer.toString(((end6-sTime)%3600)/60)+"m"+Integer.toString(((end6-sTime)%60))+"s to end of block 6";
                    }
                    else {
                        text = Integer.toString((startSun - sTime) / 3600) + "h" + Integer.toString(((startSun - sTime) % 3600) / 60) + "m" + Integer.toString(((startSun - sTime) % 60)) + "s to school start";
                    }
                }
                else if(d.equals("Wed")){
                    if (sTime >= start1 && sTime < end6) {
                        text2 = Integer.toString((52200 - sTime) / 3600) + "h" + Integer.toString(((52200 - sTime) % 3600) / 60) + "m" + Integer.toString(((52200 - sTime) % 60)) + "s to end of school";
                    }
                    if(sTime < start1){
                        text = Integer.toString((start1-sTime)/3600)+"h"+Integer.toString(((start1-sTime)%3600)/60)+"m"+Integer.toString(((start1-sTime)%60))+"s to start of block 1";

                        text2 = Integer.toString((start2-sTime)/3600)+"h"+Integer.toString(((start2-sTime)%3600)/60)+"m"+Integer.toString(((start2-sTime)%60))+"s to start of block 2";
                    }
                    else if(sTime < end1){
                        text = Integer.toString((end1-sTime)/3600)+"h"+Integer.toString(((end1-sTime)%3600)/60)+"m"+Integer.toString(((end1-sTime)%60))+"s to end of block 1";
                    }
                    else if(sTime < start2){
                        text = Integer.toString((start2-sTime)/3600)+"h"+Integer.toString(((start2-sTime)%3600)/60)+"m"+Integer.toString(((start2-sTime)%60))+"s to start of block 2";
                    }
                    else if(sTime < end2){
                        text = Integer.toString((end2-sTime)/3600)+"h"+Integer.toString(((end2-sTime)%3600)/60)+"m"+Integer.toString(((end2-sTime)%60))+"s to end of block 2";
                    }
                    else if(sTime < startA){
                        text = Integer.toString((startA-sTime)/3600)+"h"+Integer.toString(((startA-sTime)%3600)/60)+"m"+Integer.toString(((startA-sTime)%60))+"s to start of advisory";
                    }
                    else if(sTime < endA){
                        text = Integer.toString((endA-sTime)/3600)+"h"+Integer.toString(((endA-sTime)%3600)/60)+"m"+Integer.toString(((endA-sTime)%60))+"s to end of advisory";
                    }
                    else if(sTime < start3){
                        text = Integer.toString((start3-sTime)/3600)+"h"+Integer.toString(((start3-sTime)%3600)/60)+"m"+Integer.toString(((start3-sTime)%60))+"s to start of block 3";
                    }
                    else if(sTime < end3){
                        text = Integer.toString((end3-sTime)/3600)+"h"+Integer.toString(((end3-sTime)%3600)/60)+"m"+Integer.toString(((end3-sTime)%60))+"s to end of block 3";
                    }
                    else if(sTime < start4){
                        text = Integer.toString((start4-sTime)/3600)+"h"+Integer.toString(((start4-sTime)%3600)/60)+"m"+Integer.toString(((start4-sTime)%60))+"s to start of block 4";
                    }
                    else if(sTime < end4){
                        text = Integer.toString((end4-sTime)/3600)+"h"+Integer.toString(((end4-sTime)%3600)/60)+"m"+Integer.toString(((end4-sTime)%60))+"s to end of block 4";
                        if (sTime < firstLunch4){
                            text2 = Integer.toString((firstLunch4-sTime)/3600)+"h"+Integer.toString(((firstLunch4-sTime)%3600)/60)+"m"+Integer.toString(((firstLunch4-sTime)%60))+"s to end of first lunch";
                        }
                        else if (sTime < secondLunch4){
                            text2 = Integer.toString((secondLunch4-sTime)/3600)+"h"+Integer.toString(((secondLunch4-sTime)%3600)/60)+"m"+Integer.toString(((secondLunch4-sTime)%60))+"s to end of second lunch";
                        }
                    }
                    else if(sTime < start5){
                        text = Integer.toString((start5-sTime)/3600)+"h"+Integer.toString(((start5-sTime)%3600)/60)+"m"+Integer.toString(((start5-sTime)%60))+"s to start of block 5";
                    }
                    else if(sTime < end5){
                        text = Integer.toString((end5-sTime)/3600)+"h"+Integer.toString(((end5-sTime)%3600)/60)+"m"+Integer.toString(((end5-sTime)%60))+"s to end of block 5";
                    }
                    else if(sTime < start6){
                        text = Integer.toString((start6-sTime)/3600)+"h"+Integer.toString(((start6-sTime)%3600)/60)+"m"+Integer.toString(((start6-sTime)%60))+"s to start of block 6";
                    }
                    else if(sTime < end6){
                        text = Integer.toString((end6-sTime)/3600)+"h"+Integer.toString(((end6-sTime)%3600)/60)+"m"+Integer.toString(((end6-sTime)%60))+"s to end of block 6";
                    }
                    else {
                        text = Integer.toString((startSun - sTime) / 3600) + "h" + Integer.toString(((startSun - sTime) % 3600) / 60) + "m" + Integer.toString(((startSun - sTime) % 60)) + "s to school start";
                    }
                }
                else if(d.equals("Thu")){
                    if (sTime >= start1 && sTime < end6) {
                        text2 = Integer.toString((52200 - sTime) / 3600) + "h" + Integer.toString(((52200 - sTime) % 3600) / 60) + "m" + Integer.toString(((52200 - sTime) % 60)) + "s to end of school";
                    }
                    if(sTime < start1){
                        text = Integer.toString((start1-sTime)/3600)+"h"+Integer.toString(((start1-sTime)%3600)/60)+"m"+Integer.toString(((start1-sTime)%60))+"s to start of block 1";

                        text2 = Integer.toString((start2-sTime)/3600)+"h"+Integer.toString(((start2-sTime)%3600)/60)+"m"+Integer.toString(((start2-sTime)%60))+"s to start of block 2";
                    }
                    else if(sTime < end1){
                        text = Integer.toString((end1-sTime)/3600)+"h"+Integer.toString(((end1-sTime)%3600)/60)+"m"+Integer.toString(((end1-sTime)%60))+"s to end of block 1";
                    }
                    else if(sTime < start2){
                        text = Integer.toString((start2-sTime)/3600)+"h"+Integer.toString(((start2-sTime)%3600)/60)+"m"+Integer.toString(((start2-sTime)%60))+"s to start of block 2";
                    }
                    else if(sTime < end2){
                        text = Integer.toString((end2-sTime)/3600)+"h"+Integer.toString(((end2-sTime)%3600)/60)+"m"+Integer.toString(((end2-sTime)%60))+"s to end of block 2";
                    }
                    else if(sTime < startA){
                        text = Integer.toString((startA-sTime)/3600)+"h"+Integer.toString(((startA-sTime)%3600)/60)+"m"+Integer.toString(((startA-sTime)%60))+"s to start of advisory";
                    }
                    else if(sTime < endA){
                        text = Integer.toString((endA-sTime)/3600)+"h"+Integer.toString(((endA-sTime)%3600)/60)+"m"+Integer.toString(((endA-sTime)%60))+"s to end of advisory";
                    }
                    else if(sTime < start3){
                        text = Integer.toString((start3-sTime)/3600)+"h"+Integer.toString(((start3-sTime)%3600)/60)+"m"+Integer.toString(((start3-sTime)%60))+"s to start of block 3";
                    }
                    else if(sTime < end3){
                        text = Integer.toString((end3-sTime)/3600)+"h"+Integer.toString(((end3-sTime)%3600)/60)+"m"+Integer.toString(((end3-sTime)%60))+"s to end of block 3";
                    }
                    else if(sTime < start4){
                        text = Integer.toString((start4-sTime)/3600)+"h"+Integer.toString(((start4-sTime)%3600)/60)+"m"+Integer.toString(((start4-sTime)%60))+"s to start of block 4";
                    }
                    else if(sTime < end4){
                        text = Integer.toString((end4-sTime)/3600)+"h"+Integer.toString(((end4-sTime)%3600)/60)+"m"+Integer.toString(((end4-sTime)%60))+"s to end of block 4";
                        if (sTime < firstLunch4){
                            text2 = Integer.toString((firstLunch4-sTime)/3600)+"h"+Integer.toString(((firstLunch4-sTime)%3600)/60)+"m"+Integer.toString(((firstLunch4-sTime)%60))+"s to end of first lunch";
                        }
                        else if (sTime < secondLunch4){
                            text2 = Integer.toString((secondLunch4-sTime)/3600)+"h"+Integer.toString(((secondLunch4-sTime)%3600)/60)+"m"+Integer.toString(((secondLunch4-sTime)%60))+"s to end of second lunch";
                        }
                    }
                    else if(sTime < start5){
                        text = Integer.toString((start5-sTime)/3600)+"h"+Integer.toString(((start5-sTime)%3600)/60)+"m"+Integer.toString(((start5-sTime)%60))+"s to start of block 5";
                    }
                    else if(sTime < end5){
                        text = Integer.toString((end5-sTime)/3600)+"h"+Integer.toString(((end5-sTime)%3600)/60)+"m"+Integer.toString(((end5-sTime)%60))+"s to end of block 5";
                    }
                    else if(sTime < start6){
                        text = Integer.toString((start6-sTime)/3600)+"h"+Integer.toString(((start6-sTime)%3600)/60)+"m"+Integer.toString(((start6-sTime)%60))+"s to start of block 6";
                    }
                    else if(sTime < end6){
                        text = Integer.toString((end6-sTime)/3600)+"h"+Integer.toString(((end6-sTime)%3600)/60)+"m"+Integer.toString(((end6-sTime)%60))+"s to end of block 6";
                    }
                    else {
                        text = Integer.toString((startSun - sTime) / 3600) + "h" + Integer.toString(((startSun - sTime) % 3600) / 60) + "m" + Integer.toString(((startSun - sTime) % 60)) + "s to school start";
                    }
                }
                else if(d.equals("Fri")){
                    if (sTime >= start1 && sTime < end6) {
                        text2 = Integer.toString((52200 - sTime) / 3600) + "h" + Integer.toString(((52200 - sTime) % 3600) / 60) + "m" + Integer.toString(((52200 - sTime) % 60)) + "s to end of school";
                    }
                    if(sTime < start1){
                        text = Integer.toString((start1-sTime)/3600)+"h"+Integer.toString(((start1-sTime)%3600)/60)+"m"+Integer.toString(((start1-sTime)%60))+"s to start of block 1";

                        text2 = Integer.toString((start2-sTime)/3600)+"h"+Integer.toString(((start2-sTime)%3600)/60)+"m"+Integer.toString(((start2-sTime)%60))+"s to start of block 2";
                    }
                    else if(sTime < end1){
                        text = Integer.toString((end1-sTime)/3600)+"h"+Integer.toString(((end1-sTime)%3600)/60)+"m"+Integer.toString(((end1-sTime)%60))+"s to end of block 1";
                    }
                    else if(sTime < start2){
                        text = Integer.toString((start2-sTime)/3600)+"h"+Integer.toString(((start2-sTime)%3600)/60)+"m"+Integer.toString(((start2-sTime)%60))+"s to start of block 2";
                    }
                    else if(sTime < end2){
                        text = Integer.toString((end2-sTime)/3600)+"h"+Integer.toString(((end2-sTime)%3600)/60)+"m"+Integer.toString(((end2-sTime)%60))+"s to end of block 2";
                    }
                    else if(sTime < startA){
                        text = Integer.toString((startA-sTime)/3600)+"h"+Integer.toString(((startA-sTime)%3600)/60)+"m"+Integer.toString(((startA-sTime)%60))+"s to start of advisory";
                    }
                    else if(sTime < endA){
                        text = Integer.toString((endA-sTime)/3600)+"h"+Integer.toString(((endA-sTime)%3600)/60)+"m"+Integer.toString(((endA-sTime)%60))+"s to end of advisory";
                    }
                    else if(sTime < start3){
                        text = Integer.toString((start3-sTime)/3600)+"h"+Integer.toString(((start3-sTime)%3600)/60)+"m"+Integer.toString(((start3-sTime)%60))+"s to start of block 3";
                    }
                    else if(sTime < end3){
                        text = Integer.toString((end3-sTime)/3600)+"h"+Integer.toString(((end3-sTime)%3600)/60)+"m"+Integer.toString(((end3-sTime)%60))+"s to end of block 3";
                    }
                    else if(sTime < start4){
                        text = Integer.toString((start4-sTime)/3600)+"h"+Integer.toString(((start4-sTime)%3600)/60)+"m"+Integer.toString(((start4-sTime)%60))+"s to start of block 4";
                    }
                    else if(sTime < end4){
                        text = Integer.toString((end4-sTime)/3600)+"h"+Integer.toString(((end4-sTime)%3600)/60)+"m"+Integer.toString(((end4-sTime)%60))+"s to end of block 4";
                        if (sTime < firstLunch4){
                            text2 = Integer.toString((firstLunch4-sTime)/3600)+"h"+Integer.toString(((firstLunch4-sTime)%3600)/60)+"m"+Integer.toString(((firstLunch4-sTime)%60))+"s to end of first lunch";
                        }
                        else if (sTime < secondLunch4){
                            text2 = Integer.toString((secondLunch4-sTime)/3600)+"h"+Integer.toString(((secondLunch4-sTime)%3600)/60)+"m"+Integer.toString(((secondLunch4-sTime)%60))+"s to end of second lunch";
                        }
                    }
                    else if(sTime < start5){
                        text = Integer.toString((start5-sTime)/3600)+"h"+Integer.toString(((start5-sTime)%3600)/60)+"m"+Integer.toString(((start5-sTime)%60))+"s to start of block 5";
                    }
                    else if(sTime < end5){
                        text = Integer.toString((end5-sTime)/3600)+"h"+Integer.toString(((end5-sTime)%3600)/60)+"m"+Integer.toString(((end5-sTime)%60))+"s to end of block 5";
                    }
                    else if(sTime < start6){
                        text = Integer.toString((start6-sTime)/3600)+"h"+Integer.toString(((start6-sTime)%3600)/60)+"m"+Integer.toString(((start6-sTime)%60))+"s to start of block 6";
                    }
                    else if(sTime < end6){
                        text = Integer.toString((end6-sTime)/3600)+"h"+Integer.toString(((end6-sTime)%3600)/60)+"m"+Integer.toString(((end6-sTime)%60))+"s to end of block 6";
                    }
                    else{
                        text = Integer.toString((startSat+day-sTime)/3600)+"h"+Integer.toString(((startSat+day-sTime)%3600)/60)+"m"+Integer.toString(((startSat+day-sTime)%60))+"s to school start";
                    }
                }
                else if(d.equals("Sat")){
                    text = Integer.toString((startSat-sTime)/3600)+"h"+Integer.toString(((startSat-sTime)%3600)/60)+"m"+Integer.toString(((startSat-sTime)%60))+"s to school start";
                }
                /*
                7:30;
                8:29;

                8:34;
                9:33;

                9:38;
                9:46;

                9:51;
                10:50;

                10:55;

                11:24;
                11:53;

                12:22;

                12:27;
                13:26;

                13:31;
                14:30;
                */

                //build and issue notification
                NotificationCompat.Builder mNotifyBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(getApplicationContext())
                        .setContentTitle(text)
                        .setContentText(text2)
                        .setSmallIcon(R.drawable.ic_schedule_black_48dp);

                mNotificationManager.notify(
                        notifyID,
                        mNotifyBuilder.build());
                //also call the same runnable
                handler.postDelayed(this, 1000);
            }
            catch (Exception e) {
                // TODO: handle exception
            }
        }
    };
}