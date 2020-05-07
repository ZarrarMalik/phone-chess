package com.zarrar.phonechess;

import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PhoneChessMain {

	public static void main(String[] args) {

		PhonePad[][] thePad = new PhonePad[4][3];
		thePad[0][0] = new PhonePad("1", new Point(0, 0));
		thePad[0][1] = new PhonePad("2", new Point(1, 0));
		thePad[0][2] = new PhonePad("3", new Point(2, 0));
		thePad[1][0] = new PhonePad("4", new Point(0, 1));
		thePad[1][1] = new PhonePad("5", new Point(1, 1));
		thePad[1][2] = new PhonePad("6", new Point(2, 1));
		thePad[2][0] = new PhonePad("7", new Point(0, 2));
		thePad[2][1] = new PhonePad("8", new Point(1, 2));
		thePad[2][2] = new PhonePad("9", new Point(2, 2));
		thePad[3][0] = new PhonePad("*", new Point(0, 3));
		thePad[3][1] = new PhonePad("0", new Point(1, 3));
		thePad[3][2] = new PhonePad("#", new Point(2, 3));

		ChessPhoneNumbers chessPhoneNumbers = new ChessPhoneNumbers(thePad, "Knight");
		System.out.println(chessPhoneNumbers.findPossibleDigits(thePad[0][1], 10));

	}

}
