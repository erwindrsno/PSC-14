import java.util.Scanner;

public class App{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        //input panjang array 2 dimensi untuk generate minesweeper
        int sizeArray = sc.nextInt();
        //generate array berdasarkan size

        // i = baris
        // j = kolom
        
        //instansiasi array 2 dimensi
<<<<<<< HEAD
        int[][] minesweeperBoard = new int[7][7];
        int[][] minesweeperCheck = new int[7][7];
        for (int i = 1; i < sizeArray-1; i++) {
            for (int j = 1; j < sizeArray-1; j++) {
                //input angka yang ingin di input dimana (i,j) i = baris, j = kolom
                int num = sc.nextInt();
                
                //put num to board
                minesweeperBoard[i][j] = num;
                
                // 0 = tidak, 1 = iya, -1 = bisa jadi
                minesweeperCheck[i][j]= -1;
            }
        }
        printBoard(minesweeperBoard);
        // while(true){
        //     if(checkAll(minesweeperCheck)==true){
        //         break;
        //     }
        //     for (int i = 0; i < sizeArray; i++) {
        //         for (int j = 0; j < sizeArray; j++) {
        //             //kalo jumlah kotak di sekitar angkaX == angkaX, kotak diisi string "ya"
        //             //kalo angkaX == 0, kotak diisi string "tidak"
        //             if(minesweeperBoard[i][j]==0){
        //                 minesweeperCheck[i][j]= 0;
        //                 minesweeperCheck[i+1][j]= 0;
        //                 minesweeperCheck[i-1][j]= 0;
        //                 minesweeperCheck[i][j+1]= 0;
        //                 minesweeperCheck[i][j-1]= 0;
        //                 minesweeperCheck[i+1][j+1]= 0;
        //                 minesweeperCheck[i+1][j-1]= 0;
        //                 minesweeperCheck[i-1][j+1]= 0;
        //                 minesweeperCheck[i-1][j-1]= 0;
        //             }else if(minesweeperBoard[i][j]==4 && ((i==0 && (j==0||j==4))||(i==4 && (j==0||j==4)))){
        //                 minesweeperCheck[i][j]= 0;
        //                 minesweeperCheck[i+1][j]= 0;
        //                 minesweeperCheck[i-1][j]= 0;
        //                 minesweeperCheck[i][j+1]= 0;
        //                 minesweeperCheck[i][j-1]= 0;
        //                 minesweeperCheck[i+1][j+1]= 0;
        //                 minesweeperCheck[i+1][j-1]= 0;
        //                 minesweeperCheck[i-1][j+1]= 0;
        //                 minesweeperCheck[i-1][j-1]= 0;
        //             }else if(minesweeperBoard[i][j]==6 && (i==0||i==4||j==0||j==4)){
        //                 minesweeperCheck[i][j]= 0;
        //                 minesweeperCheck[i+1][j]= 0;
        //                 minesweeperCheck[i-1][j]= 0;
        //                 minesweeperCheck[i][j+1]= 0;
        //                 minesweeperCheck[i][j-1]= 0;
        //                 minesweeperCheck[i+1][j+1]= 0;
        //                 minesweeperCheck[i+1][j-1]= 0;
        //                 minesweeperCheck[i-1][j+1]= 0;
        //                 minesweeperCheck[i-1][j-1]= 0;
        //             }
        //             //kalo jumlah kotak "ya" di sekitar angka X == angkaX, kotak lainnya diisi "tidak"
        //             else if(minesweeperBoard[i][j]>=0){
        //                 int hitung = 0;
        //                 if(minesweeperCheck[i][j] == 1){
        //                     hitung++;
        //                 }
        //                 if(minesweeperCheck[i+1][j] == 1){
        //                     hitung++;
        //                 }
        //                 if(minesweeperCheck[i-1][j] == 1){
        //                     hitung++;
        //                 }
        //                 if(minesweeperCheck[i][j+1] == 1){
        //                     hitung++;
        //                 }
        //                 if(minesweeperCheck[i][j-1] == 1){
        //                     hitung++;
        //                 }
        //                 if(minesweeperCheck[i+1][j+1] == 1){
        //                     hitung++;
        //                 }
        //                 if(minesweeperCheck[i+1][j-1] == 1){
        //                     hitung++;
        //                 }
        //                 if(minesweeperCheck[i-1][j+1] == 1){
        //                     hitung++;
        //                 }
        //                 if(minesweeperCheck[i-1][j-1] == 1){
        //                     hitung++;
        //                 }

