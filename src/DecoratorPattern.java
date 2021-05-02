/*
 * 裝飾者模式
 */
public class DecoratorPattern {
	public static void main(String[] args) {
		Word word =new Fire();
		word =new BallSpell(word);
		word =new ThrowSpell(word);
		System.out.println(word.getDescription()+",傷害："+word.damage());
		
		Word word2 =new Explosion();
		word2 =new BallSpell(word2);
		word2 =new IncreaseSpell(word2);
		word2 =new ThrowSpell(word2);
		System.out.println(word2.getDescription()+",傷害："+word2.damage());
    }
}

abstract class Word{  //文字是一個抽象類別
	String description="Unknown Word!";
	
	String getDescription() {
		return description;
	}

	abstract double damage();
}

abstract class Spell extends Word{  //咒語是一個抽象類別，也就是裝飾者類別

	abstract String getDescription();
}

class Fire extends Word{  //火焰咒語，注意基本傷害是100之後再裝飾者模式修改
	
	Fire(){
		description="Fire!";
	}
	
	double damage() {
		return 100.0;
	}
}

class Explosion extends Word{  //爆裂咒語，注意基本傷害是100之後再裝飾者模式修改
	
	Explosion(){
		description="Explosion!";
	}
	
	double damage() {
		return 100.0;
	}
}

class BallSpell extends Spell{  //球型化咒語,沒有增加傷害
	Word word;

	BallSpell(Word word){
		this.word=word;
	}
	
	@Override
	String getDescription() {
		return word.getDescription()+",成球型";
	}
	
	@Override
	double damage() {
		return word.damage();
	}	
}

class IncreaseSpell extends Spell{ //增幅化咒語,傷害*3
	Word word;

	IncreaseSpell(Word word){
		this.word=word;
	}
	
	@Override
	String getDescription() {
		return word.getDescription()+",增幅";
	}
	
	@Override
	double damage() {
		return word.damage()*3;
	}	
}

class ThrowSpell extends Spell{ //投擲咒語,傷害+50
	Word word;

	ThrowSpell(Word word){
		this.word=word;
	}
	
	@Override
	String getDescription() {
		return word.getDescription()+",投擲";
	}
	
	@Override
	double damage() {
		return .20+word.damage();
	}	
}




