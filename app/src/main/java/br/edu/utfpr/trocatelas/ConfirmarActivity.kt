package br.edu.utfpr.trocatelas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmarActivity : AppCompatActivity() {

    private lateinit var tvCod : TextView
    private lateinit var tvQtd : TextView
    private lateinit var tvValor : TextView
    private lateinit var btEnviar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmar)

        tvCod = findViewById( R.id.tvCod )
        tvQtd = findViewById( R.id.tvQtd )
        tvValor = findViewById( R.id.tvValor )

        btEnviar.setOnClickListener{
            btEnviarOnClick()
        }

        val cod = intent.getStringExtra( "cod" )
        val qtd = intent.getStringExtra( "qtd" )
        val valor = intent.getStringExtra( "valor" )

        tvCod.setText( cod )
        tvQtd.setText( qtd )
        tvValor.setText( valor )

    }

    private fun btEnviarOnClick() {

        val sms_body = "Cod: ${tvCod.text}  Qtd: ${tvQtd.text}  Valor: ${tvValor.text} "
        val phone_number = "sms:+5546991112233"

        val intent = Intent( Intent.ACTION_VIEW )
        intent.setData( Uri.parse( phone_number ) )
        intent.putExtra( "sms_body", sms_body )

        if ( intent.resolveActivity( getPackageManager()) != null ) {
            startActivity( intent )
        }

    }
}