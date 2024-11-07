package com.example.apprsa.Classes

import com.example.apprsa.Interfaces.IKey

class PublicKey(private val e : Int, private val n : Int) : IKey {

    override fun getKey() : Pair<Int, Int> {
        return Pair(e,n)
    }
}