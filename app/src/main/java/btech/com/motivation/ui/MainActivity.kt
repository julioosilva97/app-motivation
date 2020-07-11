package btech.com.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import btech.com.motivation.R
import btech.com.motivation.infra.MotivationConstants
import btech.com.motivation.infra.SecutityPreferences
import btech.com.motivation.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var mFilter : Int = MotivationConstants.FILTRO_FRASE.todos
    private val mMoch : Mock = Mock()
    private lateinit var mSecurity: SecutityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(supportActionBar != null){
            supportActionBar!!.hide()
        }

        mSecurity = SecutityPreferences(this)

        setListeners()
        handleFilter(R.id.imgTodos)
        refrashPhrse()
        txtNome.setText( "Olá, ${mSecurity.getStoredString(MotivationConstants.KEY.PERSON_NAME)} !"  )

    }

    private fun verificarNomeUsuario() {
        txtNome.text = mSecurity.getStoredString(MotivationConstants.KEY.PERSON_NAME)
    }

    private fun setListeners() {
        imgTodos.setOnClickListener(this)
        imgSol.setOnClickListener(this)
        imgFeliz.setOnClickListener(this)
        btNovaFrase.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id

        var listaID = listOf(R.id.imgFeliz,R.id.imgSol,R.id.imgTodos)

        if(id in listaID){
            handleFilter(id)
        }else if (id == R.id.btNovaFrase){
            refrashPhrse()
        }
    }

    private fun refrashPhrse() {
        txtFrase.text = mMoch.getFrase(mFilter)
    }

    private fun handleFilter(id: Int) {

        imgTodos.setColorFilter(resources.getColor(R.color.white))
        imgSol.setColorFilter(resources.getColor(R.color.white))
        imgFeliz.setColorFilter(resources.getColor(R.color.white))

        if(id == R.id.imgTodos){
            mFilter = MotivationConstants.FILTRO_FRASE.todos
            imgTodos.setColorFilter(resources.getColor(R.color.colorAccent))
        } else if(id == R.id.imgSol){
             mFilter = MotivationConstants.FILTRO_FRASE.dia
            imgSol.setColorFilter(resources.getColor(R.color.colorAccent))
        }else{
            mFilter = MotivationConstants.FILTRO_FRASE.feliz
            imgFeliz.setColorFilter(resources.getColor(R.color.colorAccent))
        }
    }
}
