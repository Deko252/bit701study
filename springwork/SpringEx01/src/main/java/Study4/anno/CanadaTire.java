package Study4.anno;

import org.springframework.stereotype.Component;

//@Component: xml없이 자동으로 bean등록(id 는 자동으로 canadaTire)
//@Component("cTire" ): id가 cTire이 된다.
@Component
public class CanadaTire implements Tire {

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "캐나다타이어";
	}

}
