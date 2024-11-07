package com.example.apprsa.Generate

class ProductNumber {
    companion object{
        //calculate the product prime numbers
        fun getProduct(a : Int, b : Int) : Int{
                return a * b;
        }
        //calculate the Z
        fun getPhiEuler(p : Int, q : Int) : Int{
                return (p-1)*(q-1)
        }
    }
}