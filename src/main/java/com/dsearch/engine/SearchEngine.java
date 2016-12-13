package com.dsearch.engine;

import com.dsearch.db.Db;
import com.dsearch.db.Word;

public class SearchEngine {
	private Db db = null; 
	public SearchEngine(Db db) {
		super();
		this.db = db;
	}

	/**
	 * execQuery will create a Query object representing the search keyword
	 * then it will lookup the database for those keywords 
	 * and store the results in the database
	 * @param keywords
	 * @return
	 */
	public String execQuery(String keywords) {
		Query query = new Query(keywords);
		for (String keyword: query.getKeywords()) {
			if (keyword != null) {				
				Word word = this.db.findWord(keyword);	
				if (word != null) {				
					for (String filename: word.getFilepaths().keySet()) {
						query.addResult(filename);
					}
					
				}	
			}
		}
		return query.getResults();
	}
}
