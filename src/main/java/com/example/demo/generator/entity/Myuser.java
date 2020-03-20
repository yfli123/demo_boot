package com.example.demo.generator.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;
    import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author yfli
* @since 2019-12-30
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @ApiModel(value="Myuser对象", description="")
    public class Myuser implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "userid", type = IdType.UUID)
    private String userid;

            @ApiModelProperty(value = "用户ID")
    private String username;

    private Integer age;


}
