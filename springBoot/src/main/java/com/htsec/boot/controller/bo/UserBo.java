package com.htsec.boot.controller.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
//@Data//getting 和 setting 方法，此外还提供了equals、canEqual、hashCode、toString 方法
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class UserBo {
	private Long id;
	private String name;
	private String code;

}
