package br.com.heiderlopes.fragmentsmultiplastelas.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.heiderlopes.fragmentsmultiplastelas.R
import br.com.heiderlopes.fragmentsmultiplastelas.models.Item
import br.com.heiderlopes.fragmentsmultiplastelas.views.fragments.DetalheItemFragment

class DetalheItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detalhe_item)

        val item = intent.getParcelableExtra("item") as Item

        if (savedInstanceState == null) {
            val detalheItemFragment = DetalheItemFragment.newInstance(item)
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.flDetailContainer, detalheItemFragment)
            ft.commit()
        }
    }
}