package com.example.apprsa.Classes

import android.util.Log
import java.math.BigInteger

class Decrypt(private val d : Int, private val n : Int) {

    private fun decryptRSA(c: BigInteger): BigInteger {
        return c.modPow(d.toBigInteger(), n.toBigInteger())
    }
    fun decryptMessage(message: String): String {
        Log.e("Message", message.toString() )
        val bigIntegerList = message
            .split(",")
            .map { BigInteger(it) }

        val decryptedMessage = StringBuilder()

        for (c in bigIntegerList) {
            val m = decryptRSA(c)
            Log.e("Message decrypt", m.toString() )
            decryptedMessage.append(m.toChar())
        }
        Log.e("Message", decryptedMessage.toString() )
        return decryptedMessage.toString()
    }
}