package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class TextFileReader {

  public <T> T readFile(String fileName, WindowBuilder<T> builder) throws FileNotFoundException,
          IllegalArgumentException, InputMismatchException {
    Scanner scanner;

    scanner = new Scanner(new FileInputStream(fileName));

    while (scanner.hasNext()) {
      String command = scanner.next();

      PersonInfo personInfo1;
      if (scanner.next().equals("Person")) {
        PersonInfo personInfo = readPersonInfo(scanner);
        builder.addPerson(personInfo.getName(), personInfo.getLevel(), personInfo.getBlue(),
                personInfo.getYellow(), personInfo.getPink(), personInfo.getGreen());
      } else {
        throw new IllegalStateException("Undefined toke" + command);
      }

    }


    return builder.build();

  }

  private PersonInfo readPersonInfo(Scanner sc) throws IllegalArgumentException, InputMismatchException {
    PersonInfo personInfo = new PersonInfo();

    while(!personInfo.isAllInitalized()) {
      String command = sc.next();
      switch (command) {
        case "name":
          personInfo.setName(sc.next());
          break;
        case "level":
          personInfo.setLevel(sc.nextInt());
          break;
        case "blue":
          personInfo.setBlue(sc.nextInt());
          break;
        case "yellow":
          personInfo.setYellow(sc.nextInt());
          break;
        case "pink":
          personInfo.setPink(sc.nextInt());
          break;
        case "green":
          personInfo.setGreen(sc.nextInt());
          break;
        default: throw new IllegalArgumentException("Invalid attribute" + command);
      }
    }

    return personInfo;
  }

  class PersonInfo {
    private String name;
    private int level, blue, yellow, pink, green;
    private Map<String, Boolean> valueFlags;

    public PersonInfo() {
      valueFlags = new HashMap<String, Boolean>();
      valueFlags.put("name", false);
      valueFlags.put("level", false);
      valueFlags.put("blue", false);
      valueFlags.put("yellow", false);
      valueFlags.put("pink", false);
      valueFlags.put("green", false);
    }

    public boolean isAllInitalized() {
      for (Map.Entry<String, Boolean> entry : valueFlags.entrySet()){
        if (!entry.getValue()) {
          return false;
        }
      }
      return true;
    }

    void setName(String name) {
      this.name = name;
      valueFlags.replace("name", true);
    }

    void setLevel(int level) {
      this.level = level;
      valueFlags.replace("level", true);
    }

    void setBlue(int blue) {
      this.blue = blue;
      valueFlags.replace("blue", true);
    }

    void setYellow(int yellow) {
      this.yellow = yellow;
      valueFlags.replace("yellow", true);
    }

    void setPink(int pink) {
      this.pink = pink;
      valueFlags.replace("pink", true);
    }

    void setGreen(int green) {
      this.green = green;
      valueFlags.replace("green", true);
    }

    public String getName() {
      return name;
    }

    public int getLevel() {
      return level;
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
  }


}
