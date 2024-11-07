package com.example.apprsa.Generate

import com.example.apprsa.Classes.Modular
import com.example.apprsa.Classes.PrivateKey
import com.example.apprsa.Classes.PublicKey
import com.example.apprsa.Interfaces.IGenerate

class Generate(p: Int, q: Int) : IGenerate{
    private var modular: Modular
    private var primeNumbers: PrimeNumbers
    private var n : Int = 0
    private var z : Int = 0
    private var e : Int = 0

    init {
        primeNumbers = PrimeNumbers()
        modular = Modular()
        n = ProductNumber.getProduct(p, q)
        z = ProductNumber.getPhiEuler(p, q)
        e = primeNumbers.getCoprimeNumber(z)
    }
    override fun getPublicKey(): PublicKey {
        return PublicKey(e,n)
    }
    override fun getPrivateKey(): PrivateKey {
        var d : Int = modular.modInverse(e, z)
        return PrivateKey(d, n)
    }
    fun getE() : Int{
        return e;
    }
    fun getN() : Int{
        return n;
    }
}