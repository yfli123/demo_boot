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
    * 菜单信息表
    * </p>
*
* @author yfli
* @since 2020-01-02
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @ApiModel(value="MenuInfo对象", description="菜单信息表")
    public class MenuInfo implements Serializable {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "流水号")
            @TableId(value = "serial_no", type = IdType.UUID)
    private String serialNo;

            @ApiModelProperty(value = "菜单编号")
    private String menuId;

            @ApiModelProperty(value = "菜单名称")
    private String menuName;

            @ApiModelProperty(value = "菜单英文名称")
    private String menuEnName;

            @ApiModelProperty(value = "菜单层级")
    private String menuLevel;

            @ApiModelProperty(value = "菜单路由")
    private String routeUrl;

            @ApiModelProperty(value = "是否叶子节点")
    private String leafNode;


}
