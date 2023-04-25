package mycar.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class MyCarDao{
	
	@Autowired
	MycarDaointer carDao;
	
	//전체 갯수 반환
	public Long getTotalCount() {
		return carDao.count();
	}
	
	//insert
	public void insertCar(MyCarDto dto) {
		carDao.save(dto); //num 값 유무에 따라 insert 또는 update 실행
	}
	
	//list
	public List<MyCarDto> getAllcars(){
		
		//return carDao.findAll();//입력 순서대로 출력
		
		//가격이 비싼거 부터 출력하고 싶을경우
		return carDao.findAll(Sort.by(Sort.Direction.DESC, "carprice"));
	}
	
	//detaile
	public MyCarDto getMyCar(Long num) {
		return carDao.getReferenceById(num);
	}
	
	//update
	public void updateCar(MyCarDto dto) {
		carDao.save(dto);//이번에 num이 포함이므로 수정 해준다
	}
	
	//delete
	public void deletecar(Long num) {
		carDao.deleteById(num);
	}
	
	//list
		public List<MyCarDto> getSortcars(int idx){
			
			if(idx == 1) {
				//가격이 싼것 부터 출력하고 싶을경우
				return carDao.findAll(Sort.by(Sort.Direction.DESC, "carprice"));
			}else if(idx == 2) {
				//가격이 비싼거 부터 출력하고 싶을경우
				return carDao.findAll(Sort.by(Sort.Direction.ASC, "carprice"));			
			}else {
				return carDao.findAll();
			}
			
		}
}
