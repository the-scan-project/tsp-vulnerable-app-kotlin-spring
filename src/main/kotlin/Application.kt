package me.samoylenko.examples.vulnerable

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class Application

@RestController
class HelloController {
    @GetMapping(value = ["/hello"], produces = [MediaType.TEXT_PLAIN_VALUE])
    fun hello(@RequestParam name: String): String {
        return "Hello, $name"
    }
}

@Controller
class ViewController {
    @GetMapping("/view")
    fun getView(@RequestParam name: String, model: Model): String {
        model.addAttribute("name", name)
        return "hello"
    }
}

fun main() {
    runApplication<Application>()
}
