package org.example.ru.stimmax.lessons.lesson17.homeworks

class ChildrenClass (
    val privateVal: String,
    protectedVal: String,
    // 10. publicVal доступен в main, потому что val — это свойство, создающее геттер
    publicVal: String
) : BaseClass(privateVal, protectedVal, publicVal) {

    // 4. Чтобы изменить publicField, делаем открытый сеттер-обёртку
    fun changePublicField(value: String) {
        publicField = value
    }

    // 5. Чтобы изменить protectedField, добавляем сеттер
    fun changeProtectedField(value: String) {
        protectedField = value
    }

    // 6. privateField можно изменить через публичную функцию родителя (setPrivateField)

    // 11. getAll() доступна, потому что наследуется из BaseClass
    // 12. Печатает "Печать из класса BaseClass", потому что private методы не переопределяются
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }
}