import android.widget.Spinner
import com.mgh.pmdm.parques.databinding.FragmentSecondBinding
import com.mgh.pmdm.parques.model.Park

class SecondFragment(private val binding: FragmentSecondBinding) {

    fun bindData(park: Park) {
        binding.Name.setText(park.name)
        binding.Description.setText(park.desc)
        binding.Phone.setText(park.phone)
        binding.webSite.setText(park.webiste)

        park.openingTime?.let {
            getSpinnerIndex(binding.SpinnerOpeningTime,
                it
            )
        }?.let { binding.SpinnerOpeningTime.setSelection(it) }
        park.closingTime?.let {
            getSpinnerIndex(binding.SpinnerClosingTime,
                it
            )
        }?.let { binding.SpinnerClosingTime.setSelection(it) }

        binding.cbSport.isChecked = park.sports ?: false
        binding.cbChildren.isChecked = park.children ?: false
        binding.cbBar.isChecked = park.Bar ?: false
        binding.cbMascotas.isChecked = park.Pets ?: false
    }

    private fun getSpinnerIndex(spinner: Spinner, value: String): Int {
        for (i in 0 until spinner.adapter.count) {
            if (spinner.adapter.getItem(i).toString() == value) return i
        }
        return 0
    }
}
