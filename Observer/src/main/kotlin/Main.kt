import java.util.*
import kotlin.concurrent.schedule
import kotlin.concurrent.fixedRateTimer

// Класс WeatherObserver, реализующий наблюдатель
class WeatherObserver {
    private val observers = mutableListOf<WeatherObserverListener>()

    // Добавить подписчика
    fun addObserver(observer: WeatherObserverListener) {
        observers.add(observer)
    }

    // Удалить подписчика
    fun removeObserver(observer: WeatherObserverListener) {
        observers.remove(observer)
    }

    // Имитация периодического обновления погоды
    private fun updateWeather() {
        fixedRateTimer("WeatherUpdate", true, 0L, 5000) {
            val weather = (System.currentTimeMillis() / 1000 % 35).toInt()
            notifyObservers(weather)
        }
    }

    // Уведомить всех подписчиков об изменении погоды
    private fun notifyObservers(weather: Int) {
        for (observer in observers) {
            observer.onWeatherUpdate(weather)
        }
    }

    init {
        updateWeather()
    }
}

// Интерфейс для подписчиков
interface WeatherObserverListener {
    fun onWeatherUpdate(weather: Int)
}

// Экраны приложения
class Screen1 : WeatherObserverListener {
    private val observer = WeatherObserver()

    init {
        observer.addObserver(this)
    }

    override fun onWeatherUpdate(weather: Int) {
        // Обработка обновления погоды на экране 1
        println("Screen 1: Weather updated - $weather")
    }

    fun openScreen() {
        println("Screen 1 opened")
    }

    fun closeScreen() {
        observer.removeObserver(this)
        println("Screen 1 closed")
    }
}

class Screen2 : WeatherObserverListener {
    private val observer = WeatherObserver()

    init {
        observer.addObserver(this)
    }

    override fun onWeatherUpdate(weather: Int) {
        // Обработка обновления погоды на экране 2
        println("Screen 2: Weather updated - $weather")
    }

    fun openScreen() {
        println("Screen 2 opened")
    }

    fun closeScreen() {
        observer.removeObserver(this)
        println("Screen 2 closed")
    }
}

class Screen3 : WeatherObserverListener {
    private val observer = WeatherObserver()

    init {
        observer.addObserver(this)
    }

    override fun onWeatherUpdate(weather: Int) {
        // Обработка обновления погоды на экране 3
        println("Screen 3: Weather updated - $weather")
    }

    fun openScreen() {
        println("Screen 3 opened")
    }

    fun closeScreen() {
        observer.removeObserver(this)
        println("Screen 3 closed")
    }
}

fun main() {
    val screen1 = Screen1()
    val screen2 = Screen2()
    val screen3 = Screen3()

    screen1.openScreen()
    screen2.openScreen()
    screen3.openScreen()

    // Закройте экраны после некоторого времени (симуляция)
    Timer().schedule(15000) {
        screen1.closeScreen()
        screen2.closeScreen()

        // После закрытия экранов screen1 и screen2, приложение может продолжить выполнение других действий
        // Пример: выполнение каких-либо других задач или завершение приложения.
        println("All screens closed. Application can continue executing other tasks.")
    }
}

