package com.awesomeness.whsmap;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.graphics.Color;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import com.awesomeness.whsmap.Databasefloor1;
import android.content.Intent;
import com.awesomeness.whsmap.Databasefloor2;
import com.awesomeness.whsmap.Databasefloor3;


import java.util.ArrayList;
import java.util.logging.Logger;


public class MainActivity extends AppCompatActivity{
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;

    TouchImageView floorSet;


    Button one;
    Button two;
    Button three;
    Button four;

    EditText textbox;
    SearchView search;

    int finalHeight;
    int finalWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent serviceIntent = new Intent(this, NotificationService.class);
        startService(serviceIntent);


        image1 = (ImageView) findViewById(R.id.mainLook);
        image2 = (ImageView) findViewById(R.id.floor2);
        image3 = (ImageView) findViewById(R.id.floor3);
        image4 = (ImageView) findViewById(R.id.floor4);

        floorSet = (TouchImageView) findViewById(R.id.imageLooker);
        ViewTreeObserver vto = floorSet.getViewTreeObserver();
        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                floorSet.getViewTreeObserver().removeOnPreDrawListener(this);
                finalHeight = floorSet.getMeasuredHeight();
                finalWidth = floorSet.getMeasuredWidth();
                System.out.println("Height: " + finalHeight + " Width: " + finalWidth);
                return true;
            }
        });


        one = (Button) findViewById(R.id.button);
        two = (Button) findViewById(R.id.button2);
        three = (Button) findViewById(R.id.button3);
        four = (Button) findViewById(R.id.button4);
        Databasefloor1.putInDataBase();
        Databasefloor1.oneDataBase();
        Databasefloor2.putInBase();
        Databasefloor3.putInBase();

        textbox = (EditText) findViewById(R.id.editText);

        search = (SearchView) findViewById(R.id.searchView);
        search.setIconifiedByDefault(false);
        search.setQueryHint("Room Number");
