package View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person {
  private String name;
  private int level;
  private int blue;
  private int yellow;
  private int pink;
  private int green;

  //add new functionality
  private String firstSkill;
  private String secondSkill;

  public Person(String name, int level, int blue, int yellow, int pink, int green) {
    this.name = name;
    this.level = level;
    this.blue = blue;
    this.yellow = yellow;
    this.pink = pink;
    this.green = green;
  }


  // calculate the points
  public int cal(double blue, double yellow, double pink, double green) {
    return (int) (this.blue * blue + this.yellow * yellow + this.pink * pink + this.green * green);
  }


  public void updateLevel(int blueAdd, int yellowAdd, int pinkAdd, int greenAdd) {
    this.level++;
    if (blueAdd >= 100 || yellowAdd >= 100 || pinkAdd >= 100 || greenAdd >= 100) {
      this.blue = blueAdd;
      this.yellow = yellowAdd;
      this.pink = pinkAdd;
      this.green = greenAdd;
    } else {
      this.blue = blue + blueAdd;
      this.yellow = yellow + yellowAdd;
      this.pink = pink + pinkAdd;
      this.green = green + greenAdd;
    }
  }

  public String getName() {
    return name;
  }

  public int getBlue() {
    return blue;
  }

  public int getYellow() {
    return yellow;
  }

  public int getPink() {
    return pink;
  }

  public int getGreen() {
    return green;
  }

  public int getLevel() {
    return level;
  }

  @Override
  public String toString() {
    String s = "";
    s = s + "Name: " + this.name + "\n Level: " + this.level + "\n Blue: " + this.blue +
            "\n Yellow: " + this.yellow + "\n Pink: " + this.pink + "\n Green: " + this.green;
    return s;
  }

  public String updatedPersonInfo() {
    String s = "";
    if (this.name.contains("许墨")) {
      s = s + "Person xuMo";
    } else if (this.name.contains("周棋洛")) {
      s = s + "Person zhouQiLuo";
    } else if (this.name.contains("李泽言")) {
      s = s + "Person liZeYan";
    } else if (this.name.contains("白起")) {
      s = s + "Person baiQi";
    }

    s = s + +this.level + this.blue + " = new Person(\"" + name + "\", " + level + ", "
            + blue + ", " + yellow + ", " + pink + ", " + green + ");\n";

    return s;
  }

  public void getFirstSkill() {
    List<Integer> skills = new ArrayList<>(Arrays.asList(blue, yellow, pink, green));
    Collections.sort(skills, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        if (o1 > o2) {
          return 1;
        }
        if (o1 == o2) {
          return 0;
        } else {
          return -1;
        }
      }
    });
  }
}


