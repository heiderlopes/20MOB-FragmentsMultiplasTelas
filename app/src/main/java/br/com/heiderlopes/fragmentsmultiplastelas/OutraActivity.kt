package br.com.heiderlopes.fragmentsmultiplastelas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.heiderlopes.fragmentsmultiplastelas.models.Item
import kotlinx.android.synthetic.main.activity_outra.*

class OutraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outra)

        val item = intent.getParcelableExtra<Item>("meuItem")
        textView.text = item.title
    }
}
