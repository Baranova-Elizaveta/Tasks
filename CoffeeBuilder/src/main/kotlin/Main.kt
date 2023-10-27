class Coffee( val coffee: Boolean, val double_coffe: Boolean,
              val cream: Boolean, val sugar: Boolean, val milk: Boolean,
              val cinnamon: Boolean, val syrup: Boolean){
    override fun toString(): String{
        //Переопределяем метод toString для удобного вывода информации о нашем кофе
        val components = mutableListOf<String>()
        if (coffee)
            components.add("кофе")
        if (double_coffe)
            components.add("двойной кофе")
        if (cream)
            components.add("сливки")
        if (sugar)
            components.add("сахар")
        if (milk)
            components.add("молоко")
        if (cinnamon)
            components.add("корица")
        if (syrup)
            components.add("сироп")
        return "Список из чего состоит ваш кофе:\n${components.joinToString(",\n")}"
    }
}

//Теперь создаем builder для создания кофе
class CoffeeBuilder{
    private var coffee = false
    private var double_coffee = false
    private var milk = false
    private var cream = false
    private var sugar = false
    private var cinnamon = false
    private var syrup = false
    //метода fun add...(): CoffeeBuilder{
    //              ... = true
    //              return this
    //это методы для добавления компонентов к кофе
    fun addCoffee(): CoffeeBuilder{
        coffee = true
        return this
    }

    fun addDouble_coffee():CoffeeBuilder{
        double_coffee=true
        return this
    }

    fun addMilk():CoffeeBuilder{
        milk=true
        return this
    }

    fun addSugar():CoffeeBuilder{
        sugar=true
        return this
    }

    fun addCream():CoffeeBuilder{
        cream=true
        return this
    }

    fun addCinnamon():CoffeeBuilder{
        cinnamon=true
        return this
    }

    fun addSyrup():CoffeeBuilder{
        syrup=true
        return this
    }
    //теперь нужен метод для построения самого объекта coffee с нужными компонентами
    fun build(): Coffee{
        return Coffee(coffee, double_coffee, milk, cream, sugar, cinnamon, syrup)
    }
}

fun main() {
    val coffee = CoffeeBuilder().addCoffee().addMilk().addDouble_coffee().addSugar().build()
    println(coffee)
}