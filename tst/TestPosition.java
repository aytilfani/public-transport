package tec;
class TestPosition {
    public TestPosition() {
	
    } //Pas indispensable
    public void testAssis(){
		Position position1;
		position1 = Position.getPosition();
		Position position2;
		position2 = position1.assis();

		assert position2.estAssis() == true : "Assis c'est nul";
		//Ce test devrait passer mais ce n'est pas le cas, méthode assis ne renvoie pas une instance de position ou debout est false
		//Ce test passe maintenant
		assert position2.estDebout() == false;
		assert position2.estDehors() == false;
		assert position2.estInterieur() == true;
		System.out.println("Passed Assis");
    }
    public void testDebout(){
		Position position1;
		position1 = Position.getPosition();
		Position position2;
		position2 = position1.debout();
		assert position2.estAssis() == false;
		//Ce test devrait passer mais ce n'est pas le cas, méthode debout ne renvoie pas une instance ou debout est true
		//Ce test passe maintenant
		assert position2.estDebout() == true : "Et les handicapés alors";
		assert position2.estDehors() == false;
		assert position2.estInterieur() == true;
		System.out.println("Passed Debout");
    }
    public void testDehors() {
		Position position1;
		position1 = Position.getPosition();
		Position position2;
		position2 = position1.dehors();
		assert position2.estAssis() == false;
		assert position2.estDebout() == false;
		//Ce test devrait passer mais ce n'est pas le cas, méthode debout ne renvoie pas une instance ou dehors est true et interieur est false
		//Ce test passe maintenant
		assert position2.estDehors() == true;
		assert position2.estInterieur() == false;
		System.out.println("Passed Dehors");
    }
    public void testInstance() {
		Position position;
		position = Position.getPosition();
		assert position.estAssis() == false;
		assert position.estDebout() == false;
		assert position.estDehors() == true;
		assert position.estInterieur() == false;
		System.out.println("Passed Instance");
    }
    public static void main (String[] args) {
		boolean estMisAssertion = false;
		assert estMisAssertion = true;
		if (!estMisAssertion) {
			System.out.println("Execution impossible sans l'option -ea");
			return;
		}
		TestPosition testPosition;
		testPosition = new TestPosition();
		testPosition.testAssis();
		testPosition.testDebout();
		testPosition.testDehors();
		testPosition.testInstance();
	}
}

