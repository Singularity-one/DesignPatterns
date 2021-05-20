/*
 * 表象模式
 */
public class FacadePattern {
	public static void main(String[] args) {
		FacadeMethod fm =new FacadeMethod();
		fm.doMethod();
    }
	
}

//暴露 Facade
class FacadeMethod
{
	Amethod am;
	Bmethod bm;
	
	FacadeMethod()
    {
		am = new Amethod();
		bm = new Bmethod();
    }
	
    public void doMethod()
    {
    	am.doAmethod();
    	bm.doBmethod();
    }
}

class Amethod
{
    public void doAmethod()
    {
        System.out.println("Amethod done");
    }
}

class Bmethod
{
    public void doBmethod()
    {
        System.out.println("Bmethod done");
    }
}
