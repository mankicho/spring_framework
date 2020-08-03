package controller;

import domain.SampleDTO;
import domain.SampleDTOList;
import domain.TodoDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@Log4j
@RequestMapping("/sample/*") // 해당 클래스 모든 메서드들의 기본 URL
public class SampleController {

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) { // localhost/sample/ex01?name=AAA&age=10 -> 파라미터를 알맞게 자동 형변환
        log.info(dto + "");
        return "ex01";
    }

    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
        // 파라미터를 명시해준 자료타입에 맞게 변환, 올바르지 않은 값을 넣을경우 예외
        log.info("name: " + name);
        log.info("age: " + age);
        return "ex02";
    }

    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") List<String> list) { // List 출력
        log.info(list);
        return "ex02List";
    }

    @GetMapping("ex02Array")
    public String ex02Array(@RequestParam("ids") String[] ids) { // Array 출력
        log.info("array ids: " + Arrays.toString(ids));
        return "ex02Array";
    }

    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list) { // 여러개의 SampleDTO 객체를 생성할 수 있다. ㅇ
        log.info(list);
        return "ex02Bean";
    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // 파라미터에 날짜 형식의 값이 들어오면 자동으로 호출되어 변환해준다.
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
//    }

    @GetMapping("/ex03")
    public String ex03(TodoDTO todo) {
        log.info("todo : " + todo);
        return "ex03";
    }

    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, int page, @ModelAttribute("page2") int page2) {
        // @ModelAttribute 는 기본자료형도 화면에 반환함.
        log.info("dto : " + dto);
        log.info("page : " + page);
        log.info("page2 : " + page2);
        return "/sample/ex04";
    }

    @GetMapping("/ex05")
    public void ex05() {
        // 리턴타입이 void 인 경우 일반적으로 해당 URL 의 경로 그대로 jsp 파일의 이름으로 쓴다.
        log.info("/ex05............");
    }

    @GetMapping("/ex06")
    public @ResponseBody
    SampleDTO ex06() { // 자동으로 JSON 타입 리턴 (ResponseBody)
        log.info("/ex06..");
        SampleDTO dto = new SampleDTO();
        dto.setAge(10);
        dto.setName("홍길동");
        return dto;
    }

    @GetMapping("/ex07")
    public ResponseEntity<String> ex07() { // HTTP 헤더를 직접 다룰 수 있음.
        log.info("/ex07...........");

        //{"name": , "홍길동"}
        String msg = "{\"name\": \"홍길동\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=UTF-8");

        return new ResponseEntity<>(msg, headers, HttpStatus.OK);
    }

    @GetMapping("/exUpload")
    public void exUpload() {
        log.info("/exUpload...........");
    }

    @PostMapping("/exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files) {
        // 스프링 MVC 는 전달되는 파라미터가 동일한 이름으로 여러 개 존재하면 배열로 처리가 가능하므로 파라미터를 MultipartFile 의 배열타입으로 작성
        files.forEach(file -> {
            log.info("---------------------");
            log.info("name: " + file.getOriginalFilename());
            log.info("size: " + file.getSize());
        });
    }
}
