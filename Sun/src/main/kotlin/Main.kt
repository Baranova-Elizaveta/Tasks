object Sun {
    fun sunRise(){
        println("Солнце уже взошло. Улыбнись!")
    }

    fun sunShine(){
        println("Солнце сегодня очень яркое")
    }

    fun sunIntensity(intensity: Int){
        println("Интенсивность солнца: $intensity")
    }

    fun sunColor(color: String){
        println("Сегодня солнце $color цвета")
    }
}

fun main(){
    println("Введите цвет солнца на сегодня:")
    val color = readLine().toString()
    println("Введите интенсивность солнца:")
    val intensity = readLine()!!.toInt()
    Sun.sunRise()
    Sun.sunShine()
    Sun.sunIntensity(intensity)
    Sun.sunColor(color)
}