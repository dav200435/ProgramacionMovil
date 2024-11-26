import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parquesguiado.R

class MyAdapter(private val names: Array<String>, private val descriptions: Array<String>) :
    RecyclerView.Adapter<MyAdapter.ParkViewHolder>() {

    class ParkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val parkImageView: ImageView = itemView.findViewById(R.id.parkImageView)
        val parkName: TextView = itemView.findViewById(R.id.parkName)
        val parkDesc: TextView = itemView.findViewById(R.id.parkDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ParkViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParkViewHolder, position: Int) {
        holder.parkName.text = names[position]
        holder.parkDesc.text = descriptions[position]
        // Aquí puedes establecer una imagen específica si los datos incluyen imágenes
    }

    override fun getItemCount(): Int = names.size
}
