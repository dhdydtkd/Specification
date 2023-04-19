package com.example.specification.map;

import com.example.specification.BaseModel;
import com.example.specification.common.vo.TableSearchVO;
import com.example.specification.map.dto.LatLngReq;
import com.example.specification.map.service.MapService;
import com.example.specification.map.vo.WayDirectionsResult;
import com.example.specification.notice.service.NoticeService;
import com.example.specification.notice.vo.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/map")
public class MapAPIController {

    @Autowired
    private MapService mapService;

    @RequestMapping(method = RequestMethod.POST, path = "/waydirections")
    public BaseModel wayDirections(HttpServletRequest request, HttpServletResponse response
            , @RequestBody LatLngReq latLngReq) {
        BaseModel baseModel = new BaseModel();
        WayDirectionsResult wayDirectionsResult = mapService.wayDirections(latLngReq);
        Map<String, Object> result = new HashMap<String,Object>();
        result.put("wayDirectionsResult",wayDirectionsResult);
        baseModel.setBody(result);
        return baseModel;
    }
}
