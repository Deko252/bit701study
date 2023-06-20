package data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import data.dto.FoodDto;

@Mapper
public interface FoodMapper {
	public void insertFood(FoodDto dto);
	public List<FoodDto> getAllFood();
}
