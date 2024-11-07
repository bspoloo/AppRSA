package com.example.apprsa.Classes

import android.util.Log
import java.math.BigInteger

class Decrypt(private val d : Int, private val n : Int) {

    private fun decryptRSA(c: BigInteger): BigInteger {
        return c.modPow(d.toBigInteger(), n.toBigInteger())
    }
    fun decryptMessage(message: String): String {
        val bigIntegerList = message
            .split(",")
            .map { it.trim() }
            .map { BigInteger(it) }

        val decryptedMessage = StringBuilder()
        for (c in bigIntegerList) {
            val m = decryptRSA(c)
            Log.d("Decrypting", "the decrypted c= $c m= $m")
            decryptedMessage.append(m.toChar())
        }
        return decryptedMessage.toString()
    }
}