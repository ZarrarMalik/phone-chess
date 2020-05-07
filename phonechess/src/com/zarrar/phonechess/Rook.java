package com.zarrar.phonechess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Rook extends ChessPiece implements PieceMovement {

	public Rook(String name, PhonePad[][] thePad) {
		if (name == null || name.isEmpty() == true)
			throw new IllegalArgumentException("Name cannot be null or empty");

		this.name = name;
		this.thePad = thePad;
		this.moves = new HashMap<>();

	}

	@Override
	public Integer findKeyPadNumbers(PhonePad startingPosition, Integer digits) {
		if (startingPosition == null || "*".equals(startingPosition.getNumber())
				|| "#".equals(startingPosition.getNumber())) {
			throw new IllegalArgumentException("Invalid start point");
		}

		if (digits == 1) {
			return 1;
		}
		;

		// Init
		this.movesFrom = new int[thePad.length * thePad[0].length]; // 12
		for (int i = 0; i < this.movesFrom.length; i++)
			this.movesFrom[i] = -1; // -1 for everything

		fullNumbers = 0;
		findKeyPadNumbers(startingPosition, digits, 1);
		return fullNumbers;
	}

	private void findKeyPadNumbers(PhonePad start, Integer digits, Integer currentDigits) {
		// Base condition
		if (currentDigits == digits) {
			// Reset
			currentDigits = 1;
			fullNumbers++;
			return;
		}
		if (!this.moves.containsKey(start))
			possibleMoves(start);

		List<PhonePad> options = this.moves.get(start);
		if (options != null) {
			currentDigits++; // More digits to be got
			for (PhonePad option : options)
				findKeyPadNumbers(option, digits, currentDigits);
		}
	}

	@Override
	public boolean canMove(PhonePad current, PhonePad next) {
		/// Is the moves list available?
		if (!this.moves.containsKey(current.getNumber())) {
			// No? Process.
			countPossibleMoves(current);
		}
		if (this.moves.get(current) != null) {
			for (PhonePad option : this.moves.get(current)) {
				if (option.getNumber().equals(next.getNumber()))
					return true;
			}
		}
		return false;
	}

	@Override
	public List<PhonePad> possibleMoves(PhonePad current) {
		// First encounter
		if (this.moves == null)
			this.moves = new HashMap<>();

		if (this.moves.containsKey(current))
			return this.moves.get(current);
		else {
			List<PhonePad> found = new ArrayList<>();
			int row = current.getY();// rows
			int col = current.getX();// columns

			/*
			 * Cases: Have to Make cases for each locations on the pad, since rook can
			 * access all buttons on the pad i.e. (row=0, col=0) can give you 4 options
			 * ([0][1], [0][2], [1][0], [2][0]). We put these locations in a switch
			 * statement and use Java Math.random class to pick any of these four locations
			 * at random. Similarly have to design all the locations on the pad.
			 * 
			 * 
			 */
			return null;
		}
	}

	@Override
	public Integer countPossibleMoves(PhonePad current) {
		// TODO Auto-generated method stub
		return null;
	}

}
