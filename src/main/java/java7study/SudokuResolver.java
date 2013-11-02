package java7study;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * User: jinyanhua
 * Date: 13-11-1
 * Time: 上午9:38
 */
public class SudokuResolver {

    private final int[][] puzzle;

    public SudokuResolver(int[][] puzzle) {
        this.puzzle = puzzle;
    }

    public int [][] resuolve(){
        int [][] temp = new int[9][9];
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                temp[i][j] = puzzle[i][j];
            }
        }
        while(!isAllGridHasNumber(temp)){
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[i].length; j++) {
                    if(temp[i][j]==0){
                        temp[i][j] = checkUniqueNumbers(i, j, temp);
                        if(temp[i][j]==0){
                            temp[i][j] = checkUniqueGrid(i,j,temp);
                        }
                    }
                }
            }
            printResult(temp);
            System.out.println("==================================");
        }
        return temp;
    }

    private int checkUniqueNumbers(int i, int j, int[][] numbers) {
        int result = 0;
        HashSet <Integer> numberSet = new HashSet<Integer>();
        //rows
        for(int r=0;r<numbers[i].length;r++){
            if(numbers[i][r]!=0 && r!=j){
                numberSet.add(numbers[i][r]);
            }
        }
        //cols
        for(int r=0;r<numbers.length;r++){
            for(int c=0;c<numbers[r].length;c++){
                if(c == j && numbers[r][c] != 0 && r!=i){
                    numberSet.add(numbers[r][c]);
                }
            }
        }
        //grid
        int rowBand = 0;
        int colBand = 0;
        if(i<=2){
            rowBand = 2;
        }
        if(i>2 && i<=5){
            rowBand = 5;
        }
        if(i>5 && i<=8){
            rowBand = 8;
        }
        if(j<=2){
            colBand = 2;
        }
        if(j>2 && j<=5){
            colBand = 5;
        }
        if(j>5 && j<=8){
            colBand = 8;
        }
        for(int r=rowBand;r>rowBand-3;r--){
            for(int c=colBand;c>colBand-3;c--){
                if(numbers[r][c] != 0 && r!=i && c!=j){
                    numberSet.add(numbers[r][c]);
                }
            }
        }
        //final checkUniqueNumbers
        if(numberSet.size()!=8){
            return result;
        }
        for(int t=1;t<=9;t++){
            if(!numberSet.contains(t)){
                result = t;
            }
        }
        return result;
    }

    private int checkUniqueGrid(int i, int j, int[][] numbers) {
        int result = 0;
        List<Integer> existNumberInGrid = new ArrayList<Integer>(9);
        List<Integer> allNumbers = Lists.newArrayList(1,2,3,4,5,6,7,8,9);

        //grid
        int rowBand = 0;
        int colBand = 0;
        if(i<=2){
            rowBand = 2;
        }
        if(i>2 && i<=5){
            rowBand = 5;
        }
        if(i>5 && i<=8){
            rowBand = 8;
        }
        if(j<=2){
            colBand = 2;
        }
        if(j>2 && j<=5){
            colBand = 5;
        }
        if(j>5 && j<=8){
            colBand = 8;
        }
        for(int r=rowBand;r>rowBand-3;r--){
            for(int c=colBand;c>colBand-3;c--){
                if(numbers[r][c] != 0 ){
                    existNumberInGrid.add(numbers[r][c]);
                }
            }
        }
        allNumbers.removeAll(existNumberInGrid);
        for (Integer checkNum : allNumbers) {
            for(int r=rowBand;r>rowBand-3;r--){
                for(int c=colBand;c>colBand-3;c--){
                    if(numbers[r][c] == 0 ){
                        //if there is a same number in row or col,mark it as -1.
                        if(showInSameRowOrSameCol(r,c,checkNum,numbers)){
                            numbers[r][c] = -1;
                        }
                    }
                }
            }
            //statics if there is unique unmarked grid,the right answer
            int unMarkedCount = 0;
            int unMarkedRow = 0;
            int unMarkedCol = 0;
            for(int r=rowBand;r>rowBand-3;r--){
                for(int c=colBand;c>colBand-3;c--){
                    if(numbers[r][c] == 0 ){
                        unMarkedCount++;
                        unMarkedRow = r;
                        unMarkedCol = c;
                    }
                }
            }
            if(unMarkedCount == 1){
                numbers[unMarkedRow][unMarkedCol] = checkNum;
            }
            for(int r=rowBand;r>rowBand-3;r--){
                for(int c=colBand;c>colBand-3;c--){
                    if(numbers[r][c] == -1 ){
                        numbers[r][c] = 0;
                    }
                }
            }
        }

        return result;
    }

    private boolean showInSameRowOrSameCol(int r, int c, int checkNum,int [][] numbers) {
        boolean isExists = false;
        for(int i=0;i<numbers[r].length;i++){
            if(numbers[r][i] == checkNum){
                isExists = true;
                break;
            }
        }
        if(!isExists){
            for(int i=0;i<numbers.length;i++){
                if(numbers[i][c] == checkNum){
                    isExists = true;
                    break;
                }
            }
        }
        return isExists;
    }

    private boolean isAllGridHasNumber(int[][] puzzle) {
        boolean result = true;
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                if(puzzle[i][j]==0){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public void printResult(int[][] result){
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int [][] puzz = new int[9][9];
//        puzz[0] = new int[] {0,0,0,0,5,7,4,0,1};
//        puzz[1] = new int[] {0,0,8,0,0,0,0,6,0};
//        puzz[2] = new int[] {0,0,0,0,0,8,2,0,5};
//        puzz[3] = new int[] {0,0,7,0,6,9,1,0,0};
//        puzz[4] = new int[] {0,2,1,0,7,0,8,9,0};
//        puzz[5] = new int[] {0,0,9,4,2,0,5,0,0};
//        puzz[6] = new int[] {2,0,4,1,0,0,0,0,0};
//        puzz[7] = new int[] {0,9,0,0,0,0,7,0,0};
//        puzz[8] = new int[] {8,0,5,7,9,0,0,0,0};

        puzz[0] = new int[] {6,0,0,3,0,0,1,0,0};
        puzz[1] = new int[] {0,7,1,6,2,0,0,0,0};
        puzz[2] = new int[] {8,0,5,0,0,1,0,0,0};
        puzz[3] = new int[] {5,0,0,8,7,0,9,0,1};
        puzz[4] = new int[] {0,0,9,0,0,0,6,0,0};
        puzz[5] = new int[] {4,0,7,0,6,9,0,0,8};
        puzz[6] = new int[] {0,0,0,2,0,0,8,0,7};
        puzz[7] = new int[] {0,0,0,0,8,6,4,1,0};
        puzz[8] = new int[] {0,0,8,0,0,3,0,0,2};


//        puzz[0] = new int[] {0,0,0,0,7,3,0,0,0};
//        puzz[1] = new int[] {3,7,4,2,9,0,8,5,0};
//        puzz[2] = new int[] {0,6,8,4,0,0,0,0,3};
//        puzz[3] = new int[] {5,3,9,6,0,0,0,0,0};
//        puzz[4] = new int[] {0,4,6,7,5,1,9,3,0};
//        puzz[5] = new int[] {0,0,0,0,0,9,5,6,2};
//        puzz[6] = new int[] {6,0,0,0,0,7,3,9,0};
//        puzz[7] = new int[] {0,9,5,0,3,8,2,7,6};
//        puzz[8] = new int[] {0,0,0,9,6,0,0,0,0};
        SudokuResolver sr = new SudokuResolver(puzz);
        System.out.println("start to resolve...");
        long start = System.currentTimeMillis();
        int [][] result = sr.resuolve();
        long end = System.currentTimeMillis();
        System.out.println("finish,cost:"+(end-start)+"ms");
        sr.printResult(result);
    }
}
