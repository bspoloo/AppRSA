package com.example.apprsa.Classes

class Modular {
    private var gcd: GCD
    init {
        gcd = GCD()
    }

    fun modInverse(e: Int, phi: Int) : Int{
        val (x, _) = gcd.getExtendedGCD(e, phi)
        return if (x < 0) x + phi else x
    }
}