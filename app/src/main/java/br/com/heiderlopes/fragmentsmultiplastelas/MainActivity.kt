package br.com.heiderlopes.fragmentsmultiplastelas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import br.com.heiderlopes.fragmentsmultiplastelas.models.Item
import br.com.heiderlopes.fragmentsmultiplastelas.views.activities.DetalheItemActivity
import br.com.heiderlopes.fragmentsmultiplastelas.views.fragments.DetalheItemFragment
import br.com.heiderlopes.fragmentsmultiplastelas.views.listeners.OnItemSelectedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnItemSelectedListener {
    //Variavel para controle se a tela de detalhe e a lista estao na mesma tela
    private var telaUnica = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        determinePaneLayout()
    }
    private fun determinePaneLayout() {
        val fragmentItemDetail = findViewById<FrameLayout>(R.id.flDetailContainer)
        if (fragmentItemDetail != null) {
            telaUnica = true
        }
    }

    override fun onItemSelected(item: Item) {
        if (telaUnica) {
            // Atualiza o framelayout com o fragment
            val detalheItemFragment = DetalheItemFragment.newInstance(item!!)
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.flDetailContainer, detalheItemFragment)
            ft.commit()
        } else {
            //Inicia a Activity de detalhe caso não seja um tablet
            val i = Intent(this, DetalheItemActivity::class.java)
            i.putExtra("item", item)
            startActivity(i)
        }
    }
}