package cl.awakelab.ejerciciodieciseis

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.awakelab.ejerciciodieciseis.databinding.ItemBinding
import coil.load


class PaisesAdapter : RecyclerView.Adapter<PaisesAdapter.ViewHolder>() {

    var paises = mutableListOf<Pais>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return paises.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = paises[position]
        holder.bind(item)
    }

    fun setData(listaPaises: List<Pais>) {
        this.paises = listaPaises.toMutableList()
    }

    class ViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pais: Pais) {
            binding.tvNombrePais.text = pais.nombre
            binding.tvPoblacionPais.text = pais.poblacion.toString()
            binding.imagePais.load(pais.imgUrl)
        }
    }
}