/*
        search.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Databasefloor1.doesExist(Integer.parseInt(search.getQuery().toString()))) {
                    int[] coord = Databasefloor1.elements.get(Integer.parseInt(search.getQuery().toString()));
                    Toast.makeText(getBaseContext(), search.getQuery(), Toast.LENGTH_SHORT).show();
                }

            }
        });
*/


        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                // TODO Auto-generated method stub
                if ((query.charAt(0) == '1') && (textbox.getText().toString().charAt(0) == '1')) {
                    if ((Databasefloor1.doesExist(Integer.parseInt(search.getQuery().toString()))) && Databasefloor1.doesExist(Integer.parseInt(textbox.getText().toString()))) {
                        floorSet.setImageResource(R.drawable.floorone);
                        int[] coordFrom = Databasefloor1.elements.get(Integer.parseInt(textbox.getText().toString()));
                        int multiplier = (finalWidth > 568 && finalHeight > 441)? 3:1;
                        int[] coordFromDoubled = {coordFrom[0]*multiplier, coordFrom[1]*multiplier};
                        //System.out.println(coordFromDoubled[1]);
                        //System.out.println(coordFrom[1]);
                        //System.out.println(finalHeight);
                        int[] coordTo = Databasefloor1.elements.get(Integer.parseInt(search.getQuery().toString()));
                        int[] coordToDoubled = {coordTo[0]*multiplier, coordTo[1]*multiplier};

                        drawFromCoordToCoord(floorSet, coordFromDoubled, coordToDoubled);
                        System.out.println("coord is: " + textbox.getText());
                        System.out.println("search coord is " + search.getQuery());

                        search.clearFocus();
                    }

                }
                else if((query.charAt(0) == '2') && (textbox.getText().toString().charAt(0) == '2')){
                    if ((Databasefloor2.doesExist(Integer.parseInt(search.getQuery().toString()))) && Databasefloor2.doesExist(Integer.parseInt(textbox.getText().toString()))){
                        floorSet.setImageResource(R.drawable.floortwo);
                        int[] coordFrom = Databasefloor2.elements.get(Integer.parseInt(textbox.getText().toString()));
                        int multiplier = (finalWidth > 568 && finalHeight > 441)? 3:1;
                        int[] coordFromDoubled = {coordFrom[0]*multiplier, coordFrom[1]*multiplier};
                        int[] coordTo = Databasefloor2.elements.get(Integer.parseInt(search.getQuery().toString()));
                        int[] coordToDoubled = {coordTo[0]*multiplier, coordTo[1]*multiplier};
                        System.out.println(coordFrom[0]);
                        drawFromCoordToCoord(floorSet, coordFromDoubled, coordToDoubled);
                        search.clearFocus();
                    }
                    else{
                        System.out.println(Integer.parseInt(search.getQuery().toString()));
                        System.out.println(Databasefloor2.doesExist(Integer.parseInt(search.getQuery().toString())));
                        System.out.println(Integer.parseInt(textbox.getText().toString()));
                        System.out.println(Databasefloor2.doesExist(Integer.parseInt(textbox.getText().toString())));
                    }
                }
                else if((query.charAt(0) == '3') && (textbox.getText().toString().charAt(0) == '3')){
                    if ((Databasefloor3.doesExist(Integer.parseInt(search.getQuery().toString()))) && Databasefloor3.doesExist(Integer.parseInt(textbox.getText().toString()))){
                        floorSet.setImageResource(R.drawable.floorthree);
                        int[] coordFrom = Databasefloor3.elements.get(Integer.parseInt(textbox.getText().toString()));
                        int multiplier = (finalWidth > 568 && finalHeight > 441)? 3:1;
                        int[] coordFromDoubled = {coordFrom[0]*multiplier, coordFrom[1]*multiplier};
                        int[] coordTo = Databasefloor3.elements.get(Integer.parseInt(search.getQuery().toString()));
                        int[] coordToDoubled = {coordTo[0]*multiplier, coordTo[1]*multiplier};
                        drawFromCoordToCoord(floorSet, coordFromDoubled, coordToDoubled);
                        search.clearFocus();
                    }
                }
                search.clearFocus();
                return true;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
                // TODO Auto-generated method stub

                return false;
            }
        });
}

        /*
        textbox.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    textbox.performClick();
                    handled = true;
                }
                return handled;
            }
            }
    );}

    */
       // three.setWidth(width / 4);
       // four.setWidth(width/4);

    public void oneClick(View view) {
        if (!(floorSet == (TouchImageView) image1)){
            floorSet.setImageResource(R.drawable.floorone);
    }
    }

    public void twoClick(View view) {
        if (!(floorSet == (TouchImageView)image2)) {

            floorSet.setImageResource(R.drawable.floortwo);
        }
    }


    public void threeClick(View view) {
        if (!(floorSet == (TouchImageView)image3)) {

            floorSet.setImageResource(R.drawable.floorthree);
        }
    }

    public void fourClick(View view) {
        if (!(floorSet == (TouchImageView)image4)) {
            floorSet.setImageResource(R.drawable.floorfour);

        }
    }

    public void drawHorizontal(ImageView floorImg, int yconstant, int xstarting, int xending){
        ImageView image = floorImg;
//this function was used in testing, same with drawVertical
        Bitmap stest = ((BitmapDrawable) image.getDrawable()).getBitmap();
        Bitmap test = stest.copy(stest.getConfig(), true);
        for (int x = xstarting; x <= xending; x++) {
            test.setPixel(x, yconstant, Color.RED);
        }
        floorSet.setImageBitmap(test);

    }

    public void drawVertical(ImageView floorImg, int xconstant, int ystarting, int yending){
        ImageView image = floorImg;

        Bitmap stest = ((BitmapDrawable) image.getDrawable()).getBitmap();
        Bitmap test = stest.copy(stest.getConfig(), true);

        for (int y = ystarting; y < yending; y++) {
            test.setPixel(xconstant, y, Color.RED);
        }
        floorSet.setImageBitmap(test);
    }

    public void drawFromCoordToCoord(ImageView floorImg, int[] fromCoord, int[] toCoord) {
        ImageView image = floorImg;

        Bitmap stest = ((BitmapDrawable) image.getDrawable()).getBitmap();
        Bitmap test = stest.copy(stest.getConfig(), true);
        //System.out.println("Color is: "+test.getPixel(0,10));
        if ((fromCoord[0] < toCoord[0])){
            doX(fromCoord, toCoord, test, floorImg);
            doY(fromCoord, toCoord, test, floorImg);
        }
        else if((fromCoord[0] > toCoord[0]) && (fromCoord[1] < toCoord[1])){
            doX(fromCoord, toCoord, test, floorImg);
            doY(fromCoord, toCoord, test, floorImg);
        }

        else{
            doY(fromCoord, toCoord, test, floorImg);
            doX(fromCoord, toCoord, test, floorImg);
        }
    }
    public void doX(int[] fromCoord, int[] toCoord, Bitmap test, ImageView floorImg) {
            if (fromCoord[0] < toCoord[0]) {
                for (int x = fromCoord[0]; x < toCoord[0]; x++) {
                    test.setPixel(x, fromCoord[1], Color.RED);
                    test.setPixel(x, fromCoord[1] - 1, Color.RED);
                }
                floorImg.setImageBitmap(test);
                System.out.println("Run1");
            } else if (fromCoord[0] > toCoord[0]) {
                for (int x = fromCoord[0]; x > toCoord[0]; x--) {
                    test.setPixel(x, fromCoord[1], Color.RED);
                    test.setPixel(x, fromCoord[1] + 1, Color.RED);
                }
                floorImg.setImageBitmap(test);
                System.out.println("Run2");
            }
        }

        public void doY(int[] fromCoord, int[] toCoord, Bitmap test, ImageView floorImg) {
            if (fromCoord[1] < toCoord[1]) {
                for (int y = fromCoord[1]; y < toCoord[1]; y++) {
                    test.setPixel(toCoord[0], y, Color.RED);
                    test.setPixel(toCoord[0] - 1, y, Color.RED);

                }
                floorImg.setImageBitmap(test);
                System.out.println("Run3");
            } else if (fromCoord[1] > toCoord[1]) {
                for (int y = fromCoord[1]; y > toCoord[1]; y--) {
                    test.setPixel(toCoord[0], y, Color.RED);
                    test.setPixel(toCoord[0] + 1, y, Color.RED);
                }
                floorImg.setImageBitmap(test);
                System.out.println("Run4");
        }
    }
}