        //                 if(minesweeperBoard[i][j]==hitung){
        //                     if(minesweeperCheck[i][j] != 1){
        //                         minesweeperCheck[i][j] = 0;
        //                     }
        //                     if(minesweeperCheck[i+1][j] != 1){
        //                         minesweeperCheck[i+1][j] = 0;
        //                     }
        //                     if(minesweeperCheck[i-1][j] != 1){
        //                         minesweeperCheck[i-1][j] = 0;
        //                     }
        //                     if(minesweeperCheck[i][j+1] != 1){
        //                         minesweeperCheck[i][j+1] = 0;
        //                     }
        //                     if(minesweeperCheck[i][j-1] != 1){
        //                         minesweeperCheck[i][j-1] = 0;
        //                     }
        //                     if(minesweeperCheck[i+1][j+1] != 1){
        //                         minesweeperCheck[i+1][j+1] = 0;
        //                     }
        //                     if(minesweeperCheck[i+1][j-1] != 1){
        //                         minesweeperCheck[i+1][j-1] = 0;
        //                     }
        //                     if(minesweeperCheck[i-1][j+1] != 1){
        //                         minesweeperCheck[i-1][j+1] = 0;
        //                     }
        //                     if(minesweeperCheck[i-1][j-1] != 1){
        //                         minesweeperCheck[i-1][j-1] = 0;
        //                     }
        //                 }
        //             }  
                    
