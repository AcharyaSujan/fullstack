package com.bhd.online.models.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author datao
 * @since 2023-09-12
 */
@Getter
@Setter
@TableName("t_course")
@ApiModel(value = "Course对象", description = "")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("id")
    private Integer id;

    @ApiModelProperty("课程名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("课程介绍")
    @TableField("course_info")
    private String courseInfo;

    @ApiModelProperty("老师姓名")
    @TableField("teacher_name")
    private String teacherName;

    @ApiModelProperty("封面")
    @TableField("face_img")
    private String faceImg;

    @ApiModelProperty("价格")
    @TableField("price")
    private Double price;

    @ApiModelProperty("类别名称")
    @TableField("category_name")
    private String categoryName;

    @ApiModelProperty("所属机构名称")
    @TableField("organization_name")
    private String organizationName;


    @ApiModelProperty("课时")
    @TableField("class_hour")
    private Integer classHour;


}
