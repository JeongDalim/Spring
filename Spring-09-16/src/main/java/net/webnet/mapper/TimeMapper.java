package net.webnet.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
 @Select("select sysdate from dual")
public String getTime();
public String getTime2();
 
 @Select("select custname from member_tbl_02 where custno=100010")
 public String getName();
 

}
