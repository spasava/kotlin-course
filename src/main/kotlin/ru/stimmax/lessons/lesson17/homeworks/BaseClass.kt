package org.example.ru.stimmax.lessons.lesson17.homeworks

open class BaseClass(privateVal1: String, protectedVal1: String, publicVal1: String) {
    abstract class BaseClass(
        // 1. privateVal доступно в ChildrenClass, но не напрямую, только через конструктор вызова super()
        private val privateVal: String,
        // 2. protectedVal недоступно в main, потому что protected — только для класса и наследников
        protected val protectedVal: String,
        val publicVal: String
    ) {
        var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
                "4. Доработай ChildrenClass таким образом, чтобы это получилось"
            set(value) {
                if (verifyPublicField(value)) {
                    field = value
                }
            }

        protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
        private var privateField = "6. добавь сеттер чтобы изменить меня из main()"

        // Добавляем сеттер, чтобы privateField можно было изменить из main()
        fun setPrivateField(value: String) {
            privateField = value
        }

        fun getAll(): String {
            return mapOf(
                "privateVal" to privateVal,
                "protectedVal" to protectedVal,
                "publicVal" to publicVal,
                "publicField" to publicField,
                "protectedField" to protectedField,
                "privateField" to privateField,
                "generate" to generate(),
            ).map { "${it.key}: ${it.value}" }
                .joinToString("\n")
        }

        fun printText() {
            privatePrint()
        }

        // 7. Эта функция не может быть публичной, чтобы защитить доступ к внутренним классам
        protected open fun getProtectedClass() = ProtectedClass()

        protected open fun verifyPublicField(value: String): Boolean {
            return value.length < 20
        }

        // 8. generate() — виртуальный метод; при переопределении в ChildrenClass возвращает другой текст
        open fun generate(): String {
            return "Это генерация из родительского класса"
        }

        private fun privatePrint() {
            println("Печать из класса BaseClass")
        }

        // 9. getPrivateClass() не может быть публичной или protected, т.к. возвращает private класс
        private fun getPrivateClass() = PrivateClass()

        protected class ProtectedClass
        private class PrivateClass
    }
}