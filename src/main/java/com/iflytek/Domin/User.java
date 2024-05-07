package com.iflytek.Domin;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("usermessage")
@Data
public class User {
    private int id;
    private String userName;
    private String password;
    private String phone;
    private int money;
}
