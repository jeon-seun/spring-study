package me.seun.springbasic.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RequestDataController {

    // 1. 주소에 붙어온 데이터 가져오기 (GET)
    // key, value 오는 데이터 name=hello -> Query String
    // '/' 뒤에 그냥 오는 데이터 /search -> Path Variable
    // @GetMapping("/request")
    @ResponseBody
    public String getRequestDataV1(@RequestParam String name) {
        return name;
    }

    @ResponseBody
    // @GetMapping("/request/{name}")
    public String getRequestDataV2(@PathVariable String name) {
        return name;
    }

    // 방법1: 각 input 태그 하나씩 매개변수로 받기
    @ResponseBody
    // @PostMapping("/request")
    public String getRequestDataV3(@RequestParam String name1,
                                   @RequestParam String name2,
                                   @RequestParam String name3) {
        return name1 + " " + name2 + " " + name3;
    }

    // 방법2: 특정 객체 타입으로 받기 @ModelAttribute 는 생략가능
    @ResponseBody
    // @GetMapping("/request")
    public String getRequestDataV4(@ModelAttribute FormData formData) {
        return formData.toString();
    }

    // JSON 이 오는 경우 -> {"name1": "1", "name2": "2", "name3": "3"}
    // @RequestBody 는 생략가능
    @ResponseBody
    @PostMapping("/request")
    public String getRequestDataV5(@RequestBody FormData formData) {
        return formData.toString();
    }
    static class FormData {
        private String name1;
        private String name2;
        private String name3;

        public void setName1(String name1) {
            this.name1 = name1;
        }

        public void setName2(String name2) {
            this.name2 = name2;
        }

        public void setName3(String name3) {
            this.name3 = name3;
        }

        @Override
        public String toString() {
            return name1 + name2 + name3;
        }
    }

}
