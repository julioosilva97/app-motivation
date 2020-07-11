package btech.com.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import btech.com.motivation.R
import btech.com.motivation.infra.MotivationConstants
import btech.com.motivation.infra.SecutityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var mSecurity: SecutityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if(supportActionBar != null){
            supportActionBar!!.hide()
        }

        mSecurity = SecutityPreferences(this)

        btsSalvarNome.setOnClickListener(this)

        verificarNomeUsuario()
    }

    override fun onClick(view: View) {

        val id = view.id

        if(id === R.id.btsSalvarNome){

            salvarNome()
        }

    }

    private fun salvarNome() {

        val nome = editNome.text.toString()

        if(nome != ""){

            mSecurity.storeString(MotivationConstants.KEY.PERSON_NAME,nome)
            startActivity(Intent(this, MainActivity::class.java))
            finish() // mata essa activity do sistema
        }else{
          Toast.makeText(this,"Infome um nome!",Toast.LENGTH_SHORT).show()
        }
    }

    private fun verificarNomeUsuario() {

        val nomeUsuario = mSecurity.getStoredString(MotivationConstants.KEY.PERSON_NAME)
        if(nomeUsuario != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        editNome.setText(nomeUsuario)
    }
}
