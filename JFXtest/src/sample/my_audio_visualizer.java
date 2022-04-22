/* autogenerated by Processing revision 1281 on 2022-04-20 */
package sample;
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
import ddf.minim.analysis.FFT;
import controlP5.*;
import processing.sound.*;
import processing.awt.PSurfaceAWT;
import java.util.HashMap;
import java.util.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class my_audio_visualizer extends PApplet {





PSurfaceAWT awtSurface;
PSurfaceAWT.SmoothCanvas smoothCanvas;
PImage img;
Visualizer visualizer;
ControlPanel controlPanel;

boolean colorchange = true;
//func3 func3;

ControlP5 cp5;
Minim minim;
//GLOBAL VARIABLES, I KNOW, IT'S MESSY :P
int controlPanelWidth;
int windowHeight;
int windowWidth;
int visualizerWidth;
int numFrames=100;
FFT fft;
FFT fft1;
FFT fft2;
//inputInput input;
AudioPlayer input;
boolean fade = true;
boolean go = true;
int ranges = 100;
int n = 0;
float incr1; 
float incr2;
float limit;
float h;
int w;
int hgt;
PFont myFont1;
float redcolor;
float bluecolor;
float greencolor;
//boolean addNew = true;



int musicNum = 0;
PFont myFont2;
//Particle[] particles;
int bands = 256;
int currentWidth = width;
 public void setup() {
  /* size commented out by preprocessor */;
  surface.setSize(1080, 1080);
  surface.setLocation(displayWidth/2-width/2, displayHeight/2-height/2);
  background(25);
  cp5 = new ControlP5(this);
  System.out.println("Reset!");
  //windowHeight = displayHeight;
  //windowWidth = displayWidth;
  windowHeight = height;
  windowWidth = width;
  //controlPanelWidth = displayWidth / 4;
  controlPanelWidth = width/4;
  //visualizerWidth = (displayWidth - controlPanelWidth);
  visualizerWidth = (width - controlPanelWidth);
  minim = new Minim(this);
  System.out.println(musicNum);
  input = minim.loadFile("Corvad - Tesla.mp3");
  input.play();
  fft = new FFT(input.bufferSize(), input.sampleRate());
  fft.linAverages(bands);
  noiseSeed(98);
  /* smooth commented out by preprocessor */;
  incr2 = TWO_PI/100 ;
  h = random(360);
  img = loadImage("kwai_logo.png");
  visualizer = new Visualizer(windowHeight, windowWidth, visualizerWidth);
  controlPanel = new ControlPanel(visualizer, windowHeight, windowWidth, controlPanelWidth, cp5);
  cp5.addCallback(new CallbackListener() {
    public void controlEvent(CallbackEvent event) {
      // event.getAction() == 1 for click
      if(event.getController().getName() == "pause" && event.getAction() == 1) {
        go = !go;
        input.pause();
        cp5.getController("pause").setCaptionLabel(go ? "Pause" : "Unpause");
        System.out.println(go);
        if(go == true){
          input.play();
        }
      } else if (event.getController().getName() == "reset" && event.getAction() == 1) {
        cp5.getController("amplitude").setValue(0.40f);
        cp5.getController("frequency").setValue(0.50f);
        cp5.getController("redcolor").setValue(100);
        cp5.getController("greencolor").setValue(100);
        cp5.getController("bluecolor").setValue(100);   
      }
    visualizer.musicChooser((int)cp5.getController("Music_Changer").getValue());
    }
  });
}


 public void draw() {
  if(go) {
    visualizer.draw();
    controlPanel.draw();
  } 
}

 public void mouseReleased() {

  controlPanel.mouseEvent();
}
 public void stop() {
  super.stop();
}

public class Visualizer{
  float amplitudeMagnitude = 0.4f; // Default
  float frequencyMagnitude = 0.5f; // Default
  float adjustedAmplitudeMagnitude;
  float adjustedFrequencyMagnitude;
  float amplitude;
  float frequency;
  int musicNum = 0; //Default
  int visualizationIndex = 0; // Default
  int windowHeight;
  int windowWidth;
  int visualizerWidth;
  int time;
  int wait = 100;
  float[] angle;
  float[] y, x;
  Boolean[] addNew = new Boolean[28];
  int color1 = 0;
  int color2 = 255;
  int color3 = 255;
  public Visualizer(int windowHeight, int windowWidth, int visualizerWidth) {
    this.windowHeight = windowHeight;
    this.windowWidth = windowWidth;
    this.visualizerWidth = visualizerWidth;
    time = millis(); // Current time
    Arrays.fill(addNew, Boolean.TRUE);
  }
  public void draw() {
    fft.forward(input.mix);
    img = loadImage("kwai_logo.png");
    switch(visualizationIndex) {
      case 0:
        //fill(0, 0, 0);
        background(0);
        function1();
        break;
      case 1:
     //fill(0, 0, 0);
        //background(0);
        background(36);
        ellipseMode(CENTER);
        fill(255, 40);
        noStroke();
        smooth();
        function2();
        break;
      case 2:
      background(0);
        //func3.draw();
        noFill();
        strokeWeight(2);
        function3();
        break;
      case 3:
      //fill(0, 0, 0);
      background(0);
        function4();
        break;
      default:
      background(0);
      function1();
    }
  }
  
  private void function1(){
  background(color(5,10,25));
  myFont1 = createFont("Lucida Calligraphy Italic", 32);
  myFont2 = createFont("Segoe Print", 32);
  //textFont(myFont1,35);
  //fill(255);
  //textAlign(CENTER);
  //text("Team",345,45);
  //textFont(myFont1,45);
  //text("K-Wai",345,85);
  //textFont(myFont2,10);
  //text("MEDITATION",345,100);
  //textFont(myFont1,47);
  //text("Audio",345,140);
  //textFont(myFont2,65);
  //text("Visualizer",345,205);
  //stroke(255);
  //strokeWeight(4);
  //line(300,217,400,217);
  //line(315,227,385,227);
  //line(330,237,370,237);
  //strokeWeight(1);
  //line(305,93,313,93);
  //line(295,96,313,96);
  //line(305,99,313,99);
  //line(376,93,385,93);
  //line(376,96,395,96);
  //line(376,99,385,99);
  //strokeWeight(3);
  //point(270,150);
  //point(275,150);
  //point(280,150);
  //point(285,150);
  //point(290,150);
  //point(295,150);
  //point(300,150);
  //point(305,150);
  //point(310,150);
  //point(315,150);
  //point(320,150);
  //point(325,150);
  //point(330,150);
  //point(335,150);
  //point(340,150);
  //point(345,150);
  //point(350,150);
  //point(355,150);
  //point(360,150);
  //point(365,150);
  //point(370,150);
  //point(375,150);
  //point(380,150);
  //point(385,150);
  //point(390,150);
  //point(395,150);
  //point(400,150);
  //point(405,150);
  //point(410,150);
  //point(415,150);
  //point(420,150);
  //point(425,150);
  //point(430,150);
  //-----------------------------
  //background(20);
  //colorMode(RGB, 255, redcolor, greencolor, bluecolor);
  //image(img, (width-controlPanelWidth)/4, 0, width/2, height/5);
  h += .1f;
  h = h % 360;
  limit =  map(mouseX, 0, width, PI/12, PI/7);
  fill(350);
  text(round(degrees(limit)), 15, 15);
  incr1 += 0.001f;
  for (float r = incr2; r < TWO_PI; r += incr2 ) { // r = 0; in Java (rounding issue?) 
    float ns = noise(incr1+r);
    float rads = map(ns, 0, 1, -limit, limit);

    float x = (width/1.4f) + (60 * cos(r));
    float y = (height/2) + (60 * sin(r));

    float sw = 0;
    if (rads <= 0) sw = map(rads, 0, -limit/3, 2, 0.1f);
    else sw = map(rads, 0, limit/3, 2, 0.1f) ;
    strokeWeight(abs(sw));
    stroke(redcolor, greencolor, bluecolor );
    pushMatrix();
    translate(x-300, y);
    rotate(r + PI/2);
    arm(width/50, rads);
    popMatrix();
  }
}
 public void arm(float len, float rds) {
  if (len > 5) {
    line(0, 0, 0, -len);
    translate(0, -len);
    rotate(rds);  
    arm(len*.9f, rds);
  }
}

public void function2(){
    //rect(0, 0, visualizerWidth, height);

    // Declarations & Instantiations
    float circleCount = 80;
    float centerPosX = (width - width/5)/2;
    float centerPosY = height/2;
    float diameter =  visualizerWidth * .04f;
    float radius  = diameter/2;
    float circ =  PI * diameter;
    float smallDiameter = (circ / circleCount);

    float angle, x, y;

    adjustedAmplitudeMagnitude = amplitudeMagnitude * 1000; // Max 5000
    adjustedFrequencyMagnitude = frequencyMagnitude * 25; // Max 50
    
    amplitude = (input.mix.get(1)* adjustedAmplitudeMagnitude);
    frequency = (fft.getBand(1) * adjustedFrequencyMagnitude);
    
    
    if(colorchange){
         color1 = PApplet.parseInt(redcolor);
         color2 = PApplet.parseInt(greencolor);
         color3 = PApplet.parseInt(bluecolor);
         colorchange = false;
    }
    

    fill(color1, color2, color3);

    // Fill Change Over Time
    if(millis() - time >= wait) {
      color1 += 10;
      color2 -= 5;

      // Resets
      if(color1 >= 255) { color1 = 0; }
      if(color2 <= 0) { color2 = 255; }
      if(color3 <= 0) { color3 = 255; }

      time = millis(); // Updates time
    }

    // Visualization
    for(int i = 1; i <= circleCount; ++i) {
      angle = i * TWO_PI / circleCount;
      x = centerPosX + cos(angle) * radius * amplitude;
      y = centerPosY + sin(angle) * radius * amplitude;
      ellipse(x, y, smallDiameter * frequency, smallDiameter * frequency);
    }
  }
  
    private void function3(){    
  for (int i = 0; i < ranges; i++) {
    float paint = map(i, 0, ranges, 0, 255);
    stroke(paint);    
    beginShape();
    for (int x = -10; x < width - width/5; x += 20) {
            fill(redcolor, greencolor, bluecolor);
            float n = noise(x * 0.001f, i * 0.01f, frameCount * 0.02f);
            float y = map(n, 0, 1, 0, height);
            vertex(x, y);
    }
    endShape();
    
  }
    }
    private void function4(){
    float angle,angle2,inc,waveX,waveY,a,x,y,w,x1,y1;
    float size;
    
    adjustedAmplitudeMagnitude = amplitudeMagnitude * 800; // Max 800
    adjustedFrequencyMagnitude = frequencyMagnitude * 800; // Max 800

    background(0);
    push();
    translate((width - width/5) / 2, height / 2);
    rotate(frameCount * 0.002f);
    for (int i = 0; i < 1200; i++) {
        angle = sin(i + frameCount * 0.002f) * 10;
        angle2 = cos(i + frameCount * 0.004f) * 650;

        inc = 85;
        waveX = map(sin(frameCount * 0.01f), -1, 1, -inc, inc);
        waveY = map(cos(frameCount * 0.01f), -1, 1, -inc, inc);

        a = -394;
        x = sin(radians(i)) * (angle2 + a) + waveX;
        y = cos(radians(i)) * (angle2 + a) + waveY;

        w = 860;
        x1 = sin(radians(i)) * (w / angle);
        y1 = cos(radians(i)) * (w / angle);
  
        fill(redcolor, greencolor, bluecolor);
        circle(x, y, 1);
        size = map(sin(i * frameCount * 0.0002f), -1, 1, 0, 4);
        circle(x1, y1, size);
    }
    pop();
  }
  
  //void pauseAll(){
  //  input.pause();
  //  input1.pause();
  //  input2.pause();
  //  //input3.pause();
  //  //input4.pause();
  //  //input5.pause();
  //}
  
  public void updateattributes(float amplitudeMagnitude, float frequencyMagnitude, float visualizationIndex, float musicNum) {
    this.amplitudeMagnitude = amplitudeMagnitude;
    this.frequencyMagnitude = frequencyMagnitude;
    this.visualizationIndex = (int) visualizationIndex;
    this.musicNum = (int) musicNum;
  }
  
   public void musicChooser(int musicNum){
    if(musicNum == 1 && addNew[1] == true){
        input.close();
        input = minim.loadFile("Hans Zimmer - Time.mp3");
        input.play();
        addNew[1] = false;
    }
    if(musicNum == 2 && addNew[2] == true){
        input.close();
        input = minim.loadFile("Tenet - Posterity.mp3");
        input.play();
        addNew[2] = false;
    }
    
    if(musicNum == 3 && addNew[3] == true){
        input.close();
        input = minim.loadFile("Heat Waves - Glass Animals.mp3");
        input.play();
        addNew[3] = false;
    }
    
    if(musicNum == 4 && addNew[4] == true){
        input.close();
        input = minim.loadFile("Godfather Theme.mp3");
        input.play();
        addNew[4] = false;
    }
    
    if(musicNum == 5 && addNew[5] == true){
        input.close();
        input = minim.loadFile("Mood - 24kGoldn.mp3");
        input.play();
        addNew[5] = false;
    }
    
    if(musicNum == 6 && addNew[6] == true){
        input.close();
        input = minim.loadFile("For You - Luna Luna.mp3");
        input.play();
        addNew[6] = false;   
    }
    
    if(musicNum == 7 && addNew[7] == true){
        input.close();
        input = minim.loadFile("My Love - Maye.mp3");
        input.play();
        addNew[7] = false;   
    }
    
    if(musicNum == 8 && addNew[8] == true){
        input.close();
        input = minim.loadFile("Closer - Saweetie.mp3");
        input.play();
        addNew[8] = false;   
    }
    
    if(musicNum == 9 && addNew[9] == true){
        input.close();
        input = minim.loadFile("La Luz - Kali Uchis.mp3");
        input.play();
        addNew[9] = false;   
    }
    
    if(musicNum == 10 && addNew[10] == true){
        input.close();
        input = minim.loadFile("Raindrops - GoldLink.mp3");
        input.play();
        addNew[10] = false;   
    }
    
    if(musicNum == 11 && addNew[11] == true){
        input.close();
        input = minim.loadFile("Mean it - Manila Killa and San Holo.mp3");
        input.play();
        addNew[11] = false;   
    }
    
    if(musicNum == 12 && addNew[12] == true){
        input.close();
        input = minim.loadFile("Find Our Way - Midnight Kids.mp3");
        input.play();
        addNew[12] = false;   
    }
    
    if(musicNum == 13 && addNew[13] == true){
        input.close();
        input = minim.loadFile("Sakura - Vexento.mp3");
        input.play();
        addNew[13] = false;   
    }
    
    if(musicNum == 14 && addNew[14] == true){
        input.close();
        input = minim.loadFile("Starlight - Jai Wolf.mp3");
        input.play();
        addNew[14] = false;   
    }
    
    if(musicNum == 15 && addNew[15] == true){
        input.close();
        input = minim.loadFile("High Hopes - Marion.mp3");
        input.play();
        addNew[15] = false;   
    }
    
    if(musicNum == 16 && addNew[16] == true){
        input.close();
        input = minim.loadFile("Dancing Queen - Abba.mp3");
        input.play();
        addNew[16] = false;   
    }
    
    if(musicNum == 17 && addNew[17] == true){
        input.close();
        input = minim.loadFile("Alive - Rufus.mp3");
        input.play();
        addNew[17] = false;   
    }
    
    if(musicNum == 18 && addNew[18] == true){
        input.close();
        input = minim.loadFile("Guns for Hire - Woodkid.mp3");
        input.play();
        addNew[18] = false;   
    }
    
    if(musicNum == 19 && addNew[19] == true){
        input.close();
        input = minim.loadFile("Line of Sight - Odesza.mp3");
        input.play();
        addNew[19] = false;   
    }
    
    if(musicNum == 20 && addNew[20] == true){
        input.close();
        input = minim.loadFile("Motherboard - Daft Punk.mp3");
        input.play();
        addNew[20] = false;   
    }
    
    if(musicNum == 21 && addNew[21] == true){
        input.close();
        input = minim.loadFile("Innerbloom - Rufus.mp3");
        input.play();
        addNew[21] = false;   
    }
    
    if(musicNum == 22 && addNew[22] == true){
        input.close();
        input = minim.loadFile("Messy Love- Mura Masa.mp3");
        input.play();
        addNew[22] = false;   
    }
    
    if(musicNum == 23 && addNew[23] == true){
        input.close();
        input = minim.loadFile("Pink + White - Frank Ocean.mp3");
        input.play();
        addNew[23] = false;   
    }
    
    if(musicNum == 24 && addNew[24] == true){
        input.close();
        input = minim.loadFile("Raingurl - Yaeji.mp3");
        input.play();
        addNew[24] = false;   
    }
    
    if(musicNum == 25 && addNew[25] == true){
        input.close();
        input = minim.loadFile("Mac Miller - Stay.mp3");
        input.play();
        addNew[25] = false;   
    }
    
    if(musicNum == 26 && addNew[26] == true){
        input.close();
        input = minim.loadFile("Going Bad - Meek Mill.mp3");
        input.play();
        addNew[26] = false;   
    }
  }
}
public class ControlPanel {
  ControlP5 cp5;
  Visualizer visualizer;

  int windowHeight;
  int windowWidth;
  int controlPanelWidth;
  int controlPanelPosX;
  int elementsPosX;
  int buttonWidth;
  int dimColor = color(0xFF000000);
  
  int highlightColor = color(0,150,250);
  int highlightColor2 = color(25,25,50);
  
  int forBg = color(5,5,15);
  int forG = color(25,25,50);
  int forBut = color(90,90,137);

  public ControlPanel(Visualizer visualizer, int windowHeight, int windowWidth, int controlPanelWidth, ControlP5 cp5) {
    this.visualizer = visualizer;
    this.cp5 = cp5;

    this.windowHeight = windowHeight;
    this.windowWidth = windowWidth;
    this.controlPanelWidth = controlPanelWidth;
    
    controlPanelWidth = width/5;
    controlPanelPosX = this.windowWidth - this.controlPanelWidth;
    elementsPosX = controlPanelPosX + width/50;
    buttonWidth = (controlPanelWidth - 75) / 2; // Half of element width - margin(15)

    cp5.setFont(new ControlFont(createFont("Arial", 10),10));

    // AmplitudeMagnitude
    cp5.addSlider("amplitude")
      .setLabel("")
      .setColorForeground(highlightColor)
      .setColorActive(highlightColor)
      .setColorBackground(dimColor)
      .setHeight(10)
      //.setPosition(controlPanelPosX + 30, 160)
      .setPosition(controlPanelPosX + 30, 160)
      .setRange(0, 1)
      .setWidth(controlPanelWidth - 60) // 2x margin
      .setValue(0.40f); // Default

    // FrequencyMagnitude
    cp5.addSlider("frequency")
      .setLabel("")
      .setColorActive(highlightColor)
      .setColorForeground(highlightColor)
      .setColorBackground(dimColor)
      .setHeight(10)
      .setPosition(controlPanelPosX + 30, 255)
      .setRange(0, 1)
      .setWidth(controlPanelWidth - 60) // 2x margin
      .setValue(0.50f); // Default
      
          //red color
    cp5.addSlider("redcolor")
      .setLabel("")
      .setColorActive(highlightColor)
      .setColorForeground(highlightColor)
      .setColorBackground(dimColor)
      .setHeight(10)
      .setPosition((width - width/4), 370)
      .setRange(0, 255)
      .setWidth((width - width/4)/15) // 2x margin
      .setValue(100); // Default
      
     cp5.addSlider("greencolor")
      .setLabel("")
      .setColorActive(highlightColor)
      .setColorForeground(highlightColor)
      .setColorBackground(dimColor)
      .setHeight(10)
      .setPosition((width - width/4) + width/12, 370)
      .setRange(0, 255)
      .setWidth((width - width/4)/15) // 2x margin
      .setValue(100); // Default
      
      
    cp5.addSlider("bluecolor")
      .setLabel("")
      .setColorActive(highlightColor)
      .setColorForeground(highlightColor)
      .setColorBackground(dimColor)
      .setHeight(10)
      .setPosition((width - width/4) + width/6, 370)
      .setRange(0, 255)
      .setWidth((width - width/4)/15) // 2x margin
      .setValue(100); // Default

    // Visualization
    RadioButton radioButton = cp5.addRadioButton("radioButton");
    radioButton
        .setColorBackground(dimColor)
        .setPosition(elementsPosX, 450)
        .setColorForeground(0xFF2B2B2B)
        .setColorActive(highlightColor)
        .setSize(25, 25)
        .setItemsPerRow(1)
        .setSpacingRow(10)
        .setLabelPadding(20, 20)
        .addItem("Welcome", 0)
        .addItem("Function # 1", 1)
        .addItem("Function # 2", 2)
        .addItem("Function # 3", 3)
        .activate(0);
  
    DropdownList Music_Changer = cp5.addDropdownList("Music_Changer");
    Music_Changer
        .setColorBackground(dimColor)
        .setPosition(elementsPosX+130, 460)
        .setColorForeground(0xFF2B2B2B)
        //.setSize(120,25)
        .setColorActive(highlightColor)
        .setOpen(false)
        .addItem("Current is okay", 0)
        .addItem("Hans Zimmer - Time", 1)
        .addItem("Tenet - Posterity", 2)
        .addItem("Heat Waves - Glass Animals", 3)
        .addItem("Godfather Theme", 4)
        .addItem("Mood - 24kGoldn", 5)
        .addItem("For You - Luna Luna", 6)
        .addItem("My Love - Maye", 7)
        .addItem("Closer - Saweetie", 8)
        .addItem("La Luz - Kali Uchis", 9)
        .addItem("Raindrops - GoldLink", 10)
        .addItem("Mean it - Manila Kila and San Holo", 11)
        .addItem("Find our Way - Midnight Kids", 12)
        .addItem("Sakura - Vexento", 13)
        .addItem("Starlight - Jai Wolf", 14)
        .addItem("High Hopes - Marion", 15)
        .addItem("Dancing Queen - Abba", 16)
        .addItem("Alive - Rufus", 17)
        .addItem("Guns for Hire - Woodkid", 18)
        .addItem("Line of Sight - Odesza", 19)
        .addItem("Motherboard - Daft Punk", 20)
        .addItem("Innerbloom - Rufus", 21)
        .addItem("Messy Love - Mura Masa", 22)
        .addItem("Pink + White - Frank Ocean", 23)
        .addItem("Raingurl - Yaeji", 24)
        .addItem("Mac Miller - Stay", 25)
        .addItem("Going Bad - Meek Mill", 26);
        
    // Buttons
    Button pause = cp5.addButton("pause");
    pause
      .activateBy(ControlP5.RELEASE)
      .setLabel("Pause")
      .setColorActive(highlightColor)
      .setColorBackground(highlightColor)
      .setColorForeground(highlightColor)
      .setPosition(elementsPosX, windowHeight - 130) // 60(margin) - 40(height)
      .setSize(buttonWidth, 40)
      .setValue(128);
    Button reset = cp5.addButton("reset");
    reset
      .activateBy(ControlP5.RELEASE)
      .setLabel("Reset")
      .setColorActive(highlightColor)
      .setColorBackground(highlightColor)
      .setColorForeground(highlightColor)
      .setPosition(elementsPosX + buttonWidth + 15, windowHeight - 130) // 60(margin) - 40(height)
      .setSize(buttonWidth, 40)
      .setValue(128);

    // Button style
    Label pauseLabel = pause.getCaptionLabel();
    pauseLabel.align(CENTER, CENTER);

    Label resetLabel = reset.getCaptionLabel();
    resetLabel.align(CENTER, CENTER);
  }


  public void draw() {
    fill(5,5,15);
    //rect(controlPanelPosX, 0, controlPanelWidth, windowHeight);
    rect(width - width/4, 0, width/4, height);

    /* Text (margin: 60, 30) */

    // Title
    myFont1 = createFont("Lucida Calligraphy Italic", 32);
    myFont2 = createFont("Segoe Print", 32);
    textFont(myFont1,35);
    textAlign(CENTER);
    textSize(20);
    fill(255, 255, 255);
    
    text("K-WAi-audioVisualizer", controlPanelPosX + (controlPanelWidth/2), 60);

    // Subhead
    textAlign(LEFT);
    fill(206, 206, 206);

    textSize(16);
    text("Amplitude Magnifier", elementsPosX, 120);
    textSize(12);
    text("Magnify the amplitude of the audio", elementsPosX, 140);

    textSize(16);
    text("Frequency Magnifier", elementsPosX, 215);
    textSize(12);
    text("Magnify the frequency of the audio", elementsPosX, 235);


    textSize(16);
    text("Color Selector", elementsPosX, 315);
    textSize(12);
    text("Change the color of the visualizations!", elementsPosX, 335);
    
    textSize(14);
    fill(255,0,0);
    text("RED",elementsPosX,365);
    
    fill(0,255,0);
    //ghtn
    text("GREEN",elementsPosX + width/12,365);
    
    fill(0,0,255);
    text("BLUE", elementsPosX + width/6, 365);
    
    
    fill(0xFFFFFFFF);
    textSize(12);
    text("Visualization Selector", elementsPosX, 410);
    textSize(10);
    text("Visualize music", elementsPosX, 435);
    
    textSize(12);
    text("Music Selector",elementsPosX + 150, 410);
    textSize(10);
    text("Pick the music of your choice", elementsPosX + 130, 435);

    textSize(16);
    text("Instructions", elementsPosX, 610);
    textSize(10);
    text("- Choose the audio of your choice!", elementsPosX, 630);
    text("- Choose one of the visualizer functions", elementsPosX, 650);
    text("- Play around with the colors!", elementsPosX, 670);
    text("- Play around with the amplitude/frequency", elementsPosX, 690);
    text("- Sit back and enjoy :) ", elementsPosX, 710);

  }

  /* Updates values without needing refresh */
  public void mouseEvent() {
    float amplitudeMagnitude = cp5.get(Slider.class, "amplitude").getValue();
    float frequencyMagnitude = cp5.get(Slider.class, "frequency").getValue();
    float visualizationIndex = cp5.get(RadioButton.class, "radioButton").getValue();
    float redcolor = cp5.get(Slider.class, "redcolor").getValue();
    float greencolor = cp5.get(Slider.class, "greencolor").getValue();
    float bluecolor = cp5.get(Slider.class, "bluecolor").getValue();
    musicNum = (int) cp5.get(DropdownList.class, "Music_Changer").getValue();
    visualizer.updateattributes(amplitudeMagnitude, frequencyMagnitude, visualizationIndex, musicNum);
  }
}


  public void settings() { fullScreen(P3D);
smooth(); }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "my_audio_visualizer" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
