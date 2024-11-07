package com.example.apprsa.Classes

import android.util.Log
import java.math.BigInteger
import kotlin.math.pow

class Encrypt(private val e: Int, private val n: Int) {

    private fun encryptRSA(m: BigInteger): BigInteger {
        return m.modPow(e.toBigInteger(), n.toBigInteger())
    }

    fun encryptMessage(message: String): List<BigInteger> {
        val encryptedMessage = mutableListOf<BigInteger>()
        for (char in message) {
            val m = char.code.toBigInteger()
            val c = encryptRSA(m)

            Log.d("Encrypting", "the encrypted char= $char m= $m -> c=$c")
            encryptedMessage.add(c)
        }
        return encryptedMessage
    }
}