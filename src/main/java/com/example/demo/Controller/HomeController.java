package com.example.demo.Controller;

import com.example.demo.Model.City.CityModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Controller
public class HomeController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String showForm(Model model) {
        CityModel myCity = new CityModel();
        model.addAttribute("myCity", myCity);
        return "home/index";
    }

    @PostMapping("/")
    public String submitForm(@ModelAttribute("myCity") CityModel myCity) {
        jdbcTemplate.query("SELECT cityId, cityZipCode, cityName FROM city WHERE cityZipCode = ?",
                (rs, rowNum) -> new CityModel(rs.getString("cityZipCode"), rs.getString("cityName")),
                myCity.getCityZipCode()).forEach(city -> {
                    myCity.setCityName(city.getCityName());
                });
        return "data/data";
    }
}
