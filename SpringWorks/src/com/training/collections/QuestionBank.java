package com.training.collections;

import java.util.List;

public class QuestionBank {
	private String question;
	private List<String> options;
	
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public QuestionBank(String question, List<String> options) {
		super();
		this.question = question;
		this.options = options;
	}
	public QuestionBank() {
		super();
	}
	@Override
	public String toString() {
		return "QuestionBank [question=" + question + ", options=" + options + "]";
	}
	
	
}
