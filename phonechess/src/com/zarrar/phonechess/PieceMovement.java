package com.zarrar.phonechess;

import java.util.HashMap;
import java.util.List;

public interface PieceMovement {

	public Integer findKeyPadNumbers(PhonePad startingPosition, Integer digits);

	public abstract boolean canMove(PhonePad current, PhonePad next);

	public List<PhonePad> possibleMoves(PhonePad current);

	public Integer countPossibleMoves(PhonePad current);

}
