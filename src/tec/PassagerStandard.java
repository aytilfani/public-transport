package tec;
public class PassagerStandard implements Passager, Usager {

    private String name;
    private int destination;
    private Position position;

    public PassagerStandard(String name, int destination) {
        this.name = name;
        this.destination = destination;
        this.position = Position.getPosition();
    }

    public String nom(){
        return name;
    }

    public boolean estDehors() {
        return position.estDehors();
    }

    public boolean estAssis() {
        return position.estAssis();
    }


    public boolean estDebout(){
        return position.estDebout();
    }


    public void changerEnDehors(){
        this.position = Position.dehors();
    }


    public void changerEnAssis(){
        this.position = Position.assis();
    }


    public void changerEnDebout(){
        this.position = Position.debout();
    }

    public void monterDans(Transport b) {
      Vehicule v = (Vehicule) b;
      if(v.aPlaceAssise()) v.monteeDemanderAssis(this);
      else if(v.aPlaceDebout()) v.monteeDemanderDebout(this);
    }


    public void nouvelArret(Vehicule v, int numeroArret){
        if(this.destination == numeroArret) {
            v.arretDemanderSortie(this);
        }
    }

    public String toString() {
        return name + " " +position.toString();
    }

}
