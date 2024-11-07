package com.example.apprsa.Interfaces

import com.example.apprsa.Classes.PrivateKey
import com.example.apprsa.Classes.PublicKey

interface IGenerate {
    fun getPublicKey() : PublicKey
    fun getPrivateKey() : PrivateKey
}