package knjname.springkotlinpitfall

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@SpringBootApplication
class SpringkotlinpitfallApplication(
        private val nuke: Nuke
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        nuke.withOptional()
    }
}

@Component
class Nuke {

    private val a = listOf("a")

    // Caused by: java.lang.IllegalArgumentException: Parameter specified as non-null is null:
    // method knjname.springkotlinpitfall.Nuke.withOptional, parameter lst
    fun withOptional(
            lst: List<Any> = a
    ) = Unit

    @Transactional
    fun xxx() = Unit

}


fun main(args: Array<String>) {
    runApplication<SpringkotlinpitfallApplication>(*args)
}
