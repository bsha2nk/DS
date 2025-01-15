package com.bsha2nk.patterns;

public class Decorator {

	public static void main(String[] args) {
		BasePizza pizza = new Farmhouse();
		pizza = new ExtraCheeseDecorator(pizza);
		
		System.out.println(pizza.cost());
	}
}

interface BasePizza { 
	abstract int cost();
}

class Farmhouse implements BasePizza {

	@Override
	public int cost() {
		return 150;
	}
	
}

class VeggieDelight implements BasePizza {
	
	@Override
	public int cost() {
		return 100;
	}
	
}

abstract class PizzaDecorator implements BasePizza {
	
	BasePizza basePizza;
	
	PizzaDecorator(BasePizza basePizza) {
		this.basePizza = basePizza;
	}
}

class ExtraCheeseDecorator extends PizzaDecorator {

	public ExtraCheeseDecorator(BasePizza basePizza) {
		super(basePizza);
	}

	@Override
	public int cost() {
		return this.basePizza.cost() + 50;
	}
	
}

class ThinBaseDecorator extends PizzaDecorator {
	
	public ThinBaseDecorator(BasePizza basePizza) {
		super(basePizza);
	}
	
	@Override
	public int cost() {
		return this.basePizza.cost() + 25;
	}
	
}
