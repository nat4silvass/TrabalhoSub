
package com.mycompany.trabalhosub;

import java.util.Comparator;

public class ComparadorForcaPokemon implements Comparator<Pokemon> {
    @Override
    public int compare(Pokemon p1, Pokemon p2) {
        return Integer.compare(p1.getForca(), p2.getForca());
    }
}

