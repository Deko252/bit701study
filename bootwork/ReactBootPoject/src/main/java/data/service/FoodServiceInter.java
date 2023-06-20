package data.service;

import java.util.List;

import data.dto.FoodDto;

public interface FoodServiceInter {
	public void insertFood(FoodDto dto);
	public List<FoodDto> getAllFood();
}
