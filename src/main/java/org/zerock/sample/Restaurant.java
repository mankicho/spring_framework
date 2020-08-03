package org.zerock.sample;

import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class Restaurant {

    @Setter(onMethod_ = {@Autowired}) // onM~ wired == 스프링에서 주입시켜주겠다.
    private Chef chef;

}
