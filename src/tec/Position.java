
/**
 * Cette classe représente la position d'un passager par rapport à un transport.
 * Une position a trois états possibles : assis dans un transport, 
 * debout dans un transport et dehors d'un transport.
 *
 * Les instances de cette classe sont des objets constants.
 *
 * @author Georgy
 * @since 2007-2019
 **/
package tec;

class Position {

  private final static Position DEHORS = new Position();
  private final static Position ASSIS = new Position();
  private final static Position DEBOUT = new Position();

  private Position(){}

  public static Position getPosition(){
    return DEHORS;
  }

  /**
   * La position est-elle dehors ?
   *
   * @return vrai si l'état de l'instance est dehors;
   */
  public boolean estDehors() {
    return this == DEHORS;
  }

  /**
   * La position est-elle assis ?
   *
   * @return vrai si l'état de l'instance est assis;
   */
  public boolean estAssis() {
    return this == ASSIS;
  }

  /**
   * La position est-elle debout ?
   *
   * @return vrai si l'état de l'instance est debout;
   */
  public boolean estDebout() {
    return this == DEBOUT;
  }

  /**
   * La position est-elle assis ou debout ?
   *
   * @return vrai la position est assis ou debout.
   */
  public boolean estInterieur() {
    return this != DEHORS;
  }

  /**
   * Retourne une instance de Position assis.
   *
   * @return instance dans l'état assis.
   */
  public static Position assis() {
    return ASSIS;
  }

  /**
   * Retourne une instance de Position debout.
   *
   * @return instance dans l'état debout.
   */
  public static Position debout() {
    return DEBOUT;
  }

  /**
   * Retourne une instance de Position dehors.
   *
   * @return instance dans l'état dehors.
   */
  public static Position dehors() {
    return DEHORS;
  }

  /**
   * Cette méthode est héritée de la classe {@link java.lang.Object}. Très utile
   * pour le débogage, elle permet de fournir une chaîne de caractères
   * correspondant à l'état d'un objet. Mais, il faut adapter son code à chaque
   * classe.
   */
  @Override
  public String toString() {
    String nom = null;
    if (this == DEHORS)
      nom = "endehors";
    else if(this==ASSIS)
      nom = "assis";
    else
      nom = "debout";
    return "<" + nom + ">";
  }
}
