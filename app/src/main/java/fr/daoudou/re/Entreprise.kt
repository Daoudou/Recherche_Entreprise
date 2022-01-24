package fr.daoudou.re

import java.io.Serializable


data class Entreprise(var name:String): Comparable<Entreprise>, Serializable{

    override fun toString(): String {
        return "$name"
    }

    override fun compareTo(other: Entreprise): Int {
        return name.compareTo(other.name)
    }
}

