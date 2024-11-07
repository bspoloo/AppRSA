package com.example.apprsa

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apprsa.Classes.CopyButton
import com.example.apprsa.Classes.Encrypt
import com.example.apprsa.Generate.Generate
import com.example.apprsa.Generate.PrimeNumbers
import com.example.apprsa.Interfaces.IKey

class KeyGenerationActivity : AppCompatActivity() {
    private lateinit var primeNumbers : PrimeNumbers
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_key_generation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val inputMessage : EditText = findViewById<EditText>(R.id.inputMessage)
        val inputEncryptedMessage : TextView = findViewById<EditText>(R.id.inputEncryptedMessage)
        val inputPrivateKey : TextView = findViewById<EditText>(R.id.inputPrivateKey)
        val inputPublicKey : TextView = findViewById<EditText>(R.id.inputPublicKey)
        primeNumbers = PrimeNumbers()

        findViewById<Button>(R.id.buttonGenerateKeys).setOnClickListener {

            if (inputMessage.text.toString().isNotEmpty())
            {
                val pairNumbers : Pair<Int, Int> = generatePrimeNumbers(1,10)
                val generate = Generate(pairNumbers.first, pairNumbers.second)
                val encrypt  = Encrypt(generate.getE(), generate.getN())
                val publicKey : IKey = generate.getPublicKey()
                val privateKey : IKey = generate.getPrivateKey()
                val encryptedMessage = encrypt.encryptMessage(inputMessage.text.toString())
                inputEncryptedMessage.setText(encryptedMessage.joinToString(","))
                inputPublicKey.setText(publicKey.getKey().first.toString()+","+publicKey.getKey().second.toString())
                inputPrivateKey.setText(privateKey.getKey().first.toString() +","+privateKey.getKey().second.toString())

                return@setOnClickListener;
            }
            Toast.makeText(this, "Introduzca el mensaje a encriptar", Toast.LENGTH_SHORT).show()
        }
        CopyButton.enableCopyButton(this)
    }
    fun generatePrimeNumbers(min : Int, max : Int) :Pair<Int, Int>{
        val p : Int = primeNumbers.getPrimeNumbers(min, max)
        var q : Int = 0
        do{
            q = primeNumbers.getPrimeNumbers(min, max)
        }while (p > q || p == 0)
        return Pair(p,q)
    }
}