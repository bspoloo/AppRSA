package com.example.apprsa.Classes

class GCD {
    fun getExtendedGCD(a: Int, b: Int): Pair<Int, Int>{
        var s = 0
        var oldS = 1
        var t = 1
        var oldT = 0
        var r = b
        var oldR = a

        while (r != 0) {
            val quotient = oldR / r

            var temp = r
            r = oldR - quotient * r
            oldR = temp

            temp = s
            s = oldS - quotient * s
            oldS = temp

            temp = t
            t = oldT - quotient * t
            oldT = temp
        }
        return Pair(oldS, oldT)
    }
}