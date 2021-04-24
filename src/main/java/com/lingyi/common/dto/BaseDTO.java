package com.lingyi.common.dto;

import com.lingyi.common.enums.SystemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDTO {

    private String code = "0";
    private String msg = "成功";

    public BaseDTO(SystemStatus status){
        this.code = status.getCode();
        this.msg = status.getMsg();
    }

}
