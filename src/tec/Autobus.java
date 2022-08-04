package tec;

public class Autobus implements Vehicule, Transport {
    private int numeroArret;
    private Jauge jaugeAssise;
    private Jauge jaugeDebout;
    private static Passager [] passagers;

    public Autobus(int jauge_assise, int jauge_debout){
        this.numeroArret = 0;
        int capacite = jauge_assise+ jauge_debout ;
        this.passagers = new Passager [capacite];
        this.jaugeAssise = new Jauge(jauge_assise,0);
        this.jaugeDebout = new Jauge(jauge_debout,0);
    }

    /** 
    *verifie si il une place assise ou debout vide
    *@return 1 s'il y a une place vide assise
    *2 s'il y a une place debout vide mais pas de place assise
    *-1 s'il n'y a pas de place libre 
     */
    private int chercherEmplacementVide(){
        for(int i = 0; i<this.passagers.length; i++)
            if(this.passagers[i] == null)
                return i;
        return -1;
    }
    /**
    * Cherche un passager dans l'autobus
    * @param p le passager que nous cherchons
    * @return l'indice du passager dans le tableau s'il est dans l'Autobus
    * -1 sinon 
     */
    private int chercherPassager(Passager p){
       for(int i = 0; i < this.passagers.length; i++){
           if(this.passagers[i] == p){
               return i;
           }
       }
       return -1;
    }
    /**
   * Indique au véhicule l'arrêt suivant en déclenche sur chaque passager 
   * la méthode arretSuivant().
   */
    public void allerArretSuivant(){
        this.numeroArret += 1;

        for (int i = 0; i < passagers.length; i++) {
            if(passagers[i]!= null){
               passagers[i].nouvelArret(this, numeroArret);
            }
        }        
        
    }
    /**
   *  Y-a-t-il des places assises libres ?
   * @return vrai si nombre max de places assises n'est pas atteinte. 
   */
    public boolean aPlaceAssise (){ 
        return(this.jaugeAssise.estVert());
    }
    /**
   *  Y-a-t-il des places debout libres ?
   * @return vrai si nombre max de places debout n'est pas atteinte. 
   */
    public boolean aPlaceDebout (){
        return(this.jaugeDebout.estVert());
    }
    /**
   * Le passager entre dans le véhicule en demandant une place assise.
   * la position du passager est forcément dehors.
   * Cette méthode est appelée par un passager.
   * @param p le passager qui demande à montée.
   */
    public void monteeDemanderAssis (Passager p){
        p.changerEnAssis();
        jaugeAssise.incrementer();

        int index = chercherEmplacementVide();
        if(index != -1){
            this.passagers[index] = p;
        }
    }
    /**
   * Le passager entre dans le véhicule en demandant une place debout.
   * la position du passager est forcément dehors.
   * Cette méthode est appelée par un passager.
   * @param p le passager qui demande à montée.
   */
    public void monteeDemanderDebout (Passager p){
        p.changerEnDebout();
        jaugeDebout.incrementer();
        
        int index = chercherEmplacementVide();
        System.out.print(index);
        if(index != -1){
            this.passagers[index] = p;
        }
    }
    /**
   * Change un passager d'une place assise vers une place debout
   * pour un passager déjà dans le véhicule.
   * @param p le passager avec une position assis dans le véhicule.
   */
    public void arretDemanderDebout (Passager p){
        p.changerEnDebout();
        jaugeAssise.decrementer();
        jaugeDebout.incrementer();
    }
    /**
   * Change un passager d'une place debout vers une place assise
   * pour un passager déjà dans le véhicule.
   * @param p le passager avec une position debout dans le véhicule.
   */
    public void arretDemanderAssis (Passager p){
        p.changerEnAssis();
        jaugeAssise.incrementer();
        jaugeDebout.decrementer();
    }
    /**
   * Fait sortir un passager du véhicule.
   * @param p le passager avec une position soit assise soit debout 
   *          dans le véhicule. 
   */
    public void arretDemanderSortie(Passager p){
        if (p.estDebout())
            jaugeDebout.decrementer();
        else if (p.estAssis())
           jaugeAssise.decrementer();
        p.changerEnDehors();

    int index = chercherPassager(p);
        if(index != -1){
            this.passagers[index] = null;
        }

    }
    /**
    *fonction de deboggage
     */
    public String toString() {
        String num = null;
        num = String.valueOf(numeroArret);
        return "[arret "+ num + "]" + " assis " + jaugeAssise.toString() + " debout " + jaugeDebout.toString();
    }

    public static void main (String[] args){
        boolean estMisAssertion = false;
        assert estMisAssertion = true;

        if (!estMisAssertion) {
            System.out.println("Execution impossible sans l'option -ea");
        return;
        }
    }
}

