package sample;/* autogenerated by Processing revision 1281 on 2022-04-18 */
import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.effects.*;
import ddf.minim.signals.*;
import ddf.minim.spi.*;
import ddf.minim.ugens.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class Calm extends PApplet {


//Global variables: 
Minim minim;
AudioPlayer audio;
float var1;
float var2;

//void settings(){
//  size(1080, 1080);
//  smooth(8);
//  //noCursor();
//}

//MAIN SETUP
 public void setup(){
  /* size commented out by preprocessor */;
  surface.setLocation(100, 100);
  //fullScreen();
  /* smooth commented out by preprocessor */;
  //surface.setSize(1080,1080);
  ////noCursor(); 
  //surface.setResizable(true);
  background (0);
  frameRate(30);
  
//AUDIO PROCESSING DONE HERE.
  minim = new Minim(this);
  audio = minim.loadFile("ThetaAlpha.mp3");    
  audio.loop();
}
 
 public void draw(){
  fill(0xFF000000,50);  
  noStroke();
  rect(0, 0, width, height);
  translate(width/2, height/2);
  
  int size = audio.bufferSize();
  for (int i = 0; i < size-1; i++) {
    
    float angle = sin(i+var1)* 10; 
    float angle2 = sin(i+var2)* 300; 

    float x = sin(radians(i))*(angle2+30); 
    float y = cos(radians(i))*(angle2+30);
    
    float x2 = sin(radians(i))*(800/angle); 
    float y2 = cos(radians(i))*(800/angle);

    float x3 = sin(radians(i))*(500/angle); 
    float y3 = cos(radians(i))*(500/angle);
    
    float x4 = sin(radians(i))*(1000/angle); 
    float y4 = cos(radians(i))*(1000/angle);
    
    float x5 = sin(radians(i))*(1500/angle); 
    float y5 = cos(radians(i))*(1500/angle);
    
// Blue and green variants to create a calm environment supported by our research:
    int blue = color(0, 153, 255);
    fill (blue, 90); //blue
    circle(x3, y3, audio.right.get(i)*10);
 
    fill ( 0xFF00FFBF, 90); //light green
    rect(x3, y3, audio.left.get(i)*20, audio.left.get(i)*10);

    fill (0xFF3366FF, 70); //darker blue
    circle(x, y, audio.right.get(i)*10);
    
    fill( 0xFF00FFBF , 90); //light green
    rect(x3, y3, audio.right.get(i)*10, audio.right.get(i)*20);

    fill ( 0xFF00FFFF  , 90); //blue
    circle(x2, y2, audio.right.get(i)*20);
    
    fill (0xFFFFFFFF, 150); //white
    ellipse(x4, y4, audio.right.get(i)*30, audio.right.get(i)*30);
    
    fill (0xFF66FFFF, 90); //blue
    ellipse(x5,y5, audio.right.get(i)*30, audio.right.get(i)*30);
    
    fill( 0xFF00FFBF , 90); //light green
    circle(x3, y3, audio.right.get(i)*10);

  }
  var1 += 0.01f;
  var2 += 0.05f;

}


  public void settings() { size(1000, 1000, P3D);
smooth(8); }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Calm" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
