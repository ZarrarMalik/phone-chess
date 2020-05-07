package com.zarrar.phonechess;

public class ChessPhoneNumbers {

	private ChessPiece thePiece = null;
	private ChessPieceWorkshop workshop = null;

	public ChessPiece ThePiece() {
		return this.thePiece;
	}

	public ChessPhoneNumbers(PhonePad[][] thePad, String piece) {
		if (thePad == null || thePad.length == 0 || thePad[0].length == 0)
			throw new IllegalArgumentException("Invalid pad");
		if (piece == null)
			throw new IllegalArgumentException("Invalid chess piece");

		this.workshop = new ChessPieceWorkshop();
		this.thePiece = this.workshop.getPiece(piece, thePad);
	}

	public Integer findPossibleDigits(PhonePad startingPosition, Integer digits) {
		if (digits <= 0)
			throw new IllegalArgumentException("Digits cannot be less than or equal to zero");

		return thePiece.findKeyPadNumbers(startingPosition, digits);
	}

	public boolean isValidMove(PhonePad current, PhonePad next) {
		return this.thePiece.canMove(current, next);
	}

}
