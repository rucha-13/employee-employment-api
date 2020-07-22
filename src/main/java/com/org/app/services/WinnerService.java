package com.org.app.services;

import java.util.List;

import com.org.app.model.Winner;

public interface WinnerService {
	public Winner findWinner(int month,int year);
	public List<Winner> findAll();
}
