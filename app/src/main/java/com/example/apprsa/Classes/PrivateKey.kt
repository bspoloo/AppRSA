package com.example.apprsa.Classes

import com.example.apprsa.Interfaces.IKey

class PrivateKey(private val d : Int, private val n : Int) : IKey {
    override fun getKey(): Pair<Int, Int> {
        return Pair(d,n)
    }

}