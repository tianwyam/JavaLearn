package com.tianya.java.jackson.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppInfoBean {

    private int id ;

    @JsonDeserialize(using = StringJsonDeserializer.class)
    private String appName ;

    @JsonDeserialize(using = StringJsonDeserializer.class)
    private String appAuthor ;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonDeserialize(using = DateJsonDeserializer.class)
    private Date appBirth ;

}
