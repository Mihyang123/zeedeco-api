package shop.zeedeco.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import lombok.RequiredArgsConstructor;
import shop.zeedeco.dao.CustomDao;
import shop.zeedeco.exception.BadRequestException;
import shop.zeedeco.exception.ResourceNotFoundException;
import shop.zeedeco.util.MemberEnDecoder;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final CustomDao dao;
	private final MemberEnDecoder memberEnDecoder;
	
    public Map<String, Object> getAuth(Map<String, Object> requestMap) throws Exception {
    	Map<String, Object> responseMap = dao.dbDetail("member.getMembers", requestMap);
    	List<Map<String, Object>> details = null;
    	
        if(responseMap != null) {
        	details = dao.dbDetails("member.getMemberDetails", requestMap);
        	this.memberEnDecoder.decodeMember(responseMap);
        	responseMap.put("details", details);
        } else {
        	new ResourceAccessException("�α��ο� �����߽��ϴ�. ");
        }
             
        return responseMap;
    }
    
    public Map<String, Object> getDuplicate(String id) throws Exception {
    	Map<String, Object> requestMap = new HashMap<>();
    	Map<String, Object> resultMap = new HashMap<>();
    	requestMap.put("id", id);
    	Map<String, Object> responseMap = dao.dbDetail("member.getMembers", requestMap);
        if(responseMap != null) {
        	resultMap.put("duplicateCheck", "�ߺ��� �����Դϴ�.");
        } else {
        	resultMap.put("duplicateCheck", "����Ͻ� �� �ִ� �����Դϴ�.");
        }
             
        return resultMap;
    }
    
    public void setPassword(Map<String, Object> requestMap) throws Exception {
    	Map<String, Object> chkMap = new HashMap<>();
    	chkMap.put("memberSeq", requestMap.get("memberSeq"));
    	chkMap.put("password", requestMap.get("password"));
    	
    	Map<String, Object> responseMap = dao.dbDetail("member.getMembers", chkMap);
    	if(responseMap != null) {
    	    int effectRow = dao.dbUpdate("member.setMember", chkMap);
    	    if(effectRow < 0) new BadRequestException("��й�ȣ ������ �����߽��ϴ�.");  		
    	} else {
    		new ResourceNotFoundException("���� ������ ã�� �� �����ϴ�. ");
    	}   
    }
    
}
