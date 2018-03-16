import org.junit.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

import View.LoveView;
import View.Person;

public class PersonTest {
  Person xuDianDian = new Person("许墨·点点莹光",17,454, 15, 589, 527);

  Person zhouWeiZhuangZhe = new Person("周·伪装者",16,367, 13, 453, 478);

  Person liQingBuZiJin = new Person("李·情不自禁",16, 13, 390, 472, 435);

  Person xuJiLu = new Person("许·记录",14, 12, 528, 436, 203);

  Person liShiJianZhangKongZhe = new Person("李·时间掌控者",14, 504, 196, 12, 467);

  Person zhouDuJiaDingZhi = new Person("周·独家定制",13, 11, 466, 446, 193);

  Person liBingShanQiChang = new Person("李·冰山气场",12, 417, 292, 10, 330);

  Person liXinLingBoYi = new Person("李·心灵博奕",12, 408, 448, 10, 183);

  Person xuDuNi = new Person("许·读你",10, 279, 9, 319, 312);

  final Person zhouRuMian = new Person("周·入眠",4, 149, 5, 147, 185);

  List<Person> persons = new ArrayList<Person>(Arrays.asList(xuDianDian, zhouWeiZhuangZhe,
          liQingBuZiJin, xuJiLu, liShiJianZhangKongZhe, zhouDuJiaDingZhi, liBingShanQiChang,
          liXinLingBoYi, xuDuNi, zhouRuMian));

  @Test
  public void qinHeJueCe() {
    zhouRuMian.updateLevel(3, 3, 3, 3);
    System.out.println(zhouRuMian.getBlue());
//    System.out.println(xuDianDian.cal(0.53, 0.45, 0.55, 0.47));
//    System.out.println(zhouWeiZhuangZhe.cal(0.53, 0.45, 0.55, 0.47));
//    System.out.println(xuJiLu.cal(0.53, 0.45, 0.55, 0.47));
//    System.out.println(liShiJianZhangKongZhe.cal(0.53, 0.45, 0.55, 0.47));
//    System.out.println(zhouDuJiaDingZhi.cal(0.53, 0.45, 0.55, 0.47));
//    System.out.println(liQingBuZiJin.cal(0.53, 0.45, 0.55, 0.47));
//    System.out.println(liBingShanQiChang.cal(0.53, 0.45, 0.55, 0.47));
//    System.out.println(liXinLingBoYi.cal(0.53, 0.45, 0.55, 0.47));
//    System.out.println(xuDuNi.cal(0.53, 0.45, 0.55, 0.47));
  }

  @Test
  public void qinHeChuangZao() {
    System.out.println(xuDianDian.cal(0.47, 0.53, 0.55, 0.45));
    System.out.println(zhouWeiZhuangZhe.cal(0.47, 0.53, 0.55, 0.45));
    System.out.println(xuJiLu.cal(0.47, 0.53, 0.55, 0.45));
    System.out.println(liShiJianZhangKongZhe.cal(0.47, 0.53, 0.55, 0.45));
    System.out.println(zhouDuJiaDingZhi.cal(0.47, 0.53, 0.55, 0.45));
    System.out.println(liQingBuZiJin.cal(0.47, 0.53, 0.55, 0.45));
    System.out.println(liBingShanQiChang.cal(0.47, 0.53, 0.55, 0.45));
    System.out.println(liXinLingBoYi.cal(0.47, 0.53, 0.55, 0.45));
    System.out.println(xuDuNi.cal(0.47, 0.53, 0.55, 0.45));
  }

  @Test
  public void main() {
    String s = "Person: blabal";
    Scanner sc = new Scanner(s);
    System.out.println(sc.next());
  }


}
