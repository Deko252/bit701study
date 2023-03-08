package study.Day0308;

interface InterB{
	public void paint();
	public void save();
}

abstract class AbsOne{
	public void show() {
		System.out.println("AnstOne - show");
	}
	abstract public void study();
}

class MyAnony{

	InterB a = new InterB() {
		@Override
		public void paint() {
			// TODO Auto-generated method stub
			System.out.println("paint");
		}
		
		@Override
		public void save() {
			// TODO Auto-generated method stub
			System.out.println("save");
		}
		
	};
	AbsOne b = new AbsOne() {
		@Override
		public void study() {
			// TODO Auto-generated method stub
			System.out.println("study");
		}
		@Override
		public void show() {
			// TODO Auto-generated method stub
			System.out.println("show");
		}

		
	};

	
}


public class Ex13AnnonyClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyAnony My = new MyAnony();
		My.a.paint();
		My.a.save();
		My.b.study();
		My.b.show();
	}

}
