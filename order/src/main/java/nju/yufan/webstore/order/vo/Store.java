package nju.yufan.webstore.order.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    private String name;
    private int userid;
    private String sign;
    private String phone;
    private double turnover;
    private String location;
    private Date reg_time;
}
