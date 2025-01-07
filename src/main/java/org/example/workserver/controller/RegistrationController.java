package org.example.workserver.controller;

import org.example.workserver.entity.Bid;
import org.example.workserver.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/reg")
public class RegistrationController {


    private RegistrationRepository registrationRepository;

    public RegistrationController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @GetMapping
    public String reg(Model model) {
        return "index";
    }

    @PostMapping
    public String register(
            @RequestParam String name,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime,
            @RequestParam String telegram,
            @RequestParam(required = false) String phone,
            Model model) {

        Bid existingBid = registrationRepository.findByPhone(phone);  // Получаем существующую запись
        // Проверка на уникальность номера телефона
        if (phone != null && existingBid != null) {
            model.addAttribute("error", "Пользователь с таким номером телефона уже зарегистрирован!");
            return "index"; // Возвращаем пользователя на страницу регистрации с сообщением об ошибке
        }

        // Создаем объект регистрации
        Bid registration = new Bid();
        registration.setName(name);
        registration.setDateTime(dateTime);
        registration.setTelegram(telegram);
        registration.setPhone(phone);

        registrationRepository.save(registration);


        model.addAttribute("name", name);
        model.addAttribute("message", "Регистрация успешна!");
        return "success";
    }
}
