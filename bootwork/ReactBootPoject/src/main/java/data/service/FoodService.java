package data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.FoodDto;
import data.mapper.FoodMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FoodService implements FoodServiceInter {
	
	private FoodMapper foodMapper;
	@Override
	public void insertFood(FoodDto dto) {
		// TODO Auto-generated method stub
		foodMapper.insertFood(dto);
	}
	@Override
	public List<FoodDto> getAllFood() {
		// TODO Auto-generated method stub
		return foodMapper.getAllFood();
	}

}
