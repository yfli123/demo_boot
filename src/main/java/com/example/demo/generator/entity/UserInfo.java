package com.example.demo.generator.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import java.time.LocalDateTime;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;
    import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 用户信息表
    * </p>
*
* @author yfli
* @since 2020-01-01
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @ApiModel(value="UserInfo对象", description="用户信息表")
    public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "用户ID")
            @TableId(value = "user_id", type = IdType.UUID)
    private String userId;

            @ApiModelProperty(value = "用户名称")
    private String userName;

            @ApiModelProperty(value = "证件类型")
    private String certType;

            @ApiModelProperty(value = "证件号码")
    private String certId;

            @ApiModelProperty(value = "电话号码")
    private String phoneNo;

            @ApiModelProperty(value = "电子邮箱")
    private String email;

            @ApiModelProperty(value = "密码")
    private String passWord;

            @ApiModelProperty(value = "创建时间")
    private LocalDateTime inputTime;

            @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
