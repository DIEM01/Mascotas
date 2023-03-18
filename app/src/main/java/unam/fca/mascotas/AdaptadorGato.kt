package unam.fca.mascotas


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorGato(private val context: Context,
                    private val imgato: MutableList<MasGato>):BaseAdapter() {
    override fun getCount(): Int {
        return imgato.size
    }

    override fun getItem(position: Int): Any {
        return imgato[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view= convertView
        val holder: ItemHolder
        if (view== null){
            view = LayoutInflater.from(context).inflate(R.layout.gatos, null)
            holder = ItemHolder(view)
            view.tag = holder

        }else
        {
            holder =view.tag as ItemHolder


        }
        val animalg: MasGato = imgato[position]
        holder.imagen.setImageResource(animalg.imagen)
        holder.animal.text = animalg.gato

        return view as View
    }
    internal class ItemHolder (view: View){
        var imagen : ImageView= view.findViewById(R.id.imagen)
        var animal :TextView = view.findViewById(R.id.aniGato)

    }

}