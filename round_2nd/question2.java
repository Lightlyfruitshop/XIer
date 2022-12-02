package round_2nd;

import java.util.Scanner;
import java.util.regex.Pattern;

public class question2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        Pattern jug = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
        if (jug.matcher(scn.next()).matches()) {
            System.out.println("OK");
        } else System.out.println("ERROR");
    }
}