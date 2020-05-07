package com.zarrar.phonechess;

public class ChessPieceWorkshop {
	public ChessPiece getPiece(String piece, PhonePad[][] thePad) {
		if (thePad == null || thePad.length == 0 || thePad[0].length == 0)
			throw new IllegalArgumentException("Invalid Phonepad");
		if (piece == null)
			throw new IllegalArgumentException("Invalid chess piece");

		switch (piece) {

		case "Knight":
			if (piece.equalsIgnoreCase("Knight"))
				return new Knight("Knight", thePad);
			break;

		case "Rook":
			if (piece.equalsIgnoreCase("Rook"))
				return new Knight("Knight", thePad);
			break;

		case "Queen":
			if (piece.equalsIgnoreCase("Queen"))
				return new Knight("Knight", thePad);
			break;

		case "Pawn":
			if (piece.equalsIgnoreCase("Pawn"))
				return new Knight("Knight", thePad);
			break;
		case "King":
			if (piece.equalsIgnoreCase("King"))
				return new Knight("Knight", thePad);
			break;

		case "Bishop":
			if (piece.equalsIgnoreCase("Bishop"))
				return new Knight("Knight", thePad);
			break;
		}

		return null;
	}
}
