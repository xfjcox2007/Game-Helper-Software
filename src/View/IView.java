package View;

import java.util.List;

public interface IView {

  void updatePersonInfoArea(Person p);

  /**
   * based on the params, to calculate each person's score and list them from the strongest to
   * weakest
   * @param b the blue attribute
   * @param y the yellow attribute
   * @param p the pink attribute
   * @param g the green attribute
   */
  void outputCalculation(double b, double y, double p, double g);

  /**
   * output the updated person in string format
   * @return updated persons' info
   */
  String updatedPersonsInfo();

  /**
   * get as much person's score as possible to approach the goal set up
   * @param goal we want to approach
   */
  String approachTheGoal(int goal);
}
