package cl.eme.desafiociclobike

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import cl.eme.desafiociclobike.databinding.ActivityMainBinding
import com.example.ciromine.ciclobike.SetupCiclovias
import java.text.FieldPosition

/*
Desafío - Ciclobike
[X] 1. Crear el proyecto Android de cero, compatible con Kotlin.
[X] 2. Convertir las clases Java que vienen de recursos en el proyecto a clases Kotlin.
[X] 3. Crear las listas en base a las clases entregadas para comenzar el proyecto.
[X] 4. Crear una interfaz gráfica que cumpla con los requerimientos.
[X] 5. Hacer un buen uso del null safety mientras se desarrolla el proyecto.
[X] 6. Crear el filtro especificado usando la sentencia when.

 Desafío - Ciclobike 2.0
[X] 1. Actualizar la Activity del desafío 1, usando los view bindings.
[X] 2. Actualizar los listener de los botones a las funciones lambdas de kotlin.
[X] 3. Modificar la interfaz a lo nuevo requerido que incluye spinner
[] 4. Ahora usar la función filter para filtrar.
[] 5. Agregar botón que invierte el orden de la lista.
   Opcional
[] 6. Agregar EditText más botón filtrar, que filtra según lo escrito en el editText.
[] 7. Hacer que el filtro anterior no sea sensible a mayúsculas y minúsculas.
[] 8. Hacer otro filtro igual que el anterior, pero que filtre por el nombre de la ciclovía.
[] 9. Hacer otro filtro igual que el anterior, pero donde se ingrese un número y se filtrara si la
      comuna tiene un largo mayor a ese que se ingresó, además la app no debe caerse si se ingresa un valor no numérico.
[] 10.Hacer otro filtro igual que el anterior, pero donde se ingrese un número y se filtrara si la nombre de la ciclovía.
 */

class MainActivity : AppCompatActivity() {
    val cicloviaAdapter = CicloviaAdapter()
    val setupCiclovias=SetupCiclovias()
    val listaSpinner= setupCiclovias.getListaSpinner()

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvLista.adapter = cicloviaAdapter
        binding.rvLista.layoutManager = LinearLayoutManager(this)
        val spinAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaSpinner)
        binding.spinnerBike.adapter = spinAdapter
        binding.spinnerBike.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                when (listaSpinner[position]) {
                    "Mostrar todo" -> cicloviaAdapter.updateAdapterNoFilter()
                    else -> cicloviaAdapter.updateAdapterFilter(listaSpinner[position])
                }
            }


            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }
}