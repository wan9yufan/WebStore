package nju.yufan.webstore.order.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private int id;
    private int userid;
    private String region;
    private String address;
    private String receiver;
    private String phone;
    private boolean is_default;
}
