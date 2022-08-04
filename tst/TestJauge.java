package tec;
class TestJauge {
    /* Test des méthodes d'instanciation estVert et estRouge
    1 er cas:Le niveau de Jauge est bien dans l'intervalle */
    public void testToutDansIntervale() {
        Jauge testedJauge1 = new Jauge(67899,420);
        assert testedJauge1.estVert() : "estVert failed for a value < max";
        assert !testedJauge1.estRouge() : "estRouge failed for a value < max";

        

        Jauge testedJauge2 = new Jauge(67899,69);
        assert testedJauge2.estVert() : "estVert failed for a value == max";
        assert !testedJauge2.estRouge() : "estRouge failed for a value == max";
    }

    public void testToutSuperieurEgalMax() {
	//2 ème cas:Le niveau de Jauge est en dehors de l'intervalle (supérieur à la capacité maximale)
        Jauge testedJauge1 = new Jauge(67899,67899);
        // Ce test devrait passer 
        assert !testedJauge1.estVert() : "estVert failed for a value == max";
        assert testedJauge1.estRouge() : "estRouge failed for a value == max";
        
        Jauge testedJauge2 = new Jauge(67899,67900);
        // Ce test devrait passer 
        assert !testedJauge2.estVert() : "estVert failed for a value > max";
        assert testedJauge2.estRouge() : "estRouge failed for a value > max";
    }

    public void testToutInferieurEgalZero() {
	//3 ème cas:Le niveau de jauge négatif
        Jauge testedJauge1 = new Jauge(10,-420);
        assert !testedJauge1.estVert() : "estVert failed for a negative value";
        assert !testedJauge1.estRouge() : "estRouge failed for a negative value";
	//3 ème cas:Le niveau de jauge égale à 0
        Jauge testedJauge2 = new Jauge(20,0);
        assert testedJauge2.estVert() : "estVert failed for a negative value ";
        assert !testedJauge2.estRouge() : "estRouge failed for a negative value";
    }


    public void testIncrementer() {
        int max1 = 4;
        Jauge testedJauge1 = new Jauge(max1,max1-1);
        testedJauge1.incrementer();
        // Ce test devrait passer
        assert !testedJauge1.estVert() : "estVert failed for :Check if the value was incremented";
        // Ce test devrait passer
        assert testedJauge1.estRouge() : "estRouge failed for :Check if the value was incremented";

        int max2 = 4;
        Jauge testedJauge2 = new Jauge(max2,1);
        testedJauge2.incrementer();
        //Ce test devrait passer
        assert testedJauge2.estVert() : "estVert failed for an incremented value < max2";
        assert !testedJauge2.estRouge() : "estRouge failed for an incremented value < max2";
    }

    public void testDecrementer() {
        int max1 = 4;
        Jauge testedJauge1 = new Jauge(max1,max1);
        testedJauge1.decrementer();
        assert testedJauge1.estVert() : "estVert failed for :Check if the value was decremented";
        assert !testedJauge1.estRouge() : "estRouge failed for :Check if the value was decremented";

        int max2 = 4;
        Jauge testedJauge2 = new Jauge(max2,max2+1);
        testedJauge2.decrementer();
        //Ce test devrait passer
        assert !testedJauge2.estVert() : "estVert failed for an Decremented value == max2";
        assert testedJauge2.estRouge() : "estRouge failed for an Decremented value == max2";

        int max3 = 4;
        Jauge testedJauge3 = new Jauge(max3,max3+2);
        testedJauge3.decrementer();
        //Ce test devrait passer
        assert !testedJauge2.estVert() : "estVert failed for an Decremented value > max2";
        assert testedJauge2.estRouge() : "estRouge failed for an Decremented value > max2";
    }


    public static void main(String[] argv) {
        // Make sure that the option -ea is activated
        boolean estMisAssertion = false;
        assert estMisAssertion = true;

        if(!estMisAssertion) {
            System.out.println("Execution impossible sans l'option -ea");
            return;
        }   

        TestJauge jaugeTested = new TestJauge();
        System.out.println('.');
        jaugeTested.testToutDansIntervale();
        System.out.println("Passed ToutDansIntervale");
        jaugeTested.testToutSuperieurEgalMax();
        System.out.println("Passed ToutSuperieurEgalMax");
        jaugeTested.testToutInferieurEgalZero();
        System.out.println("Passed ToutInferieurEgalZero");
        jaugeTested.testIncrementer();
        System.out.println("Passed Incrementer");
        jaugeTested.testDecrementer();
        System.out.println("Passed Decrementer");
    }  
}


