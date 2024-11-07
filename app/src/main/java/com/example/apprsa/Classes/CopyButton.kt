package com.example.apprsa.Classes

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.apprsa.MainActivity
import com.example.apprsa.R

class CopyButton {
    companion object{
        fun enableCopyButton(activity: Activity){
            val buttonCopyText = activity.findViewById<Button>(R.id.buttonCopyCode)
            val clipboard = activity.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

            buttonCopyText.setOnClickListener {
                var textCopy = activity.findViewById<TextView>(R.id.inputEncryptedMessage).text.toString()
                val clip = ClipData.newPlainText("Texto copiado", textCopy)
                clipboard.setPrimaryClip(clip)
                Toast.makeText(activity, "$textCopy copiado exitosamente", Toast.LENGTH_SHORT).show()
            }
        }
    }
}