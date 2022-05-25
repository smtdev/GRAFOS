package com.sergio.grafos;

import java.util.Objects;

/**
 *
 * @author sergiomolinagonzalez
 */
public class KruskalClass {
    
    private int nodoIncial;
    private int nodoFinal;
    private int peso;
    private String nodo;

    public KruskalClass() {
    }

    public KruskalClass(int nodoIncial, int nodoFinal, int peso, String nodo) {
        this.nodoIncial = nodoIncial;
        this.nodoFinal = nodoFinal;
        this.peso = peso;
        this.nodo = nodo;
    }
    
    public int getNodoIncial() {
        return this.nodoIncial;
    }

    public void setNodoIncial(int nodoIncial) {
        this.nodoIncial = nodoIncial;
    }

    public int getNodoFinal() {
        return this.nodoFinal;
    }

    public void setNodoFinal(int nodoFinal) {
        this.nodoFinal = nodoFinal;
    }

    public int getPeso() {
        return this.peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    public String getNodo() {
        return this.nodo;
    }

    public void setNodo(String nodo) {
        this.nodo = nodo;
    }

    @Override
    public String toString() {
        return this.getNodo()+ " │ " + this.getPeso() ;
    }

    int compareTo(KruskalClass b) {
        if (this.getPeso()>b.getPeso()) return 1;
        if (this.getPeso()<b.getPeso()) return -1;
        return 0;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KruskalClass other = (KruskalClass) obj;
        if (this.nodoIncial != other.nodoIncial) {
            return false;
        }
        if (this.nodoFinal != other.nodoFinal) {
            return false;
        }
        if (this.peso != other.peso) {
            return false;
        }
        return Objects.equals(this.nodo, other.nodo);
    }        
    
}
