package shop.zeedeco.dto.member;

import java.time.LocalDateTime;
import java.util.Map;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberDetailDto {

	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class ViewMemberDetailRes {
		private Integer detailSeq;
		private Integer memberSeq;
		private String category;
		private String content;
		private String remark;
		private LocalDateTime createdDt;
		private Integer createdNo;
		
		public ViewMemberDetailRes(Map<String, Object> responseMap) {
			this.detailSeq			= (Integer) 		responseMap.get("detailSeq");
			this.memberSeq			= (Integer) 		responseMap.get("memberSeq");
			this.category			= (String) 			responseMap.get("category");
			this.content			= (String) 			responseMap.get("content");
			this.remark				= (String) 			responseMap.get("remark");
			this.createdDt			= (LocalDateTime) 	responseMap.get("createdDt") == null ? null : (LocalDateTime) 	responseMap.get("createdDt");
			this.createdNo			= (Integer) 		responseMap.get("createdNo");
		}
	}
	
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class AddMemberDetailReq {
		@NotNull(message = "����������ȣ ���� �����ϴ�.")
		private Integer memberSeq;
		private Integer detailSeq;
		@NotEmpty(message = "ī�װ��� �����ϴ�.")
		private String category;
		@NotEmpty(message = "������ �����ϴ�.")
		private String content;
		private String remark;
		
        public Map<String, Object> toMap() throws Exception {
            return new ObjectMapper().convertValue(this, Map.class);
        }
	}

	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class RemoveMemberDetailReq {
		@NotNull(message = "�󼼰�����ȣ ���� �����ϴ�.")
		private Integer detailSeq;
		
        public Map<String, Object> toMap() throws Exception {
            return new ObjectMapper().convertValue(this, Map.class);
        }
	}
}
