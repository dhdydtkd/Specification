package com.example.specification.dao;

import com.example.specification.common.vo.TableSearchVO;
import com.example.specification.notice.dto.NoticeReq;
import com.example.specification.notice.vo.NoticeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeDAO {

    public List<NoticeVO> getNoticeList(TableSearchVO tableSearchVO);
    public Integer getNoticeListCount(TableSearchVO tableSearchVO);

    public Integer addSchedulerNotice(NoticeReq notice);

    public Integer getAddNoticeIndex();

    public Integer deleteNotice(Integer noticeNo);

}
