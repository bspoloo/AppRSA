package com.example.apprsa.Generate

import kotlin.random.Random

class PrimeNumbers {
        fun getPrimeNumbers(min : Int, max : Int) : Int{
            var primeNumber : Int
            do {
                primeNumber = Random.nextInt(min, max)
            }while (!isPrime(primeNumber))
            return primeNumber
        }
        fun getCoprimeNumber(z : Int) : Int{
            var e = 0;
            do {
                e = getPrimeNumbers(1 , z)
            }while (e < 1 || (e > z))
            return e
        }
        private fun isPrime(num : Int) :Boolean{
            if (num <= 1) return false
            if (num <= 3) return true
            if (num % 2 == 0 || num % 3 == 0) return false
            var i = 5
            while (i * i <= num) {
                if (num % i == 0 || num % (i + 2) == 0) return false
                i += 6
            }
            return true
    }

}