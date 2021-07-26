import java.util.ArrayList;
import java.util.Iterator;

public class IteratorPattern {
	public static void main(String[] args) {
		 ShoesMenu shoesMenu = new ShoesMenu();
		 ShoesMenuIterator shoesMenuIterator = new ShoesMenuIterator(shoesMenu);
		 ClothesMenu clothesMenu = new ClothesMenu();
		 ClothesMenuIterator clothesMenuIterator = new ClothesMenuIterator(clothesMenu);
		 
		 Waitress waitress = new Waitress(
				 	shoesMenu,
				 	clothesMenu,
	                shoesMenuIterator,
	                clothesMenuIterator);
		 waitress.introduceMenu();
    }
}

interface Menu<T> {
    void setMenuItem();
    T getMenu();
}

class ShoesMenu implements Menu<ArrayList<String>> {
    ArrayList<String> menu;

    ShoesMenu() {
        this.setMenuItem();
    }

    public void setMenuItem() {
        this.menu = new ArrayList<>();
        this.menu.add("球鞋");
        this.menu.add("布鞋");
    }

    public ArrayList<String> getMenu() {
        return menu;
    }
}

class ClothesMenu implements Menu<String[]>{
	 String[] menu;
	 
	 ClothesMenu() {
		 this.menu = new String[2];
		 this.setMenuItem();
     }
	 
	 public void setMenuItem() {
	        this.menu[0] = "T shit";
	        this.menu[1] = "毛衣";
	 }
	 
	 public String[] getMenu() {
	        return menu;
	 }
}

class ShoesMenuIterator implements Iterator<String> {
    ArrayList<String> menu;
    int count = -1;

    public ShoesMenuIterator(Menu<ArrayList<String>> menu) {
        this.menu = menu.getMenu();
    }

    public boolean hasNext() {
        if (count + 1 >= menu.size()) {
            return false;
        }
        return true;
    }

    public String next() {
        count++;
        return this.menu.get(count);
    }
}

class ClothesMenuIterator implements Iterator<String> {
    String[] menu;
    int count = -1;

    public ClothesMenuIterator(Menu<String[]> menu) {
        this.menu = menu.getMenu();
    }

    public boolean hasNext() {
        if (count + 1 >= menu.length) {
            return false;
        }
        return true;
    }

    public String next() {
        count++;
        return this.menu[count];
    }
}

class Waitress {
	ShoesMenu shoesMenu;
	ClothesMenu clothesMenu;
	ShoesMenuIterator shoesMenuIterator;
    ClothesMenuIterator clothesMenuIterator;
    
    Waitress(ShoesMenu shoesMenu,ClothesMenu clothesMenu,ShoesMenuIterator shoesMenuIterator,ClothesMenuIterator clothesMenuIterator){
        this.shoesMenu = shoesMenu;
        this.clothesMenu = clothesMenu;
        this.shoesMenuIterator = shoesMenuIterator;
        this.clothesMenuIterator = clothesMenuIterator;
    }

    public void introduceMenu(){
        System.out.println("介紹鞋子");
        while(shoesMenuIterator.hasNext()) {
            System.out.println(shoesMenuIterator.next());
        }
        System.out.println("介紹衣服");
        while(clothesMenuIterator.hasNext()) {
            System.out.println(clothesMenuIterator.next());
        }
        
    }
}
