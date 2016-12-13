package com.dsearch.engine;

public class Result {
	private String filename;
	private int score;
	public Result(String filename, int score) {
		super();
		this.filename = filename;
		this.score = score;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public void incrementScore() {
		this.score ++;
	}
}
