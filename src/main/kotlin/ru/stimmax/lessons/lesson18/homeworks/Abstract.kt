package org.example.ru.stimmax.lessons.lesson18.homeworks

import java.io.InputStream
abstract class Abstract {

    // ---------- Интерфейсы ----------
    interface Powerable {
        fun powerOn()
        fun powerOff()
    }

    interface Openable {
        fun open()
        fun close()
    }

    interface WaterContainer {
        val capacity: Int
        fun fillWater(amount: Int)
        fun getWater(amount: Int)
    }

    interface TemperatureRegulatable {
        val maxTemperature: Int
        fun setTemperature(temp: Int)
    }

    interface WaterConnection {
        fun connectToWaterSupply()
        fun getWater(amount: Int)
    }

    interface AutomaticShutdown {
        val sensorType: String
        val maxSensoredValue: Int
        fun startMonitoring()
    }

    interface Drainable {
        fun connectToDrain()
        fun drain()
    }

    interface Timable {
        fun setTimer(time: Int)
    }

    interface BatteryOperated {
        fun getCapacity(): Double
        fun replaceBattery()
    }

    interface Mechanical {
        fun performMechanicalAction()
    }

    interface LightEmitting {
        fun emitLight()
        fun completeLiteEmission()
    }

    interface SoundEmitting {
        fun setVolume(volume: Int)
        fun mute()
        fun playSound(stream: InputStream)
    }

    interface Programmable {
        fun programAction(action: String)
        fun execute()
    }

    interface Movable {
        fun move(direction: String, distance: Int)
    }

    interface Cleanable {
        fun clean()
    }

    interface Rechargeable {
        fun getChargeLevel(): Double
        fun recharge()
    }

    // ---------- Абстрактные классы ----------
    abstract class AbstractPowerableDevice : Powerable {
        protected var isPoweredOn = false

        override fun powerOn() {
            if (!isPoweredOn) {
                isPoweredOn = true
                println("${this::class.simpleName}: питание включено")
            } else {
                println("${this::class.simpleName}: уже включено")
            }
        }

        override fun powerOff() {
            if (isPoweredOn) {
                isPoweredOn = false
                println("${this::class.simpleName}: питание выключено")
            } else {
                println("${this::class.simpleName}: уже выключено")
            }
        }
    }

    abstract class AbstractProgrammableDevice : AbstractPowerableDevice(), Programmable {
        private var currentProgram: String? = null

        override fun programAction(action: String) {
            if (isPoweredOn) {
                currentProgram = action
                println("${this::class.simpleName}: задана программа '$action'")
            } else {
                println("${this::class.simpleName}: невозможно задать программу — питание выключено")
            }
        }

        override fun execute() {
            if (isPoweredOn && currentProgram != null) {
                println("${this::class.simpleName}: выполняется программа '$currentProgram'")
            } else if (!isPoweredOn) {
                println("${this::class.simpleName}: невозможно выполнить программу — питание выключено")
            } else {
                println("${this::class.simpleName}: программа не задана")
            }
        }
    }

    abstract class AbstractTemperatureOpenableDevice :
        AbstractProgrammableDevice(), TemperatureRegulatable, Openable {

        protected var currentTemperature: Int = 0
        protected var isOpen: Boolean = false

        override fun open() {
            isOpen = true
            println("${this::class.simpleName}: устройство открыто")
        }

        override fun close() {
            isOpen = false
            println("${this::class.simpleName}: устройство закрыто")
        }

        override fun setTemperature(temp: Int) {
            if (isPoweredOn) {
                if (temp <= maxTemperature) {
                    currentTemperature = temp
                    println("${this::class.simpleName}: температура установлена на $temp°C")
                } else {
                    println("${this::class.simpleName}: превышена максимальная температура ($maxTemperature°C)")
                }
            } else {
                println("${this::class.simpleName}: невозможно установить температуру — питание выключено")
            }
        }
    }

    // ---------- Конкретные устройства ----------
    class Refrigerator(override val maxTemperature: Int = 10) :
        AbstractTemperatureOpenableDevice(), WaterContainer, Cleanable {

        override val capacity: Int = 200

        override fun fillWater(amount: Int) {
            println("Refrigerator: заполнен отсек водой — $amount л")
        }

        override fun getWater(amount: Int) {
            println("Refrigerator: выдано $amount л воды")
        }

        override fun clean() {
            println("Refrigerator: выполнена очистка")
        }
    }

    class WashingMachine(override val maxTemperature: Int = 90) :
        AbstractTemperatureOpenableDevice(), WaterConnection, Drainable, Cleanable {

        override fun connectToWaterSupply() {
            println("WashingMachine: подключено к водоснабжению")
        }

        override fun getWater(amount: Int) {
            println("WashingMachine: получено $amount л воды")
        }

        override fun connectToDrain() {
            println("WashingMachine: подключено к сливу")
        }

        override fun drain() {
            println("WashingMachine: выполнен слив воды")
        }

        override fun clean() {
            println("WashingMachine: выполнена чистка барабана")
        }
    }

    class Kettle(override val maxTemperature: Int = 100) :
        AbstractTemperatureOpenableDevice(), WaterContainer {

        override val capacity: Int = 2

        override fun fillWater(amount: Int) {
            println("Kettle: налито $amount л воды")
        }

        override fun getWater(amount: Int) {
            println("Kettle: выдано $amount л воды")
        }
    }

    class Oven(override val maxTemperature: Int = 250) :
        AbstractTemperatureOpenableDevice(), Cleanable {

        override fun clean() {
            println("Oven: проведена автоматическая очистка камеры")
        }
    }

    // ---------- Демонстрация ----------
    fun main() {
        val fridge = Refrigerator()
        val washer = WashingMachine()
        val kettle = Kettle()
        val oven = Oven()

        println("=== Холодильник ===")
        fridge.powerOn()
        fridge.setTemperature(5)
        fridge.programAction("Охлаждение напитков")
        fridge.execute()
        fridge.clean()
        fridge.open()
        fridge.close()
        fridge.powerOff()

        println("\n=== Стиральная машина ===")
        washer.powerOn()
        washer.connectToWaterSupply()
        washer.programAction("Быстрая стирка")
        washer.setTemperature(40)
        washer.execute()
        washer.drain()
        washer.powerOff()

        println("\n=== Чайник ===")
        kettle.powerOn()
        kettle.fillWater(1)
        kettle.setTemperature(100)
        kettle.programAction("Кипячение воды")
        kettle.execute()
        kettle.powerOff()

        println("\n=== Духовка ===")
        oven.powerOn()
        oven.setTemperature(180)
        oven.programAction("Выпечка")
        oven.execute()
        oven.clean()
        oven.powerOff()
    }
}