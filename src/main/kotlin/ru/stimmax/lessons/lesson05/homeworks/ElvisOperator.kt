package org.example.ru.stimmax.lessons.lesson05.homeworks

class ElvisOperator {
    fun main() {

        // task 1
        // Контекст: Вы изучаете физическое явление затухания звука в помещении.
        // У вас есть измеренное значение начальной интенсивности звука, но из-за ограничений оборудования данные о коэффициенте затухания иногда могут быть неизвестны.
        // Задача: Рассчитать предполагаемую интенсивность звука после затухания. Интенсивность звука после затухания пропорциональна начальной интенсивности, умноженной на коэффициент затухания.
        // Если коэффициент затухания неизвестен, использовать стандартное значение 0.5.

        val baseIntensity: Double = 3.0
        val coefficient: Double? = 0.73 // но может быть null
        val baseCoefficient = 0.5
        val resultIntensity = baseIntensity * (coefficient ?: baseCoefficient)

        // task 2
        // Контекст: Клиент оплачивает доставку груза. К стоимости доставки добавляется страховка на груз, которая составляет 0,5% от его стоимости.
        // В случае, если стоимость не указана, то берётся стандартная стоимость в $50
        // Задача: Рассчитать полную стоимость доставки.
        val defaultCost: Double = 50.0
        val cost: Double? = 20.0 // но может быть null
        val deliveryCost = 5.0
        val insuranceCoefficient = 0.005
        // стоимость страховки
        val insuranceCost = (cost ?: defaultCost) * insuranceCoefficient
        val totalCost: Double = deliveryCost + insuranceCost

        // task 3
        // Контекст: Вы проводите метеорологические измерения. Одним из важных показателей является атмосферное давление, которое должно быть зафиксировано.
        // Лаборант приносит вам набор показателей, но по пути может что-нибудь потерять. Задача - сообщить об ошибке в случае отсутствия показаний атмосферного давления.

        val pressure: String? = "34.6" // но может быть null
        val attentionMessage = "Attention, pressure is lost"
        val pressureForLab = pressure ?: attentionMessage
    }

}