        //             //kalo jumlah kotak "tidak" di sekitar angka X == (jumlah kotak di sekitar - angkaX), kotak lainnya diisi "ya"
        //         }  
        //     }
        // }
        // printBoard2(minesweeperCheck);
        //
//        printBoard(minesweeperBoard);
=======
        int[][] minesweeperBoard = new int[sizeArray+2][sizeArray+2];
        String[][] minesweeperCheck = new String[sizeArray+2][sizeArray+2];
        for (int i = 0; i < minesweeperBoard.length; i++) {
            for (int j = 0; j < minesweeperBoard.length; j++) {
                if(i==0||i==minesweeperBoard.length-1||j==0||j==minesweeperBoard.length-1){
                    minesweeperBoard[i][j] = -1;
                    minesweeperCheck[i][j]="bisajadi";
                }else if(i!=0||i!=minesweeperBoard.length-1||j!=0||j!=minesweeperBoard.length-1){
                    //input angka yang ingin di input dimana (i,j) i = baris, j = kolom
                    int num = sc.nextInt();
                    
                    //put num to board
                    minesweeperBoard[i][j] = num;

                    minesweeperCheck[i][j]="bisajadi";
                }
            }
        }
        printBoard(minesweeperBoard);
        do{
            solve(minesweeperBoard,minesweeperCheck);
//            printBoard2(minesweeperCheck);            
        } while(checkAll(minesweeperCheck) == false);
        change(minesweeperBoard,minesweeperCheck);
        printBoard(minesweeperBoard);
//        while(checkAll(minesweeperCheck)==false){
//            solve(minesweeperBoard,minesweeperCheck);
//        }
    
        
>>>>>>> 3fae62cd2e77f91550c45277dee7983177d3eefa
    }
    
    public static boolean checkAll(int[][] board){
        boolean check = true;
<<<<<<< HEAD
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == -1){
=======
        for (int i = 1; i < board.length-1; i++) {
            for (int j = 1; j < board.length-1; j++) {
                if(board[i][j].equals("bisajadi")){
>>>>>>> 3fae62cd2e77f91550c45277dee7983177d3eefa
                    check = false;
                    break;
                }                
            }
        }
        return check;
    }
    public static void printBoard(int[][] board){
        for (int i = 1; i < board.length-1; i++) {
            for (int j = 1; j < board.length-1; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
<<<<<<< HEAD
    public static void printBoard2(int[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
=======
    public static void printBoard2(String[][] board){
        for (int i = 1; i < board.length-1; i++) {
            for (int j = 1; j < board.length-1; j++) {
>>>>>>> 3fae62cd2e77f91550c45277dee7983177d3eefa
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void solve(int[][] minesweeperBoard, String[][] minesweeperCheck){
        for (int i = 1; i < minesweeperBoard.length-1; i++) {
            for (int j = 1; j < minesweeperBoard.length-1; j++) {
                //kalo jumlah kotak di sekitar angkaX == angkaX, kotak diisi string "ya"
                //kalo angkaX == 0, kotak diisi string "tidak"
                if(minesweeperBoard[i][j]==0){
                    if(minesweeperCheck[i][j].equals("bisajadi")){
                        minesweeperCheck[i][j]="tidak";
                    }
                    if(minesweeperCheck[i+1][j].equals("bisajadi")){
                        minesweeperCheck[i+1][j]="tidak";
                    }
                    if(minesweeperCheck[i-1][j].equals("bisajadi")){
                        minesweeperCheck[i-1][j]="tidak";
                    }
                    if(minesweeperCheck[i][j+1].equals("bisajadi")){
                        minesweeperCheck[i][j+1]="tidak";
                    }
                    if(minesweeperCheck[i][j-1].equals("bisajadi")){
                        minesweeperCheck[i][j-1]="tidak";
                    }
                    if(minesweeperCheck[i+1][j+1].equals("bisajadi")){
                        minesweeperCheck[i+1][j+1]="tidak";
                    }
                    if(minesweeperCheck[i+1][j-1].equals("bisajadi")){
                        minesweeperCheck[i+1][j-1]="tidak";
                    }
                    if(minesweeperCheck[i-1][j+1].equals("bisajadi")){
                        minesweeperCheck[i-1][j+1]="tidak";
                    }
                    if(minesweeperCheck[i-1][j-1].equals("bisajadi")){
                        minesweeperCheck[i-1][j-1]="tidak";
                    }
                }else if(minesweeperBoard[i][j]==4 && ((i==1 && (j==1||j==minesweeperBoard.length-2))||(i==minesweeperBoard.length-2 && (j==1||j==minesweeperBoard.length-2)))){
                    minesweeperCheck[i][j]="iya";
                    minesweeperCheck[i+1][j]="iya";
                    minesweeperCheck[i-1][j]="iya";
                    minesweeperCheck[i][j+1]="iya";
                    minesweeperCheck[i][j-1]="iya";
                    minesweeperCheck[i+1][j+1]="iya";
                    minesweeperCheck[i+1][j-1]="iya";
                    minesweeperCheck[i-1][j+1]="iya";
                    minesweeperCheck[i-1][j-1]="iya";
                }
                else if(minesweeperBoard[i][j]==6 && (i==1&&j>1&&j<minesweeperBoard.length-2||i==minesweeperBoard.length-2&&j>1&&j<minesweeperBoard.length-2||j==1&&i>1&&i<minesweeperBoard.length-2||j==minesweeperBoard.length-2&&i>1&&i<minesweeperBoard.length-2)){
                    minesweeperCheck[i][j]="iya";
                    minesweeperCheck[i+1][j]="iya";
                    minesweeperCheck[i-1][j]="iya";
                    minesweeperCheck[i][j+1]="iya";
                    minesweeperCheck[i][j-1]="iya";
                    minesweeperCheck[i+1][j+1]="iya";
                    minesweeperCheck[i+1][j-1]="iya";
                    minesweeperCheck[i-1][j+1]="iya";
                    minesweeperCheck[i-1][j-1]="iya";
                }
                //kalo jumlah kotak "ya" di sekitar angka X == angkaX, kotak lainnya diisi "tidak"
                else if(minesweeperBoard[i][j]>=0){
                    int hitungIya = 0;
                    int hitungTidak = 0;
                    int hitungKotak = 0;
                    if(i>1&&i<minesweeperBoard.length-2&&j>1&&j<minesweeperBoard.length-2){
                        hitungKotak=9;
                    }else if((i==1&&(j==1||j==minesweeperBoard.length-2))||(i==minesweeperBoard.length-2 && (j==1||j==minesweeperBoard.length-2))){
                        hitungKotak=4;
                    }else{
                        hitungKotak=6;
                    }
                    if(minesweeperCheck[i][j].equals("iya")){
                        hitungIya++;
                    }else if(minesweeperCheck[i][j].equals("tidak")){
                        hitungTidak++;
                    }
                    if(minesweeperCheck[i+1][j].equals("iya")&&i+1!=minesweeperBoard.length-1){
                        hitungIya++;
                    }else if(minesweeperCheck[i+1][j].equals("tidak")&&i+1!=minesweeperBoard.length-1){
                        hitungTidak++;
                    }
                    if(minesweeperCheck[i-1][j].equals("iya")&&i-1!=0){
                        hitungIya++;
                    }else if(minesweeperCheck[i-1][j].equals("tidak")&&i-1!=0){
                        hitungTidak++;
                    }
                    if(minesweeperCheck[i][j+1].equals("iya")&&j+1!=minesweeperBoard.length-1){
                        hitungIya++;
                    }else if(minesweeperCheck[i][j+1].equals("tidak")&&j+1!=minesweeperBoard.length-1){
                        hitungTidak++;
                    }
                    if(minesweeperCheck[i][j-1].equals("iya")&&j-1!=0){
                        hitungIya++;
                    }else if(minesweeperCheck[i][j-1].equals("tidak")&&j-1!=0){
                        hitungTidak++;
                    }
                    if(minesweeperCheck[i+1][j+1].equals("iya")&&i+1!=minesweeperBoard.length-1&&j+1!=minesweeperBoard.length-1){
                        hitungIya++;
                    }else if(minesweeperCheck[i+1][j+1].equals("tidak")&&i+1!=minesweeperBoard.length-1&&j+1!=minesweeperBoard.length-1){
                        hitungTidak++;
                    }
                    if(minesweeperCheck[i+1][j-1].equals("iya")&&i+1!=minesweeperBoard.length-1&&j-1!=0){
                        hitungIya++;
                    }else if(minesweeperCheck[i+1][j-1].equals("tidak")&&i+1!=minesweeperBoard.length-1&&j-1!=0){
                        hitungTidak++;
                    }
                    if(minesweeperCheck[i-1][j+1].equals("iya")&&i-1!=0&&j+1!=minesweeperBoard.length-1){
                        hitungIya++;
                    }else if(minesweeperCheck[i-1][j+1].equals("tidak")&&i-1!=0&&j+1!=minesweeperBoard.length-1){
                        hitungTidak++;
                    }
                    if(minesweeperCheck[i-1][j-1].equals("iya")&&i-1!=0&&j-1!=0){
                        hitungIya++;
                    }else if(minesweeperCheck[i-1][j-1].equals("tidak")&&i-1!=0&&j-1!=0){
                        hitungTidak++;
                    }
//                    System.out.println(hitungKotak);
                    if(minesweeperBoard[i][j]==hitungIya){
                        if(minesweeperCheck[i][j].equals("bisajadi")){
                            minesweeperCheck[i][j]="tidak";
                        }
                        if(minesweeperCheck[i+1][j].equals("bisajadi")&&i+1!=minesweeperBoard.length-1){
                            minesweeperCheck[i+1][j]="tidak";
                        }
                        if(minesweeperCheck[i-1][j].equals("bisajadi")&&i-1!=0){
                            minesweeperCheck[i-1][j]="tidak";
                        }
                        if(minesweeperCheck[i][j+1].equals("bisajadi")&&j+1!=minesweeperBoard.length-1){
                            minesweeperCheck[i][j+1]="tidak";
                        }
                        if(minesweeperCheck[i][j-1].equals("bisajadi")&&j-1!=0){
                            minesweeperCheck[i][j-1]="tidak";
                        }
                        if(minesweeperCheck[i+1][j+1].equals("bisajadi")&&i+1!=minesweeperBoard.length-1&&j+1!=minesweeperBoard.length-1){
                            minesweeperCheck[i+1][j+1]="tidak";
                        }
                        if(minesweeperCheck[i+1][j-1].equals("bisajadi")&&i+1!=minesweeperBoard.length-1&&j-1!=0){
                            minesweeperCheck[i+1][j-1]="tidak";
                        }
                        if(minesweeperCheck[i-1][j+1].equals("bisajadi")&&i-1!=0&&j+1!=minesweeperBoard.length-1){
                            minesweeperCheck[i-1][j+1]="tidak";
                        }
                        if(minesweeperCheck[i-1][j-1].equals("bisajadi")&&i-1!=0&&j-1!=0){
                            minesweeperCheck[i-1][j-1]="tidak";
                        }
                    }
                    //kalo jumlah kotak "tidak" di sekitar angka X == (jumlah kotak di sekitar - angkaX), kotak lainnya diisi "ya"
                    if(hitungKotak-minesweeperBoard[i][j]==hitungTidak){
                        if(minesweeperCheck[i][j].equals("bisajadi")){
                            minesweeperCheck[i][j]="iya";
                        }
                        if(minesweeperCheck[i+1][j].equals("bisajadi")&&i+1!=minesweeperBoard.length-1){
                            minesweeperCheck[i+1][j]="iya";
                        }
                        if(minesweeperCheck[i-1][j].equals("bisajadi")&&i-1!=0){
                            minesweeperCheck[i-1][j]="iya";
                        }
                        if(minesweeperCheck[i][j+1].equals("bisajadi")&&j+1!=minesweeperBoard.length-1){
                            minesweeperCheck[i][j+1]="iya";
                        }
                        if(minesweeperCheck[i][j-1].equals("bisajadi")&&j-1!=0){
                            minesweeperCheck[i][j-1]="iya";
                        }
                        if(minesweeperCheck[i+1][j+1].equals("bisajadi")&&i+1!=minesweeperBoard.length-1&&j+1!=minesweeperBoard.length-1){
                            minesweeperCheck[i+1][j+1]="iya";
                        }
                        if(minesweeperCheck[i+1][j-1].equals("bisajadi")&&i+1!=minesweeperBoard.length-1&&j-1!=0){
                            minesweeperCheck[i+1][j-1]="iya";
                        }
                        if(minesweeperCheck[i-1][j+1].equals("bisajadi")&&i-1!=0&&j+1!=minesweeperBoard.length-1){
                            minesweeperCheck[i-1][j+1]="iya";
                        }
                        if(minesweeperCheck[i-1][j-1].equals("bisajadi")&&i-1!=0&&j-1!=0){
                            minesweeperCheck[i-1][j-1]="iya";
                        }
                    }
                }  
            }
        }
    }
    public static void change(int[][] minesweeperBoard, String[][] minesweeperCheck){
        for (int i = 1; i < minesweeperCheck.length-1; i++) {
            for (int j = 1; j < minesweeperCheck.length-1; j++) {
                if(minesweeperCheck[i][j].equals("iya")){
                    minesweeperBoard[i][j]=1;
                }else if(minesweeperCheck[i][j].equals("tidak")){
                    minesweeperBoard[i][j]=0;
                }
            }
        }
    }
}
