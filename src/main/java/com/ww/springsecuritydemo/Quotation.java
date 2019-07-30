package com.ww.springsecuritydemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Wojciech Wasilewski
 * @date Created on 30.07.2019
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quotation {

    private String content;
    private String author;
}
