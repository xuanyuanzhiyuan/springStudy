package java7study;

import java.io.*;

/**
 * User: jinyanhua
 * Date: 13-10-22
 * Time: 上午9:20
 */
public class NewGrammarDemo {
    public static void main(String[] args) {
        NewGrammarDemo java7demo = new NewGrammarDemo();
        java7demo.showNewStringSwitch("A");
        java7demo.numberInUnderscore();
        java7demo.tryWithResource();

    }

    public void showNewStringSwitch(String flag){
        switch (flag){
            case "A":
                System.out.println("you choose A");
                break;
            case "B" :
                System.out.printf("you choose B");
                break;
            default:
                System.out.printf("the default!");

        }
    }

    public void numberInUnderscore(){
        int a = 900_099_434;
        int b = 0b11100011010101010;
        System.out.println(a);
        System.out.println(b);
    }

    public void tryWithResource(){
        try(InputStream is = new FileInputStream(new File("/Users/admin/test.txt"))){
            int c;
            StringBuilder content = new StringBuilder();
            while((c=is.read())!=-1){
                content.append((char)c);
            }
            System.out.println(content.toString());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
