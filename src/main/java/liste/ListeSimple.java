package liste;

/**
 * Liste chaînée d'entiers. Les ajouts se font en tête de liste : l'ordre
 * inverse de celui des insertions est donc conservé.
 */
public class ListeSimple {
    private long size;

    /**
     * Premier noeud de la liste, {@code null} si la liste est vide.
     */
    Noeud tete;

    /**
     * Retourne le nombre d'éléments actuellement contenus dans la liste.
     *
     * @return la taille de la liste
     */
    public long getSize() {
        return size;
    }

    /**
     * Ajoute un élément en tête de la liste et incrémente la taille.
     *
     * @param element valeur à insérer
     */
    public void ajout(int element) {
        tete = new Noeud(element, tete);
        size++;
    }

    /**
     * Remplace la valeur du premier noeud contenant {@code element}, sans effet
     * si cette valeur n'est pas présente dans la liste.
     *
     * @param element valeur à rechercher
     * @param nouvelleValeur valeur de remplacement
     */
    public void modifiePremier(int element, int nouvelleValeur) {
        Noeud courant = tete;
        while (courant != null && courant.getElement() != element)
            courant = courant.getSuivant();
        if (courant != null)
            courant.setElement(nouvelleValeur);
    }

    /**
     * Remplace toutes les occurrences de {@code element} par {@code nouvelleValeur}.
     *
     * @param element valeur à rechercher
     * @param nouvelleValeur valeur de remplacement
     */
    public void modifieTous(int element, int nouvelleValeur) {
        Noeud courant = tete;
        while (courant != null) {
            if (courant.getElement() == element)
                courant.setElement(nouvelleValeur);
            courant = courant.getSuivant();
        }
    }

    /**
     * Représentation textuelle de la liste, les noeuds étant séparés par une virgule.
     *
     * @return la chaîne {@code ListeSimple(Noeud(x), Noeud(y))}
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("ListeSimple(");
        Noeud n = tete;
        while (n != null) {
            sb.append(n);
            n = n.getSuivant();
            if (n != null)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     * Supprime le premier noeud contenant {@code element} et décrémente la taille.
     * La liste reste inchangée si la valeur n'est pas présente.
     *
     * @param element valeur à rechercher et à supprimer
     */
    public void supprimePremier(int element) {
        if (tete != null) {
            if (tete.getElement() == element) {
                tete = tete.getSuivant();
                size--;
                return;
            }
            Noeud precedent = tete;
            Noeud courant = tete.getSuivant();
            while (courant != null && courant.getElement() != element) {
                precedent = precedent.getSuivant();
                courant = courant.getSuivant();
            }
            if (courant != null) {
                precedent.setSuivant(courant.getSuivant());
                size--;
            }
        }
    }

    /**
     * Supprime tous les noeuds contenant {@code element} et décrémente la taille
     * en conséquence.
     *
     * @param element valeur à rechercher et à supprimer
     */
    public void supprimeTous(int element) {
       tete = supprimeTousRecurs(element, tete);
    }

    /**
     * Supprime récursivement tous les noeuds contenant {@code element} dans la
     * sous-liste démarrant à {@code courant}.
     *
     * @param element valeur à rechercher et à supprimer
     * @param courant premier noeud de la sous-liste à traiter
     * @return la tête de la sous-liste restantes après suppression, {@code null} si elle est vide
     */
    public Noeud supprimeTousRecurs(int element, Noeud courant) {
        if (courant != null) {
            Noeud suiteListe = supprimeTousRecurs(element, courant.getSuivant());
            if (courant.getElement() == element) {
                size--;
                return suiteListe;
            } else {
                courant.setSuivant(suiteListe);
                return courant;
            }
        } else return null;
    }

    /**
     * Retourne le noeud précédant le dernier élément, c'est-à-dire l'avant-dernier.
     *
     * @return l'avant-dernier noeud, ou {@code null} si la liste contient moins de deux éléments
     */
    public Noeud getAvantDernier() {
        if (tete == null || tete.getSuivant() == null)
            return null;
        else {
            Noeud courant = tete;
            Noeud suivant = courant.getSuivant();
            while (suivant.getSuivant() != null) {
                courant = suivant;
                suivant = suivant.getSuivant();
            }
            return courant;
        }
    }

    /**
     * Inverse l'ordre des éléments de la liste en renversant les liens entre noeuds.
     * La taille reste inchangée.
     */
    public void inverser() {
        Noeud precedent = null;
        Noeud courant = tete;
        while (courant != null) {
            Noeud next = courant.getSuivant();
            courant.setSuivant(precedent);
            precedent = courant;
            courant = next;
        }
        tete = precedent;
    }

    /**
     * Recherche le noeud précédant {@code r} dans la liste.
     *
     * @param r noeud dont le prédécesseur est recherché
     * @return le noeud précédant {@code r}, ou {@code null} si {@code r} est la tête,
     *         est absent de la liste, ou si la liste est vide
     */
    public Noeud getPrecedent(Noeud r) {
        Noeud precedent = null;
        Noeud courant = tete;
        while (courant != null) {
            if (courant == r) {
                return precedent;
            }
            precedent = courant;
            courant = courant.getSuivant();
        }
        return null;
    }

    /**
     * Échange la position de deux noeuds dans la liste. Si l'un des deux est la tête,
     * celle-ci est réaffectée. L'échange est sans effet si les deux noeuds sont identiques.
     *
     * @param r1 premier noeud à échanger
     * @param r2 second noeud à échanger
     */
    public void echanger(Noeud r1, Noeud r2) {
        if (r1 == r2) {
            return;
        }

        Noeud precedentR1 = getPrecedent(r1);
        Noeud precedentR2 = getPrecedent(r2);

        if (precedentR1 != null) {
            precedentR1.setSuivant(r2);
        }
        if (precedentR2 != null) {
            precedentR2.setSuivant(r1);
        }
        if (r1 == tete) {
            tete = r2;
        } else if (r2 == tete) {
            tete = r1;
        }
        Noeud temp = r2.getSuivant();
        r2.setSuivant(r1.getSuivant());
        r1.setSuivant(temp);
    }

}