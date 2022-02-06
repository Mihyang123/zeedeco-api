package shop.zeedeco.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shop.zeedeco.dao.CustomDao;
import shop.zeedeco.exception.BadRequestException;
import shop.zeedeco.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class MemoService {
	
	private final CustomDao dao;
	
    public Map<String, Object> getMemos(Map<String, Object> requestMap) throws Exception {
    	Map<String, Object> responseMap = new HashMap<>();  
    	List<Map<String, Object>> memos = dao.dbDetails("memo.getMemos", requestMap);
    	responseMap.put("memos", memos);
    	if(responseMap == null) new ResourceNotFoundException("�޸� ã�� �� �����ϴ�."); 
        return responseMap;
    }
    
    public void addMemo(Map<String, Object> requestMap) throws Exception {
 		int effectRow = dao.dbInsert("memo.addMemo", requestMap);
 		if( effectRow < 0 ) new BadRequestException("���忡 �����߽��ϴ�.");
    }
    
    public void setMemo(Map<String, Object> requestMap) throws Exception {
 		int effectRow = dao.dbInsert("memo.setMemo", requestMap);
 		if( effectRow < 0 ) new BadRequestException("������ �����߽��ϴ�.");	
    }
 
 	public void physicalRemoveMemo(int memoSeq) throws Exception {
 		Map<String, Object> requestMap = new HashMap<>();
 		requestMap.put("memoSeq", memoSeq);
 		int effectRow = dao.dbInsert("memo.removeMemo", requestMap);
 		if( effectRow < 0 ) new BadRequestException("������ �����߽��ϴ�.");
 	}
}
