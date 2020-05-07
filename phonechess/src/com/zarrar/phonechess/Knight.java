package com.zarrar.phonechess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Knight extends ChessPiece implements PieceMovement {

	/**
	 * Knight movements One horizontal, followed by two vertical Or One vertical,
	 * followed by two horizontal
	 * 
	 * @param name
	 */

	public Knight(String name, PhonePad[][] thePad) {

		if (name == null || name.isEmpty() == true)
			throw new IllegalArgumentException("Name cannot be null or empty");

		this.name = name;
		this.thePad = thePad;
		this.moves = new HashMap<>();
	}

	private Integer fullNumbers = null;

	@Override
	public Integer findKeyPadNumbers(PhonePad startingPosition, Integer digits) {
		if (startingPosition == null || "*".equals(startingPosition.getNumber())
				|| "#".equals(startingPosition.getNumber())) {
			throw new IllegalArgumentException("Invalid start point");
		}
		if (startingPosition.getNumberAsNumber() == 5) {
			return 0;
		} // Consider adding an 'allowSpecialChars' condition
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
		// Is the moves list available?
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

	/***
	 * Overriden method that defines each Piece's movement restrictions.
	 */
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

			// Cases:
			// 1. One horizontal move each way followed by two vertical moves each way
			if (col - 1 >= 0 && row - 2 >= 0)// valid
			{
				if (thePad[row - 2][col - 1].getNumber().equals("*") == false
						&& thePad[row - 2][col - 1].getNumber().equals("#") == false) {
					found.add(thePad[row - 2][col - 1]);
					this.movesFrom[current.getNumberAsNumber()] = this.movesFrom[current.getNumberAsNumber()] + 1;
				}

			}
			if (col - 1 >= 0 && row + 2 < thePad.length)// valid
			{
				if (thePad[row + 2][col - 1].getNumber().equals("*") == false
						&& thePad[row + 2][col - 1].getNumber().equals("#") == false) {
					found.add(thePad[row + 2][col - 1]);
					this.movesFrom[current.getNumberAsNumber()] = this.movesFrom[current.getNumberAsNumber()] + 1;
				}
			}
			if (col + 1 < thePad[0].length && row + 2 < thePad.length)// valid
			{
				if (thePad[row + 2][col + 1].getNumber().equals("*") == false
						&& thePad[row + 2][col + 1].getNumber().equals("#") == false) {
					found.add(thePad[row + 2][col + 1]);
					this.movesFrom[current.getNumberAsNumber()] = this.movesFrom[current.getNumberAsNumber()] + 1;
				}
			}
			if (col + 1 < thePad[0].length && row - 2 >= 0)// valid
			{
				if (thePad[row - 2][col + 1].getNumber().equals("*") == false
						&& thePad[row - 2][col + 1].getNumber().equals("#") == false)
					found.add(thePad[row - 2][col + 1]);
			}
			// Case 2. One vertical move each way follow by two horizontal moves each way

			if (col - 2 >= 0 && row - 1 >= 0) {
				if (thePad[row - 1][col - 2].getNumber().equals("*") == false
						&& thePad[row - 1][col - 2].getNumber().equals("#") == false)
					found.add(thePad[row - 1][col - 2]);
			}
			if (col - 2 >= 0 && row + 1 < thePad.length) {
				if (thePad[row + 1][col - 2].getNumber().equals("*") == false
						&& thePad[row + 1][col - 2].getNumber().equals("#") == false)
					found.add(thePad[row + 1][col - 2]);
			}

			if (col + 2 < thePad[0].length && row - 1 >= 0) {
				if (thePad[row - 1][col + 2].getNumber().equals("*") == false
						&& thePad[row - 1][col + 2].getNumber().equals("#") == false)
					found.add(thePad[row - 1][col + 2]);
			}
			if (col + 2 < thePad[0].length && row + 1 < thePad.length) {
				if (thePad[row + 1][col + 2].getNumber().equals("*") == false
						&& thePad[row + 1][col + 2].getNumber().equals("#") == false)
					found.add(thePad[row + 1][col + 2]);
			}

			if (found.size() > 0) {
				this.moves.put(current, found);
				this.movesFrom[current.getNumberAsNumber()] = found.size();
			} else {
				this.moves.put(current, null); // for example the Knight cannot move from 5 to anywhere
				this.movesFrom[current.getNumberAsNumber()] = 0;
			}
		}

		return this.moves.get(current);

	}

	@Override
	public Integer countPossibleMoves(PhonePad current) {
		int start = current.getNumberAsNumber();

		if (movesFrom[start] != -1)
			return movesFrom[start];
		else {
			movesFrom[start] = countPossibleMoves(current).SIZE;
		}
		return movesFrom[start];
	}

	@Override
	public String toString() {
		return this.name;
	}

}
