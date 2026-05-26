package ragavi.com.retrofit25

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MonsterAdapter(
    private val list: List<Monster>
) : RecyclerView.Adapter<MonsterAdapter.MonsterViewHolder>() {

    class MonsterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Mantenemos los IDs originales de tu XML para evitar errores
        val imgMonster: ImageView = view.findViewById(R.id.imgWine)
        val txtName: TextView = view.findViewById(R.id.txtWineName)
        val txtExtra: TextView = view.findViewById(R.id.txtWinery)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonsterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_monster, parent, false)
        return MonsterViewHolder(view)
    }

    override fun onBindViewHolder(holder: MonsterViewHolder, position: Int) {
        val monster = list[position]

        // Asignamos el nombre del monstruo
        holder.txtName.text = monster.name

        // Ocultamos el texto extra que no usamos
        holder.txtExtra.visibility = View.GONE

        // Usamos Glide para descargar y mostrar la imagen del monstruo
        Glide.with(holder.itemView.context)
            .load(monster.image)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(android.R.drawable.ic_menu_close_clear_cancel)
            .into(holder.imgMonster)
    }

    override fun getItemCount() = list.size
}