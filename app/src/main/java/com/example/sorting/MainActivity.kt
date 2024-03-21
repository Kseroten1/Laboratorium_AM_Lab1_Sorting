package com.example.sorting

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun bubbleSort(view: View) {
        val numbersText: EditText = findViewById(R.id.numbers)
        val textView: TextView = findViewById(R.id.textView)

        if (numbersText.text.isNotEmpty()) {
            val values = numbersText.text.split(" ", ", ", ",", " ,")
            val arrayValues: ArrayList<Int> = ArrayList()
            values.forEach {
                arrayValues.add(it.toInt())
            }
            val size = arrayValues.size
            var sorted: Boolean
            do {
                sorted = false
                for (i in 1 until size) {
                    if (arrayValues[i - 1] > arrayValues[i]) {
                        val temporary = arrayValues[i]
                        arrayValues[i] = arrayValues[i - 1]
                        arrayValues[i - 1] = temporary
                        sorted = true
                    }
                }
            } while (sorted)
            val result =
                "Wynik: $arrayValues \nSortowanie bąbelkowe (ang. bubble sort) – prosty algorytm sortowania polegający na porównywaniu za sobą sąsiednich elementów. Złożoności czasowa algorytmu wynosi O(n2). W pierwszym kroku algorytm porównuje pierwszy element ciągu z drugim i zamienia je ze sobą miejscami, jeśli są w nieprawidłowej kolejności. Następnie w analogiczny sposób porównywany jest drugi element z trzecim, trzeci z czwartym itd. Po dojściu w ten sposób do końca ciągu mamy pewność, że największy (lub najmniejszy, jeśli sortujemy malejąco) element znajduje się na końcu ciągu. W kolejnych krokach ponownie porównujemy ze sobą element pierwszy z drugim, drugi z trzecim itd., tym razem kończąc jednak na przedostatnim elemencie. Przeglądanie ciągu powtarzamy wielokrotnie, za każdym razem wykonując o jedno porównanie mniej. Algorytm kończy się, gdy w trakcie ostatniego przeglądania wykonane zostanie tylko jedno porównanie – wówczas wszystkie elementy na pewno są na swoich miejscach."

            textView.text = result
        }
    }

    fun insertionSort(view: View) {
        val numbersText: EditText = findViewById(R.id.numbers)
        val textView: TextView = findViewById(R.id.textView)

        if (numbersText.text.isNotEmpty()) {
            val values = numbersText.text.split(" ", ", ", ",", " ,")
            val arrayValues: ArrayList<Int> = ArrayList()
            values.forEach {
                arrayValues.add(it.toInt())
            }
            val size = arrayValues.size
            print(arrayValues)
            for(i in 1 until size) {
                val key = arrayValues[i]
                var j = i - 1
                while(j >=0 && arrayValues[j] > key){
                    arrayValues[j + 1] = arrayValues[j]
                    j--
                }
                arrayValues[j + 1] = key
            }
            print(arrayValues)
            val result = "Wynik: $arrayValues \nSortowanie przez wstawianie (ang. insertion sort) – prosty algorytm sortowania polegający na wstawianiu kolejnych elementów ciągu we właściwe miejsca. Złożoności czasowa algorytmu wynosi O(n2). Jest to algorytm realizujący metodę przyrostową. Sortowany ciąg dzielony jest na część posortowaną i nieposortowaną. Na początku w części posortowanej znajduje się tylko jeden element (pierwszy). W każdym kolejnym kroku bierzemy pierwszy element z części nieposortowanej i wstawiamy we właściwe miejsce części posortowanej. Aby to zrobić, wstawiany element porównujemy kolejno z ostatnim elementem posortowanej części ciągu, z przedostatnim itd. Algorytm kończy się, gdy wszystkie elementy znajdują się w części posortowanej."
            textView.text = result
        }

    }
}