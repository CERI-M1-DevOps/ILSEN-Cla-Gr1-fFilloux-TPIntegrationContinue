package liste;

/**
 * Noeud élémentaire d'une {@link ListeSimple}, contenant une valeur entière
 * et un lien vers le noeud suivant.
 */
public class Noeud {
    private int element;
    private Noeud suivant;

    /**
     * Construit un noeud contenant l'élément indiqué.
     *
     * @param e valeur contenue dans le noeud
     * @param suivant noeud placé après celui-ci, {@code null} s'il s'agit du dernier
     */
    public Noeud(int e, Noeud suivant) {
        element = e;
        this.suivant = suivant;
    }

    /**
     * Retourne la valeur contenue dans ce noeud.
     *
     * @return la valeur du noeud
     */
    public int getElement() {
        return element;
    }

    /**
     * Remplace la valeur contenue dans ce noeud.
     *
     * @param element nouvelle valeur à stocker
     */
    public void setElement(int element) {
        this.element = element;
    }

    /**
     * Retourne le noeud situé immédiatement après celui-ci.
     *
     * @return le noeud suivant, ou {@code null} si celui-ci est le dernier
     */
    public Noeud getSuivant() {
        return suivant;
    }

    /**
     * Remplace le noeud situé immédiatement après celui-ci.
     *
     * @param suivant nouveau noeud à placer après celui-ci
     */
    public void setSuivant(Noeud suivant) {
        this.suivant = suivant;
    }

    /**
     * Représentation textuelle du noeud, utilisée par {@link ListeSimple#toString()}.
     *
     * @return la chaîne {@code Noeud(valeur)}
     */
    public String toString() {
        return "Noeud(" + element + ")";
    }
}
