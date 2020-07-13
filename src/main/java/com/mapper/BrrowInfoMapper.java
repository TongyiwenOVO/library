package com.mapper;

import com.entity.BrrowInfo;
import com.entity.BrrowInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrrowInfoMapper {
    long countByExample(BrrowInfoExample example);

    int deleteByExample(BrrowInfoExample example);

    int deleteByPrimaryKey(Integer broId);

    int insert(BrrowInfo record);

    int insertSelective(BrrowInfo record);

    List<BrrowInfo> selectByExample(BrrowInfoExample example);

    List<BrrowInfo> selectByExampleWithAccountAndBook(BrrowInfoExample example);

    List<BrrowInfo> selectByExampleWithAccountAndBookByAccount(String account);

    BrrowInfo selectByPrimaryKey(Integer broId);

    int updateByExampleSelective(@Param("record") BrrowInfo record, @Param("example") BrrowInfoExample example);

    int updateByExample(@Param("record") BrrowInfo record, @Param("example") BrrowInfoExample example);

    int updateByPrimaryKeySelective(BrrowInfo record);

    int updateByPrimaryKey(BrrowInfo record);
}