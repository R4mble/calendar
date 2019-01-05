package learn;

import calendar.util.KeyCode;

import java.awt.AWTException;
import java.awt.Robot;

public class Test {

     static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public Test() throws AWTException {
    }

    public static void main(String[] args) throws AWTException {
        start();
//        start2();
//        step();
    }

        public static void start() {

            for (int j = 0; j < 9; j++) {
                for (int i = 0; i < 50; i++) {
                    robot.keyPress(KeyCode.Down);
                    robot.keyPress(KeyCode.Right);
                }
                robot.keyPress(KeyCode.Left);
            }

            for (int i = 0; i < 5; i++) {
                robot.keyPress(KeyCode.Right);
                robot.keyPress(KeyCode.Down);
            }
        }

    public static void start2() {

        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 50; i++) {
                robot.keyPress(KeyCode.Down);
                robot.keyPress(KeyCode.Right);
                robot.keyPress(KeyCode.Left);
            }
        }
    }


    public static void step() {
            for (int i = 0; i < 50; i++) {
                robot.keyPress(KeyCode.Down);
                robot.keyPress(KeyCode.Right);
            }
        }


    }
