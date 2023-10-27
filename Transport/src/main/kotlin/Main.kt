fun main() {
    val transportFactory = CountryFactory()
    val transportToRussia = transportFactory.createNewTransport("Россия")
    val transportToUSA = transportFactory.createNewTransport("США")
    val transportToBelarus = transportFactory.createNewTransport("Беларусь")
    val transportToGermany = transportFactory.createNewTransport("Германия")

    println("Россия - транспорт: ${transportToRussia.company},\n Максимальная грузоподъемность: ${transportToRussia.maxPayload},\n" +
            " Максимальный габарит груза: ${transportToRussia.maxSize}")
    println("США - транспорт: ${transportToUSA.company},\n Максимальная грузоподъемность: ${transportToUSA.maxPayload},\n " +
            "Максимальный габарит груза: ${transportToUSA.maxSize}")
    println("Беларуси - транспорт: ${transportToBelarus.company},\n Максимальная грузоподъемность: ${transportToBelarus.maxPayload},\n " +
            "Максимальный габарит груза: ${transportToBelarus.maxSize}")
    println("Германии - транспорт: ${transportToGermany.company},\n Максимальная грузоподъемность: ${transportToGermany.maxPayload},\n" +
            " Максимальный габарит груза: ${transportToGermany.maxSize}")
}

abstract class AllTransport {
    abstract val company: String
    abstract val maxPayload: Double
    abstract val maxSize: Double
}
class WaterTransport(private val type: String) : AllTransport() {
    override val company: String
        get() = "Компания по аренде водного транспорта"
    override val maxPayload: Double
        get() = if (type == "Речной") 1000.0 else 5000.0
    override val maxSize: Double
        get() = if (type == "Речной") 10.0 else 30.0
}

class RailwayTransport(private val trackGauge: String, private val ballast: Boolean) : AllTransport() {
    override val company: String
        get() = "Компания по аренде железнодорожного транспорта"
    override val maxPayload: Double
        get() = if (ballast) 8500.0 else 10000.0
    override val maxSize: Double
        get() = 40.0
}

class AirTransport(private val airType: String, private val transportType: String) : AllTransport() {
    override val company: String
        get() = "Компания по аренде авиотранспорта"
    override val maxPayload: Double
        get() = if (transportType == "Грузовой") 5500.0 else 2500.0
    override val maxSize: Double
        get() = 20.0
}

interface FactoryOfTransport {
    fun createNewTransport(country: String): AllTransport
}

class MotorTransport : AllTransport() {
    override val company: String
        get() = "Компания по аренде автотранспорта"
    override val maxPayload: Double
        get() = 6500.0
    override val maxSize: Double
        get() = 25.0
}

class CountryFactory : FactoryOfTransport {
    override fun createNewTransport(country: String): AllTransport {
        return when (country) {
            "Россия" -> RailwayTransport("1720 мм", true)
            "США" -> WaterTransport("Морской")
            "Беларусь" -> MotorTransport()
            "Германия" -> AirTransport("Международные", "Грузовой")
            else -> throw IllegalArgumentException("Неизвестная страна")
        }
    }
}

