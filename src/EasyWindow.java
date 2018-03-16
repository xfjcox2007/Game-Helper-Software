import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import View.IView;
import View.LoveView;
import View.Person;

public final class EasyWindow {

  public static void main(String[] args) {
    Person xuDianDian = new Person("许墨·点点莹光",18,474, 15, 614, 550);

    Person baiZhuoZhuo = new Person("白起·灼灼光芒", 16, 15, 454, 533, 514);

    Person baiJiZhan = new Person("白起·激战", 16, 145, 155, 14, 1201);

    Person zhouLuo = new Person("周棋洛·落雪时光", 13, 12, 387, 437, 474);

    Person zhouDuJiaDingZhi = new Person("周棋洛·独家定制",18, 14, 601, 576, 248);

    Person zhouWeiZhuangZhe = new Person("周棋洛·伪装者",16,367, 13, 453, 478);

    Person xuJiLu = new Person("许墨·记录",17, 14, 615, 509, 237);

    Person liQingBuZiJin = new Person("李泽言·情不自禁",16, 13, 390, 472, 435);

    Person liShiJianZhangKongZhe = new Person("李泽言·时间掌控者",14, 504, 196, 12, 467);


    Person liBingShanQiChang = new Person("李泽言·冰山气场",12, 417, 292, 10, 330);
    Person liXinLingBoYi = new Person("李泽言·心灵博奕",12, 408, 448, 10, 183);
    Person xuDuNi = new Person("许墨·读你",10, 279, 9, 319, 312);
    Person zhouRuMian = new Person("周棋洛·入眠",10, 281, 9, 278, 351);

    Person zhouNiDeYangZi = new Person("周棋洛·你的样子", 10, 8, 255, 312, 236);

    Person xuJingJingDengDai = new Person("许墨·静静等待", 10, 230, 8, 279, 294);

    List<Person> person = new ArrayList<Person>(Arrays.asList(xuDianDian, baiZhuoZhuo, baiJiZhan, zhouWeiZhuangZhe,
            liQingBuZiJin, zhouLuo, xuJiLu, liShiJianZhangKongZhe, zhouDuJiaDingZhi, liBingShanQiChang,
            liXinLingBoYi, xuDuNi, zhouRuMian, zhouNiDeYangZi, xuJingJingDengDai));

    IView view = new LoveView(person);


  }
}
