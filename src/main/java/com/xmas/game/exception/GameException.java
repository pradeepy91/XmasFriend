package com.xmas.game.exception;

public class GameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GameException(String message) {
		super(message);
	}
	public GameException(Exception exception) {
		super(exception);
	}
}
