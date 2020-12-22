package com.cg.addressbookapp.addressbookdto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseDTO {
	public String msg;
	public Object object;
}
