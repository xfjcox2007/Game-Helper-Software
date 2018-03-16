package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

import util.WindowBuilder;


public class LoveView extends JFrame implements IView {
  private List<Person> persons;
  private Person currentPerson;

  private JPanel mainPanel;

  private JTextArea personInfo;
  private JButton updateLevel;
  private JTextField textField;


  public LoveView(List<Person> persons) {
    super();
    this.persons = persons;
    this.currentPerson = persons.get(0);

    this.setTitle("恋与制作人帮助器");
    this.setSize(1000, 1000);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());

    //main panel
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    mainPanel.setPreferredSize(new Dimension(800, 500));
    this.add(mainPanel, BorderLayout.CENTER);

    //center panel
    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new BorderLayout());
    centerPanel.setPreferredSize(new Dimension(700, 400));
    mainPanel.add(centerPanel, BorderLayout.CENTER);

    personInfo = new JTextArea();
    centerPanel.add(personInfo);

    //left side panel for persons
    JPanel leftSidePanel = new JPanel();
    leftSidePanel.setLayout(new FlowLayout());
    leftSidePanel.setBorder(BorderFactory.createTitledBorder("List of Person"));
    leftSidePanel.setPreferredSize(new Dimension(150, 400));
    //mainPanel.add(leftSidePanel, BorderLayout.WEST);


    //left side -- list of persons
    for (Person p: persons) {
      JButton d = new JButton(p.getName());
      d.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          personInfo.setText(p.toString());
          currentPerson = p;
        }
      });
      leftSidePanel.add(d);
    }

    JScrollPane scrollPane = new JScrollPane(leftSidePanel);
    mainPanel.add(scrollPane, BorderLayout.WEST);

    //right side panel
    JPanel rightSidePanel = new JPanel();
    rightSidePanel.setPreferredSize(new Dimension(200, 400));
    mainPanel.add(rightSidePanel, BorderLayout.EAST);

    //right side -- weight
    JTextField weightBlue = new JTextField(10);
    weightBlue.setBorder(BorderFactory.createTitledBorder("Weight For Blue"));
    rightSidePanel.add(weightBlue);

    JTextField weightY = new JTextField(10);
    weightY.setBorder(BorderFactory.createTitledBorder("Weight For Yellow"));
    rightSidePanel.add(weightY);

    JTextField weightP = new JTextField(10);
    weightP.setBorder(BorderFactory.createTitledBorder("Weight For Pink"));
    rightSidePanel.add(weightP);

    JTextField weightG = new JTextField(10);
    weightG.setBorder(BorderFactory.createTitledBorder("Weight For Green"));
    rightSidePanel.add(weightG);

    JButton calculate = new JButton("Calculate");
    calculate.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Scanner sb = new Scanner(weightBlue.getText());
        Scanner sy = new Scanner(weightY.getText());
        Scanner sp = new Scanner(weightP.getText());
        Scanner sg = new Scanner(weightG.getText());
        double blue, yellow, pink, green;
        while (sg.hasNext()) {
          blue = sb.nextDouble();
          yellow = sy.nextDouble();
          pink = sp.nextDouble();
          green = sg.nextDouble();
          outputCalculation(blue, yellow, pink, green);
        }
      }
    });

    rightSidePanel.add(calculate);

    //button panel
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    buttonPanel.setPreferredSize(new Dimension(500, 100));
    mainPanel.add(buttonPanel, BorderLayout.PAGE_END);

    //button panel -- test field for update infor
    textField = new JTextField(15);
    textField.setBorder(BorderFactory.createTitledBorder("Update Information"));
    buttonPanel.add(textField, BorderLayout.WEST);

    //button panel -- update level button
    updateLevel = new JButton("update");
    updateLevel.setSize(new Dimension(5, 5));
    updateLevel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Scanner scanner = new Scanner(textField.getText());
        int b = 0;
        int y = 0;
        int p = 0;
        int g = 0;
        int counter = 0;
        while (scanner.hasNext()) {
          if (counter == 0) {
            b = scanner.nextInt();
            counter ++;
          }
          if (counter == 1) {
            y = scanner.nextInt();
            counter++;
          }
          if (counter == 2) {
            p = scanner.nextInt();
            counter++;
          }
          if (counter == 3) {
            g = scanner.nextInt();
            counter++;
          }
          if (counter == 4) {
            currentPerson.updateLevel(b, y, p, g);
            updatePersonInfoArea(currentPerson);
            textField.setText("");
            counter = 0;
          }
        }
      }
    });
    buttonPanel.add(updateLevel);

    //button panel -- export button
    JButton export = new JButton("Export");
    export.addActionListener((ActionEvent e) -> {
      File out = new File("out.txt");
      try {
        FileWriter fileWriter = new FileWriter(out);
        fileWriter.write(updatedPersonsInfo());
        fileWriter.flush();
        fileWriter.close();
      } catch (IOException e1) {
        e1.printStackTrace();
      }
    });
    buttonPanel.add(export);

    //button panel -- exit button
    JButton exit = new JButton("Exit");
    exit.addActionListener((ActionEvent e) -> {
      System.exit(0);
    });
    buttonPanel.add(exit);


    this.pack();
    this.setVisible(true);
  }

  @Override
  public void updatePersonInfoArea(Person p) {
    personInfo.setText(p.toString());
  }

  @Override
  public void outputCalculation(double b, double y, double p, double g) {
    personInfo.setText("");

    List<Integer> results = new ArrayList<Integer>();
    HashMap<Integer, String> temp = new HashMap<>();
    for (Person person: persons) {
      int result = person.cal(b, y, p, g);
      results.add(result);
      temp.put(result, person.getName());
    }

    Collections.sort(results);
    Collections.reverse(results);


    for (int i = 0; i < results.size(); i++) {
      personInfo.append(temp.get(results.get(i)) + ": " + results.get(i) + "\n");
    }

  }

  @Override
  public String updatedPersonsInfo() {
    String s = "";
    String stringforArray = "List<Person> person = new ArrayList<Person>(Arrays.asList(";
    for (Person person: persons) {
      Scanner scanner = new Scanner(person.updatedPersonInfo());
      s = s + person.updatedPersonInfo();
    }
    return s;
  }



}
