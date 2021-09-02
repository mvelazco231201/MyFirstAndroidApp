package com.aplicandolenguajekotlin.myfirstandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculated = findViewById<Button>(R.id.btnCalculated) //traemos el elemento a la variable
        val uName = findViewById<EditText>(R.id.userName) //traemos el nombre del usuario
        val uAge =findViewById<EditText>(R.id.userAge) //traemos la edad del usuario
        btnCalculated.setOnClickListener() {

            if (uName.text.isEmpty() || uAge.text.isEmpty()) {
                Toast.makeText(this, "Favor de ingresar los valores solicitados", Toast.LENGTH_LONG).show()
            }
            else{
                val valueN = uName.text.toString()
                val valueA = (uAge.text.toString()).toInt()
                if (valueA in 1..9) { //si la edad es de un dígito
                    val num = valueA * 7 //multiplicamos la edad por 7
                    if (num in 14..63) { //si el número obtenido al *7 fue de dos cifras
                        val resNum = addDig(num) //se realiza la suma de los digitos mediante la funcion
                        if (resNum in 10..13) {//si el resultado fue de dos cifras (las posibles 10,11,13)
                            val resNum1 = addDig(resNum) //realizamos la suma de nuevo
                            Toast.makeText(
                                this,
                                "Bienvenido $valueN tu número de la suerte es $resNum1",
                                Toast.LENGTH_LONG
                            ).show()
                        }else{
                            val resNu = addDig(resNum) //realizamos la suma de nuevo
                            Toast.makeText(
                                this,
                                "Bienvenido $valueN tu número de la suerte es $resNu",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else { //se obtuvo número de un dígito 1*7 =7
                        Toast.makeText(
                            this,
                            "Bienvenido $valueN tu número de la suerte es $num",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                else if (valueA <= 0){
                    Toast.makeText(this, "Edad no válida", Toast.LENGTH_LONG).show()
                }

                else if (valueA in 10..99) {//entonces si, la edad es de dos digitos
                    val resNum2 = addDig(valueA) //sumamos los digitos
                    if (resNum2 in 1..9) { //verificamos que el valor obtenido sea de un digíto, si es el caso se obtiene el numero de la suerte
                        Toast.makeText(
                            this,
                            "Bienvenido $valueN tu número de la suerte es $resNum2",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        val resNum3 = addDig(resNum2)//volvemos a sumar los digitos, para obtener el número de la suerte
                        Toast.makeText(
                            this,
                            "Bienvenido $valueN tu número de la suerte es $resNum3",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else if (valueA >= 100) {
                    Toast.makeText(this, "Edad no válida", Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}

//funcion que suma los digitos
fun addDig (Age:Int):Int{
    var num = Age
    var addDig=0
    while(num!=0){
        var lastDig=num%10
        num /= 10
        addDig+=lastDig
    }
    return addDig
}
