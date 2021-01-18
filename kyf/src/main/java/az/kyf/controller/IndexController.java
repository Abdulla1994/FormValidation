package az.kyf.controller;

import az.kyf.form.RequestForm;
import az.kyf.validator.RequestFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {


    @Autowired
    private RequestFormValidator requestFormValidator;
    @InitBinder

    public  void initFormValidators(WebDataBinder binder){
     binder.setValidator(requestFormValidator);



    }


    @GetMapping("/")
    public  String index() {


        return "index";
    }


    @GetMapping("/register-request")
    public ModelAndView registerRequest(){
        ModelAndView mav=new ModelAndView("register-request");
        RequestForm form=new RequestForm();
        form.setName("Abdulla");
        form.setSurname("Refili");
        mav.addObject("form",form);
        Map<Integer,String> statusMap=new HashMap<>();
        statusMap.put(1,"Sehid");
        statusMap.put(2,"Qazi");
        statusMap.put(3,"Esger");
        mav.addObject("statusMap",statusMap);


        Map<Integer,String> regionMap= new HashMap<>();
        regionMap.put(63,"Zerdab");
        regionMap.put(62,"Zaqatala");
        regionMap.put(61,"Ucar");
        mav.addObject("regionMap", regionMap);
        return mav;
    }

    @PostMapping("/register-request")
    public ModelAndView saveRequest(@ModelAttribute("form") @Validated RequestForm form, BindingResult result) {


        ModelAndView mav = new ModelAndView();
        System.out.println("request form=" + form);
        if (result.hasErrors()){

            System.out.println("formda xetalar var="+result.getAllErrors());
            mav.setViewName("register-request");
        }else{
            System.out.println("xeta yoxdur,muraciet qeyde alindi");
            mav.setViewName("register-request-success");


        }


        return mav;


    }

}
