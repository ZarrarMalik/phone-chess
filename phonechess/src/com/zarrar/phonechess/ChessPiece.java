package com.zarrar.phonechess;

import java.util.HashMap;
import java.util.List;

public abstract class ChessPiece implements PieceMovement {

	public String name = "";
	public HashMap<PhonePad, List<PhonePad>> moves = null;
	public Integer fullNumbers = 0;
	public int[] movesFrom = null;
	public PhonePad[][] thePad = null;
}
