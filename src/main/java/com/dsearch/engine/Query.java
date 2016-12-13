package com.dsearch.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Query {
	private final static int MAX_QUERY_RESUTS = 1000; 
	private String[] keywords;
	private HashMap<String, Result> queryResults;
	private String[] topTen;
	public Query(String keywords) {
		super();
		this.setKeywords(keywords.split("\\s+"));
		this.queryResults = new HashMap<String, Result>(MAX_QUERY_RESUTS);
		this.topTen = new String[10];
	}


	public HashMap<String, Result> getQueryResults() {
		return queryResults;
	}


	public void setQueryResults(HashMap<String, Result> queryResults) {
		this.queryResults = queryResults;
	}


	public void addResult(String filename) {
		if ( this.queryResults.containsKey(filename)){
			Result resultScore = this.queryResults.get(filename);
			resultScore.incrementScore();
			this.queryResults.put(filename, resultScore);
		} else {
			Result resultScore = new Result(filename, 1);
			this.queryResults.put(filename, resultScore);
		}
	}
	public void getToptenResutls() {
		Collection<Result> results = this.queryResults.values();
		List<Result> resultsList = new ArrayList<Result>( results );
		Collections.sort(resultsList, new Comparator<Result>() {
	        public int compare(Result result1, Result result2) {
	            return result2.getScore() - result1.getScore();
	        }
	    });
		for (int i = 0; i < resultsList.size() && i < 10; i++) {
			this.topTen[i] = resultsList.get(i).getFilename() + ": With score *" + this.getScore(resultsList.get(i).getScore()) + "%"; 
		} 
	}

	
	public float getScore(int score) {
		float keyword_length = this.keywords.length;
		return (((float) score)/keyword_length)*100;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}
	public String getResults() {
		String result = "";
		this.getToptenResutls();
		for (int i = 0; i < this.topTen.length; i++) {
			if (this.topTen[i]!=null ) {
				result+= this.topTen[i] + '\n';
				// System.out.println(this.topTen[i]);
			}
		}
		return  result;	
	}
	
}
