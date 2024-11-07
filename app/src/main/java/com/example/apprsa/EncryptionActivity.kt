package com.example.apprsa

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apprsa.Classes.Decrypt
import com.example.apprsa.Classes.PrivateKey
import com.example.apprsa.Classes.PublicKey

class EncryptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_encryption)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val inputPrivateKeyDecrypt = findViewById<EditText>(R.id.inputPrivateKeyDecrypt)

        findViewById<Button>(R.id.buttonDecryptCode).setOnClickListener {
            if (inputPrivateKeyDecrypt.text.isEmpty()){
                Toast.makeText(this, "No tiene llave privada", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val separatedKey = inputPrivateKeyDecrypt.text.split(",")
            val privateKey: PrivateKey =
                PrivateKey(separatedKey.elementAt(0).toInt(), separatedKey.elementAt(1).toInt())
            decryptMessage(privateKey)
        }
    }
    fun decryptMessage(privateKey: PrivateKey){
        Log.e("Private Key", privateKey.getKey().first.toString() + "-" +privateKey.getKey().second.toString() )
        val  decrypt = Decrypt( privateKey.getKey().first, privateKey.getKey().second)
        val message = decrypt.decryptMessage(findViewById<EditText>(R.id.inputEncryptCode).text.toString())
        findViewById<EditText>(R.id.inputDesEncryptedMessage).setText(message.toString())
    }
}