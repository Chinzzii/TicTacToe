package ticTacToe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	static int n = 0;
	static int result;
	static ArrayList<Integer> pPlayed = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPlayed = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("*******Tic Tac Toe*******\n");
		char[][] gameBoard = {
								{' ','|',' ','|',' '},
								{'—','+','—','+','—'},
								{' ','|',' ','|',' '},
								{'—','+','—','+','—'},
								{' ','|',' ','|',' '},
							 };
		
		while(true) {
			System.out.println("Enter Position(0-9): ");
			
			int pPos = sc.nextInt();
			while(pPlayed.contains(pPos) || cpuPlayed.contains(pPos) || pPos<1 || pPos>9) {
				System.out.println("Invalid, Choose Another Position!");
				pPos = sc.nextInt();
			}
			System.out.println("You Played: " + pPos);
			placement(gameBoard, pPos, "P1");
			System.out.println();
			result = check();
			if(result == 1) {
				System.out.println("You Won!!");
				break;
			}
			if(result == 3) {
				System.out.println("Tied!");
				break;
			}
			
			int cpuPos = rand.nextInt(9) + 1;	
			while(pPlayed.contains(cpuPos) || cpuPlayed.contains(cpuPos)) {
				cpuPos = rand.nextInt(9) + 1;
			}
			System.out.println("CPU Played: " + cpuPos);
			placement(gameBoard, cpuPos, "CPU");
			System.out.println();
			result = check();
			if(result == 2) {
				System.out.println("CPU Won!!");
				break;
			}

		}		
		
	}

	public static void printBoard(char[][] gameBoard) {
		for(char[] row : gameBoard) {
			for(char ch : row) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}
	
	public static void placement(char[][] gameBoard, int pos, String user) {
		
		char symbol='X';
		
		if(user.equals("P1")) {
			symbol='X';
			pPlayed.add(pos);
		}
		else if(user.equals("CPU")) {
			symbol='O';
			cpuPlayed.add(pos);
		}
		
		switch(pos) {
			case 1:
				gameBoard[0][0] = symbol;
				printBoard(gameBoard);
				break;
				
			case 2:
				gameBoard[0][2] = symbol;
				printBoard(gameBoard);
				break;
				
			case 3:
				gameBoard[0][4] = symbol;
				printBoard(gameBoard);
				break;
				
			case 4:
				gameBoard[2][0] = symbol;
				printBoard(gameBoard);
				break;
				
			case 5:
				gameBoard[2][2] = symbol;
				printBoard(gameBoard);
				break;
				
			case 6:
				gameBoard[2][4] = symbol;
				printBoard(gameBoard);
				break;
				
			case 7:
				gameBoard[4][0] = symbol;
				printBoard(gameBoard);
				break;
				
			case 8:
				gameBoard[4][2] = symbol;
				printBoard(gameBoard);
				break;
				
			case 9:
				gameBoard[4][4] = symbol;
				printBoard(gameBoard);
				break;
			default:
				break;
		}

	}

	public static int check() {
		
		List<Integer> topRow = Arrays.asList(1,2,3);
		List<Integer> midRow = Arrays.asList(4,5,6);
		List<Integer> botRow = Arrays.asList(7,8,9);
		List<Integer> leftCol = Arrays.asList(1,4,7);
		List<Integer> midCol = Arrays.asList(2,5,8);
		List<Integer> rightCol = Arrays.asList(3,6,9);
		List<Integer> cross1 = Arrays.asList(1,5,9);
		List<Integer> cross2 = Arrays.asList(3,5,7);
		
		List<List> win = new ArrayList<List>();
		win.add(topRow);
		win.add(midRow);
		win.add(botRow);
		win.add(leftCol);
		win.add(midCol);
		win.add(rightCol);
		win.add(cross1);
		win.add(cross2);
		
		for(List<?> l : win) {
			if(pPlayed.containsAll(l)) {
				return 1;
			}
			else if(cpuPlayed.containsAll(l)) {
				return 2;
			}
			else if(pPlayed.size() + cpuPlayed.size() == 9){
				return 3;
			}
		}
		return 0;
		
	}

}
