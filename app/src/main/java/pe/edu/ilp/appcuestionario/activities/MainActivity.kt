package pe.edu.ilp.appcuestionario.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import pe.edu.ilp.appcuestionario.R
import pe.edu.ilp.appcuestionario.model.Pregunta
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    var preguntas = ArrayList<Pregunta>()
    var posicionActual = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Este método añade preguntas a la lista
        cargarPreguntas()

        //Este método muestra las preguntas al usuario
        mostrarPreguntas()

            ejer1()
            ejer2()
            ejer3()



        val btnVerdad = findViewById<android.view.View>(R.id.btnVerdadero)
        btnVerdad.setOnClickListener{
            if (preguntas[posicionActual].respuesta)
            Toast.makeText(this,"La respuesta es correcta", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"La respuesta es incorrecta", Toast.LENGTH_SHORT).show()

        }

        val btnIncorrecto = findViewById<android.view.View>(R.id.btnFalso)
        btnIncorrecto.setOnClickListener{
            if(!preguntas[posicionActual].respuesta)
            Toast.makeText(this,"La respuesta es correcta", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"La respuesta es incorrecta", Toast.LENGTH_SHORT).show()
        }



        val btnNext = findViewById<Button>(R.id.btnSiguiente)
        btnNext.setOnClickListener{
            try {
                posicionActual ++
                mostrarPreguntas()
            }
            catch (e:Exception){
                Toast.makeText(this,"No hay mas preguntas Siguientes", Toast.LENGTH_SHORT).show()
            }

        }




        val btnAnterior = findViewById<Button>(R.id.btnAnterior)
        btnAnterior.setOnClickListener{
            try {
                posicionActual --
                mostrarPreguntas()
            }
            catch (e:Exception){
                Toast.makeText(this,"No hay mas preguntas anteriores", Toast.LENGTH_SHORT).show()
            }

        }



    }

    fun cargarPreguntas() {
        preguntas.add(Pregunta("Caracas es la capital de Venezuela",true))
        preguntas.add(Pregunta("Piura es un departamento que pertenece a Ecuador", false))
        preguntas.add(Pregunta("Uruguay es un país Latinoamericano", true))
        preguntas.add(Pregunta("Lima es la capital de Chile", false))
    }

    private fun mostrarPreguntas() {
        val textoPregunta = findViewById<TextView>(R.id.tvPregunta)
        textoPregunta.text = preguntas[posicionActual].enunciado
    }



   fun ejer1(){
       for (i in 50 downTo 2){
           println("Numero $i")
       }
   }


    fun ejer2() {
        val num = 5
        var factorial : Long =1
        for (i in 1..num)
        {
            factorial *=i.toLong()
        }
        println("El factorial es $num=$factorial")
    }



    fun ejer3(){
            var base : Int=5
            var altura : Int=6
            var area = (base*altura)/2
        println("El Area del triangulo es igual a $area")
    }


}