package shop.zeedeco.dto.auth;

import java.util.Map;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
public class AuthDto {
	
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class ViewAuthReq {
		@NotNull(message = "�ƾƵ� ���� �����ϴ�.")
		private String id;
		@NotEmpty(message = "�н����� ���� �����ϴ�. ")
		private String password;
		
        public Map<String, Object> toMap() throws Exception {
            return new ObjectMapper().convertValue(this, Map.class);
        }
	}
	
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class SetAuthReq {
		@NotNull(message = "����������ȣ ���� �����ϴ�.")
		private Integer memberSeq;
		@NotEmpty(message = "�н����� ���� �����ϴ�. ")
		private String password;
		
        public Map<String, Object> toMap() throws Exception {
            return new ObjectMapper().convertValue(this, Map.class);
        }
	}
	
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class ViewAuthRes {
		private String duplicateCheck;
		
        public Map<String, Object> toMap() throws Exception {
            return new ObjectMapper().convertValue(this, Map.class);
        }
        
        public ViewAuthRes(Map<String, Object> responseMap) {
        	this.duplicateCheck = (String) responseMap.get("duplicateCheck");
        }
	}
}
