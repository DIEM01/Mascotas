package unam.fca.mascotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var gridPerro: GridView
    private lateinit var spinner: Spinner
    private lateinit var gridGatos: GridView
    private lateinit var gridAves: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gridPerro = findViewById(R.id.gridPerros)
        gridGatos = findViewById(R.id.gridGatos)
        gridAves = findViewById(R.id.gridAves)
        spinner = findViewById(R.id.spinVista)
        iniciargrid()
        iniciarSpinner()
        iniciargridcat()
        iniciargridAve()
    }
    private fun iniciarSpinner() {
        spinner.adapter = ArrayAdapter(
            this,
            androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.vistas)
        )
        spinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    when (position) {
                        0 -> {
                            gridGatos.visibility=View.INVISIBLE
                            gridPerro.visibility=View.VISIBLE
                            gridAves.visibility=View.INVISIBLE
                        }
                        1 -> {
                            gridGatos.visibility=View.VISIBLE
                            gridPerro.visibility=View.INVISIBLE
                            gridAves.visibility=View.INVISIBLE
                        }
                        2-> {
                            gridGatos.visibility=View.INVISIBLE
                            gridPerro.visibility=View.INVISIBLE
                            gridAves.visibility=View.VISIBLE
                        }

                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
    }
    private fun getMascotas(): MutableList<Mascotas> {
        val imperro: MutableList<Mascotas> = mutableListOf()
        imperro.add(Mascotas(R.mipmap.bulldog, "Bulldog"))
        imperro.add(Mascotas(R.mipmap.dalmata, "Dalmata"))
        imperro.add(Mascotas(R.mipmap.labrador, "Labrador"))
        imperro.add(Mascotas(R.mipmap.sanbernardo, "San Bernardo"))
        imperro.add(Mascotas(R.mipmap.chowchow, "Chow Chow"))
        imperro.add(Mascotas(R.mipmap.husky, "Husky"))
        imperro.add(Mascotas(R.mipmap.pastoraleman, "Pastor Aleman"))
        imperro.add(Mascotas(R.mipmap.sharpei, "Sharpei"))
        imperro.add(Mascotas(R.mipmap.beagle, "Beagle"))
        imperro.add(Mascotas(R.mipmap.poodle, "Poodle"))

        return imperro
    }

    private fun getMasGato(): MutableList<MasGato> {
        val imgato: MutableList<MasGato> = mutableListOf()
        imgato.add(MasGato(R.mipmap.angoraturco, "Angora Turco"))
        imgato.add(MasGato(R.mipmap.persa, "Persa"))
        imgato.add(MasGato(R.mipmap.siames, "Siames"))
        imgato.add(MasGato(R.mipmap.himalaya, "Himalaya"))
        imgato.add(MasGato(R.mipmap.ragdoll, "Ragdoll"))
        imgato.add(MasGato(R.mipmap.snowshoe, "Snowshoe"))
        imgato.add(MasGato(R.mipmap.sphynx, "Sphynx"))
        imgato.add(MasGato(R.mipmap.bengala, "Bengala"))
        imgato.add(MasGato(R.mipmap.burmes, "Burmés"))
        imgato.add(MasGato(R.mipmap.devonrex, "Devon Rex"))

        return imgato
    }
    private fun getMasAve(): MutableList<MasAve> {
        val imave: MutableList<MasAve> = mutableListOf()
        imave.add(MasAve(R.mipmap.agaporni, "Agaporni"))
        imave.add(MasAve(R.mipmap.canario, "Canario"))
        imave.add(MasAve(R.mipmap.guacamaya, "Guacamaya"))
        imave.add(MasAve(R.mipmap.pato, "Pato"))
        imave.add(MasAve(R.mipmap.cacatua, "Cacatua"))
        imave.add(MasAve(R.mipmap.flamenco, "Flamenco"))
        imave.add(MasAve(R.mipmap.diamante, "Diamante"))
        imave.add(MasAve(R.mipmap.loro, "Loro"))
        imave.add(MasAve(R.mipmap.periquito, "Periquito"))
        imave.add(MasAve(R.mipmap.tucan, "Tucán"))

        return imave
    }
    private fun iniciargrid(){
        gridPerro.adapter= AdaptadorGrid(this, getMascotas())
        gridPerro.setOnItemClickListener{parent, view,position, id ->
            val auto = parent.getItemAtPosition(position) as Mascotas
            Toast.makeText(this,"Perro: ${auto.perro}"
                    , Toast.LENGTH_SHORT).show()
        }
    }
    private fun iniciargridcat(){
        gridGatos.adapter= AdaptadorGato(this, getMasGato())
        gridGatos.setOnItemClickListener{parent, view,position, id ->
            val autol = parent.getItemAtPosition(position) as MasGato
            Toast.makeText(this,"Gato: ${autol.gato}"
                , Toast.LENGTH_SHORT).show()
        }
    }
    private fun iniciargridAve(){
        gridAves.adapter= AdaptadorAve(this, getMasAve())
        gridAves.setOnItemClickListener{parent, view,position, id ->
            val autoll = parent.getItemAtPosition(position) as MasAve
            Toast.makeText(this,"Ave: ${autoll.ave}"
                , Toast.LENGTH_SHORT).show()
        }
    }

}

