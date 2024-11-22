package ru.batir8888.elements1511

import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import ru.batir8888.elements1511.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val naborCB = arrayListOf(false, false, false, false, false, false)
        var typeOfDelivery = TypeOfDelivery.Samovivoz
        var bahil = false
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        (binding.NaborRB[0] as RadioButton).isChecked = true

        binding.Button.setOnClickListener{
            naborCB[0] = (binding.NaborCB[0] as CheckBox).isChecked
            naborCB[1] = (binding.NaborCB[1] as CheckBox).isChecked
            naborCB[2] = (binding.NaborCB[2] as CheckBox).isChecked
            naborCB[3] = (binding.NaborCB[3] as CheckBox).isChecked
            naborCB[4] = (binding.NaborCB[4] as CheckBox).isChecked
            naborCB[5] = (binding.NaborCB[5] as CheckBox).isChecked

            typeOfDelivery = if ((binding.NaborRB[0] as RadioButton).isChecked){
                    TypeOfDelivery.Samovivoz
                }
                else if ((binding.NaborRB[1] as RadioButton).isChecked) {
                    TypeOfDelivery.Kurier
                }
                else{
                    TypeOfDelivery.Drone
                }

            bahil = binding.Switch.isChecked

            Snackbar.make(binding.root,
                "Заказ принят. ${getStringOfDeliveryType(typeOfDelivery)}",
                Snackbar.LENGTH_SHORT).show()
        }
    }
}

fun getStringOfDeliveryType(type: TypeOfDelivery) : String{
    when (type){
        TypeOfDelivery.Drone -> return "Дрон прилетит к вам через 5 минут."
        TypeOfDelivery.Kurier -> return "Курьер прибудет к вам через 15 минут."
        TypeOfDelivery.Samovivoz -> return "Заказ скоро будет запакован, приезжайте."
    }
}

enum class TypeOfDelivery{
    Drone, Kurier, Samovivoz
}