package lessons.lesson17.homeworks

class GameMachine(
    val color: String,
    val model: String,
    private var isOn: Boolean = false,
    private var isOsLoaded: Boolean = false,
    private val games: MutableList<String> = mutableListOf(),
    var hasJoystick: Boolean = true,
    private var balance: Double = 0.0,
    val owner: String,
    val supportPhone: String,
    private var isSessionPaid: Boolean = false,
    val sessionPrice: Double,
    private val pinCode: String
) {

    fun turnOn() {
        isOn = true
        println("Автомат включен")
    }

    fun turnOff() {
        isOn = false
        isOsLoaded = false
        println("Автомат выключен")
    }

    fun loadOs() {
        if (isOn) {
            isOsLoaded = true
            println("ОС загружена")
        } else {
            println("Невозможно загрузить ОС — автомат выключен")
        }
    }

    fun shutdownOs() {
        if (isOsLoaded) {
            isOsLoaded = false
            println("ОС завершила работу")
        } else {
            println("ОС уже выключена")
        }
    }

    fun showGames() {
        if (games.isEmpty()) println("Игры не установлены")
        else println("Доступные игры: ${games.joinToString()}")
    }

    fun startGame(gameName: String) {
        if (!isSessionPaid) {
            println("Оплатите игровой сеанс перед запуском игры")
            return
        }
        if (games.contains(gameName)) {
            println("Игра '$gameName' запущена!")
            isSessionPaid = false
        } else {
            println("Игра '$gameName' не найдена")
        }
    }

    fun payForSession(amount: Double) {
        if (amount >= sessionPrice) {
            isSessionPaid = true
            balance += sessionPrice
            println("Игровой сеанс оплачен. Сдача: ${amount - sessionPrice}")
        } else {
            println("Недостаточно средств для оплаты сеанса")
        }
    }

    fun withdrawCash(enteredPin: String) {
        if (enteredPin == pinCode) {
            openSafeAndGiveCash()
        } else {
            println("Неверный PIN-код. Доступ запрещён.")
        }
    }

    private fun openSafeAndGiveCash() {
        println("Выдано наличных: $balance")
        balance = 0.0
    }

}