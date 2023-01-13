package round_3;

import round_3.object.*;

import java.util.Scanner;

public class system {

    public static void main(String[] args) {
        //虽然程序里也可以建但是我默认已经建好表了，用户名root，密码123456，要改的话在属性文件里改
        Scanner scn = new Scanner(System.in);
        outer:while (true) {
            System.out.println("输入数字选择操作对象\n1\t学生\n2\t班级\n3\t进入事件\n其他\t退出");
            int jug = 0;
            int num = scn.nextInt();
            switch (num){
                case 1:
                    while (jug == 0) {
                        System.out.println("输入数字选择操作\n1\t添加\n2\t删除\n其他\t退出");
                        num = scn.nextInt();
                        if (num == 1) {
                            System.out.println("请输入SID，名字，性别，年级");
                            jug = Students.insert(scn.nextInt(), scn.next(), scn.next(), scn.nextInt());
                        } else if (num == 2) {
                            System.out.println("请输入SID");
                            jug = Students.delete(scn.nextInt());
                        }else break;
                        if (jug == 0) {
                            System.out.println("更新失败");
                        }
                    }
                    break;
                case 2:
                    while (jug == 0) {
                        System.out.println("输入数字选择操作\n1\t添加\n2\t删除\n其他\t退出");
                        num = scn.nextInt();
                        if (num == 1) {
                            System.out.println("请输入CID");
                            jug = Classes.insert(scn.nextInt());
                        } else if (num == 2) {
                            System.out.println("请输入CID");
                            jug = Classes.delete(scn.nextInt());
                        }else break;
                        if (jug == 0) {
                            System.out.println("更新失败");
                        }
                    }
                    break;
                case 3:
                    while (jug == 0) {
                        System.out.println("输入数字选择操作\n1\t添加\n2\t删除\n其他\t退出");
                        num = scn.nextInt();
                        if (num == 1) {
                            System.out.println("请输入CID, SID, 日期");
                            jug = Entry.insert(scn.nextInt(), scn.nextInt(), scn.next());
                        } else if (num == 2) {
                            System.out.println("请输入CID，SID，日期");
                            jug = Entry.delete(scn.nextInt(), scn.nextInt(), scn.next());
                        }else break;
                        if (jug == 0) {
                            System.out.println("更新失败");
                        }
                    }
                    break;
                default:
                    break outer;
            }
            if (jug != 0) {
                System.out.println("更新成功");
            }
        }
    }
}
