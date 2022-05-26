package aq.koptev.level1.lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final String HUMAN_STEP = "X";
    private static final String COMPUTER_STEP = "O";
    private static final String EMPTY_POSITION = "*";
    private static final String WINNER_HUMAN_MSG = "Поздравляем! Вы победили!";
    private static final String WINNER_COMPUTER_MSG = "Победил компьютер!";
    private static final String REPLAY_MSG = "Сыграть еще раз? Y/N";
    private static final String HORIZONTAL_ENTER_MSG = "Введиет номер горизонтальной ячейки: ";
    private static final String VERTICAL_ENTER_MSG = "Введиет номер вертикальной ячейки: ";
    private static final String SIZE_GAME_MAP_MSG = "Введите размер игрового поля (размер больше или равен 3): ";
    private static final String WRONG_FORMAT_MSG = "Неверный формат введенных данных!";
    private static final String RECOMMEND_FORMAT_SIZE_GAME_MAP_MSG = "Введите положительное целое число, больше нуля и меньше либо равное ";

    private static String[][] gameMap;

    private static int countStep = 0;
    private static int sizeGameMap = 0;
    private static int xHuman = 0;
    private static int yHuman = 0;
    private static int xComputer = 0;
    private static int yComputer = 0;
    private static int winStepCount = 0;

    private static Scanner scanner;
    private static Random random = new Random();

    public static void main(String[] args) {

        startGame();
    }

    private static void startGame() {

        getReadyGame();
        playGame();
    }
    private static void getReadyGame() {

        if(scanner == null)  {

            scanner = new Scanner(System.in);
        }

        initSizeMap();
        initGameMap();
        initCountSteps();
        printGameMap();
    }

    private static void playGame() {

        while(true) {

            humanStep();
            printGameMap();
            if(isEndGame(xHuman, yHuman, HUMAN_STEP)) {

                if(isReplay()) {

                    getReadyGame();
                    continue;
                } else {

                    scanner.close();
                    break;
                }
            }

            computerStep();
            printGameMap();
            if(isEndGame(xComputer, yComputer, COMPUTER_STEP)) {

                if(isReplay()) {

                    getReadyGame();
                    continue;
                } else {

                    scanner.close();
                    break;
                }
            }
        }
    }

    private static void humanStep() {

        while(true) {

            System.out.println(HORIZONTAL_ENTER_MSG);
            xHuman = getHumanEnter();
            System.out.println(VERTICAL_ENTER_MSG);
            yHuman = getHumanEnter();

            if(!isValidCell(xHuman, yHuman)) {

                System.out.println("Ячейка с координатами [" + (xHuman + 1) + ": " + (yHuman + 1) + "] + уже занята!" );
            } else {

                gameMap[xHuman][yHuman] = HUMAN_STEP;
                countStep--;
                break;
            }
        }
    }

    private static void computerStep() {

        do {

            xComputer = random.nextInt(sizeGameMap);
            yComputer = random.nextInt(sizeGameMap);
        } while (!isValidCell(xComputer, yComputer));

        gameMap[xComputer][yComputer] = COMPUTER_STEP;
        countStep--;
    }

    private static void endGameMessage(String step) {

        if(step.equals(HUMAN_STEP)) {

            System.out.println(WINNER_HUMAN_MSG);
            System.out.println(REPLAY_MSG);
        } else {

            System.out.println(WINNER_COMPUTER_MSG);
            System.out.println(REPLAY_MSG);
        }
    }

    private static void printGameMap() {

        System.out.print("  ");
        for(int i = 0; i < sizeGameMap; i++) {

            System.out.print(i + 1 + " ");
        }

        System.out.println();

        for (int i = 0; i < sizeGameMap; i++) {

            System.out.print(i + 1 + " ");
            for (int j = 0; j < sizeGameMap; j++) {

                System.out.print(gameMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void initGameMap() {

        gameMap = new String[sizeGameMap][sizeGameMap];

        for(int i = 0; i < sizeGameMap; i++) {

            for(int j = 0; j < sizeGameMap; j++) {

                gameMap[i][j] = EMPTY_POSITION;
            }
        }
    }

    private static void initSizeMap() {

        do {
            System.out.print(SIZE_GAME_MAP_MSG);
            while (!scanner.hasNextInt()) {

                System.out.println(WRONG_FORMAT_MSG);
                System.out.print(SIZE_GAME_MAP_MSG);
                scanner.next();
            }

            sizeGameMap = scanner.nextInt();
        } while(sizeGameMap < 3);

        if(sizeGameMap >= 3 && sizeGameMap < 5) {

            winStepCount = 3;
        } else {

            winStepCount = 5;
        }
    }

    private static boolean isReplay() {

        String msg = scanner.next();

        switch (msg) {

            case "Y", "y", "Yes", "yes", "YES", "да", "Да", "ДА", "+" :
                return true;
            default:
                return false;
        }
    }

    private static boolean isEndGame(int x_pos, int y_pos, String step) {

        if(countStep == 0) {

            if(isHorizontalWin(x_pos, step)) {

                endGameMessage(step);
                return true;
            }

            if(isVerticalWin(y_pos, step)) {

                endGameMessage(step);
                return true;
            }

            if(isDiagonalWin(x_pos, y_pos, step)) {

                endGameMessage(step);
                return true;
            }

            System.out.println("Ничья!");
            System.out.println(REPLAY_MSG);
            return true;
        } else {

            if(isHorizontalWin(x_pos, step)) {

                endGameMessage(step);
                return true;
            }

            if(isVerticalWin(y_pos, step)) {

                endGameMessage(step);
                return true;
            }

            if(isDiagonalWin(x_pos, y_pos, step)) {

                endGameMessage(step);
                return true;
            }
        }

        return false;
    }

    private static boolean isHorizontalWin(int xPos, String stepSymbol) {

        int stepCount = 0;

        for(int i = 0; i < sizeGameMap; i++) {

            if(gameMap[xPos][i].equals(stepSymbol)) {

                stepCount++;

                if(stepCount == winStepCount) {

                    return true;
                }
            } else {

                return false;
            }
        }

        return stepCount == winStepCount;
    }

    private static boolean isVerticalWin(int  yPos, String stepSymbol) {

        int stepCount = 0;

        for(int i = 0; i < sizeGameMap; i++) {

            if(gameMap[i][yPos].equals(stepSymbol)) {

                stepCount++;

                if(stepCount == winStepCount) {

                    return true;
                }
            } else {

                return false;
            }
        }

        return stepCount == winStepCount;
    }

    private static boolean isDiagonalWin(int xPos, int  yPos, String stepSymbol) {


        if(isDiagonalRightToLeft(xPos, yPos, stepSymbol)) {

            return true;
        }

        if(isDiagonalLeftToRight(xPos, yPos, stepSymbol)) {

            return true;
        }

        return false;
    }

    private static boolean isDiagonalRightToLeft(int xPos, int yPos, String stepSymbol) {

        int stepCount = 0;

        while (xPos < sizeGameMap && yPos < sizeGameMap && gameMap[xPos][yPos].equals(stepSymbol)) {

            xPos++;
            yPos++;
        }

        for(int i = xPos - 1; i >= 0; i--) {

            for(int j = yPos - 1; j >= 0; j--) {

                if(i == j) {

                    if(gameMap[i][j].equals(stepSymbol)) {

                        stepCount++;

                        if(stepCount == winStepCount) {

                            return true;
                        }
                    } else {

                        return false;
                    }
                }
            }
        }

        return stepCount == winStepCount;
    }

    private static boolean isDiagonalLeftToRight(int xPos, int  yPos, String stepSymbol) {

        int stepCount = 0;

        while (xPos < sizeGameMap && yPos > 0 && gameMap[xPos][yPos].equals(stepSymbol)) {

            xPos++;
            yPos--;
        }

        for(int i = xPos; i >= 0; i--) {

            for(int j = yPos; j < sizeGameMap; j++) {

                if(i + j + 1 == sizeGameMap) {

                    if (gameMap[i][j].equals(stepSymbol)) {

                        stepCount++;

                        if (stepCount == winStepCount) {

                            return true;
                        }
                    } else {

                        return false;
                    }
                }
            }
        }

        return stepCount == winStepCount;
    }

    private static boolean isValidCell(int xPos, int yPos) {

        return gameMap[xPos][yPos].equals(EMPTY_POSITION);
    }

    private static int getHumanEnter() {

        int cell = 0;

        while (true) {

            while (!scanner.hasNextInt()) {

                System.out.println(WRONG_FORMAT_MSG);
                System.out.println(RECOMMEND_FORMAT_SIZE_GAME_MAP_MSG + sizeGameMap);
                scanner.next();
            }

            cell = scanner.nextInt();

            if(cell > 0 && cell <= sizeGameMap) {

                return cell - 1;
            } else {

                System.out.println(RECOMMEND_FORMAT_SIZE_GAME_MAP_MSG + sizeGameMap);
            }
        }
    }

    private static int initCountSteps() {

        return countStep = sizeGameMap * sizeGameMap;
    }
}
